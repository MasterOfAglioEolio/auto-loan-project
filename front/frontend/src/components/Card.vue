

<template>
    <div class="col-sm-6 mb-3 mb-sm-0">
      <label for="gender" class="form-label">{{item}}</label>
      <select class="custom-select" id="gender" name="gender" required>
      </select>
    </div>
<!--  <div class="card shadow-sm">-->
<!--    <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>-->
<!--    <div class="card-body">-->
<!--      <p class="card-text">{{item}}</p>-->
<!--      <div class="d-flex justify-content-between align-items-center">-->
<!--        <div class="btn-group">-->
<!--          <button type="button" class="btn btn-primary">구입하기</button>-->
<!--        </div>-->
<!--        <small class="text-body-secondary">9 mins</small>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
</template>

<script>
export default {
  name:'Card',
  props:{
    item:Object
  }
}

</script>

<style scoped>

</style>