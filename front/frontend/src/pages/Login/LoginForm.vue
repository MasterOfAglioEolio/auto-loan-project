<template>
  <div class="d-flex justify-content-center align-items-center" style="height: 70vh;">
    <div class="form-signin w-100 m-auto">
      <h1 class="display-10 fw-bold text-center">Please Login</h1>
      <h2 class="display-10 fw-normal text-muted text-center">로그인</h2>
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingInput"
               @keyup.enter="submit()" v-model="state.form.account_id" placeholder="Id">
        <label for="floatingInput">Id</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password" @keyup.enter="submit()" v-model="state.form.password">
        <label for="floatingPassword">Password</label>
      </div>
      <button class="w-100 btn btn-lg btn-primary" @click="submit()">Log in</button>
    </div>
  </div>
</template>

<script>
import {reactive} from "vue";
import axios from "axios";
import store from "@/scripts/store";
import router from "@/scripts/router";


export default {
  computed: {
    store() {
      return store
    }
  },
  setup() {
    const state = reactive({
      form: {
        account_id: "",
        password: ""
      }
    })

    const submit = () => {
      axios.post("/api/login", state.form).then((res) => {
        sessionStorage.setItem("id", res.data);
        store.commit('setAccount',res.data);
        router.push({path: "/"});
        window.alert("로그인하였습니다.");
      }).catch(() => {
        window.alert("로그인 정보가 존재하지 않습니다..");
      });
    }

    return {state, submit}
  }
}
</script>

<style scoped>
.form-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 80vh;
}

.form-signin {
  max-width: 350px;
  //max-height: 350px;
  padding: 15px;
  background-color: white; /* 로그인 폼 배경 색상 */
  border-radius: 8px;
  box-shadow: 0 0 20px gainsboro;
  width: 100%;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="text"] {
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
</style>