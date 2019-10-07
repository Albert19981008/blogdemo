<template>
    <el-container class="home_container">
        <el-header>
            <div class="home_title">人民博客</div>
        </el-header>
        <el-container>
            <el-aside width="220px">
                <div>
                    <el-menu
                            default-active="0"
                            class="el-menu-vertical-demo" style="background-color: #ececec" router>
                        <el-menu-item @click="pushRouter('/home/value')">
                            <span slot="title">价值观管理</span>
                        </el-menu-item>
                    </el-menu>
                </div>
            </el-aside>
            <el-container>
                <el-main>
                    <el-breadcrumb separator-class="el-icon-arrow-right">
                        <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
                        <el-breadcrumb-item v-text="this.$router.currentRoute.name"></el-breadcrumb-item>
                    </el-breadcrumb>
                    <router-view></router-view>
                </el-main>
            </el-container>
        </el-container>
        <el-footer>
            <div class="footer_title">我们的价值观</div>
            <template v-for="(item,index) in values">
                <span class="footer_values" :key="index">{{item.name}}</span>
            </template>
        </el-footer>
    </el-container>
</template>

<script>
    export default {
        name: "Home",
        data() {
            return {
                values: []
            }
        },
        methods: {
            loadValues() {
                let _this = this;
                this.getRequest("/value/all").then(resp => {
                    if (resp && resp.status === 200) {
                        _this.values = resp.data;
                    }
                })
            },
            pushRouter(path) {
                this.$router.push(path);
            }
        },
        mounted: function () {
            this.loadValues();
        }
    }
</script>

<style scoped>
    .home_container {
        height: 100%;
        position: absolute;
        top: 0px;
        left: 0px;
        width: 100%;
    }

    .el-header {
        background-color: #a52a2a;
        color: #333;
        text-align: center;
        display: flex;
        align-items: center;
        justify-content: space-between;
    }

    .el-footer {
        background-color: #a52a2a;
        color: #333;
        text-align: left;
        display: flex;
        align-items: center;
        /*justify-content: space-between;*/
    }

    .el-aside {
        background-color: #ECECEC;
    }

    .el-main {
        background-color: #fff;
        color: #000;
        text-align: center;
    }

    .home_title {
        color: #fff;
        font-size: 22px;
        display: inline;
        text-align: center;
    }

    .footer_title {
        margin-right: 10px;
        color: #fff;
        font-size: 17px;
        display: inline;
    }

    .footer_values {
        margin-left: 10px;
        color: #fff;
        font-size: 15px;
    }

    .home_userinfo {
        color: #fff;
        cursor: pointer;
    }

    .home_userinfoContainer {
        display: inline;
        margin-right: 20px;
    }
</style>
