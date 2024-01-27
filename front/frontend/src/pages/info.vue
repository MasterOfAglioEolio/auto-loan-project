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
                <h1 class="h4 text-gray-900 mb-4">register Your Information!</h1>
              </div>
              <form class="user" @submit.prevent="submitData">
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <label for="gender" class="form-label">Gender</label>
                    <select class="custom-select" id="gender" v-model="state.selected['gender']" required>
                      <option disabled value="">Please select a gender</option>
                      <option v-for="value in state.info['gender']" :key="value" :value="value">{{ value }}</option>
                    </select>
                  </div>
                  <div class="col-sm-6">
                    <label for="age" class="form-label">age</label>
                    <input type="number" class="form-control form-control-user" id="age" name="age" v-model="state.selected['age']" required>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <label for="education" class="form-label">Education</label>
                    <select class="custom-select" id="education" v-model="state.selected['education']" required>
                      <option disabled value="">Please select an education</option>
                      <option v-for="value in state.info['education']" :key="value" :value="value">{{ value }}</option>
                    </select>
                  </div>
                  <div class="col-sm-6">
                    <label for="maritalStatus" class="form-label">Marital Status</label>
                    <select class="custom-select" id="maritalStatus" v-model="state.selected['maritalStatus']" required>
                      <option disabled value="">Please select a marital status</option>
                      <option v-for="value in state.info['maritalStatus']" :key="value" :value="value">{{ value }}</option>
                    </select>
                  </div>
                </div>
                  <div class="form-group row">
                    <div class="col-sm-6 mb-3 mb-sm-0">
                      <label for="familyCount" class="form-label">Family Count</label>
                      <input type="number" class="form-control form-control-user" id="familyCount" v-model="state.selected['familyCount']" required>
                    </div>
                    <div class="col-sm-6">
                      <label for="ChildCount" class="form-label">Child Count</label>
                      <input type="number" class="form-control form-control-user" id="ChildCount" v-model="state.selected['childCount']" required>
                    </div>
                  </div>

                <div class="form-group">
                  <label for="incomeType" class="form-label">Income Type</label>
                  <select class="custom-select" id="incomeType" v-model="state.selected['incomeType']" required>
                    <option disabled value="">Please select an income type</option>
                    <option v-for="type in state.info['incomeType']" :key="type" :value="type">{{ type }}</option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="incomeClass" class="form-label">Income Class</label>
                  <select class="custom-select" id="incomeClass" v-model="state.selected['incomeClass']" required>
                    <option disabled value="">Please select an income class</option>
                    <option v-for="incomeclass in state.info['incomeClass']" :key="incomeclass" :value="incomeclass">{{ incomeclass }}</option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="occupation" class="form-label">Occupation</label>
                  <select class="custom-select" id="occupation" v-model="state.selected['occupation']" required>
                    <option disabled value="">Please select an occupation</option>
                    <option v-for="occup in state.info['occupation']" :key="occup" :value="occup">{{ occup }}</option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="orgType" class="form-label">Org Type</label>
                  <select class="custom-select" id="orgType" v-model="state.selected['orgType']" required>
                    <option disabled value="">Please select an org type</option>
                    <option v-for="type in state.info['orgType']" :key="type" :value="type">{{ type }}</option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="employedYears" class="form-label">Employed Years</label>
                  <input type="number" class="form-control form-control-user" id="employedYears" v-model="state.selected['employedYears']" placeholder="Leave blank if not applicable">
                </div>
                <div class="form-group">
                  <label for="houseOwnedYN" class="form-label">House Own Y/N</label>
                  <select class="custom-select" id="houseOwnedYN" v-model="state.selected['houseOwnedYN']" required>
                    <option disabled value="">Please select an option</option>
                    <option v-for="option in state.info['houseOwnedYN']" :key="option" :value="option">{{ option }}</option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="dwellingType" class="form-label">Dwelling Type</label>
                  <select class="custom-select" id="dwellingType" v-model="state.selected['dwellingType']" required>
                    <option disabled value="">Please select a dwelling type</option>
                    <option v-for="type in state.info['dwellingType']" :key="type" :value="type">{{ type }}</option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="housingType" class="form-label">Housing Type</label>
                  <select class="custom-select" id="housingType" v-model="state.selected['housingType']" required>
                    <option disabled value="">Please select a housing type</option>
                    <option v-for="type in state.info['housingType']" :key="type" :value="type">{{ type }}</option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="residenceClass" class="form-label">Residence Class</label>
                  <select class="custom-select" id="residenceClass" v-model="state.selected['residenceClass']" required>
                    <option disabled value="">Please select a residence class</option>
                    <option v-for="residenceClass in state.info['residenceClass']" :key="residenceClass" :value="residenceClass">{{ residenceClass }}</option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="carOwnedYN" class="form-label">Car Owned Y/N</label>
                  <select class="custom-select" id="carOwnedYN" v-model="state.selected['carOwnedYN']" required>
                    <option disabled value="">Please select an option</option>
                    <option v-for="option in state.info['carOwnedYN']" :key="option" :value="option">{{ option }}</option>
                  </select>
                </div>


                <!-- ... 나머지 필드들을 이와 같은 방식으로 추가 ... -->
                <button class="btn btn-primary btn-user btn-block" type="submit">
                  Register Account
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
      selected: {}
    })

    onMounted(async () => {
      const response = await axios.get("/api/info");
      state.info = response.data;

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
.form-signin {
  max-width: 330px;
  padding: 1rem;
}
.form-signin .form-floating:focus-within {
  z-index: 2;
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