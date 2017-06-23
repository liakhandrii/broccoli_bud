<?php

	require 'timings.php';
	require 'grow_settings.php';
	require 'sensor.php';

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

			if (SYSTEM_ON_TIME == -1 || SYSTEM_OFF_TIME == -1) {

			} elseif (SYSTEM_ON_TIME < $off_time) {
				if ($current_hour >= SYSTEM_ON_TIME && $current_hour < SYSTEM_OFF_TIME) {
					if $grow_temp > MAX_TEMP {
							system ( "gpio write ".WARM_LED." 1" );
							system ( "gpio write ".COLD_LED." 1" );
							system ( "gpio write ".FITO_LED." 0" );
					} else if $grow_temp < MIN_TEMP {
						system ( "gpio write ".WARM_LED." 0" );
						system ( "gpio write ".COLD_LED." 0" );
						system ( "gpio write ".FITO_LED." 0" );
						system ( "gpio write ".FAN." 1" );
					}
				}
			} else {
				if ($current_hour >= SYSTEM_ON_TIME || $current_hour < SYSTEM_OFF_TIME) {
					if $grow_temp > MAX_TEMP {
							system ( "gpio write ".WARM_LED." 1" );
							system ( "gpio write ".COLD_LED." 1" );
							system ( "gpio write ".FITO_LED." 0" );
					} else if $grow_temp < MIN_TEMP {
						system ( "gpio write ".WARM_LED." 0" );
						system ( "gpio write ".COLD_LED." 0" );
						system ( "gpio write ".FITO_LED." 0" );
						system ( "gpio write ".FAN." 1" );
					}
				}
			}
	}

?>
