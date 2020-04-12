package com.slack2slack.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet for redirecting user to home page after
 * log in attempt.
 */
@WebServlet(
        urlPatterns = {"/login"}
)
public class Login extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // TODO: Remember to comment out following line in tomcat/conf/logging.properties when not debugging:
        // 1catalina.org.apache.juli.FileHandler.bufferSize = -1

//        logger.error("Logged user : " + req.getRemoteUser() + " has role of user (true/false): " + req.isUserInRole("user"));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

}