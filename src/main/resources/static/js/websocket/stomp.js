import {Stomp} from '@stomp/stompjs'


var on_connect = function() {
    console.log('connected');
};
var on_error =  function() {
    console.log('error');
};

export function start(){
    var ws = new WebSocket('ws://localhost:15674/ws');
    var client = Stomp.over(ws);
    client.connect({}, on_connect, on_error);
}