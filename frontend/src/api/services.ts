import api from './index'

// 儿童信息相关接口
export const childrenApi = {
  list: () => api.get('/children'),
  create: (data: any) => api.post('/children', data),
  update: (id: string, data: any) => api.put(`/children/${id}`, data),
  delete: (id: string) => api.delete(`/children/${id}`),
  getById: (id: string) => api.get(`/children/${id}`)
}

// 志愿者相关接口
export const volunteersApi = {
  list: () => api.get('/volunteers'),
  create: (data: any) => api.post('/volunteers', data),
  update: (id: string, data: any) => api.put(`/volunteers/${id}`, data),
  delete: (id: string) => api.delete(`/volunteers/${id}`),
  getById: (id: string) => api.get(`/volunteers/${id}`)
}

// 活动相关接口
export const activitiesApi = {
  list: () => api.get('/activities'),
  create: (data: any) => api.post('/activities', data),
  update: (id: string, data: any) => api.put(`/activities/${id}`, data),
  delete: (id: string) => api.delete(`/activities/${id}`),
  getById: (id: string) => api.get(`/activities/${id}`)
}

// 用户认证相关接口
export const authApi = {
  login: (data: { username: string; password: string }) => api.post('/auth/login', data),
  register: (data: any) => api.post('/auth/register', data),
  getCurrentUser: () => api.get('/auth/current-user'),
  logout: () => api.post('/auth/logout')
}