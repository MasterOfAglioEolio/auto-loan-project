<template>
  <div>
    <InfoForm v-if="!$store.state.info.id" />
    <InfoEdit v-else />
  </div>
</template>

<script>

import InfoEdit from "@/pages/InfoEdit.vue";
import InfoForm from "@/pages/InfoForm.vue";

export default {
  components: {
    InfoForm,
    InfoEdit
  }
}

</script>