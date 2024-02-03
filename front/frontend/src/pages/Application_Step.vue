<template>

  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5 align-items-center large-font">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-auto d-flex justify-content-center align-items-center" style="height: 70vh;">
            <div class="p-5">
              <div class="text-center">
                <h1 class="display-6 fw-bold">Fill out the application form</h1>
                <h2 class="fw-normal text-muted mb-5">대출 심사 신청서를 작성해주세요!!</h2>
                <h2 class="fw-bold mb-5">{{state.step}}/{{Object.keys(state.info).length-2}}</h2>
              </div>
              <form class="application" @submit.prevent="submitData">
                  <div class="col-sm-12 my-5" v-if="state.step === 1">
                    <label for="name" class="form-label fw-bold">Name</label>
                    <input type="text" class="form-control form-control-user" id="name" name="name" v-model="state.selected['name']" required>
                  </div>
                <div class="col-sm-12 my-5" v-if="state.step === 2">
                    <label for="cellPhone" class="form-label fw-bold">Cell Phone</label>
                    <input type="text" class="form-control form-control-user" id="cellPhone" name="cellPhone" v-model="state.selected['cellPhone']" required>
                  </div>
                <div class="col-sm-12 my-5" v-if="state.step === 3">
                    <label for="carPrice" class="form-label fw-bold">Car Price</label>
                    <input type="number" class="form-control form-control-user" id="carPrice" name="carPrice" v-model="state.selected['carPrice']" required>
                  </div>
                <div class="col-sm-12 my-5" v-if="state.step === 4">
                    <label for="loanType" class="form-label fw-bold">Loan Type</label>
                    <select class="form-select" id="loanType" v-model="state.selected['loanType']" required>
                      <option disabled value="">Please select a loan type</option>
                      <option v-for="value in state.info['loanType']" :key="value" :value="value">{{ value }}</option>
                    </select>
                  </div>
                <div class="col-sm-12 my-5" v-if="state.step === 5">
                    <label for="deposit" class="form-label fw-bold">Deposit</label>
                    <select class="form-select" id="deposit" v-model="state.selected['deposit']" required>
                      <option disabled value="">Please select a deposit</option>
                      <option v-for="value in [0, 10, 20, 30]" :key="value" :value="value">{{ value }}</option>
                    </select>
                  </div>
                <div class="col-sm-12 my-5" v-if="state.step === 6">
                    <label for="loanTerm" class="form-label fw-bold">Loan Term</label>
                    <select class="form-select" id="loanTerm" v-model="state.selected['loanTerm']" required>
                      <option disabled value="">Please select a loan term</option>
                      <option v-for="value in [12, 24, 36, 48]" :key="value" :value="value">{{ value }}</option>
                    </select>
                  </div>
                <div class="col-sm-12 my-5" v-if="state.step === 7">
                    <label for="interestType" class="form-label fw-bold">Interest Type</label>
                    <select class="form-select" id="interestType" v-model="state.selected['interestType']" required>
                      <option disabled value="">Please select an interest type</option>
                      <option v-for="value in state.info['interestType']" :key="value" :value="value">{{ value }}</option>
                    </select>
                  </div>

                <div class="btn-group">
                  <button class="btn btn-primary btn-lg" type="button" v-if="state.step > 1" @click="state.step--">
                    Prev
                  </button>
                  <button class="btn btn-primary btn-lg" type="button" v-if="state.step < Object.keys(state.info).length-2" @click="state.step++">
                    Next
                  </button>
                  <button class="btn btn-primary btn-lg" type="submit" v-if="state.step === Object.keys(state.info).length-2">
                    Register Information
                  </button>
                </div>

              </form>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>


<script>
import {onMounted, reactive} from "vue";
import axios from "axios";
import router from "@/scripts/router";

export default {
  name:"application",
  setup(){
    const state = reactive({
      info:{},
      selected: {},
      step:1
    })

    onMounted(async () => {
      const response = await axios.get("/api/application");
      console.log("[response]",response)
      state.info = response.data;

      for (let key in state.info) {
        if (Array.isArray(state.info[key])) {
          state.selected[key] = '';
        }
      }


    });

    const submitData = async () => {
      try {
        const response = await axios.post('/api/application/register', state.selected);
        console.log(response.data);
        await router.push({path: "/application"});
        // 데이터 전송 성공에 대한 처리를 이곳에 작성합니다.
        state.step=1;
      } catch (error) {
        console.error(error);
        // 데이터 전송 실패에 대한 처리를 이곳에 작성합니다.
      }
    };



    return { state, submitData };
  }
};

</script>



<style scoped>

.btn-group{
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap:20px;
  margin:auto;
}
.large-font, .form-select {
  font-size: 1.5em;
}

</style>