/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.querySelector("#signupBtn").addEventListener("click", add);

document.getElementById('olho').addEventListener('mousedown', function() {
  document.getElementById('inputPassword').type = 'text';
});

document.getElementById('olho').addEventListener('mouseup', function() {
  document.getElementById('inputPassword').type = 'password';
});

function add() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4) {
            var status = this.status;
            if (status == 201) {
                window.location = "../home";
                return false;
            } else {
                console.log("erro...");
            }
        }
    };
    xhttp.open("POST", "http://localhost:9005/VeiculosOnline-api/usuario", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    var email = document.querySelector("#inputEmail").value;
    var nome = document.querySelector("#inputNome").value;
    var senha = document.querySelector("#inputPassword").value;
    var usuario = {email: email, nome: nome, senha: senha};
    xhttp.send(JSON.stringify(usuario));
}

function cancel() {
    window.location = "../usuario/home";
}
