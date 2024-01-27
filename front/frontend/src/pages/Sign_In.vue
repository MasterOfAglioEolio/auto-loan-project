아래는 Vue.js에서 사용할 수 있는 axios.post 예제입니다. 이 예제는 위에서 제공한 Account 엔티티를 서버에 POST 요청하는 방법을 보여줍니다.

vue
<template>
  <div>
    <input v-model="account.accountId" placeholder="account id">
    <input v-model="account.password" placeholder="password">
    <input v-model="account.email" placeholder="email">
    <select v-model="account.role">
      <option disabled value="">Please select a role</option>
      <option>User</option>
      <option>Admin</option>
    </select>
    <button @click="submitForm">Submit</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      account: {
        accountId: '',
        password: '',
        email: '',
        role: ''
      }
    };
  },
  methods: {
    async submitForm() {
      try {
        console.log("[Check]",this.data);
        const response = await axios.post('/api/sign', this.account);
        console.log(response.data);
        // 성공적으로 응답을 받았을 때의 처리를 여기에 작성하세요.
      } catch (error) {
        console.error(error);
        // 오류가 발생했을 때의 처리를 여기에 작성하세요.
      }
    }
  }
};
</script>