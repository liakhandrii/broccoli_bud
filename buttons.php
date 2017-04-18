<?PHP
require_once("./include/membersite_config.php");

?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">
<html>
  <head>
<html>
<head>
<title>RasPiViv.com - Buttons</title>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>

<body>
<body>
<div class="jumbotron">
<div class="container">
<?php include 'menu.php';?>
</div>
</div>
<div class="container">
     <!-- On/Off button's picture -->
	 <?php
	 //this php script generate the first page in function of the gpio's status
	$pins = array(24, 27, 25, 28); 
	$status = array(0, 0, 0, 0);

	 foreach ($pins as $i) {
		//set the pin's mode to output and read them
		system("gpio mode ".$i." out");
		exec ("gpio read ".$i, $status[$i], $return );
		//if off
		if ($status[$i][0] == 1 ) {
		echo ("<img id='button_".$i."' src='data/img/red/red_".$i.".png' alt='off'/><br>");
		}
		//if on
		if ($status[$i][0] == 0 ) {
		echo ("<img id='button_".$i."' src='data/img/green/green_".$i.".png' alt='on'/><br>");
		}	 
	 }
	 ?>
	 </div>
	 <!-- javascript -->
	 <script src="script.js"></script>
<div class="container">
	 <hr><?php include 'footer.php';?>
</div>
</body>
</html>
