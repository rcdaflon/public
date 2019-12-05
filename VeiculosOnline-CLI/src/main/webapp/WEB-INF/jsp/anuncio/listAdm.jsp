<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../fragments/headerAdm.jsp" />

<div class="container mt-5">

    <h1>Anúncios em Avaliação</h1>

    <div id="top" class="row">
        <div class="col-sm-6">

            <form:form method="post" modelAttribute="search" action="${pageContext.request.contextPath}/anuncio/listAdm" >

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
            <a class="btn btn-primary pull-right h2" href="${pageContext.request.contextPath}/anuncio/add">Add</a>
        </div>
    </div>

    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Título</th>
            <th>Descricao</th>
            <th>Preço</th>
            <th>Laudo veicular</th>
            <th>Status</th>
            <th>Ações</th>
            <th><i class="fa fa-eye"></i></th>

        </tr>
        <c:forEach  items="${anuncioList}" var ="anuncio">
            <tr>
                <td>${anuncio.id}</td>
                <td>${anuncio.titulo}</td>
                <td>${anuncio.descricao}</td>
                <td>${anuncio.preco}</td>
                <td><a href="#">${anuncio.laudo_veicular}<a></td>
                <td>${anuncio.status}</td>
                <td>
                    <a class="btn btn-info btn-xs mr-2" href="${pageContext.request.contextPath}/anuncio/editAdm/${anuncio.id}">Edit</a>
                </td>
                <td>
                    <a class="ml-2" href="${pageContext.request.contextPath}/anuncio/${anuncio.id}" target="_blank"><i class="fa fa-eye" style="color: black"></i></a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<jsp:include page="../fragments/footer.jsp" />
