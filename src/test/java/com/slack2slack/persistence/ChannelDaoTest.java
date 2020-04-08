package com.slack2slack.persistence;

import com.slack2slack.entity.Channel;
import com.slack2slack.entity.Template;
import com.slack2slack.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
     * Verify successful update of a channel
     */
    @Test
    void updateSuccess() {
        String newChannelName = "Updated_Channel";
        Channel channelToUpdate = (Channel)genericDao.getById(2);
        channelToUpdate.setName(newChannelName);
        genericDao.saveOrUpdate(channelToUpdate);
        Channel retrievedChannel = (Channel)genericDao.getById(2);
        assertEquals(channelToUpdate, retrievedChannel);
    }

    /**
     * Verify successful delete of a channel also deletes it from the template
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(1));

        GenericDao templateDao = new GenericDao(Template.class);
        Template templateWithDeletedChannel = (Template)templateDao.getById(1);

        assertNull(genericDao.getById(1));
        assertEquals(2, templateWithDeletedChannel.getChannels().size());
    }

    /**
     * Verify successful retrieval of all channels
     */
    @Test
    void getAllSuccess() {
        List<Channel> channels = genericDao.getAll();
        assertEquals(3, channels.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Channel> channels = genericDao.getByPropertyEqual("template", 1);
        assertEquals(3, channels.size());
        assertEquals(1, channels.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Template> templates = genericDao.getByPropertyLike("name", "week");
        assertEquals(2, templates.size());
    }
}
