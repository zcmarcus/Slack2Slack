package com.slack2slack.controller;

import com.slack2slack.api.SlackApi;
import com.slack2slack.entity.Channel;
import com.slack2slack.entity.Template;
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
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet(
        urlPatterns = {"/templateAction"}
)
public class TemplateAction extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private final GenericDao<Template> templateDao = new GenericDao<>(Template.class);
    private final GenericDao<User> userDao = new GenericDao<>(User.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        HttpSession session = req.getSession();
        int userID = (int) session.getAttribute("userID");

        String channel1Name = req.getParameter("channel1name");
        String channel1Purpose = req.getParameter("channel1purpose");
        String channel1Topic = req.getParameter("channel1topic");

        String channel2Name = req.getParameter("channel2name");
        String channel2Purpose = req.getParameter("channel2purpose");
        String channel2Topic = req.getParameter("channel2topic");

        String channel3Name = req.getParameter("channel3name");
        String channel3Purpose = req.getParameter("channel3purpose");
        String channel3Topic = req.getParameter("channel3topic");

        String templateName = req.getParameter("templateName");
        String ownerFirstName = req.getParameter("ownerFirstName");
        String ownerLastName = req.getParameter("ownerLastName");
        String ownerDisplayName = req.getParameter("ownerDisplayName");
        String ownerEmail = req.getParameter("ownerEmail");
        String iconUrl = req.getParameter("iconUrl");
        String templateId = req.getParameter("templateId");


        User user = userDao.getById(userID);

        String submitAction = req.getParameter("submit");


        // user clicks button to populate Slack workspace with form fields
        if(submitAction.equals("addToSlackWorkspace")) {
            logger.debug("addToSlackWorkspace clicked");
            logger.debug("accessToken: {}", session.getAttribute("accessToken"));
            SlackApi slackApi = new SlackApi((String) session.getAttribute("accessToken"));

            slackApi.createChannel(channel1Name, (String)session.getAttribute("accessToken"));
            slackApi.createChannel(channel2Name, (String)session.getAttribute("accessToken"));
            slackApi.createChannel(channel3Name, (String)session.getAttribute("accessToken"));



        } else {

            if (req.getParameter("templateId").isEmpty()) {

                Template template = new Template();
                Channel channel = new Channel();

                template.setName(templateName);
                template.setOwnerFirstName(ownerFirstName);
                template.setOwnerLastName(ownerLastName);
                template.setOwnerDisplayName(ownerDisplayName);
                template.setIconUrl(iconUrl);
                template.setUser(user);
                template.setOwnerEmail(ownerEmail);

                channel.setName(channel1Name);
                channel.setPurpose(channel1Purpose);
                channel.setTopic(channel1Topic);

                template.addChannel(channel);

                templateDao.insert(template);


            } else {
                int id = Integer.parseInt(templateId);

                Template template = new Template();
                Channel channel = new Channel();

                template.setName(templateName);
                template.setOwnerFirstName(ownerFirstName);
                template.setOwnerLastName(ownerLastName);
                template.setOwnerDisplayName(ownerDisplayName);
                template.setIconUrl(iconUrl);
                template.setUser(user);
                template.setId(id);
                template.setOwnerEmail(ownerEmail);

                channel.setName(channel1Name);
                channel.setPurpose(channel1Purpose);
                channel.setTopic(channel1Topic);

                template.addChannel(channel);

                templateDao.saveOrUpdate(template);
            }
        }




        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);

    }


}
