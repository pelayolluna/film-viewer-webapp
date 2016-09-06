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
package com.pelayolluna.filmviewerservice.service;

import com.pelayolluna.filmviewerservice.model.JFilm;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pelayo José Lluna González
 */
@Service("jFilmService")
public class JFilmService {
    protected static final Logger LOGGER = Logger.getLogger(JFilmService.class);

    private static final AtomicLong COUNTER = new AtomicLong();
    private static final List<JFilm> JFILMS = new ArrayList<>();

    public JFilmService() {
    }
    
    public List<JFilm> findAllJFilms() {
        return JFILMS;
    }

    public JFilm findById(int id) {
        for (JFilm jFilm : JFILMS) {
            if (jFilm.getId() == id) {
                return jFilm;
            }
        }
        return null;
    }
    
    public JFilm findByName(String name) {
        for (JFilm jFilm : JFILMS) {
            if (jFilm.getName().equalsIgnoreCase(name)) {
                return jFilm;
            }
        }
        return null;
    }
    
    public JFilm findByLocation(String location) {
        for (JFilm jFilm : JFILMS) {
            if (jFilm.getLocation().equalsIgnoreCase(location)) {
                return jFilm;
            }
        }
        return null;
    }
    
    public JFilm findByType(String type) {
        for (JFilm jFilm : JFILMS) {
            if (jFilm.getType().equalsIgnoreCase(type)) {
                return jFilm;
            }
        }
        return null;
    }
}
