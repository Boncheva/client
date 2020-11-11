import Vue from 'vue'
import index from '@/view/index.vue'
import Login from '@/view/login.vue'
import VueRouter from "vue-router"

Vue.use(VueRouter)
const router = new VueRouter({
    routes: [{
        name: 'index',
        path: '/index',
        component: index,
        children: [{
            path: 'appUserMan',
            name: 'appUserMan',
            component: () => import('@/view/applyUser/appUserMan.vue'),
        },
            {
                path: 'orderBooking',
                name: 'orderBooking',
                component: () => import('@/view/orderBooking/orderBooking.vue'),
            },
            {
                path: 'hotelInfoMan',
                name: 'hotelInfoMan',
                component: () => import('@/view/hotelInfoMan/hotelInfoMan.vue'),
            },
        ]
    }, {
        path: '/login',
        component: Login
    }]
})

router.beforeEach((to, from, next) => {
    if (to.path === '/login') {
        next();
    } else {
        let token = localStorage.getItem('Authorization');

        if (token === 'null' || token === '') {
            next('/login');
        } else {
            next();
        }
    }
})
export default router