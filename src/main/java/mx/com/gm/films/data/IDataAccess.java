package mx.com.gm.films.data;
//Quiero conseguir bajo acoplamiento y alta cohesión y por eso sólo defino en la inerface el comportamiento, y luego
// en la clase de implementación meto la forma en que se ejecutan

import mx.com.gm.films.domain.Film;
import mx.com.gm.films.exceptions.DataAccessEx;
import mx.com.gm.films.exceptions.ReadDataEx;
import mx.com.gm.films.exceptions.WriteDataEx;

import java.io.*;
import java.util.List;

public interface IDataAccess { //creo todos los métodos de esta interface y luego crearé la clase que la implemente:

    //Método para saber si ya existe un archivo o aulquier otro recurso como podría ser una bbdd:

    boolean existsFile(String resourceName) throws DataAccessEx;  //porque puede arrojar una excepción

    //Método de listar (retorna lista de objetos de tipo film)

    List<Film> list(String resourceName) throws ReadDataEx;

    //Método para escribir:

    void write(Film film, String resourceName, boolean add)throws WriteDataEx;

    //Método para buscar una película:

    String search(String resourceName, String search) throws ReadDataEx;

    //Método crear:

    void create(String resourceName) throws DataAccessEx;

    //Método borrar:

    void delete(String resourceName) throws DataAccessEx;

  /*
//Creo que esto es para la clase de implementación:
    //método para crear el archivo movies:

    public static void createFile(String fileName) {
        File file = new File("c:\\FilmsCatalogue\films.txt");

        try {
            PrintWriter output = new PrintWriter(file);

            output.close();
            System.out.println("Se ha creado el archivo");

        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    //Método para escribir en el archivo:

    public static void writeFile(String fileName, String content) {
        File file = new File(fileName);

        try {
            PrintWriter output = new PrintWriter(file);

            output.close();
            System.out.println("Se ha escrito en el archivo");

        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    //Método para añadir más información al archivo:
    public static void addInfoToFile(String fileName, String content) {
        File file = new File(fileName);

        try {
            PrintWriter output = new PrintWriter(new FileWriter(file, true));

            output.close();
            System.out.println("Se ha añadido información al archivo");

        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    //Método para leer en consola el archivo:
    public static void readFile(String fileName) {
        var file = new File(fileName);

        try {
            var input = new BufferedReader(new FileReader(file));

            var lecture = input.readLine();

            while (lecture != null) {
                System.out.println("lecture = " + lecture);
                lecture = input.readLine();
            }
            input.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);

        }
    }

   */
}
