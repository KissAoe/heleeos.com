<#include "components/header.ftl" />
<div class="container-fluid">
    <#include "components/left.ftl" />
    <div class="main col-xs-12 col-sm-9 col-md-9 col-lg-7">
        <#if blogList??>
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
            <#else>
                <p>内容为空</p>
        </#if>
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
    <#include "components/right.ftl" />
</div>
<#include "components/foot.ftl" />