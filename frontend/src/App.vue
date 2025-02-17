<template>
  <el-container class="app-container">
    <el-header>
      <el-menu mode="horizontal" :router="true">
        <el-menu-item index="/">首页</el-menu-item>
        <el-menu-item index="/children">留守儿童信息</el-menu-item>
        <el-menu-item index="/volunteers">志愿者管理</el-menu-item>
        <el-menu-item index="/activities">活动管理</el-menu-item>
      </el-menu>
    </el-header>
    <el-main>
      <router-view></router-view>
    </el-main>
    <el-footer>
      © 2023 留守儿童关爱系统
    </el-footer>
  </el-container>
</template>

<script setup lang="ts">
import { ElContainer, ElHeader, ElMain, ElFooter, ElMenu, ElMenuItem } from 'element-plus'
</script>

<style>
.app-container {
  min-height: 100vh;
}

.el-header {
  padding: 0;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.el-footer {
  text-align: center;
  color: #666;
  padding: 20px;
}
</style>