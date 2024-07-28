package dev.jhugo.cdollar.repository;

import java.util.ArrayList;

public record DollarRecord(String context, ArrayList<String> value) {
    public ArrayList<String> getValue(){
        return this.value;
    }
}
