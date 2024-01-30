import Home from '../views/HomeView.vue'
import ArticleList from '@/views/board/BoardList.vue'
// import BoardDetail from '@/views/board/BoardDetail.vue'
// import BoardWrite from '@/views/board/BoardWrite.vue'
import {createRouter, createWebHistory} from "vue-router";

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'about',
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/article/list',
    name: 'ArticleList',
    component: ArticleList
  }

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router

