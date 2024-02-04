

<template>
  <div class="card shadow-sm">
    <span class="img" :style="{backgroundImage: `url(${item.imgPath})`}"/>
    <div :class="{'card-body':true, 'large-font':store.state.large_Mode.check === 1}">
      <p class="card-text">
        <span class="fw-bold">{{ item.name }} &nbsp;</span><br/>
        <span class="small-text">{{ item.info }} &nbsp;</span><br/>
        <span class="discount badge bg-danger">
          최대 할부 48개월
        </span>
      </p>
      <div class="d-flex justify-content-between align-items-center">

        <small class="price text-muted">
          {{ lib.getNumberFormatted(item.price) }}원
        </small>
        <small class="real text-danger">
          월 {{ lib.getNumberFormatted((item.price/48).toFixed(0)) }} 원
        </small>
      </div>
    </div>
  </div>
</template>

<script>
import lib from "@/scripts/lib";
import store from "@/scripts/store";
export default {
  name:'Cars',
  computed: {
    store() {
      return store
    },
    lib() {
      return lib
    }
  },
  props:{
    item:Object
  }
}
</script>

<style scoped>
.card .img {
  display: inline-block;
  width: 100%;
  height: 250px;
  background-size: cover;
  background-position: center;
}

.card .card-body .price {
  text-decoration: line-through;

}
.small-text {
  font-size: 0.8em;
}
</style>

