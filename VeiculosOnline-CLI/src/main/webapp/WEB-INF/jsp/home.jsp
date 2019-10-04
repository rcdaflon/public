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

                <div class="col-2" style="position: fixed; left: 0; border-right-style: solid; border-right-color: #ccc; border-right-width: 1px; height: 100%;">
                    <form:form method="post" modelAttribute="filtro" action="${pageContext.request.contextPath}/anuncio/filtro" >

                        <h3 class="text-center">Filtros</h3>
                        <div class="row" style="border-top-style: outset; border-top-width: 1px; border-top-color: #ccc;">
                            <spring:bind path="titulo">
                                <div class="form-group col ${status.error ? 'has-error' : ''}">
                                    <label class="control-label mt-1">Nome</label>
                                    <form:input path="titulo" type="text" class="form-control " id="titulo" placeholder="título do anúncio" />
                                    <form:errors path="titulo" class="control-label " />        
                                </div>
                            </spring:bind>
                        </div>

                        <div class="row" style="border-top-style: outset; border-top-width: 1px; border-top-color: #ccc;">
                            <spring:bind path="kilometragem">
                                <div class="form-group col ${status.error ? 'has-error' : ''}">
                                    <label class="control-label mt-1">Kilometragem</label>
                                    <form:input path="kilometragem" type="text" class="form-control " id="kilometragem" placeholder="kilometragem máxima" />
                                    <form:errors path="kilometragem" class="control-label mb-2" />        
                                </div>
                            </spring:bind>
                        </div>

                        <div class="row" style="border-top-style: outset; border-top-width: 1px; border-top-color: #ccc;">
                            <spring:bind path="ano">
                                <div class="form-group col ${status.error ? 'has-error' : ''}">
                                    <label class="control-label mt-1">Ano</label>
                                    <form:input path="ano" type="text" class="form-control mb-2" id="ano" placeholder="fabricados a partir de" />
                                    <form:errors path="ano" class="control-label mb-2" />        
                                </div>
                            </spring:bind>
                        </div>

                        <div class="row" style="border-top-style: outset; border-top-width: 1px; border-top-color: #ccc;">
                            <spring:bind path="preco_min">
                                <div class="form-group col ${status.error ? 'has-error' : ''}">
                                    <label class="control-label mt-1">Preço</label>
                                    <form:input path="preco_min" type="text" class="form-control " id="preco_min" placeholder="preço mínimo" />
                                    <form:errors path="preco_min" class="control-label" />        
                                </div>
                            </spring:bind>
                        </div>
                        <div class="row">
                            <spring:bind path="preco_max">
                                <div class="form-group col ${status.error ? 'has-error' : ''}">
                                    <form:input path="preco_max" type="text" class="form-control " id="preco_max" placeholder="preço máximo" />
                                    <form:errors path="preco_max" class="control-label " />        
                                </div>
                            </spring:bind>
                        </div>



                        <div class="form-group mt-1 text-center">
                            <button class="btn btn-primary btn-block" type="submit">Aplicar filtro</button>
                        </div>
                    </form:form>    
                </div>

                <div class="col" style="margin-left: 16.666667%;">
                    <div class="row">
                        <c:forEach  items="${anuncioList}" var="anuncio">
                            <div class="col-3">
                                <form:form method="get" action="${pageContext.request.contextPath}/anuncio/${anuncio.id}">
                                    <div style="max-height: 390px;" class="card mb-3 box-shadow" style="cursor: pointer;" onclick="javascript:this.parentNode.submit();">
                                        <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail" alt="Card image cap">
                                        <div class="card-body">
                                            <small class="text-muted float-right">${anuncio.nota}</small>
                                            <p class="card-text">${anuncio.titulo}</p>
                                            <p style="max-width: 35ch; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;" class="card-text text-muted">${anuncio.descricao}</p>
                                            <h3 class="float-right">R$ ${anuncio.preco}</h3>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>


<jsp:include page="fragments/footer.jsp" />
