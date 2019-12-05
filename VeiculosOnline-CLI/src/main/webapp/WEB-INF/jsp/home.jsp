<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var = "tipo" scope = "session" value = "${usuario_tipo}"/>
<c:choose>
    <c:when test="${tipo == 'ADM'}">
        <jsp:include page="fragments/headerLogado.jsp" />
    </c:when>
    <c:when test="${tipo == 'USR'}">
        <jsp:include page="fragments/headerLogado.jsp" />
    </c:when>
    <c:otherwise>
        <jsp:include page="fragments/headerVisitante.jsp" />
    </c:otherwise>
</c:choose>

<main role="main" style="position: absolute;">
    <div class="mt-3 py-5 bg-light">
        <div class="container-fluid">
            <div class="row" style="margin: 0; padding: 0;">

                <div class="col" style=" width: 230px; position: fixed; left: 0; border-right-style: solid; border-right-color: #ccc; border-right-width: 1px; height: 100%;">
                    <form:form method="post" modelAttribute="filtro" action="${pageContext.request.contextPath}/anuncio/filtro" >

                        <h3 class="text-center">Filtros</h3>
                        <div class="row" style="border-top-style: outset; border-top-width: 1px; border-top-color: #ccc;">
                            <spring:bind path="titulo">
                                <div class="form-group col ${status.error ? 'has-error' : ''}">
                                    <label class="control-label mt-1">Nome</label>
                                    <form:input path="titulo" type="text" class="form-control " id="titulo" placeholder="título do anúncio" />    
                                    <small style="color: red;"><form:errors path="titulo" class="control-label" /></small>
                                </div>
                            </spring:bind>
                        </div>

                        <div class="row" style="border-top-style: outset; border-top-width: 1px; border-top-color: #ccc;">
                            <spring:bind path="kilometragem">
                                <div class="form-group col ${status.error ? 'has-error' : ''}">
                                    <label class="control-label mt-1">Kilometragem</label>
                                    <form:input path="kilometragem" type="text" class="form-control " id="kilometragem" placeholder="kilometragem máxima" />    
                                    <small style="color: red;"><form:errors path="kilometragem" class="control-label" /></small>
                                </div>
                            </spring:bind>
                        </div>

                        <div class="row" style="border-top-style: outset; border-top-width: 1px; border-top-color: #ccc;">
                            <spring:bind path="ano">
                                <div class="form-group col ${status.error ? 'has-error' : ''}">
                                    <label class="control-label mt-1">Ano</label>
                                    <form:input path="ano" type="text" class="form-control mb-2" id="ano" placeholder="fabricados a partir de" />
                                    <small style="color: red;"><form:errors path="ano" class="control-label" /></small>
                                </div>
                            </spring:bind>
                        </div>

                        <div class="row" style="border-top-style: outset; border-top-width: 1px; border-top-color: #ccc;">
                            <spring:bind path="preco_min">
                                <div class="form-group col ${status.error ? 'has-error' : ''}">
                                    <label class="control-label mt-1">Preço</label>
                                    <form:input path="preco_min" type="text" class="form-control " id="preco_min" placeholder="preço mínimo" />
                                    <small style="color: red;"><form:errors path="preco_min" class="control-label" /></small>
                                </div>
                            </spring:bind>
                        </div>
                        <div class="row">
                            <spring:bind path="preco_max">
                                <div class="form-group col ${status.error ? 'has-error' : ''}">
                                    <form:input path="preco_max" type="text" class="form-control " id="preco_max" placeholder="preço máximo" />
                                    <small style="color: red;"><form:errors path="preco_min" class="control-label" /></small>
                                    <form:errors path="preco_min" class="control-label" />
                                </div>
                            </spring:bind>
                        </div>

                        <hr>

                        <spring:bind path="not_found">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:hidden path="not_found" />
                                <small style="color: red;"><form:errors path="not_found" class="control-label" /></small>  
                            </div>
                        </spring:bind>   

                        <div class="form-group mt-1 text-center">
                            <button class="btn btn-primary btn-block" type="submit" id="aplicarFiltro_btn">Aplicar filtro</button>
                        </div>
                    </form:form>    
                </div>
                
                <div class="col-xl-10 col-lg-10 col-md-9 col-sm-9 col-8" style="margin-left: 240px;">
                    <div class="row">
                        <c:forEach  items="${anuncioList}" var="anuncio">
                            <div class="col-xl-3 col-lg-4 col-md-6 col-sm-12 col-12">
                                <a href="${pageContext.request.contextPath}/anuncio/${anuncio.id}" style="text-decoration: none; color: black">
                                    <div style="height: 360px; max-width: 310px;" class="card mb-3 box-shadow" style="cursor: pointer;">
                                        <c:if test="${anuncio.foto_capa == null}">
                                            <img class="bd-placeholder-img" height="100%" src="data:image/png;base64,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";
                                                 "role="img">                                        
                                        </c:if>
                                        <c:if test="${anuncio.foto_capa != null}">
                                            <img class="card-img-top" height="100%" src="data:image/png;base64,${anuncio.foto_capa}" alt="Card image cap">
                                        </c:if>
                                        <div class="card-body" style="height: 25%" >
                                            <small class="text-muted float-right">${anuncio.nota}</small>
                                            <p class="card-text">${anuncio.titulo}</p>
                                            <p style="max-width: 35ch; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;" class="card-text text-muted">${anuncio.descricao}</p>
                                            <h3 class="float-right">R$ ${anuncio.preco}</h3>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
                    </div>

                </div>
            </div>
        </div>
    </div>
</main>


<jsp:include page="fragments/footer.jsp" />
