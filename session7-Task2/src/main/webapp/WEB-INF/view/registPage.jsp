<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h2>User Registration</h2>
    <form action="processForm">
        First Name: <input type="text" name="firstName"><br/>
        Last Name: <input type="text" name="lastName"><br/>
        Email: <input type="email" name="email"><br/>
        Date of Birth: <input type="text" name="birthdate" placeholder="DD-MM-YYYY"><br/>
        City: <input type="text" name="city"><br/><br/>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
