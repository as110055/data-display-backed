<template>
  <div>
    <el-table :data="tableData">
      <el-table-column prop="id" label="id" width="140">
      </el-table-column>
      <el-table-column prop="username" label="Name" width="120">
      </el-table-column>
      <el-table-column prop="age" label="Age" width="120">
      </el-table-column>
      <el-table-column prop="gender" label="Gender" width="120">
      </el-table-column>
      <el-table-column prop="education" label="Education" width="120">
      </el-table-column>
    </el-table>

    <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageNum"
      :page-sizes="[1, 5, 10, 15]" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper" :total="total">
    </el-pagination>
  </div>
</template>

<script>
export default {
  name: "First",

  data() {
    return {
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 5
    }
  },
  created() {
    this.load()
  },
  methods: {
    load() {
      this.request.get("http://localhost:8081/user/page", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
        }
      }).then(res => {
        this.tableData = res.data
        this.total = res.total
      })
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum) {
      this.pageNum = pageNum
      this.load()
    }
  }

}
</script>