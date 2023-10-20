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

      <q-space />

      <!-- Spacer to push buttons to the right -->
      <q-space />

      <!-- Buttons on the right -->
      <q-btn flat label="Home" href="/homea" />
    </q-app-bar>

    <div class="new-button-container">
      
      
    </div>

<div class="home-page">
      <!-- Profile Section -->
      <div class="profile">
        <h1>Users </h1>
    <br>

        <q-table
          :rows="members"
          :columns="columns"
          row-key="id"
        >
          <template v-slot:body-cell-actions="props">
            <q-td :props="props">
              <div class="action-buttons">
                <q-btn flat round dense color="primary" @click="editMember(props.row.id)" label="Edit" />
                <q-space size="sm" />
                <q-btn flat round dense color="negative" @click="deleteMember(props.row.id)" label="Delete" />
              </div>
            </q-td>
          </template>
        </q-table>
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
  </div>
</template>



<style scoped>

.c {
  background-color: #D3D3D3; 
  float:left;
clear:none; 
}

.transparent-navbar {
  padding-top: 20px;
  background-color: transparent; 
  width: calc(100% - 40px); 
  z-index: 1;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.navbar-input {
  flex: 1;
  margin: 0 10px; 
}


.container {
width: 105vw;

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
  margin-left: 20em;
  max-width: 100px;  
}




.footer {
  background-color: #ccc;
  text-align: center; 
  
  display: flex; 
  justify-content: space-between; 
  align-items: flex-end; 
  margin-top: 0px;
  padding-top: 0px;
  float: left;
  clear: none;
  width: 100vw;
  margin-left: -50px;
  padding-left: 10px;
  padding-right: 10px;
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
const api = 'http://localhost:8000/individual/enterprise/one/'

export default {
  data() {
    return {
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
      members: [
        { id: 1, firstname: 'mohamed', lastname: 'chokri', email: 'mohamed.chokri@esprit.tn' },
        { id: 2, firstname: 'mariem', lastname: 'ben amor', email: 'mariembenamor@gmail.com' },
      ],
      columns: [
        { name: 'id', required: true, label: 'ID', align: 'left', field: 'id', sortable: true },
        { name: 'firstname', required: true, label: 'First Name', align: 'left', field: 'firstname', sortable: true },
        { name: 'lastname', required: true, label: 'Last Name', align: 'left', field: 'lastname', sortable: true },
        { name: 'email', required: true, label: 'Email', align: 'left', field: 'email', sortable: true },
        {
          name: 'actions',
          label: 'Actions',
          field: 'actions',
          align: 'left',
        },
      ],
    };
  },
  mounted() {
      this.fetchData();
    },
  methods: {
  modify(){
    this.$router.push('/modify_enter/'+this.$route.params.id);
  },
    async fetchData() {
      try {
        const response = await axios.get(api+ this.$route.params.id);
        const data = response.data;

        this.formData.id  = data.id;
        this.formData.name  = data.name;
        this.formData.fiscalNum = data.fiscalNum;
        this.formData.user.email = data.responsableUser.email;
        this.formData.user.id = data.responsableUser.id;
        this.formData.user.firstname = data.responsableUser.firstname;
        this.formData.user.lastname = data.responsableUser.lastname;
        console.log('API Response:', data);

      } catch (error) {
        console.error('Error fetching data from the API:', error);
      }
    },
    editMember(memberId) {
      console.log(memberId)
    },
    deleteMember(memberId) {
      console.log(memberId)
    },
    addMember() {
      console.log()
        this.$router.push('/add_aff/'+this.formData.user.id + '/' + this.formData.id);
    },
  },
};
</script>
