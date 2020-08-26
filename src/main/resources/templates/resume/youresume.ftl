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

<#list allApplicantResume as resume>
<div class="card w-75">
    <div class="card-body">
        <h5 class="card-title">${resume.applicant.firstName} ${resume.applicant.lastName}</h5>
        <p class="card-text">
        <li>${resume.profession.name}</li>
        <#list resume.educations as education>
        <li> ${education.level}
        <#if education.educationalInstitution??>
        <li> ${education.educationalInstitution}
        <li> ${education.yearOfEnding}
            </#if>
            </#list>
        <li>${resume.aboutMyself}</li>
        </p>
        <a href="/resume/Resume?id=${resume.id}" class="btn btn-primary">Button</a>
    </div>
</div>
</#list>


<style>
    body {
        background: url("https://krot.info/uploads/posts/2020-01/1579349378_6-14.jpg")
    }
</style>

</body>
</html>