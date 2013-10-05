<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${!ajaxRequest}">
<html>
<head>
	<title>Flyaway | 子行业</title>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
	<script type="text/javascript" src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="../resources/js/jquery.form.js" />"></script>	
</head>
<body>
</c:if>
	<div id="fileuploadContent">
		<h2>文件上传</h2>

		<form id="fileuploadForm" action="fileupload" method="POST" enctype="multipart/form-data" class="cleanform">
			<div class="header">
		  		<h2>表单</h2>
		  		<c:if test="${not empty message}">
					<div id="message" class="success">${message}</div>	  		
		  		</c:if>
			</div>
			<label for="file">文件</label>
			<input id="file" type="file" name="file" />
			<p><button type="submit">上传</button></p>		
		</form>
		<script type="text/javascript">
			$(document).ready(function() {
				$('<input type="hidden" name="ajaxUpload" value="true" />').insertAfter($("#file"));
				$("#fileuploadForm").ajaxForm({ success: function(html) {
						$("#fileuploadContent").replaceWith(html);
					}
				});
			});
		</script>	
	</div>
<c:if test="${!ajaxRequest}">
</body>
</html>
</c:if>