package com.slack2slack.persistence;

import com.slack2slack.entity.Role;
import com.slack2slack.entity.User;
import com.slack2slack.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


//TODO: Update with tests for user templates
class UserDaoTest {
    GenericDao genericDao;

    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb_v2.sql");

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

    /**
     * Verify successful update user
     */
    @Test
    void updateSuccess() {
        String newUserName = "Jane_Donaldson";
        User userToUpdate = (User)genericDao.getById(2);
        userToUpdate.setName(newUserName);
        genericDao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)genericDao.getById(2);
        assertEquals(userToUpdate, retrievedUser);
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {
        User newUser = new User("FredFlintstone", "fflintstone55");
        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals(newUser, insertedUser);
    }

    /**
     * Verify successful addition of user role
     */
    @Test
    void addUserRoleSuccess() {
        User newUser = new User("UserWithRoleTest", "specialpassword");

        String userRoleName = "admin";
        Role userRole = new Role(userRoleName, newUser);

        newUser.addRole(userRole);
        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);

        User insertedUser = (User)genericDao.getById(id);
        assertEquals(newUser, insertedUser);
        assertEquals(1, newUser.getRoles().size());
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(3));
        assertNull(genericDao.getById(3));
    }

    /**
     * Verify user roles are deleted if the user is deleted
     */
    @Test
    void deleteUserDeletesRolesSuccess() {
        genericDao.delete(genericDao.getById(1));

        GenericDao roleDao = new GenericDao(Role.class);
        assertEquals(null, roleDao.getById(1));
        assertEquals(null, roleDao.getById(2));
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<User> users = genericDao.getAll();
        assertEquals(4, users.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = genericDao.getByPropertyEqual("name", "donaldduck");
        assertEquals(1, users.size());
        assertEquals(4, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = genericDao.getByPropertyLike("name", "e");
        assertEquals(3, users.size());
    }
}