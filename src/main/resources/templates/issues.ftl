<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Issues</title>
    </head>
    <body>
        <h1>Issues list</h1>
            <table class="tg">
                <tr>
                    <th width="120">Issue</th>
                    <th width="120">Status</th>
                    <th width="120">Created date</th>
                    <th width="120">Details</th>
                </tr>
                <#list issues as issue>
                    <tr align="center">
                        <td align="left">${issue.issueName}</td>
                        <td>${issue.status}</td>
                        <td>${issue.dateCreated}</td>
                        <td><a href="/issue/${issue.id}">View</a></td>
                    </tr>
                </#list>
            </table>
        <br>
    </body>
</html>