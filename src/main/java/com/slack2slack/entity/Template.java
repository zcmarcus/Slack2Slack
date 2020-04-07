package com.slack2slack.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.json.JsonObject;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a template for a Slack workspace
 */
@Entity(name = "Template")
@Table(name = "template")
public class Template {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String name;

    private  String iconUrl;

    private String primaryOwnerProfile;

    @ManyToOne
    @JoinColumn(name = "user_Id",
            foreignKey = @ForeignKey(name = "template_user_id_fk")
    )
    private User user;

    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Channel> channels = new ArrayList<>();

    /**
     * Instantiates a new Template (empty constructor)
     */
    public Template() {
    }

    /**
     * Instantiates a new Template.
     *
     * @param name                the name
     * @param iconUrl             the icon url
     * @param primaryOwnerProfile the primary owner profile
     * @param user                the slack2slack user
     */
    public Template(String name, String iconUrl, String primaryOwnerProfile, User user) {
        this.name = name;
        this.iconUrl = iconUrl;
        this.primaryOwnerProfile = primaryOwnerProfile;
        this.user = user;
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
     * Gets icon url.
     *
     * @return the icon url
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * Sets icon url.
     *
     * @param iconUrl the icon url
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * Gets primary owner profile.
     *
     * @return the primary owner profile
     */
    public String getPrimaryOwnerProfile() {
        return primaryOwnerProfile;
    }

    /**
     * Sets primary owner profile.
     *
     * @param primaryOwnerProfile the primary owner profile
     */
    public void setPrimaryOwnerProfile(String primaryOwnerProfile) {
        this.primaryOwnerProfile = primaryOwnerProfile;
    }

    /**
     * Gets slack2slack user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets slack2slack user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets channels.
     *
     * @return the channels
     */
    public List<Channel> getChannels() {
        return channels;
    }

    /**
     * Sets channels.
     *
     * @param channels the channels
     */
    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    /**
     * Add channel.
     *
     * @param channel the channel
     */
    public void addChannel(Channel channel) {
        channels.add(channel);
        channel.setTemplate(this);
    }

    /**
     * Remove channel.
     *
     * @param channel the channel
     */
    public void removeChannel(Channel channel) {
        channels.remove(channel);
        channel.setTemplate(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Template template = (Template) o;
        return id == template.id &&
                Objects.equals(name, template.name) &&
                Objects.equals(iconUrl, template.iconUrl) &&
                Objects.equals(primaryOwnerProfile, template.primaryOwnerProfile) &&
                Objects.equals(user, template.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, iconUrl, primaryOwnerProfile, user);
    }

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", primaryOwnerProfile=" + primaryOwnerProfile +
                '}';
    }
}
