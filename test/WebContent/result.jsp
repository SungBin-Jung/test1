<%@page import="test.ProductInfoDAO" %>
<%@page import="test.ProductInfoDO" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	ProductInfoDAO productInfoDAO = ProductInfoDAO.getInstance();
	List<ProductInfoDO> list = productInfoDAO.getList();
	ProductInfoDO data = new ProductInfoDO();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 리스트</title>
</head>
<body>
	<div align="center">
	<h1>상품 정보 리스트</h1>
	<table border="1">
	<tr>
	<td>제품 명</td>
	<td>가격</td>
	</tr>
	<%
		for(int i=0;i<list.size();i++){
			data = list.get(i);
	%>
	<tr>
	<td><%=data.getName() %></td>
	<td><%=data.getPrice() %></td>
	<%} %>
	</table>
	</div>
</body>
</html>