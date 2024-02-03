
<template>
  <div class="d-flex justify-content-center align-items-center" style="height: 80vh;">
  <div class="form-signin w-100 m-auto">
    <h3 class="display-10 fw-bold text-center">Create Your Account</h3>
    <h4 class="display-10 fw-normal text-muted mb-5 text-center">회원 가입</h4>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput"
             @keyup.enter="submit()" v-model="account.accountId">
      <label for="floatingInput">Id</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingInput" placeholder="Password" @keyup.enter="submit()" v-model="account.password">
      <label for="floatingInput">Password</label>
    </div>
    <div class="form-floating">
      <input type="email" class="form-control" id="floatingInput" placeholder="Email" @keyup.enter="submit()" v-model="account.email">
      <label for="floatingInput">Email</label>
    </div>
    <div>
      <select v-model="account.role">
        <option disabled value="">Please select a role</option>
        <option>USER</option>
        <option>ADMIN</option>
      </select>
    </div>
    <button class="w-100 btn btn-lg btn-primary" @click="submitForm">Sign in</button>
  </div>
  </div>



</template>

<script>
import axios from 'axios';
import router from "@/scripts/router";
// import store from "@/scripts/store";

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
        console.log("[Check]",this.account);
        const response = await axios.post('/api/sign', this.account);
        console.log("[Response]",response.data);
        await router.push({path: "/login"});
        // 성공적으로 응답을 받았을 때의 처리를 여기에 작성하세요.
      } catch (error) {
        console.error(error);
        // 오류가 발생했을 때의 처리를 여기에 작성하세요.
      }
    }
  }
};
</script>


<style scoped>

.form-signin {
  max-width: 330px;
  padding: 15px;
}

.form-signin .form-floating:focus-within {
  z-index: 2
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}


</style>