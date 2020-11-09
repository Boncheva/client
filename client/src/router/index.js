import Vue from 'vue'
import index from '@/view/index.vue'
import Login from '@/view/login.vue'
import VueRouter from "vue-router"

Vue.use(VueRouter)
const router = new VueRouter({
    routes: [{
        path: '/index',
        component: index,
        children: [{
            path: 'appUserMan',
            name: 'appUserMan',
            component: () => import('@/view/applyUser/appUserMan.vue')
        },
            {
                path: 'orderBooking',
                name: 'orderBooking',
                component: () => import('@/view/orderBooking/orderBooking.vue')
            },
            {
                path: 'hotelInfoMan',
                name: 'hotelInfoMan',
                component: () => import('@/view/hotelInfoMan/hotelInfoMan.vue')
            }
        ]
    }, {
        path: '/login',
        component: Login
    }]
})
export default router