import Home from "@/pages/Home.vue";
import Login from "@/pages/Login.vue";
import info from "@/pages/info.vue";
import Sign_In from "@/pages/Sign_In.vue";
import {createRouter, createWebHistory} from "vue-router";

const routes=[
    {path:'/', component:Home},
    {path:'/login',component: Login},
    {path:'/info', component:info},
    {path:'/sign',component: Sign_In}

]

const router = createRouter({
    history:createWebHistory(),
    routes
})

export default router;