<template>
  <div id="contact-us">
    <h3>Hello from normal component {{name}}</h3>
    <div th:text="${pageTitle}">Page title</div>
  </div>
</template>

<script>
  export default{
    data(){
      return {
        name: "Harrison",
        pageTitle: ''
      }
    },
    mounted(){
      this.pageTitle = this.$refs.pageTitle.innerText;
    }
  }
</script>
