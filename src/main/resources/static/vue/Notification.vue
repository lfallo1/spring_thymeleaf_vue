<template>
  <div id="app-notifications">
    <p>{{message}}</p>
  </div>
</template>

<script>
  export default{
    props: ['message']
  }
</script>

<style scoped>
#app-notifications{
  position: fixed;
	top: 0;
	width: 100%;
	background: rgba(66,139,202, 0.9);
	padding: 8px 28px;
	color: white;
	font-size: 18px;
	border-radius: 4px;
	text-align: center;
}
</style>
