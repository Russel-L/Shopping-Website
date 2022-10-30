<template>
  <div id="home">
    <h1>HOME</h1>
  </div>

  <div class="container">
    <div class="row">
      <h2 class="pt-3">Products</h2>
    </div>
    <div class="row">
      <div v-for="index in this.productSize" :key="index"
      class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex">
        <ProductBox :product="products[index-1]" />
      </div>
    </div>
  </div>
</template>

<script>
import ProductBox from '../components/ProductBox.vue'

export default {
  name: 'HomeView',
  components: {
    ProductBox
},
  props: ["products"],
  data () {
    return {
      productSize: 0
    }
  },
  mounted () {
    this.productSize = Math.min(6, this.products.length)
  }
}
</script>
