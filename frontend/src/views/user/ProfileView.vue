<template>
  <div class="profile">
    <el-card>
      <template #header>
        <div class="card-header">
          <span>个人信息</span>
        </div>
      </template>

      <el-form
        :model="form"
        :rules="rules"
        ref="formRef"
        label-width="100px"
      >
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" disabled />
        </el-form-item>

        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" />
        </el-form-item>

        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email" />
        </el-form-item>

        <el-form-item label="手机号" prop="phone">
          <el-input v-model="form.phone" />
        </el-form-item>

        <el-form-item>
          <el-button 
            type="primary" 
            @click="submitForm"
            :loading="loading"
          >
            保存
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { ElMessage } from 'element-plus'
import type { FormInstance, FormRules } from 'element-plus'

interface ProfileForm {
  username: string
  name: string
  email: string
  phone: string
}

const formRef = ref<FormInstance>()
const loading = ref(false)

const form = ref<ProfileForm>({
  username: 'user123',
  name: '张三',
  email: 'user@example.com',
  phone: '13800138000'
})

const rules = ref<FormRules<ProfileForm>>({
  name: [
    { required: true, message: '请输入姓名', trigger: 'blur' }
  ],
  email: [
    { required: true, message: '请输入邮箱', trigger: 'blur' },
    { type: 'email', message: '请输入正确的邮箱格式', trigger: 'blur' }
  ],
  phone: [
    { required: true, message: '请输入手机号', trigger: 'blur' },
    { pattern: /^1[3-9]\d{9}$/, message: '请输入正确的手机号格式', trigger: 'blur' }
  ]
})

const submitForm = () => {
  formRef.value?.validate((valid) => {
    if (valid) {
      loading.value = true
      // TODO: 调用更新接口
      setTimeout(() => {
        loading.value = false
        ElMessage.success('保存成功')
      }, 1000)
    }
  })
}
</script>

<style scoped>
.profile {
  padding: 20px;
}

.card-header {
  font-size: 18px;
  font-weight: bold;
}
</style>