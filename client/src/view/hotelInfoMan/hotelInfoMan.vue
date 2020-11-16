<template>
    <body>
    <div class="wrap contents-body">
        <div class="item-title_box">
            <div class="item-title supervision-list-line"><span>酒店信息管理</span></div>
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
                <el-select v-model="deleted" placeholder="是否删除">
                    <el-option label="未删除" value="0"></el-option>
                    <el-option label="已删除" value="1"></el-option>
                </el-select>
            </div>
            <div class="layui-inline">
                <el-select v-model="notshow" placeholder="是否显示">
                    <el-option label="展示" value="0"></el-option>
                    <el-option label="不展示" value="1"></el-option>
                </el-select>
            </div>
            <div class="layui-inline">
                <el-select v-model="hotelTypes" placeholder="酒店类型">
                    <el-option
                            v-for="item in hotelTypesList"
                            :key="item.id"
                            :label="item.itemName"
                            :value="item.id">
                    </el-option>
                </el-select>
            </div>
            <div class="layui-inline">
                <input type="text" v-model="hotelName" placeholder="搜索酒店名称" class="layui-input">
            </div>

            <button class="layui-btn layui-btn-normal layui-btn-sm" @click="hotelInfoList()">搜索</button>
            <button class="layui-btn layui-btn-normal layui-btn-sm" @click="reset">重置</button>
            <button class="layui-btn layui-btn-normal layui-btn-sm" @click="openAdd">新增</button>
            <div class="supervision-list-table">
                <el-table
                        :data="tableData.slice((currentPage-1)*pageSize,currentPage*pageSize)"
                        style="width: 100%">
                    <el-table-column
                            prop="hotelName"
                            label="酒店名称"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="hotelOtherName"
                            label="别名"
                            width="300">
                    </el-table-column>
                    <el-table-column
                            prop="hotelTypes"
                            label="类型"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="todayCheckInCount"
                            label="今日入住数"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="todayCheckOutCount"
                            label="今日退房数"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="todayOrderCount"
                            label="今日预约数"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="todayRemindCount"
                            label="今日剩余数"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="district"
                            label="酒店所在区域"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="address"
                            label="酒店详细地址"
                            width="250">
                    </el-table-column>
                    <el-table-column
                            prop="contractUser"
                            label="酒店联系人"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="contractMobile"
                            label="联系方式"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="action"
                            label="操作"
                            width="300">
                        <template slot-scope="scope">
                            <el-button
                                    size="mini"
                                    @click="openUpdate(scope.row)">编辑
                            </el-button>
                            <el-button
                                    size="mini"
                                    @click="openAllocationOfHousing(scope.row)">分配房源
                            </el-button>
                            <el-button
                                    size="mini"
                                    type="danger"
                                    @click="handleDelete(scope.row.id)">删除
                            </el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <div class="block">
                    <el-pagination
                            @size-change="handleSizeChange"
                            @current-change="handleCurrentChange"
                            :page-sizes="[5, 10, 20, 40]"
                            :current-page="currentPage"
                            :page-size="pageSize"
                            layout="total, sizes, prev, pager, next, jumper"
                            :total="tableData.length">
                    </el-pagination>
                </div>
            </div>
        </div>

        <div class="supervision-list-table">
        </div>
        <div id="pages"></div>
    </div>
    <el-dialog title="新增酒店" :visible.sync="dialogVisibleAdd" :close-on-click-modal="true" :modal="true"
               :show-close="true"
               :center="true">
        <span slot="footer" class="dialog-footer">
        <el-button @click="cancelAdd">取 消</el-button>
        <el-button type="primary" @click="addHotelInfo">确 定</el-button>
        </span>
        <table>
            <tr>
                <td>
                    酒店名称：
                    <el-input v-model="hotelNameAdd"></el-input>
                </td>
                <td>
                    酒店别名：
                    <el-input v-model="hotelOtherNameAdd"></el-input>
                </td>
                <td>
                    联系人：
                    <el-input v-model="contractUserAdd"></el-input>
                </td>
                <td>
                    联系电话：
                    <el-input v-model="contractMobileAdd"></el-input>
                </td>
                <td>
                    酒店类型：
                    <el-select v-model="hotelTypeAdd" placeholder="酒店类型" @change="hotelTypesChoice(hotelTypeAdd)">
                        <el-option
                                v-for="item in hotelTypesList"
                                :key="item.id"
                                :label="item.itemName"
                                :value="item">
                        </el-option>
                    </el-select>
                </td>
                <td>
                    详细地址：
                    <el-input v-model="addressAdd"></el-input>
                </td>
            </tr>
            <tr>


                <td>
                    区：
                    <el-select v-model="districtAdd" @change="getStreetListAdd(districtAdd)">
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
                    <el-select v-model="streetAdd">
                        <el-option
                                v-for="item in streetAddList"
                                :key="item"
                                :label="item"
                                :value="item">
                        </el-option>
                    </el-select>
                </td>
                <td>
                    备注：
                    <el-input v-model="remarkAdd"></el-input>
                </td>
                <td>
                    是否删除：
                    <el-select v-model="deletedAdd">
                        <el-option label="未删除" value="0"></el-option>
                        <el-option label="已删除" value="1"></el-option>
                    </el-select>
                </td>
            </tr>
            <tr>
            </tr>
            <tr>
                <td>
                    是否展示：
                    <el-select v-model="notshowAdd">
                        <el-option label="展示" value="0"></el-option>
                        <el-option label="不展示" value="1"></el-option>
                    </el-select>
                </td>
                <td>
                    酒店登陆账号：
                    <el-input v-model="hotelUsernameAdd"></el-input>
                </td>
                <td>
                    酒店登陆密码：
                    <el-input v-model="hotelPasswordAdd"></el-input>
                </td>
                <td>
                    管控时间：
                    <el-date-picker
                            v-model="controlDateAdd"
                            type="date"
                            placeholder="选择日期">
                    </el-date-picker>
                </td>
                <td>
                    区政府是否上报：
                    <el-select v-model="isReportAdd">
                        <el-option label="否" value="0"></el-option>
                        <el-option label="是" value="1"></el-option>
                    </el-select>
                </td>
            </tr>
            <tr>
                <td>
                    可预约日期：
                    <el-date-picker
                            v-model="reserveDateAdd"
                            type="date"
                            placeholder="选择日期">
                    </el-date-picker>
                </td>
                <td>
                    区政府是否上报：
                    <el-select v-model="isReportAdd">
                        <el-option label="否" value="0"></el-option>
                        <el-option label="是" value="1"></el-option>
                    </el-select>
                </td>
                <td>
                    房源：
                    <el-select v-model="areaTypeAdd">
                        <el-option label="深圳房源" value="1"></el-option>
                        <el-option label="珠海房源" value="2"></el-option>
                        <el-option label="其他城市" value="3"></el-option>
                    </el-select>
                </td>
            </tr>
        </table>
    </el-dialog>
    <el-dialog title="编辑" :visible.sync="dialogVisibleUpdate" :close-on-click-modal="true" :modal="true"
               :show-close="true"
               :center="true">
        <span slot="footer" class="dialog-footer">
        <el-button @click="cancelUpdate">取 消</el-button>
        <el-button type="primary" @click="updateHotel">确 定</el-button>
        </span>
        <table>
            <tr>
                <td>
                    酒店名称：
                    <el-input v-model="hotelNameUpdate"></el-input>
                </td>
                <td>
                    酒店别名：
                    <el-input v-model="hotelOtherNameUpdate"></el-input>
                </td>
                <td>
                    联系人：
                    <el-input v-model="contractUserUpdate"></el-input>
                </td>
                <td>
                    联系电话：
                    <el-input v-model="contractMobileUpdate"></el-input>
                </td>
                <td>
                    详细地址：
                    <el-input v-model="addressUpdate"></el-input>
                </td>
            </tr>
            <tr>
                <td>
                    酒店类型:
                    <el-select v-model="hotelTypeUpdate" @change="updateHotelTypes(hotelTypeUpdate)">
                        <el-option
                                v-for="item in hotelTypesList"
                                :key="item.id"
                                :label="item.itemName"
                                :value="item">
                        </el-option>
                    </el-select>
                </td>
                <td>
                    区：
                    <el-select v-model="districtUpdate" @change="getStreetListUpdate(districtUpdate)">
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
                    <el-select v-model="streetUpdate">
                        <el-option
                                v-for="item in streetUpdateList"
                                :key="item"
                                :label="item"
                                :value="item">
                        </el-option>
                    </el-select>
                </td>
                <td>
                    备注：
                    <el-input v-model="remarkUpdate"></el-input>
                </td>
            </tr>
            <tr>
                <td>
                    <span>是否删除：</span>
                    <el-select v-model="deletedUpdate">
                        <el-option value='true' label="未删除"></el-option>
                        <el-option value="false" label="已删除"></el-option>
                    </el-select>
                </td>
                <td>
                    是否展示：
                    <el-select v-model="notshowUpdate">
                        <el-option label="展示" value="true"></el-option>
                        <el-option label="不展示" value="false"></el-option>
                    </el-select>
                </td>
                <td>
                    区政府是否上报：
                    <el-select v-model="isReportUpdate">
                        <el-option label="否" value="0"></el-option>
                        <el-option label="是" value="1"></el-option>
                    </el-select>
                </td>
                <td>
                    房源：
                    <el-select v-model="areaTypeUpdate">
                        <el-option label="深圳房源" value="1"></el-option>
                        <el-option label="珠海房源" value="2"></el-option>
                        <el-option label="其他城市" value="3"></el-option>
                    </el-select>
                </td>
            </tr>
            <tr>
                <td>
                    酒店登陆账号：
                    <el-input v-model="hotelUsernameUpdate"></el-input>
                </td>
                <td>
                    酒店登陆密码：
                    <el-input v-model="hotelPasswordUpdate"></el-input>
                </td>
            </tr>
        </table>
    </el-dialog>
    <el-dialog title="分配房源" :visible.sync="dialogVisibleAOH" :close-on-click-modal="true" :modal="true"
               :show-close="true"
               :center="true">
        <span slot="footer" class="dialog-footer">
        <el-button @click="cancelAllocation">取 消</el-button>
        <el-button type="primary" @click="allocationOfHousing">确 定</el-button>
        </span>
        <table>
            <tr>
                <td>
                    房型1：
                </td>
                <td>
                    <el-input-number v-model="house1TotalCount"></el-input-number>
                </td>
            </tr>
            <tr>
                <td>
                    房型2：
                </td>
                <td>
                    <el-input-number v-model="house2TotalCount"></el-input-number>
                </td>
            </tr>
            <tr>
                <td>
                    房型3：
                </td>
                <td>
                    <el-input-number v-model="house3TotalCount"></el-input-number>
                </td>
            </tr>
            <tr>
                <td>
                    房型4：
                </td>
                <td>
                    <el-input-number v-model="house4TotalCount"></el-input-number>
                </td>
            </tr>
            <tr>
                <td>
                    房型5：
                </td>
                <td>
                    <el-input-number v-model="house5TotalCount"></el-input-number>
                </td>
            </tr>
            <tr>
                <td>
                    房型6：
                </td>
                <td>
                    <el-input-number v-model="house6TotalCount"></el-input-number>
                </td>
            </tr>
        </table>
    </el-dialog>
    </body>
