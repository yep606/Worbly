function sendMessage(){

    axios({
        method: 'get',
        url: '/room/Math',
        responseType: 'json'
    })
        .then(function (response) {
                console.log(response.data);
            }
        );

}