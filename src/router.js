import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/inicio',
            name: 'inicio',
            component: function () {
                return import(/* webpackChunkName: "about" */ './views/Inicio')
            }
        },
        {
            path: '/profesores',
            name: 'profesores',
            component: function () {
                return import(/* webpackChunkName: "about" */ './views/Profesores')
            }
        },
      {
        path: '/alumnos',
        name: 'alumnos',
        component: function () {
          return import(/* webpackChunkName: "about" */ './views/Alumnos')
        }
      },
      {
        path: '/clases',
        name: 'clases',
        component: function () {
          return import(/* webpackChunkName: "about" */ './views/Clases')
        }
      },
      {
        path: '/',
        name: 'login',
        component: function () {
          return import(/* webpackChunkName: "about" */ './views/Login')
        }
      },
      {
        path: '/mantenimiento',
        name: 'mantenimiento',
        component: function () {
          return import(/* webpackChunkName: "about" */ './views/Mantenimiento')
        }
      }
    ]
})
