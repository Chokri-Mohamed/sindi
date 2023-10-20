import { RouteRecordRaw } from 'vue-router';

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
    { path: '/t', component: () => import('pages/TestPage.vue') },
      //original home
    { path: '/home', component: () => import('pages/HomePage.vue') },
    //admin
    { path: '/homeA', component: () => import('pages/HomePageAdmin.vue') },
    //enterprise home
    { path: '/homeE', component: () => import('pages/HomePageEnter.vue') },
    //user home
    { path: '/homeU', component: () => import('pages/HomePageUser.vue') },


    { path: '/users', component: () => import('pages/UsersPage.vue') },

 
    { path: '/advert', component: () => import('pages/AdvertPage.vue') }, 

    { path: '/modify_advert/:id', component: () => import('pages/AdvertPageModify.vue') },
    
    { path: 'd_advert/:id', component: () => import('pages/SinglePage.vue') }, 

    { path: 'myads/:id', component: () => import('pages/MyAds.vue') }, 

    { path: 'd_advertA/:id', component: () => import('pages/SinglePageA.vue') }, 
    { path: 'd_advertUA/:id', component: () => import('pages/SinglePageUA.vue') }, 

    { path: '/User', component: () => import('pages/UserAccountPage.vue') },
    { path: '/Userget/:id', component: () => import('pages/UserGetPage.vue') },
    { path: '/login', component: () => import('pages/LoginPage.vue') },
    { path: '/auth', component: () => import('pages/AuthPage.vue') },
    { path: '/modifyUser/:id', component: () => import('pages/ModifyUserPage.vue') },


    { path: '/search/:q', component: () => import('pages/SearchPage.vue') },

    { path: '/enter/:id', component: () => import('pages/EnterPage.vue') }, //done minus the members
    { path: '/create_enter', component: () => import('pages/CreateEnter.vue') },
    { path: '/modify_enter/:id', component: () => import('pages/ModifyEnter.vue') }, 

    //affiliated users

    { path: '/add_aff/:user/:enter', component: () => import('pages/add_aff.vue') }, 
    { path: '/modify_aff/:respons/:enter/:user/:email/:firstname/:lastname', component: () => import('pages/ModifyAff.vue') } 
  ],
  },
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue'),
  },
];

export default routes;
