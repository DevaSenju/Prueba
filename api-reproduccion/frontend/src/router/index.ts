import { createRouter, createWebHistory } from 'vue-router'
//import HomeView from '../views/HomeView.vue'  // Si decides mantener la vista principal
import Formulario from '../views/Formulario.vue' // Vista para agregar canción
import FormularioLista from '../views/FormularioLista.vue' // Vista para agregar lista

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: '/formulario',  // Redirige directamente al formulario para agregar canción
    },
    {
      path: '/about',
      name: 'Listas',
      component: FormularioLista
    },
    {
      path: '/formulario',
      name: 'formulario',
      component: Formulario,  // Aquí redirige a la vista para agregar canciones
    },
    {
      path: '/formulario-lista',
      name: 'formulario-lista',
      component: FormularioLista, // Vista para agregar listas
    }
  ],
})

export default router
