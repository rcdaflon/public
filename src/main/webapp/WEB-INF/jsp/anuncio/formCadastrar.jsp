<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="../css/bootstrap.min.css">

        <title>Cadastro de Anúncio</title>
    </head>
    <body class="text-center">
        <div class="container">  
            <h2 class="mt-3 mb-5">Cadastrar Novo Anúncio</h2>
            <form>
                <div class="input-group mx-sm-5 mb-5">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Título<a style="color: red;">*</a></span>
                    </div>                       
                    <input type="text" class="form-control" id="tituloInput" placeholder="título do anúncio">
                </div>
                <div class="input-group mx-sm-5 mb-5">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Descrição<a style="color: red;">*</a></span>
                    </div>                       
                    <input type="text" class="form-control" id="descricaoInput" placeholder="descrição do anúncio">
                </div>
                <div class="input-group mx-sm-5 mb-5">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Preço<a style="color: red;">*</a></span>
                    </div>   
                    <input type="text" class="form-control" id="precoInput" placeholder="preço do seu veículo">
                </div>
                <div class="input-group mx-sm-5 mb-5">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Título<a style="color: red;">*</a></span>
                    </div>                       
                    <input type="text" class="form-control" id="tituloInput" placeholder="título do anúncio">
                </div>
                <div class="input-group mx-sm-5 mb-5">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Descrição<a style="color: red;">*</a></span>
                    </div>                       
                    <input type="text" class="form-control" id="descricaoInput" placeholder="descrição do anúncio">
                </div>
                <div class="input-group mx-sm-5 mb-5">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Preço<a style="color: red;">*</a></span>
                    </div>   
                    <input type="text" class="form-control" id="precoInput" placeholder="preço do seu veículo">
                </div>
                
                <small id="obrigatorio" class="form-text mb-5 text-muted"><a style="color: red;"> *</a> Campos obrigatórios!</small>
                
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
        <script src="../js/anuncio/formCadastrar.js"></script>
    </body>
</html>