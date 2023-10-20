<template>
  <div class="c container">

<q-app-bar class="transparent-navbar">
       <div>
        <q-toolbar>

<q-toolbar-title>
  <q-avatar>
    <img src="../assets/Sindibad.png">
  </q-avatar>
  Sindibad
</q-toolbar-title>
</q-toolbar>
      </div> 

      <q-space />

      <q-input outlined dense placeholder="Search..." class="navbar-input" v-model="q"   @keyup.enter="onEnterKeyPressed"/>

      <q-space />

      <q-btn flat label="Home" class="q-mr-md" href="/home"/>
    </q-app-bar>

    <br>
    <br>
    <br>
    <br>

  <h2> Search results</h2>
  <hr>
<div class="home-page">
    
      <div class="card-container">
        <div v-for="(group, index) in groupedAdverts" :key="index" class="card-group">
          <q-card v-for="advert in group" :key="advert.title" class="card">
            <q-card-section>
              <h4>{{ advert.title }}</h4>
              <!-- imghere -->
              <p> {{ advert.description }}</p>
            </q-card-section>
          </q-card>
        </div>
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


<style scoped>
.container {

  width: 100vw;
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
  background-color: #D3D3D3; 
  float:left;
clear:none;  
}

.home-page {
  background-color: #D3D3D3; 
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 100vh; 
  /* width: 92vw;  */
  /* width: 93vw;  */
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
  margin-left: 1em;
  margin-bottom: 1em;
  margin-right: 1em;

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
</style>








<script>
import axios from 'axios';

const api = 'http://localhost:8000/individual/adverts/search/';
// const api = 'https://61b0-102-152-214-192.ngrok.io/individual/adverts/search/'

export default {
  data() {
    return {
      adverts: [],
      q:''

    };
  },
  computed: {
    groupedAdverts() {
    //groups for the first array
      const grouped = [];
      for (let i = 0; i < this.adverts.length; i += 3) {
        grouped.push(this.adverts.slice(i, i + 3));
      }
      console.log(grouped)
      return grouped;
    },
    //groups for the second array
   
  },
  mounted() {
    console.log('search query is' + this.$route.params.q);
    this.fetchdata();
  },
  methods: {
    onEnterKeyPressed() {
      console.log(this.q)
      this.$router.push('/search/'+ this.q);

     },
    async fetchdata() {
      try {
        const response = await axios.get(api + this.$route.params.q);
        this.adverts = response.data;
        console.log(response.data);
        
        //filter them

        

      } catch (error) {
        console.error('error fetching data from the api:', error);
      }
    },
  },
   watch: {
      $route(newValue, oldValue) {
         console.log('************************************************')
         console.log(newValue, oldValue);
         this.fetchdata();
      }
   }
};
</script>