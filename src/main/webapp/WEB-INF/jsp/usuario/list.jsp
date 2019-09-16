<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="../css/bootstrap.min.css">

        <title>Usuários - CRUD</title>
    </head>
    <body>
        <div class="container">  
            <div class="row mb-5">
                <div class="col mt-5 form-group">
                    <a href="../usuario/adicionar"  class="btn btn-success">+  Cadastrar Novo Usuário</a>
                </div>
                <div class="col-2">
                </div>
                <div class="col mt-5 form-group">
                    <div class="input-group-append">
                        <input type="text" class="form-control" placeholder="Pesquisar por id, email ou nome completo" id="inputPesquisar">
                        <button class="btn  btn-outline-secondary" type="button" id="buttonPesquisar">Pesquisar</button>
                    </div>
                    <p id="notifPesquisa" style="color: red"></p>
                </div>
                
            </div>
            
            <table class="table w-100">
                <thead class="thead-dark"><tr><th><h3 class="text-center">Lista de Usuários Cadastrados</h3></th></tr></thead>
            </table>
            <p id="notifPesquisa2" style="color: red"></p>
            <table id="usuarioTable" class="mt-1 table table-hover" >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Email</th>
                        <th>Nome</th>
                        <th>Senha</th>
                        <th>Ações</th>
                    </tr>
                </thead>
            </table>
            
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="../js/jquery-3.3.1.slim.min.js"></script>
        <script src="../js/popper.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/usuario/list.js"></script>
    </body>
</html>