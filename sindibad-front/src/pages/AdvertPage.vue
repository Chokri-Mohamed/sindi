<template>
<div class="q-pa-md">
  <h4 class="text-h5 text-black q-my-md">Add Advert</h4>
  
    <div class="q-gutter-y-md column" @submit="onSubmit" style="max-width: 500px">
    
      <q-input
        ref="title"
        v-model="title"
        filled
        clearable
        color="purple-12"
        label="Title"
        :shadow-text="inputShadowText"
        @keydown="processInputFill"
        @focus="processInputFill"
      />

      

      <q-input
        ref="description"
        v-model="description"
        filled
        clearable
        type="textarea"
        color="red-12"
        label="Description"
        :shadow-text="textareaShadowText"
        @keydown="processTextareaFill"
        @focus="processTextareaFill"
      />
      <q-btn label="Add" unelevated  type="submit" size="lg" color="green" class="full-width text-white" />

    </div>
  </div>
  </template>
  
  <script>
import { ref } from 'vue'
// import  {api}  from 'boot/axios'
export default {
  setup () {
    
    const title=ref(null)
    const titleRef=ref(null)

    const description=ref(null)
    const descriptionRef=ref(null)
    
    const accept = ref(false)

  
   return {
    title,
    titleRef,

    description,
    descriptionRef, 

    accept,


        onSubmit () {
            let data={
              title:title.value,
              description:description.value
            }
            //api.post('individual/adverts',data).then(res=>console.log(res)).catch(err=>console.log(err))
            console.log(data)
        },
    }
  } 
} 
  </script>  
  