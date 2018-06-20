<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>详情</title>
    <link rel="stylesheet" type="text/css" href="../../../style/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../../style/detail.css"/>
    <!--<link rel="stylesheet" type="text/css" href="style/reset.css" />
        <link rel="stylesheet" type="text/css" href="style/style.css" />-->
</head>

<body class="bgf8">
<jsp:include page="header.jsp"></jsp:include>
<div class="section" style="margin-top:20px;">
    <div class="width1200">
        <div class="fl" style="width: 60%;height: 400px"><img src="/canvas/getImg.do?id=${canvas.id}" width="100%" height="100%"/></div>
        <div class="fl sec_intru_bg" style="width: 27%;height: 337px">
            <dl>
                <dt>${canvas.name}</dt>
                <dd>
                    <p>发布人：<span>${canvas.creator}</span></p>
                    <p>发布时间：<span><fmt:formatDate pattern="yyyy-MM-dd" value="${canvas.createTime}"/></span></p>
                    <p>修改时间：<span><fmt:formatDate pattern="yyyy-MM-dd" value="${canvas.updateTime}"/></span></p>
                </dd>
            </dl>
            <ul>
                <li>售价：<br/><span class="price">${canvas.price}</span>元</li>
            </ul>
        </div>
    </div>
</div>
<div class="secion_words">
    <div class="width1200">
        <div class="secion_wordsCon">
            ${canvas.details}
        </div>
    </div>
</div>
</div>
    <div class="footer">
        <p><span>M-GALLARY</span>©2017 POWERED BY IMOOC.INC</p>
    </div>
</div>
</body>
</html>
