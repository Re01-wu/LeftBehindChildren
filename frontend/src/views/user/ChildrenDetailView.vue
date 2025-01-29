<template>
  <div class="children-detail">
    <el-card>
      <template #header>
        <div class="card-header">
          <span>留守儿童信息详情</span>
          <el-button @click="goBack">返回</el-button>
        </div>
      </template>

      <el-descriptions 
        :column="1" 
        border
      >
        <el-descriptions-item label="姓名">
          {{ detail.name }}
        </el-descriptions-item>

        <el-descriptions-item label="年龄">
          {{ detail.age }}
        </el-descriptions-item>

        <el-descriptions-item label="性别">
          {{ detail.gender }}
        </el-descriptions-item>

        <el-descriptions-item label="学校">
          {{ detail.school }}
        </el-descriptions-item>

        <el-descriptions-item label="监护人">
          {{ detail.guardian }}
        </el-descriptions-item>

        <el-descriptions-item label="联系方式">
          {{ detail.contact }}
        </el-descriptions-item>

        <el-descriptions-item label="家庭情况">
          {{ detail.familyInfo }}
        </el-descriptions-item>

        <el-descriptions-item label="备注">
          {{ detail.remark }}
        </el-descriptions-item>
      </el-descriptions>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useRouter, useRoute } from 'vue-router'

const router = useRouter()
const route = useRoute()

interface ChildDetail {
  id: number
  name: string
  age: number
  gender: string
  school: string
  guardian: string
  contact: string
  familyInfo: string
  remark: string
}

const detail = ref<ChildDetail>({
  id: 0,
  name: '',
  age: 0,
  gender: '',
  school: '',
  guardian: '',
  contact: '',
  familyInfo: '',
  remark: ''
})

onMounted(() => {
  const id = Number(route.params.id)
  // TODO: 根据id获取数据
  detail.value = {
    id: id,
    name: '张三',
    age: 10,
    gender: '男',
    school: '希望小学',
    guardian: '李四',
    contact: '13800138000',
    familyInfo: '父母外出务工，由爷爷奶奶照顾',
    remark: '需要重点关注学习情况'
  }
})

const goBack = () => {
  router.go(-1)
}
</script>

<style scoped>
.children-detail {
  padding: 20px;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>