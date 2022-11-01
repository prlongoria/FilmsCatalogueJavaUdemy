package mx.com.gm.films.data;

import mx.com.gm.films.domain.Film;
import mx.com.gm.films.exceptions.*;

import java.io.*;
import java.util.*;

//Esta clase es para rellenar los métodos de la interface
public class DataAccessImplementation implements IDataAccess {//me pongo sobre el error que marca y doy a implementar
    // todos los métodos y ya lo hace automáticamente, pero yo debo rellenarlos:

    @Override
    public boolean existsFile(String resourceName) {
        //return false; Esto me lo da automáticamente pero no lo quiero

        var file = new File(resourceName);
        return file.exists();
    }

    @Override
    public List<Film> list(String resourceName) throws ReadDataEx {
        //return null;

        var file = new File(resourceName);
        List<Film> films = new ArrayList<>();
        try {
            var input = new BufferedReader(new FileReader(file));

            String line =  null;
            line = input.readLine();
            while (line != null) {
                var film = new Film(line);
                films.add(film);
                line = input.readLine();
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ReadDataEx("Exception listing films: " + e.getMessage());//hago mi propia excepción
            // en lugar de utilizar la de la api de java
        } catch (IOException e) {
            e.printStackTrace();
            throw new ReadDataEx("Exception listing films: " + e.getMessage());
        }
        return films;
    }

    @Override
    public void write(Film film, String resourceName, boolean add) throws WriteDataEx {
        var file = new File(resourceName);
        try  {
            var output = new PrintWriter(new FileWriter(file, add));
            output.println(film.toString());
            output.close();
            System.out.println("Info written in file: " + film);
        }catch (IOException e) {
            e.printStackTrace();
            throw new WriteDataEx("Exception writting films: " + e.getMessage());
        }
    }

    @Override
    public String search(String resourceName, String search) throws ReadDataEx {
        //return null; esto salió por defecto pero lo relleno yo así:

        var file = new File(resourceName);
        String result = null;

        try {
            var input = new BufferedReader(new FileReader(file));
            String line = null;
            line = input.readLine();
            var index = 1; //para saber el índice que estoy leyendo(lo inicializo en 1)

            while (line != null) {
                if (search!= null && search.equalsIgnoreCase(line)){
                    result = "Film " + line + "found in index " + index;
                    break;
                }
                line = input.readLine();
                index++;
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ReadDataEx("Exception listing films: " + e.getMessage());
        } catch (IOException e) {
            throw new ReadDataEx("Exception listing films: " + e.getMessage());
        }

        return result;
    }

    @Override
    public void create(String resourceName) throws DataAccessEx {
        var file = new File(resourceName);
        try {
            var output = new PrintWriter(new FileWriter(file));
            output.close();
            System.out.println("File has been created");
        }catch (IOException e) {
            throw new DataAccessEx("Exception cresting file: " + e.getMessage());
        }
    }

    @Override
    public void delete(String resourceName){
        var file = new File(resourceName);
        if(file.exists ()) {
            file.delete ();
            System.out.println("File has been deleted");
        }
    }
}
