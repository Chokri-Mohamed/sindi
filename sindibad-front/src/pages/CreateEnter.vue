<template>
  <q-page
    class="window-height window-width row justify-center items-center"
    style="background: linear-gradient(#858488, #77767b);"
  >

    <div class="column q-pa-lg">
      <div class="row">
        <q-card square class="shadow-24" style="width:500px;height:605px;">
          <q-card-section class="white">
            <h4 class="text-h5 text-black q-my-md">add enterprise</h4>
            <div class="absolute-bottom-right q-pr-md" style="transform: translateY(50%);">
              <q-btn fab icon="close" href="/home" color="red-14" />
            </div>
          </q-card-section>
          <q-card-section>
            <q-form class="q-px-sm q-pt-xl q-pb-lg" @submit="submitForm">
              <q-input square clearable type="title" label="name" v-model="formData.name">
              </q-input>
              <br>
              <q-input square clearable type="title" label="num fiscal" v-model="formData.numf">
              </q-input>

              <q-card-actions class="q-px-lg">
                <q-btn label="Add" unelevated type="submit" size="lg" color="green" class="full-width text-white" />
              </q-card-actions>

            </q-form>
          </q-card-section>
        </q-card>
      </div>
    </div>
  </q-page>
</template>

<script>
import axios from 'axios'; 


const api = 'http://localhost:8000/individual/enterprise/'
const user = '2'

export default {
  data() {
    return {
      formData: {
        name: '',
        numf: ''
      }
    };
  },
  methods: {
    async submitForm() {
      const requestData = {
        name: this.formData.name,
        fiscalNum: this.formData.numf,
      };

      try {
        console.log(requestData);
        console.log(api+user)
        // sending the request
        const response = await axios.post(api + user, requestData);
        console.log('Response from API:', response.data);
        this.$router.push('/enter/12');

      } catch (error) {
        console.error('Error:', error);
      }
    }
  }
};
</script>
