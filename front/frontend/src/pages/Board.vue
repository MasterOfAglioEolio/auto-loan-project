

<template>
  <div id="nav">
    <button @click="currentView = 'BoardList'">공지사항</button> |
    <button @click="currentView = 'QuestionList'">Q&A</button>
  </div>
  <component :is="currentView"/>
</template>

<script>
import BoardList from '@/pages/board/BoardList.vue'
import QuestionList from '@/pages/question/QuestionList.vue' // QuestionList 컴포넌트를 임포트하세요.

export default {
  components: {
    BoardList,
    QuestionList // QuestionList 컴포넌트를 등록하세요.
  },
  data() {
    return {
      currentView: 'BoardList'
    }
  }
}
</script>

<style>

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

nav .navbar-nav a.router-link-exact-active {
  color: #42b983 !important;
}

nav .navbar-nav a.nav-link {
  font-weight: bold;
  color: #2c3e50 !important;
}

</style>