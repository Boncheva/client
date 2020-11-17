<template>
    <body>
    <div class="wrap contents-body">
        <div class="item-title_box">
            <div class="item-title supervision-list-line"><span>申报用户管理</span></div>
            <form action="" class="layui-form supervision-list">
                <div class="topctrl fix">

                    <div class="layui-inline">
                        <el-select v-model="province" placeholder="请选择省份" @change="getCities(province)">
                            <el-option
                                    v-for="item in provinces"
                                    :key="item.id"
                                    :label="item.cname"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </div>
                    <div class="layui-inline">
                        <el-select v-model="city" placeholder="请选择城市" @change="getareas(city)">
                            <el-option
                                    v-for="item in cities"
                                    :key="item.id"
                                    :label="item.cname"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </div>
                    <div class="layui-inline">
                        <el-select v-model="area" placeholder="请选择区域">
                            <el-option
                                    v-for="item in areas"
                                    :key="item.id"
                                    :label="item.cname"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </div>
                    <div class="layui-inline">
                        <el-select v-model="isSubmit" placeholder="请选择核酸报告状态">
                            <el-option label="未提交" value="0"></el-option>
                            <el-option label="已提交" value="1"></el-option>
                        </el-select>
                    </div>
                    <div class="layui-inline">
                        <el-select v-model="deleted" placeholder="请选择账号状态">
                            <el-option label="正常" value="0"></el-option>
                            <el-option label="已删除" value="1"></el-option>
                        </el-select>
                    </div>
                    <div class="layui-inline">
                        <el-select v-model="fillStatus" placeholder="是否填报">
                            <el-option label="否" value="0"></el-option>
                            <el-option label="是" value="1"></el-option>
                        </el-select>
                    </div>
                    <div class="layui-inline">
                        <el-select v-model="userType" placeholder="用户类型">
                            <el-option label="香港入境普通市民" value="0"></el-option>
                            <el-option label="机场国际航班人员" value="1"></el-option>
                            <el-option label="跨境货车司机" value="2"></el-option>
                            <el-option label="港口入境船员" value="3"></el-option>
                        </el-select>
                    </div>
                    <div class="layui-inline">
                        <el-input v-model="idOrName" placeholder="请输入身份证或者姓名"></el-input>
                    </div>

                    <button class="layui-btn layui-btn-normal layui-btn-sm" @click="appUserList">搜索</button>
                    <button class="layui-btn layui-btn-normal layui-btn-sm" @click="initForm">重置</button>
                </div>

                <div class="supervision-list-table">
                    <el-table
                            :data="tableData"
                            style="width: 100%">
                        <el-table-column
                                prop="certType"
                                label="证件类型"
                                width="180">
                        </el-table-column>
                        <el-table-column
                                prop="certNo"
                                label="证件号码"
                                width="250">
                        </el-table-column>
                        <el-table-column
                                prop="userName"
                                label="姓名"
                                width="250">
                        </el-table-column>
                        <el-table-column
                                prop="checkStatus"
                                label="公安审核状态"
                                width="180">
                        </el-table-column>
                        <el-table-column
                                prop="sqCheckStatus"
                                label="社区审核状态"
                                width="180">
                        </el-table-column>
                        <el-table-column
                                prop="hsRgCheckStatus"
                                label="核酸审核状态"
                                width="180">
                        </el-table-column>
                        <el-table-column
                                prop="reportPath"
                                label="核酸报告状态"
                                width="180">
                        </el-table-column>
                        <el-table-column
                                prop="deleted"
                                label="账号是否删除"
                                width="180">
                        </el-table-column>
                        <el-table-column
                                prop="address"
                                label="同住人员信息"
                                width="180">
                        </el-table-column>
                        <el-table-column
                                prop="userType"
                                label="用户类型"
                                width="180">
                        </el-table-column>
                        <el-table-column
                                prop="fromType"
                                label="来源"
                                width="180">
                        </el-table-column>
                        <el-table-column
                                prop="action"
                                label="操作"
                                width="400">
                            <template slot-scope="scope">
                                <el-button
                                        size="mini"
                                        @click="userInfoDetail(scope.row)">用户详情
                                </el-button>
                                <el-button
                                        size="mini"
                                        @click="open(scope.row)">重置密码
                                </el-button>
                                <el-button
                                        size="mini"
                                        type="danger"
                                        @click="deleteUser(scope.row.id)">删除用户
                                </el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                    <div class="block">
                        <span class="demonstration"></span>
                        <el-pagination
                                @size-change="handleSizeChange"
                                @current-change="handleCurrentChange"
                                :current-page="currentPage"
                                :page-sizes="[10, 20, 30, 40, 50]"
                                :page-size="pageSize"
                                layout="total, sizes, prev, pager, next, jumper"
                                :total="totalCount">
                        </el-pagination>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--弹框-->
    <el-dialog title="用户详情" :visible.sync="dialogVisible" :close-on-click-modal="true" :modal="true" :show-close="true"
               :center="true">
        <template>
            <el-tabs v-model="activeName">
                <el-tab-pane label="申报人信息" name="first">
                    <div class="layui-tab-content layui-form">
                        <div class="layui-tab-item layui-show">
                            <table class="layui-table detail-table">
                                <tbody>
                                <tr>
                                    <td><label>姓名：</label>
                                        <span> {{userInfo.userName}} </span></td>
                                    <td><label>年龄：</label>
                                        <span>{{userInfo.age}}</span></td>
                                </tr>
                                <tr>
                                    <td><label>证件类型：</label>
                                        <div class="layui-inline">
                                            <span>
                                                {{userInfo.certType}}
                                            </span>
                                        </div>
                                    </td>
                                    <td><label>证件号码：</label>
                                        <span>{{userInfo.certNo}}</span></td>
                                </tr>
                                <tr>
                                    <td colspan="2"><label>核酸报告：</label>
                                        <a href="" class="color-blue-006">查看</a></td>
                                </tr>
                                </tbody>
                            </table>
                            <table class="layui-table detail-table">
                                <thead>
                                <th colspan="2"><strong>公安审核</strong></th>
                                </thead>
                                <tbody>
                                <tr>
                                    <td><label>审核状态：</label>
                                        <span> {{userInfo.checkStatus}} </span></td>
                                    <td><label>审核原因：</label>
                                        <span>{{userInfo.checkReason}}</span></td>
                                </tr>
                                <tr>
                                    <td><label>审核时间：</label>
                                        <span> {{userInfo.checkDate.slice(0,10)}} </span></td>
                                    <td><label>审核人：</label>
                                        <span>{{userInfo.checkUser}}</span></td>
                                </tr>

                                </tbody>
                            </table>
                            <table class="layui-table detail-table">
                                <thead>
                                <th colspan="2"><strong>社区审核</strong></th>
                                </thead>
                                <tbody>
                                <tr>
                                    <td><label>审核状态：</label>
                                        <span>{{userInfo.sqCheckStatus}}</span></td>
                                    <td><label>审核原因：</label>
                                        <span>{{userInfo.sqCheckReason}}</span></td>
                                </tr>
                                <tr>
                                    <td><label>审核时间：</label>
                                        <span> {{userInfo.sqCheckDate.slice(0,10)}} </span></td>
                                    <td><label>审核人：</label>
                                        <span>{{userInfo.sqCheckUser}}</span></td>
                                </tr>

                                </tbody>
                            </table>
                            <table class="layui-table detail-table">
                                <thead>
                                <th colspan="2"><strong>核酸审核</strong></th>
                                </thead>
                                <tbody>
                                <tr>
                                    <td><label>审核状态：</label>
                                        <span> {{userInfo.hsRgCheckStatus}} </span></td>
                                    <td><label>审核原因：</label>
                                        <span>{{userInfo.hsRgCheckReason}}</span></td>
                                </tr>
                                <tr>
                                    <td><label>审核时间：</label>
                                        <span>{{userInfo.hsRgCheckDate.slice(0,10)}} </span></td>
                                    <td><label>审核人：</label>
                                        <span>{{userInfo.hsRgCheckUser}}</span></td>
                                </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </el-tab-pane>
                <el-tab-pane label="同住人信息" name="second">
                </el-tab-pane>
            </el-tabs>
        </template>
        <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
    </el-dialog>

    <el-dialog title="重置密码" :visible.sync="dialogVisibleRP" :close-on-click-modal="true" :modal="true"
               :show-close="true"
               :center="true">
        <el-input v-model="newPassWord" placeholder="请输入新密码" show-password></el-input>
        <el-input v-model="confirmTheNewPassword" placeholder="请再次输入新密码" show-password></el-input>
        <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisibleRP = false">取 消</el-button>
        <el-button type="primary" @click="resetPassword">确 定</el-button>
        </span>
    </el-dialog>
    </body>
