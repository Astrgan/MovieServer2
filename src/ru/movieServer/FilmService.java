package ru.movieServer;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

//import org.jboss.resteasy.annotations.GZIP;

@Path("/films")
public class FilmService {
	
	@Inject 
	DBConnectionFilms dbConnection;
	@EJB
	ListAllFilms listAllFilms; 
	@Context
	UriInfo uri;
		
	@Consumes("application/json")
	@Produces({"application/json"})
	@GET
//	@GZIP
	public Lists getListGenres() {		
		return listAllFilms.getLists();
	}

	@Consumes("application/json")
	@Produces({"application/json"})
	@POST
//	@GZIP
	public ArrayList<Film> getFilms(Film filmFilter) {
		
		System.out.println(filmFilter.name);
		System.out.println(filmFilter.id);
		System.out.println(filmFilter.year);
		
		return dbConnection.getFilms(filmFilter, uri.getBaseUri().getHost());
//		return dbConnection.getFilms(filmFilter, "gebruder.tk");

	}



}
