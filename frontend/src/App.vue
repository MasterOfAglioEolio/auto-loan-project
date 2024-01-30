<template>
  <header>
    <nav class="navbar navbar-expand-sm navbar-light bg-light">
      <div class="container-fluid">
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link to="/" class="nav-link">Home</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/about" class="nav-link">Q&A</router-link>
          </li>
          <li class="nav-item">
            <router-link :to="{name: 'BoardList'}" class="nav-link">공지사항</router-link>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <main>
            <div id="nav">
              <router-link to="/">Home</router-link> |
              <router-link to="/about">Q&A</router-link> |
              <router-link :to="{name: 'BoardList'}">공지사항</router-link>
            </div>
            <router-view/>
  </main>
  <footer>
  </footer>
</template>




<script>
export default {
  name: 'App',
  components: {
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

nav .navbar-nav a.router-link-exact-active {
  color: #42b983 !important;
}

nav .navbar-nav a.nav-link {
  font-weight: bold;
  color: #2c3e50 !important;
}
</style>
