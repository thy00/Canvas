<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="../../../style/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../../style/index.css"/>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="content">
    <div class="banner">
        <img class="banner-img" src="../../../image/welcome.png" width="732px" height="372" alt="图片描述">
    </div>
    <div class="auth fr">
        <ul>
            <c:forEach items="${categories}" var="category">
                <span><a href="/canvas/list.do?page=${page}&categoryId=${category.id}">${category.name}</a></span>&nbsp;&nbsp;&nbsp;&nbsp;
            </c:forEach>
        </ul>
    </div>
    <div class="img-content">
        <ul>
            <c:forEach items="${canvases}" var="canvas">
                <li>
                    <img class="img-li-fix" src="/canvas/getImg.do?id=${canvas.id}" alt="${canvas.name}" style="height:45%">
                    <div class="info">
                        <h3 class="img_title">${canvas.name}</h3>
                        <p style="height: 20%">
                                ${canvas.description}
                        </p>
                        <div class="btn">
                            <a href="/canvas/detail.do?id=${canvas.id}" class="edit">详情</a>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="page-nav">
        <ul>
            <li><a href="/canvas/list.do?page=1&categoryId=${categoryId}">首页</a></li>
            <c:if test="${page!=1}">
                <li><a href="/canvas/list.do?page=${page-1}&categoryId=${categoryId}">上一页</a></li>
            </c:if>
            <c:if test="${page==1}">
                <li><a href="javascript:void(0)">上一页</a></li>
            </c:if>
            <c:forEach begin="1" end="${totalPage}" var="p">
                <c:if test="${p==page}">
                    <li><span class="first-page">${p}</span></li>
                </c:if>
                <c:if test="${p!=page}">
                    <li><a href="/canvas/list.do?page=${p}&categoryId=${categoryId}">${p}</a></li>
                </c:if>
            </c:forEach>
            <c:if test="${page!=totalPage}">
                <li><a href="/canvas/list.do?page=${page+1}&categoryId=${categoryId}">下一页</a></li>
            </c:if>
            <c:if test="${page==totalPage}">
                <li><a href="javascript:void(0)">下一页</a></li>
            </c:if>
            <li><a href="/canvas/list.do?page=${totalPage}&categoryId=${categoryId}">尾页</a></li>
        </ul>
    </div>
</div>

<div class="footer">
    <p><span>M-GALLARY</span>©2017 POWERED BY IMOOC.INC</p>
</div>
</body>
</html>