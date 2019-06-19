<template>
  <div class="div-root">
    <div class="div-top">
      <Head ></Head>
    </div>
    <div class="div-center">
      <div>
        <Navmenu></Navmenu>
      </div>
      <div class="div-content">
        <router-view/>
      </div>
    </div>
    <div class="div-bottom">bottom</div>
  </div>
</template>
<script>
import Head from '@/components/Head'
import Navmenu from '@/components/Navmenu'

export default {
  data () {
    return {}
  },
  components: {
    Head, Navmenu
  }
}
</script>

<style scope>
.div-root {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  display: flex;
  flex-direction: column;
  /* justify-content: space-around; */
  height: 100%; 
}
.div-top {
  /* flex: 1; */
}
.div-center {
  flex: 1;
  display: flex;
  flex-direction: row;
}
.div-content {
  flex: 1;
}
.div-bottom {
  /* flex: 1; */
}
</style>
