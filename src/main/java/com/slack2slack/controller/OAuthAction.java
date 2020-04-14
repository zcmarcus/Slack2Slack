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
* This servlet is what users land on after agreeing to give Slack permission to their workspace.
* This servlet receives a temporary code from Slack and then calls the Slack oauth.v2.access method to
* obtain authentication parameters that will be used by the Slack2Slack app when making calls to the Slack API.
*
* IMPORTANT: If this servlet's urlPattern is changed, it must also be changed on the OAuth & Permissions page of the online Slack API console.
 */
@WebServlet(
        urlPatterns = {"/slackoauth"}
)
public class OAuthAction extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        //Note that the temporary code expires after 10 minutes
        String tempSlackCode = req.getParameter("code");
        logger.info("******Temporary Slack code: " + tempSlackCode);

        OAuthDao oAuthDao = new OAuthDao();
        String accessToken = oAuthDao.getOAuthResponse(tempSlackCode).getAccessToken();
        logger.info("******Access token: " + accessToken);
        //TODO: If null set an error?


        //Add the necessary OAuth tokens to the session
        session.setAttribute("accessToken", accessToken);

        //Forward to the home page
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}