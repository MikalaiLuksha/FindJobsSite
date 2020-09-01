<html lang="en">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
<#import "pager.ftl" as p>

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
                <a class="nav-link" href="/resume/addResume">Create resume</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/resume/youResume">You resume</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Response</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user/logout">Logout</a>
            </li>
        <#elseif checkRegE??>
            <li class="nav-item">
                <a class="nav-link" href="/user/employer/account">Company Information</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/resume/resumeList">Resume list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/advert/addAdvert">Create advert</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/advert/youAdvert">You advert</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user/logout">Logout</a>
            </li>
        <#elseif checkRegAd??>
            <li class="nav-item">
                <a class="nav-link" href="/user/applicant/account">User list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/advert/addAdvert">Resume list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/advert/youAdvert">Advert list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Response</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user/logout">Logout</a>
            </li>
        </#if>
    </ul>
</nav>

<form action="/sort" method="post">
<div class="d-flex justify-content-start mb-n3">
    <div class="p-2 bd-highlight mb-0">
        <dt class="text-light"><h4>Sorting</h4></dt>
    </div>
    <div class="p-2 bd-highlight mb-0">
        <div class="dropdown">
            <button class="btn btn-light dropdown-toggle" type="button" id="profession1" data-toggle="dropdown">
                Profession <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" style="width: 250px;">
                <#list profs as prof>
                    <li class="dropdown-input offset-sm-1"><label><input type="checkbox" name="profSort"
                                                                         value="${prof.id}"> ${prof.name}</label></li>
                </#list>
            </ul>
        </div>
    </div>
    <div class="p-2 bd-highlight mb-0">
        <div class="dropdown">
            <button class="btn btn-light dropdown-toggle" type="button" id="salary1" data-toggle="dropdown">
                Salary <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <#assign periods = ["less 1000", "1000 - 1500", "1500 - 2000", "more 2000"]>
                <#list periods as period>
                    <li class="dropdown-input offset-sm-1"><label><input type="radio" name="salaryPeriod"
                                                                         value="${period}"> ${period}</label></li>
                </#list>
            </ul>
        </div>
    </div>
    <div class="p-2 bd-highlight mb-0">
        <select class="form-control" name="salarySort">
            <#assign sors = ["salary increase", "salary decrease", "no"]>
            <#list sors as sor>
                <option value="${sor}"> ${sor}</option>
            </#list>
        </select>
    </div>
    <div class="p-2 bd-highlight mb-0">
            <button type="submit" class="btn btn-primary">Accept</button>
    </div>
</div>
</form>
<@p.pager url page />
    <#list page.content as advert>
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
                    <dt class="col-sm-2"> Add date</dt>
                    <dd class="col-sm-10">${advert.addDate.time?string["yyyy-MM-dd"]}</dd>
                    <div class="d-flex justify-content-start mb-n3">
                        <div class="p-2 bd-highlight mb-0">
                            <form action="/advert/advert/${advert.id}" method="get">
                                <button type="submit" class="btn btn-primary">Open</button>
                            </form>
                        </div>
                    </div>
                </dl>
            </div>
        </div>
    </#list>
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