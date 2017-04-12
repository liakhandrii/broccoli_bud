<?php

include 'pins.php';

date_default_timezone_set("Europe/Kiev");

# pin_number => [on time, off time]
     $timings = array(
     	WARM_LED => array(12, 15),
     	COLD_LED => array(15, 18),
     	FITO_LED => array(4, 22),
     	FAN => array(4, 22)
     );
?>

