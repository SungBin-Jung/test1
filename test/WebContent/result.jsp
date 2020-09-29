<%@page import="test.ProductInfoDAO" %>
<%@page import="test.ProductInfoDTO" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	ProductInfoDAO productInfoDAO = ProductInfoDAO.getInstance();
	List<ProductInfoDTO> list = productInfoDAO.getList();
	ProductInfoDTO data = new ProductInfoDTO();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 리스트</title>
</head>
<body>
	<div align="center">
	<table border="1">
	<tr><td align="center" colspan="2">상품 정보 리스트</td></tr>
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