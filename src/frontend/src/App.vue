<template>
  <nav>
    <router-link to="/">Home | </router-link>
    <router-link :to="{name: 'admin'}">Admin | </router-link>
    <router-link :to="{name: 'cart'}">Cart | </router-link>
    <router-link v-if="!token" :to="{name: 'SignUp'}">Sign Up | </router-link>
    <router-link v-if="!token" :to="{name: 'SignIn'}">Sign In</router-link>
    <a v-if="token" href="#" @click="signout">Sign Out</a>
  </nav>
  <router-view
  :baseURL = "baseURL"
  :products = "products"
  @fetchData="fetchData"
  style="min-height: 60vh"
  >
  </router-view>
</template>

<script>
import axios from 'axios'
import swal from 'sweetalert';

export default {
  data () {
    return {
      baseURL: "http://localhost:8080/",
      products: {},
      token: null
    }
  },
  methods: {
    async fetchData () {
      //api call to get products
      await axios.get(this.baseURL + "product/")
      .then(res => {
        this.products = res.data
      }).catch((err) => console.log('err', err));
    },
    signout() {
      localStorage.removeItem("token");
      this.token = null;
      swal({
        text: "Logged out.",
        icon: "success"
      });
      this.$router.push({name: "home"})
    }
  },
  mounted() {
    this.fetchData();
    this.token = localStorage.getItem("token");
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

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
