package com.pelayolluna.filmviewerservice.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="jFilms")
public class JFilmList {
	
	private List<JFilm> data;

	public List<JFilm> getData() {
		return data;
	}

	public void setData(List<JFilm> data) {
		this.data = data;
	}

}
