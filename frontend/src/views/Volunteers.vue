<template>
  <div class="volunteers-container">
    <div class="page-header">
      <h2>志愿者管理</h2>
      <el-button type="primary" @click="dialogVisible = true">添加志愿者</el-button>
    </div>

    <el-table :data="volunteers" border style="width: 100%">
      <el-table-column prop="name" label="姓名" width="120" />
      <el-table-column prop="age" label="年龄" width="80" />
      <el-table-column prop="gender" label="性别" width="80" />
      <el-table-column prop="occupation" label="职业" width="120" />
      <el-table-column prop="contact" label="联系方式" width="150" />
      <el-table-column prop="availability" label="服务时间" />
      <el-table-column prop="skills" label="特长" />
      <el-table-column label="操作" width="200">
        <template #default="{ row }">
          <el-button size="small" @click="handleEdit(row)">编辑</el-button>
          <el-button size="small" type="danger" @click="handleDelete(row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog v-model="dialogVisible" :title="formType === 'add' ? '添加志愿者' : '编辑志愿者信息'">
      <el-form :model="form" label-width="100px">
        <el-form-item label="姓名">
          <el-input v-model="form.name" />
        </el-form-item>
        <el-form-item label="年龄">
          <el-input-number v-model="form.age" :min="18" :max="70" />
        </el-form-item>
        <el-form-item label="性别">
          <el-select v-model="form.gender">
            <el-option label="男" value="男" />
            <el-option label="女" value="女" />
          </el-select>
        </el-form-item>
        <el-form-item label="职业">
          <el-input v-model="form.occupation" />
        </el-form-item>
        <el-form-item label="联系方式">
          <el-input v-model="form.contact" />
        </el-form-item>
        <el-form-item label="服务时间">
          <el-input v-model="form.availability" placeholder="例如：周末、节假日" />
        </el-form-item>
        <el-form-item label="特长">
          <el-input v-model="form.skills" type="textarea" placeholder="例如：教育辅导、心理咨询、艺术特长等" />
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
import { volunteersApi } from '../api/services'

interface VolunteerInfo {
  id?: number
  name: string
  age: number
  gender: string
  occupation: string
  contact: string
  availability: string
  skills: string
}

const volunteers = ref<VolunteerInfo[]>([])
const dialogVisible = ref(false)
const formType = ref<'add' | 'edit'>('add')

const form = reactive<VolunteerInfo>({
  name: '',
  age: 25,
  gender: '男',
  occupation: '',
  contact: '',
  availability: '',
  skills: ''
})

const handleEdit = (row: VolunteerInfo) => {
  formType.value = 'edit'
  Object.assign(form, row)
  dialogVisible.value = true
}

const loadVolunteers = async () => {
  try {
    volunteers.value = await volunteersApi.list()
  } catch (error) {
    ElMessage.error('获取志愿者信息失败')
  }
}

const handleDelete = async (row: VolunteerInfo) => {
  try {
    await volunteersApi.delete(row.id!.toString())
    ElMessage.success('删除成功')
    loadVolunteers()
  } catch (error) {
    ElMessage.error('删除失败')
  }
}

const handleSubmit = async () => {
  try {
    if (formType.value === 'add') {
      await volunteersApi.create(form)
      ElMessage.success('添加成功')
    } else {
      await volunteersApi.update(form.id!.toString(), form)
      ElMessage.success('更新成功')
    }
    dialogVisible.value = false
    loadVolunteers()
  } catch (error) {
    ElMessage.error(formType.value === 'add' ? '添加失败' : '更新失败')
  }
}

// 组件挂载时加载数据
loadVolunteers()
</script>

<style scoped>
.volunteers-container {
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