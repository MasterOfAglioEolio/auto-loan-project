<template>
  <h1>Hello, Vue!</h1>
  <h3>{{userId}}님, 안녕하세요!</h3>
  <p>{{msg}}</p>
</template>

<script>

export default {
  name: 'TestComponent',
  props : {
    userId: {
      type: String,
      required: true
    },
    msg: String
  }

}
</script>

<style>
h1 {
  color: #42b983;
}
</style>