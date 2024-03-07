<template>
  <div class="order">
    <div class="container">
      <main>
        <div class="py-5 text-center"><h2>대출 신청</h2></div>
        <div class="row g-5">
          <div class="col-md-5 col-lg-4 order-md-last"><h4
              class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-primary">대출 신청 목록</span>
            <span
                class="badge bg-primary rounded-pill">
              {{ state.items.length }}
            </span></h4>
            <ul class="list-group mb-3">
              <li class="list-group-item d-flex justify-content-between lh-sm" v-for="(i, idx) in state.items"
                  :key="idx">
                <div>
                  <h6 class="my-0">{{ i.name }}</h6>
                </div>
                <span class="text-muted">
                  {{ lib.getNumberFormatted(i.price) }}원
                </span>
              </li>
            </ul>
            <h3 class="text-center total-price">
              {{ lib.getNumberFormatted(computedPrice) }}원
            </h3>
          </div>
          <div class="col-md-7 col-lg-8"><h4 class="mb-3">주문자 정보</h4>
            <div class="needs-validation" novalidate="">
              <div class="form-group row my-5">
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <label for="name" class="form-label fw-bold">Name</label>
                  <input type="text" class="form-control form-control-user" id="name" name="name" v-model="application_data.selected['name']" readonly>
                </div>
                <div class="col-sm-6">
                  <label for="cellPhone" class="form-label fw-bold">Cell Phone</label>
                  <input type="text" class="form-control form-control-user" id="cellPhone" name="cellPhone" v-model="application_data.selected['cellPhone']" required>
                </div>
              </div>
              <div class="form-group row my-5">
                <div class="col-sm-6">
                  <label for="carPrice" class="form-label fw-bold">Car Price</label>
                  <input type="number" class="form-control form-control-user" id="carPrice" name="carPrice" v-model=computedPrice readonly>
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
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <label for="interestRate" class="form-label fw-bold">Interest Rate</label>
                  <input type="number" class="form-control form-control-user" id="interestRate" name="interestRate" v-model="judgment_data.info['interestRate']" readonly>
                </div>
              </div>
              <hr class="my-4">
              <button class="w-100 btn btn-primary btn-lg" @click="submit()">대출 신청하기</button>
            </div>
          </div>
        </div>
      </main>
    </div>
  </div>
</template>

<script>
import {computed, onMounted, reactive} from "vue";
import axios from "axios";
import lib from "@/scripts/lib";
import router from "@/scripts/router";
import store from "@/scripts/store";

export default {
  setup() {
    const state = reactive({
      items: [],
      info:{},
      selected: {}
    })

    const application_data = reactive({
      info:{},
      selected: {}
    })

    const judgment_data=reactive({
      info:{}
    })

    const account_id = store.state.accountId.id;


    const load = () => {
      axios.get("/api/cart/items").then(({data}) => {
        console.log(data);
        state.items = data;
      })
    };

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

      const get_judgment = await axios.get(`/api/judgment/${account_id.value}`);
      console.log("[Check get Judgment]",get_judgment.data);
      judgment_data.info=get_judgment.data;
      console.log("[InfoValue]", judgment_data.info);
      console.log("[Judgment STATE INFO]", judgment_data.info['judgment'], judgment_data.info['interestRate']);
    });


    const submit = () => {
      // const args = JSON.parse(JSON.stringify(state.form));
      const args={
        items: JSON.stringify(state.items),
        carPrice: computedPrice.value,
        ...application_data.selected,
        ...judgment_data.info
      };

      console.log("[args]",args);
      args.items = JSON.stringify(state.items);

      axios.post("/api/contract", args).then(() => {
        alert('대출 신청하였습니다.');
        router.push({path: "/contract-check"})
      })


    }

    const computedPrice = computed(() => {
      let result = 0;

      for (let i of state.items) {
        result += i.price;
      }

      return result;
    })

    load();

    return {state, lib, application_data,judgment_data, computedPrice, submit}
  }
}
</script>

<style scoped>
</style>