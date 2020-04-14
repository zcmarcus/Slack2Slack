package com.slack2slack.controller;

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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        String[] channelNames = req.getParameterValues("channelName");
        String[] channelTopics = req.getParameterValues("channelTopic");
        String[] channelPurposes = req.getParameterValues("channelPurpose");
        String[] channelIds = req.getParameterValues("channelId");

        String templateName = req.getParameter("templateName");
        String ownerFirstName = req.getParameter("ownerFirstName");

        String ownerLastName = req.getParameter("ownerLastName");
        String ownerDisplayName = req.getParameter("ownerDisplayName");
        String ownerEmail = req.getParameter("ownerEmail");
        String iconUrl = req.getParameter("iconUrl");
        String templateId = req.getParameter("templateId");

        List<Channel> channels = new ArrayList<>();

        for (int i=0; i < channelNames.length; i++) {
            Channel channel = new Channel();
            channel.setId(Integer.parseInt(channelIds[i]));
            channel.setTopic(channelTopics[i]);
            channel.setPurpose(channelPurposes[i]);
            channel.setName(channelNames[i]);

            channels.add(channel);
        }


        User user = userDao.getById(userID);


        if (req.getParameter("templateId").isEmpty()) {

            Template template = new Template();

            template.setName(templateName);
            template.setOwnerFirstName(ownerFirstName);
            template.setOwnerLastName(ownerLastName);
            template.setOwnerDisplayName(ownerDisplayName);
            template.setIconUrl(iconUrl);
            template.setUser(user);
            template.setOwnerEmail(ownerEmail);

            for (Channel channel : channels) {
                channel.setTemplate(template);
            }

            template.setChannels(channels);

            templateDao.insert(template);


        } else {
            int id = Integer.parseInt(templateId);

            Template template = new Template();

            template.setName(templateName);
            template.setOwnerFirstName(ownerFirstName);
            template.setOwnerLastName(ownerLastName);
            template.setOwnerDisplayName(ownerDisplayName);
            template.setIconUrl(iconUrl);
            template.setUser(user);
            template.setId(id);
            template.setOwnerEmail(ownerEmail);

            for (Channel channel : channels) {
                channel.setTemplate(template);
            }
            template.setChannels(channels);

            templateDao.saveOrUpdate(template);
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);

    }


}