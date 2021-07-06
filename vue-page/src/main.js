import Vue from 'vue'
import App from './App.vue'
import router from "@/router/router";
import axios from 'axios';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(router)
Vue.config.productionTip = false
Vue.prototype.axios = axios
Vue.use(ElementUI); // 添加ElementUI

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
