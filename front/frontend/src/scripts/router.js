import Home from "@/pages/Home.vue";
import Login from "@/pages/Login/Login.vue";
import info from "@/pages/Info/info.vue";
import Sign_In from "@/pages/SignIn/Sign_In.vue";
import {createRouter, createWebHistory} from "vue-router";
import Application from "@/pages/Application/Application.vue";
import Judgment from "@/pages/Judgment/Judgment.vue";
import BoardList from '@/pages/board/BoardList.vue'
import AboutView from "@/pages/AboutView.vue";
import BoardDetail from "@/pages/board/BoardDetail.vue";
import BoardWrite from "@/pages/board/BoardWrite.vue";
import QuestionList from "@/pages/question/QuestionList.vue";
import QuestionDetail from "@/pages/question/QuestionDetail.vue";
import QuestionWrite from "@/pages/question/QuestionWrite.vue";
import CommentDetail from "@/pages/comment/CommentDetail.vue";
import Order from "@/pages/Order/Order.vue";

const routes=[
    {path:'/', component:Home},
    {path:'/login',component: Login},
    {path:'/info', component:info},
    {path:'/sign',component: Sign_In},
    {path:'/application',component:Application},
    {path:'/judgment',component:Judgment},
    {path:'/order',component: Order},
    {path:'/orders',component: Orders},
    {
        path: '/about',
        name: 'about',
        component: AboutView
    },

    {
        path: '/board/list',
        name: 'BoardList',
        component: BoardList
    },
    {
        path: '/board/detail',
        name: 'BoardDetail',
        component: BoardDetail
    },
    {
        path: '/board/write',
        name: 'BoardWrite',
        component: BoardWrite
    },
    {
        path: '/question/list',
        name: 'QuestionList',
        component: QuestionList
    },
    {
        path: '/question/detail',
        name: 'QuestionDetail',
        component: QuestionDetail
    },
    {
        path: '/question/write',
        name: 'QuestionWrite',
        component: QuestionWrite
    },
    {
        path: '/comment/detail',
        name: 'CommentDetail',
        component: CommentDetail
    }


]

const router = createRouter({
    history:createWebHistory(),
    routes
})

export default router;