<template>

  <div class="container">
    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h3 class="display-6 fw-bold">Your Information!</h3>
                <h5 class="fw-normal text-muted mb-5">정보를 확인해주세요!</h5>
              </div>
              <form class="user" @submit.prevent="submitData">
                <div class="form-group row my-5">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <label for="gender" class="form-label fw-bold">Gender</label>
                    <select class="form-select" id="gender" v-model="info_data.selected['gender']" required>
                      <option disabled value="">Please select a gender</option>
                      <option v-for="value in state.info['gender']" :key="value" :value="value">{{ value }}</option>
                    </select>
                  </div>
                  <div class="col-sm-6">
                    <label for="age" class="form-label fw-bold">age</label>
                    <input type="number" class="form-control form-control-user" id="age" name="age" v-model="info_data.selected['age']" required>
                  </div>
                </div>
                <div class="form-group row my-5">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <label for="education" class="form-label fw-bold">Education</label>
                    <select class="form-select" id="education" v-model="info_data.selected['education']" required>
                      <option disabled value="">Please select an education</option>
                      <option v-for="value in state.info['education']" :key="value" :value="value">{{ value }}</option>
                    </select>
                  </div>
                  <div class="col-sm-6">
                    <label for="maritalStatus" class="form-label fw-bold">Marital Status</label>
                    <select class="form-select" id="maritalStatus" v-model="info_data.selected['maritalStatus']" required>
                      <option disabled value="">Please select a marital status</option>
                      <option v-for="value in state.info['maritalStatus']" :key="value" :value="value">{{ value }}</option>
                    </select>
                  </div>
                </div>
                <div class="form-group row my-5">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <label for="familyCount" class="form-label fw-bold">Family Count</label>
                    <input type="number" class="form-control form-control-user" id="familyCount" v-model="info_data.selected['familyCount']" required>
                  </div>
                  <div class="col-sm-6">
                    <label for="ChildCount" class="form-label fw-bold">Child Count</label>
                    <input type="number" class="form-control form-control-user" id="ChildCount" v-model="info_data.selected['childCount']" required>
                  </div>
                </div>

                <div class="form-group my-5">
                  <label for="incomeType" class="form-label fw-bold">Income Type</label>
                  <select class="form-select" id="incomeType" v-model="info_data.selected['incomeType']" required>
                    <option disabled value="">Please select an income type</option>
                    <option v-for="type in state.info['incomeType']" :key="type" :value="type">{{ type }}</option>
                  </select>
                </div>
                <div class="form-group my-5">
                  <label for="incomeClass" class="form-label fw-bold">Income Class</label>
                  <select class="form-select" id="incomeClass" v-model="info_data.selected['incomeClass']" required>
                    <option disabled value="">Please select an income class</option>
                    <option v-for="incomeclass in state.info['incomeClass']" :key="incomeclass" :value="incomeclass">{{ incomeclass }}</option>
                  </select>
                </div>
                <div class="form-group my-5">
                  <label for="occupation" class="form-label fw-bold">Occupation</label>
                  <select class="form-select" id="occupation" v-model="info_data.selected['occupation']" required>
                    <option disabled value="">Please select an occupation</option>
                    <option v-for="occup in state.info['occupation']" :key="occup" :value="occup">{{ occup }}</option>
                  </select>
                </div>
                <div class="form-group my-5">
                  <label for="orgType" class="form-label fw-bold">Org Type</label>
                  <select class="form-select" id="orgType" v-model="info_data.selected['orgType']" required>
                    <option disabled value="">Please select an org type</option>
                    <option v-for="type in state.info['orgType']" :key="type" :value="type">{{ type }}</option>
                  </select>
                </div>
                <div class="form-group my-5">
                  <label for="employedYears" class="form-label fw-bold">Employed Years</label>
                  <input type="number" class="form-control form-control-user" id="employedYears" v-model="info_data.selected['employedYears']" placeholder="Leave blank if not applicable">
                </div>
                <div class="form-group my-5">
                  <label for="houseOwnedYN" class="form-label fw-bold">House Own Y/N</label>
                  <select class="form-select" id="houseOwnedYN" v-model="info_data.selected['houseOwnedYN']" required>
                    <option disabled value="">Please select an option</option>
                    <option v-for="option in state.info['houseOwnedYN']" :key="option" :value="option">{{ option }}</option>
                  </select>
                </div>
                <div class="form-group my-5">
                  <label for="dwellingType" class="form-label fw-bold">Dwelling Type</label>
                  <select class="form-select" id="dwellingType" v-model="info_data.selected['dwellingType']" required>
                    <option disabled value="">Please select a dwelling type</option>
                    <option v-for="type in state.info['dwellingType']" :key="type" :value="type">{{ type }}</option>
                  </select>
                </div>
                <div class="form-group my-5">
                  <label for="housingType" class="form-label fw-bold">Housing Type</label>
                  <select class="form-select" id="housingType" v-model="info_data.selected['housingType']" required>
                    <option disabled value="">Please select a housing type</option>
                    <option v-for="type in state.info['housingType']" :key="type" :value="type">{{ type }}</option>
                  </select>
                </div>
                <div class="form-group my-5">
                  <label for="residenceClass" class="form-label fw-bold">Residence Class</label>
                  <select class="form-select" id="residenceClass" v-model="info_data.selected['residenceClass']" required>
                    <option disabled value="">Please select a residence class</option>
                    <option v-for="residenceClass in state.info['residenceClass']" :key="residenceClass" :value="residenceClass">{{ residenceClass }}</option>
                  </select>
                </div>
                <div class="form-group my-5">
                  <label for="carOwnedYN" class="form-label fw-bold">Car Owned Y/N</label>
                  <select class="form-select" id="carOwnedYN" v-model="info_data.selected['carOwnedYN']" required>
                    <option disabled value="">Please select an option</option>
                    <option v-for="option in state.info['carOwnedYN']" :key="option" :value="option">{{ option }}</option>
                  </select>
                </div>

                <button class="btn btn-primary btn-lg" type="submit">
                  Edit Info
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
import {onMounted, reactive, ref} from "vue";
import router from "@/scripts/router";


export default {

  name:"info",
  setup(){
    const state = reactive({
      info:{},
      selected: {}
    })

    const info_data = reactive({
      info:{},
      selected: {}
    })
    const account_id = ref("");

    onMounted(async () => {
      const responseCheck = await axios.get("/api/check");
      account_id.value = responseCheck.data;
      console.log("[CHECK ID in Application]", account_id.value);

      const response = await axios.get("/api/info");
      state.info = response.data;
      console.log("[STATE INFO]", state.info);

      for (let key in state.info) {
        if (Array.isArray(state.info[key])) {
          state.selected[key] = '';
        }
      }
      const get_response = await axios.get(`/api/info/${account_id.value}`);
      console.log("[Check get Application]",get_response.data);
      info_data.info = get_response.data;

      // state.selected에 API 응답 데이터를 저장합니다
      for (let key in info_data.info) {
        info_data.selected[key] = info_data.info[key];
      }
      console.log("[Check Selected]",info_data.selected);
    });

    const submitData = async () => {
      try {
        const put_response = await axios.put(`/api/info/${account_id.value}`,info_data.selected);
        console.log("[Check Put data]",put_response.data);
        await router.push({path: "/info"});
      } catch (error) {
        console.error(error);
      }
    };


    return { state, info_data, submitData };
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