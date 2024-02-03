<template>
  <div class="board-detail">
    <div class="board-contents">
      <input type="text" v-model="title" class="w3-input w3-border" placeholder="제목을 입력해주세요.">
    </div>
    <div class="board-contents">
      <textarea id="" cols="30" rows="10" v-model="contents" class="w3-input w3-border" style="resize: none;">
      </textarea>
    </div>
    <div class="common-buttons">
      <button type="button" class="w3-button w3-round w3-blue-gray" v-on:click="fnSave">저장</button>&nbsp;
      <button type="button" class="w3-button w3-round w3-gray" v-on:click="fnList">목록</button>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import router from "@/scripts/router";

export default {
  data() { //변수생성
    return {
      requestBody: this.$route.query,
      idx: this.$route.query.idx,

      title: '',
      contents: '',
      created_at: ''
    }
  },
  mounted() {
    this.fnGetView()
  },
  methods: {
    fnGetView() {
      if (this.idx !== undefined) {
        axios.get('/api/board/' + this.idx, {
          params: this.requestBody
        }).then((res) => {
          this.title = res.data.title
          this.contents = res.data.contents
          this.created_at = res.data.createdAt
        }).catch((err) => {
          console.log(err)
        })
      }
    },
    fnList() {
      delete this.requestBody.idx
      router.push({
        path: './list',
        query: this.requestBody
      })
    },
    fnView(idx) {
      this.requestBody.idx = idx
      router.push({
        path: './detail',
        query: this.requestBody
      })
    },
    fnSave() {
      let apiUrl ='/api/board'
      this.form = {
        "idx": this.idx,
        "title": this.title,
        "contents": this.contents,
      }

      if (this.idx === undefined) {
        //INSERT
        axios.post(apiUrl, this.form)
            .then((res) => {
              alert('글이 저장되었습니다.')
              this.fnView(res.data.idx)
            }).catch((err) => {
          if (err.message.indexOf('Network Error') > -1) {
            alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
          }
        })
      } else {
        //UPDATE
        axios.patch(apiUrl, this.form)
            .then((res) => {
              alert('글이 저장되었습니다.')
              this.fnView(res.data.idx)
            }).catch((err) => {
          if (err.message.indexOf('Network Error') > -1) {
            alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
          }
        })
      }
    }
  }
}
</script>
<style scoped>

</style>