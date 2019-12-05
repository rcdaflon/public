<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var = "tipo" scope = "session" value = "${usuario_tipo}"/>
<c:choose>
    <c:when test="${usuario_tipo == 'USR'}">
        <jsp:include page="../fragments/headerLogado.jsp" />
    </c:when>
    <c:otherwise>
        <jsp:include page="../fragments/headerVisitante.jsp" />
    </c:otherwise>
</c:choose>

<main role="main">

    <c:if test="${fotosList.size() > '0'}">
        <div class="shadow-lg mb-0" data-ride="carousel">
            <div class="carousel-inner" style="width: 100%; height: 360px;">
                <div class="carousel-item active"> 
                    <!--<svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"><rect width="100%" height="100%" fill="#777"/></svg>-->

                    <div class="row" style="height: 360px">
                        <c:if test="${fotosList.size() > '0'}">
                            <c:if test="${fotosList.size() < '3'}">
                                <div class="col-xl-6 col-lg-6 mx-0 mt-2 px-0">
                                    <img class="img-responsive" src="data:image/png;base64,${fotosList.get(0)}" width="100%" height="100%" role="img" />                      
                                </div>
                                <div class="col-xl-6 col-lg-6 mx-0 mt-2 px-0">
                                    <img class="img-responsive" src="data:image/png;base64,${fotosList.get(1)}" width="100%" height="100%" role="img" />                                 
                                </div>
                            </c:if>
                            <c:if test="${fotosList.size() >= '3'}">
                                <div class="col-xl-4 col-lg-6 mx-0 mt-2 px-0">
                                    <img class="img-responsive" src="data:image/png;base64,${fotosList.get(0)}" width="100%" height="100%" role="img" />                      
                                </div>
                                <div class="col-xl-4 col-lg-6 mx-0 mt-2 px-0">
                                    <img class="img-responsive" src="data:image/png;base64,${fotosList.get(1)}" width="100%" height="100%" role="img" />                                 
                                </div>
                                <div class="col-xl-4 col-lg-6 mt-lg-5 mt-xl-0 mx-0 mt-2 px-0">
                                    <img class="img-responsive" src="data:image/png;base64,${fotosList.get(2)}" width="100%" height="100%" role="img" />                      
                                </div>
                            </c:if>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>

        <div class="text-center mb-5">
            <a class="mx-auto" data-target="#imgModal" data-toggle="modal" href="#imgModal">
                Abrir slide de fotos
            </a>
        </div>
        <!-- Modal -->
        <div class="modal fade mx-auto" id="imgModal" tabindex="-1" role="dialog" aria-labelledby="imgModalTittle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered pt-0 mt-0" style="height:50%;">
                <div class="modal-content pt-0" style="height: 62px; margin-top: -220px;">
                    <div class="modal-header">
                        <a class="" href="#myCarousel2" role="button" data-slide="prev" style="color: black">
                            <i class="fa fa-arrow-left" style="color: black"></i>
                        </a>
                        <a class="ml-3" href="#myCarousel2" role="button" data-slide="next">
                            <i class="fa fa-arrow-right" style="color: black"></i>
                        </a>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div id="myCarousel2" class="carousel slide my-0 py-0" data-ride="carousel" data-interval="1500" style="height: auto">
                            <div class="carousel-inner">
                                <c:if test="${fotosList.size() > '0'}">            
                                    <c:forEach items="${fotosList}" var="foto">
                                        <div class="carousel-item ${fotosList.get(0) == foto ? 'active' :''}">
                                            <img style="height: auto; width: auto;" src="data:image/png;base64,${foto}" role="img" />                      
                                        </div>
                                    </c:forEach>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
        
    <c:if test="${fotosList.size() == '0'}">
        <div class="mt-5 mb-5"></div>
    </c:if>

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
                        <a style="text-decoration: none;" class="text-center btn-lg btn-success btn-block" href="${pageContext.request.contextPath}/chat/${anuncio.usuario_id}/${anuncio.id}">Chat</a>
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