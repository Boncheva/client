<template>
    <!-- 侧边菜单 -->
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu :default-active="this.$route.path" :router = "true" mode="horizontal">
            <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
                {{ item.navItem }}
            </el-menu-item>
        </el-menu>

    </el-aside>
</template>

<script>
    export default {
        name: "aside",
        data() {
            return {
                navList: [
                    {name: '/index/appUserMan', navItem: '申报用户管理'},
                    {name: '/index/orderBooking', navItem: '预定订单管理'},
                    {name: '/index/hotelInfoMan', navItem: '酒店信息管理'}
                ]
            }
        }
    }
</script>

<style lang="scss">
    .aside-wrap {
        min-height: 100vh;
        background: #b02128;
    }
</style>