<template>
  <div class="c container">

<q-app-bar class="transparent-navbar">
      <div>
        <img src="logo.png" alt="Logo" class="logo" />
      </div>

      <q-space />

      <q-input outlined dense placeholder="Search..." class="navbar-input" v-model="q"   @keyup.enter="onEnterKeyPressed"/>

      <q-space />

     
      <q-btn flat label="advert" class="q-mr-md" />
      <q-btn flat label="enterprise" class="q-mr-md" />
      <q-btn flat label="login" />
   

    </q-app-bar>


    <br>
    <br>
    <br>
    <br>
     <div class="navbar-image-container">
      <img src="https://cdn.w600.comps.canstockphoto.com/city-house-isometric-banner-vector-clipart_csp70853204.jpg" alt="Your Image" class="navbar-image" />
      <img src="https://cdn.w600.comps.canstockphoto.com/city-house-isometric-banner-vector-clipart_csp70853204.jpg" alt="Your Image" class="navbar-image" />
    </div>
    <br>
    <br>
    <br>
    <br>

  <div class="home-page">
    <div class="description">
      <h1>Welcome to Your Website</h1>
      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum</p>
      <br>
       <div class="center-button">
          <q-btn class="big-button" label="ABOUT US " color="light-pink" text-color="black" />
        </div>
    </div>



    <div class="image">
      <!-- <img src="https://images.pexels.com/photos/1926769/pexels-photo-1926769.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" alt="Your Image" /> -->
      <img src="https://images.pexels.com/photos/1021693/pexels-photo-1021693.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" alt="Your Image" />
    </div>
  </div>

<!-- Three vertical cards -->
  <h3> Advert type 2</h3>
  <hr>
   <div class="card-container">
    <div v-for="(group, index) in groupedAdverts_2" :key="index" class="card-group">
      <q-card v-for="advert in group" :key="advert.title" class="card">
        <q-card-section>
          <h4>{{ advert.title }}</h4>
          <img class="imgg" :src="imgs[advert.id]" alt="">
          <p>{{ advert.description }}</p>
        </q-card-section>

        <q-card-actions align="right">
          <q-btn flat label="See More" @click="seeMore(advert)" color="primary" />
        </q-card-actions>
      </q-card>
    </div>
  </div>
  <br>
  <h3> Advert type 1</h3>
  <hr>
<div class="card-container">
    <div v-for="(group, index) in groupedAdverts_1" :key="index" class="card-group">
      <q-card v-for="advert in group" :key="advert.title" class="card">
        <q-card-section>
          <h4>{{ advert.title }}</h4>
          <img class="imgg" :src="imgs[advert.id]" alt="">
          <p> {{ advert.description }}</p>

          <q-card-actions align="right">
          <q-btn flat label="See More" @click="seeMore(advert)" color="primary" />
        </q-card-actions>
        </q-card-section>
      </q-card>
    </div>
  </div>



 


  



</div>

 <div class="footer">
      
      
      <!-- Copyright Section -->
      <p class="copyright">&copy; 2023 Your Website Name. All rights reserved.</p>
<!-- Contact Us Section -->
      <div class="contact-us">
        <p>Contact Us:</p>
        <p>Email: example@example.com</p>
        <p>Phone: +1 (123) 456-7890</p>
      </div>
    </div>


</template>

<script>
import axios from 'axios';

const api = 'https://8f33-197-240-97-177.ngrok.io/individual/adverts';

