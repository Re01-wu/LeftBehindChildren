<template>
  <div class="login-container">
    <el-card class="login-card">
      <h2>用户登录</h2>
      <el-form 
        :model="loginForm" 
        :rules="rules" 
        ref="loginFormRef"
        label-width="80px"
      >
        <el-form-item label="用户名" prop="username">
          <el-input v-model="loginForm.username" />
        </el-form-item>

        <el-form-item label="密码" prop="password">
          <el-input 
            v-model="loginForm.password" 
            type="password"
            show-password
          />
        </el-form-item>

        <el-form-item>
          <el-button 
            type="primary" 
            @click="submitForm"
            :loading="loading"
          >
            登录
          </el-button>
          <el-button @click="resetForm">重置</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'
import type { FormInstance, FormRules } from 'element-plus'
import { authApi } from '../api/services'

interface LoginForm {
  username: string
  password: string
}

const loginFormRef = ref<FormInstance>()
const loading = ref(false)
const router = useRouter()

const loginForm = ref<LoginForm>({
  username: '',
  password: ''
})

const rules = ref<FormRules<LoginForm>>({
  username: [
    { required: true, message: '请输入用户名', trigger: 'blur' }
  ],
  password: [
    { required: true, message: '请输入密码', trigger: 'blur' }
  ]
})

const submitForm = () => {
  loginFormRef.value?.validate(async (valid) => {
    if (valid) {
      loading.value = true;
      try {
        await authApi.login(loginForm.value);
        ElMessage.success('登录成功');
        router.push({ name: 'home' });
      } catch (error) {
        ElMessage.error('登录失败，请检查用户名和密码');
      } finally {
        loading.value = false;
      }
    }
  });
}

const resetForm = () => {
  loginFormRef.value?.resetFields()
}
</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f5f7fa;
}

.login-card {
  width: 400px;
  padding: 20px;
}

h2 {
  text-align: center;
  margin-bottom: 20px;
}
</style>