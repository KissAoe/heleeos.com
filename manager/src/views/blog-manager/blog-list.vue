<style lang="less">
    @import '../../styles/common.less';
    @import './blog-list.less';
</style>

<template>
    <div>
        <Row>
            <Table border :columns="blogColumns" :data="blogData" :loading="blogLoading"></Table>
        </Row>
        <Row class="pageDiv">
            <Select v-model="queryParam.rows" style="width:60px" @on-change="loadBlogList()">
                <Option v-for="item in rowList" :value="item.value" :key="item.value">{{ item.label }}</Option>
            </Select>
            <Button>首页</Button>
            <Button @click="changePage(-1)">上一页</Button>
            <ButtonGroup>
                <Button  v-for="button in buttons"
                         :key="button"
                         :type="button == queryParam.page ? 'info' : 'default'"
                         @click=""
                         >
                    {{button}}
                </Button>
            </ButtonGroup>
            <Button @click="changePage(1)">下一页</Button>
            <Button>尾页</Button>
        </Row>
    </div>
</template>

<script>
import api from '@/libs/api';

export default {
    name: 'workflow',
    data () {
        return {
            queryParam: {
                page: 1,
                rows: 5,
                count: 0
            },
            rowList: [{
                value: '5',
                label: '5条'
            }, {
                value: '7',
                label: '7条'
            }, {
                value: '10',
                label: '10条'
            }, {
                value: '15',
                label: '15条'
            }],
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
    computed: {
        buttons: function() {
            return [1,2,3];
        }
    },
    methods: {
        loadBlogList () {
            var self = this;
            api.ajax(api.getBlogList, {params : this.queryParam}).then(function(response) {
                var result = response.data;
                if(result.code == 200) {
                    self.blogData = result.data.beans;
                    self.queryParam.count = result.data.count;
                } else {
                    self.$Message.error('加载列表失败, 原因:' + result.message);
                }
                self.blogLoading = false;
            }).catch(function (error) {
                self.$Message.error('服务器开小差了, 请稍后重试!');
                self.blogLoading = false;
            });
        },
        changePage(change) {
            this.queryParam.page = this.queryParam.page + change;
            this.loadBlogList();
        },
        setPage(pageNumber) {
            this.queryParam.page = pageNumber;
            this.loadBlogList();
        }
    },
    mounted () {
        this.loadBlogList();
    }
};
</script>
