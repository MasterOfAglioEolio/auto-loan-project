<template>

  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="display-6 fw-bold">Application form</h1>
                <h5 class="fw-normal text-muted mb-5">대출 심사 신청서</h5>
              </div>
              <form class="application" @submit.prevent="submitData">
                <div class="form-group row my-5">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <label for="name" class="form-label fw-bold">Name</label>
                    <input type="text" class="form-control form-control-user" id="name" name="name" v-model="application_data.selected['name']" required>
                  </div>
                  <div class="col-sm-6">
                    <label for="cellPhone" class="form-label fw-bold">Cell Phone</label>
                    <input type="text" class="form-control form-control-user" id="cellPhone" name="cellPhone" v-model="application_data.selected['cellPhone']" required>
                  </div>
                </div>
                <div class="form-group row my-5">
                  <div class="col-sm-6">
                    <label for="carPrice" class="form-label fw-bold">Car Price</label>
                    <input type="number" class="form-control form-control-user" id="carPrice" name="carPrice" v-model="application_data.selected['carPrice']" required>
                  </div>
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <label for="loanType" class="form-label fw-bold">Loan Type</label>
                    <select class="form-select" id="loanType" v-model="application_data.selected['loanType']" required>
                      <option disabled value="">Please select a loan type</option>
                      <option v-for="value in state.info['loanType']" :key="value" :value="value">{{ value }}</option>
                    </select>
                  </div>
                </div>
                <div class="form-group row my-5">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <label for="deposit" class="form-label fw-bold">Deposit</label>
                    <select class="form-select" id="deposit" v-model="application_data.selected['deposit']" required>
                      <option disabled value="">Please select a deposit</option>
                      <option v-for="value in [0, 10, 20, 30]" :key="value" :value="value">{{ value }}</option>
                    </select>
                  </div>
                  <div class="col-sm-6">
                    <label for="loanTerm" class="form-label fw-bold">Loan Term</label>
                    <select class="form-select" id="loanTerm" v-model="application_data.selected['loanTerm']" required>
                      <option disabled value="">Please select a loan term</option>
                      <option v-for="value in [12, 24, 36, 48]" :key="value" :value="value">{{ value }}</option>
                    </select>
                  </div>
                </div>
                <div class="form-group row my-5">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <label for="interestType" class="form-label fw-bold">Interest Type</label>
                    <select class="form-select" id="interestType" v-model="application_data.selected['interestType']" required>
                      <option disabled value="">Please select an interest type</option>
                      <option v-for="value in state.info['interestType']" :key="value" :value="value">{{ value }}</option>
                    </select>
                  </div>
                </div>
              </form>

              <div class="btn-group">
                <!-- ... 나머지 필드들을 이와 같은 방식으로 추가 ... -->
                <button class="btn btn-primary btn-lg" type="submit" @click="submitData">
                  Edit Application
                </button>
                <button class="btn btn-success btn-lg" type="submit" @click="submitJudgment">
                  Judgment
                </button>
              </div>


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
import store from "@/scripts/store";

export default {
  name:"application",
  setup(){
    const state = reactive({
      info:{},
      selected: {}
    })

    const application_data = reactive({
      info:{},
      selected: {}
    })

    const account_id = store.state.accountId.id;


    onMounted(async () => {


      const response = await axios.get("/api/application");
      console.log("[response]",response)
      state.info = response.data;

      for (let key in state.info) {
        if (Array.isArray(state.info[key])) {
          state.selected[key] = '';
        }
      }

      const get_response = await axios.get(`/api/application/${account_id.value}`);
      console.log("[Check get Application]",get_response.data);
      application_data.info = get_response.data;

      // state.selected에 API 응답 데이터를 저장합니다
      for (let key in application_data.info) {
        application_data.selected[key] = application_data.info[key];
      }
      console.log("[Check Selected]",application_data.selected);
      console.log("[loantype]",application_data.info['loanType'])
      console.log("[selected]",application_data.selected['loanType'])


    });

    const submitData = async () => {
      try {
        const put_response = await axios.put(`/api/application/${account_id.value}`,application_data.selected);
        console.log(put_response.data);
        await router.push({path: "/application"});
        // 데이터 전송 성공에 대한 처리를 이곳에 작성합니다.
      } catch (error) {
        console.error(error);
        // 데이터 전송 실패에 대한 처리를 이곳에 작성합니다.
      }
    };

    const submitJudgment = async () => {
      try {
        const responseJudgment = await axios.post('/api/judgment', {accountId: account_id.value});
        console.log("[Judgment AccountId STATE INFO]", responseJudgment.data);
        await router.push({path: "/judgment"});
        location.reload();
      } catch (error) {
        console.error(error);
      }
    };


    return { state, application_data,submitData, submitJudgment };
  }
};

</script>



<style scoped>
.bg-register-image {
  background-image: url('@/assets/car1.jpg');
  background-size: cover;  /* 이미지 크기를 조절합니다 */
  background-repeat: no-repeat;  /* 이미지가 반복되지 않도록 합니다 */
  background-position: center;  /* 이미지를 중앙에 위치시킵니다 */
}

.btn-group{
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap:20px;
  margin:auto;
}

</style>