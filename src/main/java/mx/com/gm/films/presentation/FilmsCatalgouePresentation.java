package mx.com.gm.films.presentation;
//Capa donde voy a interactuar con el usuario


import mx.com.gm.films.bussiness.FilmsCatalogueImpl;
import mx.com.gm.films.bussiness.IFilmsCatalogue;

import java.util.Scanner;

public class FilmsCatalgouePresentation {
    public static void main(String[] args) {
        var option = -1; //inicializo esta variable en -1
        var scanner = new Scanner(System.in);
        IFilmsCatalogue catalogue = new FilmsCatalogueImpl();//defino variable local para utilizar el constructor
        // de esta clase, aquí estoy trabajando ya con la capa de negocio(bajo acoplamiento y alta cohesión, porque
        // cada capa tiene su responsabilidad)

        while (option != 0) {
            System.out.println("Choose an option: \n"
                            + "1. Init Films Catalogue \n"
                            + "2. Add Film \n"
                            + "3. List Films \n"
                            + "4. Search Film \n"
                            + "0. Exit \n"
            );
            option = Integer.parseInt(scanner.nextLine());//si no pongo una opción integer, me echa del programa

            //Para que se pueda procesar cada opción que escoja el usuario debo hacer:
            switch (option){
                case 1:
                    catalogue.initFilmsCatalogue();
                    break;

                case 2:
                    System.out.println("What is the name of the film?");
                    var filmName = scanner.nextLine();
                    catalogue.addFilm(filmName);
                    break;

                case 3:
                    catalogue.listFilms();
                    break;
                case 4:
                    System.out.println("Introduce the film you want to seach, please:");
                    var filmToSearch = scanner.nextLine();
                    catalogue.searchFilm(filmToSearch);
                    break;
                case 0:
                    System.out.println("See you soon!");
                    break;
                default:
                    System.out.println("Non valid option");
                    break;
            }

        }
    }
}
