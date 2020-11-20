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
                    <el-option label="未删除" value=0></el-option>
                    <el-option label="已删除" value=1></el-option>
                </el-select>
            </div>
            <div class="layui-inline">
                <el-select v-model="notshow" placeholder="是否显示">
                    <el-option label="展示" value=0></el-option>
                    <el-option label="不展示" value=1></el-option>
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

            <button class="layui-btn layui-btn-normal layui-btn-sm" @click="hotelInfoList(null,1)">搜索</button>
            <button class="layui-btn layui-btn-normal layui-btn-sm" @click="reset">重置</button>
            <button class="layui-btn layui-btn-normal layui-btn-sm" @click="openAdd">新增</button>
            <div class="supervision-list-table">
                <el-table
                        :data="tableData"
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
                    <el-input v-model="hotelPasswordAdd" show-password></el-input>
                </td>
                <td>
                    确认酒店登陆密码：
                    <el-input v-model="confirmHotelPasswordAdd" show-password></el-input>
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
                    是否展示：
                    <el-select v-model="notshowUpdate">
                        <el-option label="展示" value="0"></el-option>
                        <el-option label="不展示" value="1"></el-option>
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
                        <el-option label="深圳房源" value=1></el-option>
                        <el-option label="珠海房源" value=2></el-option>
                        <el-option label="其他城市" value=3></el-option>
                    </el-select>
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
                confirmHotelPasswordAdd: null,
                controlDateAdd: null,
                reserveDateAdd: null,
                hotelTypesIdList: null,

                updateId: null,
                hotelTypeUpdate: null,
                districtUpdate: null,
                districtUpdateList: null,
                streetUpdateList: null,
                streetUpdate: null,
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
                confirmHotelPasswordUpdate: null,
                controlDateUpdate: null,
                reserveDateUpdate: null,
                hotelTypesListUpate: [],
                hotelTypeUpdateIdList: null,

                allocationId: null,

                pageSize: 10,    //每页的数据
                currentPage: 1,//第几页
                totalCount: 1,//总条数

                isHotelNameExist: false,
                isHotelOtherNameExist: false,
            }
        },
        methods: {
            //每页显示的条数
            handleSizeChange(val) {
                this.pageSize = val
                this.hotelInfoList(val, 1)
                this.currentPage = 1
            },
            //显示第几页
            handleCurrentChange(val) {
                this.currentPage = val
                this.hotelInfoList(this.pageSize, val)
            },
            //获取酒店类型列表
            getHotelTypesList() {
                this.$http.get('http://127.0.0.1:8888/config/list', {params: {parentId: 1005}}).then(function (res) {
                    this.hotelTypesList = res.body.data;
                })
            },
            //获取区域列表
            getDistrictList() {
                this.$http.get('http://127.0.0.1:8888/hotel/district/list').then(function (res) {
                    this.districtList = res.body.data;
                    this.districtAddList = this.districtList;
                })
            },
            //获取街道列表
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
            //重置查询条件
            reset() {
                this.district = null,
                    this.street = null,
                    this.deleted = null,
                    this.notshow = null,
                    this.hotelTypes = null,
                    this.hotelName = null
            },
            //获取酒店列表
            hotelInfoList(pageSize, pageNum) {
                let data = {
                    district: this.district,
                    street: this.street,
                    hotelTypes: this.hotelTypes,
                    hotelName: this.hotelName,
                }
                if (this.deleted != null) {
                    data.deleted = this.deleted;
                } else {
                    data.deleted = -1;
                }
                if (this.notshow != null) {
                    data.notshow = this.notshow
                } else {
                    data.notshow = -1;
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
                this.$http.post('http://127.0.0.1:8888/hotel/list', data, {emulateJSON: true}).then(function (res) {
                    this.tableData = res.body.data.list;
                    this.totalCount = res.body.data.total
                    this.getHotelTypesList();
                    let list = this.hotelTypesList;
                    this.tableData.map((item => {
                        if (item.hotelTypes != null && item.hotelTypes != '') {
                            let hotelTypesList = item.hotelTypes.split(',');
                            let str = '';
                            for (let i = 0; i < hotelTypesList.length; i++) {
                                for (let j = 0; j < list.length; j++) {
                                    if (hotelTypesList[i] == list[j].id) {
                                        if (i == hotelTypesList.length - 1) {
                                            str = str + list[j].itemValue;
                                        } else {
                                            str = str + list[j].itemValue + ',';
                                        }
                                    }
                                }
                            }
                            item.hotelTypes = str;
                            item.hotelList = hotelTypesList;
                        }
                    }))
                })
            },
            //打开新增酒店弹框
            openAdd() {
                this.hotelTypeAdd = null;
                this.hotelTypesIdList = null;
                this.hotelTypeAddList = null;
                this.dialogVisibleAdd = true;
            },
            //打开修改酒店弹框
            openUpdate(row) {
                if (row.deleted == true) {
                    row.deleted = '1'
                } else {
                    row.deleted = '0'
                }
                if (row.notshow == true) {
                    row.notshow = '1'
                } else {
                    row.notshow = '0'
                }
                this.hotelTypeUpdateIdList = '';
                this.hotelTypesListUpate = null;
                this.updateId = row.id;
                this.streetUpdate = null,
                    this.dialogVisibleUpdate = true;
                this.hotelTypesListUpate = row.hotelList;
                if (this.hotelTypesListUpate != null && this.hotelTypesListUpate.length > 0) {
                    let str = '';
                    let list = this.hotelTypesList;
                    for (let i = 0; i < this.hotelTypesListUpate.length; i++) {
                        for (let j = 0; j < list.length; j++) {
                            if (this.hotelTypesListUpate[i] == list[j].id) {
                                if (i == this.hotelTypesListUpate.length - 1) {
                                    str = str + list[j].itemValue;
                                    this.hotelTypeUpdateIdList = this.hotelTypeUpdateIdList + list[j].id.toString();
                                } else {
                                    str = str + list[j].itemValue + ',';
                                    this.hotelTypeUpdateIdList = this.hotelTypeUpdateIdList + list[j].id.toString() + ',';
                                }
                            }
                        }
                    }
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
                    this.confirmHotelPasswordUpdate = row.hotelPassword,
                    this.controlDateUpdate = row.controlDate,
                    this.reserveDateUpdate = row.reserveDate,
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
            //分配房源
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
                        this.$message.error(res.body.msg)
                    }
                })
                this.dialogVisibleAOH = false;
                this.resetAllocation();
            },
            //取消分配房源
            cancelAllocation() {
                this.dialogVisibleAOH = false;
                this.resetAllocation();
            },
            //增加酒店
            addHotelInfo() {
                if (this.hotelNameAdd == null || this.hotelNameAdd == '') {
                    this.$message.error("请输入酒店名称");
                    return;
                }
                if (this.hotelOtherNameAdd == null || this.hotelOtherNameAdd == '') {
                    this.$message.error("请输入酒店别名");
                    return;
                }
                if (this.contractUserAdd == null || this.contractUserAdd == '') {
                    this.$message.error("请输入联系人");
                    return;
                }
                if (this.contractMobileAdd == null || this.contractMobileAdd == '') {
                    this.$message.error("请输入联系电话");
                    return;
                } else {
                    const reg = /^1(3[0-9]|5[0-3,5-9]|7[1-3,5-8]|8[0-9])\d{8}$/;
                    if (!reg.test(this.contractMobileAdd)) {
                        this.$message.error("电话号码格式不正确");
                        return;
                    }
                }
                if (this.hotelTypeAdd == null || this.hotelTypeAdd == '') {
                    this.$message.error("请选择酒店类型");
                    return;
                }
                if (this.addressAdd == null || this.addressAdd == '') {
                    this.$message.error("请输入详细地址");
                    return;
                }
                if (this.districtAdd == null || this.districtAdd == '') {
                    this.$message.error("请选择区域");
                }
                if (this.streetAdd == null || this.streetAdd == '') {
                    this.$message.error("请选择街道");
                    return;
                }
                if (this.notshowAdd == null || this.notshowAdd == '') {
                    this.$message.error("请选择是否展示");
                    return;
                }
                if (this.hotelUsernameAdd == null || this.hotelUsernameAdd == '') {
                    this.$message.error("请输入酒店登录账号");
                    return;
                }
                if (this.hotelPasswordAdd == null || this.hotelPasswordAdd == '') {
                    this.$message.error("请输入酒店登录密码");
                    return;
                }
                if (this.hotelPasswordAdd.length < 8) {
                    this.$message.error("酒店登录密码不应少于8位");
                    return;
                }
                if (this.confirmHotelPasswordAdd == null || this.confirmHotelPasswordAdd == '') {
                    this.$message.error("请再次输入酒店登录密码")
                    return;
                }
                if (this.confirmHotelPasswordAdd != this.hotelPasswordAdd) {
                    this.$message.error("两次输入密码不一致")
                    return;
                }
                if (this.controlDateAdd == null || this.controlDateAdd == '') {
                    this.$message.error("请选择管控日期");
                    return;
                }
                if (this.isReportAdd == null || this.isReportAdd == '') {
                    this.$message.error("请选择是否上报");
                    return;
                }
                if (this.reserveDateAdd == null || this.reserveDateAdd == '') {
                    this.$message.error("请选择可预定日期");
                    return;
                }
                if (this.areaTypeAdd == null || this.areaTypeAdd == '') {
                    this.$message.error("请选择房源");
                    return;
                }
                let data = {
                    hotelTypes: this.hotelTypesIdList,
                    district: this.districtAdd,
                    street: this.streetAdd,
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
                }
                if (this.controlDateAdd != null && this.controlDateAdd != '') {
                    data.controlDate = this.$moment(this.controlDateAdd).format('YYYY-MM-DD')
                }
                if (this.reserveDateAdd != null && this.reserveDateAdd != '') {
                    data.reserveDate = this.$moment(this.reserveDateAdd).format('YYYY-MM-DD')
                }
                this.$http.post('http://127.0.0.1:8888/hotel/add', data, {emulateJSON: true}).then(function (res) {
                    if (res.body.status == 200) {
                        this.$message.success("新增成功")
                        this.dialogVisibleAdd = false;
                        this.hotelInfoList();
                        this.clearAdd();
                    } else {
                        this.$message.error(res.body.msg)
                    }
                })

            },
            cancelAdd() {
                this.dialogVisibleAdd = false;
                this.clearAdd();
            },
            clearAdd() {
                this.confirmHotelPasswordAdd = null;
                this.hotelTypeAddList = null;
                this.districtAdd = null;
                this.streetAdd = null;
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
            //修改酒店
            updateHotel() {
                if (this.hotelNameUpdate == null || this.hotelNameUpdate == '') {
                    this.$message.error("请输入酒店名称");
                    return;
                }
                if (this.hotelOtherNameUpdate == null || this.hotelOtherNameUpdate == '') {
                    this.$message.error("请输入酒店别名");
                    return;
                }
                if (this.contractUserUpdate == null || this.contractUserUpdate == '') {
                    this.$message.error("请输入联系人");
                    return;
                }
                if (this.contractMobileUpdate == null || this.contractMobileUpdate == '') {
                    this.$message.error("请输入联系电话");
                    return;
                } else {
                    const reg = /^1(3[0-9]|5[0-3,5-9]|7[1-3,5-8]|8[0-9])\d{8}$/;
                    if (!reg.test(this.contractMobileUpdate)) {
                        this.$message.error("电话号码格式不正确");
                        return;
                    }
                }
                if (this.hotelTypeUpdate == null || this.hotelTypeUpdate == '') {
                    this.$message.error("请选择酒店类型");
                    return;
                }
                if (this.addressUpdate == null || this.addressUpdate == '') {
                    this.$message.error("请输入详细地址");
                    return;
                }
                if (this.districtUpdate == null || this.districtUpdate == '') {
                    this.$message.error("请选择区域");
                }
                if (this.streetUpdate == null || this.streetUpdate == '') {
                    this.$message.error("请选择街道");
                    return;
                }
                if (this.notshowUpdate == null || this.notshowUpdate == '') {
                    this.$message.error("请选择是否展示");
                    return;
                }
                if (this.isReportUpdate == null || this.isReportUpdate == '') {
                    this.$message.error("请选择是否上报");
                    return;
                }
                if (this.areaTypeUpdate == null || this.areaTypeUpdate == '') {
                    this.$message.error("请选择房源");
                    return;
                }
                let data = {
                    id: this.updateId
                };
                data.hotelName = this.hotelNameUpdate;
                data.hotelOtherName = this.hotelOtherNameUpdate;
                data.hotelTypes = this.hotelTypeUpdateIdList;
                data.district = this.districtUpdate;
                data.street = this.streetUpdate;
                data.areaType = this.areaTypeUpdate;
                data.contractUser = this.contractUserUpdate;
                data.contractMobile = this.contractMobileUpdate;
                data.address = this.addressUpdate;
                data.remark = this.remarkUpdate;
                data.notshow = this.notshowUpdate,
                    data.isReport = this.isReportUpdate,
                    data.areaType = this.areaTypeUpdate,
                    this.$http.post('http://127.0.0.1:8888/hotel/edit', data, {emulateJSON: true}).then(function (res) {
                        if (res.body.status == 200) {
                            this.$message.success("修改成功")
                            this.dialogVisibleUpdate = false;
                            this.hotelInfoList();
                            this.clearUpdate();
                        } else {
                            this.$message.error(res.body.msg)
                        }
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
            //删除酒店
            handleDelete(id) {
                this.$http.get('http://127.0.0.1:8888/hotel/delete', {params: {id: id}}).then(function (res) {
                    if (res.status == 200) {
                        this.$message.success("删除成功")
                    } else {
                        this.$message.error("删除失败")
                    }
                    this.hotelInfoList(null, 1);
                })
            },
            //酒店类型选择(多选)
            hotelTypesChoice(hotelTypeAdd) {
                let str = '';
                this.hotelTypesIdList = '';
                if (this.hotelTypeAddList == null) {
                    this.hotelTypeAddList = [];
                }
                if (this.hotelTypeAddList.length > 0) {
                    if (this.hotelTypeAddList.includes(hotelTypeAdd.id.toString())) {
                        let index = this.hotelTypeAddList.indexOf(hotelTypeAdd.id.toString());
                        this.hotelTypeAddList.splice(index, 1)
                    } else {
                        this.hotelTypeAddList.push(hotelTypeAdd.id.toString());
                    }
                } else {
                    this.hotelTypeAddList.push(hotelTypeAdd.id.toString());
                }
                if (this.hotelTypeAddList.length > 0) {
                    let length = this.hotelTypeAddList.length;
                    for (let i = 0; i < length; i++) {
                        for (let j = 0; j < this.hotelTypesList.length; j++) {
                            if (this.hotelTypeAddList[i] == this.hotelTypesList[j].id) {
                                if (i == length - 1) {
                                    str = str + this.hotelTypesList[j].itemValue;
                                    this.hotelTypesIdList = this.hotelTypesIdList + this.hotelTypesList[j].id;
                                } else {
                                    str = str + this.hotelTypesList[j].itemValue + ",";
                                    this.hotelTypesIdList = this.hotelTypesIdList + this.hotelTypesList[j].id + ",";
                                }
                                break;
                            }
                        }
                    }
                }
                this.hotelTypeAdd = str;
            },
            //酒店类型选择(多选)
            updateHotelTypes(hotelTypeUpdate) {
                if (this.hotelTypesListUpate != null && this.hotelTypesListUpate.length > 0) {
                    if (this.hotelTypesListUpate.includes(hotelTypeUpdate.id.toString())) {
                        let index = this.hotelTypesListUpate.indexOf(hotelTypeUpdate.id.toString());
                        this.hotelTypesListUpate.splice(index, 1)
                    } else {
                        this.hotelTypesListUpate.push(hotelTypeUpdate.id.toString());
                    }
                } else {
                    this.hotelTypesListUpate = [];
                    this.hotelTypesListUpate.push(hotelTypeUpdate.id.toString())
                }
                let str = '';
                this.hotelTypeUpdateIdList = '';
                for (let i = 0; i < this.hotelTypesListUpate.length; i++) {
                    for (let j = 0; j < this.hotelTypesList.length; j++) {
                        if (this.hotelTypesListUpate[i] == this.hotelTypesList[j].id) {
                            if (i == this.hotelTypesListUpate.length - 1) {
                                str = str + this.hotelTypesList[j].itemValue;
                                this.hotelTypeUpdateIdList = this.hotelTypeUpdateIdList.toString() + this.hotelTypesList[j].id.toString();
                            } else {
                                str = str + this.hotelTypesList[j].itemValue + ',';
                                this.hotelTypeUpdateIdList = this.hotelTypeUpdateIdList.toString() + this.hotelTypesList[j].id.toString() + ',';
                            }
                            break;
                        }
                    }
                }
                this.hotelTypeUpdate = str;
            },
        },
        mounted() {
            this.getHotelTypesList();
            this.getDistrictList();
        },
        created() {
            this.hotelInfoList(this.pageSize, this.currentPage)
        },
    }
</script>

<style scoped>

</style>