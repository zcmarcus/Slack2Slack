package com.slack2slack.persistence;

import com.slack2slack.entity.Template;
import com.slack2slack.test.util.Database;
import org.junit.jupiter.api.BeforeEach;

public class TemplateDaoTest {
    GenericDao genericDao;

    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        genericDao = new GenericDao(Template.class);
    }
}
