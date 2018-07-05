<style lang="less">
    @import '../../styles/common.less';
    @import './preview.less';
</style>

<template>
    <div class="preview-main">
        <div>
            <Card>
                <h1>{{ blog.title }}</h1>
                <p class="preview-publish-time"><Icon type="android-alarm-clock"></Icon>&nbsp;发布时间：{{ publishTime }}</p>
                <div class="preview-content" v-html="blog.info"></div>
            </Card>
        </div>
    </div>
</template>

<script>
import SimpleMDE from 'simplemde';
import showdown from 'showdown'
export default {
    data () {
        return {
            blog: '',
            publishTime: ''
        };
    },
    mounted () {
        this.blog = JSON.parse(localStorage.blog);
        if(this.blog.type == "MarkDown") {
            var converter = new showdown.Converter();
            converter.setFlavor('github'); 
            this.blog.info = converter.makeHtml(this.blog.info);
        }
        this.publishTime = localStorage.publishTime;
    }
};
</script>
