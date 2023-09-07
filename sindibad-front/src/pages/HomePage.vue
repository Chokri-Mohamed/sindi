<template>
  <q-layout view="hHh lpR fFf">

    <q-header elevated class="bg-grey-8 text-white" height-hint="98">
      <q-toolbar>

        <q-toolbar-title>
          <q-avatar>
            <img src="../assets/Sindibad.png">
          </q-avatar>
          Sindibad
        </q-toolbar-title>
      </q-toolbar>

      <q-tabs align="right">
        <q-route-tab to="/User" label="Inscription"  />
        <q-route-tab to="/login" label="Connexion" />
        
      </q-tabs>
      
    </q-header>
   
        
    <q-page-container>
      <br>
      <q-tabs align="right">
        <q-btn color="deep-orange" text-color="white" rounded href="/advert">
          <q-icon left name="add" />
          <div>Déposer une annonce</div>
          </q-btn>
      </q-tabs>
  <div>   
  <div class="q-pa-md row items-start q-gutter-md">
    <!-- <q-card class="my-card">
      <img src="https://cdn.quasar.dev/img/mountains.jpg">

      <q-card-section>
        <div class="text-h6">Our Changing Planet</div>
        <div class="text-subtitle2">by John Doe</div>
      </q-card-section>

      <q-card-section class="q-pt-none">
        {{ lorem }}
      </q-card-section>
    </q-card> -->

    <q-card class="my-card">
      <q-img src="https://cdn.quasar.dev/img/parallax2.jpg">
        <div class="absolute-bottom text-subtitle2 text-center">
          Title
        </div>
      </q-img>
    </q-card>

    <q-card class="my-card">
      <q-img src="https://cdn.quasar.dev/img/parallax2.jpg">
        <div class="absolute-bottom text-h6">
          Title
        </div>
      </q-img>

      <q-card-section>
        {{ lorem }}
      </q-card-section>
    </q-card>

    <q-card class="my-card">
      <q-img src="https://cdn.quasar.dev/img/parallax2.jpg">
        <div class="text-subtitle2 absolute-top text-center">
          Title
        </div>
      </q-img>
    </q-card>

    <q-card class="my-card">
      <q-img src="https://cdn.quasar.dev/img/parallax2.jpg">
        <div class="text-h5 absolute-bottom text-right">
          Title
        </div>
      </q-img>
    </q-card>

    <q-card class="my-card">
      <q-item>
        <q-item-section avatar>
          <q-avatar>
            <img src="https://cdn.quasar.dev/img/avatar2.jpg">
          </q-avatar>
        </q-item-section>

        <q-item-section>
          <q-item-label>Title</q-item-label>
          <q-item-label caption>Subhead</q-item-label>
        </q-item-section>
      </q-item>

      <img src="https://cdn.quasar.dev/img/parallax2.jpg">
    </q-card>

    <!-- <q-card class="my-card">
      <q-img src="https://cdn.quasar.dev/img/parallax2.jpg">
        <div class="absolute-bottom">
          <div class="text-h6">Our Changing Planet</div>
          <div class="text-subtitle2">by John Doe</div>
        </div>
      </q-img>

      
    </q-card> -->
  </div>
</div> 

      <router-view />
    </q-page-container>

    <q-footer reveal elevated class="bg-grey-8 text-white">
      <q-toolbar>
        <q-toolbar-title>
          <q-avatar>
            <img src="../assets/Sindibad.png">
          </q-avatar>
          <div>Sindibad</div>
        </q-toolbar-title>
      </q-toolbar>
    </q-footer>

  </q-layout>
</template>