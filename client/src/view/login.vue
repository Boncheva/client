<template>
    <!--手机登录结束-->
    <div class="loginWrap" id="app">
        <p class="gl-logo">
            <img src="../assets/images/loging-logo.png">
        </p>
        <div class="loginForme">

            <!--手机密码登录-->
            <div action="" class="cont" id="psw-login-form">
                <p class="f16 mb25">
                    <strong></strong>
                </p>
                <div class="lable">
                    <input type="text" maxlength="11" placeholder="请输入用户名（手机号）" id="input_userPhone" autocomplete="off"
                           v-model="mobile">
                </div>
                <div class="lable">
                    <input type="password" placeholder="请输入密码" id="input_password" autocomplete="off" v-model="passwd">
                </div>
                <!--            <p class="ta-r mb20"><a href="javascript:" id="btn-psw-forget"><span class="c-434">忘记密码</span></a></p>-->
                <input @click="login()" id="input_btn_login_password" readonly style="cursor: pointer;"
                       class="btnBase bg-006"
                       value="登录">
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        name: "login",
        data() {
            return {
                mobile: null,
                passwd: null
            }
        },
        methods: {
            login() {
                if (this.mobile == null || this.mobile == '') {
                    this.$message.error("请填写手机号")
                    return;
                }
                if (this.passwd == null || this.passwd == '') {
                    this.$message.error("请填写用户密码")
                    return;
                }
                this.$http.post('http://127.0.0.1:8888/admin/login', {
                    mobile: this.mobile,
                    passwd: this.passwd
                }, {emulateJSON: true}).then(function (res) {
                    if (res.body.status == 200) {
                        let userToken = res.body.data.userToken;
                        //登陆成功，存储token
                        this.$store.commit('changeLogin', {Authorization: userToken});
                        // 跳转到主页
                        this.$router.push({path: 'index', query: {userName: res.body.data.userInfo.userName}});
                    } else {
                        this.$message.error(res.body.msg)
                    }
                })
            },
        },
        watch: {
            inputData() {
                console.log(this.mobile);
            }
        }
    }
</script>

<style scoped>
    @import "../assets/css/global.css";
    @import "../assets/css/login.css";
</style>