document.querySelector("#loginBtn").addEventListener("click", autenticacao);


function autenticacao() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var usuarioList = JSON.parse(this.responseText);
            
            
        }
    };
    xhttp.open("GET", "http://localhost:9005/VeiculosOnline/usuario", true);
    xhttp.send();
}