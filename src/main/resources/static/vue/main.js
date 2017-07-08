import Vue from 'vue'
import Products from './Products.vue'
import CheckoutForm from './CheckoutForm.vue'

//add components
Vue.component('app-products', Products);
Vue.component('app-checkoutform', CheckoutForm);

new Vue({
  el: '#app'
});
