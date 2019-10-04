<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../fragments/headerLogado.jsp" />

<div class="container mt-5">

    <h1>Editar meus dados</h1>

    <div class="form-group">

        <form:form method="post" modelAttribute="usuario" action="${pageContext.request.contextPath}/usuario/edit" >

            <form:hidden path="id" />
            <form:hidden path="status" />
            <form:hidden path="tipo" />
            <form:hidden path="banco" />
            <form:hidden path="agencia" />
            <form:hidden path="conta" />

            <spring:bind path="nome">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Nome</label>
                    <form:input path="nome" type="text" class="form-control" id="nome" placeholder="Nome" />
                    <form:errors path="nome" class="control-label" />        
                </div>
            </spring:bind>
            
            <spring:bind path="cpf">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Cpf</label>
                    <form:input path="cpf" type="text" class="form-control" id="cpf" placeholder="somente numeros" />
                    <form:errors path="cpf" class="control-label" />        
                </div>
            </spring:bind>

            <spring:bind path="telefone">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Telefone</label>
                    <form:input path="telefone" type="text" class="form-control" id="telefone" placeholder="(35) 3471-9500" />
                    <form:errors path="telefone" class="control-label" />        
                </div>
            </spring:bind>
            
            <spring:bind path="endereco">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Endereço</label>
                    <form:input path="endereco" type="text" class="form-control" id="endereco" placeholder="Rua Antônio de Cássa, 459, Santa Rita do Sapucaí, MG, 37540-000" />
                    <form:errors path="endereco" class="control-label" />        
                </div>
            </spring:bind>

            <div class="form-group">
                <button class="btn btn-primary" type="submit">Save</button>
                <a class="btn btn-info" href="${pageContext.request.contextPath}/usuario/list">Cancel</a>
                <a class="btn btn-info" href="${pageContext.request.contextPath}/usuario/editSenha">Alterar Senha</a>
            </div>

        </form:form>
        
    </div> 


</div> 

<jsp:include page="../fragments/footer.jsp" />