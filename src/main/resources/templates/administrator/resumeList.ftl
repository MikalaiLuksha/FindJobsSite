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
        <li class="nav-item">
            <a class="nav-link active" href="/">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">###########</a>
        </li>
    </ul>
</nav>

<form action="/administrator/sortResume" method="post">
<div class="d-flex justify-content-start mb-n3">
    <div class="p-2 bd-highlight mb-0">
        <dt class="text-light"><h4>Sorting</h4></dt>
    </div>
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
</div>
</form>

<#if resumes??>
    <#list resumes as resume>
        <div class="card w-75">
            <div class="card-body mb-0">
                <h5 class="card-title">${resume.applicant.firstName} ${resume.applicant.lastName}</h5>
                <p class="card-text overflow-auto">
                <dl class="row">
                    <dt class="col-sm-2"> Profession </dt>
                    <dd class="col-sm-10">${resume.profession.name}</dd>
                    <dt class="col-sm-2"> Educations</dt>
                    <dd class="col-sm-10">
                        <#list resume.educations as education>
                        <li> ${education.level}
                            </#list>
                    </dd>
                    <dt class="col-sm-2"> Work experience </dt>
                    <dd class="col-sm-10">${resume.workExperience}</dd>
                    <dt class="col-sm-2"> About myself </dt>
                    <dd class="col-sm-10">${resume.aboutMyself}</dd>
                    <dt class="col-sm-2"> Status </dt>
                    <dd class="col-sm-10">${resume.status}</dd>
                </dl>
                </p>
                <div class="d-flex justify-content-start mb-n3">
                    <div class="p-2 bd-highlight mb-0">
                        <form action="/resume/resume/${resume.id}" method="get">
                            <button type="submit" class="btn btn-primary" value="">Open</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </#list>
</#if>
<div class="fixed-bottom">
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">4</a></li>
            <li class="page-item"><a class="page-link" href="#">5</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
    </nav>
</div>

<style>
    body {
        background: url("https://krot.info/uploads/posts/2020-01/1579349378_6-14.jpg")
    }
</style>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
<script>
    $('.dropdown-input').click(function (event) {
        event.stopPropagation();
    });
</script>
</body>
</html>