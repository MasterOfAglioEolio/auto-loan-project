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
import CarList from "@/pages/Contract/CarList.vue";
import Cart from "@/pages/Contract/Cart.vue";
import Contract from "@/pages/Contract/Contract.vue";
import Contract_check from "@/pages/Contract/Contract_check.vue";
import Repayment from "@/pages/Repayment/Repayment.vue";
import Repayment_history from "@/pages/Repayment/Repayment_history.vue";

const routes=[
    {path:'/', component:Home},
    {path:'/login',component: Login},
    {path:'/info', component:info},
    {path:'/sign',component: Sign_In},
    {path:'/application',component:Application},
    {path:'/judgment',component:Judgment},
    {path:'/contract',component: Contract},
    {path:'/contract-check',component: Contract_check},
    {path:'/car-list',component: CarList},
    {path:'/cart',component: Cart},
    {path:'/repayment',component: Repayment},
    {path:'/repayment-history',component: Repayment_history},
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