import Vue from 'vue'
import Products from './Products.vue'
import CheckoutForm from './CheckoutForm.vue'
import Notification from './Notification.vue'

//add components
Vue.component('app-products', Products);
Vue.component('app-checkoutform', CheckoutForm);
Vue.component('app-notification', Notification);

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