export default {
  data() {
    return {
      imgs: [

      'https://images.pexels.com/photos/1021693/pexels-photo-1021693.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
      'https://www.bestoil.tn/256-large_default/huile-moteur-shell-hmd-40.jpg',
      'https://www.bestoil.tn/376-home_default/huile-moteur-shell-rimula-r3-turbo-15w40.jpg',
      'https://m.media-amazon.com/images/I/41Qv3U1SZ0L._AC_UF1000,1000_QL80_.jpg',
      'https://www.bestoil.tn/376-home_default/huile-moteur-shell-rimula-r3-turbo-15w40.jpg',
      'https://m.media-amazon.com/images/I/41Qv3U1SZ0L._AC_UF1000,1000_QL80_.jpg',
      'https://www.bestoil.tn/256-large_default/huile-moteur-shell-hmd-40.jpg',
      'https://www.bestoil.tn/376-home_default/huile-moteur-shell-rimula-r3-turbo-15w40.jpg',
      'https://m.media-amazon.com/images/I/41Qv3U1SZ0L._AC_UF1000,1000_QL80_.jpg',
      'https://www.bestoil.tn/256-large_default/huile-moteur-shell-hmd-40.jpg',
      'https://www.bestoil.tn/376-home_default/huile-moteur-shell-rimula-r3-turbo-15w40.jpg',
      'https://m.media-amazon.com/images/I/41Qv3U1SZ0L._AC_UF1000,1000_QL80_.jpg',
      'https://www.bestoil.tn/256-large_default/huile-moteur-shell-hmd-40.jpg',
      'https://www.bestoil.tn/376-home_default/huile-moteur-shell-rimula-r3-turbo-15w40.jpg',
      'https://m.media-amazon.com/images/I/41Qv3U1SZ0L._AC_UF1000,1000_QL80_.jpg',
      'https://www.bestoil.tn/256-large_default/huile-moteur-shell-hmd-40.jpg',
      ],
      adverts: [],
      adverts_1: [],
      adverts_2: [],
      q:''
    };
  },
  computed: {
    groupedAdverts_1() {
    //groups for the first array
      const grouped = [];
      for (let i = 0; i < this.adverts.length; i += 3) {
        grouped.push(this.adverts_1.slice(i, i + 3));
      }
      return grouped;
    },
    //groups for the second array
    groupedAdverts_2() {
      const grouped = [];
      for (let i = 0; i < this.adverts.length; i += 3) {
        grouped.push(this.adverts_2.slice(i, i + 3));
      }
      return grouped;
    },
  },
  mounted() {
    console.log(this.$route.params.id);
    this.fetchdata();
  },
  methods: {
     seeMore(advert) {
      this.$router.push('/d_advert/' + advert.id)
    },
     onEnterKeyPressed() {
      console.log(this.q)
      this.$router.push('/search/'+ this.q);

     },
    async fetchdata() {
      try {
        const response = await axios.get(api);
        this.adverts = response.data.content;
        
        //filter them

        this.adverts_1 = this.adverts.filter( (element) => element.advert_type==1)
        this.adverts_2 = this.adverts.filter( (element) => element.advert_type==2)

        console.log(this.adverts);
      } catch (error) {
        console.error('error fetching data from the api:', error);
      }
    },
  },
};
</script>

<style scoped>
 hr.short-hr {
    width: 80%; 
    margin-left: auto;
    margin-right: auto;
  }
.container {

  position: relative;
  padding-left: 40px;
  padding-right: 70px; 
}

.transparent-navbar {
  background-color: transparent;
  position: absolute; 
  width: calc(100% - 40px);
  z-index: 1; 
  display: flex;
  justify-content: space-between;
  align-items: center;
  top:20px;
}

.navbar-input {
  flex: 1;
  margin: 0 10px; 
}



.c {
  background-color: #f0e6f2; 
  float:left;
clear:none;  
}

.home-page {
  background-color: #f0e6f2;
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 100vh; 
  padding: 20px;
}

.description {
  width: 50%; 
  padding: 20px;
}

.description h1 {
  font-size: 4em;
}


.big-button {
 
  font-size: 18px; 
}

.center-button {
  text-align: center; 
}


.image {
  width: 50%; 
  text-align: center; 
}

.image img {
  max-width: 100%; 
  height: auto;
}


.card-container {
  display: flex;
  justify-content: space-between;
  margin: 20px 0; 
}

.card {
  
  width: 30em;
  border: 1px solid #ccc; 
}


.card-image {
  max-width: 100%; 
  height: auto; 
}

.footer {
  background-color: #ccc; 
  text-align: center;
  padding: 10px 0; 
  display: flex; 
  justify-content: space-between; 
  align-items: flex-end;
  margin-top: 0px;
  padding-top: 0px;
  float:left;
  clear:none;  
  width: 100%;
}

.contact-us,
.copyright {
  background-color: #ccc; 
  padding: 10px;
  border-radius: 5px; 
}

.contact-us {
  text-align: left;
}

.navbar-image-container {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 20px;
}

.navbar-image {
  max-width: 100%;
  height: auto;
}

.imgg{
  height: 15em;
  width: 25em;
}
</style>



