<template>
    <div >
    <div>this is page annonce</div>
    <!-- <table>
        <tr v-for="item in list" :key="item.id">
            <td>{{ item.title }}</td>
            <td>{{ item.description }}</td>
        </tr>
    </table>     -->
    </div>
  </template>
  
  <script setup>
  import { api } from 'boot/axios'
  api.get('api/get/1').then(Response=>console.log(Response))
 

  </script>  
  