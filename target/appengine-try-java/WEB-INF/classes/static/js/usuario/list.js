document.querySelector("#buttonPesquisar").addEventListener("click", pesquisar);
load();
function clearTable() {
    var table = document.querySelector("#usuarioTable");
    for (var i = table.rows.length - 1; i > 0; i--) {
        table.deleteRow(i);
    }
}
function load() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var usuarioList = JSON.parse(this.responseText);
            
            var usuarioTable = document.querySelector("#usuarioTable");
            clearTable();
            for (var usuario of usuarioList) {
                var row = usuarioTable.insertRow();
                var idCell = row.insertCell();
                idCell.appendChild(document.createTextNode(usuario.id));
                var emailCell = row.insertCell();
                emailCell.appendChild(document.createTextNode(usuario.email));
                var nomeCell = row.insertCell();
                nomeCell.appendChild(document.createTextNode(usuario.nome));
                var senhaCell = row.insertCell();
                senhaCell.appendChild(document.createTextNode(usuario.senha));
                
                var acoesCell = row.insertCell();

                var editarButton = document.createElement("button");
                editarButton.appendChild(document.createTextNode("Editar"));
                editarButton.setAttribute("id", usuario.id);
                editarButton.setAttribute("class","btn btn-outline-secondary btn-sm");
                editarButton.addEventListener("click", loadEditForm);
                acoesCell.appendChild(editarButton);

                var excluirButton = document.createElement("button");
                excluirButton.appendChild(document.createTextNode("Excluir"));
                excluirButton.setAttribute("id", usuario.id);
                excluirButton.setAttribute("class","btn btn-outline-danger btn-sm");
                excluirButton.addEventListener("click", deleteEntity);
                acoesCell.appendChild(excluirButton);
               
            }

        }
    };
    xhttp.open("GET", "http://localhost:9005/VeiculosOnline/usuario", true);
    xhttp.send();
}

function loadEditForm(){
    //var xhttp = new XMLHttpRequest();
    //xhttp.open("GET", "http://localhost:9005/VeiculosOnline/usuario/editar/"+this.id, true);
    //xhttp.setRequestHeader("Content-type", "application/json");
    //xhttp.send();
    sessionStorage.setItem('id', this.id);
    window.location = "../usuario/editar";
}



function deleteEntity(){
    var xhttp = new XMLHttpRequest();   
    var deletarId = this.id;
    xhttp.open("DELETE", "http://localhost:9005/VeiculosOnline/usuario/"+deletarId , true);
    //xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
    alert("Usuario " + deletarId + " excluído com sucesso!");
    load();    
   
}


function pesquisar(){
   var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var usuarioList = JSON.parse(this.responseText);
            var usuarioTable = document.querySelector("#usuarioTable");
            clearTable();
            for (var usuario of usuarioList) {
                if((usuario.email===document.querySelector("#inputPesquisar").value) || (usuario.nome===document.querySelector("#inputPesquisar").value) || (usuario.id===document.querySelector("#inputPesquisar").value))
                {
                    var row = usuarioTable.insertRow();
                    var idCell = row.insertCell();
                    idCell.appendChild(document.createTextNode(usuario.id));
                    var emailCell = row.insertCell();
                    emailCell.appendChild(document.createTextNode(usuario.email));
                    var nomeCell = row.insertCell();
                    nomeCell.appendChild(document.createTextNode(usuario.nome));
                    var senhaCell = row.insertCell();
                    senhaCell.appendChild(document.createTextNode(usuario.senha));

                    var acoesCell = row.insertCell();
                    
                    var editarButton = document.createElement("button");
                    editarButton.appendChild(document.createTextNode("Editar"));
                    editarButton.setAttribute("id", usuario.id);
                    editarButton.setAttribute("class","btn btn-outline-secondary btn-sm");
                    editarButton.addEventListener("click", loadEditForm);
                    acoesCell.appendChild(editarButton);

                    var excluirButton = document.createElement("button");
                    excluirButton.appendChild(document.createTextNode("Excluir"));
                    excluirButton.setAttribute("id", usuario.id);
                    excluirButton.setAttribute("class","btn btn-outline-danger btn-sm");
                    excluirButton.addEventListener("click", deleteEntity);
                    acoesCell.appendChild(excluirButton);
                    
                    document.getElementById("notifPesquisa").innerHTML = "";
                }
                else{
                    if(document.querySelector("#inputPesquisar").value === ""){
                        document.getElementById("notifPesquisa").innerHTML = "";
                        load();
                    }
                    else{
                        document.getElementById("notifPesquisa").innerHTML = "Usuário não encontrado!";
                        load();
                    }
                }
            }

        }
    };
    xhttp.open("GET", "http://localhost:9005/VeiculosOnline/usuario", true);
    xhttp.send();
}