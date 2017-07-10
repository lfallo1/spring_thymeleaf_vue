import Vue from 'vue'
import Products from './Products.vue'
import CheckoutForm from './CheckoutForm.vue'
import ContactUs from './ContactUs.vue'
import config from './config.js';

//add components
Vue.component('app-products', Products);
Vue.component('app-checkoutform', CheckoutForm);
Vue.component('app-contactus', ContactUs);

//set csrf header
config.setCsrfHeader();

new Vue({
  el: '#app',
  data(){
    return {
      showNotifications: true
    }
  },
  mounted(){
    setTimeout(()=>this.showNotifications = false, 5000);
  }
});
