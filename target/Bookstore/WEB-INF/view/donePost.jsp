<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<p>
Book Title : <input type="text" name="title" value=${postinfo.title} readonly="readonly" />
</p>
<p>
Book Description: <input type="text" name="description" value=${postinfo.description} readonly="readonly" />
</p>
<p>
Book Price : <input type="text" name="price" value=${postinfo.price} readonly="readonly" />
</p>

<p>
Post Date: ${postinfo.date}
</p>

<p> Post Successfully Created </p>

</body>
</html>