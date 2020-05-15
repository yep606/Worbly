import {start} from './websocket/stomp';
import VueResource from 'vue-resource'

Vue.use(VueResource);

var resource = Vue.resource('room{/id}');

resource.get().then(response => {

    response.json().then(data =>{
        console.log(data.subject)
    })

})

Vue.component('message-form', {

    data: function() {
        return {
            text: '',
            id: '',
        }
    },

    props: ['messages', 'message'],
    template: '<div>' +
        '<input placeholder="Write a messsge" v-model="text" />'+
        '<button @click="save">Send</button>' +
        '<button @click="conn">Connection</button>'
        + '</div>',

    watch: {
        message: function(newValue){
            this.text = newValue.text;
            this.id = newValue.id;
        }
    },
    methods: {
        save: function(){
            var message = {text: this.text, id: this.id}
            if(this.id){ //update
                var index = this.messages.findIndex(elem => elem.id === this.id)
                this.messages.splice(index, 1, message);
                this.text = '';
                this.id ='';
            }
            else{ //adding
                this.messages.push({text: this.text, id: 55})
                this.text ='';
            }

        },

        conn: function(){
            start();
        }

    }
})

Vue.component('message-row', {
    props: ['messages', 'message', 'editMessage'],
    template: '<div>' +
        '{{message.text}} {{message.id}}' +
        '<button @click="edit">Edit</button>' +
        '</div>',

    methods: {

        edit: function(){
            this.editMessage(this.message);
        }

    }

})

Vue.component('message-list', {
    data: function(){

        return {
            message: null,
        }

    },
    props: ['messages'],
    template: '<div>' +
        '<message-row v-for="message in messages" :key="message.id"' +
        ':messages="messages" :message="message" :editMessage="editMessage">' +
        '</message-row>' +
        '<message-form :messages="messages" :message="message" />'
        + '</div>',

    methods: {

        editMessage: function(message){
            this.message = message;
        }

    }
});

new Vue({
    el: '#app',
    template: '<message-list :messages="messages"></message-list>',
    data: {
        messages: [
            {text: 'alex1', id:1},
            {text: 'alex2', id:2},
            {text: 'alex3', id:3}
        ],
    },
    methods: {
        addNewTodo: function () {
            this.todos.push({
                id: this.nextTodoId++,
                title: this.newTodoText
            })
            this.newTodoText = ''
        }
    }
})