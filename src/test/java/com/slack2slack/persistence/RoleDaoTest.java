package com.slack2slack.persistence;

import com.slack2slack.entity.Role;
import com.slack2slack.entity.Template;
import com.slack2slack.entity.User;
import com.slack2slack.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoleDaoTest {
    GenericDao genericDao;

    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        genericDao = new GenericDao(Role.class);
    }

    /**
     * Verify successful retrieval of a role
     */
    @Test
    void getByIdSuccess() {
        GenericDao userDao = new GenericDao(User.class);
        User user = (User)userDao.getById(2);
        Role role = (Role)genericDao.getById(3);
        assertNotNull(role);
        assertEquals(user, role.getUser());
    }

    /**
     * Verify successful insert of a role
     */
    @Test
    void insertSuccess() {
        GenericDao userDao = new GenericDao(User.class);
        User user = (User)userDao.getById(4);
        Role newRole = new Role("admin", user);
        user.addRole(newRole);

        int id = genericDao.insert(newRole);
        Role insertedRole = (Role)genericDao.getById(id);
        assertNotEquals(0,id);
        assertEquals(user, insertedRole.getUser());
    }

    /**
     * Verify successful delete of a user's role
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(1));

        GenericDao userDao = new GenericDao(User.class);
        User userWithDeletedRole = (User)userDao.getById(1);

        assertNull(genericDao.getById(1));
        assertEquals(1, userWithDeletedRole.getRoles().size());
    }

    /**
     * Verify successful retrieval of all roles
     */
    @Test
    void getAllSuccess() {
        List<Role> roles = genericDao.getAll();
        assertEquals(5, roles.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Role> roles = genericDao.getByPropertyEqual("roleName", "user");
        assertEquals(4, roles.size());
        assertEquals(2, roles.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Role> roles = genericDao.getByPropertyLike("roleName", "u");
        assertEquals(4, roles.size());
        assertEquals(2, roles.get(0).getId());
    }

}
