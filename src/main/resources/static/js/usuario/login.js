document.querySelector("#loginBtn").addEventListener("click", autenticacao);


function autenticacao() {
    var email = document.getElementById("inputEmail");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var usuario = JSON.parse(this.responseText);

            if (usuario !== null) {  
                if(usuario.senha !== document.getElementById("inputPassword").value){
                    var alertError = document.getElementById("alertError");
                    alertError.setAttribute("style", "display: block;");
                } else {
                    document.location.href="../home";
                }
            } else{
                alert("usuario nao encontrado!");
            }
        }
    };
    xhttp.open("GET", "http://localhost:9005/VeiculosOnline/usuario/email/" + email.value, true);
    xhttp.send();
}