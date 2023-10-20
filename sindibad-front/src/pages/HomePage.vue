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

     
      <!-- <q-btn flat label="advert" href="/advert" class="q-mr-md" /> -->
      <!-- <q-btn flat label="enterprise" href="/create_enter" class="q-mr-md" /> -->
      <q-btn flat label="login" href="/login" />
      <q-btn flat label="inscription" href="/user" />
      <!-- <q-btn flat label="Inscription" href="/User" /> -->
   

    </q-app-bar>
    

    <div class="new-button-container">
      
  <!-- <q-btn flat label="add advert" class="q-mr-md new-b" @click="handleNewButtonClick" /> -->
  
</div>


    <br>
    <br>
    <br>
    <br>
    <br><br>


    <div class="q-pa-md">
      <q-carousel
        animated
        v-model="slide"
        arrows
        navigation
        infinite
        autoplay="true"
        style="width: 70vw; height: 200px; margin-left: 11vw;"
      >
        <q-carousel-slide v-for="slide in slides" :key="slide.id" :name="slide.id" :img-src="slide.url" style="width: 100%; height: 100%;" ></q-carousel-slide>
      </q-carousel>
    </div>

    
  <div class="home-page">
    <div class="description">
      <h1>Welcome to Sindibad</h1>
      <p>Sindibad est hub agissant comme une plateforme complète d’annonces avec des orientations thématiques poussées. Il s’agit d’un agrégat de tout ce qui constitue une annonce .</p>
      <br>
       <!-- <div class="center-button">
          <q-btn class="big-button" label="ABOUT US " color="light-pink" text-color="black" />
        </div> -->
    </div>



    <div class="image" >

      <img src="../assets/Sindibad.png" alt="Your Image" />
      <!-- <img src="https://images.pexels.com/photos/1926769/pexels-photo-1926769.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" alt="Your Image" /> -->
    </div>
  </div>

<!-- Three vertical cards -->
  <h3> Véhicule </h3>
  <hr>
   <!-- <div class="card-container">
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
  </div> -->

  <hr>
   <div class="card-container">
      <q-card v-for="advert in adverts_1" :key="advert.title" class="card">
        <q-card-section>
          <h4>{{ advert.title }}</h4>
          <img class="imgg" :src="imgs[advert.id]" alt="">
          <p>{{ advert.description }}
          gouvernorat: {{ go[advert.id] }}
          </p>

        </q-card-section>
        <q-card-actions align="right">
          <q-btn flat label="See More" @click="seeMore(advert)" color="primary" />
        </q-card-actions>
      </q-card>
  </div>


  <div class="pagination-container">
   <q-pagination
    v-model="currentPage"
    :max="maxPages"
    class="q-mt-md"
    @click="changePage"
  />
  </div>
  <br>



  <h3> Immobilières </h3>
  <hr>
 <div class="card-container">
      <q-card v-for="advert in adverts_2" :key="advert.title" class="card">
        <q-card-section>
          <h4>{{ advert.title }}</h4>
          <img class="imgg" :src="imgs_imo[advert.id]" alt="">
          <p>{{ advert.description }}
          gouvernorat: {{ go[advert.id] }}
          </p>

        </q-card-section>
        <q-card-actions align="right">
          <q-btn flat label="See More" @click="seeMore(advert)" color="primary" />
        </q-card-actions>
      </q-card>
  </div>
  <div class="pagination-container">
   <q-pagination
    v-model="currentPage"
    :max="maxPages"
    class="q-mt-md"
    @click="changePage"
  />
  </div>



 


  



</div>

 <div class="footer">
      
      
  <q-avatar>
            <img src="../assets/Sindibad.png">
          </q-avatar>
<!-- Contact Us Section -->
      <div class="contact-us">
        <p>Contact Us:</p>
        <p>Email: contact@sindibad.com</p>
        <p>Phone: +216 70 000 000</p>
      </div>
    </div>


</template>

<script>
import axios from 'axios';

const api = 'http://localhost:8000/individual/adverts?pageSize=30&pageNum=';

const slides = [
  {
    id: 1,
    url: require('../assets/gloulou.png')
  },
  {
    id: 2,
    url: require('../assets/ennakl.png')
  }
]

