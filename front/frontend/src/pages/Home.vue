
<template>
    <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-body-tertiary">
      <div class="col-md-5 p-lg-5 mx-auto my-5 text-left">
        <h1 class="display-2 fw-bold text-white ">당신의 <br>대출 심사 결과를<br> 확인하세요</h1>
        <h3 class="fw-normal text-muted mb-5 text-white">Check The Result <br> Your Loan Judgement </h3>
        <div class="d-flex gap-3  lead fw-normal">

            <a href="/judgment" class="btn btn-primary btn-lg">심사 받기</a>

        </div>
      </div>
      <div class="product-device shadow-sm d-none d-md-block"></div>
      <div class="product-device product-device-2 shadow-sm d-none d-md-block"></div>
    </div>

  <Board/>
  <CarList/>


</template>

<script>

import Board from "@/pages/Board.vue";
import CarList from "@/pages/Contract/CarList.vue";


export default {
  name:"Home",
  components: {Board, CarList}

}

</script>


<style>

.bg-body-tertiary {
  width: auto;
  height: auto;
  background-image: url('@/assets/homeimg.png');
  background-size: cover;
  background-position: center;
}


@media (min-width: 768px) {
  .bd-placeholder-img-lg {
    font-size: 3.5rem;
  }
}

.nav-scroller .nav {
  display: flex;
  flex-wrap: nowrap;
  padding-bottom: 1rem;
  margin-top: -1px;
  overflow-x: auto;
  text-align: center;
  white-space: nowrap;
  -webkit-overflow-scrolling: touch;
}


.bd-mode-toggle .dropdown-menu .active .bi {
  display: block !important;
}
</style>