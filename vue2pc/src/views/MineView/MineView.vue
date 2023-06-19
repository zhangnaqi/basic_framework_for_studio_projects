<template>
  <div>
    <el-button @click="toLogin">点击跳转登录页进行登录</el-button>
  </div>
</template>

<script>
import router from '@/router'

export default {
  name: 'MineView',
  methods: {
    toLogin() {
      router.push('/login')
    }
  }
}
</script>

<style scoped>

</style>
