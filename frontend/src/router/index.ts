import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/LoginView.vue')
    },
    {
      path: '/admin',
      name: 'admin',
      component: () => import('../views/admin/AdminView.vue'),
      meta: { requiresAuth: true, role: 'admin' },
      children: [
        {
          path: 'dashboard',
          name: 'admin.dashboard',
          component: () => import('../views/admin/DashboardView.vue')
        },
        {
          path: 'children/list',
          name: 'admin.children.list',
          component: () => import('../views/admin/children/ChildrenListView.vue')
        },
        {
          path: 'children/add',
          name: 'admin.children.add',
          component: () => import('../views/admin/children/ChildrenAddView.vue')
        },
        {
          path: 'children/edit/:id',
          name: 'admin.children.edit',
          component: () => import('../views/admin/children/ChildrenEditView.vue')
        }
      ]
    },
    {
      path: '/user',
      name: 'user',
      component: () => import('../views/user/UserView.vue'),
      meta: { requiresAuth: true, role: 'user' },
      children: [
        {
          path: 'dashboard',
          name: 'user.dashboard',
          component: () => import('../views/user/DashboardView.vue')
        },
        {
          path: 'profile',
          name: 'user.profile',
          component: () => import('../views/user/ProfileView.vue')
        },
        {
          path: 'children',
          name: 'user.children',
          component: () => import('../views/user/ChildrenView.vue')
        },
        {
          path: 'children/detail/:id',
          name: 'user.children.detail',
          component: () => import('../views/user/ChildrenDetailView.vue')
        }
      ]
    }
  ]
})

export default router