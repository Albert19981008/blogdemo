<template>
    <div>
        <el-table
                ref="multipleTable"
                :data="values"
                tooltip-effect="dark"
                style="width: 100%;overflow-x: hidden; overflow-y: hidden;"
                max-height="390"
                @selection-change="handleSelectionChange" v-loading="loading">

            <el-table-column
                    prop="id"
                    label="序号"
                    width="120"
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
                    width="280"
                    align="left">
            </el-table-column>

            <el-table-column
                    label="操作"
                    align="left"
                    v-if="showEdit || showDelete"
                    width="200">
                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            @click="handleEdit(scope.$index, scope.row)" v-if="showEdit">编辑
                    </el-button>
                    <el-button
                            size="mini"
                            type="danger"
                            @click="handleDelete(scope.$index)" v-if="showDelete">删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>

</template>

<script>
    export default {
        name: "Values",
        data() {
            return {
                values: [],
                showEdit: true,
                showDelete: true
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
            handleDelete(index) {
                let _this = this;
                let id1 = this.values[index].id;
                this.postRequest("/value/delete", {"id": id1}).then(resp => {
                    if (resp && resp.status === 200) {
                        _this.loadValues();
                    }
                })
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
</style>
