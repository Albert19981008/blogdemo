<template>
    <el-container>
        <el-header style="margin-top: 25px; text-align: left">
            <el-input
                    placeholder="请输入要搜索的文章名称"
                    v-model="articleToSearch.name" style="width: 350px; margin-right: 15px">
            </el-input>
            <el-button type="info" size="medium" style="margin-left: 15px" @click="searchArticle">搜索文章</el-button>
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
                        prop="title"
                        label="文章标题"
                        align="left">
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

                <el-table-column
                        label="操作"
                        align="left">
                    <template slot-scope="scope">
                        <el-button
                                size="mini"
                                type="danger"
                                @click="handleDelete(scope.$index)">删除
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-main>

        <el-dialog title="编辑价值观信息" :visible.sync="dialogFormVisible">
            <el-form :model="form">
                <el-form-item label="请输入新名称:" :label-width="formLabelWidth">
                    <el-input v-model="form.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="请输入新描述:" :label-width="formLabelWidth">
                    <el-input v-model="form.explanation" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取消</el-button>
                <el-button type="primary" @click="doEdit()">确定
                </el-button>
            </div>
        </el-dialog>
    </el-container>

</template>

<script>
    export default {
        name: "ArticleManagement",
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
                let usr_base = '/search/name';
                this.getRequest(usr_base + '?name=' + this.articleToSearch.title).then(resp => {
                    if (resp && resp.status === 200) {
                        _this.loadArticles();
                    }
                });
            },
            handleDelete(index) {
                let _this = this;
                let id1 = this.articles[index].articleId;
                this.postRequest("/article/delete", {"id": id1}).then(resp => {
                    if (resp && resp.status === 200) {
                        _this.loadArticles();
                    }
                })
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
