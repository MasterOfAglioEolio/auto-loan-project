<template>
  <header nav ref="navbar" class="navbar navbar-expand-md navbar-light bg-light sticky-top bg-transparent"
  >
      <div class="container-fluid">
<!--        <div class="offcanvas-body">-->
        <ul class="navbar-nav flex-grow-1 justify-content-start fw-bold">
          <li class="nav-item">
            <router-link to="/" class="nav-link">Home</router-link>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              커뮤니티
            </a>
            <ul class="dropdown-menu bg-transparent border-0" aria-labelledby="navbarDropdown">
              <li><router-link to="/question/list" class="dropdown-item">Q&A</router-link></li>
              <li><router-link to="/board/list" class="dropdown-item">공지사항</router-link></li>
            </ul>
          </li>
          <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            회원
          </a>
            <ul class="dropdown-menu bg-transparent border-0" aria-labelledby="navbarDropdown">
            <li><router-link to ="/sign" class="dropdown-item" v-if="!$store.state.account.id"> 회원 가입 </router-link></li>
            <li>
              <router-link to ="/login" class="dropdown-item" v-if="!$store.state.account.id"> 로그인 </router-link>
              <a to ="/login" class="nav-link" @click="logout()" v-else> 로그아웃 </a>
            </li>
            </ul>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              심사 정보 입력
            </a>
            <ul class="dropdown-menu bg-transparent border-0" aria-labelledby="navbarDropdown">
            <li><router-link to ="/info" class="dropdown-item"> 회원 정보 입력 </router-link></li>
            <li><router-link to ="/application" class="dropdown-item"> 심사 신청 </router-link></li>
            </ul>
          </li>
          <li class="nav-item">
            <router-link to ="/judgment" class="nav-link"> 심사 </router-link>
          </li>
        </ul>

<!--      </div>-->
      </div>
  </header>
</template>

<script>
import store from "@/scripts/store";
import router from "@/scripts/router";
import {onMounted, onUnmounted, ref} from "vue";
import axios from "axios";

export default {
  name: 'Header',
  setup(){
    const logout=()=>{
      store.commit('setAccount',0);
      store.commit('setAccountId','');
      store.commit('setInfo',0);
      store.commit('setApplication',0);
      sessionStorage.removeItem("id");
      sessionStorage.clear();

      // 서버에 로그아웃 요청 보내기
      axios.post('/api/logout')
          .then(() => {
            // 로그아웃 성공 시, 홈 페이지로 이동
            router.push({ path: "/" });
            location.reload();
          })
          .catch(err => {
            // 에러 처리
            console.error(err);
          });

    }

    const navbar = ref(null);
    const handleScroll = () => {
      if (window.pageYOffset > 50) {
        navbar.value.classList.remove('bg-light');
        navbar.value.classList.add('bg-transparent');
      } else {
        navbar.value.classList.remove('bg-transparent');
        navbar.value.classList.add('bg-light');
      }
    };
    onMounted(() => {
      window.addEventListener('scroll', handleScroll);
    });
    onUnmounted(() => {
      window.removeEventListener('scroll', handleScroll);
    });

    return {logout, navbar};
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>


#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
.nav-item {
  margin-left: 20px;  /* 왼쪽 마진을 20px로 설정 */
  margin-right: 20px;  /* 오른쪽 마진을 20px로 설정 */
}

.navbar .dropdown-menu{
  overflow: visible;
  position: static;
}
nav .navbar-nav a.router-link-exact-active {
  color: #42b983 !important;
}

nav .navbar-nav a.nav-link {
  font-weight: bold;
  color: #2c3e50 !important;
}

.dropdown-item {
  margin: 10px 0;  /* 위아래 마진을 10px로 설정 */
}


</style>

