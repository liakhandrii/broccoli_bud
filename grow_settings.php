<?php

	define("FLOWERING", 420);
	define("VEGETATION", 1620);

	define("CYCLE", VEGETATION);
	// define("CYCLE", FLOWERING);

	define("WARM_LED", 27);
	define("COLD_LED", 24);
	define("FITO_LED", 25);
	define("FAN", 28);
	define("PUMP", 29);

	define("MAX_TEMP", 32);
	define("MIN_TEMP", 22);

	# twice a day
	define("WATERINGS_PER_DAY", 8);
	define("PUMP_TIMEOUT", ceil(60 * 60 * 24 / WATERINGS_PER_DAY));

	# volume in mililiters
	define("WATER_AMOUNT", 150);
	define("PUMPING_TIME", ceil(WATER_AMOUNT / 14));

	define("MODE_AUTO", 228);
	define("MODE_MANUAL", 322);

	define("MODE", MODE_AUTO);

?>
