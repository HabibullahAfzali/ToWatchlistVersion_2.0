import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import EditCard from '../components/EditCard.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Homeview',
      component: HomeView
    },
    {
      path: '/edit/:id',
      name:'EditCard',
      component: EditCard 
    }
  ]
})

export default router
