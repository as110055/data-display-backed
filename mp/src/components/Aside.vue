<template>
    <el-menu :default-openeds="['1', '3']" router>
        <el-submenu index="1">
          <template slot="title"><i class="el-icon-message"></i>Navigator One</template>
          <el-menu-item-group>
            <template slot="title">Group 1</template>
            <el-menu-item index="/">Option 1</el-menu-item>
            <el-menu-item  index="/second">Option 2</el-menu-item>
            <el-menu-item  index="/third">Option 3</el-menu-item>
          </el-menu-item-group>
          
        </el-submenu>
    </el-menu>
</template>

<script>
    export default {
        name: "Aside"
    }
</script>