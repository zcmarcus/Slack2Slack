package com.slack2slack.persistence;

import com.slack2slack.entity.Template;
import com.slack2slack.entity.Channel;
import com.slack2slack.entity.User;
import com.slack2slack.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TemplateDaoTest {
    GenericDao genericDao;

    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        genericDao = new GenericDao(Template.class);
    }

    /**
     * Verify successful retrieval of a template
     */
    @Test
    void getByIdSuccess() {
        Template retrievedTemplate = (Template)genericDao.getById(1);
        assertNotNull(retrievedTemplate);
        assertEquals("Basic", retrievedTemplate.getName());
        assertEquals("https://cdn0.iconfinder.com/data/icons/customicondesignoffice5/256/examples.png", retrievedTemplate.getIconUrl());
    }

    /**
     * Verify successful update of a template
     */
    @Test
    void updateSuccess() {
        String newTemplateName = "Updated_Template";
        Template templateToUpdate = (Template)genericDao.getById(1);
        templateToUpdate.setName(newTemplateName);
        genericDao.saveOrUpdate(templateToUpdate);
        Template retrievedTemplate = (Template)genericDao.getById(1);
        assertEquals(templateToUpdate, retrievedTemplate);
    }

    /**
     * Verify successful insert of a template
     */
    @Test
    void insertSuccess() {
        GenericDao userDao = new GenericDao(User.class);
        User user = (User)userDao.getById(2);

        Template newTemplate = new Template("New Template", "www.fakeimage.com", "{\"email\": \"newemail@gmail.com\", \"last_name\": \"Jones\", \"first_name\": \"Joe\", \"display_name\": \"MrJones\"}", user);
        int id = genericDao.insert(newTemplate);
        assertNotEquals(0,id);
        Template insertedTemplate = (Template)genericDao.getById(id);
        assertEquals(newTemplate, insertedTemplate);
    }

    /**
     * Verify successful delete of a template
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(1));
        assertNull(genericDao.getById(1));
    }

    /**
     * Verify channels are deleted if the template is deleted
     */
    @Test
    void deleteTemplateDeletesChannelsSuccess() {
        genericDao.delete(genericDao.getById(1));

        GenericDao channelDao = new GenericDao(Channel.class);
        assertEquals(null, channelDao.getById(1));
        assertEquals(null, channelDao.getById(2));
        assertEquals(null, channelDao.getById(3));
    }

    /**
     * Verify successful retrieval of all templates
     */
    @Test
    void getAllSuccess() {
        List<Template> templates = genericDao.getAll();
        assertEquals(1, templates.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        //TODO: Get all templates by user_Id...running into error though
        List<Template> templates = genericDao.getByPropertyEqual("name", "Basic");
        assertEquals(1, templates.size());
        assertEquals(1, templates.get(0).getId());
    }
}
