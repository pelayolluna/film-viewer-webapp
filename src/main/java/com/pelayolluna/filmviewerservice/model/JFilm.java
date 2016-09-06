/*
 * Copyright 2016 Pelayo José Lluna González.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pelayolluna.filmviewerservice.model;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pelayo José Lluna González
 */
@XmlRootElement(name="jFilm")
public class JFilm implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String name;
    private String location;
    private String type;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "id:" + id + ", name:" + name + ", location:" + location + ", type:" + type;
    }
    
    public String toJson() {
        return "{\"id\":" + id + ",\"name\":" + name + ",\"location\":" + location + ",\"type\":" + type + "}";
    }

    @Override
    public int hashCode() {
        if(id == 0) {
            return 31*7*3;
        }
        return id * name.hashCode() * location.hashCode() * type.hashCode() * 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JFilm other = (JFilm) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }
    
    
}
