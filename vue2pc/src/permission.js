import router from './router'
import { getToken } from './utils/auth'
import store from './store'

const blackList = []

router.beforeEach(async(to, from, next) => {
  // console.log('to', to)
  // console.log('from', from)
  console.log('路由守卫 ===》 ', to, from)
  const hasToken = getToken()
  console.log('是否成功的获取了token ===》 ', hasToken)
  if (hasToken) {
    // token 存在
    if (to.path === '/login' || to.path === '/register') {
      // 进入登录，注册页面直接跳转到首页
      next({ path: '/index' })
    } else {
      console.log('vuex中是否正确存储name ===》 ', store.getters.name)
      if (store.getters.name) {
        // 有用户信息
        next()
      } else {
        // 没有用户信息, 获取用户信息
        try {
          await store.dispatch('user/getInfo')
          next()
        } catch (error) {
          // 移除token
          await store.dispatch('user/resetToken')
          // 请重新登录获取用户信息
          this.$message.error(error || 'error')
          next(`login?redirect=${to.path}`)
        }
      }
    }
  } else {
    // token 不存在
    if (blackList.indexOf(to.path) !== -1) {
      next(`/login?redirect=${to.path}`)
    } else {
      next()
    }
  }
})
