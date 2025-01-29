<template>
  <el-container>
    <el-aside width="200px">
      <el-menu
        :default-active="activeMenu"
        router
      >
        <el-menu-item index="/user/dashboard">
          <el-icon><HomeFilled /></el-icon>
          <span>首页</span>
        </el-menu-item>

        <el-menu-item index="/user/profile">
          <el-icon><User /></el-icon>
          <span>个人信息</span>
        </el-menu-item>

        <el-menu-item index="/user/children">
          <el-icon><Notebook /></el-icon>
          <span>留守儿童信息</span>
        </el-menu-item>
      </el-menu>
    </el-aside>

    <el-container>
      <el-header>
        <div class="header-content">
          <span>留守儿童信息管理系统</span>
          <el-button type="danger" @click="logout">退出登录</el-button>
        </div>
      </el-header>

      <el-main>
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import {
  HomeFilled,
  User,
  Notebook
} from '@element-plus/icons-vue'

const router = useRouter()
const activeMenu = ref('/user/dashboard')

const logout = () => {
  // TODO: 实现退出登录逻辑
  router.push({ name: 'login' })
}
</script>

<style scoped>
.el-container {
  height: 100vh;
}

.el-header {
  background-color: #fff;
  border-bottom: 1px solid #e4e7ed;
  display: flex;
  align-items: center;
}

.header-content {
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.el-aside {
  background-color: #fff;
  border-right: 1px solid #e4e7ed;
}

.el-main {
  padding: 20px;
}
</style>