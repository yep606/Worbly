function sendMessage(){

    axios({
        method: 'get',
        url: '/room',
        responseType: 'json'
    })
        .then(function (response) {
                console.log(response.data);
            }
        );
}