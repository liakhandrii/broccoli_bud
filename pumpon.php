<?php 
exec('/usr/local/bin/gpio mode 29 out'); 
exec('/usr/local/bin/gpio write 29 0');

sleep(35);

exec('/usr/local/bin/gpio write 29 1');  
?> 

