/*
 * Copyright 2016 Pelayo José Lluna González.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pelayolluna.filmviewerservice.controller;

import java.io.IOException;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Pelayo José Lluna González
 */
public class Login {

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        final ResourceBundle rb = ResourceBundle.getBundle("login");
        String jsp = "/FilmViewerService/WEB-INF/jsp/errorLogin.jsp";
        String user = "";
        char[] password = {};

        if (request.getParameter("user") != null) {
            user = request.getParameter("user");
        }

        if (request.getParameter("password") != null) {
            password = request.getParameter("password").toCharArray();
        }

        if (user != null && user.equals(rb.getString("user")) && password != null && String.valueOf(password).equals(rb.getString("password"))) {
            request.getSession().setAttribute("user", request.getParameter("user"));
            jsp = "/FilmViewerService/WEB-INF/jsp/menu.jsp";
        }

        password = null;
        request.getRequestDispatcher(jsp).forward(request, response);
    }
}
