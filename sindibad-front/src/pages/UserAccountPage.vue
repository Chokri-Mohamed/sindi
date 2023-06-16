<template>
    <q-page
      class="window-height window-width row justify-center items-center"
      style="background: linear-gradient(#858488, #77767b);"
    >

      <div class="column q-pa-lg">
        <div class="row">
          <q-card square class="shadow-24" style="width:500px;height:605px;">
            <q-card-section class="white">
              <h4 class="text-h5 text-black q-my-md">Registration</h4>
              <div class="absolute-bottom-right q-pr-md" style="transform: translateY(50%);">
                <q-btn fab icon="close" color="red-14" />
              </div>
            </q-card-section>
            <q-card-section>
              <q-form class="q-px-sm q-pt-xl q-pb-lg" @submit="onSubmit">
                
                <q-input square clearable v-model="firstname" type="firstname" label="Firstname">
                  <template v-slot:prepend>
                    <q-icon name="person" />
                  </template>
                </q-input>
                <q-input square clearable v-model="lastname" type="lastname" label="Lastname">
                  <template v-slot:prepend>
                    <q-icon name="person" />
                  </template>
                </q-input>
                <q-input square clearable v-model="email" type="email" label="Email">
                  <template v-slot:prepend>
                    <q-icon name="email" />
                  </template>
                </q-input>
                <q-input square clearable v-model="password" type="password" label="Password">
                  <template v-slot:prepend>
                    <q-icon name="lock" />
                  </template>
                </q-input>
               
                <div class="q-pa-md">
                  <div class="q-gutter-sm">
                    <q-radio v-model="gender" val="Female" label="Female" />
                    <q-radio v-model="gender" val="Male" label="Male" />
                  </div>
                

                </div>
                
                <q-card-actions class="q-px-lg">
              <q-btn label="Register" unelevated  type="submit" size="lg" color="green" class="full-width text-white" />
            </q-card-actions>
                
              </q-form>
            </q-card-section>
           
            <q-card-section class="text-center q-pa-sm">
              <p class="text-grey-6">Return to login</p>
            </q-card-section>
          </q-card>
        </div>
      </div>
    </q-page>
  </template>

<script>
import { ref } from 'vue'
import  {api}  from 'boot/axios'
export default {
  setup () {
    const firstname=ref(null)
    const lastname=ref(null)
    const email=ref(null)
    const password=ref(null)
    const gender=ref(null)

    return {
        firstname,
        lastname,
        email,
        password,
        gender,
      onSubmit () {
            let data={
                firstname:firstname.value,
                lastname:lastname.value,
                email:email.value,
                gender:gender.value,
                password:password.value
            }
           api.post('individual/users',data).then(res=>console.log(res)).catch(err=>console.log(err))
          
      },
    }
  }
}
</script>