package com.slack2slack.api;

/**
 * The type Create conversation parameters.
 */
public class CreateConversationParameters {
    private String name;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name. Channel names may only contain lowercase letters, numbers, hyphens, and underscores,
     * and must be 80 characters or less.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}
