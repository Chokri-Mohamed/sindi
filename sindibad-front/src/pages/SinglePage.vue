<template>
  <div class="c container">
    <q-app-bar class="transparent-navbar">
      <!-- Logo on the left -->
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

      <!-- Spacer to push buttons to the right -->
      <!-- <q-space />

      <q-input outlined dense placeholder="Search..." class="navbar-input" />

      <q-space /> -->

      <!-- Buttons on the right -->
     <!-- <q-btn flat label="profile" class="q-mr-md" /> -->
      <!-- <q-btn flat label="enterprise" class="q-mr-md" /> -->
      <q-btn flat label="Home" href="/homeu" />
    </q-app-bar>

    <div class="home-page">
      <div class="description">
        <h1>  {{ formdata.title }} 
        
        <!-- <q-btn flat label="Delete advert" class="q-ml-auto" @click="handleModify" /> -->

        </h1>
          <img v-if="formdata.advert_type==2" class="imgg" :src="imgs[$route.params.id]" alt="" >
          <img v-else class="imgg" :src="imgs_imo[$route.params.id]" alt="" >
        <p>
          <br>
          Location: Ben Arous
          <br>
          {{ formdata.description }}
          <!-- Lorem Ipsum is simply dummy text of the printing and typesetting
          industry. Lorem Ipsum has been the industry's standard dummy text
          ever since the 1500s, when an unknown printer took a galley of type
          and scrambled it to make a type specimen book. It has survived not
          only five centuries, but also the leap into electronic typesetting,
          remaining essentially unchanged. It was popularised in the 1960s
          with the release of Letraset sheets containing Lorem Ipsum passages,
          and more recently with desktop publishing software like Aldus
          PageMaker including versions of Lorem Ipsum -->
        </p>
        <br />
        <div class="center-button">
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
  </div>
</template>

<style scoped>
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
  width: 30%; 
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



.card-container {
   display: flex;
  flex-direction: column;
  margin-top: 20px;
  align-items: center;
  max-width: 50%;

}

.card {
   width: 300px;
   height: 200px;
  border: 1px solid #ccc;
  padding: 10px;
  display: flex;
  flex-direction: column;
}

.imgg{
  height: 15em;
  width: 25em;
}





</style>

<script>
import axios from 'axios';


const api = 'http://localhost:8000/individual/adverts';

export default {
  data() {
    return {
      imgs_imo: [

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

      formdata: {
        title: '',
        description: ''
      },
      testData: {
        title: '',
        description: '',
        advert_type: -1
      },
      adverts :  [
        { title: '', description: '' },
        { title: '', description: '' },
        { title: '', description: '' }
      ]
    
    };
  },
  mounted() {
    console.log(this.$route.params.id);
    this.fetchdata();
  },
  methods: {
    handleModify(){
      console.log('helo')
      this.$router.push('/modify_advert/'+ this.$route.params.id)
    },
    async fetchdata() {
    //   getting the advert to display
      try {
        const response = await axios.get(api + '/' + this.$route.params.id);
        const data = response.data;
        console.log('api response:', data);

        this.formdata.title = data.title;
        this.formdata.description = data.description;
        this.formdata.advert_type = data.advert_type;

      } catch (error) {
        console.error('error fetching data from the api:', error);
      }

    // getting the other adverts

      try {
        const response = await axios.get(api);
        this.adverts = response.data.content;


        console.log('api response:', this.adverts[2].description);
      } catch (error) {
        console.error('error fetching data from the api:', error);
      }



    },
  }
};
</script> 