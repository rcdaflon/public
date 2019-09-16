<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="../css/bootstrap.min.css">

        <title>An�ncios - CRUD</title>
    </head>
    <body>
        <div class="container">  
            <div class="row mb-5">
                <div class="col mt-5 form-group">
                    <a href="../anuncio/adicionar"  class="btn btn-success">+  Cadastrar Novo An�ncio</a>
                </div>
                <div class="col-2">
                </div>
                <div class="col mt-5 form-group">
                    <div class="input-group-append">
                        <input type="text" class="form-control" placeholder="Pesquisar por id do anuncio ou do anunciante" id="inputPesquisar">
                        <button class="btn  btn-outline-secondary" type="button" id="buttonPesquisar">Pesquisar</button>
                    </div>
                    <p id="notifPesquisa" style="color: red"></p>
                </div>
                
            </div>
            
            <table class="table w-100">
                <thead class="thead-dark"><tr><th><h3 class="text-center">Lista de An�ncios Cadastrados</h3></th></tr></thead>
            </table>
            <p id="notifPesquisa2" style="color: red"></p>
            <table id="anuncioTable" class="mt-1 table table-hover" >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>T�tulo</th>
                        <th>Descri��o</th>
                        <th>Marca</th>
                        <th>Modelo</th>
                        <th>Motor</th>
                        <th>Portas</th>
                        <th>N� de Donos</th>
                        <th>Pre�o</th>
                        <th>A��es</th>
                    </tr>
                </thead>
            </table>
            
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="../js/jquery-3.3.1.slim.min.js"></script>
        <script src="../js/popper.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/anuncio/list.js"></script>
    </body>
</html>