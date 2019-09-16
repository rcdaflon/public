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
            var anuncioList = JSON.parse(this.responseText);
            
            var anuncioTable = document.querySelector("#anuncioTable");
            clearTable();
            for (var anuncio of anuncioList) {
                var row = anuncioTable.insertRow();
                var idCell = row.insertCell();
                idCell.appendChild(document.createTextNode(anuncio.id));
                var tituloCell = row.insertCell();
                tituloCell.appendChild(document.createTextNode(anuncio.titulo));
                var descricaoCell = row.insertCell();
                descricaoCell.appendChild(document.createTextNode(anuncio.descricao));
                var marcaCell = row.insertCell();
                marcaCell.appendChild(document.createTextNode(anuncio.marca));
                var modeloCell = row.insertCell();
                modeloCell.appendChild(document.createTextNode(anuncio.modelo));
                var motorCell = row.insertCell();
                motorCell.appendChild(document.createTextNode(anuncio.motor));
                var portasCell = row.insertCell();
                portasCell.appendChild(document.createTextNode(anuncio.portas));
                var donosCell = row.insertCell();
                donosCell.appendChild(document.createTextNode(anuncio.quantidade_donos));
                var precoCell = row.insertCell();
                precoCell.appendChild(document.createTextNode(anuncio.preco));
                
                var acoesCell = row.insertCell();

                var editarButton = document.createElement("button");
                editarButton.appendChild(document.createTextNode("Editar"));
                editarButton.setAttribute("id", anuncio.id);
                editarButton.setAttribute("class","btn btn-outline-secondary btn-sm");
                editarButton.addEventListener("click", loadEditForm);
                acoesCell.appendChild(editarButton);

                var excluirButton = document.createElement("button");
                excluirButton.appendChild(document.createTextNode("Excluir"));
                excluirButton.setAttribute("id", anuncio.id);
                excluirButton.setAttribute("class","btn btn-outline-danger btn-sm");
                excluirButton.addEventListener("click", deleteEntity);
                acoesCell.appendChild(excluirButton);
               
            }

        }
    };
    xhttp.open("GET", "http://localhost:9005/VeiculosOnline/anuncio", true);
    xhttp.send();
}

function loadEditForm(){
    //var xhttp = new XMLHttpRequest();
    //xhttp.open("GET", "http://localhost:9005/VeiculosOnline/usuario/"+this.id, true);
    //xhttp.setRequestHeader("Content-type", "application/json");
    //xhttp.send();
    sessionStorage.setItem('id', this.id);
    window.location = "anuncio/editar";
}



function deleteEntity(){
    var xhttp = new XMLHttpRequest();   
    var deletarId = this.id;
    xhttp.open("DELETE", "http://localhost:9005/VeiculosOnline/anuncio/"+deletarId , true);
    //xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
    alert("Anúncio " + deletarId + " excluído com sucesso!");
    load();    
   
}


function pesquisar(){
   var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var anuncioList = JSON.parse(this.responseText);
            var anuncioTable = document.querySelector("#anuncioTable");
            clearTable();
            for (var anuncio of anuncioList) {
                if((anuncio.id===document.querySelector("#inputPesquisar").value) || (anuncio.usuario_id===document.querySelector("#inputPesquisar").value))
                {
                    var row = anuncioTable.insertRow();
                var idCell = row.insertCell();
                idCell.appendChild(document.createTextNode(anuncio.id));
                var tituloCell = row.insertCell();
                tituloCell.appendChild(document.createTextNode(anuncio.titulo));
                var descricaoCell = row.insertCell();
                descricaoCell.appendChild(document.createTextNode(anuncio.descricao));
                var marcaCell = row.insertCell();
                marcaCell.appendChild(document.createTextNode(anuncio.marca));
                var modeloCell = row.insertCell();
                modeloCell.appendChild(document.createTextNode(anuncio.modelo));
                var motorCell = row.insertCell();
                motorCell.appendChild(document.createTextNode(anuncio.motor));
                var portasCell = row.insertCell();
                portasCell.appendChild(document.createTextNode(anuncio.portas));
                var donosCell = row.insertCell();
                donosCell.appendChild(document.createTextNode(anuncio.quantidade_donos));
                var precoCell = row.insertCell();
                precoCell.appendChild(document.createTextNode(anuncio.preco));
                
                var acoesCell = row.insertCell();

                var editarButton = document.createElement("button");
                editarButton.appendChild(document.createTextNode("Editar"));
                editarButton.setAttribute("id", anuncio.id);
                editarButton.setAttribute("class","btn btn-outline-secondary btn-sm");
                editarButton.addEventListener("click", loadEditForm);
                acoesCell.appendChild(editarButton);

                var excluirButton = document.createElement("button");
                excluirButton.appendChild(document.createTextNode("Excluir"));
                excluirButton.setAttribute("id", anuncio.id);
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
    xhttp.open("GET", "http://localhost:9005/VeiculosOnline/anuncio", true);
    xhttp.send();
}