import VueResource from 'vue-resource'

import App from "./pages/App.vue";

// Vue.use(VueResource);
//
// var resource = Vue.resource('room{/id}');
//
// // resource.get().then(response => {
// //
// //     response.json().then(data =>{
// //         console.log(data.subject)
// //     })
// //
// // })
//


new Vue({
    el: '#app',
    template: '<App/>',
    components: { App },
})