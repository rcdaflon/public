/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.validator.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 *
 * @author Marcelo
 */
@Component
public class ServiceInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("User email session: " + request.getSession().getAttribute("email"));

        String uri = request.getRequestURI();

        //request.
        
        if (uri.equals("/VeiculosOnline-cli/") || uri.endsWith("login") || uri.endsWith("usuario/add") || uri.endsWith("home") || uri.contains("anuncio") 
                || !uri.endsWith("anuncio/add") || !uri.endsWith("anuncio/listAdm") || !uri.endsWith("anuncio/list") || !uri.endsWith("anuncio/edit") || 
                uri.endsWith("verify") || uri.endsWith("error") || uri.contains("resources") || uri.endsWith("dashboard")) {
            return true;
        }
        
        if (request.getSession().getAttribute("email") != null) {
            return true;
        } 
        
        response.sendRedirect("error");
        return false;
    }
}
