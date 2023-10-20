<template>
  <q-page
    class="window-height window-width row justify-center items-center"
    style="background: linear-gradient(#858488, #77767b);"
  >

    <div class="column q-pa-lg">
      <div class="row">
        <q-card square class="shadow-24" style="width:500px;height:605px;">
          <q-card-section class="white">
            <h4 class="text-h5 text-black q-my-md">Add member</h4>
            <div class="absolute-bottom-right q-pr-md" style="transform: translateY(50%);">
              <q-btn fab icon="close" :href="'/enter/' + $route.params.enter" color="red-14" />
            </div>
          </q-card-section>
          <q-card-section>
            <q-form class="q-px-sm q-pt-xl q-pb-lg" @submit="submitForm">
              <q-input square clearable type="title" label="email" v-model="formData.email">
              </q-input>
              <br>
              <q-input square clearable type="title" label="firstname" v-model="formData.firstname">
              </q-input>

              <br>
              <q-input square clearable type="title" label="lastname" v-model="formData.lastname">
              </q-input>

              <q-input square clearable type="title" label="password" v-model="formData.password">
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

const api = 'http://localhost:8000/individual/enterprise/affiliate/'
import axios from 'axios'; 

export default {
  data() {
    return {
      formData: {
        email: '',
        firstname: '',
        lastname: '',
        password: ''
      }
    };
  },
  methods: {
    async submitForm() {
      const requestData = {
        email: this.formData.email,
        firstname: this.formData.firstname,
        lastname: this.formData.lastname,
        password: this.formData.password
      };

      try {
        console.log(api + this.$route.params.user + '/' + this.$route.params.enter)
        console.log(requestData)
        // sending the request
        const response = await axios.patch(api + this.$route.params.user + '/' + this.$route.params.enter, requestData);
        console.log('Response from API:', response.data);
        this.$router.push('/home');

      } catch (error) {
        console.error('Error:', error);
      }
    }
  }
};
</script>
