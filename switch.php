<?php
	
	require 'timings.php';

	foreach ($timings as $pin => $timing) {
		system ( "gpio mode ".$pin." out" );

		$on_time = $timing[0];
		$off_time = $timing[1];

		$current_hour = intval(date("H"));

		if ($on_time < $off_time) {
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

?>