</template>
<script>
    import '../../../static/layui/css/layui.css'
    import '../../assets/css/global.css'
    import '../../assets/css/master.css'

    export default {
        name: "applyUser",
        data() {
            return {
                idOrName: null,
                tableData: [],
                provinces: [],
                cities: [],
                areas: [],
                province: null,
                city: null,
                area: null,
                activeName: 'first',

                userId: null,
                userType: null,
                fillStatus: null,
                deleted: null,
                isSubmit: null,
                dialogVisible: false,
                dialogVisibleRP: false,
                newPassWord: null,
                confirmTheNewPassword: null,
                userInfo: {
                    hsRgCheckDate: '',
                    sqCheckDate: '',
                    checkDate: ''
                },


                pageSize: 10,    //每页的数据
                currentPage: 1,//第几页
                totalCount: 1,//总条数
            }
        },
        methods: {
            //每页显示的条数
            handleSizeChange(val) {
                this.pageSize = val
                this.appUserList(val, 1)
                this.currentPage = 1
            },
            //显示第几页
            handleCurrentChange(val) {
                this.currentPage = val
                this.appUserList(this.pageSize, val)
            },
            //用户列表
            appUserList(pageSize, pageNum) {
                let data = {
                    province: this.province,
                    city: this.city,
                    area: this.area,
                    isSubmit: this.isSubmit,
                    deleted: this.deleted,
                    fillStatus: this.fillStatus,
                    userType: this.userType,
                    idOrName: this.idOrName
                }
                if (pageNum != null && pageSize != null) {
                    data.pageNum = pageNum;
                    data.pageSize = pageSize;
                } else {
                    data.pageNum = this.currentPage;
                    data.pageSize = this.pageSize;
                }
                this.$http.post('http://127.0.0.1:8888/userInfo/user/list', data, {emulateJSON: true}).then(function (res) {
                    this.tableData = res.body.data.list;
                    this.totalCount = res.body.data.total
                    for (var i = 0; i < this.tableData.length; i++) {
                        var certType = this.tableData[i].certType;
                        var checkStatus = this.tableData[i].checkStatus;
                        var sqCheckStatus = this.tableData[i].sqCheckStatus;
                        var hsRgCheckStatus = this.tableData[i].hsRgCheckStatus;
                        var deleted = this.tableData[i].deleted;
                        var reportPath = this.tableData[i].reportPath;
                        var fromType = this.tableData[i].fromType;
                        var userType = this.tableData[i].userType;
                        if (reportPath) {
                            this.tableData[i].reportPath = '已提交';
                        } else {
                            this.tableData[i].reportPath = '未提交';
                        }
                        if (certType == '1') {
                            this.tableData[i].certType = '身份证';
                        } else if (certType == '2') {
                            this.tableData[i].certType = '港澳通行证';
                        } else if (certType == '3') {
                            this.tableData[i].certType = '护照';
                        } else if (certType == '4') {
                            this.tableData[i].certType = '回乡证';
                        } else {
                            this.tableData[i].certType = '来源不明';
                        }
                        if (checkStatus == '0') {
                            this.tableData[i].checkStatus = '待审核';
                        } else if (checkStatus == '1') {
                            this.tableData[i].checkStatus = '审核通过';
                        } else if (checkStatus == '2') {
                            this.tableData[i].checkStatus = '审核不通过';
                        }
                        if (sqCheckStatus == '0') {
                            this.tableData[i].sqCheckStatus = '待审核';
                        } else if (sqCheckStatus == '1') {
                            this.tableData[i].sqCheckStatus = '审核通过';
                        } else if (sqCheckStatus == '2') {
                            this.tableData[i].sqCheckStatus = '审核不通过';
                        }
                        if (hsRgCheckStatus == '0') {
                            this.tableData[i].hsRgCheckStatus = '待审核';
                        } else if (hsRgCheckStatus == '1') {
                            this.tableData[i].hsRgCheckStatus = '审核通过';
                        } else if (hsRgCheckStatus == '2') {
                            this.tableData[i].hsRgCheckStatus = '审核不通过';
                        }
                        if (deleted == '0') {
                            this.tableData[i].deleted = '正常';
                        } else if (deleted == '1') {
                            this.tableData[i].deleted = '已删除';
                        }
                        if (userType == '0') {
                            this.tableData[i].userType = '香港入境普通市民';
                        } else if (userType == '1') {
                            this.tableData[i].userType = '机场国际航班人员';
                        } else if (userType == '2') {
                            this.tableData[i].userType = '跨境货车司机';
                        } else if (userType == '3') {
                            this.tableData[i].userType = '港口入境船员';
                        }
                        if (fromType == '0') {
                            this.tableData[i].fromType = '码通海关推送';
                        } else if (fromType == '1') {
                            this.tableData[i].fromType = '码通粤省事补登';
                        } else if (fromType == '2') {
                            this.tableData[i].fromType = '手机端注册';
                        }
                    }
                })
            },
            //初始化查询条件
            initForm() {
                this.province = null,
                    this.city = null,
                    this.area = null,
                    this.isSubmit = null,
                    this.deleted = null,
                    this.fillStatus = null,
                    this.userType = null,
                    this.idOrName = null,
                    this.cities = [],
                    this.areas = []
            },
            //获取省份
            getProvinces() {
                this.$http.post('http://127.0.0.1:8888/userInfo/area/list', {}, {emulateJSON: true})
                    .then(
                        function (res) {
                            this.provinces = res.body.data;
                        },
                    )
            },
            //获取城市
            getCities(id) {
                this.city = null;
                this.area = null;
                this.$http.post('http://127.0.0.1:8888/userInfo/area/list', {id: id}, {emulateJSON: true})
                    .then(
                        function (res) {
                            this.cities = res.body.data;
                        },
                    )
            },
            //获取地区
            getareas(id) {
                this.area = null;
                this.$http.post('http://127.0.0.1:8888/userInfo/area/list', {id: id}, {emulateJSON: true})
                    .then(
                        function (res) {
                            this.areas = res.body.data;
                        },
                    )
            },
            //获取用户详细信息
            userInfoDetail(row) {
                this.dialogVisible = true;
                this.$http.get('http://127.0.0.1:8888/userInfo/user/info', {params: {userId: row.id}}).then(function (res) {
                    this.userInfo = res.body.data;
                    let certType = this.userInfo.certType;
                    if (certType == '1') {
                        this.userInfo.certType = '身份证';
                    } else if (certType == '2') {
                        this.userInfo.certType = '港澳通行证';
                    } else if (certType == '3') {
                        this.userInfo.certType = '护照';
                    } else if (certType == '4') {
                        this.userInfo.certType = '回乡证';
                    }
                    let checkStatus = this.userInfo.checkStatus;
                    if (checkStatus == '0') {
                        this.userInfo.checkStatus = '待审核'
                    } else if (checkStatus == '1') {
                        this.userInfo.checkStatus = '审核通过'
                    } else if (checkStatus == '2') {
                        this.userInfo.checkStatus = '审核不通过'
                    }
                    let hsRgCheckStatus = this.userInfo.hsRgCheckStatus;
                    if (hsRgCheckStatus == '0') {
                        this.userInfo.hsRgCheckStatus = '待审核'
                    } else if (hsRgCheckStatus == '1') {
                        this.userInfo.hsRgCheckStatus = '审核通过'
                    } else if (hsRgCheckStatus == '2') {
                        this.userInfo.hsRgCheckStatus = '审核不通过'
                    }
                    let sqCheckStatus = this.userInfo.sqCheckStatus;
                    if (sqCheckStatus == '0') {
                        this.userInfo.sqCheckStatus = '待审核'
                    } else if (sqCheckStatus == '1') {
                        this.userInfo.sqCheckStatus = '审核通过'
                    } else if (sqCheckStatus == '2') {
                        this.userInfo.sqCheckStatus = '审核不通过'
                    }
                })
            },
            //弹出用户详情框
            open(row) {
                this.userId = row.id;
                this.dialogVisibleRP = true;
            },
            //重置密码
            resetPassword() {
                if (this.newPassWord == null || this.newPassWord == '') {
                    this.$message.error("请输入密码");
                    return;
                }
                if (this.newPassWord.length < 8) {
                    this.$message.error("密码长度不能少于8位")
                    return;
                }

                if (this.confirmTheNewPassword == null || this.confirmTheNewPassword == '') {
                    this.$message.error("请确认密码");
                    return;
                }
                if (this.newPassWord != this.confirmTheNewPassword) {
                    this.$message.error("两次输入密码不一致")
                    return;
                }
                this.$http.post('http://127.0.0.1:8888/userInfo/resetpwd', {
                    id: this.userId,
                    passwd: this.newPassWord
                }, {emulateJSON: true}).then((res) => {
                    if (res.body.status != 200) {
                        this.$notify({
                            title: '修改失败',
                            type: 'failed'
                        });
                    } else {
                        this.$notify({
                            title: '修改成功',
                            type: 'success'
                        });
                    }
                    this.newPassWord = null;
                    this.confirmTheNewPassword = null;
                    this.dialogVisibleRP = false;
                })
            },
            //删除用户
            deleteUser(userId) {
                this.$http.delete('http://127.0.0.1:8888/userInfo/delete', {params: {'userId': userId}}).then((res) => {
                    if (res.body.status != 200) {
                        this.$notify({
                            title: '删除失败',
                            type: 'failed'
                        });
                    } else {
                        this.$notify({
                            title: '删除成功',
                            type: 'success'
                        });
                        this.appUserList();
                    }
                })
            }
        },
        mounted() {
            this.getProvinces();
        },
        created() {
            this.appUserList(this.pageSize, this.currentPage)
        },
    }


</script>

<style scoped>

</style>