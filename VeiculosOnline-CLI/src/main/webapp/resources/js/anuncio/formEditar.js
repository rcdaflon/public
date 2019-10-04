loadEditForm();

function loadEditForm() {

    var buttonCancelar = document.getElementById("buttonCancelar");
    buttonCancelar.addEventListener("click", cancelarEditar);

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var usuario = JSON.parse(this.responseText);

            var email = document.getElementById("email");
            email.setAttribute("placeholder", usuario.email);
            
            var nomeInput = document.getElementById("nomeInput");
            nomeInput.setAttribute("value", usuario.nome);

            var senhaInput = document.getElementById("senhaInput");
            senhaInput.setAttribute("value", usuario.senha);

            var telefoneInput = document.getElementById("telefoneInput");
            if (usuario.telefone !== null)
                telefoneInput.setAttribute("value", usuario.telefone);
            var enderecoInput = document.getElementById("enderecoInput");
            if (usuario.endereco !== null)
                enderecoInput.setAttribute("value", usuario.endereco);

            if (usuario.tipo) {
                var dadosAdm = document.getElementById("dadosAdm");
                dadosAdm.setAttribute("style", "display: block;");
                var cpfInput = document.getElementById("cpfInput");
                if (usuario.cpf !== null)
                    cpfInput.setAttribute("value", usuario.cpf);
                var bancoInput = document.getElementById("bancoInput");
                if (usuario.banco !== null)
                    bancoInput.setAttribute("value", usuario.banco);
                var agenciaInput = document.getElementById("agenciaInput");
                if (usuario.agencia !== null)
                    agenciaInput.setAttribute("value", usuario.agencia);
                var contaInput = document.getElementById("contaInput");
                if (usuario.conta !== null)
                    contaInput.setAttribute("value", usuario.conta);
            } else {
                var dadosAdm = document.getElementById("dadosAdm");
                dadosAdm.setAttribute("style", "display: none;");
            }

            var buttonConfirmar = document.getElementById("buttonConfirmar");
            buttonConfirmar.addEventListener("click", confirmarEditar);


        }
    };

    xhttp.open("GET", "http://localhost:9005/VeiculosOnline/usuario/" + this.id, true);
    //xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
}




function confirmarEditar() {
    var enderecoTable = document.querySelector("#enderecoTable");
    var rows = enderecoTable.getElementsByTagName("tr");

    var nome = document.getElementById("nomeInput").value;
    var senha = document.getElementById("senhaInput").value;

//    var telefone = document.getElementById("telefoneInput").value;
//    
//    for(var i = 0; i < rows.length; i++){
//  	var selecionado = selecionados[i];
//        selecionado = selecionado.getElementsByTagName("td");
//        var rua = selecionado[0].innerHTML;
//        var numero = selecionado[1].innerHTML;
//        var bairro = selecionado[2].innerHTML;
//        var cidade = selecionado[3].innerHTML;
//        var estado = selecionado[4].innerHTML;
//        var xhttp = new XMLHttpRequest();   
//        xhttp.open("PATCH", "http://localhost:9005/VeiculosOnline/endereco/"+ Integer.parseInt(selecionado.getAttribute("id")), true);
//        xhttp.setRequestHeader("Content-type", "application/json");
//        var endereco = {rua: rua, numero: numero, bairro: bairro, cidade: cidade, estado: estado};
//        xhttp.send(JSON.stringify(endereco));
//    }

    var cpf = document.getElementById("cpfInput").value;
    var banco = document.getElementById("bancoInput").value;
    var agencia = document.getElementById("agenciaInput").value;
    var conta = document.getElementById("contaInput").value;

    var xhttp = new XMLHttpRequest();
    xhttp.open("PATCH", "http://localhost:9005/VeiculosOnline/usuario/" + sessionStorage.getItem('id'), true);
    xhttp.setRequestHeader("Content-type", "application/json");
    var usuario = {nome: nome, senha: senha, cpf: cpf, banco: banco, agencia: agencia, conta: conta};
    xhttp.send(JSON.stringify(usuario));
    window.location = "../usuario";
}

function cancelarEditar() {
    window.location = "../usuario";
}


