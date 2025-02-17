<template>
  <div class="home-container">
    <el-row :gutter="20" class="welcome-section">
      <el-col :span="24">
        <h1>欢迎来到留守儿童关爱系统</h1>
        <p>我们致力于为留守儿童提供关爱和支持</p>
      </el-col>
    </el-row>

    <el-row :gutter="20" class="feature-cards">
      <el-col :span="8">
        <el-card>
          <template #header>
            <div class="card-header">
              <h3>留守儿童信息</h3>
            </div>
          </template>
          <div class="card-content">
            <p>管理和查看留守儿童的基本信息、生活状况和教育需求</p>
            <el-button type="primary" @click="$router.push('/children')">查看详情</el-button>
          </div>
        </el-card>
      </el-col>

      <el-col :span="8">
        <el-card>
          <template #header>
            <div class="card-header">
              <h3>志愿者管理</h3>
            </div>
          </template>
          <div class="card-content">
            <p>招募和管理志愿者，组织志愿服务活动</p>
            <el-button type="primary" @click="$router.push('/volunteers')">查看详情</el-button>
          </div>
        </el-card>
      </el-col>

      <el-col :span="8">
        <el-card>
          <template #header>
            <div class="card-header">
              <h3>活动管理</h3>
            </div>
          </template>
          <div class="card-content">
            <p>策划和组织各类关爱活动，促进儿童健康成长</p>
            <el-button type="primary" @click="$router.push('/activities')">查看详情</el-button>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import { ElRow, ElCol, ElCard, ElButton } from 'element-plus'
</script>

<style scoped>
.home-container {
  padding: 20px;
}

.welcome-section {
  text-align: center;
  margin-bottom: 40px;
}

.welcome-section h1 {
  font-size: 2.5em;
  color: #409EFF;
  margin-bottom: 10px;
}

.welcome-section p {
  font-size: 1.2em;
  color: #666;
}

.feature-cards {
  margin-top: 20px;
}

.card-header h3 {
  margin: 0;
  color: #303133;
}

.card-content {
  text-align: center;
}

.card-content p {
  margin: 15px 0;
  min-height: 44px;
}

.el-card {
  margin-bottom: 20px;
  transition: all 0.3s;
}

.el-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}
</style>