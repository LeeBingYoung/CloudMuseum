<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<c:set var="proPath" value="${pageContext.request.contextPath}" />
<html>
    <head>
        <title>首页</title>
        <link href="${proPath}/static/css/bootstrap.min.css" rel="stylesheet">
        <script src="${proPath}/static/js/jquery.min.js"></script>
        <script src="${proPath}/static/js/bootstrap.min.js"></script>
        <style type="text/css">
            .input-group{
                padding:10px 5px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <div class="row">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="col-md-3 col-sm-2 navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="#">Brand</a>
                        </div>
                        <div class="form-group collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <div class="col-md-6 col-sm-7">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="请输入关键字……"  autofocus >
                                    <span class="input-group-addon btn btn-default" id="home_search">
                                             <span class="glyphicon glyphicon-search" ></span>
                                        </span>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-3" >
                                <ul class="nav navbar-nav navbar-right" id="bar01">
                                    <li><a href="${proPath}/toLogin.action"><span class="text-info">登录</span></a></li>
                                    <li><a href="${proPath}/toRegister.action"><span class="text-info">注册</span> </a></li>
                                </ul>
                                <ul class="nav navbar-nav navbar-right" id="bar02" hidden="hidden">
                                    <li><a>欢迎你！${sessionScope.user.name}</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
    </body>
</html>