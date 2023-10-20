<template>
    <q-page
      class="window-height window-width row justify-center items-center"
      style="background: linear-gradient(#858488, #77767b);"
    >
  
      <div class="column q-pa-lg">
        <div class="row">
          <q-card square class="shadow-24" style="width:500px;height:605px;">
            <q-card-section class="white">
              <h4 class="text-h5 text-black q-my-md">Modify User</h4>
              <div class="absolute-bottom-right q-pr-md" style="transform: translateY(50%);">
                <q-btn fab icon="close" :href="'/Userget/'+$route.params.id" color="red-14" />
              </div>
            </q-card-section>
            <q-card-section>
              <q-form class="q-px-sm q-pt-xl q-pb-lg" @submit="submitForm">
                <q-input square clearable type="title" label="firstname" v-model="formData.firstname">
                </q-input>
                <br>
                <q-input square clearable type="title" label="lastname" v-model="formData.lastname">
                </q-input>
                  <br>
                <q-input square clearable type="title" label="email" v-model="formData.email">

                </q-input>
  
            
  
                <q-card-actions class="q-px-lg">
                  <q-btn label="modify" unelevated type="submit" size="lg" color="green" class="full-width text-white" />
                </q-card-actions>
  
              </q-form>
            </q-card-section>
          </q-card>
        </div>
      </div>
    </q-page>
  </template>
  
  <script>
  
  
  const api_put = 'http://localhost:8000/individual/users/'
  // const api_put = 'https://8f33-197-240-97-177.ngrok.io/individual/users/'
  
  import axios from 'axios';
  
  export default {
    data() {
      return {
      
        formData: {
          firstname: '',
          lastname: '',
          email:''
        }
      };
    },
    mounted() {
      this.fetchData();
    },
    methods: {
      async fetchData() {
        console.log(api_put + this.$route.params.id)
        try {
          const response = await axios.get(api_put + this.$route.params.id);
          const data = response.data;
          console.log(response.data)
  
          this.formData.firstname = data.firstname;
          this.formData.lastname = data.lastname;
          this.formData.email = data.email;

  
          console.log('API Response:', data);
        } catch (error) {
          console.error('Error fetching data from the API:', error);
        }
      },
      async submitForm() {
        const requestData = {
          firstname: this.formData.firstname,
          lastname: this.formData.lastname,
          email: this.formData.email
        };
  
        try {
          // sending the request
          const response = await axios.put(api_put + this.$route.params.id, requestData);
          console.log('Response from API:', response.data);
          this.$router.push('/userget/'+ this.$route.params.id);
  
        } catch (error) {
          console.error('Error:', error);
        }
      }
    }
  };
  </script>
  
   