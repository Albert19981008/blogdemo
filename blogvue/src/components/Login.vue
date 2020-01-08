<template>
    <el-form :rules="rules" class="login-container" label-position="left" :model="loginForm"
             label-width="0px" v-loading="loading">
        <h3 class="login_title">系统登录（注册）</h3>
        <el-form-item prop="username">
            <el-input type="text" v-model="loginForm.username"
                      auto-complete="off" placeholder="账号"></el-input>
        </el-form-item>
        <el-form-item prop="password">
            <el-input type="password" v-model="loginForm.password"
                      auto-complete="off" placeholder="密码"></el-input>
        </el-form-item>
        <el-checkbox class="login_remember" v-model="checked"
                     label-position="left">记住密码
        </el-checkbox>
        <el-form-item style="width: 100%">
            <el-button type="primary" style="width: 100%" @click="submitLogin">登录</el-button>
        </el-form-item>
        <el-form-item style="width: 100%">
            <el-button type="primary" style="width: 100%" @click="submitSignUp">注册</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        name: "Login",
        data() {
            return {
                rules: {
                    username: [{required: true, message: '请输入用户名', trigger: 'blur'}],
                    password: [{required: true, message: '请输入密码', trigger: 'blur'}]
                },
                checked: true,
                loginForm: {
                    username: 'root',
                    password: 'root'
                },
                loading: false
            }
        },
        methods: {
            submitLogin: function () {
                let _this = this;
                this.loading = true;
                _this.$store.commit('logout');
                this.postRequest('/login', {
                    username: this.loginForm.username,
                    password: this.loginForm.password
                }).then(resp=> {
                    _this.loading = false;
                    const json = resp.data;
                    window.console.log(json);
                    if (resp.status === 200) {
                        _this.$router.replace({path: '/home'});
                        _this.$store.commit('login', json.obj);
                    } else {
                        //失败
                        _this.$alert('登录失败!', '失败!');
                    }
                    // eslint-disable-next-line no-unused-vars
                }, resp=> {
                    _this.loading = false;
                    _this.$alert('找不到服务器⊙﹏⊙∥!', '失败!');
                });
            },
            submitSignUp: function () {
                let _this = this;
                this.loading = true;
                this.postRequest('/signup', {
                    username: this.loginForm.username,
                    password: this.loginForm.password
                }).then(resp=> {
                    _this.loading = false;
                    const json = resp.data;
                    window.console.log(json);
                    if (resp.status === 200) {
                        _this.$alert('注册成功!', '成功!');
                    } else {
                        //失败
                        _this.$alert('注册失败!', '失败!');
                    }
                    // eslint-disable-next-line no-unused-vars
                }, resp=> {
                    _this.loading = false;
                    _this.$alert('找不到服务器⊙﹏⊙∥!', '失败!');
                });
            }
        }
    }
</script>

<style scoped>
    .login-container {
        border-radius: 15px;
        background-clip: padding-box;
        margin: 180px auto;
        width: 350px;
        padding: 35px 35px 15px 35px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cac6c6;
    }

    .login_title {
        margin: 0px auto 40px auto;
        text-align: center;
        color: #505458;
    }

    .login_remember {
        margin: 0px 0px 35px 0px;
        text-align: left;
    }
</style>
