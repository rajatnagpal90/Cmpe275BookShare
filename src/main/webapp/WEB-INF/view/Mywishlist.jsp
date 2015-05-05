<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
    <h2>Books Posted</h2>
 
    <c:forEach var="post" items="${wishlist}">
        <ul>
          <li>${post.title}</li>
          <li>${post.ISBN}</li>
          <li>${post.description}</li>
          <li>${post.price}</li>
          <li>${post.date}</li>
        </ul>
        <hr>
    </c:forEach>
 
</body>
</html>