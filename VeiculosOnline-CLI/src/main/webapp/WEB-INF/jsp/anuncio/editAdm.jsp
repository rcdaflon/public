<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../fragments/headerAdm.jsp" />

<div class="container ">  
    <h2 class="mt-5 mb-5">Editar dados do anúncio</h2>
    <form:form method="post" modelAttribute="anuncio" action="${pageContext.request.contextPath}/anuncio/editAdm" >

        <form:hidden path="id" />
        <div class="row">
             <spring:bind path="nota">
                 <div class="form-group col-md-4 ${status.error ? 'has-error' : ''}">
                     <label class="control-label">Nota de avaliação</label>
                     <form:input path="nota" type="number" class="form-control" id="nota" placeholder="de 0 à 10" />
                     <form:errors path="nota" class="control-label" />        
                 </div>
             </spring:bind>

             <spring:bind path="status">
                 <div class="form-group col-md-4 ${status.error ? 'has-error' : ''}">
                     <label class="control-label">Status</label>
                     <form:input path="status" type="text" class="form-control" id="status" placeholder="Em Avaliacao, Ativo, Pausado ou Excluido" />
                     <form:errors path="status" class="control-label" />        
                 </div>
             </spring:bind>

             <spring:bind path="taxa_compra">
                 <div class="form-group col-md-4 ${status.error ? 'has-error' : ''}">
                     <label class="control-label">Taxa de compra</label>
                     <form:input path="taxa_compra" type="number" class="form-control" id="taxa_compra" placeholder="somente numeros" />
                     <form:errors path="taxa_compra" class="control-label" />        
                 </div>
             </spring:bind>
        </div>
        
        <div class="form-group mt-4">
            <button class="btn btn-primary" type="submit">Save</button>
            <a class="btn btn-info" href="${pageContext.request.contextPath}/anuncio/listAdm">Cancel</a>
        </div>
    </form:form>
    <jsp:include page="../fragments/footer.jsp" />