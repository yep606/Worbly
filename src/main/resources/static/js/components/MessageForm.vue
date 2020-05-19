<template>
    <div>
        <input placeholder="Write a message" v-model="text"/>
        <button @click="save">Send</button>
    </div>
</template>

<script>

    let nextMessageId = 0;

    export default {
        data: function () {
            return {
                text: '',
                id: '',
            }
        },
        props: ['messages', 'message'],
        watch: {
            message: function (newValue) {
                this.text = newValue.text;
                this.id = newValue.id;
            }
        },
        methods: {
            save: function () {
                if (this.id) { //update
                    let message = {text: this.text, id: this.id}
                    let index = this.messages.findIndex(elem => elem.id === this.id)
                    this.messages.splice(index, 1, message);
                    this.text = '';
                    this.id = '';
                } else { //adding
                    this.messages.push({text: this.text, id: nextMessageId++})
                    this.text = '';
                }
            },
        }
    }
</script>

<style></style>