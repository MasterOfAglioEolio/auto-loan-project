<template>

  <div class="container">
    <div class="card o-hidden border-0 shadow-lg my-5 align-items-center">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
<!--          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>-->
          <div class="col-lg-auto d-flex justify-content-center align-items-center" style="height: 70vh;">
            <div class="p-5 ">
              <div class="text-center">
                <h3 class="display-6 fw-bold">Register Your Information!</h3>
                <h5 class="fw-normal text-muted mb-5">정보를 입력해주세요!! </h5>
                <h6 class="fw-bold mb-5">{{state.step}}/{{Object.keys(state.info).length-2}}</h6>
              </div>
              <form class="user" @submit.prevent="submitData">
<!--                <template v-for="(values, key, index) in state.info">-->
<!--                  <div class="form-group row my-5" :key="key" v-if="state.step === index + 1">-->
<!--                    <div class="col-sm-12">-->
<!--                      <label :for="key" class="form-label fw-bold">{{ key }}</label>-->
<!--                      <select class="form-select" :id="key" v-model="state.selected[key]" required @change="state.step++" v-if="Array.isArray(values)">-->
<!--                        <option disabled value="">Please select a {{ key }}</option>-->
<!--                        <option v-for="value in values" :key="value" :value="value">{{ value }}</option>-->
<!--                      </select>-->
<!--                      <input type="number" class="form-control form-control-user" :id="key" :name="key" v-model="state.selected[key]" required @input="state.step++" v-else>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </template>-->
                <div class="form-group row my-5" v-if="state.step === 1">
                  <div class="col-sm-12">
                    <label for="gender" class="form-label fw-bold">Gender</label>
                    <select class="form-select" id="gender" v-model="state.selected['gender']" required>
                      <option disabled value="">Please select a gender</option>
                      <option v-for="value in state.info['gender']" :key="value" :value="value">{{ value }}</option>
                    </select>
                  </div>
                </div>
                <div class="form-group row my-5" v-if="state.step === 2">
                  <div class="col-sm-12">
                    <label for="age" class="form-label fw-bold">age</label>
                    <input type="number" class="form-control form-control-user" id="age" name="age" v-model="state.selected['age']" required>
                  </div>
                </div>
                <div class="form-group row my-5">
                  <div class="col-sm-6 mb-3 mb-sm-0" v-if="state.step === 3">
                    <label for="education" class="form-label fw-bold" >Education</label>
                    <select class="form-select" id="education" v-model="state.selected['education']" required>
                      <option disabled value="">Please select an education</option>
                      <option v-for="value in state.info['education']" :key="value" :value="value">{{ value }}</option>
                    </select>
                  </div>
                  <div class="col-sm-6" v-if="state.step === 4">
                    <label for="maritalStatus" class="form-label fw-bold">Marital Status</label>
                    <select class="form-select" id="maritalStatus" v-model="state.selected['maritalStatus']" required>
                      <option disabled value="">Please select a marital status</option>
                      <option v-for="value in state.info['maritalStatus']" :key="value" :value="value">{{ value }}</option>
                    </select>
                  </div>
                </div>
                <div class="form-group row my-5" >
                  <div class="col-sm-6 mb-3 mb-sm-0" v-if="state.step === 5">
                    <label for="familyCount" class="form-label fw-bold">Family Count</label>
                    <input type="number" class="form-control form-control-user" id="familyCount" v-model="state.selected['familyCount']" required>
                  </div>
                  <div class="col-sm-6" v-if="state.step === 6">
                    <label for="ChildCount" class="form-label fw-bold">Child Count</label>
                    <input type="number" class="form-control form-control-user" id="ChildCount" v-model="state.selected['childCount']" required>
                  </div>
                </div>

                <div class="form-group my-5" v-if="state.step === 7">
                  <label for="incomeType" class="form-label fw-bold">Income Type</label>
                  <select class="form-select" id="incomeType" v-model="state.selected['incomeType']" required>
                    <option disabled value="">Please select an income type</option>
                    <option v-for="type in state.info['incomeType']" :key="type" :value="type">{{ type }}</option>
                  </select>
                </div>
                <div class="form-group my-5" v-if="state.step === 8">
                  <label for="incomeClass" class="form-label fw-bold">Income Class</label>
                  <select class="form-select" id="incomeClass" v-model="state.selected['incomeClass']" required>
                    <option disabled value="">Please select an income class</option>
                    <option v-for="incomeclass in state.info['incomeClass']" :key="incomeclass" :value="incomeclass">{{ incomeclass }}</option>
                  </select>
                </div>
                <div class="form-group my-5" v-if="state.step === 9">
                  <label for="occupation" class="form-label fw-bold">Occupation</label>
                  <select class="form-select" id="occupation" v-model="state.selected['occupation']" required>
                    <option disabled value="">Please select an occupation</option>
                    <option v-for="occup in state.info['occupation']" :key="occup" :value="occup">{{ occup }}</option>
                  </select>
                </div>
                <div class="form-group my-5" v-if="state.step === 10">
                  <label for="orgType" class="form-label fw-bold">Org Type</label>
                  <select class="form-select" id="orgType" v-model="state.selected['orgType']" required >
                    <option disabled value="">Please select an org type</option>
                    <option v-for="type in state.info['orgType']" :key="type" :value="type">{{ type }}</option>
                  </select>
                </div>
                <div class="form-group my-5" v-if="state.step === 11">
                  <label for="employedYears" class="form-label fw-bold">Employed Years</label>
                  <input type="number" class="form-control form-control-user" id="employedYears" v-model="state.selected['employedYears']" placeholder="Leave blank if not applicable" >
                </div>
                <div class="form-group my-5" v-if="state.step === 12">
                  <label for="houseOwnedYN" class="form-label fw-bold">House Own Y/N</label>
                  <select class="form-select" id="houseOwnedYN" v-model="state.selected['houseOwnedYN']" required>
                    <option disabled value="">Please select an option</option>
                    <option v-for="option in state.info['houseOwnedYN']" :key="option" :value="option">{{ option }}</option>
                  </select>
                </div>
                <div class="form-group my-5" v-if="state.step === 13">
                  <label for="dwellingType" class="form-label fw-bold">Dwelling Type</label>
                  <select class="form-select" id="dwellingType" v-model="state.selected['dwellingType']" required>
                    <option disabled value="">Please select a dwelling type</option>
                    <option v-for="type in state.info['dwellingType']" :key="type" :value="type">{{ type }}</option>
                  </select>
                </div>
                <div class="form-group my-5" v-if="state.step === 14">
                  <label for="housingType" class="form-label fw-bold">Housing Type</label>
                  <select class="form-select" id="housingType" v-model="state.selected['housingType']" required>
                    <option disabled value="">Please select a housing type</option>
                    <option v-for="type in state.info['housingType']" :key="type" :value="type">{{ type }}</option>
                  </select>
                </div>
                <div class="form-group my-5" v-if="state.step === 15">
                  <label for="residenceClass" class="form-label fw-bold">Residence Class</label>
                  <select class="form-select" id="residenceClass" v-model="state.selected['residenceClass']" required>
                    <option disabled value="">Please select a residence class</option>
                    <option v-for="residenceClass in state.info['residenceClass']" :key="residenceClass" :value="residenceClass">{{ residenceClass }}</option>
                  </select>
                </div>
                <div class="form-group my-5" v-if="state.step === 16">
                  <label for="carOwnedYN" class="form-label fw-bold">Car Owned Y/N</label>
                  <select class="form-select" id="carOwnedYN" v-model="state.selected['carOwnedYN']" required>
                    <option disabled value="">Please select an option</option>
                    <option v-for="option in state.info['carOwnedYN']" :key="option" :value="option">{{ option }}</option>
                  </select>
                </div>
                <button class="btn btn-primary btn-lg" type="button" v-if="state.step < Object.keys(state.info).length-2" @click="state.step++">
                  Next
                </button>

                <button class="btn btn-primary btn-lg" type="submit" v-if="state.step === Object.keys(state.info).length-2">
                  Register Information
                </button>

              </form>
            </div>
          </div>
        </div>
      </div>

    </div>

  </div>
