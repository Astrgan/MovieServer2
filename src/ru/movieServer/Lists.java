package ru.movieServer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Lists {

	@XmlElement public String[] jsonAllFilms;

	public String[] getJsonAllFilms() {
		return jsonAllFilms;
	}

	public String[] getJsonAllGenres() {
		return jsonAllGenres;
	}

	public String[] getJsonCountries() {
		return jsonCountries;
	}

	public String[] getYears() {
		return years;
	}

	public String[] getCountries() {
		return countries;
	}

	public String[] getActors() {
		return actors;
	}

	public String[] getWriters() {
		return writers;
	}

	@XmlElement public String[] jsonAllGenres;
	@XmlElement public String[] jsonCountries;
	@XmlElement public String[] years;
	@XmlElement public String[] countries;
	@XmlElement public String[] actors;
	@XmlElement public String[] writers;
}
