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
        <form action="/user/reg" method="post">
            <input type="text" name="firstName" placeholder="First Name">
            <input type="text" name="lastName" placeholder="Last Name">
            <input type="email" name="email" placeholder="Email">
            <input type="password" name="password" placeholder="Password">
            <button>Submit</button>
        </form>
            </div>
    <div class="tab-pane fade" id="employer" role="tabpanel" aria-labelledby="profile-tab">
        <form action="/user/reg" method="post">
            <input type="text" name="firstName" placeholder="First Name">
            <input type="text" name="lastName" placeholder="Last Name">
            <input type="email" name="email" placeholder="Email">
            <input type="password" name="password" placeholder="Password">
            <button>Submit</button>
    </div>
</div>



</body>
</html>
