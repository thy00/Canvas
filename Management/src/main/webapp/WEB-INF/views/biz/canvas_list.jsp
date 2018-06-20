<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>油画列表</title>
        <link rel="stylesheet" href="../../../css/index.css">
        <link rel="stylesheet" href="../../../css/bootstrap.min.css">
    </head>

    <body>
        <header>
            <div class="container">
                <c:forEach items="${categories}" var="category">
                    <nav>
                        <a href="/canvas/list.do?categoryId=${category.id}" >${category.name}</a>
                    </nav>
                </c:forEach>
                    <nav>
                        <a href="#">欢迎您，${username}</a>
                        <a href="/loginPrompt.do">退出</a>
                        <%--<a href="#" onclick="alert('功能暂未开放');">注册</a>--%>
                        <a href="/canvas/list.do">全部油画</a>
                        <a href="/category/list.do">分类</a>
                    </nav>
            </div>
        </header>
        <section class="banner">
            <div class="container">
                <div>
                    <h1>油画</h1>
                    <p>油画列表</p>
                </div>
            </div>
        </section>
        <section class="main">
            <div class="container">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>名称</th>
                        <th>分类</th>
                        <th>价格</th>
                        <th>创建时间</th>
                        <th>最后修改时间</th>
                        <th>描述</th>
                        <th>编辑</th>
                        <th>删除</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${canvases}" var="canvas">
                            <tr>
                                <td>${canvas.name}</td>

                                <c:forEach items="${categories}" var="category">
                                    <c:if test="${category.id==canvas.categoryId}">
                                        <td>${category.name}</td>
                                    </c:if>
                                </c:forEach>

                                <td>￥<fmt:formatNumber type="currency" pattern="#,#00.00#" value="${canvas.price}"/></td>
                                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${canvas.createTime}"/></td>
                                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${canvas.updateTime}"/></td>
                                <td>${canvas.description}</td>
                                <td><a href="/canvas/updatePrompt.do?id=${canvas.id}">编辑</a></td>
                                <td><a href="/canvas/del.do?id=${canvas.id}">删除</a>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>
        <section class="page">
            <div class="container">
                <div id="fatie">
                    <a href="/canvas/addPrompt.do"><button>新建油画</button></a>
                </div>
            </div>
        </section>
        <footer>
            copy@慕课网
        </footer>
    </body>
</html>