<template>
    <q-page
      class="window-height window-width row justify-center items-center"
      style="background: linear-gradient(#858488, #77767b);"
    >

      <div class="column q-pa-lg">
        <div class="row">
          <q-card square class="shadow-24" style="width:500px;height:605px;">
            <q-card-section class="white">
              <h4 class="text-h5 text-black q-my-md">Add Advert</h4>
              <div class="absolute-bottom-right q-pr-md" style="transform: translateY(50%);">
                <q-btn fab icon="close" color="red-14" />
              </div>
            </q-card-section>
            <q-card-section>
              <q-form class="q-px-sm q-pt-xl q-pb-lg" @submit="onSubmit">
                
                <q-input square clearable v-model="title" type="title" label="title"  >
                  
                </q-input>
                <br>
                <q-input square clearable v-model="description" type="textarea" label="description" > 
                  
                </q-input>
                
                
                <q-card-actions class="q-px-lg">
              <q-btn label="Add" unelevated  type="submit" size="lg" color="green" class="full-width text-white" />
             </q-card-actions>
                
             </q-form>
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
    
    const title=ref(null)

    const description=ref(null)
    
    const accept = ref(false)

  
   return {
    title,

    description,

    accept,


        onSubmit () {
            let data={
              title:title.value,
              description:description.value
            }
            api.post('individual/adverts?user=1',data).then(res=>console.log(res)).catch(err=>console.log(err))
            //console.log(data)
        },
    }
  } 
} 
  </script>  
  