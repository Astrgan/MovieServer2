package ru.movieServer;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.movieServer.users.Comment;

@XmlRootElement
public class Film {

	@XmlElement public int id;
	@XmlElement public int year;
	@XmlElement public double rating;
	@XmlElement public String poster;
	@XmlElement public String name;
	@XmlElement public String description;	
	@XmlElement public String[] genres;
	@XmlElement public String[] countries;
	@XmlElement public String[] actors;
	@XmlElement public String[] writers;
	@XmlElement public String path;
	@XmlElement public ArrayList<Comment> comments;
	
	
	@XmlElement public int antiYear;
	@XmlElement public String antiName;
	@XmlElement public String[] antiGenres;
	@XmlElement public String[] antiCountries;
	@XmlElement public String[] antiActors;
	@XmlElement public String[] antiWriters;

	public int getId() {
		return id;
	}

	public int getYear() {
		return year;
	}

	public double getRating() {
		return rating;
	}

	public String getPoster() {
		return poster;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String[] getGenres() {
		return genres;
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

	public String getPath() {
		return path;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public int getAntiYear() {
		return antiYear;
	}

	public String getAntiName() {
		return antiName;
	}

	public String[] getAntiGenres() {
		return antiGenres;
	}

	public String[] getAntiCountries() {
		return antiCountries;
	}

	public String[] getAntiActors() {
		return antiActors;
	}

	public String[] getAntiWriters() {
		return antiWriters;
	}
}
