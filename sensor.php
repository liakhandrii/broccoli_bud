<?php

error_reporting(E_ALL);
ini_set('display_errors', '1');
include "PhpSerial.php";

function readSensor($sensor)
{
	$output = array();
	$return_var = 0;
	$i=0;
	exec('python /home/pi/dht11.py '.$sensor, $output, $return_var);
  	while (substr($output[$i],0,1) != "H")
	{
        $i++;
	}
	$humid=substr($output[$i],11,5);
        $temp=substr($output[$i],33,5);
        	$db = mysql_connect("localhost","datalogger","datalogger") or die("DB Connect error");
	mysql_select_db("datalogger");
	$q = "INSERT INTO datalogger VALUES (now(), $sensor, '$temp', '$humid',0)";
	mysql_query($q);
	mysql_close($db);
	return;
}

function readSerial() {

	$output = array();
	$return_var = 0;
	exec('python /home/pi/temp_light.py ', $output, $return_var);

	$reading = implode("",$output);
	$lux_end = strpos($reading, " Lux.");
	$temp_start = $lux_end + 5;
	$temp_end = strpos($reading, " Celsius.");

	$lux = substr($reading, 0, $lux_end);
    $temp = substr($reading, $temp_start, $temp_end - $temp_start);

    if ($lux != '' && $temp != '') {
    	$db = mysql_connect("localhost","datalogger","datalogger") or die("DB Connect error");
		mysql_select_db("datalogger");
		$q = "INSERT INTO light_and_roomtemp VALUES ('$lux', '$temp', now())";
		mysql_query($q);
		mysql_close($db);
    }

	return;
}

readSensor(4);
readSerial();
?>
