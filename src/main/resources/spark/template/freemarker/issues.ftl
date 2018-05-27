<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Issues</title>
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
                <li class="active"><a class="btn" href="/logout">SIGN OUT</a></li>
            </ul>
        </div>
    </div>
</div>

<header id="head" class="secondary"></header>

<div class="container">

    <ol class="breadcrumb">
        <li><a href="/">Home</a></li>
        <li class="active">Issues list</li>
    </ol>

    <div class="row">

        <article class="col-xs-12 maincontent">
            <header class="page-header">
                <h1 class="page-title">Issues List</h1>
            </header>

            <table class="table table-bordered">
                <thead>
                <tr>
                    <th width="120">Issue</th>
                    <th width="120">Status</th>
                    <th width="120">Created date</th>
                    <th width="120">Details</th>
                </tr>
                </thead>
                <tbody>
				<#list issues as issue>
                <tr align="center">
                    <td>${issue.issueName}</td>
                    <td>${issue.status}</td>
                    <td>${issue.dateCreated}</td>
                    <td><a href="/issue/${issue.id}">View</a></td>
                </tr>
				</#list>
                </tbody>
            </table>
            <hr>
        </article>
    </div>
    <a class="btn btn-action btn-lg" role="button" href="/createIssue">Create issue</a>
</div>
<hr>
</body>
</html>
