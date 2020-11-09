<template>
    <!--手机登录结束-->
    <div class="loginWrap" id="app">
        <p class="gl-logo">
            <img src="../assets/images/loging-logo.png">
        </p>
        <div class="loginForme">
            <!--手机验证码登录-->
            <!--        <a href="#" class="log-01" id="weixin_login"></a>-->
            <div action="" class="cont" id="code-login-form" style="display: none;">
                <p class="f16 mb25">
                    <strong></strong>
                </p>
                <div class="lable">
                    <i class="log-06"></i><input type="text" maxlength="11" placeholder="请输入用户名（手机号）"
                                                 id="input_userPhoneCode" autocomplete="off">
                </div>
                <div class="lable" style="width: 155px">
                    <i class="log-07"></i> <input type="text" placeholder="输入验证码" id="input_code" autocomplete="off">
                    <button class="btn-verification" id="btn_verification" style="padding: 0;">获取验证码</button>
                    <div class="loginerror-tips" id="code-login-error">
                        <span class="sanjiao-img"></span>
                        验证码错误
                    </div>
                </div>
                <p class="ta-r mb20"><a href="javascript:" id="btn-code-forget"><span class="c-434">忘记密码</span></a></p>
                <input id="input_btn_login_code" readonly style="cursor: pointer" class="btnBase bg-006"
                       @click="login()" value="登录">
            </div>

            <!--手机密码登录-->
            <div action="" class="cont" id="psw-login-form">
                <p class="f16 mb25">
                    <strong></strong>
                </p>
                <div class="lable">
                    <input type="text" maxlength="11" placeholder="请输入用户名（手机号）" id="input_userPhone" autocomplete="off">
                </div>
                <div class="lable">
                    <input type="password" placeholder="请输入密码" id="input_password" autocomplete="off">
                </div>
                <!--            <p class="ta-r mb20"><a href="javascript:" id="btn-psw-forget"><span class="c-434">忘记密码</span></a></p>-->
                <input @click="login('123')" id="input_btn_login_password" readonly style="cursor: pointer;" class="btnBase bg-006"
                       value="登录">
            </div>
            <div class="login-pop-ups" style="display: none">
                <div class="cont">
                    <p class="f16 mb25"><strong>首次扫描登录，需要验证您的手机号码</strong></p>
                    <div class="lable">
                        <i class="log-06"></i><input type="text" maxlength="11" placeholder="请输入手机号">
                    </div>
                    <div class="lable" style="width: 155px">
                        <i class="log-07"></i> <input type="text" placeholder="输入验证码">
                        <button class="btn-verification">获取验证码</button>
                    </div>
                    <button type="button" class="btnBase bg-006">验证</button>
                </div>
            </div>
            <!--登录验证成功弹窗-->
            <div class="login-pop-ups" style="display: none;">
                <div class="verification-success">
                    <i></i>
                    <p><strong>验证成功</strong></p>
                </div>
            </div>
            <!--登录验证警告弹窗-->
            <div class="login-pop-ups" style="display: none;">
                <a href="" class="close"><i></i></a>
                <div class="phone-login-tips">
                    <i></i>
                    <p><strong>该手机已绑定别的企业微信账号</strong></p>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        methods: {
            login () {
                this.$router.push({path:'/index'})
            }
        },
    }
</script>

<style scoped>
    @import "../assets/css/global.css";
    @import "../assets/css/login.css";
</style>