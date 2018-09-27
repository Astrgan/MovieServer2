package ru.movieServer.cdi;

import ru.movieServer.DBConnectionFilms;
import ru.movieServer.Film;
import ru.movieServer.ListAllFilms;
import ru.movieServer.Lists;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped

public class FilmCDI {

    Film filmFilter = new Film();
    Film film;
    List<Film> films;
    Lists lists;
    int year = 2018;
    int id = -1;
    int currentPage = 1;

    String genre="все";
    ArrayList<Integer> numbers = new ArrayList<>();

    @Inject
    DBConnectionFilms dbConnection;
    @EJB
    ListAllFilms listAllFilms;
    double pages;

    int length = 8;
    private int numSelector = 6;

    @PostConstruct
    void init(){

    }

    public void reInit(){
        System.out.println("reInit");
        System.out.println("id: " + id);
        if(id > 0) {
            getFilmFromPlayer();
            return;
        }
        filmFilter.year = year;
        filmFilter.genres = new String[] {genre};
        films = getFilms(filmFilter);
        pages = Math.ceil(this.films.size() / this.numSelector);
        int began = (int)biganPages();
        int endListFilms = ((currentPage - 1) * numSelector) + (numSelector);
        System.out.println("currentPage" + currentPage);
        films = films.subList(((currentPage - 1) * numSelector), films.size()<endListFilms?films.size():endListFilms);
        for (int i = began; i < began+length & i <= pages; i++)
            numbers.add(i);
    }

    public void getFilmFromPlayer(){
        filmFilter.id = id;
        film = getFilms(filmFilter).get(0);
    }

    public String getGenre() {
        return genre;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getNumSelector() {
        return numSelector;
    }
    public int getCurrentPage() {
        return currentPage;
    }

    public ArrayList<Integer> getNumbers() {
        System.out.println("numbers size" + numbers.size());
        return numbers;
    }
    public Lists getLists() {
        return listAllFilms.getLists();
    }

    public List<Film> getFilms() {
        return films;
    }

    double biganPages() {
        double index;
        index = pages - this.currentPage + 1;

        if (pages < this.length) { return 0; }
        if (index < this.length ) {  return  ((this.currentPage + 1 - (this.length - index)) - 3);}

        return this.currentPage + 1 > this.numSelector ? this.currentPage + 1 - this.numSelector : 0;
    }

    public Lists getListGenres() {
        return listAllFilms.getLists();
    }


    public ArrayList<Film> getFilms(int year){
        Film filmFilter = new Film();
        filmFilter.year = year;

        return getFilms(filmFilter);
    }

    public ArrayList<Film> getFilms(Film filmFilter) {
        System.out.println("getFilms");
        System.out.println(filmFilter.name);
        System.out.println(filmFilter.id);
        System.out.println(filmFilter.year);

        return dbConnection.getFilms(filmFilter, "HOST!!!!!!!");

    }

}
