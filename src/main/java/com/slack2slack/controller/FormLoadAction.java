package com.slack2slack.controller;

import com.slack2slack.consume.TemplatesItem;
import com.slack2slack.consume.TemplatesResponse;
import com.slack2slack.entity.Template;
import com.slack2slack.persistence.*;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet (
        urlPatterns = { "/formLoadAction" }
)
public class FormLoadAction extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int userID = (int) session.getAttribute("userID");

        TemplatesResponseDao templatesResponseDao = new TemplatesResponseDao();
//        if(submitAction!=null) {
        TemplatesResponse templatesResponse = templatesResponseDao.getTemplates(userID);
        logger.debug("templates response: {}", templatesResponse);
        List<TemplatesItem> templates = templatesResponse.getTemplates();
        req.setAttribute("userTemplates", templates);
//        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/configureWorkspace.jsp");
        dispatcher.forward(req, resp);



    }
}
