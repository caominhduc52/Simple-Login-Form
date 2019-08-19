<%--
  Created by IntelliJ IDEA.
  User: Minh Duc Cao
  Date: 8/19/2019
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
    <style>
        body {
            font-family: 'Open Sans', sans-serif;
            background: #3498db;
            margin: 0 auto 0 auto;
            width: 100%;
            text-align: center;
            margin: 20px 0px 20px 0px;
        }

        p {
            font-size: 12px;
            text-decoration: none;
            color: #ffffff;
        }

        h1 {
            font-size: 1.5rem;
            color: #525252;
        }

        .box {
            background: white;
            width: 300px;
            border-radius: 6px;
            margin: 0 auto 0 auto;
            padding: 0px 0px 70px 0px;
            border: #2980b9 4px solid;
        }

        .username {
            background: #ecf0f1;
            border: #ccc 1px solid;
            padding: 8px;
            width:250px;
            color:#AAAAAA;
            margin-top:10px;
            font-size:1em;
            border-radius:4px;
        }

        .button{
            background:#2ecc71;
            width:125px;
            padding-top:5px;
            padding-bottom:5px;
            color:white;
            border-radius:4px;
            border: #27ae60 1px solid;
            margin-top:20px;
            margin-bottom:20px;
            float:left;
            margin-left:88px;
            font-weight:800;
            font-size:0.8em;
        }
        .button:hover{
            background:#2CC06B;
        }
        .fpwd{
            color:#f1c40f;
            text-decoration: underline;
        }
        #absoluteCenteredDiv{
            position: absolute;
            top:0;
            bottom: 0;
            left: 0;
            right: 0;
            margin: auto;
            width:400px;
            height: 300px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div id="absoluteCenteredDiv">
        <h3><%= request.getAttribute("Message") != null ? request.getAttribute("Message") : ""%></h3>
        <form action="LoginController" method="POST">
            <div class="box">
                <h1>Login Form</h1>
                <input class="username" name="username" type="text" placeholder="User Name">
                <input class="username" name="password" type="password" placeholder="Password">
                <a href="#"><input class="button" type="submit" value="Sign IN"/></a>
            </div>
        </form>
        <p>Forgot your password? <a href="#" class="fpwd">click Here!></a></p>
    </div>
</body>
</html>
