<template>
    <Card>
        <Form :label-width="80">
            <FormItem label="文章标题">
                <Input v-model="blog.blogTitle" @on-blur="handleBlogBlur" icon="android-list"/>
            </FormItem>

            <FormItem label="文章路径">
                <Input v-model="blog.displayUrl" @on-blur="handleBlogBlur" icon="ios-pulse-strong"/>
            </FormItem>

            <FormItem label="内容类型">
                <RadioGroup v-model="blog.contentType" type="button" size="large">
                    <Radio label="0">Html</Radio>
                    <Radio label="1">MarkDown</Radio>
                </RadioGroup>
            </FormItem>
        </Form>

        <div class="margin-top-20" v-bind:class="{ notDisplay: !showHTML}">
            <textarea id="articleEditor"></textarea>
        </div>

        <div class="markdown-con" v-bind:class="{ notDisplay: showHTML}">
             <textarea id="markdownEditor"></textarea> 
        </div>

    </Card>
</template>
<script>
export default {
    name: 'blog-edit',
    data () {
        return {
            blog: {
                title: '',
                path: '',
                type: 'MarkDown',
                info: ''
            },
            publishTime: '',
            publishTimeType: 'immediately',
            publishLoading: false,
            editPublishTime: false,
            simplemde: '',
            dateOptions: {
                disabledDate (date) {
                    return date && date.valueOf() < Date.now();
                }
            },
            progress: 0
        };
    },
    methods: {
        handleBlogBlur () {
            if (this.blog.blogTitle.length == 0) {
                this.$Message.error('文章标题不可为空');
                return false;
            }

            if (this.blog.displayUrl.length == 0) {
                this.$Message.error('文章路径不可为空');
                return false;
            }

            if(this.articleType == 'HTML') {
                this.blog.info = tinymce.activeEditor.getContent();
            } else {
                this.blog.info = this.simplemde.value();
            }

            if(this.blog.info.length == 0) {
                this.$Message.error('文章内容不可为空');
                return false;
            }

            return true;
        },
        handleEditPublishTime () {
            this.editPublishTime = !this.editPublishTime;
        },
        handleSavePublishTime () {
            this.publishTimeType = 'timing';
            this.editPublishTime = false;
        },
        cancelEditPublishTime () {
            this.publishTimeType = 'immediately';
            this.editPublishTime = false;
        },
        setPublishTime (datetime) {
            this.publishTime = datetime;
        },
        handlePreview () {
            if (this.handleBlogBlur()) {
                localStorage.blog = JSON.stringify(this.blog);
                this.$router.push({
                    name: 'preview'
                });
            }
        },
        timeSaveCache() {
            if(localStorage.currentPageName == 'blog-publish') {
                this.progress = this.progress + 1;
                if(this.progress >= 100) {
                    this.progress = 0;
                    this.handleSaveCache();
                }
                setTimeout(() => {this.timeSaveCache()}, 500)
            }
        },
        handleSaveCache () {
            if (this.handleBlogBlur()) {
                localStorage.blog = JSON.stringify(this.blog);
                this.$Notice.success({
                    title: '缓存保存成功',
                    desc: '文章《' + this.blog.title + '》保存成功'
                });
            }
        },
        handleDeleteCache () {
            localStorage.blog = "";
            this.$Notice.success({
                title: '缓存删除成功',
                desc: '缓存删除成功'
            });
        },
        handlePublish () {
            if (this.handleBlogBlur()) {
                this.publishLoading = true;
                setTimeout(() => {
                    this.publishLoading = false;
                    this.$Notice.success({
                        title: '保存成功',
                        desc: '文章《' + this.blog.title + '》保存成功'
                    });
                }, 3000);
            }
        }
    },
    computed: {
        showHTML () {
            return this.blog.contentType == 0;
        },
        showMarkDown() {
            return this.blog.contentType == 1;
        }
    },
    mounted () {
        //this.init();
    },
    destroyed () {
        tinymce.get('articleEditor').destroy();
    }
};
</script>
    