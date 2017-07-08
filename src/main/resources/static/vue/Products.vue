<template>
	<div id="products-wrapper">
		
	  <div class="col-md-4" v-for="product in products">
	      <div class="course-listing">
	          <div class="row">
	              <a :href="'product/' + product.id">
	                  <div class="col-lg-12">
	                      <div class="course-box-image-container">
	                          <img role="presentation"
	                            :src="'images/' + product.imageUrl"
	                               class="course-box-image" />
	                      </div>
	                      <div class="course-listing-title">
	                          {{product.courseName}}
	                      </div>
	                      <div class="course-listing-subtitle">
	                          {{product.courseSubtitle}}
	                      </div>
	                  </div>
	              </a>
	          </div>
	          <div class="row course-listing-extra-info col-xs-12">
	              <div class="col-xs-8">
	                  <img align="left" alt="John Thompson"
	                    :src="'images/' + product.author.image"
	                       class="img-circle" />
	                  <div class="small course-author-name">
	                      {{product.author.firstName + ' ' + product.author.lastName}}
	                  </div>
	              </div>
	              <div class="col-xs-4">
	                  <div v-if="product.price" class="small course-price">
	                      ${{product.price}}
	                  </div>
	                  <div v-else class="small course-price">
	                    	FREE
	                  </div>
	              </div>
	          </div>
	      </div>
	    </div>
	 </div>
</template>

<script>
import axios from 'axios';
export default {
  data () {
    return {
      products: []
    }
  },
  created(){
    axios.get(`http://localhost:8080/api/products`)
        .then(response => {
          // JSON responses are automatically parsed.
          console.log(response.data);
          this.products = response.data
        })
        .catch(e => {
          console.log(e);
        })
  }
}
</script>

<style scoped>
</style>
