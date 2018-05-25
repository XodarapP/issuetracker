<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Sign up</title>
	<link rel="shortcut icon" href="images/gt_favicon.png">
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">

	<link rel="stylesheet" href="css/bootstrap-theme.css" media="screen" >
	<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top headroom" >
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right">
					<li></li>
					<li class="dropdown">
					</li>
					<li class="active"><a class="btn" href="/register">SIGN IN / SIGN UP</a></li>
				</ul>
			</div>
		</div>
	</div>
	<header id="head">
		<div class="container">
			<div class="row">
				<h1 class="lead"><a href="/issues">ISSUE TRACKER</a></h1>
				<p>
					<a class="btn btn-default btn-lg" role="button" href="/register">REGISTER</a>
					<a class="btn btn-action btn-lg" role="button" href="/signin">SIGN IN</a>
				</p>
			</div>
			<#if info??>
                <strong>${info}</strong>
			</#if>
			<#if user??>
				<strong>${user.username}</strong>
			</#if>
		</div>
	</header>
</body>
</html>
