<template>
  <div class="order">
    <div class="container">
      <main>
        <div class="py-5 text-center"><h2>대출 신청 정보</h2></div>
        <div class="row g-5">
          <div class="col-md-5 col-lg-4 order-md-last"><h4
              class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-primary">대출 신청 정보</span>
            <span
                class="badge bg-primary rounded-pill">
              {{ contract_data.info['items'].length }}
            </span></h4>

            <h6 class="my-0">{{ contract_data.info['items'].name }}</h6>

            <span class="text-muted">
              {{contract_data.info['items'].price }}원
            </span>

            <h3 class="text-center total-price">
              {{ lib.getNumberFormatted(computedPrice) }}원
            </h3>
          </div>
          <div class="col-md-7 col-lg-8"><h4 class="mb-3">주문자 정보</h4>
<!--            <div class="needs-validation" novalidate="">-->
              <div class="form-group row my-5">
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <label for="name" class="form-label fw-bold">Name</label>
                  <input type="text" class="form-control form-control-user" id="name" name="name" v-model="contract_data.info['name']" readonly>
                </div>
                <div class="col-sm-6">
                  <label for="cellPhone" class="form-label fw-bold">Cell Phone</label>
                  <input type="text" class="form-control form-control-user" id="cellPhone" name="cellPhone" v-model="contract_data.info['cellPhone']" readonly>
                </div>
              </div>
              <div class="form-group row my-5">
                <div class="col-sm-6">
                  <label for="carPrice" class="form-label fw-bold">Car Price</label>
                  <input type="number" class="form-control form-control-user" id="carPrice" name="carPrice" v-model="contract_data.info['carPrice']" readonly>
                </div>
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <label for="loanType" class="form-label fw-bold">Loan Type</label>
                  <input type="text" class="form-control form-control-user" id="loanType" name="loanType" v-model="contract_data.info['loanType']" readonly>
                </div>
              </div>
              <div class="form-group row my-5">
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <label for="deposit" class="form-label fw-bold">Deposit</label>
                  <select class="form-select" id="deposit" v-model="contract_data.info['deposit']" readonly>
                    <option disabled value="">Please select a deposit</option>
                    <option v-for="value in [0, 10, 20, 30]" :key="value" :value="value">{{ value }}</option>
                  </select>
                </div>
                <div class="col-sm-6">
                  <label for="loanTerm" class="form-label fw-bold">Loan Term</label>
                  <select class="form-select" id="loanTerm" v-model="contract_data.info['loanTerm']" readonly>
                    <option disabled value="">Please select a loan term</option>
                    <option v-for="value in [12, 24, 36, 48]" :key="value" :value="value">{{ value }}</option>
                  </select>
                </div>
              </div>
              <div class="form-group row my-5">
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <label for="interestType" class="form-label fw-bold">Interest Type</label>
                  <input type="text" class="form-control form-control-user" id="interestType" name="interestType" v-model="contract_data.info['interestType']" readonly>
                </div>
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <label for="interestRate" class="form-label fw-bold">Interest Rate</label>
                  <input type="number" class="form-control form-control-user" id="interestRate" name="interestRate" v-model="contract_data.info['interestRate']" readonly>
                </div>
              </div>
              <div class="form-group row my-5">
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <label for="appliedAt" class="form-label fw-bold">Applied Data</label>
                  <input type="datetime-local" class="form-control form-control-user" id="appliedAt" name="appliedAt" v-model="contract_data.info['appliedAt']" readonly>
                </div>
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <label for="interestRate" class="form-label fw-bold">Maturity</label>
                  <input type="datetime-local" class="form-control form-control-user" id="maturity" name="maturity" v-model="contract_data.info['maturity']" readonly>
                </div>
              </div>
              <div class="form-group row my-5">
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <label for="approvalAmount" class="form-label fw-bold">Approval Amount</label>
                  <input type="number" class="form-control form-control-user" id="approvalAmount" name="approvalAmount" v-model="contract_data.info['approvalAmount']" readonly>
                </div>
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <label for="contractedAt" class="form-label fw-bold">Interest Rate</label>
                  <input type="datetime-local" class="form-control form-control-user" id="contractedAt" name="contractedAt" v-model="contract_data.info['contractedAt']" readonly>
                </div>
              </div>
            <div class="form-group row my-5">
              <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="approvalAmount" class="form-label fw-bold">Approval Amount</label>
                <input type="number" class="form-control form-control-user" id="approvalAmount" name="approvalAmount" v-model="contract_data.info['approvalAmount']" readonly>
              </div>
            </div>
<!--            </div>-->
          </div>
        </div>
      </main>
    </div>
  </div>
</template>

<script>
import {computed, reactive} from "vue";
import axios from "axios";
import store from "@/scripts/store";
import lib from "@/scripts/lib";


export default {
  setup() {
    const contract_data = reactive({
      info: {}
    })

    let entry_data;

    const account_id = store.state.accountId.id;
    const application_id=store.state.applicationId.id;

    const load = async () => {
      await axios.get(`/api/contract/${account_id.value}`).then(({data}) => {

        contract_data.info = data;
        console.log("[Get info]",contract_data.info);
        console.log("[Get info name]",contract_data.info['name']);
        entry_data=reactive({
          entryAmount:contract_data.info['approvalAmount']

        })
        create_entry();
      })
    };

    const create_entry =() => {
      console.log("[application_id]",application_id);
      console.log("[entry1]",entry_data);
      try {
        const responseEntry =axios.post(`/api/contract/${application_id}/entries`, entry_data);
        console.log("[entry_data]",responseEntry);
      } catch (error) {
        console.error(error);
      }
    };


    const computedPrice = computed(() => {
      let result = 0;

      // result=(state.info['items'].price/state.info['loanTerm'])+(state.info['items'].price*state.info['interestRate'])/state.info['loanTerm']
      result=(contract_data.info['items'].price/contract_data.info['loanTerm'])+(contract_data.info['items'].price*(7.7*0.01))/contract_data.info['loanTerm']
      console.log("[result]",result);
      return result;
    })
    load();


    return {contract_data,lib,computedPrice}
  }
}
</script>

<style scoped>
</style>