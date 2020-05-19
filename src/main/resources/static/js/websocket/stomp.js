import {Stomp} from '@stomp/stompjs'
import SockJS from 'sockjs-client'
import Vue from 'vue'
import VueResource from 'vue-resource'

Vue.use(VueResource)

const room = Vue.resource('room{/id}');

export function start(){
    var ws = new SockJS('/ws');
    var client = Stomp.over(ws);
    client.connect({}, on_connect, on_error);
}

function on_connect(){
    room.get().then(response => {

        response.json().then(data =>{
            console.log(data.subject)
        })

    })
}

function on_error() {
    console.log('error');
}