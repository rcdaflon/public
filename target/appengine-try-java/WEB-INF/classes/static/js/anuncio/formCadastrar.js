document.querySelector("#buttonConfirmar").addEventListener("click", add);
document.querySelector("#buttonCancelar").addEventListener("click", cancel);

function add() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4) {
            var status = this.status;
            if (status == 201) {
                window.location = "../usuario";
                return false;
            } else {
                console.log("erro...");
            }
        }
    };
    xhttp.open("POST", "http://localhost:9005/VeiculosOnline/usuario", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    var email = document.querySelector("#emailInput").value;
    var nome = document.querySelector("#nomeInput").value;
    var senha = document.querySelector("#senhaInput").value;
    var usuario = {email: email, nome: nome, senha: senha};
    xhttp.send(JSON.stringify(usuario));
}

function cancel() {
    window.location = "../usuario";
}