<?php

include 'grow_settings.php';

date_default_timezone_set("Europe/Kiev");

# pin_number => [on time, off time]

	$veg_timings = array(
		WARM_LED => array(12, 15),
		COLD_LED => array(15, 18),
		FITO_LED => array(4, 22),
		FAN => array(4, 22)
	);
	$flower_timings =  array(
		WARM_LED => array(21, 9),
		COLD_LED => array(21, 9),
		FITO_LED => array(21, 9),
		FAN => array(21, 9)
	);

    $timings = $veg_timings;

	if (CYCLE == FLOWERING) {
		$timings = $flower_timings;
	}
	
?>
