<template>
  <div>
    <el-container>
      <!--页头-->
      <el-header :style="{padding: 0}">
        <el-menu
          router
          :default-active="activeIndex"
          class="el-menu-demo"
          mode="horizontal"
          @select="handleSelect"
        >
          <el-menu-item
            index="index"
            route="/index"
          >首页</el-menu-item>
          <el-submenu
            :style="{float: 'right'}"
            index="2-4"
          >
            <template slot="title">
              <el-avatar
                shape="square"
                fit="contain"
                :src="userAvatar"
              />
            </template>
            <el-menu-item
              index="mine"
              route="/mine"
            >我的</el-menu-item>
            <el-menu-item
              index="logout"
              route="#"
              @click.native="logout"
            >登出</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-header>
      <!--页面内容-->
      <el-main>
        <router-view />
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  name: 'HomeView',
  data() {
    return {
      activeIndex: this.$store.getters.activeIndex,
      userAvatar: this.$store.getters.avatar
    }
  },
  // beforeUpdate() {
  //   console.log('beforeUpdate')
  //   console.log(this.$store.getters.activeIndex)
  //   console.log(this.$store.getters.avatar)
  //   this.activeIndex = this.$store.getters.activeIndex
  //   this.userAvatar = this.$store.getters.avatar
  // },
  methods: {
    handleSelect(index, indexPath) {
      console.log('选择导航栏 ===》 ', index, indexPath)
      if (index === 'logout') {
        console.log('=== 登出 ===')
      } else {
        this.$store.commit('router/SET_ACTIVE_INDEX', index)
        this.activeIndex = index
      }
    },
    async logout() {
      await this.$store.dispatch('router/resetActiveIndex')
      await this.$store.dispatch('user/logout')
      this.$router.push(`/index`)
      location.reload()
    }
  }
}
</script>

<style scoped>
.el-menu-demo {
  margin-bottom: 20px;
}

.footer {
  color: #888;
}
</style>
<style>
body {
  padding: 0;
  margin: 0;
  background-color: #f5f5f5;
  box-sizing: border-box;
  overflow-x: hidden;
  height: 100%;
}

.flex-grow {
  flex-grow: 1;
}
.dream-container {
  width: 95%;
  margin: 30px auto;
}
</style>
