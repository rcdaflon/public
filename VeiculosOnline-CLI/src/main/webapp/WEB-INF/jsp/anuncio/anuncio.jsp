<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var = "tipo" scope = "session" value = "${usuario_tipo}"/>
<c:choose>
    <c:when test="${usuario_tipo == 'ADM'}">
        <jsp:include page="../fragments/headerAdm.jsp" />
    </c:when>
    <c:when test="${usuario_tipo == 'USR'}">
        <jsp:include page="../fragments/headerLogado.jsp" />
    </c:when>
    <c:otherwise>
        <jsp:include page="../fragments/headerVisitante.jsp" />
    </c:otherwise>
</c:choose>

<main role="main">

    <div id="myCarousel" class="shadow-lg carousel slide" style="" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"><rect width="100%" height="100%" fill="#777"/></svg>

            </div>
            <div class="carousel-item">
                <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"><rect width="100%" height="100%" fill="#777"/></svg>
                <div class="container">
                    <div class="carousel-caption">
                        <h1>Another example headline.</h1>
                        <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>

                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"><rect width="100%" height="100%" fill="#777"/></svg>
                <div class="container">
                    <div class="carousel-caption text-right">
                        <h1>One more for good measure.</h1>
                        <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>

                    </div>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Anterior</span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Próximo</span>
        </a>
    </div>


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container-fluid marketing">

        <!-- Three columns of text below the carousel -->

        <div class="row mb-3 ml-5 mr-5">
            <div class="col-1"></div>

            <div class="col mr-3 border border-success rounded shadow-lg">
                <div class="col mt-4 mb-2 mr-2 ml-2">
                    <div class="row">
                        <div class="col mb-3">
                            <h3>${anuncio.titulo}</h3>
                            <h5 class="text-muted"><i>"${anuncio.descricao}"</i></h5>
                        </div>
                        <div class="col-2">
                            <h3></br>R$ ${anuncio.preco}</h3>
                        </div>
                    </div>
                    <div class="row mt-4">
                        <div class="col">
                            <h6>Marca</h6>
                            <p>${anuncio.marca}</p>
                        </div>
                        <div class="col">
                            <h6>Ano</h6>
                            <p>${anuncio.ano}</p>
                        </div>
                        <div class="col">
                            <h6>Kilometragem</h6>
                            <p>${anuncio.kilometragem}</p>
                        </div>
                        <div class="col">
                            <h6>Motor</h6>
                            <p>${anuncio.motor}</p>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col">
                            <h6>Modelo</h6>
                            <p>${anuncio.modelo}</p>
                        </div>
                        <div class="col">
                            <h6>Cor</h6>
                            <p>${anuncio.cor}</p>
                        </div>
                        <div class="col">
                            <h6>Combustível</h6>
                            <p>${anuncio.combustivel}</p>
                        </div>
                        <div class="col">
                            <h6>Portas</h6>
                            <p>${anuncio.portas}</p>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col">
                            <h6>Câmbio</h6>
                            <p>${anuncio.cambio}</p>
                        </div>
                        <div class="col">
                            <h6>Final Placa</h6>
                            <p>${anuncio.final_placa}</p>
                        </div>
                        <div class="col">
                            <h6>Quantidade de Donos</h6>
                            <p>${anuncio.quantidade_donos}</p>
                        </div>
                        <div class="col">
                            <h6>Formas de Pagamento</h6>
                            <p>${anuncio.formas_pagamento}</p>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col">
                            <h6>Laudo Veicular</h6>
                            <p>${anuncio.laudo_veicular}</p>
                        </div>
                        <div class="col"></div>
                        <div class="col"></div>
                        <div class="col"></div>
                    </div>
                </div>
            </div>

            <!-- link chat -->
            <div class="col-3 mr-3 border border-success rounded shadow-lg">
                <div class="row text-center">
                    <div class="col-1"></div>
                    <div class="col text-center"><p><br /><br /></p>
                        <img  src="https://img.icons8.com/ios/50/000000/new-message.png" width="" height="" />
                        <h3><br />Interessado?</h3>
                        <h6><br />Entre em contato com o dono do anúncio para maiores informações e possíveis negociações.<br /><br /></h6>
                        <a style="text-decoration: none;" class="text-center btn-lg btn-success btn-block" href="${pageContext.request.contextPath}/chat/${usuario_id}/${anuncio.id}">Chat</a>
                    </div>
                    <div class="col-1"></div>
                </div>
            </div>

            <div class="col-1"></div>
        </div>

    </div>

    <!-- chat
    <div style=" float:right; height: 250px;" class="col-lg-5">

        <div style=" height:250px;" class="mesgs">
            <div style="border-style:ridge; height:250px;" class="msg_history">
                <div class="incoming_msg">
                    <div class="incoming_msg_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
                    <div class="received_msg">
                        <div class="received_withd_msg">
                            <p>Test which is a new approach to have all
                                solutions</p>
                            <span class="time_date"> 11:01 AM    |    June 9</span></div>
                    </div>
                </div>
                <div class="outgoing_msg">
                    <div class="sent_msg">
                        <p>Test which is a new approach to have all
                            solutions</p>
                        <span class="time_date"> 11:01 AM    |    June 9</span> </div>
                </div>
                <div class="incoming_msg">
                    <div class="incoming_msg_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
                    <div class="received_msg">
                        <div class="received_withd_msg">
                            <p>Test, which is a new approach to have</p>
                            <span class="time_date"> 11:01 AM    |    Yesterday</span></div>
                    </div>
                </div>
                <div class="outgoing_msg">
                    <div class="sent_msg">
                        <p>Apollo University, Delhi, India Test</p>
                        <span class="time_date"> 11:01 AM    |    Today</span> </div>
                </div>
                <div class="incoming_msg">
                    <div class="incoming_msg_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
                    <div class="received_msg">
                        <div class="received_withd_msg">
                            <p>We work directly with our designers and suppliers,
                                and sell direct to you, which means quality, exclusive
                                products, at a price anyone can afford.</p>
                            <span class="time_date"> 11:01 AM    |    Today</span></div>
                    </div>
                </div>
            </div>
            <div style="border-style:ridge;" class="type_msg">
                <div class="input_msg_write">
                    <input type="text" class="write_msg" placeholder="Type a message" />
                    <button class="msg_send_btn" type="button"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button>
                </div>
            </div>
        </div>
    </div>-->

</main>
<jsp:include page="../fragments/footer.jsp" />