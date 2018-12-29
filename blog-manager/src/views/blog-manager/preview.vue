<style lang="less">
    @import '../../styles/common.less';
    @import './preview.less';
</style>

<template>
    <div class="preview-main">
        <div>
            <Card>
                <h1>{{ blog.blogTitle }}</h1>
                <p class="preview-publish-time"><Icon type="android-alarm-clock"></Icon>&nbsp;发布时间：{{ publishTime }}</p>
                <div class="preview-content" v-html="blog.blogContent"></div>
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
            blog: {
                id: 0,
                blogTitle: '',
                displayUrl: '',
                blogContent: ''
            },
            publishTime: ''
        };
    },
    methods: {
        loadBlog() {
            let blogId = this.$route.query.blogId;
            this.blog = JSON.parse(localStorage.getItem("tempBlog_" + blogId));
            console.log(this.blog);

            var converter = new showdown.Converter();
            converter.setFlavor('github'); 
            this.blog.blogContent = converter.makeHtml(this.blog.blogContent);
        }
    },
    mounted () {
        this.publishTime = localStorage.publishTime;
    },
    beforeRouteEnter(to,from,next) {
        next(vm => vm.loadBlog());
    },
};
</script>
