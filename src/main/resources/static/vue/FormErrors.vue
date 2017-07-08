<template>
  <div id="form-errors">
    <div class="alert alert-danger text-center">
      <table class="table table-hover text-center">
        <thead>
          <tr>
            <th>Field</th>
            <th>Error Type</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="error in errors">
            <td>{{error.field}}</td>
            <td>{{error.code}}</td>
            <td>{{error.defaultMessage}}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
  export default{
    props: {
      errors: {
        required: true,
        type: Array
      }
    }
  }
</script>

<style scoped>
#form-errors {
  margin-top: 15px;
}
#form-errors th{
    text-align: center !important;
    background: white;
}
</style>
