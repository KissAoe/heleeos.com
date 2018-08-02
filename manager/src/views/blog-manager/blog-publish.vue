<style lang="less">
    @import '../../styles/common.less';
    @import './blog-publish.less';
</style>

<template>
    <div>
        <Row>
            <Col span="18">
                <blogEdit v-bind:blog="blogInfo"></blogEdit>
            </Col>
            <Col span="6" class="padding-left-10">
                <blogOptions v-bind:blog="blogInfo"></blogOptions>
            </Col>
        </Row>
    </div>
</template>

<script>
import api from '@/libs/api';
import axios from 'axios';
import tinymce from 'tinymce';
import SimpleMDE from 'simplemde';
import './simplemde.min.css';

import blogOptions from './components/blog-options.vue';
import blogEdit from './components/blog-edit.vue';

export default {
    name: 'artical-publish',
    components: {
        blogOptions,
        blogEdit
    },
    data () {
        return {
            blogInfo: {
                title: '',
                path: '',
                type: 'MarkDown',
                info: ''
            }
        };
    },
};
</script>
