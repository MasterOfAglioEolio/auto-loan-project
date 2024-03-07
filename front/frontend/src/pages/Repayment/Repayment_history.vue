<template>
  <div class="orders">
    <div class="container">
      <table class="table table-bordered">
        <thead>
        <tr>
          <th>상환 번호</th>
          <th>신청 번호</th>
          <th>대출 ID</th>
          <th>기존 대출 금액</th>
          <th>대출 상환 금액</th>
          <th>이후 대출 금액</th>
          <th>상환 일시</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(repayment, idx1) in state.repayments" :key="idx1">

          <td>{{ repayment.repaymentId }}</td>
          <td>{{ repayment.applicationId }}</td>
          <td>{{ repayment.accountId }}</td>
          <td>{{ repayment.balance }}</td>
          <td>{{ repayment.repaymentAmount }}</td>
          <td>{{ repayment.afterRepaymentAmount }}</td>
          <td>{{ repayment.updatedAt }}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import {reactive} from "vue";
import axios from "axios";
import lib from "@/scripts/lib";
import store from "@/scripts/store";

export default {
  setup() {
    const state = reactive({
      repayments: [],
    })

    const application_id = store.state.applicationId.id;

    axios.get(`/api/contract/${application_id}/repayments`).then(({data}) => {
      state.repayments = [];
      console.log("[check data]",data);

      for (let d of data) {
        if (d.items) {
          d.items = JSON.parse(d.items);
          console.log("d22",d.items);
        }
        console.log("d",d.items);

        state.repayments.push(d);
      }
      console.log("repayemnts",state.repayments);


    })
    return {state, lib}
  }
}
</script>

<style scoped>
.table {
  margin-top: 30px;
}

.table > tbody {
  border-top: 1px solid #eee;
}
</style>