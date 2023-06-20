<template>
    <q-page
      class="window-height window-width row justify-center items-center"
      style="background: linear-gradient(#858488, #77767b);"
    >

      <div class="column q-pa-lg">
        <div class="row">
          <q-card square class="shadow-24" style="width:500px;height:705px;">
            <q-card-section class="white">
              <h4 class="text-h5 text-black q-my-md">Registration</h4>
              <div class="absolute-bottom-right q-pr-md" style="transform: translateY(50%);">
                <q-btn fab icon="close" color="red-14" />
              </div>
            </q-card-section>
            <q-card-section>
              <q-form class="q-px-sm q-pt-xl q-pb-lg" @submit="onSubmit">
                
                <q-input square clearable ref="firstnameRef" filled v-model="firstname" type="firstname" label="Firstname *" :rules="firstnameRules" >
                  <template v-slot:prepend>
                    <q-icon name="person" />
                  </template>
                </q-input>
                <q-input square clearable ref="lastnameRef" filled v-model="lastname" type="lastname" label="Lastname *" :rules="lastnameRules"> 
                  <template v-slot:prepend>
                    <q-icon name="person" />
                  </template>
                </q-input>
                <q-input square clearable ref="emailRef" filled v-model="email" type="email" label="Email *" :rules="emailRules">
                  <template v-slot:prepend>
                    <q-icon name="email" />
                  </template>
                </q-input>
                <q-input square clearable ref="passwordRef" v-model="password" filled  label="Password *" :type="isPwd ?  'password' : 'text'" :rules="passwordRules" >

                 
                 <template v-slot:append>
                    <q-icon 
                        :name="isPwd ? 'visibility_off' : 'visibility'"
                        class="cursor-pointer"
                        @click="isPwd = !isPwd"/>
                        
                </template>
                </q-input>
                
                <q-card-actions class="q-px-lg">
              <q-btn label="Register" unelevated  type="submit" size="lg" color="green" class="full-width text-white" />
            </q-card-actions>
                
              </q-form>
            </q-card-section>
           
            <!-- <q-card-section class="text-center q-pa-sm">
              <p class="text-grey-6">Return to login</p>
            </q-card-section> -->
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
    const firstnameRef=ref(null)
    
    const lastname=ref(null)
    const lastnameRef=ref(null)
    
    const email=ref(null)
    const emailRef=ref(null)
    
    const password=ref(null)
    const passwordRef=ref(null)

    const accept = ref(false)


    return {
        firstname,
        firstnameRef,
        firstnameRules: [
        val => (val && val.length > 0) || 'Please type something'],
        
        lastname,
        lastnameRef,
        lastnameRules: [
        val => (val && val.length > 0) || 'Please type something'],
       
        email,
        emailRef,
        emailRules: [
        val => (val && val.length > 0) || 'Please type something'],
        
        password,
        passwordRef,
        passwordRules:[ val => val && val.length > 3 || 'Please use minimum 3 characters'],
        isPwd: ref(true),

        accept,

      onSubmit () {
            let data={
                firstname:firstname.value,
                lastname:lastname.value,
                email:email.value,
                password:password.value
            }
            api.post('individual/users',data).then(res=>console.log(res)).catch(err=>console.log(err))
          //console.log(data)
      },
    }
  }
}
</script>