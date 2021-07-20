<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Registration Form</title>
</head>
<body>
<h1>Registration Form</h1>
<form action="success" method="post" enctype = "multipart/form-data">
<!-- enctype = "multipart/form-data"-->
    <table style="with: 50%">
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" /></td>
        </tr>
        <tr>
            <td>Mobile No.</td>
            <td><input type="text" name="mobile" /></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>Male <input type="radio" id="M" name="gender" value="Male" />
                Female <input type="radio" id="F" name="gender" value="Female"/>
            </td>
        </tr>
        <tr>
            <td>State</td>
            <td><select name="state">
						<option value="" >Select State</option>
                        <option value="Andhra Pradesh">Andhra Pradesh</option>
                        <option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
                        <option value="Arunachal Pradesh">Arunachal Pradesh</option>
                        <option value="Assam">Assam</option>
                        <option value="Bihar">Bihar</option>
                        <option value="Chandigarh">Chandigarh</option>
                        <option value="Chhattisgarh">Chhattisgarh</option>
                        <option value="Dadar and Nagar Haveli">Dadar and Nagar Haveli</option>
                        <option value="Daman and Diu">Daman and Diu</option>
                        <option value="Delhi">Delhi</option>
                        <option value="Lakshadweep">Lakshadweep</option>
                        <option value="Puducherry">Puducherry</option>
                        <option value="Goa">Goa</option>
                        <option value="Gujarat">Gujarat</option>
                        <option value="Haryana">Haryana</option>
                        <option value="Himachal Pradesh">Himachal Pradesh</option>
                        <option value="Jammu and Kashmir">Jammu and Kashmir</option>
                        <option value="Jharkhand">Jharkhand</option>
                        <option value="Karnataka">Karnataka</option>
                        <option value="Kerala">Kerala</option>
                        <option value="Madhya Pradesh">Madhya Pradesh</option>
                        <option value="Maharashtra">Maharashtra</option>
                        <option value="Manipur">Manipur</option>
                        <option value="Meghalaya">Meghalaya</option>
                        <option value="Mizoram">Mizoram</option>
                        <option value="Nagaland">Nagaland</option>
                        <option value="Odisha">Odisha</option>
                        <option value="Punjab">Punjab</option>
                        <option value="Rajasthan">Rajasthan</option>
                        <option value="Sikkim">Sikkim</option>
                        <option value="Tamil Nadu">Tamil Nadu</option>
                        <option value="Telangana">Telangana</option>
                        <option value="Tripura">Tripura</option>
                        <option value="Uttar Pradesh">Uttar Pradesh</option>
                        <option value="Uttarakhand">Uttarakhand</option>
                        <option value="West Bengal">West Bengal</option>
			</select></td>
        </tr>
        <tr>
            <td>Skills</td>
            <td><input type="checkbox" id="html" name="skills" value="HTML" > HTML</input>
                <input type="checkbox" id="css" name="skills" value="CSS" > CSS </input>
                <input type="checkbox" id="hibernate" name="skills" value="Hibernate" > Hibernate </input>
                <input type="checkbox" id="python" name="skills" value="Python" > Python </input>
                <input type="checkbox" id="java" name="skills" value="Java" > Java </input>
                <input type="checkbox" id="javascript" name="skills" value="JavaScript" > JavaScript </input>
                <input type="checkbox" id="mysql" name="skills" value="MySQL" > MySQL </input>
                <input type="checkbox" id="springboot" name="skills" value="Springboot" > Springboot </input></td>
        </tr>
        <tr>
            <td>Image</td>
            <td><input type="file" class="form-control-file" id="sub" name="image" title="Upload image.">
            </td>
        </tr></table>
        <br>
    	<input type="submit" value="Submit"/>
</form>
</body>
</html>