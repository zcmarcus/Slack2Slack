package com.slack2slack.persistence;

import com.slack2slack.entity.User;
import com.slack2slack.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    GenericDao genericDao;

    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        genericDao = new GenericDao(User.class);
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)genericDao.getById(3);
        assertNotNull(retrievedUser);
        assertEquals("JANEDOE", retrievedUser.getName());
        assertEquals("secret", retrievedUser.getPassword());
    }

}