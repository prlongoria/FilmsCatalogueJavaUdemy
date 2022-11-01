package mx.com.gm.films.bussiness;
//Esta capa negocio es para el usuario final, así que tiene los métodos que él va a utilizar
public interface IFilmsCatalogue{
    //constante archivo:
    String RESOURCE_NAME = "films.txt";//nombre del archivo

    //Métodos para usuario:
    void addFilm(String filmName);

    void listFilms();

    void searchFilm(String search);

    void initFilmsCatalogue();
}
