<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
    <h1>Add Record to Book Table</h1>
    <form:form action="addBookToDB" method="post">
      Book Title: <form:input path="title"/><br/>
      Book ISBN: <form:input path="ISBN" /><br/>
      Book Description:<br/>
      <form:textarea path="description" rows="20"/><br/>
      <input type="reset"/>
      <input type="submit"/>
    </form:form>
</body>
</html>