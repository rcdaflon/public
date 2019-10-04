<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../fragments/headerLogado.jsp" />

<div class="container mt-5">

    <h1>Meus anúncios</h1>

    <div id="top" class="row">
        <div class="col-sm-6">

            <form:form method="post" modelAttribute="search" action="${pageContext.request.contextPath}/anuncio/listUser" >

                <spring:bind path="content">
                    <div class="input-group h2">
                        <form:input path="content" type="text" class="form-control" id="content" placeholder="Search" />
                        <button class="btn btn-primary" type="submit">Search</button>
                    </div>
                </spring:bind>

            </form:form>

        </div>

        <div class="col-sm-6">
            <a class="btn btn-primary float-right h2" href="${pageContext.request.contextPath}/anuncio/add">Add</a>
        </div>
    </div>

    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Título</th>
            <th>Descricao</th>
            <th>Preço</th>
            <th>Status</th>
            <th>Ações</th>

        </tr>
        <c:forEach  items="${anuncioList}" var ="anuncio">
            <tr>
                <td>${anuncio.id}</td>
                <td>${anuncio.titulo}</td>
                <td>${anuncio.descricao}</td>
                <td>${anuncio.preco}</td>
                <td>${anuncio.status}</td>
                <td>
                    <a class="btn btn-info btn-xs" href="${pageContext.request.contextPath}/anuncio/editUser/${anuncio.id}">Edit</a>
                    <a class="btn btn-danger btn-xs" href="${pageContext.request.contextPath}/anuncio/delete/${anuncio.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<jsp:include page="../fragments/footer.jsp" />
