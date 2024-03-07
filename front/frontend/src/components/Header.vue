<template>
  <div class="headerInner mt-3 mb-3">
    <h1><router-link to="/" class="nav-link"><img :src="require(`@/assets/EALC_BANNER.png`)" alt="홈 배너 이미지" class="banner-image"></router-link></h1>
    <!-- 큰글 모드 영역 -->
    <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
      <input type="radio" class="btn-check" name="btn_radio" id="btn_radio1" @change="setFontSize(0)" autocomplete="off" checked>
      <label class="btn btn-outline-primary fw-bold " for="btn_radio1">기본 모드</label>

      <input type="radio" class="btn-check" name="btn_radio" id="btn_radio2" @change="setFontSize(1)" autocomplete="off">
      <label class="btn btn-outline-primary fw-bold" for="btn_radio2">큰글 모드</label>
    </div>
  </div>
  <header nav ref="navbar" :class="{'navbar': true, 'navbar-expand-md': true, 'mx-auto': true,
   'navbar-light': true, 'bg-light': true, 'sticky-top': true, 'border-bottom':true,'bg-transparent': true, 'large-font': store.state.large_Mode.check === 1}">
    <div class="container-fluid">
      <ul class="navbar-nav flex-grow-1 fw-bold">
        <li class="nav-item">
          <router-link to="/" class="nav-link">Home</router-link>
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
            커뮤니티
          </a>
          <ul class="dropdown-menu bg-transparent border-0" aria-labelledby="navbarDropdown">
            <li><router-link to="/question/list" class="dropdown-item">Q&A</router-link></li>
            <li><router-link to="/board/list" class="dropdown-item">공지사항</router-link></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            심사 정보 입력
          </a>
          <ul class="dropdown-menu bg-transparent border-0" aria-labelledby="navbarDropdown">
            <li><router-link to ="/info" class="dropdown-item"> 회원 정보 입력 </router-link></li>
            <li><router-link to ="/application" class="dropdown-item"> 심사 신청 </router-link></li>
            <li><router-link to ="/judgment" class="dropdown-item"> 심사 결과 확인 </router-link></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            자동차 구매
          </a>
          <ul class="dropdown-menu bg-transparent border-0" aria-labelledby="navbarDropdown">
            <li><router-link to ="/car-list" class="dropdown-item"> 자동차 리스트 </router-link></li>
            <li><router-link to ="/cart" class="dropdown-item"> 위시 리스트 </router-link></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            대출 관리
          </a>
          <ul class="dropdown-menu bg-transparent border-0" aria-labelledby="navbarDropdown">
          <li><router-link to ="/contract" class="dropdown-item"> 계약서 작성 </router-link></li>
          <li><router-link to ="/contract-check" class="dropdown-item"> 계약 확인 </router-link></li>
          <li><router-link to ="/repayment" class="dropdown-item"> 대출금 상환 </router-link></li>
          <li><router-link to ="/repayment-history" class="dropdown-item"> 대출금 상환 내역 </router-link></li>
          </ul>
        </li>
      </ul>
    </div>

  </header>
</template>

<script>
import store from "@/scripts/store";
import router from "@/scripts/router";
import {onMounted, onUnmounted, ref} from "vue";
import axios from "axios";
// import "@/assets/common.css";

export default {
  name: 'Header',
  computed: {
    store() {
      return store
    }
  },
  methods:{
    setFontSize(size) {
      if (size === 0) {
        store.commit('setLargeMode', 0);  // 기본 폰트 사이즈
        console.log("[Set SIZE 0]",store.state.large_Mode)
      } else if (size === 1) {
        store.commit('setLargeMode', 1);  // 큰 폰트 사이즈
        console.log("[Set SIZE 1]",store.state.large_Mode)
      }
    }
  },
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
            router.push({ path: "/" }).then(() => {
              // 페이지 새로고침
              location.reload();
            });
          })
          .catch(err => {
            // 에러 처리
            console.error(err);
          });

    }

    const navbar = ref(null);
    const handleScroll = () => {
      if (window.pageYOffset > 50) {
        navbar.value.classList.remove('bg-white');
        navbar.value.classList.add('bg-transparent');
      } else {
        navbar.value.classList.remove('bg-transparent');
        navbar.value.classList.add('bg-white');
      }
    };
    onMounted(() => {
      window.addEventListener('scroll', handleScroll);
    });
    onUnmounted(() => {
      window.removeEventListener('scroll', handleScroll);
    });

    return { logout, navbar};
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
.banner-image {
  width: 100px;
  height: auto;
}
.headerInner {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin:auto

}
.nav-item{
  margin:auto
}

.headerInner,
.navbar {

  width: 100%;
  max-width: 1500px;
}

@media (max-width: 768px) {
  .headerInner,
  .navbar {
    max-width: 100%;
  }
  .nav-item {
    margin-left: 1em;
    margin-right: 1em;
  }
}

.navbar .dropdown-menu{
  overflow: visible;
  position: static;
}


.dropdown-item {
  margin: 10px 0;  /* 위아래 마진을 10px로 설정 */
}


</style>

