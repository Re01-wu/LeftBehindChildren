<template>
  <div class="children-edit">
    <el-card>
      <template #header>
        <div class="card-header">
          <span>编辑留守儿童信息</span>
        </div>
      </template>

      <el-form
        :model="form"
        :rules="rules"
        ref="formRef"
        label-width="100px"
      >
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" />
        </el-form-item>

        <el-form-item label="年龄" prop="age">
          <el-input-number 
            v-model="form.age"
            :min="0"
            :max="18"
          />
        </el-form-item>

        <el-form-item label="性别" prop="gender">
          <el-radio-group v-model="form.gender">
            <el-radio label="男" />
            <el-radio label="女" />
          </el-radio-group>
        </el-form-item>

        <el-form-item label="学校" prop="school">
          <el-input v-model="form.school" />
        </el-form-item>

        <el-form-item label="监护人" prop="guardian">
          <el-input v-model="form.guardian" />
        </el-form-item>

        <el-form-item label="联系方式" prop="contact">
          <el-input v-model="form.contact" />
        </el-form-item>

        <el-form-item>
          <el-button 
            type="primary" 
            @click="submitForm"
            :loading="loading"
          >
            保存
          </el-button>
          <el-button @click="goBack">返回</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { ElMessage } from 'element-plus'
import type { FormInstance, FormRules } from 'element-plus'

interface ChildForm {
  id: number
  name: string
  age: number
  gender: string
  school: string
  guardian: string
  contact: string
}

const formRef = ref<FormInstance>()
const loading = ref(false)
const router = useRouter()
const route = useRoute()

const form = ref<ChildForm>({
  id: 0,
  name: '',
  age: 0,
  gender: '男',
  school: '',
  guardian: '',
  contact: ''
})

const rules = ref<FormRules<ChildForm>>({
  name: [
    { required: true, message: '请输入姓名', trigger: 'blur' }
  ],
  age: [
    { required: true, message: '请输入年龄', trigger: 'blur' }
  ],
  gender: [
    { required: true, message: '请选择性别', trigger: 'change' }
  ],
  school: [
    { required: true, message: '请输入学校', trigger: 'blur' }
  ],
  guardian: [
    { required: true, message: '请输入监护人', trigger: 'blur' }
  ],
  contact: [
    { required: true, message: '请输入联系方式', trigger: 'blur' }
  ]
})

onMounted(() => {
  const id = Number(route.params.id)
  // TODO: 根据id获取数据
  form.value = {
    id: id,
    name: '张三',
    age: 10,
    gender: '男',
    school: '希望小学',
    guardian: '李四',
    contact: '13800138000'
  }
})

const submitForm = async () => {
  formRef.value?.validate(async (valid) => {
    if (valid) {
      loading.value = true;
      try {
        // 假设有一个 API 来更新儿童信息
        await axios.put(`/api/children/${form.value.id}`, form.value);
        ElMessage.success('更新成功');
        router.push({ name: 'admin.children.list' });
      } catch (error) {
        ElMessage.error('更新失败');
      } finally {
        loading.value = false;
      }
    }
  });
};

const goBack = () => {
  router.push({ name: 'admin.children.list' });
};
</script>

<style scoped>
.children-edit {
  padding: 20px;
}

.card-header {
  font-size: 18px;
  font-weight: bold;
}
</style>