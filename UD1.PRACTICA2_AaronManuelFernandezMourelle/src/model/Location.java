/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author AARONFM
 */
public class Location {
    
    public static final String ACTIONS_DELETE = "DELETE";
    public static final String ACTIONS_UPDATE = "UPDATE";
    public static final String ACTIONS_INSERT = "INSERT";
    
    private String name;
    private List<Location> locations;
    private boolean isProvince;

    public Location() {
    }

    public Location(String name, List<Location> locations, boolean isProvince) {
        this.name = name;
        this.locations = locations;
        this.isProvince = isProvince;
    }

    public Location(String name, boolean isProvince) {
        this.name = name;
        this.isProvince = isProvince;
    }

    public Location(String name) {
        this.name = name;
        this.isProvince = true;
    }

    public String getName() {
        return name;
    }

    public List<Location> getLocations() {
        if (Objects.isNull(locations)) {
            return new ArrayList<>();
        }
        return locations;
    }

    public boolean isIsProvince() {
        return isProvince;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public void setIsProvince(boolean isProvince) {
        this.isProvince = isProvince;
    }

    @Override
    public String toString() {
        return name;
    }

    
    public String toStringRegularInfo() {
        if (this.isProvince) {
            return "Lugar:\nNombre: " + name + " lugares: " + locations;
        } else {
            return "Lugar:\nNombre: " + name;
        }
    }

}
