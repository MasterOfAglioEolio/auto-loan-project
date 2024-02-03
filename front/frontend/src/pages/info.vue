<template>
  <div>
    <InfoForm v-if="!$store.state.info.id& $store.state.large_Mode.check === 0" />
    <Info_step v-else-if="!$store.state.info.id & $store.state.large_Mode.check === 1"/>
    <InfoEdit v-else />
  </div>
</template>

<script>

import InfoEdit from "@/pages/InfoEdit.vue";
import InfoForm from "@/pages/InfoForm.vue";
import Info_step from "@/pages/Info_step.vue";

export default {
  components: {
    InfoForm,
    InfoEdit,
    Info_step
  }
}

</script>