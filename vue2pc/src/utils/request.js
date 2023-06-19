import axios from 'axios'

// 使用create方法创建axios实例
export const Service = axios.create({
  timeout: 10000, // 请求超时时间
  baseURL: 'http://localhost:8080/api'
})

// 添加请求截拦器
Service.interceptors.request.use(config => {
  return config
}, error => {
  this.$message.error('请求超时')
  return Promise.reject(error)
})

// 添加一个响应截拦器
Service.interceptors.response.use(response => {
  const res = response.data
  if (response.status !== 200) {
    this.$message.error(res.massage || 'Error')
    return Promise.reject(new Error(res.massage || 'Error'))
  } else {
    return res
  }
}, error => {
  this.$message.error(error.message)
  return Promise.reject(error)
})
export default Service
