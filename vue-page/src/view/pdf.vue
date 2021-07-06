<template>
  <div>
    <el-button @click="pdf">预览pdf</el-button>
    <el-button @click="downloadPdf()">模板下载</el-button>

  </div>
</template>

<script>
export default {
  name: "pdf",
  data(){
    return {
      fileUrl: 'http://file.clzn.sunline.cn:8283/group1/M00/00/00/ChZVMmBZm8CANMbbAE4a0Em_r80670.pdf',
      newUserId: null
    }
  },
  mounted() {
  },
  methods: {
    downloadClick(){
      var link = document.createElement('a');
      link.setAttribute("download", "");
      link.href = "./batchCaseUpdate.xlsx";
      link.click();
    },


    pdf() {
      console.log('预览pdf')
      this.axios({
        methods: 'get',
        url: '/api/readPdfFile',
        params: {
          fileUrl: this.fileUrl
        },
        responseType: 'blob',
        headers:{
          'Content-Type': 'application/json'
        }
      }).then(res => {
        let blob = new Blob([res.data], {type: 'application/pdf'})
        let href = URL.createObjectURL(blob)
        console.warn(href)
        window.open(`./pdf/web/viewer.html?file=${encodeURIComponent(href)}`);
      })
    },
    downloadPdf() {
      console.log('下载pdf')
      this.axios({
        methods: 'get',
        url: '/api/readPdfFile',
        params: {
          fileUrl: this.fileUrl
        },
        responseType: 'blob',
        headers:{
          'Content-Type': 'application/json'
        }
      }).then(res => {
        const link = document.createElement('a')
        let blob = new Blob([res.data], {type: 'application/pdf'})
        link.href = URL.createObjectURL(blob)
        link.style.display = 'none'
        link.style.target = '_blank'
        link.href = URL.createObjectURL(blob)
        console.warn(link.href)
        link.download = new Date().getTime() //下载的文件名
        document.body.appendChild(link)
        link.click()
        document.body.removeChild(link)
      })
    }
  }
}
</script>

<style scoped>

</style>
