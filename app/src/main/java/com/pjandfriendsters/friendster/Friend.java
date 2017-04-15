package com.pjandfriendsters.friendster;

/**
 * Created by Jonathan Arino on 4/14/2017.
 */

public class Friend {
    private int id;
    private String name;

    public Friend() {

    }

    public Friend(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }


}
