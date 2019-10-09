<template>
    <el-container>
        <el-header style="margin-top: 25px; text-align: left">
            <el-input
                    placeholder="请输入话题名称"
                    v-model="newTopic.name" style="width: 200px; margin-right: 15px">
            </el-input>
            <el-button type="info" size="medium" style="margin-left: 15px" @click="addTopic">新增话题</el-button>
        </el-header>

        <el-main class="with_shadow">
            <el-table
                    ref="multipleTable"
                    :data="topics"
                    tooltip-effect="dark"
                    style="width: 100%;"
                    max-height="410">

                <el-table-column
                        prop="id"
                        label="序号"
                        width="80"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="name"
                        label="价值观"
                        width="120"
                        align="left">
                </el-table-column>

                <el-table-column
                        label="操作"
                        align="left">
                    <template slot-scope="scope">
                        <el-button
                                size="mini"
                                @click="onEditClicked(scope.$index)">编辑
                        </el-button>
                        <el-button
                                size="mini"
                                type="danger"
                                @click="handleDelete(scope.$index)">删除
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-main>

        <el-dialog title="编辑话题信息" :visible.sync="dialogFormVisible">
            <el-form :model="form">
                <el-form-item label="请输入新名称:" :label-width="formLabelWidth">
                    <el-input v-model="form.name" autocomplete="off"></el-input>
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
        name: "Topic",
        data() {
            return {
                topics: [],
                dialogFormVisible: false,
                form: {
                    id: 0,
                    name: '',
                },
                formLabelWidth: '120px',
                newTopic: {
                    name: '',
                }
            }
        },
        methods: {
            loadTopics() {
                let _this = this;
                this.getRequest("/topic/all").then(resp => {
                    if (resp && resp.status === 200) {
                        _this.topics = resp.data;
                    }
                });
            },
            addTopic() {
                let _this = this;
                this.postRequest("/topic/add", {
                    name: this.newTopic.name,
                }).then(resp => {
                    if (resp && resp.status === 200) {
                        _this.loadTopics();
                    }
                });
            },
            handleDelete(index) {
                let _this = this;
                let id1 = this.topics[index].id;
                this.postRequest("/topic/delete", {"id": id1}).then(resp => {
                    if (resp && resp.status === 200) {
                        _this.loadTopics();
                    }
                })
            },
            onEditClicked(index) {
                this.form.id = this.topics[index].id;
                this.form.name = this.topics[index].name;
                this.dialogFormVisible = true;
            },
            doEdit() {
                this.dialogFormVisible = false;
                let _this = this;
                this.postRequest("/topic/update", {
                    id: this.form.id,
                    name: this.form.name,
                }).then(resp => {
                    if (resp && resp.status === 200) {
                        _this.loadTopics();
                    }
                });
            },
        },
        mounted: function () {
            this.loadTopics();
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
