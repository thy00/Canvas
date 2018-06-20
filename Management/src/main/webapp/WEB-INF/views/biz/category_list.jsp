<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>油画分类列表</title>
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
                    <h1>油画分类</h1>
                    <p>油画分类列表</p>
                </div>
            </div>
        </section>
        <section class="main">
            <div class="container">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>名称</th>
                        <th>创建时间</th>
                        <th>最后修改时间</th>
                        <th>描述</th>
                        <th>编辑</th>
                        <th>删除</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${categories}" var="category">
                            <tr>
                                <td>${category.name}</td>
                                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${category.createTime}"/></td>
                                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${category.updateTime}"/></td>
                                <td>${category.description}</td>
                                <td><a href="/category/updatePrompt.do?id=${category.id}">编辑</a></td>
                                <td><a href="/category/del.do?id=${category.id}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>
        <section class="page">
            <div class="container">
                <div id="fatie">
                    <a href="/category/addPrompt.do"><button>新建分类</button></a>
                </div>


                <!-- <div id="pagefy">
                    <ul>
                        <form id="messageForm" action="#" method="post">
                            <input type="hidden" id="page" name="page" value="3">
                            <input type="hidden" id="last" name="last" value="1">
                            <li><a href="#" onclick="submitMessageForm('first')">首页</a></li>
                            <li><a href="#" onclick="submitMessageForm('pre')">上一页</a></li>
                            <li><a href="#">当前第1页</a></li>
                            <li><a href="#" onclick="submitMessageForm('next')">下一页</a></li>
                            <li><a href="#" onclick="submitMessageForm('last')">尾页</a></li>
                        </form>
                    </ul>
                </div> -->
            </div>
        </section>
        <footer>
            copy@慕课网
        </footer>
    </body>
</html>