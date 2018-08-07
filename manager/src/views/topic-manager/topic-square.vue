<style lang="less">
    @import '../../styles/common.less';
    @import './topic-square.less';
</style>

<template>
	<div class="square">
        <Row>
			<Card class="topic" :bordered="false" v-for="note in noteList" :key="note.id">
				<p slot="title">
					<Row>
						<span>{{note.title}}</span>
						<span class="title-time">{{note.createTime}}</span>
					</Row>
				</p>
				<p v-html="note.content"></p>
			</Card>
        </Row>

		<div>loadMore</div>
    </div>
</template>
<script>
import api from '@/libs/api';

export default {
    name: 'topicSquare',
    data () {
        return {
            queryParam: {
                page: 1,
                rows: 5
			},
			noteList: []
        };
    },
    methods: {
        loadTopicList () {
            var self = this;
            api.ajax(api.getTopicList, {params : this.queryParam}).then(function(response) {
                var result = response.data;
                if(result.code == 200) {
					self.noteList = result.data;
					console.log(result.data)
                } else {
                    self.$Message.error('加载列表失败, 原因:' + result.message);
                }
            }).catch(function (error) {
                self.$Message.error('服务器开小差了, 请稍后重试!');
            });
        }
    },
    mounted () {
        this.loadTopicList();
    }
}
</script>