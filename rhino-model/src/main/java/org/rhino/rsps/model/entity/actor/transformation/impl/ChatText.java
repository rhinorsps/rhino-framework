package org.rhino.rsps.model.entity.actor.transformation.impl;

import org.rhino.rsps.model.entity.actor.transformation.Transformation;

public class ChatText implements Transformation {

    private final String text;
    private final int effects;
    private final int color;
    private final Icon icon;

    public ChatText(String text, int effects, int color, Icon icon) {
        this.text = text;
        this.effects = effects;
        this.color = color;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public int getEffects() {
        return effects;
    }

    public int getColor() {
        return color;
    }

    public Icon getIcon() {
        return icon;
    }

    /**
     * Chat icon
     */
    public static enum Icon {
        NONE, MODERATOR, ADMINISTRATOR, DONATOR, DEVELOPER, TESTER;
    }

}
