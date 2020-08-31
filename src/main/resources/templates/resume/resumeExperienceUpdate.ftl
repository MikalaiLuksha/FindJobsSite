<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.2.0/css/datepicker.min.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form>
    <h6 class="mt-4"></h6>
    <div class="form-group text-light">
        <label for="datepicker" class="offset-sm-2">Beginning of work </label>
        <input type="text" class="form-control col-2 offset-sm-2" name="beginningOfWork" id="datepicker" value="${pow.beginningOfWork}"/>
    </div>
    <div class="form-group text-light">
        <label for="datepicker2" class="offset-sm-2">  End of work </label>
        <input type="text" class="form-control col-2 offset-sm-2" name="endOfWork" id="datepicker2" value="${pow.endOfWork}"/>
    </div>
    <div class="form-group text-light">
        <label for="applicant3" class="offset-sm-2">Organization </label>
        <input type="text" class="form-control col-4 offset-sm-2" id="applicant3" name="organization" value="${pow.organization}">
    </div>
    <div class="form-group text-light">
        <label for="applicant4" class="offset-sm-2">Position </label>
        <input type="text" class="form-control col-4 offset-sm-2" id="applicant4" name="position" value="${pow.position}">
    </div>
    <div class="form-group text-light">
        <label for="employer5" class="offset-sm-2">Workplace responsibilities</label>
        <textarea class="form-control col-4 offset-sm-2" id="employer5" name="workplaceResponsibilities" rows="3">${pow.workplaceResponsibilities}</textarea>
    </div>
    <button type="submit" formaction="/resume/updateExperience?id=${pow.id}&idr=${idr}"
            class="btn btn-primary offset-sm-2" formmethod="post"> Save
    </button>
</form>




<style>
    body {
        background: url("https://i1.wallbox.ru/wallpapers/main/201134/2560h1600-tekstura-oboi-e710001.jpg")
    }
</style>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.2.0/js/bootstrap-datepicker.min.js"></script>
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

<script>$("#datepicker").datepicker( {
        format: "mm-yyyy",
        startView: "months",
        minViewMode: "months"
    });</script>
<script>$("#datepicker2").datepicker( {
        format: "mm-yyyy",
        startView: "months",
        minViewMode: "months"
    });</script>
</body>
</html>