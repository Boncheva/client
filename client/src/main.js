import Vue from 'vue'
import App from './App.vue'
import router from '@/router/index'
import ElementUI from 'element-ui';
import './assets/css/global.css'
import './assets/css/login.css'
import './assets/css/master.css'
import './assets/css/monthly-report.css'
import 'element-ui/lib/theme-chalk/index.css'
import VueResource from 'vue-resource'
Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(VueResource)
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
