package com.slack2slack.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;

/**
 * Represents a Slack channel
 */
@Entity(name = "Channel")
@Table(name = "channel")
public class Channel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String name;

    private String topic;

    private String purpose;

    @ManyToOne
    @JoinColumn(name = "templateId",
            foreignKey = @ForeignKey(name = "channel_template_id_fk")
    )
    private Template template;

    /**
     * Instantiates a new Channel.
     */
    public Channel() {
    }

    /**
     * Instantiates a new Channel.
     *
     * @param name    the name
     * @param topic   the topic
     * @param purpose the purpose
     */
    public Channel(String name, String topic, String purpose, Template template) {
        this.name = name;
        this.topic = topic;
        this.purpose = purpose;
        this.template = template;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets topic.
     *
     * @return the topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Sets topic.
     *
     * @param topic the topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * Gets purpose.
     *
     * @return the purpose
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * Sets purpose.
     *
     * @param purpose the purpose
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /**
     * Gets template.
     *
     * @return the template
     */
    public Template getTemplate() {
        return template;
    }

    /**
     * Sets template.
     *
     * @param template the template
     */
    public void setTemplate(Template template) {
        this.template = template;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return id == channel.id &&
                Objects.equals(name, channel.name) &&
                Objects.equals(topic, channel.topic) &&
                Objects.equals(purpose, channel.purpose) &&
                Objects.equals(template, channel.template);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, topic, purpose, template);
    }

    @Override
    public String toString() {
        return "Channel{" +
                "name='" + name + '\'' +
                ", topic='" + topic + '\'' +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
