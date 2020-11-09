<template>
    <body>

    <div class="wrap contents-body">
        <div class="item-title_box">
            <div class="item-title supervision-list-line"> <span>酒店信息管理</span><span class="item-title-tips">政府管控时间段：21点到22点    最新同步时间：2020-08-08 21:30</span> </div>
            <form action="" class="layui-form supervision-list">
                <div class="topctrl select-s fix">

                    <div class="layui-inline">
                        <select>
                            <option value="1">请选择省份</option>
                        </select>
                    </div>
                    <div class="layui-inline">
                        <select>
                            <option value="1">请选择城市</option>
                        </select>
                    </div>
                    <div class="layui-inline" >
                        <select>
                            <option value="1">请选择区域</option>
                        </select>
                    </div>
                    <div class="layui-inline">
                        <select >
                            <option value="1">请选择核酸报告状态</option>
                        </select>
                    </div>
                    <div class="layui-inline">
                        <select >
                            <option value="1">请选择账号状态</option>
                        </select>
                    </div>
                    <div class="layui-inline">
                        <input type="text" name="title" autocomplete="off" placeholder="请输入证件号码、姓名" class="layui-input">
                    </div>

                    <button class="layui-btn layui-btn-normal layui-btn-sm">搜索</button>
                    <button class="layui-btn layui-btn-normal layui-btn-sm">重置</button>
                </div>

                <div class="supervision-list-table">
                    <table class="layui-table"  lay-even="" lay-skin="row">
                        <tr>
                            <th>证件类型</th>
                            <th>证件号码</th>
                            <th>姓名</th>
                            <th>申报信息状态</th>
                            <th>核酸报告状态</th>
                            <th>同住人员</th>
                            <th>操作</th>
                        </tr>
                        <tr>
                            <td>身份证</td>
                            <td>441421199010299898</td>
                            <td>张三</td>
                            <td>未填报</td>
                            <td>未提交</td>
                            <td>张三、李四</td>
                            <td><a href="">详情</a><a href="">详情</a><a href="">详情</a></td>
                        </tr>
                        <tr>
                            <td>身份证</td>
                            <td>441421199010299898</td>
                            <td>张三</td>
                            <td>未填报</td>
                            <td>未提交</td>
                            <td>张三、李四</td>
                            <td><a href="">详情</a><a href="">详情</a><a href="">详情</a></td>
                        </tr>
                        <tr>
                            <td>身份证</td>
                            <td>441421199010299898</td>
                            <td>张三</td>
                            <td>未填报</td>
                            <td>未提交</td>
                            <td>张三、李四</td>
                            <td><a href="">详情</a><a href="">详情</a><a href="">详情</a></td>
                        </tr>
                        <tr>
                            <td>身份证</td>
                            <td>441421199010299898</td>
                            <td>张三</td>
                            <td>未填报</td>
                            <td>未提交</td>
                            <td>张三、李四</td>
                            <td><a href="">详情</a><a href="">详情</a><a href="">详情</a></td>
                        </tr>
                    </table>
                </div>
                <div id="pages"></div>
            </form>
        </div>
    </div>
    </body>
</template>

<script>
    import '../../../static/layui/css/layui.css'
    import '../../assets/css/global.css'
    import '../../assets/css/master.css'
    export default {
        name: "hotelHosingSubV"
    }
</script>

<style scoped>

</style>