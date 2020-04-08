package com.slack2slack.persistence;

import com.slack2slack.entity.Channel;
import com.slack2slack.entity.Role;
import com.slack2slack.entity.Template;
import com.slack2slack.entity.User;
import com.slack2slack.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChannelDaoTest {
    GenericDao genericDao;

    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        genericDao = new GenericDao(Channel.class);
    }

    /**
     * Verify successful retrieval of a channel
     */
    @Test
    void getByIdSuccess() {
        GenericDao templateDao = new GenericDao(Template.class);
        Template template = (Template)templateDao.getById(1);
        Channel channel = (Channel)genericDao.getById(3);
        assertNotNull(channel);
        assertEquals(template, channel.getTemplate());
    }

    /**
     * Verify successful insert of a channel
     */
    @Test
    void insertSuccess() {
        GenericDao templateDao = new GenericDao(Template.class);
        Template template = (Template)templateDao.getById(1);
        Channel channel = new Channel("New Channel", "A good name", "Here's the purpose", template);
        template.addChannel(channel);

        int id = genericDao.insert(channel);
        Channel insertedChannel = (Channel)genericDao.getById(id);
        assertNotEquals(0,id);
        assertEquals(template, insertedChannel.getTemplate());
    }

    /**
     * Verify successful delete of a channel
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(1));

        GenericDao templateDao = new GenericDao(Template.class);
        Template templateWithDeletedChannel = (Template)templateDao.getById(1);

        assertNull(genericDao.getById(1));
        assertEquals(2, templateWithDeletedChannel.getChannels().size());
    }
}
