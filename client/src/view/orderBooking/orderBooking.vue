<template>
    <body>
    <div class="wrap contents-body">
        <div class="item-title_box">
            <div class="item-title supervision-list-line"><span>预定订单管理</span></div>
            <form action="" class="layui-form supervision-list">
                <div class="topctrl fix">

                    <div class="layui-inline">
                        <el-select v-model="district" placeholder="全部区域" @change="getStreetList(district)">
                            <el-option
                                    v-for="item in districtList"
                                    :key="item"
                                    :label="item"
                                    :value="item">
                            </el-option>
                        </el-select>
                    </div>
                    <div class="layui-inline">
                        <el-select v-model="street" placeholder="全部街道">
                            <el-option
                                    v-for="item in streetList"
                                    :key="item"
                                    :label="item"
                                    :value="item">
                            </el-option>
                        </el-select>
                    </div>
                    <div class="layui-inline">
                        <el-select v-model="status" placeholder="全部状态">
                            <el-option label="预订待审核" value="0"></el-option>
                            <el-option label="审核未通过" value="1"></el-option>
                            <el-option label="已预订" value="2"></el-option>
                            <el-option label="入住" value="3"></el-option>
                            <el-option label="爽约" value="4"></el-option>
                            <el-option label="退房" value="5"></el-option>
                            <el-option label="取消" value="9"></el-option>
                        </el-select>
                    </div>
                    <div class="layui-inline">
                        <el-select v-model="portType" placeholder="入境口岸">
                            <el-option label="0" value="0"></el-option>
                            <el-option label="1" value="1"></el-option>
                            <el-option label="3" value="3"></el-option>
                        </el-select>
                    </div>
                    <div class="layui-inline">
                        <el-select v-model="hotelType" placeholder="酒店类型">
                            <el-option
                                    v-for="item in hotelTypesList"
                                    :key="item.id"
                                    :label="item.itemName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </div>
                    <div class="layui-inline">
                        <el-date-picker v-model="checkinDate" type="date" placeholder="入住时间"></el-date-picker>
                    </div>
                    <div class="layui-inline">
                        <el-input v-model="hotelName" placeholder="预约酒店"></el-input>
                    </div>
                    <div class="layui-inline">
                        <el-input v-model="remark" placeholder="搜索备注"></el-input>
                    </div>
                    <div class="layui-inline">
                        <el-input v-model="oriRemark" placeholder="搜索原始备注"></el-input>
                    </div>

                    <el-button class="layui-btn layui-btn-normal layui-btn-sm" @click="orderInfoList(null,1)">搜索
                    </el-button>
                    <el-button class="layui-btn layui-btn-normal layui-btn-sm" @click="reset">重置</el-button>
                    <el-button class="layui-btn layui-btn-normal layui-btn-sm" @click="exportOrderInfoList()">导出
                    </el-button>
                    <el-button class="layui-btn layui-btn-normal layui-btn-sm" @click="deleteOrderList()">批量删除
                    </el-button>
                    <el-button class="layui-btn layui-btn-normal layui-btn-sm" @click="openMt">批量转移</el-button>
                    <el-upload
                            class="upload-demo"
                            action="http://127.0.0.1:8888/order/upload"
                            accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel"
                            :on-preview="handlePreview"
                            :on-remove="handleRemove"
                            :on-success="handleAvatarSuccess"
                            multiple
                            :limit="1"
                            :on-exceed="handleExceed"
                            :file-list="fileList">
                        <el-button size="small" type="primary">批量上传</el-button>
                    </el-upload>
                </div>

                <div class="supervision-list-table">
                    <el-table
                            :data="tableData"
                            style="width: 100%"
                            @selection-change="handleSelectionChange"
                            border>
                        <el-table-column
                                type="selection"
                                width="55">
                        </el-table-column>
                        <el-table-column
                                prop="userName"
                                label="姓名"
                                width="180"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                prop="sex"
                                label="性别"
                                width="180"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                prop="age"
                                label="年龄"
                                width="180"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                prop="hotelName"
                                label="预订酒店"
                                width="250"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                prop="district"
                                label="区域"
                                width="180"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                prop="roomNum"
                                label="房号"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                prop="remark"
                                label="备注"
                                width="180"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                prop="checkinDate"
                                label="入住日期"
                                width="250"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                prop="statusForList"
                                label="预定状态"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                prop="userType"
                                label="入住人"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                prop="action"
                                label="操作"
                                width="250"
                                align="center">
                            <template slot-scope="scope">
                                <el-button
                                        size="mini"
                                        @click="orderDetail(scope.row)">详情
                                </el-button>
                                <el-button
                                        size="mini"
                                        type="danger"
                                        @click="open(scope.row)">编辑
                                </el-button>
                                <el-button
                                        size="mini"
                                        type="danger"
                                        @click="deleteOrder(scope.row.id)">删除
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
            <el-dialog title="编辑" :visible.sync="dialogVisibleUp" :close-on-click-modal="true" :modal="true"
                       :show-close="true"
                       :center="true">
                <div class="demo-input-suffix">
                    <table>
                        <tr>
                            <td>
                                <span>房间类型: </span>
                                <el-select v-model="houseTypeUpt">
                                    <el-option label="普通房间" value=1></el-option>
                                    <el-option label="货车司机专用" value=2></el-option>
                                    <el-option label="其他" value=3></el-option>
                                </el-select>
                            </td>
                            <td>
                                <span>入住时间：</span>
                                <el-date-picker v-model="checkinDateUpt" type="date" placeholder="入住时间"
                                                value-format="yyyy-MM-dd"/>
                            </td>
                            <td>
                                <span>价格: </span>
                                <el-input v-model="housePriceUpt" type="number"></el-input>
                            </td>
                            <td>
                                <span>状态: </span>
                                <el-select v-model="statusUpt">
                                    <el-option label="预订待审核" value="0"></el-option>
                                    <el-option label="审核未通过" value="1"></el-option>
                                    <el-option label="已预订" value="2"></el-option>
                                    <el-option label="入住" value="3"></el-option>
                                    <el-option label="爽约" value="4"></el-option>
                                    <el-option label="退房" value="5"></el-option>
                                    <el-option label="取消" value="9"></el-option>
                                </el-select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span>是否删除：</span>
                                <el-select v-model="deletedUpt">
                                    <el-option value="0" label="未删除"></el-option>
                                    <el-option value="1" label="已删除"></el-option>
                                </el-select>
                            </td>
                            <td>
                                <span>入住房号：</span>
                                <el-input v-model="roomNumUpt"></el-input>
                            </td>
                            <td>
                                <span>备注：</span>
                                <el-input v-model="remakeUpt"></el-input>
                            </td>
                            <td>
                                <span>来源：</span>
                                <el-select v-model="fromTypeUpt">
                                    <el-option label="用户" value="0"></el-option>
                                    <el-option label="酒店" value="1"></el-option>
                                    <el-option label="导入" value="2"></el-option>
                                </el-select>
                            </td>
                        </tr>
                    </table>
                </div>
                <span slot="footer" class="dialog-footer">
                                        <el-button @click="dialogVisibleUp = false">取 消</el-button>
                                        <el-button type="primary" @click="updateOrder()">确 定</el-button>
                                        </span>
            </el-dialog>
            <el-dialog title="批量转移" :visible.sync="dialogVisibleMt" :close-on-click-modal="true" :modal="true"
                       :show-close="true"
                       :center="true">
                <div class="demo-input-suffix">
                    <table>
                        <tr>
                            <td>
                                区域：
                                <el-select v-model="districtMt"
                                           @change="getStreetMtList(districtMt)">
                                    <el-option
                                            v-for="item in districtList"
                                            :key="item"
                                            :label="item"
                                            :value="item">
                                    </el-option>
                                </el-select>
                            </td>
                            <td>
                                街道：
                                <el-select v-model="streetMt" @change="getHotelMtList()">
                                    <el-option
                                            v-for="item in streetMtList"
                                            :key="item"
                                            :label="item"
                                            :value="item">
                                    </el-option>
                                </el-select>
                                酒店：
                                <el-select v-model="hotelMt">
                                    <el-option
                                            v-for="item in hotelInfoListMt"
                                            :key="item.id"
                                            :label="item.hotelName"
                                            :value="item.id">
                                    </el-option>
                                </el-select>
                            </td>
                        </tr>
                    </table>
                </div>
                <span slot="footer" class="dialog-footer">
                                        <el-button @click="dialogVisibleMt = false">取 消</el-button>
                                        <el-button type="primary" @click="massTransfer()">确 定</el-button>
                                        </span>
            </el-dialog>
            <el-dialog title="预定详情" :visible.sync="dialogVisible" :close-on-click-modal="true" :modal="true"
                       :show-close="true"
                       :center="true">
                <template>
                    <el-tabs v-model="activeName">
                        <el-tab-pane label="预定人信息" name="first">
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
                                                <span> {{userInfo.checkDate}} </span></td>
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
                                                <span>
                                                    {{userInfo.sqCheckDate}}
                                                </span></td>
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
                                                <span>{{userInfo.hsRgCheckDate}} </span></td>
                                            <td><label>审核人：</label>
                                                <span>{{userInfo.hsRgCheckUser}}</span></td>
                                        </tr>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </el-tab-pane>
                        <el-tab-pane label="酒店信息" name="second">
                            <div class="layui-tab-content layui-form">
                                <div class="layui-tab-item layui-show">
                                    <table class="layui-table detail-table">
                                        <tbody>
                                        <tr>
                                            <td colspan="2"><label>酒店名称：</label>
                                                <span> {{hotelInfo.hotelName}} </span></td>
                                            <td colspan="2"><label>酒店别名：</label>
                                                <span>{{hotelInfo.hotelOtherName}}</span></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2"><label>区：</label>
                                                <span> {{hotelInfo.district}} </span></td>
                                            <td colspan="2"><label>街道：</label>
                                                <span>{{hotelInfo.street}}</span></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2"><label>联系人：</label>
                                                <span>{{hotelInfo.contractUser}}</span></td>
                                            <td colspan="2"><label>联系电话：</label>
                                                <span>{{hotelInfo.contractMobile}}</span></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                <label>酒店详细地址：</label>
                                                <span>{{hotelInfo.address}}</span>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </el-tab-pane>
                    </el-tabs>
                </template>
                <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
            </el-dialog>
        </div>
    </div>
    </body>
