package com.company.store.web;

import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "Controller",urlPatterns = {"/controller}"})
public class Controller extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //從client 提交的 操作參數
        String action = request.getParameter("action");
    }
}
