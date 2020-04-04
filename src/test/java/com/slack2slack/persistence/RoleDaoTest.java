package com.slack2slack.persistence;

import com.slack2slack.entity.Role;
import com.slack2slack.entity.User;
import com.slack2slack.test.util.Database;
import org.junit.jupiter.api.BeforeEach;

public class RoleDaoTest {
    GenericDao genericDao;

    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        genericDao = new GenericDao(Role.class);
    }

    //ToDO: Continue here!
}