</template>
<script>
    import '../../../static/layui/css/layui.css'
    import '../../assets/css/global.css'
    import '../../assets/css/master.css'

    export default {
        name: "orderBooking",
        data() {
            return {
                id: null,
                activeName: 'first',
                tableData: [],
                hotelTypesList: [],
                districtList: [],
                streetList: [],
                checkinDate: null,
                hotelName: null,
                remark: null,
                oriRemark: null,
                status: null,
                hotelType: null,
                district: null,
                street: null,
                portType: null,
                orderId: null,
                dialogVisibleUp: false,
                multipleSelection: [],
                dialogVisible: false,

                fileList: [],

                hotelInfo: {},
                userInfo: {},

                hotelList: [],
                hotelIdUpt: null,
                houseTypeUpt: null,
                housePriceUpt: null,
                checkinDateUpt: null,
                statusUpt: null,
                realCheckInDateUpt: null,
                canceDateUpt: null,
                modifyDateUpt: null,
                deletedUpt: null,
                checkoutDateUpt: null,
                roomNumUpt: null,
                remakeUpt: null,
                fromTypeUpt: null,

                districtMt: null,
                streetMt: null,
                hotelMt: null,
                streetMtList: null,
                hotelInfoListMt: null,
                dialogVisibleMt: false,
                selectionListMt: [],

                pageSize: 10,    //每页的数据
                currentPage: 1,//第几页
                totalCount: 1,//总条数
            }
        },
        methods: {
            //每页显示的条数
            handleSizeChange(val) {
                this.pageSize = val
                this.orderInfoList(val, 1)
                this.currentPage = 1
            },
            //显示第几页
            handleCurrentChange(val) {
                this.currentPage = val
                this.orderInfoList(this.pageSize, val)
            },
            //获取酒店类型
            getHotelTypesList() {
                this.$http.get('http://127.0.0.1:8888/config/list', {params: {parentId: 1005}}).then(function (res) {
                    this.hotelTypesList = res.body.data;
                })
            },
            //获取区域列表
            getDistrictList() {
                this.$http.get('http://127.0.0.1:8888/hotel/district/list').then(function (res) {
                    this.districtList = res.body.data;
                })
            },
            //获取街道列表
            getStreetList(district) {
                this.$http.get('http://127.0.0.1:8888/hotel/street/list', {params: {district: district}}).then(function (res) {
                    this.streetList = res.body.data;
                })
            },
            getStreetMtList(districtMt) {
                this.streetMt = null;
                this.$http.get('http://127.0.0.1:8888/hotel/street/list', {params: {district: districtMt}}).then(function (res) {
                    this.streetMtList = res.body.data;
                })
            },
            getHotelMtList() {
                this.hotelMt = null;
                this.$http.post('http://127.0.0.1:8888/order/hotel/list', {
                    district: this.districtMt,
                    street: this.streetMt
                }, {emulateJSON: true}).then((res => {
                    this.hotelInfoListMt = res.body;
                }))
            },
            //获取订单列表
            orderInfoList(pageSize, pageNum) {
                let data = {
                    district: this.district,
                    street: this.street,
                    portType: this.portType,
                    hotelType: this.hotelType,
                    hotelName: this.hotelName,
                    checkinDate: (this.checkinDate == null) || (this.checkinDate == '') ? null : this.$moment(this.checkinDate).format('YYYY-MM-DD'),
                    remark: this.remark,
                    oriRemark: this.oriRemark
                }
                if (this.status != null) {
                    data.status = this.status;
                } else {
                    data.status = -1;
                }
                if (pageNum != null) {
                    data.pageNum = pageNum;
                } else {
                    data.pageNum = this.currentPage;
                }
                if (pageSize != null) {
                    data.pageSize = pageSize;
                } else {
                    data.pageSize = this.pageSize;
                }
                this.$http.post('http://127.0.0.1:8888/order/list', data, {emulateJSON: true}).then(function (res) {
                    this.tableData = res.body.data.list;
                    this.totalCount = res.body.data.total
                    for (let i = 0; i < this.tableData.length; i++) {
                        if (this.tableData[i].checkinDate != null) {
                            this.tableData[i].checkinDate = this.tableData[i].checkinDate.substring(0, 10);
                        }
                        let sex = this.tableData[i].sex;
                        if (sex == '0') {
                            this.tableData[i].sex = '男'
                        } else {
                            this.tableData[i].sex = '女'
                        }
                        let status = this.tableData[i].status;
                        if (status == 0) {
                            this.tableData[i].statusForList = '预订待审核'
                        } else if (status == '1') {
                            this.tableData[i].statusForList = '审核未通过'
                        } else if (status == '2') {
                            this.tableData[i].statusForList = '已预订'
                        } else if (status == '3') {
                            this.tableData[i].statusForList = '入住'
                        } else if (status == '4') {
                            this.tableData[i].statusForList = '爽约'
                        } else if (status == '5') {
                            this.tableData[i].statusForList = '退房'
                        } else if (status == '9') {
                            this.tableData[i].statusForList = '取消'
                        }
                    }
                })
            },
            //重置查询参数
            reset() {
                this.district = null,
                    this.street = null,
                    this.status = null,
                    this.portType = null,
                    this.hotelType = null,
                    this.checkinDate = null,
                    this.hotelName = null,
                    this.remark = null,
                    this.oriRemark = null,
                    this.streetList = []
            },
            //打开订单修改弹框
            open(row) {
                this.id = row.id;
                this.$http.post('http://127.0.0.1:8888/order/hotel/list', null, {emulateJSON: true}).then((res) => {
                    this.hotelList = res.body.data;
                })
                this.orderId = row.id;
                this.statusUpt = row.status.toString();
                this.hotelIdUpt = row.hotelId;
                if (row.houseType != null) {
                    this.houseTypeUpt = row.houseType.toString();
                }
                this.housePriceUpt = row.price;
                this.checkinDateUpt = row.checkinDate;
                this.realCheckInDateUpt = row.realCheckinDate;
                this.canceDateUpt = row.canceDate;
                this.modifyDateUpt = row.modifyDate;
                this.deletedUpt = row.deleted.toString();
                this.checkinDateUpt = row.checkinDate;
                this.roomNumUpt = row.roomNum;
                this.remakeUpt = row.remark;
                this.fromTypeUpt = row.fromType.toString();
                this.dialogVisibleUp = true;
            },
            //更新订单
            updateOrder() {
                if (this.houseTypeUpt == null || this.houseTypeUpt == '') {
                    this.$message.error("请选择房间类型");
                    return;
                }
                if (this.checkinDateUpt == null || this.checkinDateUpt == '') {
                    this.$message.error("请选择入住时间");
                    return;
                }
                if (this.housePriceUpt == null || this.housePriceUpt == '') {
                    this.$message.error("请填写房间价格");
                    return;
                }
                if (this.statusUpt == null || this.statusUpt == '') {
                    this.$message.error("请选择状态");
                    return;
                }
                if (this.deletedUpt == null || this.deletedUpt == '') {
                    this.$message.error("请选择是否删除");
                    return;
                }
                if (this.roomNumUpt == null || this.roomNumUpt == '') {
                    this.$message.error("请填写入住房号");
                    return;
                }
                if (this.fromTypeUpt == null || this.fromTypeUpt == '') {
                    this.$message.error("请选择来源");
                    return;
                }
                console.log(this.checkinDateUpt);
                this.$http.post('http://127.0.0.1:8888/order/edit', {
                        id: this.id,
                        hotelId: this.hotelIdUpt,
                        houseType: this.houseTypeUpt,
                        // checkinDate: (this.checkinDateUpt == null) || (this.checkinDateUpt == '') ? null : this.$moment(this.checkinDateUpt).format('YYYY-MM-DD'),
                        checkinDate: this.checkinDateUpt,
                        price: this.housePriceUpt,
                        status: this.statusUpt,
                        deleted: this.deletedUpt,
                        roomNum: this.roomNumUpt,
                        remark: this.remakeUpt,
                        fromType: this.fromTypeUpt
                    },
                    {
                        emulateJSON: true
                    }).then((res) => {
                    if (res.body.status != 200) {
                        this.$message.error(res.body.msg)
                    } else {
                        this.orderInfoList();
                        this.$message.success("修改成功")
                        this.dialogVisibleUp = false;
                    }
                })
            },
            //获取订单详情（用户信息和酒店信息）
            orderDetail(row) {
                this.dialogVisible = true;
                this.$http.get('http://127.0.0.1:8888/order/detail', {params: {id: row.id}}).then(function (res) {
                    this.userInfo = res.body.data.userInfo;
                    let certType = this.userInfo.certType;
                    if (certType == '1') {
                        this.userInfo.certType = '身份证';
                    } else if (certType == '2') {
                        this.userInfo.certType = '港澳通行证';
                    } else if (certType == '3') {
                        this.userInfo.certType = '护照';
                    } else if (certType == '4') {
                        this.userInfo.certType = '回乡证';
                    } else {
                        this.userInfo.certType = '';
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
                    if (this.userInfo.hsRgCheckDate != null && this.userInfo.hsRgCheckDate != '') {
                        this.userInfo.hsRgCheckDate = this.userInfo.hsRgCheckDate.slice(0, 10);
                    }
                    if (this.userInfo.sqCheckDate != null && this.userInfo.sqCheckDate != '') {
                        this.userInfo.sqCheckDate = this.userInfo.sqCheckDate.slice(0, 10);
                    }
                    if (this.userInfo.checkDate != null && this.userInfo.checkDate != '') {
                        this.userInfo.checkDate = this.userInfo.checkDate.slice(0, 10);
                    }
                    this.hotelInfo = res.body.data.hotelInfo;
                })
            },
            //多选列表
            handleSelectionChange(val) {
                this.multipleSelection = [];
                for (let i = 0; i < val.length; i++) {
                    this.multipleSelection.push(val[i].id);
                }
            },
            //删除订单
            deleteOrder(id) {
                this.$http.delete('http://127.0.0.1:8888/order/delete', {params: {'id': id}}).then((res) => {
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
                        this.orderInfoList();
                    }
                })
            },
            //批量删除订单
            deleteOrderList() {
                if (this.multipleSelection.length == 0) {
                    this.$message.error("请选择要删除的信息");
                    return;
                }
                let jsonStr = "";
                for (let i = 0; i < this.multipleSelection.length; i++) {
                    if (i == this.multipleSelection.length - 1) {
                        jsonStr = jsonStr + this.multipleSelection[i]
                    } else {
                        jsonStr = jsonStr + this.multipleSelection[i] + ","
                    }
                }
                jsonStr = jsonStr + ""
                this.$http.post('http://127.0.0.1:8888/order/deleteList', {'idList': jsonStr}, {emulateJSON: true}).then((res) => {
                    if (res.body.status != 200) {
                        this.$message.error(res.body.msg);
                    } else {
                        this.$message.success("删除成功");
                        this.orderInfoList();
                    }
                })
            },
            //打开批量转移弹窗
            openMt() {
                if (this.multipleSelection.length == 0) {
                    this.$message.error("请选择需要转移的信息");
                    return;
                }
                this.dialogVisibleMt = true;
                this.selectionListMt = this.multipleSelection;
            },
            //批量转移
            massTransfer() {
                if (this.hotelMt == null) {
                    this.$message.error("请选择酒店");
                    return;
                }
                let jsonStr = "";
                for (let i = 0; i < this.selectionListMt.length; i++) {
                    if (i == this.selectionListMt.length - 1) {
                        jsonStr = jsonStr + this.selectionListMt[i]
                    } else {
                        jsonStr = jsonStr + this.selectionListMt[i] + ","
                    }
                }
                jsonStr = jsonStr + "";
                this.$http.post('http://127.0.0.1:8888/order/mass/transfer', {
                    idList: jsonStr,
                    hotelId: this.hotelMt
                }, {emulateJSON: true}).then((res) => {
                    if (res.body.status == 200) {
                        this.$message.success("批量转移成功")
                    } else {
                        this.$message.error(res.body.msg)
                    }
                    this.districtMt = null;
                    this.streetMt = null;
                    this.hotelMt = null;
                    this.selectionListMt = [];
                    this.dialogVisibleMt = false;
                    this.orderInfoList();
                })
            },
            //导出订单列表
            exportOrderInfoList() {
                if (!this.district) {
                    this.district = '';
                }
                if (!this.street) {
                    this.street = '';
                }
                if (!this.status) {
                    this.status = '';
                }
                if (!this.hotelType) {
                    this.hotelType = '';
                }
                if (!this.checkinDate) {
                    this.checkinDate = '';
                }
                if (!this.hotelName) {
                    this.hotelName = '';
                }
                if (!this.remark) {
                    this.remark = '';
                }
                if (!this.oriRemark) {
                    this.oriRemark = '';
                }
                if (!this.portType) {
                    this.portType = '';
                }
                let url = 'http://127.0.0.1:8888/order/export?';
                url = url + 'district=' + this.district + '&street=' + this.street + '&status=' + this.status
                    + '&portType=' + this.portType + '&hotelType=' + this.hotelType + '&checkinDate=' + this.checkinDate
                    + '&hotelName=' + this.hotelName + '&remark=' + this.remark + '&oriRemark=' + this.oriRemark;
                window.open(url)
            },
            handleRemove(file, fileList) {
                console.log(file, fileList);
            },
            handlePreview(file) {
                console.log(file.type);
            },
            //上传文件的校验
            handleExceed(files, fileList) {
                this.$message.warning(`当前限制选择2个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
            },
            handleAvatarSuccess(res) {
                if (res.status == 200) {
                    this.$message.success("上传成功")
                    this.orderInfoList(null, 1);
                } else {
                    this.$message.error(res.msg)
                }
                this.fileList = [];
            }
        },
        mounted() {
            this.getHotelTypesList();
            this.getDistrictList();
        },
        created() {
            this.orderInfoList(this.pageSize, this.currentPage)
        },
    }


</script>

<style scoped>

</style>