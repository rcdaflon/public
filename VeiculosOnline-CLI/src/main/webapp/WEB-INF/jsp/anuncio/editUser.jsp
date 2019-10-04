<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../fragments/headerLogado.jsp" />

<div class="container ">  
    <h2 class="mt-5 mb-5">Editar dados do anúncio</h2>
    <form:form method="post" modelAttribute="anuncio" action="${pageContext.request.contextPath}/anuncio/editUser" >

        <form:hidden path="id" />

        <div class="row">
            <spring:bind path="titulo">
                <div class="form-group col-md-5 ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Título</label>
                    <form:input path="titulo" type="text" class="form-control" id="email" placeholder="Título" />
                    <form:errors path="titulo" class="control-label" />        
                </div>
            </spring:bind>
            <spring:bind path="descricao">
                <div class="form-group col-md-7 ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Descricao</label>
                    <form:input path="descricao" type="text" class="form-control" id="descricao" placeholder="Descricao" />
                    <form:errors path="descricao" class="control-label" />        
                </div>
            </spring:bind>
        </div>


        <div class="row">
            <spring:bind path="formas_pagamento">
                <div class="form-group col-md-5  ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Formas de pagamento</label>
                    <form:input path="formas_pagamento" type="text" class="form-control" id="formas_pagamento" placeholder="Formas de pagamento" />
                    <form:errors path="formas_pagamento" class="control-label" />        
                </div>
            </spring:bind>
            <spring:bind path="portas">
                <div class="form-group col-md-1 ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Portas</label>
                    <form:input path="portas" type="number" class="form-control" id="portas" placeholder="Portas" />
                    <form:errors path="portas" class="control-label" />        
                </div>
            </spring:bind>
            <spring:bind path="final_placa">
                <div class="form-group col-md-2 ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Final da placa</label>
                    <form:input path="final_placa" type="text" class="form-control" id="final_placa" placeholder="Final da placa" />
                    <form:errors path="final_placa" class="control-label" />        
                </div>
            </spring:bind>
            <spring:bind path="ano">
                <div class="form-group col-md-2 ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Ano</label>
                    <form:input path="ano" type="number" class="form-control" id="ano" placeholder="Ano" />
                    <form:errors path="ano" class="control-label" />        
                </div>
            </spring:bind>

            <spring:bind path="quantidade_donos">
                <div class="form-group col-md-2 ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Quantidade de donos</label>
                    <form:input path="quantidade_donos" type="number" class="form-control" id="quantidade_donos" placeholder="Quantidade de donos" />
                    <form:errors path="quantidade_donos" class="control-label" />        
                </div>
            </spring:bind>
        </div>


        <div class="row">
            <spring:bind path="cor">
                <div class="form-group col-md-3 ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Cor</label>
                    <form:input path="cor" type="text" class="form-control" id="cor" placeholder="Cor" />
                    <form:errors path="cor" class="control-label" />        
                </div>
            </spring:bind>
            <spring:bind path="motor">
                <div class="form-group col-md-3 ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Motor</label>
                    <form:input path="motor" type="text" class="form-control" id="motor" placeholder="Motor" />
                    <form:errors path="motor" class="control-label" />        
                </div>
            </spring:bind>
            <spring:bind path="combustivel">
                <div class="form-group col-md-3 ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Combustível</label>
                    <form:input path="combustivel" type="text" class="form-control" id="combustivel" placeholder="Combustível" />
                    <form:errors path="combustivel" class="control-label" />        
                </div>
            </spring:bind>
            <spring:bind path="kilometragem">
                <div class="form-group col-md-3 ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Kilometragem</label>
                    <form:input path="kilometragem" type="text" class="form-control" id="kilometragem" placeholder="Kilometragem" />
                    <form:errors path="kilometragem" class="control-label" />        
                </div>
            </spring:bind>
        </div>


        <div class="row">
            <spring:bind path="cambio">
                <div class="form-group col-md-3 ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Câmbio</label>
                    <form:input path="cambio" type="text" class="form-control" id="cambio" placeholder="Câmbio" />
                    <form:errors path="cambio" class="control-label" />        
                </div>
            </spring:bind>

            <spring:bind path="modelo">
                <div class="form-group col-md-3 ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Modelo</label>
                    <form:input path="modelo" type="text" class="form-control" id="modelo" placeholder="Modelo" />
                    <form:errors path="modelo" class="control-label" />        
                </div>
            </spring:bind>

            <spring:bind path="marca">
                <div class="form-group col-md-3 ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Marca</label>
                    <form:input path="marca" type="text" class="form-control" id="marca" placeholder="Marca" />
                    <form:errors path="marca" class="control-label" />        
                </div>
            </spring:bind>
            <spring:bind path="preco">
                <div class="form-group col-md-3 ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Preço (R$)</label>
                    <form:input path="preco" type="text" class="form-control" id="preco" placeholder="Preço" />
                    <form:errors path="preco" class="control-label" />        
                </div>
            </spring:bind>
        </div>




        <div class="form-group mt-4">
            <button class="btn btn-primary" type="submit">Save</button>
            <a class="btn btn-info" href="${pageContext.request.contextPath}/anuncio/listUser">Cancel</a>
        </div>
    </div>
</form:form>
<jsp:include page="../fragments/footer.jsp" />