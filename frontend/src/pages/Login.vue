<template>
<div class="div-root">
    <div class="div-login-pane">
        <div class='div-login-title'>欢迎进入后台管理系统</div>
        <div>
            <el-input v-model="user.name" placeholder="请输入用户名"></el-input>
        </div>
        <div>
            <el-input v-model="user.password" type="password" placeholder="请输入用户密码"></el-input>
        </div>
        <div>
            <el-button type="primary" class="btn-login">登录</el-button>
        </div>
        <div>
            <a href="#/password" class="a-passwd">忘记密码</a>
        </div>
    </div>
</div>
</template>
<script>
export default {
    data () {
        return {
            user: {}
        }
    }
}
</script>
<style scoped>
.div-root {
    background: #f3f3f4;
    height: 100%;
    width: 100%;
}
.div-login-pane {
    position: relative;
    width: 300px;
    top: 35%;
    left: 50%;
    transform: translate(-50%, -50%);
}
.div-login-pane > div {
    margin: 20px 0;
}
.div-login-title {
    font-size: 16px;
    font-weight: bold;
}
.btn-login {
    width: 100%;
}
.a-passwd {
    text-decoration: none;
    cursor: pointer;
    font-size: 12px;
    color: #337ab7;
}
</style>


