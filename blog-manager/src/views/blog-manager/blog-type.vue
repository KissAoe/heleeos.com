<style lang="less">
    @import '../../styles/common.less';
    @import './blog-type.less';
</style>

<template>
    <div>
        <Row :gutter="10">
            <Col span="6">
                <Card>
                    <Tree ref="tree" :data="blogTypes" :load-data="loadBlogType" @on-select-change="selectChange"></Tree>
                </Card>
            </Col>
            <Col span="18">
                <Card>
                    选中的节点: {{selectNode.title}}
                    <table>
                        <thead>
                            <tr>
                                <th>节点ID</th>
                                <th>节点名称</th>
                                <th>节点状态</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>{{selectNode.nodeKey}}</td>
                                <td>{{selectNode.title}}</td>
                                <td>{{selectNode.data}}</td>
                            </tr>
                        </tbody>
                    </table>
                </Card>
            </Col>
        </Row>
    </div>
</template>

<script>
import api from '@/libs/api';

export default {
    name: 'blogType',
    data() {
        return {
            blogTypes: [{
                nodeKey: 0,
                title: '文章分类',
                loading: false,
                children: []
            }],
            selectNode: {}
        }
    },
    methods: {
        loadBlogType(item, callback) {
            let self = this;
            let params = {parentId: item.nodeKey};
            api.ajax.get(api.getBlogTypeList, {params: params}).then(response => {
                var result = response.data;
                if(result.code == 200) {
                    let data = self.transformBlogType(result.data);
                    callback(data);
                } else {

                }
            }).catch(error => {
                console.log(error);
            });
        },
        transformBlogType(array) {
            return array.map(function(type){
                return {
                    nodeKey: type.id,
                    title: type.typeName,
                    loading: false,
                    children: [],
                    data: type
                }
            });
        },
        selectChange(node) {
            if(node !== undefined && node.length > 0) {
                this.selectNode = node[0];
            } else {
                this.selectNode = {};
            }
        }
    }
};
</script>
