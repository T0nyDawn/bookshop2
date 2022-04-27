<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 
	if(!true){
		to login.jsp
}
 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		.t_bg{background-color:#8A2BE2}
		.t_right_bg{background-color:#FFF0F5}
		a:link{
			text-decoration:none;
		}
		a:visited{
			text-decoration:none;
		}
		a:active{
			text-decoration:none;
		}
		a:hover{
			text-decoration:none;
		}
	</style>
</head>
<body>


<jsp:include page="title.jsp"></jsp:include>

<table width="800px" height="400px" align="center">
	<tr>
		<td width="200px" class="t_right_bg" valign="top">
			<table width="100%"  >
				<tr>
					<td>图书目录</td>
				</tr>
				
				<tr>
					<td><a href="doproduct.jsp?lb=1">计算机类</a></td>
				</tr>
				
				<tr>
					<td><a href="doproduct.jsp?lb=2">小说类</a></td>
				</tr>
				<tr>
					<td><a href="%">儿童读物</a></td>
				</tr>
				<tr>
					<td><a href="%">杂志天下</a></td>
				</tr>
			</table>
		</td>
		
		<td>
		<img alt="图书商城" src="images/rightside.jpg">
		</td>
	</tr>
	
</table>
<!-- 内容end -->
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>