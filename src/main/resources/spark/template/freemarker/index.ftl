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
            <a class="navbar-brand" href="/"><img src="images/logo.png"></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav pull-right">
                <li></li>
                <li class="dropdown">
                </li>
			<#if register??>
                <li class="active"><a class="btn" href="/register">REGISTER</a></li>
			<#else>
                <li><a href="#">You sign in as: <b>${user}</b></a></li>
                <li class="active"><a class="btn" href="/logout">LOG OUT</a></li>
			</#if>
            </ul>
        </div>
    </div>
</div>
<header id="head">
    <div class="container">
        <div class="row">
            <h1 class="lead"><a href="/issues" style="text-decoration: none">ISSUE TRACKER</a></h1>
		<#if register??>
            <p>
                <a class="btn btn-default btn-lg" role="button" href="/register">REGISTER</a>
                <a class="btn btn-action btn-lg" role="button" href="/signin">SIGN IN</a>
            </p>
		</#if>
        </div>
	<#if info??>
        <strong>${info}</strong>
	</#if>
    </div>
</header>
</body>
</html>
