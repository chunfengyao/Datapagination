<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.7.2.min.js"></script>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newslist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	这是新闻页!!!
	<table border="1" width="80%" align="center" cellpadding="5" cellspacing="0" >
		<tr>
			<td>序号</td>
			<td>标题</td>
			<td>描述</td>
			<td>日期</td>
			<td>链接</td>
		</tr>
		<!-- 迭代数据 -->
		<c:choose>
			<c:when test="${not empty requestScope.Pagebean.resaultSet}">
				<c:forEach var="news" items="${requestScope.Pagebean.resaultSet}" varStatus="vs">
					<tr>
						<td>${vs.count }</td>
						<td>${news.newsTitle }</td>
						<td>${news.newsDescription }</td>
						<td>${news.newsDate.toLocaleString() }</td>
						<td><a href="${news.newsURL }">go~</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="3"> 抱歉，目前还没有相关数据。。</td>
					
				</tr>
			</c:otherwise>
		</c:choose>
		<tr>
			<td align="center" colspan="4">
				<a href="${request.contextPath }/DataPagination/news?currentpage=1&lineNumPerPage=${requestScope.Pagebean.lineNumPerPage }">
						首页
					</a>&nbsp;&nbsp;
				<a href="${request.contextPath }/DataPagination/news?currentpage=${requestScope.Pagebean.currentPage-1 }&lineNumPerPage=${requestScope.Pagebean.lineNumPerPage }">
						上一页
					</a>&nbsp;&nbsp;
				<a href="${request.contextPath }/DataPagination/news?currentpage=${requestScope.Pagebean.currentPage+1 }&lineNumPerPage=${requestScope.Pagebean.lineNumPerPage }">
						下一页
					</a>&nbsp;&nbsp;
				<a href="${request.contextPath }/DataPagination/news?currentpage=${requestScope.Pagebean.totlePage }&lineNumPerPage=${requestScope.Pagebean.lineNumPerPage }">
						末页${requestScope.Pagebean.totlePage }
					</a>&nbsp;&nbsp;
			</td>
		</tr>
	</table >
	<table action="newslist.jsp" method="post">
	<tr>
		<td>调整每页行数:</td><td><input type="text" value="${requestScope.Pagebean.lineNumPerPage }" name="lineNumPerPage" id="lineNumPerPage">
		<input type="submit" value="确定并刷新" id="button" onclick="location.href='${request.contextPath }/DataPagination/news?currentpage=${requestScope.Pagebean.currentPage }&lineNumPerPage='+document.getElementById('lineNumPerPage').value;return false;" >
		<br></td>
		</tr>
	</table>
	<a href="${request.contextPath }/DataPagination">返回主页</a>
	</body>
</html>
