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
            <#if checkEmp??>
                <li class="nav-item">
                    <a class="nav-link" href="/advert/update/${advert.id}">Update advert</a>
                </li>
            </#if>
        </ul>
    </nav>
</head>
<body>

<div class="card w-75">
    <div class="card-body mb-0">
        <h5 class="card-title">${advert.profession.name}</h5>
        <p class="card-text overflow-auto">
        <dl class="row">
            <dt class="col-sm-2"> Company</dt>
            <dd class="col-sm-10">${advert.employer.company}</dd>
            <dt class="col-sm-2"> Salary</dt>
            <dd class="col-sm-10">${advert.salary}</dd>
            <dt class="col-sm-2"> Requirements</dt>
            <dd class="col-sm-10"> ${advert.requirements}</dd>
            <dt class="col-sm-2"> Responsibility</dt>
            <dd class="col-sm-10"> ${advert.responsibility}</dd>
            <dt class="col-sm-2"> Terms</dt>
            <dd class="col-sm-10"> ${advert.terms}</dd>
            <dt class="col-sm-2"> Add date</dt>
            <dd class="col-sm-10">${advert.addDate.time?string["yyyy-MM-dd"]}</dd>
            <dt class="col-sm-2"> Status </dt>
            <dd class="col-sm-10"> ${advert.status}</dd>
                </dl>
        <form action="/administrator/setStatus/${advert.id}" method="post">
            <div class="d-flex justify-content-start mb-n3">
                <div class="p-2 bd-highlight mb-0">
            <select class="form-control" name="status">
                <#list status as s>
                    <option value="${s}">${s}</option>
                </#list>
            </select>
                </div>
                <div class="p-2 bd-highlight mb-0">
                <button type="submit" class="btn btn-primary">Accept</button>
                </div>
        </form>
    </div>
</div>

<style>
    body {
        background: url("https://krot.info/uploads/posts/2020-01/1579349378_6-14.jpg")
    }
</style>

</body>
</html>