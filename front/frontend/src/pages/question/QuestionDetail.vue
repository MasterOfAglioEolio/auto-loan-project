<template>
  <div class="question-detail">
    <div class="question-contents">
      <h3>{{ title }}</h3>
      <div>
        <strong class="w3-large">{{ author }}</strong>
        <br>
        <span>{{ created_at }}</span>
      </div>
    </div>
    <div class="question-contents">
      <span>{{ contents }}</span>
    </div>
    <!-- CommentDetail 컴포넌트를 사용하여 댓글 상세 정보 표시 -->
    <comment-detail :commentDetail="commentDetail" />

    <div class="common-buttons">
      <button type="button" class="w3-button w3-round w3-blue-gray" v-on:click="fnUpdate">수정</button>&nbsp;
      <button type="button" class="w3-button w3-round w3-red" v-on:click="fnDelete">삭제</button>&nbsp;
      <button type="button" class="w3-button w3-round w3-gray" v-on:click="fnList">목록</button>
    </div>
  </div>
</template>

<script>
import router from "@/scripts/router";
import axios from "axios";
import CommentDetail from "@/pages/comment/CommentDetail.vue";

export default {
  components: {
    CommentDetail,
  },
  data() { //변수생성
    return {
      requestBody: this.$route.query,
      idx: this.$route.query.idx,

      title: '',
      contents: '',
      created_at:'',
      commentDetail: {},

    }
  },
  mounted() {
    this.fnGetView()
  },
  methods: {
    fnGetView() {
      axios.get('/api/question/' + this.idx, {
        params: this.requestBody
      }).then((res) => {
        this.title = res.data.title
        this.contents = res.data.contents
        this.created_at = res.data.createdAt
      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      });
      axios.get('/api/comment/' + this.idx, {
            params: this.requestBody,
          })
          .then((res) => {
            this.commentDetail = res.data;
          })
          .catch((err) => {
            console.error(err);
            if (err.message.indexOf('Network Error') > -1) {
              alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.');
            }
          });
    },
    fnList() {
      delete this.requestBody.idx
      router.push({
        path: './list',
        query: this.requestBody
      })
    },
    fnUpdate() {
      router.push({
        path: './write',
        query: this.requestBody
      })
    },
    fnDelete() {
      if (!confirm("삭제하시겠습니까?")) return

      axios.delete('/api/question/' + this.idx, {})
          .then(() => {
            alert('삭제되었습니다.')
            this.fnList();
          }).catch((err) => {
        console.log(err);
      })
    }
  }
}
</script>
<style scoped>


</style>