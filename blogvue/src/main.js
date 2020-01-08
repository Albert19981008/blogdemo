import Vue from 'vue'
import App from './App.vue'
import router from './router'
// eslint-disable-next-line no-unused-vars
import axios from 'axios'
import '../theme/index.css'
import store from './store'


Vue.config.productionTip = false;


import {getRequest} from "./util/api";
import {postRequest} from "./util/api";
import {putRequest} from "./util/api";
import {deleteRequest} from "./util/api";


Vue.prototype.getRequest = getRequest;
Vue.prototype.postRequest = postRequest;
Vue.prototype.putRequest = putRequest;
Vue.prototype.deleteRequest = deleteRequest;

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(ElementUI);

router.beforeEach((to, from, next) => {
    if (to.fullPath === '/') {
        next({
            path: '/login',
        });
    } else {
        next();
    }
});
//
// router.beforeEach((to, from, next) => {
//     /* 页面title */
//     if (to.meta.title) {
//         document.title = to.meta.title
//     }
//     /* 判断该路由是否需要登录权限 */
//     if (to.matched.some(record => record.meta.requireAuth)) {
//         //是否登录
//         axios.post('/home/user/isLogin')
//             .then(function (response) {
//                 if (response.data.code === 0) {
//                     //未登录
//                     if (response.data.data.online === 0) {
//                         next({
//                             path: '/login',
//                         })
//                     } else {
//                         //已登录
//                         next()
//                     }
//                 }
//             })
//             // eslint-disable-next-line no-unused-vars
//             .catch(function (error) {
//                 // Toast(error.data.msg);
//             });
//     }
//     next();
// });


new Vue({
    render: h => h(App),
    router,
    store
}).$mount('#app');
