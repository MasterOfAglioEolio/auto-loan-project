<template>
  <div>
    <InfoForm v-if="!$store.state.info.id" />
    <InfoEdit v-else />
  </div>
</template>

<script>
import axios from "axios";
import store from "@/scripts/store";
import {useRoute} from "vue-router";
import {watch} from "vue";
import InfoEdit from "@/pages/InfoEdit.vue";
import InfoForm from "@/pages/InfoForm.vue";

export default {
  components: {
    InfoForm,
    InfoEdit
  }
}

const check_info = ()=>{
  axios.get("/api/check-info").then(({data})=>{
    console.log("[Check-info in info]",data);
    store.commit("setInfo",data||0);

  })
};

const route = useRoute();

watch(route, () => {
  check_info();
})
</script>