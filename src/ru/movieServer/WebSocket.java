package ru.movieServer;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/ws")
public class WebSocket {

    @Inject DBConnectionFilms dbConnection;


    @OnMessage
    public String onMessage(String filmFilterJSON) {
        System.out.println("json: " + filmFilterJSON);
        Gson gson = new Gson();
        Film filmFilter = gson.fromJson(filmFilterJSON, Film.class);
        return gson.toJson(dbConnection.getFilms(filmFilter, "gebruder.tk"));

    }
}