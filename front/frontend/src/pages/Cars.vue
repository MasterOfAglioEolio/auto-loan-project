

<template>
  <div class="card shadow-sm">
    <span class="img" :style="{backgroundImage: `url(${item.imgPath})`}"/>
    <div class="card-body">
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
          월 {{ lib.getNumberFormatted((item.price/48).toFixed(2)) }} 원
        </small>
      </div>
    </div>
  </div>


<!--  <div class="d-md-flex flex-md-equal w-100 my-md-3 ps-md-3">-->
<!--    <div class="bg-body-tertiary me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden w-100">-->
<!--      <div class="my-3 p-3">-->
<!--        <h2 class="display-5">Another headline</h2>-->
<!--        <p class="lead">And an even wittier subheading.</p>-->
<!--      </div>-->
<!--      <div class="bg-dark shadow-sm mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"></div>-->
<!--    </div>-->
<!--    <div class="text-bg-primary me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden w-100">-->
<!--      <div class="my-3 py-3">-->
<!--        <h2 class="display-5">Another headline</h2>-->
<!--        <p class="lead">And an even wittier subheading.</p>-->
<!--      </div>-->
<!--      <div class="bg-body-tertiary shadow-sm mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"></div>-->
<!--    </div>-->
<!--  </div>-->

</template>

<script>
import lib from "@/scripts/lib";
export default {
  name:'Cars',
  computed: {
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

