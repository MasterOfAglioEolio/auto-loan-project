<template>
  <div>
    <ApplicationForm v-if="!$store.state.application.id" />
    <ApplicationEdit v-else />
  </div>
</template>

<script>
import ApplicationForm from '@/pages/ApplicationForm.vue'
import ApplicationEdit from '@/pages/ApplicationEdit.vue'
import axios from "axios";
import store from "@/scripts/store";
import {useRoute} from "vue-router";
import {watch} from "vue";

export default {
  components: {
    ApplicationForm,
    ApplicationEdit
  }
}

const check_application = ()=>{
  axios.get("/api/check-application").then(({data})=>{
    console.log("[Check-application in Application]",data);
    store.commit("setApplication",data||0);

  })
};

const route = useRoute();

watch(route, () => {
  check_application();
})
</script>