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
      <q-space />

      <!-- <q-input outlined dense placeholder="Search..." class="navbar-input" /> -->

      <!-- Spacer to push buttons to the right -->
      <q-space />

      <!-- Buttons on the right -->
      <q-btn flat label="home" class="q-mr-md" href="/homeu" />
      <q-btn flat label="logout" href="/home" />
      
    </q-app-bar>

  
  <div class="home-page">
        <!-- Profile Section -->
        <div class="profile">
          <br>
          <br>
          <br>
          <div class="profile-info">
            <div class="profile-header">
                
      
      <img :src="require('../assets/pdf.jpg')" alt="Profile Image" class="profile-image" />
    </div>
    <br>
    <p>First Name: {{ user.firstname }}</p>
                <br>
                  <p>Last Name: {{ user.lastname }}</p>
                  <br>
        <p>Email: {{ user.email }}</p>
      </div>
       <div class="profile-buttons">
        <q-btn class="edit-profile-button" label="mes annonces" @click="$router.push('/myads/'+$route.params.id)"/>
        <q-btn class="edit-profile-button" label="Edit Profile" @click="modify"/>
        <q-btn class="edit-profile-button" label="add entreprise" @click="$router.push('/create_enter')"/>
        
      </div>
      <br>
  
          
        </div>
      </div>
  
      <div class="footer">
        <!-- Copyright Section -->
        <q-avatar>
            <img src="../assets/Sindibad.png">
          </q-avatar>        <!-- Contact Us Section -->
        <div class="contact-us">
          <p>Contact Us:</p>
        <p>Email: contact@sindibad.com</p>
        <p>Phone: +216 70 000 000</p>
        </div>
      </div>
    </div>
  </template>
  
  
  
  <style scoped>

.c {
  background-color: #D3D3D3; 
  float:left;
clear:none; 
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


.container {
  width: 100vw;
  position: relative;
  padding-left: 40px;
  padding-right: 70px; 
}


.profile {
  margin-top: -100px;
  width: 100vw;
  height: 105vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.profile-info {
  align-self: flex-start;
  margin-left: 36em;
}

.profile-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.profile-header h1 {
  margin-right: 10px; 
}

.profile-image {
  margin-left: 5em;
  max-width: 100px;  
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
.action-buttons {
  display: flex;
  align-items: center;
  gap: 8px;
}


.add-button {
  display: flex;
  justify-content: flex-end;
  margin-top: 10px;
}

.right-button {
    color: white;
  background-color: #FF5733;



  }
</style>

  
  
  <script>
  
  import axios from 'axios';
const api = 'http://localhost:8000/individual/users/'
  
  export default {
    data() {
      return {
        user: {
        id:'',
        email:'',
        firstname:'',
        lastname:'',
        },
        formData: {
          id:'',
          name: '',
          fiscalNum: '',
          user: {
            id:'',
            email:'',
            firstname:'',
            lastname:'',
          }
        },
     
        
      };
    },
    mounted() {
        this.fetchData();
      },
    methods: {
    modify(){
      this.$router.push('/modifyUser/'+this.$route.params.id);
    },
      async fetchData() {
        try {
          const response = await axios.get(api+ this.$route.params.id);
          const data = response.data;
  
          
          this.user.email = data.email;
          this.user.id = data.id;
          this.user.firstname = data.firstname;
          this.user.lastname = data.lastname;
          console.log('API Response:', data);
  
        } catch (error) {
          console.error('Error fetching data from the API:', error);
        }
      },
      
    },
  };
  </script>
  