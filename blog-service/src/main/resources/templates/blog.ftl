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
    <link rel="stylesheet" type="text/css" href="/css/blog.css">
    <link rel="shortcut icon" href="https://heleeos.com/favicon.ico"/>
</head>
<body>
<div class="app">
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
        <div class="main col-xs-12 col-sm-9 col-md-9 col-lg-10">
            <div class="card">
                <h1 class="title"><a>{{blog.blogTime}}</a></h1>
                <div class="meta">
                    <div class="time"><i class="fa fa-calendar"></i>{{datetime blog.createTime}}</div>
                    <div class="type"><i class="fa fa-folder"></i>{{blog.blogType}}</div>
                    <div class="count"><i class="fa fa-bookmark"></i>{{blog.readCount}} 次</div>
                    <div class="tag"><i class="fa fa-tags"></i>{{{splitTags blog.blogTags}}}</div>
                </div>
                <div class="info">摘要:{{blog.blogSummary}}</div>
                <hr>
                <div class="blog-body">
                    ${blogBody}
                </div>
                <div class="blog-copy-info">
                    <p>以上内容是在下的一点愚见，有任何不对的地方，欢迎指出。</p>
                    <p>欢迎任何形式的转载，但请务必注明出处。</p>
                    <p>转载请注明：文章转载自 黑老李的博客[<a href="https://heleeos.com/blog/{{blog.dispUrl}}.html">https://heleeos.com</a>]</p>
                    <p>本文标题：{{blog.blogTitle}}</p>
                    <p>本文地址：https://heleeos.com/blog/{{blog.dispUrl}}.html</p>
                </div>
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
    <div class="footer">成长之旅 | 2017 ~ 2019 &copy;<a href="https://heleeos.com/profile/" target="_blank">李瑜</a>
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
</div>
</body>
</html>
