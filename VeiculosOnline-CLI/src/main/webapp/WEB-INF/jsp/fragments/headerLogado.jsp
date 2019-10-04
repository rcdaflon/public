<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="pt-br">
    <title>Veiculos Online</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/anuncio.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/chat.css">
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
</head>

<body>

    <header>
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <a class="navbar-brand" href="#"><img class="active" src="${pageContext.request.contextPath}/resources/images/logoMenu.png" alt="" width="100" height="40"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item ">
                        <a class="nav-link" href="${pageContext.request.contextPath}">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <form:form method="get" action="${pageContext.request.contextPath}/anuncio/listUser">
                            <a class="nav-link" style="cursor: pointer;" onclick="javascript:this.parentNode.submit();" >Meus Anúncios</a>
                        </form:form>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="#">Notificações</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="${pageContext.request.contextPath}/chat/list">Chat</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="${pageContext.request.contextPath}/usuario/editUser">Meu Perfil</a>
                    </li>
                </ul>
                <form:form name="sair-form" class="form-inline mt-2 mt-md-0" method="get" action="${pageContext.request.contextPath}/logout" >
                    <button class="btn btn-outline-success my-2 my-sm-0" onclick="document.forms['sair-form'].submit();">Sair</button>
                </form:form>
            </div>
        </nav>
    </header>