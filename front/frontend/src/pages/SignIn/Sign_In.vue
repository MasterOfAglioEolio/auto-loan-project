
<template>
  <Sign_In_Form v-if="$store.state.large_Mode.check === 0"/>
  <Sign_In_Step v-else-if="$store.state.large_Mode.check === 1"/>
</template>

<script>
import store from "@/scripts/store";
import Sign_In_Step from "@/pages/SignIn/Sign_In_Step.vue";
import Sign_In_Form from "@/pages/SignIn/Sign_In_Form.vue";

export default {
  components: {Sign_In_Form, Sign_In_Step},
  computed: {
    store() {
      return store
    }
  },

};
</script>



<style scoped>

</style>