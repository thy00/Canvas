<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>编辑</title>
        <link rel="stylesheet" href="../../../css/bootstrap.min.css">
        <link rel="stylesheet" href="../../../css/add.css">
    </head>
    <body>
    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">
                    慕课网油画管理
                </a>
            </div>
        </div>
    </nav>
    <div class="container">
        <div class="jumbotron">
            <h1>Hello, ${username}!</h1>
            <p>请小心的编辑油画记录</p>
        </div>
        <div class="page-header">
            <h3><small>编辑</small></h3>
        </div>
        <form class="form-horizontal" action="/canvas/update.do" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">名称 ：</label>
                <div class="col-sm-8">
                    <input type="text" name="name" class="form-control" id="name" value="${canvas.name}">
                    <input type="hidden" name="id" value="${canvas.id}">
                </div>
            </div>

            <div class="form-group">
                <label for="categoryId" class="col-sm-2 control-label">分类 ：</label>
                <select id="categoryId" name="categoryId" class="col-sm-8 form-control" style="width: auto">
                    <c:forEach items="${categories}" var="category">
                        <c:if test="${category.id!=canvas.categoryId}">
                            <option id="001" value="${category.id}">${category.name}</option>
                        </c:if>
                        <c:if test="${category.id==canvas.categoryId}">
                            <option id="001" value="${category.id}" selected="selected">${category.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="creator" class="col-sm-2 control-label">作者 ：</label>
                <div class="col-sm-8">
                    <input name="creator" type="text" class="form-control" id="creator" value="${canvas.creator}">
                </div>
            </div>
            <div class="form-group">
                <label for="price" class="col-sm-2 control-label">价格 ：</label>
                <div class="col-sm-8">
                    <input name="price" type="number" class="form-control" id="price" value="${canvas.price}">
                </div>
            </div>
            <div class="form-group">
                <label for="smallImg" class="col-sm-2 control-label">图片 ：</label>
                <div class="col-sm-8">
                    <input id="smallImg" name="smallImg" class="file-loading"
                           type="file" multiple accept=".jpg,.jpeg,.png" data-min-file-count="1"
                           data-show-preview="true" value="${canvas.smallImg}" >
               </div>
                <p style="color: red">图片请小于400kb</p>
           </div>

            <div class="form-group">
                <label for="description" class="col-sm-2 control-label">描述 ：</label>
                <div class="col-sm-8">
                    <input name="description" type="text" class="form-control" id="description" value="${canvas.description}">
               </div>
            </div>

            <div class="form-group">
                <label for="details" class="col-sm-2 control-label">细节 ：</label>
                <div class="col-sm-8">
                    <input name="details" type="text" class="form-control" id="details" value="${canvas.details}">
               </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
                </div>
            </div>
        </form>
    </div>
<footer class="text-center" >
    copy@imooc
</footer>
</body>
</html>
