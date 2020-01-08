<template>
    <el-row v-loading="loading">
        <el-col :span="24">
            <div style="text-align: left;">
                <el-button type="text" icon="el-icon-back" @click="goBack" style="padding-bottom: 0;">返回</el-button>
            </div>
        </el-col>
        <el-col :span="24">
            <div>
                <div><h3 style="margin-top: 0;margin-bottom: 0">{{article.title}}</h3></div>
                <div style="width: 100%;margin-top: 5px;display: flex;justify-content: flex-end;align-items: center">
                    <div style="display: inline; color: #20a0ff;margin-left: 50px;margin-right:20px;font-size: 12px;">
                        用户 {{article.userName}}
                    </div>
                    <span style="color: #20a0ff;margin-right:20px;font-size: 12px;">话题 {{article.topicName }}</span>
                    <span style="margin:0 50px 0 0"/>
                </div>
            </div>
        </el-col>
        <el-col>
            <div style="text-align: left" v-html="article.articleText">
            </div>
        </el-col>
    </el-row>
</template>
<script>
    import {getRequest} from '../util/api'

    export default {
        name: "ArticleDetail",
        methods: {
            goBack() {
                this.$router.go(-1);
            }
        },
        mounted: function () {
            let aid = this.$route.query.aid;
            // window.console.log(this.$route.query.aid);
            let _this = this;
            this.loading = true;
            getRequest("/article/id/" + aid).then(resp => {
                if (resp.status === 200) {
                    _this.article = resp.data;
                }
                _this.loading = false;
                // eslint-disable-next-line no-unused-vars
            }, resp => {
                _this.loading = false;
                _this.$message({type: 'error', message: '页面加载失败!'});
            });
        },
        data() {
            return {
                article: {},
                loading: false,
            }
        }
    }
</script>
