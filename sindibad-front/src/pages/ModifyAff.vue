<template>
  <q-page
    class="window-height window-width row justify-center items-center"
    style="background: linear-gradient(#858488, #77767b);"
  >

    <div class="column q-pa-lg">
      <div class="row">
        <q-card square class="shadow-24" style="width:500px;height:605px;">
          <q-card-section class="white">
            <h4 class="text-h5 text-black q-my-md">modify affiliated user</h4>
            <div class="absolute-bottom-right q-pr-md" style="transform: translateY(50%);">
              <q-btn fab icon="close" href="/home" color="red-14" />
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
import axios from 'axios'; 

const api = 'http://localhost:8000/individual/enterprise/users/'

export default {
  data() {
    return {
      formData: {
        email: this.$route.params.email,
        firstname: this.$route.params.firstname,
        lastname: this.$route.params.lastname,
      }
    };
  },
  methods: {
    async submitForm() {
      const requestData = {
        email: this.formData.email,
        firstname: this.formData.firstname,
        lastname: this.formData.lastname
      };

      try {
        // console.log(this.formData);
        // console.log(api + this.$route.params.respons + '/' + this.$route.params.enter + '/' + this.$route.params.user)
        // sending the request
        // const response = await axios.post(api + this.$route.params.respons + '/' + this.$route.params.enter + '/' + this.$route.params.user, requestData);
        // console.log('Response from API:', response.data);
        this.$router.push('/enter/'+this.$route.params.enter);

      } catch (error) {
        console.error('Error:', error);
      }
    }
  }
};
</script>











