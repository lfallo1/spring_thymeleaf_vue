import Vue from 'vue'
import Products from './Products.vue'
import CheckoutForm from './CheckoutForm.vue'
import Notification from './Notification.vue'
import ContactUs from './ContactUs.vue'

//add components
Vue.component('app-products', Products);
Vue.component('app-checkoutform', CheckoutForm);
Vue.component('app-notification', Notification);
Vue.component('app-contactus', ContactUs);

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
