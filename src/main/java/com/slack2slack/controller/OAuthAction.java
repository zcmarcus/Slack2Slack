package com.slack2slack.controller;

import com.slack2slack.persistence.OAuthDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        logger.info("******Temporary Slack code: " + tempSlackCode);

        OAuthDao oAuthDao = new OAuthDao();
        String accessToken = oAuthDao.getOAuthResponse(tempSlackCode).getAccessToken();
        logger.info("******Access token: " + accessToken);
        //TODO: grab any other parameters we need for future slack api requests

        //Add the necessary OAuth tokens to the session
        HttpSession session = req.getSession();
        session.setAttribute("accessToken", accessToken);

        //TODO: Put the access token in the database

        //Forward to the home page
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}
