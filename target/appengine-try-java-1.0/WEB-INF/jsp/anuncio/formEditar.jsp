<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="../css/bootstrap.min.css">

        <title>Editar Usu�rio</title>
    </head>
    <body class="text-center">
        <div class="container ">  
            <h2 class="mt-3 mb-5">Editar Dados Cadastrais</h2>
            <form id="usuarioEditForm">
                <div class="input-group mx-sm-5 mb-5">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">@</span>
                    </div>
                    <input type="text" class="form-control" id="email" aria-describedby="basic-addon1" disabled>
                </div>
                <div class="input-group mx-sm-5 mb-5">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Nome<a style="color: red;">*</a></span>
                    </div>                       
                    <input type="text" class="form-control" id="nomeInput">
                </div>
                <div class="input-group mx-sm-5 mb-5">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Senha<a style="color: red;">*</a></span>
                    </div>   
                    <input type="text" class="form-control" id="senhaInput">
                </div>
                <div class="input-group mx-sm-5 mb-5">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Telefone</span>
                    </div>   
                    <input type="text" class="form-control" id="telefoneInput" placeholder="somente n�meros">
                </div>
                <div class="input-group mx-sm-5 mb-5">
                    <table id="enderecoTable" class="mt-1 table table-hover" >
                        <thead>
                            <tr>
                                <th>Rua</th>
                                <th>Numero</th>
                                <th>Bairro</th>
                                <th>Cidade</th>
                                <th>Estado</th>
                            </tr>
                        </thead>
                    </table>
                </div>
                <div id="dadosAdm">
                    <div class="input-group mx-sm-5 mb-5">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Cpf</span>
                        </div>   
                        <input type="text" class="form-control" id="cpfInput" placeholder="somente n�meros">
                    </div>
                    <div class="input-group mx-sm-5 mb-5">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Banco</span>
                        </div>   
                        <input type="text" class="form-control" id="bancoInput" placeholder="somente n�meros">
                    </div>
                    <div class="input-group mx-sm-5 mb-5">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Agencia</span>
                        </div>   
                        <input type="text" class="form-control" id="agenciaInput" placeholder="somente n�meros">
                    </div>
                    <div class="input-group mx-sm-5 mb-5">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Conta</span>
                        </div>   
                        <input type="text" class="form-control" id="contaInput" placeholder="somente n�meros">
                    </div>
                </div>
                
                <small id="obrigatorio" class="form-text mb-5 text-muted"><a style="color: red;">*</a> Campos obrigat�rios!</small>



            </form>
            <div class="btn-group">
                <button id="buttonConfirmar" class="btn btn-success">Confirmar</button>
                <button id="buttonCancelar" class="btn btn-danger">Cancelar</button>
            </div>
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="../js/jquery-3.3.1.slim.min.js"></script>
        <script src="../js/popper.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/anuncio/formEditar.js"></script>
    </body>
</html>