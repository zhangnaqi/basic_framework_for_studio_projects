<template>
  <div>
    <h1>首页</h1>
    <h2>名字：{{name}}</h2>
  </div>
</template>

<script>
export default {
  name: 'IndexView',
  data() {
    return {
      name: this.$store.getters.name
    }
  },
  methods: {

  }
}
</script>

<style scoped>

</style>
