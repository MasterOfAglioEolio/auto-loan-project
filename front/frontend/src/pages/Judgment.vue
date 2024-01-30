<template>
  <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-body-tertiary">
    <div class="col-md-6 p-lg-5 mx-auto my-5">

            <h1 class="display-3 fw-bolder mb-0"><span class="text-black d-inline">당신의 대출 심사 결과 예상?</span></h1>
            <h3 class="highlight-text display-3 fw-bolder mb-5" v-if="info.value"><span class="text-gradient d-inline">{{info.value['judgment']}}</span></h3><br>
            <h1 class="display-3 fw-bolder mb-0"><span class="text-black d-inline">예상 대출 금리</span><br></h1>
            <h3 class="highlight-text display-3 fw-bolder mb-5" v-if="info.value">
            <span class="text-gradient d-inline">
                <CountUp :endVal="info.value['interestRate']" :decimalPlaces="2" class="d-inline-block"/>
                <span class="d-inline-block">%</span>
            </span>
              </h3>
            <br>

           <div class="d-flex gap-3 justify-content-center lead fw-normal">
            <a class="btn btn-primary btn-lg px-0 py-3 me-sm-3 fs-6 fw-bolder" href="/">about</a>
            <a class="btn btn-outline-dark btn-lg px-5 py-3 fs-6 fw-bolder" href="/">Ummmmmm</a>
          </div>
        </div>
      </div>

</template>

<script>
import {onMounted, reactive} from "vue";
import axios from "axios";
import CountUp from 'vue-countup-v3';

export default {
  components: {
    CountUp,
  },
  name:"judgment",
  setup() {
    const info = reactive({});
    const account_id = reactive({});

    onMounted(async () => {
    try {

      const responseCheck = await axios.get("/api/check");
      account_id.value = responseCheck.data;
      console.log("[CHECK ID in Judgment]", account_id.value);

      const responseInfo = await axios.get(`/api/judgment/${account_id.value}`);
      info.value = responseInfo.data;
      console.log("[InfoValue]", info.value);
      console.log("[Judgment STATE INFO]", info.value['judgment'], info.value['interestRate']);
    } catch (error) {
      console.error("Error loading data:", error);
    }
  });

    return {info, account_id};
  }
}

</script>

<style scoped>
.highlight-text {
  color: #6200EA;
}
</style>