<template>
    <el-form :model="form" style="margin-top: 20px">
        <el-form-item label="文章标题:" :label-width="formLabelWidth">
            <el-input v-model="form.title" autocomplete="off" style="width: 500px;"></el-input>
        </el-form-item>

        <el-form-item label="文章话题:" :label-width="formLabelWidth">
            <el-autocomplete
                    style="width: 500px;"
                    v-model="form.topic"
                    :fetch-suggestions="queryTopics"
                    placeholder="请输入内容">
            </el-autocomplete>
        </el-form-item>

        <el-form-item label="文章正文:" :label-width="formLabelWidth">
            <el-input
                    type="textarea"
                    :rows="15"
                    style="margin-top: 20px"
                    placeholder="请输入内容"
                    v-model="form.content">
            </el-input>
        </el-form-item>

        <el-button type="primary" size="medium" @click="doAddArticle">发表</el-button>

    </el-form>


</template>

<script>
    export default {
        name: "ArticleWrite",
        data() {
            return {
                form: {
                    title: '',
                    content: '',
                    topic: ''
                },
                formLabelWidth: '120px',
                topicsAll: []
            }
        },
        methods: {
            queryTopics(queryString, cb) {
                let topicsAll1 = this.topicsAll.map((topic => {
                    return {"value": topic.name};
                }));
                let results = queryString ? topicsAll1.filter(this.createFilter(queryString)) : topicsAll1;
                // 调用 callback 返回建议列表的数据
                cb(results);
            },
            createFilter(queryString) {
                return (item) => {
                    return (item.value.indexOf(queryString) === 0);
                };
            },
            loadTopics() {
                let _this = this;
                this.getRequest("/topic/all").then(resp => {
                    if (resp && resp.status === 200) {
                        _this.topicsAll = resp.data;
                    }
                });
            },
            doAddArticle() {
                let _this = this;
                this.postRequest("/article/add", {
                    "topicName": this.form.topic,
                    "userId": this.$store.state.user.id,
                    "articleText": this.form.content,
                    "title": this.form.title
                }).then(resp => {
                    if (resp && resp.status === 200) {
                        _this.$message({type: 'success', message: '发表成功'});
                        this.$router.push({path: '/home'});
                    } else {
                        _this.$message({type: 'error', message: '失败，请检查参数信息'});
                    }
                })
            }
        },
        mounted: function () {
            this.loadTopics();
        },
    }
</script>

<style scoped>

</style>
