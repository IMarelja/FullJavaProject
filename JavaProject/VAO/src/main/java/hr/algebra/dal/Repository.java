/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal;

import hr.algebra.model.*;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author windsten
 */
public interface Repository {
  

   int createActor(Actor actor) throws Exception;
   Optional<Actor> readActor(int id) throws Exception;
   List<Actor> readActors() throws Exception;
   void updateActor(int id,Actor actor) throws Exception;
   void deleteActor(int id) throws Exception;
   
   int createDirector(Director director) throws Exception;
   Optional<Director> readDirector(int id) throws Exception;
   List<Director> readDirectors() throws Exception;
   void updateDirector(int id,Director director) throws Exception;
   void deleteDirector(int id) throws Exception;
   
   int createGenre(Genre genre) throws Exception;
   Optional<Genre> readGenre(int id) throws Exception;
   List<Genre> readGenres() throws Exception;
   void updateGenre(int id,Genre genre) throws Exception;
   void deleteGenre(int id) throws Exception;
   
   int createMovie(Movie movie) throws Exception;
   Optional<Movie> readMovie(int id) throws Exception;
   List<Movie> readMovies() throws Exception;
   void updateMovie(int id,Movie movie) throws Exception;
   void deleteMovie(int id) throws Exception;
   
   void createActorFromMovie(int movieId, int actorId) throws Exception;
   List<Actor> readActorsFromMovie(int movieId) throws Exception;
   List<Movie> readMoviesFromActor(int actorId) throws Exception;
   void deleteActorFromMovie(int movieId, int actorId) throws Exception;
   
   void createDirectorToMovie(int movieId, int directorId) throws Exception;
   List<Director> readDirectorsFromMovie(int movieId) throws Exception;
   List<Movie> readMovieFromDirector(int directorId) throws Exception;
   void removeDirectorFromMovie(int movieId, int directorId) throws Exception;
   
   void createGenreToMovie(int movieId, int genreId) throws Exception;
   List<Genre> selectGenresFromMovie(int movieId) throws Exception;
   List<Movie> selectMoviesFromGenre(int genreId) throws Exception;
   void removeGenreFromMovie(int movieId, int genreId) throws Exception;

   Optional<User> getUserByUsername(String username) throws Exception;
   int createUser(User user) throws Exception;
   boolean authenticateUser(String username, char[] password) throws Exception;
   
   void DeleteAllDataExceptUsers() throws Exception;
}
