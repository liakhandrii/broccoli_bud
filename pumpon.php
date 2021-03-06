<?php 

include 'grow_settings.php';

date_default_timezone_set("Europe/Kiev");

function water_plant() {
	exec('/usr/local/bin/gpio mode '.PUMP.' out');
	exec('/usr/local/bin/gpio write '.PUMP.' 0');

	sleep(PUMPING_TIME);

	exec('/usr/local/bin/gpio write '.PUMP.' 1');
}

function get_timestamp() {
	$date = new DateTime();
	return $date->getTimestamp();
}

$file = 'last_watering.txt';
$last_watering = intval(file_get_contents($file));

$now = get_timestamp();

if ($now >= ($last_watering + PUMP_TIMEOUT)) {
	water_plant();
	file_put_contents($file, $now);
}

?> 

