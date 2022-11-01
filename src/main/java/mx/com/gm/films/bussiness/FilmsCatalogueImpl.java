package mx.com.gm.films.bussiness;

import mx.com.gm.films.data.DataAccessImplementation;
import mx.com.gm.films.data.IDataAccess;
import mx.com.gm.films.domain.Film;
import mx.com.gm.films.exceptions.DataAccessEx;
import mx.com.gm.films.exceptions.ReadDataEx;

public class FilmsCatalogueImpl implements IFilmsCatalogue{

    //defino atributo de la clase de la otra interface para poder acceder a esos datos:
    private final IDataAccess data;

    /*constructor:se crea solo cuando aparece el error y doy a implementar el constructor

    public FilmsCatalogueImpl(IDataAccess data) {
        this.data = data;
    }
    */

    //EN el video, el constructor lo hace así:
    public FilmsCatalogueImpl() {
        this.data = new DataAccessImplementation();
    }


    @Override
    public void addFilm(String filmName) {
        Film film = new Film(filmName);//creo objeto tipo Film
        boolean append = false; //inicializo la variable para añadir info como false
        try {
            append = data.existsFile(RESOURCE_NAME);//método existsFile de la IDataAccess
            data.write(film, RESOURCE_NAME, append);//método write de la IDataAccess

        } catch (DataAccessEx e) {
            System.out.println("Access error");
            e.printStackTrace(System.out);
        }

    }

    @Override
    public void listFilms() {
        try {
            var films = this.data. list(RESOURCE_NAME);
            for(var film: films) {
                System.out.println("film = " + film);
            }
        } catch (DataAccessEx e) {//meto el tipo más genérico para capturar errores más genéricos, de clase padre
            System.out.println("Access Data Error");
            e.printStackTrace();

        }

    }

    @Override
    public void searchFilm(String search) {
        String result = null;
        try {
            result = this.data.search(RESOURCE_NAME, search);

        } catch (DataAccessEx e) {
            System.out.println("Access data Error searching film");
            e.printStackTrace(System.out);
        }
        System.out.println("result = " + result);

    }

    @Override
    public void initFilmsCatalogue() {
        try {
            if(this.data.existsFile(RESOURCE_NAME)) {
                data.delete(RESOURCE_NAME);
                data.create(RESOURCE_NAME);
            }
            else {
                data.create(RESOURCE_NAME);
            }
        } catch (DataAccessEx e) {
            System.out.println("Error when init FIlms Catalogue");
            e.printStackTrace(System.out);
        }
    }
}
