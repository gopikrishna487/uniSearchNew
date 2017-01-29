<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- <%@include file="/WEB-INF/jsps/template/header.jsp"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book's</title>
</head>

<div class="page-header">
	<h1>All Books</h1>

	<p class="lead">
	<h3>All Avilable TitleListASSIA's</h3>
	</p>
	<br/>
</div>

<table class="table table-striped table-hover">
	<thead>
		<tr class="bg-success">
			<th>SerialTitle</th>
			<th>ISSNPrint</th>
			<th>ISSNElectronic</th>
			<th>PublisherName</th>
			<th>CountryOfPublication</th>
			<th>ASSIA</th>
			<th></th>
		</tr>
	</thead>
	<c:forEach items="${books}" var="books">
		<tr>
			<td>${books.serialTitle}</td>
			<td>${books.ISSNPrint}</td>
			<td>${books.ISSNElectronic}</td>
			<td>${books.publisherName}</td>
			<td>${books.countryOfPublication}</td>
			<td>${books.ASSIA}</td>
		</tr>
	</c:forEach>
</table>
<p>
	<a href="${pageContext.request.contextPath}/home">Home Page</a>
</p>
<%@include file="/WEB-INF/jsps/template/footer.jsp"%>
