<!DOCTYPE HTML>
<html lang="en">

    <head>
        <title>Veiculos Online</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    </head>

    <body class="container text-center">
        <div class="form-signin">   
                <a href="${pageContext.request.contextPath}">
                    <img class="" src="${pageContext.request.contextPath}/resources/images/logoVo10.png" alt="" width="200" height="200">
                </a>
      
            <h2>Ops!</h2>
            <small class="text-muted">Ocorreu um erro inesperado...</br><strong>Você já efetuou o login?</strong></br>Caso <strong>não</strong>, clique nos links abaixo e tenha acesso à essas e outras funcionalidades.</br>Caso <strong>sim</strong>, é provável que algumas funcionalidades não estejam disponíveis no momento, fique tranquilo, estamos trabalhando nisso.</small>
            <div style="height: 50px;"></div>
            <div class="mt-4">
                <button style="background: green ; color: white" class="btn btn-outline-success btn-block" type="submit" onclick="window.location.href = '${pageContext.request.contextPath}/login'">Entrar</button>
                <spam>Ou</spam>
                <button style="background: green; color: white " class="btn btn-outline-success btn-block" type="submit" onclick="window.location.href = '${pageContext.request.contextPath}/usuario/add'">Cadastrar</button>
            </div>
        </div> 
    </body>
</html>
