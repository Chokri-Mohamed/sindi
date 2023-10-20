<template>
  <q-page
    class="window-height window-width row justify-center items-center"
    style="background: linear-gradient(#858488, #77767b);"
  >

    <div class="column q-pa-lg">
      <div class="row">
        <q-card square class="shadow-24" style="width:500px;height:605px;">
          <q-card-section class="white">
            <h4 class="text-h5 text-black q-my-md">modify enterprise</h4>
            <div class="absolute-bottom-right q-pr-md" style="transform: translateY(50%);">
              <q-btn fab icon="close" :href="'enter/'+$route.params.id" color="red-14" />

            </div>
          </q-card-section>
          <q-card-section>
            <q-form class="q-px-sm q-pt-xl q-pb-lg" @submit="submitForm">
              <q-input square clearable type="title" label="nom" v-model="formData.name">
              </q-input>
              <br>
              <q-input square clearable type="title" label="numf" v-model="formData.numf">
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


const api_get = 'http://localhost:8000/individual/enterprise/one/'


import axios from 'axios';

export default {
  data() {
    return {
    
      formData: {
        name: '',
        numf: ''
      }
    };
  },
  mounted() {
    this.fetchData();
  },
  methods: {
    async fetchData() {
      console.log(api_get + this.$route.params.id)
      try {
        const response = await axios.get(api_get + this.$route.params.id);
        const data = response.data;

        this.formData.numf = data.fiscalNum;
        this.formData.name = data.name;

        console.log('API Response:', data);
      } catch (error) {
        console.error('Error fetching data from the API:', error);
      }
    },
    async submitForm() {
      const requestData = {
        name: this.formData.name,
        fiscalNum: this.formData.numf
      };

      try {
        // sending the request
        const response = await axios.put('http://localhost:8000/individual/enterprise/2/'+ this.$route.params.id, requestData);
        console.log('Response from API:', response.data);
        this.$router.push('/enter/'+this.$route.params.id);

      } catch (error) {
        console.error('Error:', error);
      }
    }
  }
};
</script>

