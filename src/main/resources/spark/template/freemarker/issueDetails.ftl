<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Issue details</title>
    <link rel="shortcut icon" href="../images/gt_favicon.png">
    <link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/font-awesome.min.css">

    <link rel="stylesheet" href="../css/bootstrap-theme.css" media="screen" >
    <link rel="stylesheet" href="../css/main.css">
<body>
<div class="navbar navbar-inverse navbar-fixed-top headroom" >
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/"><img src="../images/logo.png"></a>
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
        <li class="active">${issues.id}</li>
        <li class="active">Issue Details</li>
    </ol>

    <div class="row">

        <article class="col-xs-12 maincontent">
            <header class="page-header">
                <h1 class="page-title">Issue Details</h1>
            </header>

        <#if issues??>
            <h2> ${issues.issueName} </h2>
            <table>
                <tr>
                    <th align="left">Status:</th>
                    <td width="150">${issues.status}</td>
                </tr>
                <tr>
                    <th align="left">Start date:</th>
                    <td width="150">${issues.dateCreated}</td>
                </tr>
                <tr>
                    <th align="left">Author:</th>
                    <td width="150">${issues.author}</td>
                </tr>
            </table>
            <table>
                <tr>
                    <th align="left">Description:</th>
                </tr>
                <tr>
                    <td width="500">${issues.issueDescription}</td>
                </tr>
            </table>
            <hr>
        </#if>
            <br>
            <b>History:</b>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th width="120">Comment</th>
                    <th width="120">Comment author</th>
                    <th width="120">Comment date</th>
                    <th width="120">Update status</th>
                </tr>
                </thead>
                <tbody>
                <#list issueResolvers as issueResolver>
                <tr align="center">
                    <td align="left">${issueResolver.comment}</td>
                    <td>${issueResolver.commentAuthor}</td>
                    <td>${issueResolver.commentDate}</td>
                    <td>${issueResolver.updateStatus}</td>
                </tr>
                </#list>
                </tbody>
            </table>
            <br><br>
            <hr>
        <#if issues.status != "Closed">
            <h3>Create new solution</h3>
            <form action="/issue/${issues.id}" method="POST">
                <h4>Status:</h4>
                <select class="selectpicker dropup" id="issue_status" name="issue_status">
                    <option>In process</option>
                    <option>Resolved</option>
                    <option>Closed</option>
                </select>
                <br>
                <h4>Author:</h4>
                <#if user??>
                ${user}
                </#if>
                <br>
                <h4>Text:</h4>
                <textarea name="issue_description" id="issue_description"cols="50" rows="15" required></textarea>
                <br><br>
                <button type="btn btn-action" class="btn btn-warning" href="/issue/${issues.id}" formmethod="post">Create</button>
            </form>
        </#if>
            <hr>
        </article>
    </div>
</div>
</body>
</html>