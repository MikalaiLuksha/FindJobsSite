<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<div class="tab-pane fade show active" id="applicant" role="tabpanel" aria-labelledby="home-tab">
    <form action="/user/applicant/addProfile" method="post">
        <h6 class="mt-4"></h6>
        <div class="form-group text-light">
            <label for="applicant1" class="offset-sm-2"> Birthday </label>
            <input type="date" class="form-control col-2 offset-sm-2" id="applicant1" name="birthday">
        </div>
        <div class="form-group text-light">
            <label for="applicant2" class="offset-sm-2"> Gender </label>
            <select class="form-control col-2 offset-sm-2" name="gender">
                <#list genders as gender>
                    <option value="${gender}"> ${gender}</option>
                </#list>
            </select>
        </div>

        <div class="dropdown mt-2">
            <label for="appl" class="offset-sm-2 text-light"> Nationality </label>
            <br><button class="btn btn-light dropdown-toggle offset-sm-2" type="button" id="appl" data-toggle="dropdown">
                Selected <span class="caret"></span>
            </button><br>
            <ul class="dropdown-menu">
                <#list nationality as nati>
                <li class="dropdown-input offset-sm-1"><label><input type="checkbox" name="nationality" value="${nati.id}"> ${nati.name} </label></li>
                </#list>
            </ul>
        </div>

<div class="form-group text-light mt-3">
    <label for="telephone" class="offset-sm-2">Telephone</label>
    <input type="text" name="telephone" id="phone" class="form-control bfh-phone col-2 offset-sm-2"
           data-format="+375 (dd) ddd-dddd" value="" pattern="(\+[\d\ \(\)\-]{16})">
</div>
<button type="submit" class="btn btn-primary offset-sm-2">Submit</button>
</form>
</div>

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

