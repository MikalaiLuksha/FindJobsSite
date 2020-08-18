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
<#if checkReg=="null">
<a href="/user/reg">Registration |</a>
<a href="/user/auth">Authorisation |</a>
<#elseif checkRegA??>
        <a href="/user/auth">Appl</a>
        <a href="/user/logout">logout</a>
<#elseif checkRegE??>
    <a href="/user/auth">  Emp</a>
    <a href="/user/logout">logout</a>
</#if>

<#if message??>
    <h2>${message}</h2>
</#if>

</body>
</html>