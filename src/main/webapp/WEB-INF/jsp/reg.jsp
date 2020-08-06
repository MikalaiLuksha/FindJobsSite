<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<html>
<head>
    <title>Title</title>

REGUSER
</head>
<body>


<ul class="nav nav-tabs" id="myTab" role="tablist">
<li class="nav-item" role="presentation">
    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#applicant" role="tab" aria-controls="Applicant" aria-selected="true">Registration applicant</a>
</li>
<li class="nav-item" role="presentation">
    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#employer" role="tab" aria-controls="Employer" aria-selected="false">Registration employer</a>
</li>
</ul>

<div class="tab-content" id="myTabContent">
    <div class="tab-pane fade show active" id="applicant" role="tabpanel" aria-labelledby="home-tab">
        <form action="/user/reg/applicant" method="post">
            <div class="form-group">
                <label for="applicant1" class="offset-sm-2">First Name</label>
                <input type="text" class="form-control col-5 offset-sm-2" id="applicant1" name="firstName">
            </div>
            <div class="form-group">
                <label for="applicant2" class="offset-sm-2">Last Name</label>
                <input type="text" class="form-control col-5 offset-sm-2" id="applicant2" name="lastName">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1" class="offset-sm-2">Email address</label>
                <input type="email" name="email" class="form-control col-5 offset-sm-2" id="exampleInputEmail1" aria-describedby="emailHelp">
             </div>
            <div class="form-group">
                <label for="exampleInputPassword1" class="offset-sm-2">Password</label>
                <input type="password" name="password" class="form-control col-5 offset-sm-2" id="exampleInputPassword1">
            </div>
               <button type="submit" class="btn btn-primary offset-sm-2">Submit</button>
        </form>
        </div>
    <div class="tab-pane fade" id="employer" role="tabpanel" aria-labelledby="profile-tab">
        <form action="/user/reg/employer" method="post">
            <input type="text" name="firstName" placeholder="First Name">
            <input type="text" name="lastName" placeholder="Last Name">
            <input type="email" name="email" placeholder="Email">
            <input type="text" name="phone" placeholder="Phone">
            <input type="text" name="company" placeholder="Company">
            <input type="password" name="password" placeholder="Password">
            <button>Submit</button>
        </form>
    </div>
</div>




</body>
</html>
