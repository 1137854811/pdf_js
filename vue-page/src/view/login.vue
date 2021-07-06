<template>
  <div>
    {{ newUserId }}
  </div>
</template>

<script>
export default {
  name: "login",
  data(){
    return {
      userId: 'tz',
      newUserId: null
    }
  },
  created() {
    this.test()
  },
  methods:{
    test(){
      const data = {
        userId: this.userId
      }
      this.axios.post('/api/user',data).then(res => {
        this.newUserId = res.data
        console.log("this is result:"+res)
      })
    }
  }
}
</script>
<style scoped>

</style>
