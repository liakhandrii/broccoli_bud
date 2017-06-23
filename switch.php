<?php

	require_once 'timings.php';
	require_once 'grow_settings.php';

	if (MODE == MODE_AUTO) {

		$current_hour = intval(date("H"));

		foreach ($timings as $pin => $timing) {
				system ( "gpio mode ".$pin." out" );

				$on_time = $timing[0];
				$off_time = $timing[1];

				if ($on_time == -1 || $off_time == -1) {
					system ( "gpio write ".$pin." 1" );
				} elseif ($on_time < $off_time) {
					if ($current_hour >= $on_time && $current_hour < $off_time) {
						system ( "gpio write ".$pin." 0" );
					} else {
						system ( "gpio write ".$pin." 1" );
					}
				} else {
					if ($current_hour >= $on_time || $current_hour < $off_time) {
						system ( "gpio write ".$pin." 0" );
					} else {
						system ( "gpio write ".$pin." 1" );
					}
				}

			}

			$grow_temp = getGrowTemp();
			echo($grow_temp);

			// if (SYSTEM_ON_TIME == -1 || SYSTEM_OFF_TIME == -1) {
			//
			// } elseif (SYSTEM_ON_TIME < $off_time) {
			// 	if ($current_hour >= SYSTEM_ON_TIME && $current_hour < SYSTEM_OFF_TIME) {
			// 		if ($grow_temp > MAX_TEMP) {
			// 				system ( "gpio write ".WARM_LED." 1" );
			// 				system ( "gpio write ".COLD_LED." 1" );
			// 				system ( "gpio write ".FITO_LED." 0" );
			// 		} else if ($grow_temp < MIN_TEMP) {
			// 			system ( "gpio write ".WARM_LED." 0" );
			// 			system ( "gpio write ".COLD_LED." 0" );
			// 			system ( "gpio write ".FITO_LED." 0" );
			// 			system ( "gpio write ".FAN." 1" );
			// 		}
			// 	}
			// } else {
			// 	if ($current_hour >= SYSTEM_ON_TIME || $current_hour < SYSTEM_OFF_TIME) {
			// 		if ($grow_temp > MAX_TEMP) {
			// 				system ( "gpio write ".WARM_LED." 1" );
			// 				system ( "gpio write ".COLD_LED." 1" );
			// 				system ( "gpio write ".FITO_LED." 0" );
			// 		} else if ($grow_temp < MIN_TEMP) {
			// 			system ( "gpio write ".WARM_LED." 0" );
			// 			system ( "gpio write ".COLD_LED." 0" );
			// 			system ( "gpio write ".FITO_LED." 0" );
			// 			system ( "gpio write ".FAN." 1" );
			// 		}
			// 	}
			// }
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

		$sql = "SELECT roomtemp FROM light_and_roomtemp ORDER BY time DESC LIMIT 1";
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

?>
