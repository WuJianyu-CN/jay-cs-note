<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add book</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small> add book </small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/addBook" method="post">
        book name: <input type="text" name="bookName"><br><br><br>
        book counts: <input type="text" name="bookCounts"><br><br><br>
        book detail: <input type="text" name="detail"><br><br><br>
        <input type="submit" value="add">
    </form>

</div>

</body>
</html>
