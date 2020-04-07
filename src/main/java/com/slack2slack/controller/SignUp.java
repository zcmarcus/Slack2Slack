package com.slack2slack.controller;

import com.slack2slack.entity.Role;
import com.slack2slack.entity.User;
import com.slack2slack.persistence.GenericDao;
import org.apache.catalina.realm.MessageDigestCredentialHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet (
    urlPatterns = { "/signup" }
)
public class SignUp extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao userDao = new GenericDao(User.class);

        String plainTextPassword = req.getParameter("password");
        MessageDigestCredentialHandler credentialHandler = new MessageDigestCredentialHandler();
        try {
            credentialHandler.setAlgorithm("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            logger.error("Algorithm {} could not be found", "SHA-256");
        }
        credentialHandler.setEncoding("UTF-8");
        String hashedPassword = credentialHandler.mutate(plainTextPassword);



        User user = new User(
                req.getParameter("name")
                ,hashedPassword
        );

        int newUserId = userDao.insert(user);


        if (newUserId > 0) {
            // If role other than default "user" set in request, create associated role along with new user
            GenericDao roleDao = new GenericDao(Role.class);
            Role userRole;
            if (req.getParameterMap().containsKey("role_name")) {
                userRole = new Role(req.getParameter("role_name"), user);
            } else {
                userRole = new Role("user", user);
            }
            user.addRole(userRole);
            int newUserRoleId = roleDao.insert(userRole);
        }

        req.setAttribute("newUserId", newUserId);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}