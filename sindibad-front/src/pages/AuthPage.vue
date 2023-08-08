<template>
  <q-page padding>
    HELLO CALLBACK
  </q-page>
</template>

<script setup lang="ts">
 import { onMounted } from 'vue';
import {userManager} from '../boot/oidc-client';
 onMounted(()=>{
  console.log('REDIRECT CALLBACK')
        userManager.signinRedirectCallback().then((user)=>{
          console.log(user);
        })
 })

</script>
