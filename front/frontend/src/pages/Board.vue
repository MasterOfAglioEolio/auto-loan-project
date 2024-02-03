

<template>
  <div id="nav" :class="{'large-font': store.state.large_Mode.check === 1}">
    <button @click="currentView = 'BoardList'" >공지사항</button> |
    <button @click="currentView = 'QuestionList'">Q&A</button>
  </div>
  <component :is="currentView"/>
</template>

<script>
import BoardList from '@/pages/board/BoardList.vue'
import QuestionList from '@/pages/question/QuestionList.vue'
import store from "@/scripts/store";

export default {
  computed: {
    store() {
      return store
    }
  },
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