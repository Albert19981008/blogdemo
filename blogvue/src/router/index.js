import Vue from 'vue'
import Router from 'vue-router'
import HelloWord from '@/components/HelloWorld'
import Movie from '@/components/Movie'
import Movies from '@/components/Movies'

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/welcome',
            name: '登录',
            hidden: true,
            component: HelloWord
        },
        {
            path: '/movie',
            name: '',
            component: Movie,
            hidden: true
        },
        {
            path: '/movies',
            name: '',
            component: Movies,
            hidden: true
        }
    ]
})
