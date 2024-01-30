<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <TestComponent msg="Welcome to Your Vue.js App" user-id="test id"/>
 </div>
</template>

<script>
// @ is an alias to /src
import TestComponent from "@/components/TestComponent.vue";

export default {
  name: 'HomeView',
  components: {
    TestComponent
  }
}
</script>
