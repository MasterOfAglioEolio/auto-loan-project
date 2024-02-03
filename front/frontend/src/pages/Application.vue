<template>
  <div>
    <ApplicationForm v-if="!$store.state.application.id" />
    <ApplicationEdit v-else />
  </div>
</template>

<script>
import ApplicationForm from '@/pages/ApplicationForm.vue'
import ApplicationEdit from '@/pages/ApplicationEdit.vue'
import store from "@/scripts/store";


export default {
  components: {
    ApplicationForm,
    ApplicationEdit
  }
}
console.log("[Check-application in Application]",store.state.application.id);

</script>