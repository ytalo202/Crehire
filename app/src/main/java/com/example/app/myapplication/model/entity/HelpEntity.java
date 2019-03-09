package com.example.app.myapplication.model.entity;

/**
 * Created by Ricardo Bravo on 1/03/17.
 */

public class HelpEntity {

    private int id;
    private String help;

    public HelpEntity(int id, String help) {
        this.id = id;
        this.help = help;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
