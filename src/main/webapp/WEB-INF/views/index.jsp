<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="pl" xml:lang="pl">
<head>
	<title>Embedded JSON</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script>
        // Fetch products using Ajx call and update html.
        function getProducts(page, pageSize) {
            $.ajax({
            url: 'api/product/list?page=' + page + '&pageSize=' + pageSize,
            success: function (data) {
                console.log("Successful product Ajax call with data:");
                console.log(data);
                var productTable = $('#productTable');
                productTable.empty();
                $.each(data, function(index, product) {
                    productTable.append($('<tr><td>'+product.name+'</td><td>'+product.description+'</td><td>'+product.price+'</td></tr>'));
                });

            }
            });
        }

        // On document.ready, initialize link handlers and fetch first products.
        $(function () {
            $.each($('.pagingLink'), function(index, link) {
                console.log('Updating click handler of link ' + link + ' at index ' + index);
                $(link).click(function() { getProducts(index+1, 3);
              });
            });
            getProducts(1,3);

        });
    </script>
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
        <tbody id="productTable" />
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
