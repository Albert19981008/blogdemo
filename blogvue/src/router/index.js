import Vue from 'vue'
import Router from 'vue-router'
import HelloWord from '@/components/HelloWorld'
import Value from '@/components/Value'
import Home from '@/components/Home'
import Topic from '@/components/Topic'

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
