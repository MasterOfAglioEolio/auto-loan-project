import Home from "@/pages/Home.vue";
import Login from "@/pages/Login.vue";
import info from "@/pages/info.vue";
import Sign_In from "@/pages/Sign_In.vue";
import {createRouter, createWebHistory} from "vue-router";
import Application from "@/pages/Application.vue";
import info_step from "@/pages/Info_step.vue";
import Judgment from "@/pages/Judgment.vue";

const routes=[
    {path:'/', component:Home},
    {path:'/login',component: Login},
    {path:'/info', component:info},
    {path:'/info_step', component:info_step},
    {path:'/sign',component: Sign_In},
    {path:'/application',component:Application},
    {path:'/judgment',component:Judgment}

]

const router = createRouter({
    history:createWebHistory(),
    routes
})

export default router;