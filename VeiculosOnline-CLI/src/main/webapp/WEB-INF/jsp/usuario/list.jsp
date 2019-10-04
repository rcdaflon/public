<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../fragments/headerAdm.jsp" />

<div class="container">

    <h1>Usuário List</h1>

    <div id="top" class="row">
        <div class="col-sm-6">

            <form:form method="post" modelAttribute="search" action="${pageContext.request.contextPath}/usuario/list" >

                <spring:bind path="content">
                    <div class="input-group h2">
                        <form:input path="content" type="text" class="form-control" id="content" placeholder="Search" />
                        <span class="input-group-btn">
                            <button class="btn btn-primary" type="submit">
                                <span class="glyphicon glyphicon-search"></span>
                            </button>
                        </span>
                    </div>
                </spring:bind>

            </form:form>

        </div>

        <div class="col-sm-6">
            <a class="btn btn-primary pull-right h2" href="${pageContext.request.contextPath}/usuario/add">Add</a>
        </div>
    </div>

    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Email</th>
            <th>Tipo</th>
            <th>Status</th>
            <th>Ações</th>

        </tr>
        <c:forEach  items="${usuarioList}" var="usuario">
            <tr>
                <td>${usuario.id}</td>
                <td>${usuario.email}</td>
                <td>
                    <c:if test="${usuario.tipo == 'USR'}">
                        <c:out value="Usuário"/>
                    </c:if>
                    <c:if test="${usuario.tipo == 'ADM'}">
                        <c:out value="Administrador"/>
                    </c:if>
                </td>
                <td>${usuario.status}</td>
                <td>
                    <a class="btn btn-info btn-xs" href="${pageContext.request.contextPath}/usuario/editAdm/${usuario.id}">Editar</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<jsp:include page="../fragments/footer.jsp" />