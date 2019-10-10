import Vue from 'vue'
import Router from 'vue-router'
import Value from '@/components/Value'
import Home from '@/components/Home'
import Topic from '@/components/Topic'
import Login from '@/components/Login'

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/login',
            name: '',
            component: Login,
            hidden: true,
        },
        {
            path: '/home',
            name: '',
            component: Home,
            hidden: true,
            children: [
                {
                    path: 'value',
                    name: '价值观管理',
                    component: Value,
                    meta: {
                        keepAlive: true
                    }
                },
                {
                    path: 'topic',
                    name: '话题管理',
                    component: Topic,
                    meta: {
                        keepAlive: true
                    }
                }
            ]
        }
    ]
})
