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


    <div class="card mb-10 offset-sm-1 mt-4" style="max-width: 540px; background-color: #e6e4f3">
        <div class="row no-gutters">
            <div class="col-md-4">
                <img src="https://c7.hotpng.com/preview/895/85/169/computer-icons-businessperson-clip-art-business-woman.jpg" class="card-img" alt="...">
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h5 class="card-title offset-sm-1">Profile</h5>
                        <dl class="row">
                        <dt class="col-sm-4 offset-sm-1"> First Name</dt>
                        <dd class="col-sm-6">${currentApplicant.firstName}</dd>
                        <dt class="col-sm-4 offset-sm-1"> Last Name</dt>
                        <dd class="col-sm-6">${currentApplicant.lastName}</dd>
                        <dt class="col-sm-4 offset-sm-1"> Gender </dt>
                        <dd class="col-sm-6">${currentApplicant.gender}</dd>
                        <dt class="col-sm-4 offset-sm-1"> Telephone </dt>
                        <dd class="col-sm-6">${currentApplicant.telephone}</dd>
                        <dt class="col-sm-4 offset-sm-1"> Birthday </dt>
                        <dd class="col-sm-6">${currentApplicant.birthday.time?string["yyyy-MM-dd"]}</dd>
                        <dt class="col-sm-4 offset-sm-1"> Nationality </dt>
                        <dd class="col-sm-6">
                            <#list natiList as nati>
                            <li>${nati.name}
                            </#list>
                        </dd>

                    </dl>

                </div>
            </div>
        </div>
    </div>


<style>
    body {
        background: url("https://krot.info/uploads/posts/2020-01/1579349378_6-14.jpg")
    }
</style>

</body>
</html>