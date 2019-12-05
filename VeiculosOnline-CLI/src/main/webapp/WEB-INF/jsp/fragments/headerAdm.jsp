<!DOCTYPE HTML>
<head>
    <title>Veiculos Online</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
</head>

<body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">

            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Veiculos Online</a>
            </div>

            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>

                <li class=""><a href="${pageContext.request.contextPath}/usuario/list">Usu�rios</a></li> 

                <li class=""><a href="${pageContext.request.contextPath}/anuncio/listAdm">An�ncios</a></li>

                <li class=""><a href="${pageContext.request.contextPath}/notificacao/list">Notifica��es</a></li>

            </ul>

            <a class="btn btn-outline-success"><button class="btn btn-outline-success" onclick="window.location.href = '${pageContext.request.contextPath}/logout'" >Sair</button></a>

        </div>
    </nav>  
