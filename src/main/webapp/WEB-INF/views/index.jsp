<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<h1><s:message code="view.index.title" /></h1>

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
                <a href="#"><c:out value="${pageIndex}" /></a>
            </c:forEach>
        </div>
    </c:if>
</p>
