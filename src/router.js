import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);

//const router = new Router({
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
            path: '/mantenimientoT',
            name: 'mantenimientoT',
            component: function () {
                return import(/* webpackChunkName: "about" */ './views/Mantenimiento_tarifas')
            }
        },
        {
            path: '/mantenimientoA',
            name: 'mantenimientoA',
            component: function () {
                return import(/* webpackChunkName: "about" */ './views/Mantenimiento_asignaturas')
            }
        },
        {
            path: '/mantenimientoC',
            name: 'mantenimientoC',
            component: function () {
                return import(/* webpackChunkName: "about" */ './views/Mantenimiento_cursos')
            }
        }
    ]
});

//Router.beforeEach((to, from, next) => {
    // ...
//});

//export default Router;