export default {
  data() {
    return {
      slide: 1,
      slides,
      currentPage: 1,
      itemsPerPage: 3,
     
      maxPages: 3,
      go:[
        'Ben Arous',
        'Tunis',
        'Kairouan',
        'Bizerte',
        'Sidi Bouzid',
        'Gassrine',
        'Tataouine',
        'Sfax',
        'Sousse'
      ],
      imgs_imo: [

'https://www.buildimmobiliere.tn/images/00.jpg',
'https://immoneuftunisie.com/wp-content/uploads/2022/10/residence-omrane-16-immobiliere-du-maghreb-cite-el-ghazela-immobilier-appartement-tunisie-1-3.jpg',
     'https://www.trust-immobiliere.com/wp-content/uploads/2020/02/2.png',
'https://i.pinimg.com/736x/db/ae/71/dbae71af6a63d04ce1f7ac990d11fb3f.jpg',

'https://www.buildimmobiliere.tn/images/00.jpg',
'https://immoneuftunisie.com/wp-content/uploads/2022/10/residence-omrane-16-immobiliere-du-maghreb-cite-el-ghazela-immobilier-appartement-tunisie-1-3.jpg',
     'https://www.trust-immobiliere.com/wp-content/uploads/2020/02/2.png',
'https://i.pinimg.com/736x/db/ae/71/dbae71af6a63d04ce1f7ac990d11fb3f.jpg',


'https://www.buildimmobiliere.tn/images/00.jpg',
'https://immoneuftunisie.com/wp-content/uploads/2022/10/residence-omrane-16-immobiliere-du-maghreb-cite-el-ghazela-immobilier-appartement-tunisie-1-3.jpg',
     'https://www.trust-immobiliere.com/wp-content/uploads/2020/02/2.png',
'https://i.pinimg.com/736x/db/ae/71/dbae71af6a63d04ce1f7ac990d11fb3f.jpg',


'https://www.buildimmobiliere.tn/images/00.jpg',
'https://immoneuftunisie.com/wp-content/uploads/2022/10/residence-omrane-16-immobiliere-du-maghreb-cite-el-ghazela-immobilier-appartement-tunisie-1-3.jpg',
     'https://www.trust-immobiliere.com/wp-content/uploads/2020/02/2.png',
'https://i.pinimg.com/736x/db/ae/71/dbae71af6a63d04ce1f7ac990d11fb3f.jpg',
    ],
    imgs:[
      
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSYprVzHhHgrZhn3iQfq_v2XVU7_wcNUkVgw&usqp=CAU',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7hR_2gMSQY9n72HS7z94WwYUfQILodUbPbA&usqp=CAU',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGBoUku2LbL4mMG3EK7XNl_uua8mMweiDSzQ&usqp=CAU',

'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSYprVzHhHgrZhn3iQfq_v2XVU7_wcNUkVgw&usqp=CAU',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7hR_2gMSQY9n72HS7z94WwYUfQILodUbPbA&usqp=CAU',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGBoUku2LbL4mMG3EK7XNl_uua8mMweiDSzQ&usqp=CAU',

'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSYprVzHhHgrZhn3iQfq_v2XVU7_wcNUkVgw&usqp=CAU',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7hR_2gMSQY9n72HS7z94WwYUfQILodUbPbA&usqp=CAU',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGBoUku2LbL4mMG3EK7XNl_uua8mMweiDSzQ&usqp=CAU',

'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSYprVzHhHgrZhn3iQfq_v2XVU7_wcNUkVgw&usqp=CAU',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7hR_2gMSQY9n72HS7z94WwYUfQILodUbPbA&usqp=CAU',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGBoUku2LbL4mMG3EK7XNl_uua8mMweiDSzQ&usqp=CAU',

'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSYprVzHhHgrZhn3iQfq_v2XVU7_wcNUkVgw&usqp=CAU',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7hR_2gMSQY9n72HS7z94WwYUfQILodUbPbA&usqp=CAU',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGBoUku2LbL4mMG3EK7XNl_uua8mMweiDSzQ&usqp=CAU',
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

   
    async changePage(){
      const page = this.currentPage - 1;
      console.log(page)
      if (page == 1){
        this.adverts = 1;
      }

      console.log(api + page)
      const response = await axios.get(api + page);
        
        this.adverts = response.data.content;
        if (this.adverts.length == 1){
          this.adverts.push(this.adverts[0])
          this.adverts.push(this.adverts[0])
        }
        else if (this.adverts.length == 2){
          this.adverts.push(this.adverts[0]);
        }
        // this.adverts = this.adverts.slice(0,3);
        console.log(this.adverts.length);
      
      
    },
    handleNewButtonClick () {
      this.$router.push('/advert')
    },
     seeMore(advert) {
      this.$router.push('/d_advert/' + advert.id)
    },
     onEnterKeyPressed() {
      console.log(this.q)
      this.$router.push('/search/'+ this.q);

     },
     async fetchdata() {
      try {
        const response = await axios.get(api+'0');
        this.adverts = response.data.content;
        this.maxPages = response.data.totalPages
        
        //filter them

        this.adverts_1 = this.adverts.filter( (element) => element.advert_type==1).slice(0,3)
        console.log('//////////')

        this.adverts_2 = this.adverts.filter( (element) => element.advert_type==2).slice(0,3)

        console.log(this.adverts);
        console.log(this.adverts_1)

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

.new-button-container {
    position: absolute;
    top: 70px; 
    right: 20px; 
  }

  .new-b {
    color: white;
  background-color: #FF5733;



  }

  .pagination-container {
    display: flex;
    justify-content: center;
    align-items: center; 
    margin-top: 20px; 
  }
</style>