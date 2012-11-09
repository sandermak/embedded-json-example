<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="pl" xml:lang="pl">
<head>
	<title>Embedded JSON</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>Products</h1>
<p>
    <table>
        <thead>
            <tr>
                <th>Product</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
        </thead>
        <c:forEach var="product" items="${products}">
            <tr>
                <td><c:out value="${product.name}" /></td>
                <td><em><c:out value="${product.description}" /></em></td>
                <td><c:out value="${product.price}" /> Euro</td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${pageIndices.size() > 1}">
        <div id="paging">
            <c:forEach var="pageIndex" items="${pageIndices}">
                <a href="#" class="pagingLink"><c:out value="${pageIndex}" /></a>
            </c:forEach>
        </div>
    </c:if>
</p>
</body>
</html>
