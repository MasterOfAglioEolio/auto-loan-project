<template>
  <div class="order">
    <div class="container">
      <main>
        <div class="py-5 text-center"><h2>대출 상환</h2></div>
        <form class="application" @submit.prevent="submitData">
        <div class="row g-5">
          <div class="col-md-5 col-lg-4 order-md-last"><h4
              class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-primary">대출 상환 내역</span>
            <span
                class="badge bg-primary rounded-pill">
              {{ state.repayments.length }}
            </span></h4>
            <ul class="list-group mb-3">
              <li class="list-group-item d-flex justify-content-between lh-sm" v-for="(i, idx) in state.repayments"
                  :key="idx">
                <div>
                  <h6 class="my-0">{{ i.updatedAt }}</h6>
                </div>
                <span class="text-muted">
                  {{i.repaymentAmount}}
                </span>
              </li>
            </ul>
            <h3 class="text-center total-price">
              남은 대출 상환 금액 : {{repayment_data.info['balance']}} 원
            </h3>

          </div>

          <div class="col-md-7 col-lg-8"><h4 class="mb-3">주문자 정보</h4>
            <div class="needs-validation" novalidate="">
              <div class="form-group row my-5">
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <label for="repaymentAmount" class="form-label fw-bold">Repayment Amount</label>
<!--                  <input type="number" class="form-control form-control-user" id="repaymentAmount" name="repaymentAmount" v-model="state.info['repaymentAmount']" readonly>-->
                  <input type="number" class="form-control form-control-user" id="repaymentAmount" name="repaymentAmount" required>
                </div>
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <label for="balance" class="form-label fw-bold">balance</label>
                  <input type="number" class="form-control form-control-user" id="balance" name="balance" v-model="repayment_data.info['balance']" readonly>
                  <!--                <input type="number" class="form-control form-control-user" id="balance" name="balance" required>-->
                </div>

              </div>
              <div class="form-group row my-5">
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <label for="beforeAmount" class="form-label fw-bold">Before Amount</label>
                  <input type="number" class="form-control form-control-user" id="beforeAmount" name="beforeAmount" v-model="repayment_data.info['beforeAmount']" readonly>
<!--                  <input type="number" class="form-control form-control-user" id="beforeAmount" name="beforeAmount" required>-->
                </div>
                <div class="col-sm-6">
                  <label for="afterAmount" class="form-label fw-bold">After Amount</label>
                  <input type="number" class="form-control form-control-user" id="afterAmount" name="afterAmount" v-model="repayment_data.info['afterAmount']" readonly>
<!--                  <input type="number" class="form-control form-control-user" id="afterAmount" name="afterAmount" required>-->
                </div>
              </div>

<!--              <div class="form-group row my-5">-->
<!--                <div class="col-sm-6 mb-3 mb-sm-0">-->
<!--                  <label for="createdAt" class="form-label fw-bold">createdAt</label>-->
<!--                  <input type="datetime-local" class="form-control form-control-user" id="createdAt" name="createdAt" v-model="repayment_data.info['createdAt']" readonly>-->
<!--&lt;!&ndash;                  <input type="datetime-local" class="form-control form-control-user" id="createdAt" name="createdAt" required>&ndash;&gt;-->
<!--                </div>-->
<!--                <div class="col-sm-6">-->
<!--                  <label for="updatedAt" class="form-label fw-bold">updatedAt</label>-->
<!--                  <input type="datetime-local" class="form-control form-control-user" id="updatedAt" name="updatedAt" v-model="repayment_data.info['updatedAt']" readonly>-->
<!--&lt;!&ndash;                  <input type="datetime-local" class="form-control form-control-user" id="updatedAt" name="updatedAt" required>&ndash;&gt;-->
<!--                </div>-->
<!--              </div>-->
              <hr class="my-4">
              <button class="w-100 btn btn-primary btn-lg" @click="submit()">대출 상환하기</button>
            </div>
          </div>

        </div>
        </form>
      </main>
    </div>
  </div>
</template>

<script>
import {reactive} from "vue";
import axios from "axios";
import router from "@/scripts/router";
import store from "@/scripts/store";
import lib from "@/scripts/lib";


export default {
  setup() {
    const state = reactive({
      info: {},
      repayments:[]

    })

    const repayment_data = reactive({
      info: {}
    })

    const application_id = store.state.applicationId.id;


    const load_repayment = async() => {
      await axios.get(`/api/contract/${application_id}/repayment`).then(({data}) => {

        repayment_data.info = data;
        console.log("[Get repayment_data]",repayment_data.info);
        // console.log("[Get info name]",repayment_data.info['name']);

      })
    };
    load_repayment();

    const load_repayments = async () => {
      axios.get(`/api/contract/${application_id}/repayments`).then(({data}) => {
        state.repayments = [];
        console.log("[check data]", data);

        for (let d of data) {
          if (d.items) {
            d.items = JSON.parse(d.items);
            console.log("d22", d.items);
          }
          console.log("d", d.items);

          state.repayments.push(d);
        }
        console.log("repayemnts", state.repayments);
      })
    };
    load_repayments();





    const submitData = async() => {

      const args = state.info;

      console.log("[args]", args);
      console.log("[repayment_id]",repayment_data.info['repayment_id']);
      // args.items = JSON.stringify(state.items);

      await axios.post(`/api/contract/${application_id}/repayments`, args).then(() => {
        alert('대출을 상환하였습니다.');
        router.push({path: "/repayment-history"})
      })
    }
    return {state, repayment_data,lib,submitData}
  }
}
</script>

<style scoped>
</style>