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

/*
* TODO: Comment here!
 */
@WebServlet(
        urlPatterns = {"/slackoauth"}
)
public class OAuthAction extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Note that the temporary code expires after 10 minutes
        String tempSlackCode = req.getParameter("code");
        logger.info("******slack code: " + tempSlackCode);

        //TODO: Next step: exchange the code for an access token, then put the access token in the database and the session

        //Forward to the home page
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}
