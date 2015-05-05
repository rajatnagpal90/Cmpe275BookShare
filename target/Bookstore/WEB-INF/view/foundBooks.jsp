<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
    <h2>Found Books</h2>
 
    <c:forEach var="book" items="${foundBooks}">
        <ul>
          <li>${book.title}</li>
          <li>${book.ISBN}</li>
          <li>${book.description}</li>
        </ul>
        <hr>
    </c:forEach>
 
</body>
</html>