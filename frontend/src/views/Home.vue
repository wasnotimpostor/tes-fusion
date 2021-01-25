<template>
  <div class="container">
    <Hero />
    <div class="row mt-4">
      <div class="col">
        <h2>Daftar<strong> Makanan</strong></h2>
      </div>
      <div class="col">
        <!-- <router-link
          class="btn badge-success float-right"
          to="/foods"
          tag="button"
          ><b-icon-eye></b-icon-eye> Lihat semua</router-link
        > -->
      </div>
    </div>

    <div class="row mb-3">
      <div class="col-md-4 mt-4" v-for="product in products" :key="product.id">
        <CardProduct :product="product" />
      </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import Hero from "@/components/Hero.vue";
import CardProduct from "../components/CardProduct";
import axios from "axios";
export default {
  name: "Home",
  components: {
    Hero,
    CardProduct,
  },
  data() {
    return {
      products: [],
    };
  },
  methods: {
    setProducts(data) {
      this.products = data;
    },
  },
  mounted() {
    axios
      .get("http://192.168.1.33:8087/tis/products")
      .then((response) => this.setProducts(response.data))
      .catch((error) => console.log(error));
  },
};
</script>