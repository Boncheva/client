<template>
    <div>
        <span style="text-align: left">隔离酒店 | 预订系统     </span>
        <span style="text-align: right">{{this.$route.query.userName}}</span>
        <el-button href="#" @click="signOut"> 退出登录</el-button>
    </div>
</template>

<script>
    export default {
        name: "header",
        methods: {
            signOut() {
                this.$http.post('http://127.0.0.1:8888/admin/signOut').then(function (res) {
                    if (res.body.status == 200) {
                        localStorage.setItem('Authorization', null);
                        this.$router.push({path: 'login'});
                    }
                })
            }
        }
    }
</script>

<style>
    .el-header, .el-footer {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 200px;
    }

    .el-main {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        line-height: 160px;
    }

    body > .el-container {
        margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }
</style>