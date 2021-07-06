import Vue from 'vue'
import Router from "vue-router";

import login from "@/view/login";
import pdf from "../view/pdf";

Vue.use(Router)

const routers = new Router({
    mode: 'history',
    routes:[
        {
            path: '/',
            name: 'pdf',
            component: pdf
        },
        {
            path: '/login',
            name:'login',
            component: login
        }

    ]
})
export default routers
