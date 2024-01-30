import { createRouter, createWebHistory } from 'vue-router'

import PageHome from '../views/PageHome.vue'

import BoardList from "@/views/board/BoardList.vue";
import BoardDetail from "@/views/board/BoardDetail.vue";
import BoardWrite from '@/views/board/BoardWrite.vue';

import QuestionList from "@/views/question/QuestionList.vue";
import QuestionDetail from "@/views/question/QuestionDetail.vue";
import QuestionWrite from "@/views/question/QuestionWrite.vue";
const routes = [

  {
    path: '/',
    name: 'PageHome',
    component: PageHome
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
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
