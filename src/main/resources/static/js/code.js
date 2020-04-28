function sendMessage(){

    axios({
        method: 'get',
        url: '/room/1',
        responseType: 'json'
    })
        .then(function (response) {
                console.log(response.data);
            }
        );
}