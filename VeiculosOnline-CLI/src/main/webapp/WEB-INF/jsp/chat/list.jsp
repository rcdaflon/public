<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../fragments/headerLogado.jsp" />

<div class="container mt-5">

    <h1>Minhas Conversas</h1>

    <div id="top" class="row">
        <div class="col-sm-6">

            <form:form method="post" modelAttribute="search" action="${pageContext.request.contextPath}/anuncio/list" >

                <spring:bind path="content">
                    <div class="input-group h2">
                        <form:input path="content" type="text" class="form-control" id="content" placeholder="Search" />
                        <button class="btn btn-primary" type="submit">Search</button>
                    </div>
                </spring:bind>

            </form:form>

        </div>


    </div>

    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Id-Anuncio</th>
            <th>Data/Hora Criação</th>
            <th>Ações</th>

        </tr>
        <c:forEach  items="${chatList}" var ="chat">
            <tr>
                <td>${chat.id}</td>
                <td>${chat.anuncio_id}</td>
                <td>${chat.data_hora}</td>
                <td>
                    <a class="btn btn-info btn-xs" href="${pageContext.request.contextPath}/chat/${chat.id}">Visualizar</a>
                    <a class="btn btn-danger btn-xs" href="${pageContext.request.contextPath}/chat/delete/${chat.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<jsp:include page="../fragments/footer.jsp" />