</template>

<script>
    import '../../../static/layui/css/layui.css'
    import '../../assets/css/global.css'
    import '../../assets/css/master.css'

    export default {
        name: "hotelInfoMan",
        data() {
            return {
                tableData: [],
                hotelTypesList: [],
                districtList: [],
                streetList: [],
                deleted: null,
                checkinDate: null,
                hotelName: null,
                hotelTypes: null,
                district: null,
                street: null,
                portType: null,
                notshow: null,
                currentPage: 1,
                pageSize: 10,
                dialogVisibleAdd: false,
                dialogVisibleUpdate: false,
                dialogVisibleAOH: false,

                house1TotalCount: null,
                house2TotalCount: null,
                house3TotalCount: null,
                house4TotalCount: null,
                house5TotalCount: null,
                house6TotalCount: null,

                hotelTypeAdd: null,
                hotelTypeAddList: [],
                districtAdd: null,
                districtAddList: null,
                streetAddList: null,
                streetAdd: null,
                deletedAdd: null,
                notshowAdd: null,
                isReportAdd: null,
                areaTypeAdd: null,
                hotelNameAdd: null,
                hotelOtherNameAdd: null,
                contractUserAdd: null,
                contractMobileAdd: null,
                addressAdd: null,
                remarkAdd: null,
                addDateAdd: null,
                modifyDateAdd: null,
                hotelUsernameAdd: null,
                hotelPasswordAdd: null,
                controlDateAdd: null,
                reserveDateAdd: null,

                updateId: null,
                hotelTypeUpdate: null,
                districtUpdate: null,
                districtUpdateList: null,
                streetUpdateList: null,
                streetUpdate: null,
                deletedUpdate: null,
                notshowUpdate: null,
                isReportUpdate: null,
                areaTypeUpdate: null,
                hotelNameUpdate: null,
                hotelOtherNameUpdate: null,
                contractUserUpdate: null,
                contractMobileUpdate: null,
                addressUpdate: null,
                remarkUpdate: null,
                addDateUpdate: null,
                modifyDateUpdate: null,
                hotelUsernameUpdate: null,
                hotelPasswordUpdate: null,
                controlDateUpdate: null,
                reserveDateUpdate: null,
                hotelTypesListUpate: [],

                allocationId: null,
            }
        },
        methods: {
            // 初始页currentPage、初始每页数据数pagesize和数据data
            handleSizeChange: function (size) {
                this.pageSize = size;
            },
            handleCurrentChange: function (currentPage) {
                this.currentPage = currentPage;
            },
            getHotelTypesList() {
                this.$http.get('http://127.0.0.1:8888/config/list', {params: {parentId: 1005}}).then(function (res) {
                    this.hotelTypesList = res.body.data;
                })
            },
            getDistrictList() {
                this.$http.get('http://127.0.0.1:8888/hotel/district/list').then(function (res) {
                    this.districtList = res.body.data;
                    this.districtAddList = this.districtList;
                })
            },
            getStreetList(district) {
                this.$http.get('http://127.0.0.1:8888/hotel/street/list', {params: {district: district}}).then(function (res) {
                    this.street = null;
                    this.streetList = res.body.data;
                })
            },
            getStreetListAdd(district) {
                this.$http.get('http://127.0.0.1:8888/hotel/street/list', {params: {district: district}}).then(function (res) {
                    this.streetAdd = null;
                    this.streetAddList = res.body.data;
                })
            },
            getStreetListUpdate(district) {
                this.streetUpdate = null;
                this.$http.get('http://127.0.0.1:8888/hotel/street/list', {params: {district: district}}).then(function (res) {
                    this.streetUpdateList = res.body.data;
                })
            },
            reset() {
                this.district = null,
                    this.street = null,
                    this.deleted = null,
                    this.notshow = null,
                    this.hotelTypes = null,
                    this.hotelName = null
            },
            hotelInfoList() {
                this.$http.post('http://127.0.0.1:8888/hotel/info/list', {
                    district: this.district,
                    street: this.street,
                    deleted: this.deleted,
                    notshow: this.notshow,
                    hotelTypes: this.hotelTypes,
                    hotelName: this.hotelName
                }, {emulateJSON: true}).then(function (res) {
                    res.body.data.map((item => {
                        if (item.configList != null && item.configList.length > 0) {
                            let str = "";
                            let arr = item.configList;
                            let length = item.configList.length;
                            for (let i = 0; i < length; i++) {
                                if (i == length - 1) {
                                    str = str + arr[i].itemName;
                                } else {
                                    str = str + arr[i].itemName + "，";
                                }
                            }
                            item.hotelTypes = str;
                        }
                    }))
                    this.tableData = res.body.data;
                })
            },
            openAdd() {
                this.dialogVisibleAdd = true;
            },
            openUpdate(row) {
                this.updateId = row.id;
                this.streetUpdate = null,
                    this.dialogVisibleUpdate = true;
                this.hotelTypesListUpate = row.configList;
                if (this.hotelTypesListUpate != null && this.hotelTypesListUpate.length > 0) {
                    let str = [];
                    this.hotelTypesListUpate.map(function (item) {
                        str.push(item.itemName);
                    });
                    this.hotelTypeUpdate = str;
                }
                if (row.district != null) {
                    this.streetUpdateList = this.getStreetListUpdate(row.district);
                    this.streetUpdate = row.street
                }
                this.districtUpdate = row.district,
                    this.areaTypeUpdate = row.areaType,
                    this.hotelNameUpdate = row.hotelName,
                    this.hotelOtherNameUpdate = row.hotelOtherName,
                    this.contractUserUpdate = row.contractUser,
                    this.contractMobileUpdate = row.contractMobile,
                    this.addressUpdate = row.address,
                    this.remarkUpdate = row.remark,
                    this.hotelUsernameUpdate = row.hotelUsername,
                    this.hotelPasswordUpdate = row.hotelPassword,
                    this.controlDateUpdate = row.controlDate,
                    this.reserveDateUpdate = row.reserveDate,
                    this.deletedUpdate = row.deleted.toString(),
                    this.notshowUpdate = row.notshow.toString(),
                    this.isReportUpdate = row.isReport.toString(),
                    this.areaTypeUpdate = row.areaType.toString()
            },
            openAllocationOfHousing(row) {
                this.dialogVisibleAOH = true;
                this.allocationId = row.id;
            },
            resetAllocation() {
                this.allocationId = null;
                this.house1TotalCount = null;
                this.house2TotalCount = null;
                this.house3TotalCount = null;
                this.house4TotalCount = null;
                this.house5TotalCount = null;
                this.house6TotalCount = null;
            },
            allocationOfHousing() {
                this.$http.post('http://127.0.0.1:8888/hotel/house/allocation', {
                    id: this.allocationId,
                    house1TotalCount: this.house1TotalCount,
                    house2TotalCount: this.house2TotalCount,
                    house3TotalCount: this.house3TotalCount,
                    house4TotalCount: this.house4TotalCount,
                    house5TotalCount: this.house5TotalCount,
                    house6TotalCount: this.house6TotalCount,
                }, {emulateJSON: true}).then(function (res) {
                    if (res.body.status == 200) {
                        this.$message.success("分配成功")
                        this.hotelInfoList();
                    } else {
                        this.$message.error("分配失败")
                    }
                })
                this.dialogVisibleAOH = false;
                this.resetAllocation();
            },
            cancelAllocation() {
                this.dialogVisibleAOH = false;
                this.resetAllocation();
            },
            addHotelInfo() {
                if (this.hotelTypeAdd == null || this.hotelTypeAdd == '') {
                    this.$message.error("请选择酒店类型")
                    return;
                }
                let hotelTypes = "";
                if (this.hotelTypeAddList.length > 0) {
                    let length = this.hotelTypeAddList.length;
                    for (let i = 0; i < length; i++) {
                        if (i == length - 1) {
                            hotelTypes = hotelTypes + this.hotelTypeAddList[i].id;
                        } else {
                            hotelTypes = hotelTypes + this.hotelTypeAddList[i].id + ",";
                        }
                    }
                }
                if (this.hotelNameAdd == null) {
                    this.$message.error("请输入酒店名称")
                    return;
                }
                this.$http.post('http://127.0.0.1:8888/hotel/info/add', {
                    hotelTypes: hotelTypes,
                    district: this.districtAdd,
                    street: this.streetAdd,
                    deleted: this.deletedAdd,
                    notshow: this.notshowAdd,
                    isReport: this.isReportAdd,
                    areaType: this.areaTypeAdd,
                    hotelName: this.hotelNameAdd,
                    hotelOtherName: this.hotelOtherNameAdd,
                    contractUser: this.contractUserAdd,
                    contractMobile: this.contractMobileAdd,
                    address: this.addressAdd,
                    remark: this.remarkAdd,
                    hotelUsername: this.hotelUsernameAdd,
                    hotelPassword: this.hotelPasswordAdd,
                    controlDate: (this.controlDateAdd == null) || (this.controlDateAdd == '') ? null : this.$moment(this.controlDateAdd).format('YYYY-MM-DD'),
                    reserveDate: (this.reserveDateAdd == null) || (this.reserveDateAdd == '') ? null : this.$moment(this.reserveDateAdd).format('YYYY-MM-DD'),
                }, {emulateJSON: true}).then(function (res) {
                    if (res.status == 200) {
                        this.$message.success("新增成功")
                    } else {
                        this.$message.error("新增失败")
                    }
                    this.dialogVisibleAdd = false;
                    this.hotelInfoList();
                    this.clearAdd();
                })

            },
            cancelAdd() {
                this.dialogVisibleAdd = false;
                this.clearAdd();
            },
            clearAdd() {
                this.hotelTypeAddList = null;
                this.districtAdd = null;
                this.streetAdd = null;
                this.deletedAdd = null;
                this.notshowAdd = null;
                this.isReportAdd = null;
                this.areaTypeAdd = null;
                this.hotelNameAdd = null;
                this.hotelOtherNameAdd = null;
                this.contractUserAdd = null;
                this.contractMobileAdd = null;
                this.addressAdd = null;
                this.remarkAdd = null;
                this.addDateAdd = null;
                this.modifyDateAdd = null;
                this.hotelUsernameAdd = null;
                this.hotelPasswordAdd = null;
                this.controlDateAdd = null;
                this.reserveDateAdd = null;
            },
            updateHotel() {
                let hotelTypes = "";
                if (this.hotelTypesListUpate.length > 0) {
                    let length = this.hotelTypesListUpate.length;
                    for (let i = 0; i < length; i++) {
                        if (i == length - 1) {
                            hotelTypes = hotelTypes + this.hotelTypesListUpate[i].id;
                        } else {
                            hotelTypes = hotelTypes + this.hotelTypesListUpate[i].id + ",";
                        }
                    }
                }
                let data = {
                    id: this.updateId
                };
                data.hotelName = this.hotelNameUpdate;
                data.hotelOtherName = this.hotelOtherNameUpdate;
                data.hotelTypes = hotelTypes;
                data.district = this.districtUpdate;
                data.street = this.streetUpdate;
                data.areaType = this.areaTypeUpdate;
                data.contractUser = this.contractUserUpdate;
                data.contractMobile = this.contractMobileUpdate;
                data.address = this.addressUpdate;
                data.hotelUsername = this.hotelUsernameUpdate;
                data.hotelPassword = this.hotelPasswordUpdate;
                data.remark = this.remarkUpdate;
                data.deleted = this.deletedUpdate,
                    data.notshow = this.notshowUpdate,
                    data.isReport = this.isReportUpdate,
                    data.areaType = this.areaTypeUpdate,
                    this.$http.post('http://127.0.0.1:8888/hotel/info/update', data, {emulateJSON: true}).then(function (res) {
                        if (res.status == 200) {
                            this.$message.success("修改成功")
                        } else {
                            this.$message.error("修改失败")
                        }
                        this.dialogVisibleUpdate = false;
                        this.hotelInfoList();
                        this.clearUpdate();
                    })
            },
            cancelUpdate() {
                this.dialogVisibleUpdate = false;
                this.clearUpdate();
            },
            clearUpdate() {
                this.hotelTypesListUpate = null;
                this.hotelTypeUpdate = null;
                this.updateId = null;
                this.districtUpdate = null;
                this.streetUpdate = null;
                this.deletedUpdate = null;
                this.notshowUpdate = null;
                this.isReportUpdate = null;
                this.areaTypeUpdate = null;
                this.hotelNameUpdate = null;
                this.hotelOtherNameUpdate = null;
                this.contractUserUpdate = null;
                this.contractMobileUpdate = null;
                this.addressUpdate = null;
                this.remarkUpdate = null;
                this.addDateUpdate = null;
                this.modifyDateUpdate = null;
                this.hotelUsernameUpdate = null;
                this.hotelPasswordUpdate = null;
                this.controlDateUpdate = null;
                this.reserveDateUpdate = null;
            },
            handleDelete(id) {
                this.$http.get('http://127.0.0.1:8888/hotel/info/delete', {params: {id: id}}).then(function (res) {
                    if (res.status == 200) {
                        this.$message.success("删除成功")
                    } else {
                        this.$message.error("删除失败")
                    }
                    this.hotelInfoList();
                })
            },
            hotelTypesChoice(hotelTypeAdd) {
                let list = [];
                if (this.hotelTypeAddList == null) {
                    this.hotelTypeAddList = [];
                }
                if (this.hotelTypeAddList.length > 0) {
                    if (this.hotelTypeAddList.includes(hotelTypeAdd)) {
                        let index = this.hotelTypeAddList.indexOf(hotelTypeAdd);
                        this.hotelTypeAddList.splice(index, 1)
                    } else {
                        this.hotelTypeAddList.push(hotelTypeAdd);
                    }
                } else {
                    this.hotelTypeAddList.push(hotelTypeAdd);
                }
                for (let i = 0; i < this.hotelTypeAddList.length; i++) {
                    list.push(this.hotelTypeAddList[i].itemName);
                }
                this.hotelTypeAdd = list;
            },
            updateHotelTypes(hotelTypeUpdate) {
                let list = [];
                let list2 = [];
                if (this.hotelTypesListUpate != null && this.hotelTypesListUpate.length > 0) {
                    this.hotelTypesListUpate.map(function (item) {
                        list2.push(item.id);
                    })
                } else {
                    this.hotelTypesListUpate = [];
                }
                if (list2.length > 0) {
                    if (list2.includes(hotelTypeUpdate.id)) {
                        let index = list2.indexOf(hotelTypeUpdate.id);
                        this.hotelTypesListUpate.splice(index, 1)
                    } else {
                        this.hotelTypesListUpate.push(hotelTypeUpdate);
                    }
                } else {
                    this.hotelTypesListUpate.push(hotelTypeUpdate);
                }
                this.hotelTypesListUpate.map(function (hotelType) {
                    list.push(hotelType.itemName);
                })
                this.hotelTypeUpdate = list;
            }
        },
        mounted() {
            this.getHotelTypesList();
            this.getDistrictList();
        }
    }
</script>

<style scoped>

</style>