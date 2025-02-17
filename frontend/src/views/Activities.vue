<template>
  <div class="activities-container">
    <div class="page-header">
      <h2>活动管理</h2>
      <el-button type="primary" @click="dialogVisible = true">创建活动</el-button>
    </div>

    <el-table :data="activities" border style="width: 100%">
      <el-table-column prop="title" label="活动名称" width="200" />
      <el-table-column prop="date" label="活动日期" width="120" />
      <el-table-column prop="location" label="活动地点" width="150" />
      <el-table-column prop="organizer" label="组织者" width="120" />
      <el-table-column prop="status" label="状态" width="100">
        <template #default="{ row }">
          <el-tag :type="row.status === '进行中' ? 'success' : row.status === '已结束' ? 'info' : 'warning'">
            {{ row.status }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="description" label="活动描述" />
      <el-table-column label="操作" width="200">
        <template #default="{ row }">
          <el-button size="small" @click="handleEdit(row)">编辑</el-button>
          <el-button size="small" type="danger" @click="handleDelete(row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog v-model="dialogVisible" :title="formType === 'add' ? '创建活动' : '编辑活动'">
      <el-form :model="form" label-width="100px">
        <el-form-item label="活动名称">
          <el-input v-model="form.title" />
        </el-form-item>
        <el-form-item label="活动日期">
          <el-date-picker v-model="form.date" type="date" placeholder="选择日期" />
        </el-form-item>
        <el-form-item label="活动地点">
          <el-input v-model="form.location" />
        </el-form-item>
        <el-form-item label="组织者">
          <el-input v-model="form.organizer" />
        </el-form-item>
        <el-form-item label="状态">
          <el-select v-model="form.status">
            <el-option label="未开始" value="未开始" />
            <el-option label="进行中" value="进行中" />
            <el-option label="已结束" value="已结束" />
          </el-select>
        </el-form-item>
        <el-form-item label="活动描述">
          <el-input v-model="form.description" type="textarea" rows="4" />
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="handleSubmit">确定</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive } from 'vue'
import { ElMessage } from 'element-plus'
import { activitiesApi } from '../api/services'

interface ActivityInfo {
  id?: number
  title: string
  date: string
  location: string
  organizer: string
  status: string
  description: string
}

const activities = ref<ActivityInfo[]>([])
const dialogVisible = ref(false)
const formType = ref<'add' | 'edit'>('add')

const form = reactive<ActivityInfo>({
  title: '',
  date: '',
  location: '',
  organizer: '',
  status: '未开始',
  description: ''
})

const handleEdit = (row: ActivityInfo) => {
  formType.value = 'edit'
  Object.assign(form, row)
  dialogVisible.value = true
}

const loadActivities = async () => {
  try {
    activities.value = await activitiesApi.list()
  } catch (error) {
    ElMessage.error('获取活动信息失败')
  }
}

const handleDelete = async (row: ActivityInfo) => {
  try {
    await activitiesApi.delete(row.id!.toString())
    ElMessage.success('删除成功')
    loadActivities()
  } catch (error) {
    ElMessage.error('删除失败')
  }
}

const handleSubmit = async () => {
  try {
    if (formType.value === 'add') {
      await activitiesApi.create(form)
      ElMessage.success('创建成功')
    } else {
      await activitiesApi.update(form.id!.toString(), form)
      ElMessage.success('更新成功')
    }
    dialogVisible.value = false
    loadActivities()
  } catch (error) {
    ElMessage.error(formType.value === 'add' ? '创建失败' : '更新失败')
  }
}

// 组件挂载时加载数据
loadActivities()
</script>

<style scoped>
.activities-container {
  padding: 20px;
}

.page-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}

.page-header h2 {
  margin: 0;
  color: #303133;
}
</style>