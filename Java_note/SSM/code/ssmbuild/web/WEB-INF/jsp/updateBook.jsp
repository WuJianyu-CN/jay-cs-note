<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update book</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small> modify book </small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <input type="hidden" name="bookID" value="${QBook.bookID}"/>
        book name: <input type="text" name="bookName" value="${QBook.bookName}"/>
        book counts: <input type="text" name="bookCounts" value="${QBook.bookCounts}"/>
        book detail: <input type="text" name="detail" value="${QBook.detail}"/>
        <input type="submit" value="submit"/>
    </form>

</div>
</body>
</html>
