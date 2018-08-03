<style lang="less">
    @import '../../styles/common.less';
</style>

<template>
    <div>
        <Row>
            <Card>
                <Table border :columns="blogColumns" :data="blogData" :loading="blogLoading"></Table>
                list
            </Card>
        </Row>
    </div>
</template>

<script>
import api from '@/libs/api';
import axios from 'axios';

export default {
    name: 'workflow',
    data () {
        return {
            blogLoading: true,
            blogData: [],
            blogColumns: [{
                        title: '文章ID',
                        key: 'id'
                    },
                    {
                        title: '文章标题',
                        key: 'blogTitle',
                        ellipsis: true
                    },
                    {
                        title: '显示URL',
                        key: 'displayURL',
                        ellipsis: true
                    },
                    {
                        title: '创建时间',
                        key: 'createTime'
                    },
                    {
                        title: '更新时间',
                        key: 'updateTime'
                    }, 
                    {
                        title: '操作',
                        key: 'action',
                        width: 150,
                        align: 'center',
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '5px'
                                    },
                                    on: {
                                        click: () => {
                                            let query = {blog_id : params.row.id};
                                            this.$router.push({
                                                name: 'blog-publish',
                                                query: query
                                            });
                                        }
                                    }
                                }, '编辑'),
                                h('Button', {
                                    props: {
                                        type: 'error',
                                        size: 'small'
                                    },
                                    on: {
                                        click: () => {
                                            this.remove(params.index)
                                        }
                                    }
                                }, '删除')
                            ]);
                        }
                    }]
        };
    },
    methods: {
        loadBlogList () {
            var self = this;
            axios.get(api.getBlogList, {params : {'rows' : 6, 'statue' : 20}}).then(function(response) {
                var result = response.data;
                if(result.code == 200) {
                    self.blogData = result.data.beans;
                } else {
                    self.$Message.error('加载列表失败, 原因:' + result.message);
                }
                self.blogLoading = false;
            }).catch(function (error) {
                console.log(error);
                self.blogLoading = false;
            });
        }
    },
    mounted () {
        this.loadBlogList();
    }
};
</script>
