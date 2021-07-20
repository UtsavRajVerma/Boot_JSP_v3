<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Success</title>
</head>
<body>
<h1>Successfully added!</h1>
    <table style="with: 50%">
        <tr>
            <td><b>Name:</b> ${form.name}</td>
        </tr>
        <tr>
            <td><b>Email:</b> ${form.email}</td> 
        </tr>
        <tr>
            <td><b>Mobile No.:</b> ${form.mobile}</td> 
        </tr>
        <tr>
            <td><b>Gender:</b> ${form.gender}</td> 
        </tr>
        <tr>
            <td><b>State:</b> ${form.state}</td> 
        </tr>
        <tr>
            <td><b>Skills:</b> ${form.skills}</td> 
        </tr>
        <tr>
            <td><b>Image: </b><img src="${form.image}"/></td>
        </tr></table>
        <br>   
    <a href="http://localhost:5747/home">
    <input type="submit" value="Edit"/></a>
</body>
</html>