<?php

include 'grow_settings.php';

date_default_timezone_set("Europe/Kiev");

# pin_number => [on time, off time]

	define("SYSTEM_ON_TIME", 5);
	define("SYSTEM_OFF_TIME", 22);

	$veg_timings = array(
		WARM_LED => array(5, 6),
		COLD_LED => array(6, 22),
		FITO_LED => array(5, 22),
		FAN => array(5, 22)
	);
	$flower_timings =  array(
		WARM_LED => array(9, 21),
		COLD_LED => array(9, 10),
		FITO_LED => array(9, 21),
		FAN => array(9, 21)
	);

    $timings = $veg_timings;

	if (CYCLE == FLOWERING) {
		$timings = $flower_timings;
	}

?>
