<style lang="less">
    @import './login.less';
</style>

<template>
    <div class="login" @keydown.enter="handleSubmit">
        <div class="login-con">
            <Card :bordered="false">
                <p slot="title">
                    <Icon type="log-in"></Icon> 欢迎使用
                </p>
                <div class="form-con">
                    <Form ref="loginForm" :model="loginInfo" :rules="rules">
                        <FormItem prop="userName">
                            <Input v-model="loginInfo.userName" placeholder="请输入用户名">
                                <span slot="prepend">
                                    <Icon :size="16" type="person"></Icon>
                                </span>
                            </Input>
                        </FormItem>
                        <FormItem prop="password">
                            <Input type="password" v-model="loginInfo.passWord" placeholder="请输入密码">
                                <span slot="prepend">
                                    <Icon :size="14" type="locked"></Icon>
                                </span>
                            </Input>
                        </FormItem>
                        <FormItem>
                            <Button @click="handleSubmit" type="primary" long>登录</Button>
                        </FormItem>
                    </Form>
                    <p class="login-tip">{{loginInfo.loginTip}}</p>
                </div>
            </Card>
        </div>
    </div>
</template>

<script>
import api from '@/libs/api';
import Cookies from 'js-cookie';

export default {
    data () {
        return {
            loginInfo: {
                userName: '',
                passWord: '',
                loginTip: ''
            },
            rules: {
                userName: [
                    { required: true, message: '账号不能为空', trigger: 'blur' }
                ],
                passWord: [
                    { required: true, message: '密码不能为空', trigger: 'blur' }
                ]
            }
        };
    },
    methods: {
        handleSubmit () {
            this.loginInfo.loginTip = "";
            this.$refs.loginForm.validate((valid) => {
                if (valid) {
                    var self = this;
                    api.ajax(api.login, {params : this.loginInfo}).then(response => {
                        var result = response.data;
                        console.log(result);
                        if(result.code == 200) {
                            localStorage.managerInfo = JSON.stringify(result.data);
                            // self.$store.commit('setManager', JSON.stringify(result.data));
                            self.$router.push({name: 'home_index'});
                        } else {
                            self.loginInfo.loginTip = result.message;
                        }
                    }).catch(error => {
                        self.loginInfo.loginTip = "服务器开小差了, 请稍后重试~";
                    });
                }
            });
        }
    }
};
</script>
