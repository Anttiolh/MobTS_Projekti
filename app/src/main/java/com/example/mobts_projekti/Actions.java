package com.example.mobts_projekti;

import java.time.ZoneId;

public interface Actions {
    Counter counter = new Counter(16,0,1);
    /*
    public void add();
    public void subtract();
    public String getValue();

     */

    default void add(){
        counter.add();
    }

    default void subtract(){
        counter.subtract();
    }

    default String getValue(){
       return counter.getValue();
    }
}
