package com.slack2slack.controller;

import com.slack2slack.entity.User;
import com.slack2slack.persistence.GenericDao;
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
import java.util.List;

/**
 * Protected resource that simply redirects to the root. This is a hack to get around issue of Tomcat
 * security not liking direct navigation to the login page.
 */
@WebServlet(
        urlPatterns = {"/loginAction"}
)
public class LoginAction extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao userDao = new GenericDao(User.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        int userID = 0;
        List<User> user = userDao.getByPropertyEqual("userName", req.getRemoteUser());
        logger.debug(user.toString());
        if (user.size() == 1) {
            userID = user.get(0).getId();
        }
        logger.debug(userID);


        // set userID in session for use in calls to web service
        session.setAttribute("userID", userID);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

}