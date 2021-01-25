<template>
  <nav class="navbar navbar-expand-lg navbar-light">
      <div class="container">
            <div class="container-fluid">
    <a class="navbar-brand" href="#">Podo Ngalih Resto</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
         <router-link class="nav-link" to="/">Home</router-link>
        </li>
        <li class="nav-item">
         <!-- <router-link class="nav-link" to="/foods">Foods</router-link> -->
        </li>
        <!-- <li class="nav-item">
         <router-link class="nav-link" to="/Register"> Register </router-link>
        </li>
        <li class="nav-item">
         <router-link class="nav-link" to="/Login"> Login </router-link>
        </li> -->
      </ul>
      <ul>
        
      </ul>
      
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
         <router-link class="nav-link" to="/keranjang">Keranjang
         <b-icon-bag></b-icon-bag>
             <span class="badge badge-success ml-2">{{ jumlahPesanan.length }}</span>
         </router-link>
        </li>
      </ul>
    </div>
  </div>
      </div>
</nav>
</template>
<script>
import axios from "axios";
export default {
  name: "Navbar",
  data() {
    return {
      jumlahPesanan: [],
    };
  },
  props: ["updateKeranjang"],
  methods: {
    setJumlah(data) {
      this.jumlahPesanan = data;
    },
  },
  mounted() {
    axios
      .get("http://192.168.1.33:8087/tis/keranjangs")
      .then((response) => this.setJumlah(response.data))
      .catch((error) => console.log(error));
  },
};
</script>
<style>
</style>