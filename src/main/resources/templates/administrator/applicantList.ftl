<html lang="en">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
<#import "../pager.ftl" as p>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link active" href="/">Home</a>
            </li>
        </ul>
    </nav>
</head>
<body>



<table class="table col-8 offset-sm-2 mt-5">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">First</th>
        <th scope="col">Last</th>
        <th scope="col">email</th>
        <th scope="col">password</th>
        <th scope="col">#</th>
    </tr>
    </thead>
    <tbody>
    <#if page.content??>
    <#list page.content as applicant>
    <tr>
        <th scope="row">${applicant.id}</th>
        <th scope="row">${applicant.firstName}</th>
        <th scope="row">${applicant.lastName}</th>
        <th scope="row">${applicant.email}</th>
        <th scope="row">${applicant.password}</th>
        <th scope="row">
            <form action="/administrator/applicant/${applicant.id}" method="get">
                <button type="submit" class="btn btn-primary">Open</button>
            </form>
        </th>

    </tr>
    </#list>
</#if>
    </tbody>
</table>

<div class="fixed-bottom">
    <@p.pager url page />
</div>



</body>
</html>