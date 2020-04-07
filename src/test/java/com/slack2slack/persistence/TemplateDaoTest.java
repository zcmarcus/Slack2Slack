package com.slack2slack.persistence;

import com.slack2slack.entity.Template;
import com.slack2slack.entity.Channel;
import com.slack2slack.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