</template>

<script>

// import {reactive} from "vue";
import axios from "axios";
import {onMounted, reactive} from "vue";
import router from "@/scripts/router";

export default {
  name:"info",
  setup(){
    const state = reactive({
      info:{},
      selected: {},
      step:1
    })

    onMounted(async () => {
      const response = await axios.get("/api/info");
      state.info = response.data;
      console.log("[STATE INFO]",state.info);
      console.log("[STATE STEP]",state.step);

      for (let key in state.info) {
        if (Array.isArray(state.info[key])) {
          state.selected[key] = '';
        }
      }

    });

    const submitData = async () => {
      try {
        const response = await axios.post('/api/info/register', state.selected);
        console.log(response.data);
        await router.push({path: "/"});
        // 데이터 전송 성공에 대한 처리를 이곳에 작성합니다.
        state.step = 1;  // 모든 정보를 입력한 후에는 step을 다시 1로 초기화합니다.
      } catch (error) {
        console.error(error);
        // 데이터 전송 실패에 대한 처리를 이곳에 작성합니다.
      }
    };


    return { state, submitData };
  }
};

</script>

<style scoped>
.bg-register-image {
  background-image: url('@/assets/car3.jpg');
  background-size: cover;  /* 이미지 크기를 조절합니다 */
  background-repeat: no-repeat;  /* 이미지가 반복되지 않도록 합니다 */
  background-position: center;  /* 이미지를 중앙에 위치시킵니다 */
}

</style>