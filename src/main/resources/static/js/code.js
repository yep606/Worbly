import Vue from 'vue'
import App from "./pages/App.vue";
import './utils/resource'

new Vue({
    el: '#app',
    render: a => a(App)
})