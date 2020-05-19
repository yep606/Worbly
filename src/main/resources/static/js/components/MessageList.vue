<template>
    <div>
        <button v-if="!isConnected" @click="conn">Connection</button>
        <div v-if="isConnected">
            <MessageRow v-for="message in messages" :key="message.id"
                        :messages="messages" :message="message" :editMessage="editMessage"/>
            <MessageForm :messages="messages" :message="message"/>
        </div>
    </div>
</template>

<script>
    import MessageForm from "./MessageForm.vue";
    import MessageRow from "./MessageRow.vue";
    import {start} from "../websocket/stomp";

    export default {
        components: {
            MessageForm,
            MessageRow
        },
        data: function () {
            return {
                message: null,
                isConnected: false,
                messages: [],
            }
        },
        methods: {
            editMessage: function (message) {
                this.message = message;
            },
            conn: function () {
                start();
                this.isConnected = true;
            }
        }
    }
</script>

<style></style>
