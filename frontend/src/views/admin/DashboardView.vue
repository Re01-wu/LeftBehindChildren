<template>
  <div class="dashboard">
    <el-card>
      <template #header>
        <div class="card-header">
          <span>系统仪表盘</span>
        </div>
      </template>

      <el-row :gutter="20">
        <el-col :span="6">
          <el-card shadow="hover">
            <div class="stat-item">
              <div class="stat-title">留守儿童总数</div>
              <div class="stat-value">120</div>
            </div>
          </el-card>
        </el-col>

        <el-col :span="6">
          <el-card shadow="hover">
            <div class="stat-item">
              <div class="stat-title">新增人数</div>
              <div class="stat-value">5</div>
            </div>
          </el-card>
        </el-col>

        <el-col :span="6">
          <el-card shadow="hover">
            <div class="stat-item">
              <div class="stat-title">学校数量</div>
              <div class="stat-value">8</div>
            </div>
          </el-card>
        </el-col>

        <el-col :span="6">
          <el-card shadow="hover">
            <div class="stat-item">
              <div class="stat-title">监护人数量</div>
              <div class="stat-value">120</div>
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