<#ftl output_format="HTML" auto_esc=true>
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
                <li class="dropdown">
                </li>
                <li class="active"><a class="btn" href="/signin">SIGN IN</a></li>
            </ul>
        </div>
    </div>
</div>

<header id="head" class="secondary"></header>

<div class="container">

    <ol class="breadcrumb">
        <li><a href="/">Home</a></li>
        <li class="active">Registration</li>
    </ol>

    <div class="row">

        <article class="col-xs-12 maincontent">
            <header class="page-header">
                <h1 class="page-title">Registration</h1>
            </header>

            <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3 class="thin text-center">Register a new account</h3>
                        <p class="text-center text-muted"> Or: <a href="/signin">Sign In</a> </p>
                        <hr>

                        <form>
                            <div class="top-margin">
                                <label>Username</label>
                                <input type="text" class="form-control" id="username" name = "username">
                            </div>
                            <div class="row top-margin">
                                <div class="col-sm-6">
                                    <label>Password <span class="text-danger">*</span></label>
                                    <input type="password" class="form-control" id="password" name = "password">
                                </div>
                                <div class="col-sm-6">
                                    <label>Confirm Password <span class="text-danger">*</span></label>
                                    <input type="password" class="form-control" id="confirm_password" name = "confirm_password">
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-lg-4 text-right" href="/register">
                                    <button class="btn btn-action" type="submit" href="/register" formmethod="post">Register</button>
                                </div>
                            </div>
                        </form>
                        <hr>
					<#if error??>
                        <div class="alert alert-danger">
                            <strong>Error:</strong> ${error}
                        </div>
					</#if>
                    </div>
                </div>
            </div>
        </article>
    </div>
</div>
</body>
</html>
