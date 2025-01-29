<template>
  <div class="dashboard">
    <el-card>
      <template #header>
        <div class="card-header">
          <span>用户首页</span>
        </div>
      </template>

      <el-row :gutter="20">
        <el-col :span="8">
          <el-card shadow="hover">
            <div class="stat-item">
              <div class="stat-title">可查看的留守儿童</div>
              <div class="stat-value">50</div>
            </div>
          </el-card>
        </el-col>

        <el-col :span="8">
          <el-card shadow="hover">
            <div class="stat-item">
              <div class="stat-title">最近更新</div>
              <div class="stat-value">3天前</div>
            </div>
          </el-card>
        </el-col>

        <el-col :span="8">
          <el-card shadow="hover">
            <div class="stat-item">
              <div class="stat-title">我的收藏</div>
              <div class="stat-value">12</div>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script setup lang="ts">
</script>

<style scoped>
.dashboard {
  padding: 20px;
}

.card-header {
  font-size: 18px;
  font-weight: bold;
}

.stat-item {
  text-align: center;
}

.stat-title {
  font-size: 14px;
  color: #909399;
}

.stat-value {
  font-size: 24px;
  font-weight: bold;
  margin-top: 10px;
}
</style>