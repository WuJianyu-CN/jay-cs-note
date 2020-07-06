<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>

    <style>

        a {
            text-decoration: none;
            color: black;
            font-size: 18px;
        }

        h3 {
            width: 200px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: deepskyblue;
            border-radius: 5px;
        }

    </style>

</head>
<body>

<h3>
    <a href="${pageContext.request.contextPath}/book/toAddPage">add book</a>
</h3>

<h3>
    <a href="${pageContext.request.contextPath}/book/allBook">enter books page</a>
</h3>

</body>
</html>
