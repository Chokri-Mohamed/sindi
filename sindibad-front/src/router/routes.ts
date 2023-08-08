import { RouteRecordRaw } from 'vue-router';

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
 
    { path: '', component: () => import('pages/AdvertPage.vue') },
    { path: '/User', component: () => import('pages/UserAccountPage.vue') },
   { path: '/login', component: () => import('pages/LoginPage.vue') },
   { path: '/auth', component: () => import('pages/AuthPage.vue') }
  ],
  },
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue'),
  },
];

export default routes;
