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
                    :rows="20"
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
                        window.console.log(_this.topicsAll);
                    }
                });
            },
            doAddArticle() {

            }
        },
        mounted: function () {
            this.loadTopics();
        },
    }
</script>

<style scoped>

</style>
