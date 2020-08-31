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
                <a class="nav-link" href="#">###########</a>
            </li>
        </ul>
    </nav>
</head>
<body>

<#if allApplicantResume??>
<#list allApplicantResume as resume>
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
            </dl>
              </p>
            <div class="d-flex justify-content-start mb-n3">
                <div class="p-2 bd-highlight mb-0">
                    <form action="/resume/resume/${resume.id}" method="get">
                        <button type="submit" class="btn btn-primary" value="">Open</button>
                    </form>
                </div>
                <div class="p-2 bd-highlight mb-0">
                    <form action="/resume/deleted/${resume.id}" method="post">
                        <button type="submit" class="btn btn-primary">Deleted</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</#list>
</#if>

<style>
    body {
        background: url("https://krot.info/uploads/posts/2020-01/1579349378_6-14.jpg")
    }
</style>

</body>
</html>