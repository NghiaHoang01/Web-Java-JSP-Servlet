/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet("/validate-otp")
public class ValidateOtpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = String.valueOf(req.getParameter("otpvalue"));

        String otp = String.valueOf(req.getSession().getAttribute("otp"));

        RequestDispatcher dispatcher = null;

        if (value.equals(otp)) {

//            req.setAttribute("email", req.getParameter("email"));
//            req.setAttribute("status", "success");
            dispatcher = req.getRequestDispatcher("ResetPassword.jsp");
            dispatcher.forward(req, resp);

        } else {
            req.setAttribute("message", "Wrong OTP");

            dispatcher = req.getRequestDispatcher("ValidateOtp.jsp");
            dispatcher.forward(req, resp);

        }
    }

}
