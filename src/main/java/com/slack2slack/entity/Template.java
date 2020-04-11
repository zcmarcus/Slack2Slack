package com.slack2slack.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a template with (profile info exploded into separate fields) for a Slack workspace
 */
@Entity(name = "Template")
@Table(name = "template")
public class Template {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String name;

    private String iconUrl;

    private String ownerFirstName;

    private String ownerLastName;

    private String ownerDisplayName;

    private String ownerEmail;

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

    public Template(String name, String iconUrl, String ownerFirstName, String ownerLastName, String ownerDisplayName, String ownerEmail, User user) {
        this.name = name;
        this.iconUrl = iconUrl;
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.ownerDisplayName = ownerDisplayName;
        this.ownerEmail = ownerEmail;
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
     * Gets owner first name.
     *
     * @return the owner first name
     */
    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    /**
     * Sets owner first name.
     *
     * @param ownerFirstName the owner first name
     */
    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    /**
     * Gets owner last name.
     *
     * @return the owner last name
     */
    public String getOwnerLastName() {
        return ownerLastName;
    }

    /**
     * Sets owner last name.
     *
     * @param ownerLastName the owner last name
     */
    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    /**
     * Gets owner display name.
     *
     * @return the owner display name
     */
    public String getOwnerDisplayName() {
        return ownerDisplayName;
    }

    /**
     * Sets owner display name.
     *
     * @param ownerDisplayName the owner display name
     */
    public void setOwnerDisplayName(String ownerDisplayName) {
        this.ownerDisplayName = ownerDisplayName;
    }

    /**
     * Gets owner email.
     *
     * @return the owner email
     */
    public String getOwnerEmail() {
        return ownerEmail;
    }

    /**
     * Sets owner email.
     *
     * @param ownerEmail the owner email
     */
    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
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
        Template that = (Template) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(iconUrl, that.iconUrl) &&
                Objects.equals(ownerFirstName, that.ownerFirstName) &&
                Objects.equals(ownerLastName, that.ownerLastName) &&
                Objects.equals(ownerDisplayName, that.ownerDisplayName) &&
                Objects.equals(ownerEmail, that.ownerEmail) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, iconUrl, ownerFirstName, ownerLastName, ownerDisplayName, ownerEmail, user);
    }

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", ownerFirstName='" + ownerFirstName + '\'' +
                ", ownerLastName='" + ownerLastName + '\'' +
                ", ownerDisplayName='" + ownerDisplayName + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                '}';
    }
}
