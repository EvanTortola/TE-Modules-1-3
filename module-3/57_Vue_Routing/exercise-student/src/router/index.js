import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home';
import { component } from 'vue/types/umd';
import MyBooks from '@/views/MyBooks';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },

  {
    path: '/myBooks',
    name: 'reading-list',
    component: ReadingList
  }

];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
