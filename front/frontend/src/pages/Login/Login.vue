<template>
  <LoginForm v-if="$store.state.large_Mode.check === 0"/>
  <LoginStep v-else-if="$store.state.large_Mode.check === 1"/>
</template>

<script>

import store from "@/scripts/store";
import LoginForm from "@/pages/Login/LoginForm.vue";
import LoginStep from "@/pages/Login/LoginStep.vue";


export default {
  components: {LoginStep, LoginForm},
  computed: {
    store() {
      return store
    }
  },


}
</script>

<style scoped>

</style>