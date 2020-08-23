<#import "/spring.ftl" as spring/>
<html lang="en">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
    <ul class="nav">
        <#if !checkReg??>
        <li class="nav-item">
            <a class="nav-link" href="/user/reg">Registration</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/user/auth">Authorisation</a>
        </li>
        <#elseif checkRegA??>
        <li class="nav-item">
            <a class="nav-link" href="/user/applicant/account">Personal Information</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/user/applicant/addResume">Create resume</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">You resume</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Response</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/user/logout">Logout</a>
        </li>
        <#elseif checkRegE??>
            <a href="/user/employer/account">Personal Account</a>
            <a href="/user/logout">logout</a>
        </#if>
    </ul>
</nav>
<#if message??>
    <h2>${message}</h2>
</#if>

<style>
    body {
        background: url("https://krot.info/uploads/posts/2020-01/1579349378_6-14.jpg")
    }
</style>

</body>
</html>