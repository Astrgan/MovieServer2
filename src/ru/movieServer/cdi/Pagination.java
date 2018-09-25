package ru.movieServer.cdi;

import ru.movieServer.DBConnectionFilms;
import ru.movieServer.Film;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;

@Dependent
@Named
public class Pagination {

    @Inject
    DBConnectionFilms dbConnection;
    ArrayList<Film> films;


    public  int currentPage = 0;

    public int getCurrentPage() {
        return currentPage;
    }

    public int[] getNumbers() {
        return numbers;
    }



    public int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
}
