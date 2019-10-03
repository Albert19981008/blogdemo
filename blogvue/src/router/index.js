import Vue from 'vue'
import Router from 'vue-router'
import HelloWord from '@/components/HelloWorld'
import Values from '@/components/Values'

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
            path: '/values',
            name: '',
            component: Values,
            hidden: true
        }
    ]
})
