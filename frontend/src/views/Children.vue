<template>
  <div class="children-container">
    <div class="page-header">
      <h2>留守儿童信息管理</h2>
      <el-button type="primary" @click="dialogVisible = true">添加儿童信息</el-button>
    </div>

    <el-table :data="children" border style="width: 100%">
      <el-table-column prop="name" label="姓名" width="120" />
      <el-table-column prop="age" label="年龄" width="80" />
      <el-table-column prop="gender" label="性别" width="80" />
      <el-table-column prop="school" label="就读学校" />
      <el-table-column prop="guardian" label="监护人" width="120" />
      <el-table-column prop="contact" label="联系方式" width="150" />
      <el-table-column prop="address" label="居住地址" />
      <el-table-column label="操作" width="200">
        <template #default="{ row }">
          <el-button size="small" @click="handleEdit(row)">编辑</el-button>
          <el-button size="small" type="danger" @click="handleDelete(row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog v-model="dialogVisible" :title="formType === 'add' ? '添加儿童信息' : '编辑儿童信息'">
      <el-form :model="form" label-width="100px">
        <el-form-item label="姓名">
          <el-input v-model="form.name" />
        </el-form-item>
        <el-form-item label="年龄">
          <el-input-number v-model="form.age" :min="1" :max="18" />
        </el-form-item>
        <el-form-item label="性别">
          <el-select v-model="form.gender">
            <el-option label="男" value="男" />
            <el-option label="女" value="女" />
          </el-select>
        </el-form-item>
        <el-form-item label="就读学校">
          <el-input v-model="form.school" />
        </el-form-item>
        <el-form-item label="监护人">
          <el-input v-model="form.guardian" />
        </el-form-item>
        <el-form-item label="联系方式">
          <el-input v-model="form.contact" />
        </el-form-item>
        <el-form-item label="居住地址">
          <el-input v-model="form.address" type="textarea" />
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
import { childrenApi } from '../api/services'

interface ChildInfo {
  id?: number
  name: string
  age: number
  gender: string
  school: string
  guardian: string
  contact: string
  address: string
}

const children = ref<ChildInfo[]>([])
const dialogVisible = ref(false)
const formType = ref<'add' | 'edit'>('add')

const form = reactive<ChildInfo>({
  name: '',
  age: 7,
  gender: '男',
  school: '',
  guardian: '',
  contact: '',
  address: ''
})

const handleEdit = (row: ChildInfo) => {
  formType.value = 'edit'
  Object.assign(form, row)
  dialogVisible.value = true
}

const loadChildren = async () => {
  try {
    children.value = await childrenApi.list()
  } catch (error) {
    ElMessage.error('获取儿童信息失败')
  }
}

const handleDelete = async (row: ChildInfo) => {
  try {
    await childrenApi.delete(row.id!.toString())
    ElMessage.success('删除成功')
    loadChildren()
  } catch (error) {
    ElMessage.error('删除失败')
  }
}

const handleSubmit = async () => {
  try {
    if (formType.value === 'add') {
      await childrenApi.create(form)
      ElMessage.success('添加成功')
    } else {
      await childrenApi.update(form.id!.toString(), form)
      ElMessage.success('更新成功')
    }
    dialogVisible.value = false
    loadChildren()
  } catch (error) {
    ElMessage.error(formType.value === 'add' ? '添加失败' : '更新失败')
  }
}

// 组件挂载时加载数据
loadChildren()
</script>

<style scoped>
.children-container {
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