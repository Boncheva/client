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
import store from './store/index'
import moment from 'moment'

Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(VueResource)
new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')

Vue.prototype.$moment = moment;//赋值使用

// 添加请求拦截器，在所有请求头中加token
Vue.http.interceptors.push((request, next) => {
    if (!(request.url.indexOf('/admin/login') != -1)) {
        let TOKEN = localStorage.getItem('Authorization');

        request.headers.set('Authorization', TOKEN);

    }

    next(response => {
        console.log(response)
        if (response.body == '401') {
            router.push({path: '../login'});
        }
    })

});

