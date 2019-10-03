import Vue from 'vue'
import App from './App.vue'
import router from './router'


Vue.config.productionTip = false

new Vue({
    render: h => h(App),
    router,
}).$mount('#app')

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
