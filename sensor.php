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

function getGrowTemp() {
	$servername = "localhost";
	$username = "datalogger";
	$password = "datalogger";
	$dbname = "datalogger";

	// Create connection
	$conn = mysqli_connect($servername, $username, $password, $dbname);
	// Check connection
	if (!$conn) {
			die("Connection failed: " . mysqli_connect_error());
	}

	$sql = "SELECT roomtemp FROM light_and_roomtemp LIMIT 1";
	$result = mysqli_query($conn, $sql);

	if (mysqli_num_rows($result) > 0) {
			// output data of each row
			while($row = mysqli_fetch_assoc($result)) {
					$grow_temp = $row["roomtemp"];
					mysqli_close($conn);
					return $grow_temp;
			}
	} else {
			mysqli_close($conn);
			return -1;
	}
}


readSensor(4);
readSerial();
?>
