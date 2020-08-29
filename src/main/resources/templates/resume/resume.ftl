<html lang="en">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
<style>
    body {
        background: url("https://krot.info/uploads/posts/2020-01/1579349378_6-14.jpg")
    }
</style>
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

<div class="card w-75">
    <div class="card-body">
        <h5 class="card-title">${resume.applicant.firstName} ${resume.applicant.lastName} </h5>
        <p class="card-text">
        <dl class="row">
            <dt class="col-sm-2"> Profession</dt>
            <dd class="col-sm-10">${resume.profession.name}</dd>
            <dt class="col-sm-2"> Salary</dt>
            <dd class="col-sm-10">${resume.salary}</dd>
            <dt class="col-sm-2 text-primary"><h4>Personal information</h4></dt>
            <dd class="col-sm-10"></dd>
            <dt class="col-sm-2"> Age</dt>
            <dd class="col-sm-10">${age.years}</dd>
            <dt class="col-sm-2"> Gender</dt>
            <dd class="col-sm-10">${resume.applicant.gender}</dd>
            <dt class="col-sm-2 "> Telephone</dt>
            <dd class="col-sm-10">${resume.applicant.telephone}</dd>
            <dt class="col-sm-2"> Nationality</dt>
            <dd class="col-sm-10">
                <#list resume.applicant.nationality as nati>
                <li>${nati.name}
                    </#list>
            </dd>
            <dt class="col-sm-2"> Gender</dt>
            <dd class="col-sm-10">${resume.applicant.gender}</dd>
            <dt class="col-sm-2"> Native language</dt>
            <dd class="col-sm-10">${resume.nativeLanguage.name}</dd>
            <dt class="col-sm-2"> Native language</dt>
            <dd class="col-sm-10">
                <#list resume.foreignLanguages as lg>
                <li>${lg.name}
                    </#list>
            </dd>
            <dt class="col-sm-2"> About myself</dt>
            <dd class="col-sm-10">${resume.aboutMyself}</dd>
            <dt class="col-sm-2 text-primary"><h4>Educations </h4></dt>
            <dd class="col-sm-10"></dd>
            <#list resume.educations as ed>
                <dt class="col-sm-2 text-primary"> ---------------------</dt>
                <dd class="col-sm-10"></dd>
                <dt class="col-sm-2"> Level</dt>
                <dd class="col-sm-10">
                    ${ed.level}
                </dd>
                <#if ed.educationalInstitution??>
                    <dt class="col-sm-2">Institution</dt>
                    <dd class="col-sm-10">${ed.educationalInstitution}</dd>
                    <dt class="col-sm-2">Faculty</dt>
                    <dd class="col-sm-10">${ed.faculty}</dd>
                    <dt class="col-sm-2">Specialization</dt>
                    <dd class="col-sm-10">${ed.specialization}</dd>
                    <dt class="col-sm-2">Year of ending</dt>
                    <dd class="col-sm-10">${ed.yearOfEnding}</dd>
                </#if>
                <dt class="col-sm-2 text-primary"> ---------------------</dt>
                <dd class="col-sm-10">
            </#list>
            </dd>
            <dt class="col-sm-2 text-primary"><h4> Work experience </h4></dt>
            <dd class="col-sm-10"></dd>
            <#list resume.placeOfWorks as wr>
                <dt class="col-sm-2 text-primary"> ---------------------</dt>
                <dd class="col-sm-10"></dd>
                <#if wr.organization??>
                    <dt class="col-sm-2">Organization</dt>
                    <dd class="col-sm-10">${wr.organization}</dd>
                    <dt class="col-sm-2">Position</dt>
                    <dd class="col-sm-10">${wr.position}</dd>
                    <dt class="col-sm-2">Beginning of work</dt>
                    <dd class="col-sm-10">${wr.beginningOfWork}</dd>
                    <dt class="col-sm-2">End of work</dt>
                    <dd class="col-sm-10">${wr.endOfWork}</dd>
                    <dt class="col-sm-2">Workplace responsibilities</dt>
                    <dd class="col-sm-10">${wr.workplaceResponsibilities}</dd>
                </#if>
                <dt class="col-sm-2 text-primary"> ---------------------</dt>
                <dd class="col-sm-10"></dd>
            </#list>
            <#if resume.workExperience == "No">
            <dt class="col-sm-2">Work experience</dt>
            <dd class="col-sm-10">${resume.workExperience}</dd>
            </#if>
        </dl>
        <a href="#" class="btn btn-primary">Button</a>
    </div>
</div>




</body>
</html>