<template>
    <div>
        {{message.text}} {{message.id}}
        <button @click="edit">Edit</button>
    </div>
</template>

<script>
    export default {
        props: ['messages', 'message', 'editMessage'],
        methods: {
            edit: function () {
                this.editMessage(this.message);
            }
        }
    }
</script>

<style></style>