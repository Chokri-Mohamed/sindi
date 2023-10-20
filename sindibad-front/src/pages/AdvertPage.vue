<template>
  <q-page
    class="window-height window-width row justify-center items-center"
    style="background: linear-gradient(#858488, #77767b);"
  >

    <div class="column q-pa-lg" style="height:950px;">
      <div class="row">
        <q-card square class="shadow-24" style="width:500px;height:850px;">
          <q-card-section class="white">
            <h4 class="text-h5 text-black q-my-md">Add Advert</h4>
            <div class="absolute-bottom-right q-pr-md" style="transform: translateY(50%);">
              <q-btn fab icon="close" href="/home" color="red-14" />
            </div>
          </q-card-section>
          <q-card-section>
            <q-form class="q-px-sm q-pt-xl q-pb-lg" @submit="submitForm">
              <q-input square clearable type="title" label="title" v-model="formData.title">
              </q-input>
              <br>
              <q-input square clearable type="textarea" label="description" v-model="formData.description">
              </q-input>

              <!-- Add the select element -->
              <q-select
                square
                label="Catégories"
                v-model="selectedOption"
                :options="selectOptions"
              ></q-select>

              <br>
              <div id="map" style="height: 200px;"></div>
              <br>
              <q-input square clearable type="title" label="gouvernorat" v-model="state" disable="true">
              </q-input>

              <br>

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
import axios from 'axios'; 
import L from 'leaflet'; // Import Leaflet
import 'leaflet/dist/leaflet.css';


// import markerIconUrl from '../public/marker-icon.png'; // Update the path if needed
import markerIconUrl from '../assets/marker-icon.png';



const api = 'http://localhost:8000/individual/adverts?user=2'

export default {
  data() {
    return {
      markers: [], 
      state:'',


      selectedOption: '', 
      selectOptions: [
        { label: 'Véhicule', value: '1' },
        { label: 'Immobilière', value: '2' }
      ],
      formData: {
        title: '',
        description: '',
      }
    };
  },
  methods: {
    async submitForm() {
      const requestData = {
        title: this.formData.title,
        description: this.formData.description,
        advert_type: this.selectedOption.value
      };

      try {
        //request
        console.log(requestData)
        const response = await axios.post(api, requestData);
        console.log('Response from API:', response.data);
        this.$router.push('/homeu');

      } catch (error) {
        console.error('Error:', error);
      }
    }
  },
  mounted() {
    // Initialize Leaflet map after the component is mounted
    this.map = L.map('map').setView([36.8065, 10.1815], 13); // Set your initial coordinates and zoom level

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png').addTo(this.map);

    // Add a click event listener to capture coordinates when the map is clicked
this.map.on('click', async (e) => {
  console.log('eee')
  const latlng = e.latlng; // Get the clicked coordinates

  // Create a marker with the locally hosted marker icon
  const marker = L.marker(latlng, { icon: L.icon({ iconUrl: markerIconUrl }) }).addTo(this.map);

  // Add the marker to the markers array
  this.markers.push(marker);

  // You can also do something with the clicked coordinates if needed
  console.log('Chosen Coordinates:', latlng.lat);
  console.log('Chosen Coordinates:', latlng.lng);
  const apiKey = '2d2abdbb98bf48089f4eca570a66d650'
  const apiUrl = 'https://api.opencagedata.com/geocode/v1/json' + '?q=' + latlng.lat + '+' + latlng.lng+ '&key=' + apiKey;

  const response = await axios.get(apiUrl);
  console.log(response.data.results[0].components.state);
  this.state = response.data.results[0].components.state;

});

  }

};
</script>
<style scoped>

</style>