<template>
  <header nav ref="navbar" class="navbar navbar-dark navbar-expand-md bg-primary sticky-top border-bottom bg-transparent">
    <div class="container">
        <div class="offcanvas-body">
          <ul class="navbar-nav flex-grow-1 justify-content-between fw-bold">
            <li class="nav-item"><a class="nav-link" href="#">
              <svg class="bi" width="24" height="24"><use xlink:href="#aperture"/></svg>
            </a></li>
              <li class="nav-item">
                <router-link to ="/" class="nav-link text-dark"> 메인 (이미지로 바꾸기)</router-link>
              </li>
              <li class="nav-item">
                <router-link to ="/" class="nav-link text-dark"> 공지 </router-link>
              </li>
              <li class="nav-item">
                <router-link to ="/sign" class="nav-link text-dark" v-if="!$store.state.account.id"> 회원 가입 </router-link>
              </li>
              <li class="nav-item">
                <router-link to ="/login" class="nav-link text-dark" v-if="!$store.state.account.id"> 로그인 </router-link>
                <a to ="/login" class="nav-link" @click="logout()" v-else> 로그아웃 </a>
              </li>
              <li class="nav-item">
                <router-link to ="/info" class="nav-link text-dark"> 회원 정보 입력 </router-link>
              </li>
              <li class="nav-item">
                <router-link to ="/application" class="nav-link text-dark"> 심사 신청 </router-link>
              </li>
              <li class="nav-item">
                <router-link to ="/judgment" class="nav-link text-dark"> 심사 </router-link>
              </li>
          </ul>
        </div>
      </div>
  </header>
</template>

<script>
import store from "@/scripts/store";
import router from "@/scripts/router";
import {onMounted, onUnmounted, ref} from "vue";

export default {
  name: 'Header',
  setup(){
    const logout=()=>{
      store.commit('setAccount',0);
      sessionStorage.removeItem("id");
      router.push({path:"/"});
    }

    const navbar = ref(null);
    const handleScroll = () => {
      if (window.pageYOffset > 50) {
        navbar.value.classList.remove('bg-transparent');
        navbar.value.classList.add('bg-primary');
      } else {
        navbar.value.classList.remove('bg-primary');
        navbar.value.classList.add('bg-transparent');
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


</style>

