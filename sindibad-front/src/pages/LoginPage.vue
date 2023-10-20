<template>
  <div>
    <button @click="login">Login</button>
  </div>
</template>

<script>
import oidcConfig from '../boot/oidc-client'; 
import { UserManager } from 'oidc-client-ts';
import {userManager} from '../boot/oidc-client';
export default {
  methods: {
    test() {
      console.log(userManager.settings); // Add this line to log 'hhh'
      fetch('http://localhost:9000/', { method: 'GET', headers: { 'Content-Type': 'application/json', } }).then(response => { console.log(response); }).catch(error => { console.error(error); });
      // userManager.signinRedirect()
    },
    async login() {
      // Redirect the user to the OIDC provider for login
      await new UserManager(oidcConfig).signinRedirect();
    },
  },
  mounted() {
    this.test(); // Call the test() function when the component is mounted
    this.login(); 
  }
}
</script>
../boot/oidc-client../boot/oidc-client