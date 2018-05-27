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
                <li><a href="#">You sign in as: <b>${user}</b></a></li>
                <li class="dropdown">
                </li>
                <li class="active"><a class="btn" href="/logout">SIGN OUT</a></li>
            </ul>
        </div>
    </div>
</div>
<header id="head" class="secondary"></header>
<div class="container">
    <ol class="breadcrumb">
        <li><a href="/">Home</a></li>
        <li><a href="/issues">Issues</a></li>
        <li class="active">Create issue</li>
    </ol>
    <div class="row">
        <article class="col-xs-12 maincontent">
            <header class="page-header">
                <h1 class="page-title">Create issue</h1>
            </header>
            <form action="/createIssue" method="POST">
                Name: <input class="form-control" id="issue_name" name="issue_name" type="text" size="42" required/><br>
                Author: ${user}<hr>
                Description: <br>
                <textarea name="description" id="description"cols="50" rows="15" required></textarea>
                <hr>
                <button type="btn btn-action" class="btn btn-warning" href="/createIssue" formmethod="post">Create issue</button>
            </form>
        </article>
    </div>
</div>
<hr>
</body>
</html>
