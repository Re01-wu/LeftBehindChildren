<template>
  <div class="children-list">
    <el-card>
      <template #header>
        <div class="card-header">
          <span>留守儿童信息列表</span>
          <el-button 
            type="primary" 
            @click="goToAdd"
          >
            添加信息
          </el-button>
        </div>
      </template>

      <el-table
        :data="tableData"
        stripe
        style="width: 100%"
      >
        <el-table-column
          prop="name"
          label="姓名"
          width="120"
        />
        <el-table-column
          prop="age"
          label="年龄"
          width="80"
        />
        <el-table-column
          prop="gender"
          label="性别"
          width="80"
        />
        <el-table-column
          prop="school"
          label="学校"
        />
        <el-table-column
          prop="guardian"
          label="监护人"
        />
        <el-table-column
          prop="contact"
          label="联系方式"
        />
        <el-table-column
          label="操作"
          width="150"
        >
          <template #default="scope">
            <el-button 
              type="primary" 
              size="small"
              @click="handleEdit(scope.row)"
            >
              编辑
            </el-button>
            <el-button 
              type="danger" 
              size="small"
              @click="handleDelete(scope.row)"
            >
              删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-pagination
        class="pagination"
        background
        layout="prev, pager, next"
        :total="100"
        :page-size="10"
      />
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { ElMessageBox } from 'element-plus'

const router = useRouter()

interface ChildInfo {
  id: number
  name: string
  age: number
  gender: string
  school: string
  guardian: string
  contact: string
}

const tableData = ref<ChildInfo[]>([
  {
    id: 1,
    name: '张三',
    age: 10,
    gender: '男',
    school: '希望小学',
    guardian: '李四',
    contact: '13800138000'
  },
  {
    id: 2,
    name: '李四',
    age: 12,
    gender: '女',
    school: '阳光小学',
    guardian: '王五',
    contact: '13800138001'
  }
])

const goToAdd = () => {
  router.push({ name: 'admin.children.add' })
}

const handleEdit = (row: ChildInfo) => {
  router.push({
    name: 'admin.children.edit',
    params: { id: row.id }
  })
}

const handleDelete = (row: ChildInfo) => {
  ElMessageBox.confirm('确定要删除该信息吗？', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(() => {
    // TODO: 调用删除接口
    tableData.value = tableData.value.filter(item => item.id !== row.id)
  })
}
</script>

<style scoped>
.children-list {
  padding: 20px;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.pagination {
  margin-top: 20px;
  justify-content: flex-end;
}
</style>