<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

</head>
<body>

<h4 class="mt-5"></h4>
        <form action="/user/applicant/account/update" method="post">
            <h6 class="mt-4"></h6>
            <div class="form-group text-light">
                <label for="applicant1" class="offset-sm-2">First Name </label>
                <input type="text" class="form-control col-4 offset-sm-2" id="applicant1" name="firstName" value="${currentApplicant.firstName}">
            </div>
            <div class="form-group text-light">
                <label for="applicant2" class="offset-sm-2">Last Name</label>
                <input type="text" class="form-control col-4 offset-sm-2" id="applicant2" name="lastName" value="${currentApplicant.lastName}">
            </div>
            <div class="form-group text-light">
                <label for="exampleInputEmail1" class="offset-sm-2">Email address</label>
                <input type="email" name="email" class="form-control col-4 offset-sm-2" id="exampleInputEmail1" aria-describedby="emailHelp" value="${currentApplicant.email}">
            </div>}
            <div class="form-group text-light">
                <label for="exampleInputPassword1" class="offset-sm-2">Password</label>
                <input type="password" name="password" class="form-control col-4 offset-sm-2" id="exampleInputPassword1" value="${currentApplicant.password}">
            </div>
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
                       data-format="+375 (dd) ddd-dddd" value="${currentApplicant.telephone}" pattern="(\+[\d\ \(\)\-]{16})">
            </div>
            <button type="submit" class="btn btn-primary offset-sm-2">Submit</button>
        </form>

<a href="/" type="submit" class="btn btn-primary offset-sm-4 col-2">Return</a>

<#if messageError??>
    <div class="alert alert-danger col-4 offset-sm-2 mt-4" role="alert" style="background-color: #f46666;">
        ${messageError}
    </div>
</#if>

<style>
    body {
        background: url("https://i1.wallbox.ru/wallpapers/main/201134/2560h1600-tekstura-oboi-e710001.jpg")
    }
</style>
<script>
    $('.dropdown-input').click(function(event){
        event.stopPropagation();
    });
</script>
</body>
</html>
