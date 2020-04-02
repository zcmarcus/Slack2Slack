package com.slack2slack.entity;


import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * Represents a Slack2Slack user's role
 *
 * @author Kelly Palese
 */
@Entity(name = "Role")
@Table(name = "user_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name="role_name")
    private String roleName;

    //TODO: Coming back to this after creating generic DAO and User Dao test


}
