<template>
    <el-container>
        <el-header>
            <div class="home_title">人民博客</div>
        </el-header>
        <el-container>
            <el-aside width="300px">
                <el-menu
                        default-active="0"
                        class="el-menu-vertical-demo" style="background-color: #ECECEC" router>
                    <el-menu-item @click="pushRouter('/home/value')">
                        <span slot="title">价值观管理</span>
                    </el-menu-item>
                </el-menu>
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
            <h3>好好好</h3>
        </el-footer>
    </el-container>
</template>

<script>
    export default {
        name: "Home",
        methods: {
            pushRouter(path) {
                this.$router.push(path);
            },
            // 获取当前路由的子路由
            routes() {
                // var routes = {
                //     children: this.$router.options.routes
                // };
                //
                // var route = this.$route.matched;
                //
                // for (var i = 0; i < route.length - 1; i++) {
                //     routes = routes.children.find((e) => (e.name === route[i].name));
                // }
                return this.$route.children
            }
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
        background-color: #20a0ff;
        color: #333;
        text-align: center;
        display: flex;
        align-items: center;
        justify-content: space-between;
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
