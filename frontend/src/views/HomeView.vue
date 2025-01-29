<template>
  <div class="home">
    <h1>留守儿童信息管理系统</h1>
    <p>欢迎使用本系统</p>
    <div class="actions">
      <el-button type="primary" @click="goToLogin">登录</el-button>
      <el-button type="success" @click="goToRegister">注册</el-button>
    </div>
  </div>
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router'

const router = useRouter()

const goToLogin = () => {
  router.push({ name: 'login' })
}

const goToRegister = () => {
  router.push({ name: 'register' })
}
</script>

<style scoped>
.home {
  text-align: center;
  margin-top: 100px;
}

.actions {
  margin-top: 20px;
}

.actions button {
  margin: 0 10px;
}
</style>