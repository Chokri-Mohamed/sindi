<template>
  <q-page padding>
    HELLO CALLBACK

  </q-page>

</template>

<script setup lang="ts">
 import { onMounted } from 'vue';
import {userManager} from '../boot/oidc-client';
// import { useRouter } from 'vue-router'; 
import { useRouter } from 'vue-router'; 


// const route = useRoute();
const router = useRouter();

 onMounted(()=>{
  console.log('REDIRECT CALLBACK')
        userManager.signinRedirectCallback().then((user)=>{
          
          console.log(user.profile.sub);


          if(user.profile.sub !='admin'){
            router.push('/homeU')
          }
        })
 })

</script>
