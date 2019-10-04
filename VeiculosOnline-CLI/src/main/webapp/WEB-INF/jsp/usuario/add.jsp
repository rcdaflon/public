<%-- 
    Document   : signup
    Created on : 11/09/2019, 20:49:17
    Author     : Rodrigo
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html lang="en">

    <head>
        <title>Signup</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    </head>

    <body class="text-center">
        <div class="container">

            <div class="form-group">

                <form:form class="form-signin" method="post" modelAttribute="usuario" action="${pageContext.request.contextPath}/usuario/add" >

                    <a href="${pageContext.request.contextPath}"><img class="" src="${pageContext.request.contextPath}/resources/images/logoVo10.png" width="194" height="163"></a>


                    <spring:bind path="nome">
                        <div class="form-group ${status.error ? 'has-error' : ''} text-left">
                            <form:input path="nome" type="text" class="form-control" id="nome" placeholder="Nome" />
                            <form:errors path="nome" class="control-label" />        
                        </div>
                    </spring:bind>

                    <spring:bind path="email">
                        <div class="form-group ${status.error ? 'has-error' : ''} text-left">
                            <form:input path="email" type="text" class="form-control" id="email" placeholder="Email" />
                            <form:errors path="email" class="control-label" />        
                        </div>
                    </spring:bind>

                    <spring:bind path="senha">
                        <div class="form-group ${status.error ? 'has-error' : ''} text-left">
                            <form:input path="senha" type="password" class="form-control" id="senha" placeholder="Senha" />
                            <form:errors path="senha" class="control-label" />        
                        </div>
                    </spring:bind>



                    <button class="btn btn-lg btn-primary btn-block" type="submit">Cadastrar</button>

                </form:form>           
                    
                    <p class="text-muted">&copy Veiculos Online 2019</p>

            </div> 
        </div> 
    </body>
</html>




