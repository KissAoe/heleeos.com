<template>
	<Card>
        <p slot="title">
            <Icon type="paper-airplane"></Icon>发布选项
        </p>
        <p class="margin-top-10">
            <Icon type="ios-calendar-outline"></Icon>
            <span v-if="publishTimeType === 'immediately'">立即发布</span><span v-else>定时：{{ publishTime }}</span>
            <Button v-show="!editPublishTime" size="small" @click="handleEditPublishTime" type="text">修改</Button>
            <transition name="publish-time">
                <div v-show="editPublishTime" class="publish-time-picker-con">
                    <div class="margin-top-10">
                        <DatePicker :options="dateOptions" @on-change="setPublishTime" type="datetime" style="width:200px;" placeholder="选择日期和时间" ></DatePicker>
                    </div>
                    <div class="margin-top-10">
                        <Button type="primary" @click="handleSavePublishTime">确认</Button>
                        <Button type="ghost" @click="cancelEditPublishTime">取消</Button>
                    </div>
                </div>
            </transition>
        </p>
        <p class="margin-top-10">
            <Icon type="android-time"></Icon>
            <span>发布状态:</span>
            <Select size="small" style="width:90px" value="草稿">
                <Option value="草稿"></Option>
                <Option value="待发布"></Option>
            </Select>
        </p>
        <p class="margin-top-10">
            <Icon type="android-time"></Icon>
            <span>自动保存:</span>
            <Progress class="publish-time" :percent="progress" status="active" hide-info></Progress>
        </p>
        <Row class="margin-top-20 publish-button-con">
            <span class="publish-button"><Button @click="handleSaveCache" type="dashed">暂存缓存</Button></span>
            <span class="publish-button"><Button @click="handleDeleteCache" type="warning">删除缓存</Button></span>
        </Row>
        <Row class="margin-top-20">
            <span class="publish-button"><Button @click="handlePreview" type="ghost">预览发布</Button></span>
            <span class="publish-button"><Button @click="handlePublish" :loading="publishLoading" icon="ios-checkmark" type="primary" style="width:80px">发布</Button></span>
        </Row>
    </Card>
</template>
<script>
export default {
    name: 'blog-options',
    data () {
        return {
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
