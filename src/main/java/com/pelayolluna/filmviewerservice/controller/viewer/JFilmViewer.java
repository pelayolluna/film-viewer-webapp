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
package com.pelayolluna.filmviewerservice.controller;

import com.pelayolluna.filmviewerservice.model.JFilmList;
import com.pelayolluna.filmviewerservice.service.JFilmService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pelayo José Lluna González
 */
@RestController
public class JFilmViewer {
    private final static Logger LOGGER = Logger.getLogger(JFilmViewer.class);
    private JFilmService jFilmService;
    
    @RequestMapping(value = "/jFilms", method = RequestMethod.GET, produces = "application/json")
    private @ResponseBody JFilmList getJFilmsXml() {

        JFilmList result = new JFilmList();
        result.setData(jFilmService.findAllJFilms());

        return result;
    }
}
