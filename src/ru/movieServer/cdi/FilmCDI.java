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
    List<Film> films;
    Lists lists;
    int year = 2018;

    int currentPage = 1;

    String genre="все";
    ArrayList<Integer> numbers = new ArrayList<>();

    @Inject
    DBConnectionFilms dbConnection;
    @EJB
    ListAllFilms listAllFilms;
    double pages;

    int length = 8;
    private int numSelector = 3;

//    @PostConstruct
//    void init(){
//
//    }

    public void reInit(){
        System.out.println("reInit");
        filmFilter.year = 2018;
        filmFilter.genres = new String[] {genre};
        films = getFilms(filmFilter);
        pages = Math.ceil(this.films.size() / this.numSelector);
        int began = (int)biganPages();
        System.out.println("currentPage" + currentPage);
        films = films.subList(((currentPage - 1) * numSelector), ((currentPage - 1) * numSelector) + (numSelector));
        for (int i = began; i < began+length; i++)
            numbers.add(i);
    }

    public String getGenre() {
        return genre;
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
