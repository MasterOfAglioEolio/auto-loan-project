import './assets/common.css'
import '@popperjs/core';

import { createApp } from 'vue'
import store from "@/scripts/store";
import App from './App.vue'
import router from "@/scripts/router"
import vuetify from './plugins/vuetify'
import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";


// import axios from "axios";
// const app = createApp(App)
// app.config.globalProperties.$axios = axios;  //전역변수로 설정 컴포넌트에서 this.$axios 호출할 수 있음
createApp(App).use(vuetify).use(store).use(router).mount('#app')