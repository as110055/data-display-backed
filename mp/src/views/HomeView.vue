<template>
  <div class="home">
    <el-container style="height: 100%; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246); height:100%">
        <Aside></Aside>
      </el-aside>
      <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <Header></Header>
        </el-header>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
// @ is an alias to /src

import Aside from "../components/Aside";
import Header from "../components/Header";

export default {
  name: 'HomeView',
  components: {
    Aside,
    Header,
  },
  data() {

  },
  methods: {
  }
}
</script>

<style>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>