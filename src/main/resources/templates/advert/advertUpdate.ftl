<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Title</title>
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
</head>
<body>


    <form action="/advert/update/${advert.id}" method="post">
        <h6 class="mt-4"></h6>
        <div class="form-group text-light">
            <label for="applicant1" class="offset-sm-2"> Profession </label>
            <select class="form-control col-2 offset-sm-2" name="profession">
                <#list professions as prof>
                    <#if advert.profession.id == prof.id>
                        <option value="${prof.id}" selected> ${prof.name}</option>
                    <#else>
                        <option value="${prof.id}"> ${prof.name}</option>
                    </#if>
                </#list>
            </select>
        </div>
        <div class="form-group text-light">
            <label for="employer2" class="offset-sm-2">Salary</label>
            <input type="text" class="form-control col-4 offset-sm-2" id="employer2" name="salary" value="${advert.salary}">
        </div>
        <div class="form-group text-light">
            <label for="employer5" class="offset-sm-2">Responsibility</label>
            <textarea class="form-control col-4 offset-sm-2" id="employer5" name="responsibility" rows="3">${advert.responsibility}</textarea>
        </div>
        <div class="form-group text-light">
            <label for="employer5" class="offset-sm-2">Requirements</label>
            <textarea class="form-control col-4 offset-sm-2" id="employer5" name="requirements" rows="3">${advert.requirements}</textarea>
        </div>
        <div class="form-group text-light">
            <label for="employer5" class="offset-sm-2">Terms</label>
            <textarea class="form-control col-4 offset-sm-2" id="employer5" name="terms" rows="3">${advert.terms}</textarea>
        </div>
        <button type="submit" class="btn btn-primary offset-sm-2">Submit</button>
    </form>



<style>
    body {
        background: url("https://i1.wallbox.ru/wallpapers/main/201134/2560h1600-tekstura-oboi-e710001.jpg")
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
    $('.dropdown-input').click(function(event){
        event.stopPropagation();
    });
</script>
</body>
</html>