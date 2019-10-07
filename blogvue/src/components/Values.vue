<template>
    <el-container>
        <el-main>
            <el-table
                    ref="multipleTable"
                    :data="values"
                    tooltip-effect="dark"
                    style="width: 100%;"
                    max-height="390">

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
                        prop="explanation"
                        label="描述"
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
                    <el-button type="primary" @click="dialogFormVisible = false, doEdit()">确定
                    </el-button>
                </div>
            </el-dialog>
        </el-main>
    </el-container>

</template>

<script>
    export default {
        name: "Values",
        data() {
            return {
                values: [],
                dialogFormVisible: false,
                form: {
                    id: 0,
                    name: '',
                    explanation: '',
                },
                formLabelWidth: '120px'
            }
        },
        methods: {
            loadValues() {
                let _this = this;
                this.getRequest("/value/all").then(resp => {
                    if (resp && resp.status === 200) {
                        _this.values = resp.data;
                    }
                });
            },
            handleDelete(index) {
                let _this = this;
                let id1 = this.values[index].id;
                this.postRequest("/value/delete", {"id": id1}).then(resp => {
                    if (resp && resp.status === 200) {
                        _this.loadValues();
                    }
                })
            },
            onEditClicked(index) {
                this.form.id = this.values[index].id;
                this.form.name = this.values[index].name;
                this.form.explanation = this.values[index].explanation;
                this.dialogFormVisible = true;
            },
            doEdit() {
                let _this = this;
                this.postRequest("/value/update", {
                    id: this.form.id,
                    name: this.form.name,
                    explanation: this.form.explanation
                }).then(resp => {
                    if (resp && resp.status === 200) {
                        _this.loadValues();
                    }
                });
            }
        },
        mounted: function () {
            this.loadValues();
        }
    }
</script>

<style scoped>
    div {
        text-align: center;
        width: 100%;
    }

    .el-main {
        justify-content: flex-start;
        display: flex;
        flex-direction: column;
        padding-left: 15px;
        background-color: #ececec;
        margin-top: 20px;
        padding-top: 20px;
    }
</style>
