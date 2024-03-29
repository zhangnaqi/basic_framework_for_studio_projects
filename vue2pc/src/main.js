import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
// mock假数据
import './mock/index'
// 路由守卫
import './permission'
// 图标
import './icons'
// element ui
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.config.productionTip = false
Vue.use(ElementUI)
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
