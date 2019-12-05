<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../fragments/headerLogado.jsp" />

<div class="container mt-5">

    <h1>Editar Usuario: ${usuario.nome} / ${usuario.email}</h1>

    <div class="form-group">

        <form:form method="post" modelAttribute="usuario" action="${pageContext.request.contextPath}/usuario/editAdm" >

            <form:hidden path="id" />
            <form:hidden path="nome" />
            <form:hidden path="email" />
            <form:hidden path="senha" />
            <form:hidden path="telefone" />
            <form:hidden path="endereco" />
            <form:hidden path="cpf" />

            <spring:bind path="status">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Status</label>
                    <form:input path="status" type="text" class="form-control" id="status" placeholder="'Ativo' ou 'Bloqueado'" />
                    <form:errors path="status" class="control-label" />        
                </div>
            </spring:bind>

            <spring:bind path="tipo">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Tipo</label>
                    <form:input path="tipo" type="text" class="form-control" id="tipo" placeholder="USR(usuário) ou ADM(admin)" />
                    <form:errors path="tipo" class="control-label" />        
                </div>
            </spring:bind>

            <spring:bind path="banco">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Banco</label>
                    <form:input path="banco" type="text" class="form-control" id="banco" placeholder="banco" />
                    <form:errors path="banco" class="control-label" />        
                </div>
            </spring:bind>

            <spring:bind path="agencia">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Agência</label>
                    <form:input path="agencia" type="text" class="form-control" id="agencia" placeholder="agência" />
                    <form:errors path="agencia" class="control-label" />        
                </div>
            </spring:bind>

            <spring:bind path="conta">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label">Conta</label>
                    <form:input path="conta" type="text" class="form-control" id="conta" placeholder="conta" />
                    <form:errors path="conta" class="control-label" />        
                </div>
            </spring:bind>

            <div class="form-group">
                <button class="btn btn-primary" type="submit">Save</button>
                <a class="btn btn-info" href="${pageContext.request.contextPath}/usuario/list">Cancel</a>
                <a class="btn btn-danger float-right btn-xs" href="${pageContext.request.contextPath}/usuario/delete/${usuario.id}">Excluir</a>
            </div>

        </form:form>

    </div> 


</div> 

<jsp:include page="../fragments/footer.jsp" />