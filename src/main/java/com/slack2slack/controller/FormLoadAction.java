package com.slack2slack.controller;

import com.slack2slack.consume.TemplateItem;
import com.slack2slack.consume.TemplatesCollection;
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
        TemplatesCollection templatesCollection = templatesResponseDao.getTemplates(userID);
        List<TemplateItem> templates = templatesCollection.getTemplates();
        logger.debug("templates : {}", templates);

        req.setAttribute("userTemplates", templates);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/chooseTemplate.jsp");
        dispatcher.forward(req, resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("chooseTemplate").equals("new")) {
            // Show blank template

        } else {
            int templateID = Integer.parseInt(req.getParameter("chooseTemplate"));



//            List<TemplatesItem> templates = (List<TemplatesItem>)session.getAttribute("userTemplates");

            TemplatesResponseDao templatesResponseDao = new TemplatesResponseDao();
            TemplateItem template = templatesResponseDao.getTemplateByID(templateID);

            req.setAttribute("currentTemplate", template);
        }




        RequestDispatcher dispatcher = req.getRequestDispatcher("/configureWorkspace.jsp");
        dispatcher.forward(req, resp);



    }
}
