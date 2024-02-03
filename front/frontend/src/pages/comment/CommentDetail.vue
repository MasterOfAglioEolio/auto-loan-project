<template>
  <div class="comment-detail">
    <div class="comment-contents">
      <div>
        <br>
        <span>{{ created_at }}</span>
      </div>
    </div>
  </div>
  <div class="comment-contents">
    <div class="comment-box">
      <span class="contents">{{ contents }}</span>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() { //변수생성
    return {
      requestBody: this.$route.query,
      idx: this.$route.query.idx,

      contents: '',
      created_at: ''
    }
  },
  mounted() {
    this.fnGetView()
  },
  methods: {
    fnGetView() {
      axios.get('/api/comment/' + this.idx, {
        params: this.requestBody
      }).then((res) => {
        this.contents = res.data.contents
        this.created_at = res.data.createdAt
      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    }
  }
}
</script>
<style scoped>
.comment-box {
  border: 1px solid #ccc; /* 박스의 테두리 스타일과 색상을 지정합니다. */
  padding: 10px; /* 박스의 내부 여백을 조정합니다. */
  border-radius: 5px; /* 박스의 테두리를 둥글게 만듭니다. */
}


</style>