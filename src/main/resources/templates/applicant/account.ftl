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
    <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link active" href="/">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Update information</a>
        </li>
        </ul>
    </nav>
</head>
<body>

<dl class="row">
    <dt class="col-sm-2 offset-sm-1"> First Name</dt>
    <dd class="col-sm-8">${currentApplicant.firstName}</dd>
    <dt class="col-sm-2 offset-sm-1"> Last Name</dt>
    <dd class="col-sm-8">${currentApplicant.lastName}</dd>
</dl>

<style>
    body {
        background: url("https://krot.info/uploads/posts/2020-01/1579349378_6-14.jpg")
    }
</style>

</body>
</html>