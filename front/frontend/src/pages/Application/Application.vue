<template>
  <div>
    <Info v-if="!$store.state.info.id"/>
    <ApplicationForm v-if="!$store.state.application.id & $store.state.large_Mode.check === 0" />
    <Application_Step v-else-if="!$store.state.application.id & $store.state.large_Mode.check === 1" />
    <ApplicationEdit v-else />
  </div>
</template>

<script>
import ApplicationForm from '@/pages/Application/ApplicationForm.vue'
import ApplicationEdit from '@/pages/Application/ApplicationEdit.vue'
import store from "@/scripts/store";
import Application_Step from "@/pages/Application/Application_Step.vue";
import Info from "@/pages/Info/info.vue";


export default {
  components: {
    Info,
    Application_Step,
    ApplicationForm,
    ApplicationEdit
  }
}
console.log("[Check-application in Application]",store.state.application.id);

</script>