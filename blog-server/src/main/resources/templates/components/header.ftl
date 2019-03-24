<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <#if title??>
        <title>${title}</title>
    <#else>
        <title>成长之旅</title>
    </#if>
    <meta charset="UTF-8">
<#--    <meta name="keywords" content="{{ keywords }}">-->
<#--    <meta name="description" content="{{ description }}">-->
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
<div class="header">
    <a href="https://heleeos.com/" class="logo">
        <img class="logo-image" src="/image/logo.png"/>
    </a>
    <nav class="main-nav">
        <a class="main-nav-link" href="/">主页</a>
        <#--        <a class="main-nav-link" href="https://heleeos.com/time/">时间轴</a>-->
        <#--        <a class="main-nav-link" href="">技术干货</a>-->
        <#--        <a class="main-nav-link" href="">读书感悟</a>-->
        <#--        <a class="main-nav-link" href="">工具手册</a>-->
        <!--<a class="main-nav-link" href="https://heleeos.com/profile/index.html">关于我</a>-->
    </nav>
    <nav class="profile-nav hidden-lg">
        <img class="profile-image" src="/image/profile.jpg">
        <a href="javascript:"><i class="fa fa-caret-down"></i></a>
    </nav>
</div>