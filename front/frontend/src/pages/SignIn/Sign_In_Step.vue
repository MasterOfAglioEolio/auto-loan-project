
<template>
  <div class="d-flex justify-content-center align-items-center" style="height: 80vh;">
    <div class="form-signin w-100 m-auto">
      <h1 class="display-5 fw-bold text-center">회원 가입</h1>
      <h2 class="display-7 fw-normal text-muted text-center">Create Your Account</h2>
      <h2 class="fw-bold mb-5">{{state.step}}/3</h2>
      <div class="form-floating" v-if="state.step === 1">
        <input type="text" class="form-control" id="floatingInput"
               @keyup.enter="submit()" v-model="account.accountId" required>
        <label for="floatingInput">Id</label>
      </div>
      <div class="form-floating" v-if="state.step === 2">
        <input type="password" class="form-control" id="floatingInput" placeholder="Password" @keyup.enter="submit()" v-model="account.password" required>
        <label for="floatingInput">Password</label>
      </div>
      <div class="form-floating" v-if="state.step === 3">
        <input type="email" class="form-control" id="floatingInput" placeholder="Email" @keyup.enter="submit()" v-model="account.email" required>
        <label for="floatingInput">Email</label>
      </div>
      <!--    <div>-->
      <!--      <select v-model="account.role">-->
      <!--        <option disabled value="">Please select a role</option>-->
      <!--        <option>USER</option>-->
      <!--        <option>ADMIN</option>-->
      <!--      </select>-->
      <!--    </div>-->
      <div class="btn-group">
        <button class="btn btn-primary btn-lg" type="button" v-if="state.step > 1" @click="state.step--">
          Prev
        </button>
        <button class="btn btn-primary btn-lg" type="button" v-if="state.step <=2" @click="state.step++">
          Next
        </button>
        <button class="w-100 btn btn-lg btn-primary" @click="submitForm" v-if="state.step === 3">Sign In</button>
      </div>
    </div>
  </div>



</template>

<script>
import axios from 'axios';
import router from "@/scripts/router";
import store from "@/scripts/store";
import {reactive} from "vue";

export default {
  computed: {
    store() {
      return store
    }
  },
  setup() {
    const state = reactive({
      step: 1
    })
    return {state}
  },


  data() {
    return {
      account: {
        accountId: '',
        password: '',
        email: '',
        role: 'USER'
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
        window.alert("회원가입이 완료되었습니다 로그인해주세요.");
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
.form-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 80vh;
}
.form-floating{
  margin-top: 30px;
  margin-bottom:30px;
}

.form-signin {
  max-width: 400px;
  padding: 15px;
  background-color: white; /* 로그인 폼 배경 색상 */
  border-radius: 8px;
  box-shadow: 0 0 20px gainsboro;
  width: 100%;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="text"],
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

.form-signin button {
  width: 100%;
  padding: 12px;
  background-color: #4267B2;
  border: none;
  border-radius: 8px;
  color: white;
  font-size: 16px;
  cursor: pointer;
}

.form-signin button:hover {
  background-color: #365899;
}

.form-signin p {
  margin-top: 15px;
  font-size: 14px;
}

.form-signin p b {
  color: #4267B2;
  cursor: pointer;
}
.btn-group{
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap:20px;
  margin:auto;
}
</style>