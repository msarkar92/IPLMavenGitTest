<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dto.UploadFileLogDTO"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<meta name="description" content="">
<meta name="author" content="">
<title>Upload Match Info</title>

<jsp:include page="links_1.jsp"></jsp:include>
<script src="js/myScript.js"></script>

<script type="text/javascript">
	function selectFile(btnId){
		//alert(btnId);
		var txtFile=document.getElementById('txt-fileName-'+btnId).value;
		var txtPath=document.getElementById('txt-filePath-'+btnId).value;
		document.getElementById('txt-selected-file').value=txtPath+txtFile;
	}
</script>

</head>

<body class="fixed-nav" id="page-top">

	<jsp:include page="adminHeaderMenu.jsp"></jsp:include>
	
	<div class="content-wrapper py-3">

		<div class="container-fluid">
			<!-- Breadcrumbs -->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#" onclick="inputFile()" >Upload</a></li>
			</ol>
			<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li>
						<form action="UploadFileController" method="post" enctype="multipart/form-data" id="form-content">
							<input type="file" id="file" name="file" placeholder="Upload...">
							<input class="col-sm-12" type="submit" value="Upload">
						</form>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<%
		String uploadStatus=request.getAttribute("uploadStatus")==null?"":request.getAttribute("uploadStatus").toString();
		
	%>
	<p><%=uploadStatus%></p>
	
		<div>
			<form action="UploadFileListController" method="post">
				<input type="submit" value="Refresh"> 
			</form>
		</div>
		<% if(request.getAttribute("uploadList")!=null){
		%>
		<%
			List<UploadFileLogDTO> uploadFileLogDTOs=(ArrayList<UploadFileLogDTO>)request.getAttribute("uploadList");
			String status="";
			if(uploadFileLogDTOs.size()<0){
				status="No recent files";
		%>
		<p><%=status %></p>
		<%}
		else{
			int id=1;
			for(UploadFileLogDTO dto:uploadFileLogDTOs){
		%>
		<div>
			<table>
				<tr>
					<td><input type="text" id="txt-fileName-<%=++id %>" value="<%=dto.getFileName()+'.'+dto.getFileExtension()%>"></td>					
					<td><%=dto.getFileUpload_date()%></td>
					<td><input type="text"  id="txt-filePath-<%=id %>"value="<%=dto.getFilePath()%>"></td>
					<td><input type="button" id="<%=id%>" onclick="selectFile(this.id)" value="Select"></td>
				</tr>
			</table>
			
		
		<%
			}
		%>
			<div>
				<form action="InsertToDatabaseController" method="post">
					<input type="text" id="txt-selected-file" name="txt-selected-file" size="60" required> 
					<input type="submit" value="Process">
				</form>
			</div>
			<div>
				<% if(request.getAttribute("insertStatus")!=null){
					String insertStatus=request.getAttribute("insertStatus")==null?"":(String)request.getAttribute("insertStatus");
				%>
				<p><%=insertStatus%></p>
				<%
				}
				%>
			</div>
			
		</div>
		<%
		}
		}
		%>
	</div>
	
	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/popper/popper.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
	<script src="vendor/chart.js/Chart.min.js"></script>
	<script src="vendor/datatables/jquery.dataTables.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/sb-admin.min.js"></script>

</body>

</html>
