

<template>
  <div class="album py-5 bg-light">
    <div class="container">
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
        <div class="col" v-for="(item, idx) in cars.items.slice(0, 6)" :key="idx">
          <Cars :item="item"/>
        </div>
      </div>
    </div>
  </div>

</template>

<script>

import Cars from "@/pages/Cars.vue"
import {onMounted, reactive} from "vue";
import axios from "axios";

export default {
  name:"Home",
  components: {Cars},
  setup(){


    const cars = reactive({
      items:[]
    })

    onMounted(async () => {
      const items = await axios.get("/api/cars");
      cars.items=items.data;
      console.log("items",cars.items);

    });

    return {cars}
  }
  }
</script>

<style scoped>

</style>