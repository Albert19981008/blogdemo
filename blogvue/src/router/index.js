import Vue from 'vue'
import Router from 'vue-router'
import Value from '@/components/Value'
import Home from '@/components/Home'
import Topic from '@/components/Topic'
import Login from '@/components/Login'
import ArticleManagement from '@/components/ArticleManagement'
import ArticleSearch from '@/components/ArticleSearch'
import ArticleDetail from '@/components/ArticleDetail'
import ArticleWrite from '@/components/ArticleWrite'

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
                },
                {
                    path: 'article_management',
                    name: '文章管理',
                    component: ArticleManagement,
                    meta: {
                        keepAlive: true
                    }
                },
                {
                    path: 'article_search',
                    name: '文章浏览',
                    component: ArticleSearch,
                    meta: {
                        keepAlive: true
                    }
                },
                {
                    path: 'article_detail',
                    name: '文章详情',
                    component: ArticleDetail,
                    meta: {
                        keepAlive: true
                    }
                },
                {
                    path: 'article_write',
                    name: '新增文章',
                    component: ArticleWrite,
                    meta: {
                        keepAlive: true
                    }
                }
            ]
        }
    ]
})
