package mx.com.gm.films.domain;

import java.io.Serializable;

public class Film implements Serializable { //la hago javabean(por eso pongo Serializable, aunque no me es necesario
    // en este caso):

    //atributos private
    private String filmName;

    //Constructor vacío:
    public Film() {

    }

    //constructor con un argumento
    public Film(String filmName) {
        this.filmName = filmName;
    }

    //getter y setter:

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    //toString:

    @Override
    public String toString() {
        /*
        final StringBuilder sb = new StringBuilder("Film{");
        sb.append("filmName='").append(filmName).append('\'');
        sb.append('}');
        return sb.toString();

         */
        return this.filmName;//Lo pongo así para que cuando use el método search sólo busque el nombre de la película
    }
}
