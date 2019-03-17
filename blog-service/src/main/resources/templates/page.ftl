<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>成长之旅</title>
    <meta charset="UTF-8">
    <meta name="keywords" content="{{ keywords }}">
    <meta name="description" content="{{ description }}">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="author" content="Liyu, kissaoe@gmail.com">
    <meta name="copyright" content="Liyu">
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" type="text/css" href="/lib/bootstrap-3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/lib/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="/css/common.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="shortcut icon" href="https://heleeos.com/favicon.ico"/>
</head>
<body>
<div class="header">
    <a href="https://heleeos.com/" class="logo">
        <img class="logo-image" src="/image/logo.png"/>
    </a>
    <nav class="main-nav">
        <#--        <a class="main-nav-link" href="https://heleeos.com/">主页</a>-->
        <#--        <a class="main-nav-link" href="https://heleeos.com/time/">时间轴</a>-->
        <a class="main-nav-link" href="">技术干货</a>
        <a class="main-nav-link" href="">读书感悟</a>
        <a class="main-nav-link" href="">工具手册</a>
        <!--<a class="main-nav-link" href="https://heleeos.com/profile/index.html">关于我</a>-->
    </nav>
    <nav class="profile-nav hidden-lg">
        <img class="profile-image" src="https://static.heleeos.com/blog-web/image/profile.jpg">
        <a href="javascript:"><i class="fa fa-caret-down"></i></a>
    </nav>
</div>
<div class="container-fluid">
    <div class="left visible-lg-inline-block col-lg-3">
        <div class="card">
            <img class="profile-image" src="https://static.heleeos.com/blog-web/image/profile.jpg">
            <p class="profile-name">李瑜</p>
            <p class="profile-info">爱生活，爱学习，更爱写代码<br>爱折腾的全栈开发工程师<br>前端，后台，运维</p>
            <p class="profile-location"><i class="fa fa-map-marker"></i>中国 - 上海</p>
            <a class="profile-button btn" href="https://github.com/greenfit" target="_blank">Follow</a>
            <div class="profile-other">
                <a href="https://git.oschina.net/IP" target="_blank"><i class="fa fa-git"></i></a>
                <a href="https://codepen.io/greenfit/" target="_blank"><i class="fa fa-codepen"></i></a>
                <a href="https://www.freecodecamp.com/greenfit" target="_blank"><i class="fa fa-free-code-camp"></i></a>
                <a href="mailto:kissaoe@gmail.com?subject=I Love You~" target="_blank"><i class="fa fa-envelope"></i></a>
                <a href="https://www.facebook.com/profile.php?id=100010520951879" target="_blank"><i class="fa fa-facebook"></i></a>
            </div>
        </div>
        <h3>微信订阅号</h3>
        <img src="https://static.heleeos.com/blog-web/image/qrcode.jpg">
    </div>
    <div class="main col-xs-12 col-sm-9 col-md-9 col-lg-7">
        <#list blogList as blog>
            <div class="card">
                <h1 class="title"><a href="/blog/${blog.displayUrl}.html">${blog.blogTitle}</a></h1>
                <div class="meta">
                    <div class="time"><i class="fa fa-calendar"></i>${blog.createTime?string('yyyy-MM-dd hh:mm:ss')}
                    </div>
                    <div class="type" style="float:none"><i class="fa fa-folder"></i>${blog.blogType}</div>
                </div>
                <div class="info">${blog.blogSummary}</div>
                <hr>
                <div class="tags"><i class="fa fa-tag"></i>${blog.blogTags}</div>
                <div class="readCount"><i class="fa fa-bookmark"></i>${blog.readCount}次</div>
                <#if (blog.sortIndex > 0) >
                    <img class="tj" src="https://static.heleeos.com/blog-web/image/tj.png">
                </#if>
            </div>
        </#list>
        <div class="page-nav">
            <#if (page > 1)>
                <a class="page-number" href="/page/${page - 1}.html">« 上一页</a>
            </#if>
            <#if (page - 1 > 5)>
                <a class="page-number" href="/page/1.html">1</a><span class="space">…</span>
            </#if>
            <#list (page - 4)..(page + 4) as number>
                <#if (number > 0) && (number <= max)>
                    <#if page == number>
                        <span class="page-number current" href="page-${number}.html">${number}</span>
                    <#else>
                        <a class="page-number" href="/page/${number}.html">${number}</a>
                    </#if>
                </#if>
            </#list>
            <#if (max - page > 5)>
                <span class="space">…</span><a class="page-number" href="/page/${max}.html">${max}</a>
            </#if>
            <#if (page < max)>
                <a class="page-number" href="/page/${page + 1}.html">下一页 »</a>
            </#if>
        </div>

    </div>
    <div class="right hidden-xs col-sm-3 col-md-3 col-lg-2">
        <h3>公告</h3>
        <div class="card">
            <div class="info">网站改版升级中...</div>
        </div>
        <h3>标签</h3>
        <div class="tags">
            <a href="">Spring</a>
            <a href="">Spring Bean</a>
            <a href="">Spring MVC</a>
            <a href="">MySQL</a>
            <a href="">Java8</a>
            <a href="">JVM</a>
            <a href="">AOP</a>
        </div>
        <div class="catalog">
            <span class="sidebar-scrollbar"></span>
            <ul class="catalog-content"></ul>
        </div>
    </div>
</div>
<div class="footer">成长之旅 | 2017 ~ 2019
    <div class="beian">
        <p class="icp">豫ICP备 17009313 号 | 邮箱: <a href="mailto:kissaoe@gmail.com?subject=I Love You~"
                                                 target="_blank">kissaoe@gmail.com</a></p>
        <a class="beian-link" target="_blank"
           href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=41072102000352">
            <img style="float: left;" src="https://static.heleeos.com/blog-web/image/beian.png"/>
            <p class="beian-title">豫公网安备 41072102000352 号</p>
        </a>
    </div>
</div>
</body>
</html>
