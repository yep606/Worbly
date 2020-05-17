<template>

    <div>
        <input placeholder="Write a messsge" v-model="text"/>
        <button @click="save">Send</button>
    </div>

</template>

<script>

    export default {
        
        data: function() {
            return {
                text: '',
                id: '',
            }
        },

        props: ['messages', 'message'],

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
        }
    }

</script>

<style></style>