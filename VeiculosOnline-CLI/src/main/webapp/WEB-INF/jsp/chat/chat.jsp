<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../fragments/headerLogado.jsp" />

<div class="container mt-5">
    <h3 class=" text-center mt-3">Chat</h3>
    <div class="messaging">
        <div class="inbox_msg">
            <div class="mesgs">
                <div class="msg_history">
                    <c:set var="chat" value="${chat}"/>
                    <c:forEach items="${msgList}" var="msg">
                        <div class="${interessado_id == chat.usuario_id ? 'outcoming_msg' : 'incoming_msg'}">
                            <div class="${interessado_id == chat.usuario_id ? 'outcoming_msg_img' : 'incoming_msg_img'}"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
                            <div class="${interessado_id == chat.usuario_id ? 'sent_msg' : 'received_msg'}">
                                <div class="${interessado_id == chat.usuario_id ? '' : 'received_withd_msg'}">
                                    <p>${msg.texto}</p>
                                    <span class="time_date">${msg.data_hora}</span>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="type_msg">
                    <div class="input_msg_write text-center">
                        <input type="text" class="write_msg" placeholder="Type a message" />
                        <button class="msg_send_btn" type="button"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button>
                    </div>
                </div>
            </div>
        </div>




    </div></div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>