<template>
    <el-container>
        <el-header style="margin-top: 25px; text-align: left">
            <el-input
                    placeholder="请输入要搜索的文章名称"
                    v-model="articleToSearch.title" style="width: 350px; margin-right: 15px">
            </el-input>
            <el-button type="primary" size="medium" style="margin-left: 15px" @click="searchArticle">搜索文章</el-button>
            <el-button type="info" size="medium" style="margin-left: 15px" @click="addArticle">新增文章</el-button>
        </el-header>

        <el-main class="with_shadow">
            <el-table
                    ref="multipleTable"
                    :data="articles"
                    tooltip-effect="dark"
                    style="width: 100%;"
                    max-height="520">

                <el-table-column
                        prop="articleId"
                        label="文章序号"
                        align="left">
                </el-table-column>

                <el-table-column
                        label="标题"
                        width="400" align="left">
                    <template slot-scope="scope">
                        <span style="color: #409eff;cursor: pointer"
                              @click="article_Click(scope.row)">{{ scope.row.title}}</span>
                    </template>
                </el-table-column>

                <el-table-column
                        prop="topicName"
                        label="话题"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="userName"
                        label="发表用户"
                        align="left">
                </el-table-column>

            </el-table>
        </el-main>

    </el-container>

</template>

<script>
    export default {
        name: "ArticleSearch",
        data() {
            return {
                articles: [],
                dialogFormVisible: false,
                form: {
                    id: 0,
                    name: '',
                    explanation: '',
                },
                articleToSearch: {
                    title: ''
                },
                formLabelWidth: '120px',
            }
        },
        methods: {
            article_Click(row) {
                this.$router.push({path: '/home/article_detail', query: {aid: row.articleId}})
            },
            loadArticles() {
                let _this = this;
                this.getRequest("/article/all").then(resp => {
                    if (resp && resp.status === 200) {
                        _this.articles = resp.data;
                    }
                });
            },
            searchArticle() {
                let _this = this;
                let url_base = '/article/search/name/';
                this.getRequest(url_base + this.articleToSearch.title).then(resp => {
                    if (resp && resp.status === 200) {
                        _this.articles = resp.data;
                    }
                });
            },
            addArticle() {

            }
        },
        mounted: function () {
            this.loadArticles();
        }
    }
</script>

<style scoped>
    div {
        text-align: center;
        width: 100%;
    }

    .with_shadow {
        justify-content: flex-start;
        display: flex;
        flex-direction: column;
        padding-left: 15px;
        background-color: #ececec;
        margin-top: 10px;
        padding-top: 20px;
    }
</style>
