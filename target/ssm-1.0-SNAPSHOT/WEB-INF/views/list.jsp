<%--
  Created by IntelliJ IDEA.
  User: 96384
  Date: 2018/7/14
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工列表</title>
</head>
<%
    pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<!--
    不以/开始的相对路径，找资源，以当前资源路径为基准
    以/开始的相对路径，以服务器为标准，需要加上（http://localhost8080）
-->
<%--<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>--%>
<%--<link href="${APP_PATH}/static/Bootstrap/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">--%>
<%--<script src="#{APP_PATH}/static/Bootstrap/bootstrap-3.3.7-dist/js/bootstrap.js"></script>--%>
<script type="text/javascript"
        src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link
        href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
        rel="stylesheet">
<script
        src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<body>
<div class="container">
    <%--标题--%>
    <div class="row">
        <h1>SSM-CRUD</h1>
    </div>
    <%--按钮--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary">新增</button>
            <button class="btn btn-danger">删除</button>
        </div>
    </div>
    <%--表格--%>
    <div class="row">
        <div class=col-md-12"">
            <table class="table">
                <tr>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="em">
                    <tr>
                        <th>${em.emp_id}</th>
                        <th>${em.emp_name}</th>
                        <th>${em.gender=="1"?"男":"女"}</th>
                        <th>${em.email}</th>
                        <th>${em.dept_name}</th>
                        <th>
                            <button class="btn btn-primary btn-sm">编辑</button>
                            <button class="btn btn-danger btn-sm">删除</button>
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </div>
    <%--分列--%>
    <div class="row">
        <div class="col-md-6">
            当前记录数:${pageInfo.pageNum}页,总共{pageInfo.pages}，总${pageInfo.total}记录
        </div>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="${APP_PATH }/emps?pn=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage }">
                        <li><a href="${APP_PATH }/emps?pn=${pageInfo.pageNum-1}"
                               aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                        </a></li>
                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="pagenum">
                        <c:if test="${pagenum == pageInfo.pageNum}">
                            <li class="active"><a href="#">${pagenum}</a></li>
                        </c:if>
                        <c:if test="${pagenum != pageInfo.pageNum}">
                            <li><a href="${APP_PATH}/emps?pn=${pagenum}">${pagenum}</a></li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${pageInfo.hasNextPage }">
                        <li><a href="${APP_PATH }/emps?pn=${pageInfo.pageNum+1 }"
                               aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                        </a></li>
                    </c:if>
                    <li><a href="${APP_PATH }/emps?pn=${pageInfo.pages}">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
