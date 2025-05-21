/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.Repository;
import hr.algebra.model.Actor;
import hr.algebra.model.Director;
import hr.algebra.model.Genre;
import hr.algebra.model.Movie;
import hr.algebra.model.User;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author windsten
 */
public class SqlRepo implements Repository{

    
    //Actor
    
    private static final String IDACTOR = "ID";
    private static final String FIRSTNAMEACTOR = "FirstName";
    private static final String LASTNAMEACTOR = "LastName";

    private static final String CREATE_ACTOR = "{ CALL CreateActor (?,?,?) }";
    private static final String UPDATE_ACTOR = "{ CALL UpdateActor (?,?,?) }";
    private static final String DELETE_ACTOR = "{ CALL DeleteActor (?) }";
    private static final String SELECT_ACTOR = "{ CALL ReadActor (?) }";
    private static final String SELECT_ACTORS = "{ CALL ReadActors }";
    
    @Override
    public int createActor(Actor actor) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_ACTOR)) {
            stmt.setString(FIRSTNAMEACTOR, actor.getFirstName());
            stmt.setString(LASTNAMEACTOR, actor.getLastName());

            stmt.registerOutParameter(IDACTOR, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(IDACTOR);

        }
    }

    @Override
    public Optional<Actor> readActor(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); 
                CallableStatement stmt = con.prepareCall(SELECT_ACTOR)) {
           
            stmt.setInt(IDACTOR, id);
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(
                            new Actor(
                                    rs.getInt(IDACTOR), 
                                    rs.getString(FIRSTNAMEACTOR), 
                                    rs.getString(LASTNAMEACTOR)
                                )
                    );
                }
            }
            

        }    
        
        return Optional.empty();
    }

    @Override
    public List<Actor> readActors() throws Exception {
        List<Actor> actors = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); 
                CallableStatement stmt = con.prepareCall(SELECT_ACTORS)) {
           
            
            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    actors.add(
                            new Actor(
                                    rs.getInt(IDACTOR), 
                                    rs.getString(FIRSTNAMEACTOR), 
                                    rs.getString(LASTNAMEACTOR)
                            ));
                }
            }
            
        }    
        
        
        return actors;
    }

    @Override
    public void updateActor(int id, Actor actor) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); 
                CallableStatement stmt = con.prepareCall(UPDATE_ACTOR)) {
            stmt.setString(FIRSTNAMEACTOR, actor.getFirstName());
            stmt.setString(LASTNAMEACTOR, actor.getLastName());


            stmt.setInt(IDACTOR, id);

            stmt.executeUpdate();
           

        } 
    }

    @Override
    public void deleteActor(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); 
                CallableStatement stmt = con.prepareCall(DELETE_ACTOR)) {
           
            stmt.setInt(IDACTOR, id);

            stmt.executeUpdate();

        }  
    }

    private static final String IDDIRECTOR = "ID";
    private static final String FIRSTNAMEDIRECTOR = "FirstName";
    private static final String LASTNAMEDIRECTOR = "LastName";

    private static final String CREATE_DIRECTOR = "{ CALL CreateDirector (?,?,?) }";
    private static final String UPDATE_DIRECTOR = "{ CALL UpdateDirector (?,?,?) }";
    private static final String DELETE_DIRECTOR = "{ CALL DeleteDirector (?) }";
    private static final String SELECT_DIRECTOR = "{ CALL ReadDirector (?) }";
    private static final String SELECT_DIRECTORS = "{ CALL ReadDirectors }";
    
    //Director
    @Override
    public int createDirector(Director director) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_DIRECTOR)) {
            stmt.setString(FIRSTNAMEDIRECTOR, director.getFirstName());
            stmt.setString(LASTNAMEDIRECTOR, director.getLastName());

            stmt.registerOutParameter(IDDIRECTOR, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(IDDIRECTOR);

        }
    }

    @Override
    public Optional<Director> readDirector(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); 
                CallableStatement stmt = con.prepareCall(SELECT_DIRECTOR)) {
           
            stmt.setInt(IDDIRECTOR, id);
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(
                            new Director(
                                    rs.getInt(IDDIRECTOR), 
                                    rs.getString(FIRSTNAMEDIRECTOR), 
                                    rs.getString(LASTNAMEDIRECTOR)
                                )
                    );
                }
            }
            

        }    
        
        return Optional.empty();
    }

    @Override
    public List<Director> readDirectors() throws Exception {
        List<Director> directors = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); 
                CallableStatement stmt = con.prepareCall(SELECT_DIRECTORS)) {
           
            
            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    directors.add(
                            new Director(
                                    rs.getInt(IDDIRECTOR), 
                                    rs.getString(FIRSTNAMEDIRECTOR), 
                                    rs.getString(LASTNAMEDIRECTOR)
                            ));
                }
            }
            
        }    
        
        
        return directors;
    }

    @Override
    public void updateDirector(int id,Director director) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); 
                CallableStatement stmt = con.prepareCall(UPDATE_DIRECTOR)) {
            stmt.setString(FIRSTNAMEDIRECTOR, director.getFirstName());
            stmt.setString(LASTNAMEDIRECTOR, director.getLastName());


            stmt.setInt(IDDIRECTOR, id);

            stmt.executeUpdate();
           

        }
    }

    @Override
    public void deleteDirector(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); 
                CallableStatement stmt = con.prepareCall(DELETE_DIRECTOR)) {
           
            stmt.setInt(IDDIRECTOR, id);

            stmt.executeUpdate();

        } 
    }

    private static final String IDGENRE = "ID";
    private static final String NAMEGENRE = "Name";

    private static final String CREATE_GENRE = "{ CALL CreateGenre (?,?) }";
    private static final String UPDATE_GENRE = "{ CALL UpdateGenre (?,?) }";
    private static final String DELETE_GENRE = "{ CALL DeleteGenre (?) }";
    private static final String SELECT_GENRE = "{ CALL ReadGenre (?) }";
    private static final String SELECT_GENRES = "{ CALL ReadGenres }";
    
    //Genre
    @Override
    public int createGenre(Genre genre) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_GENRE)) {
            stmt.setString(NAMEGENRE, genre.getName());

            stmt.registerOutParameter(IDGENRE, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(IDGENRE);

        }
    }

    @Override
    public Optional<Genre> readGenre(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); 
                CallableStatement stmt = con.prepareCall(SELECT_GENRE)) {
           
            stmt.setInt(IDGENRE, id);
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(
                            new Genre(
                                    rs.getInt(IDGENRE), 
                                    rs.getString(NAMEGENRE)
                                )
                    );
                }
            }
            

        }    
        
        return Optional.empty();
    }

    @Override
    public List<Genre> readGenres() throws Exception {
        List<Genre> genres = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); 
                CallableStatement stmt = con.prepareCall(SELECT_GENRES)) {
           
            
            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    genres.add(
                            new Genre(
                                    rs.getInt(IDGENRE), 
                                    rs.getString(NAMEGENRE)
                            ));
                }
            }
            
        }    
        
        
        return genres;
    }

    @Override
    public void updateGenre(int id,Genre genre) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); 
                CallableStatement stmt = con.prepareCall(UPDATE_GENRE)) {
            stmt.setString(NAMEGENRE, genre.getName());


            stmt.setInt(IDGENRE, id);

            stmt.executeUpdate();
           

        }
    }

    @Override
    public void deleteGenre(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); 
                CallableStatement stmt = con.prepareCall(DELETE_GENRE)) {
           
            stmt.setInt(IDGENRE, id);

            stmt.executeUpdate();

        } 
    }

    //Movie
    
    private static final String IDMOVIE = "ID";
    private static final String TITLE = "Title";
    private static final String PICTURE_PATH = "PicturePath";
    private static final String DESCRIPTION = "Description";
    private static final String RELEASE_DATE = "ReleaseDate";

    private static final String CREATE_MOVIE = "{ CALL CreateMovie (?,?,?,?,?) }";
    private static final String UPDATE_MOVIE = "{ CALL UpdateMovie (?,?,?,?,?) }";
    private static final String DELETE_MOVIE = "{ CALL DeleteMovie (?) }";
    private static final String SELECT_MOVIE = "{ CALL ReadMovie (?) }";
    private static final String SELECT_MOVIES = "{ CALL ReadMovies }";
    
    @Override
    public int createMovie(Movie movie) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
        CallableStatement stmt = con.prepareCall(CREATE_MOVIE)) {

        stmt.setString(TITLE, movie.getTitle());
        stmt.setString(PICTURE_PATH, movie.getPicturePath());
        stmt.setString(DESCRIPTION, movie.getDescription());
        stmt.setString(RELEASE_DATE, movie.getPublishedDate()
                .format(Movie.DATE_FORMATTER));
        
        stmt.registerOutParameter(IDMOVIE, Types.INTEGER);

        stmt.executeUpdate();
        return stmt.getInt(IDMOVIE);
        }
    }

    @Override
    public Optional<Movie> readMovie(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(SELECT_MOVIE)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Movie movie = new Movie(
                        rs.getInt(IDMOVIE),
                        rs.getString(TITLE),
                        rs.getString(PICTURE_PATH),
                        rs.getString(DESCRIPTION),
                        LocalDate.parse(rs.getString(RELEASE_DATE), Movie.DATE_FORMATTER)
                    );
                    return Optional.of(movie);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Movie> readMovies() throws Exception {
        List<Movie> movies = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(SELECT_MOVIES);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Movie movie = new Movie(
                    rs.getInt(IDMOVIE),
                    rs.getString(TITLE),
                    rs.getString(PICTURE_PATH),
                    rs.getString(DESCRIPTION),
                    LocalDate.parse(rs.getString(RELEASE_DATE), Movie.DATE_FORMATTER)
                );
                movies.add(movie);
            }
        }
        return movies;
    }

    @Override
    public void updateMovie(int id,Movie movie) throws Exception {
        
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(UPDATE_MOVIE)) {

            stmt.setString(TITLE, movie.getTitle());
            stmt.setString(PICTURE_PATH, movie.getPicturePath());
            stmt.setString(DESCRIPTION, movie.getDescription());
            stmt.setString(RELEASE_DATE, movie.getPublishedDate().format(Movie.DATE_FORMATTER));

            stmt.setInt(IDMOVIE, id);
            
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteMovie(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(DELETE_MOVIE)) {

            stmt.setInt(IDMOVIE, id);
            stmt.executeUpdate();
        }
    }

    //Actor And Movie
    private static final String CREATE_ACTOR_FROM_MOVIE = "{ CALL CreateActorFromMovie (?, ?) }";
    private static final String READ_ACTORS_FROM_MOVIE = "{ CALL ReadActorsFromMovie (?) }";
    private static final String READ_MOVIES_FROM_ACTOR = "{ CALL ReadMoviesFromActor (?) }";
    private static final String DELETE_ACTOR_FROM_MOVIE = "{ CALL DeleteActorFromMovie (?, ?) }";

    
    @Override
    public void createActorFromMovie(int movieId, int actorId) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(CREATE_ACTOR_FROM_MOVIE)) {

            stmt.setInt(1, movieId);
            stmt.setInt(2, actorId);

            stmt.executeUpdate();
        }
    }

    @Override
    public List<Actor> readActorsFromMovie(int movieId) throws Exception {
        List<Actor> actors = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(READ_ACTORS_FROM_MOVIE)) {

            stmt.setInt(1, movieId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Actor actor = new Actor(
                        rs.getInt(IDACTOR),
                        rs.getString(FIRSTNAMEACTOR),
                        rs.getString(LASTNAMEACTOR)
                    );
                    actors.add(actor);
                }
            }
        }
        return actors;
    }

    @Override
    public List<Movie> readMoviesFromActor(int actorId) throws Exception {
        List<Movie> movies = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(READ_MOVIES_FROM_ACTOR)) {

            stmt.setInt(1, actorId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Movie movie = new Movie(
                        rs.getInt(IDMOVIE),
                        rs.getString(TITLE),
                        rs.getString(PICTURE_PATH),
                        rs.getString(DESCRIPTION),
                        LocalDate.parse(rs.getString(RELEASE_DATE), Movie.DATE_FORMATTER)
                    );
                    movies.add(movie);
                }
            }
        }
        return movies;
    }

    @Override
    public void deleteActorFromMovie(int movieId, int actorId) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(DELETE_ACTOR_FROM_MOVIE)) {

            stmt.setInt(1, movieId);
            stmt.setInt(2, actorId);

            stmt.executeUpdate();
        }
    }

    //Director and movie
    private static final String CREATE_DIRECTOR_TO_MOVIE = "{ CALL CreateDirectorToMovie (?, ?) }";
    private static final String READ_DIRECTORS_FROM_MOVIE = "{ CALL ReadDirectorsFromMovie (?) }";
    private static final String READ_MOVIES_FROM_DIRECTOR = "{ CALL ReadMoviesFromDirector (?) }";
    private static final String REMOVE_DIRECTOR_FROM_MOVIE = "{ CALL RemoveDirectorFromMovie (?, ?) }";

    @Override
    public void createDirectorToMovie(int movieId, int directorId) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(CREATE_DIRECTOR_TO_MOVIE)) {

            stmt.setInt(1, movieId);
            stmt.setInt(2, directorId);

            stmt.executeUpdate();
        }
    }

    @Override
    public List<Director> readDirectorsFromMovie(int movieId) throws Exception {
        List<Director> directors = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(READ_DIRECTORS_FROM_MOVIE)) {

            stmt.setInt(1, movieId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Director director = new Director(
                        rs.getInt(IDDIRECTOR),
                        rs.getString(FIRSTNAMEDIRECTOR),
                        rs.getString(LASTNAMEDIRECTOR)
                    );
                    directors.add(director);
                }
            }
        }
        return directors;
    }

    @Override
    public List<Movie> readMovieFromDirector(int directorId) throws Exception {
        List<Movie> movies = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(READ_MOVIES_FROM_DIRECTOR)) {

            stmt.setInt(1, directorId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Movie movie = new Movie(
                        rs.getInt(IDMOVIE),
                        rs.getString(TITLE),
                        rs.getString(PICTURE_PATH),
                        rs.getString(DESCRIPTION),
                        LocalDate.parse(rs.getString(RELEASE_DATE), Movie.DATE_FORMATTER)
                    );
                    movies.add(movie);
                }
            }
        }
        return movies;
    }

    @Override
    public void removeDirectorFromMovie(int movieId, int directorId) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(READ_DIRECTORS_FROM_MOVIE)) {

            stmt.setInt(1, movieId);
            stmt.setInt(2, directorId);

            stmt.executeUpdate();
        }
    }

    //Genre and movie
    private static final String CREATE_GENRE_TO_MOVIE = "{ CALL CreateGenreToMovie (?, ?) }";
    private static final String READ_GENRES_FROM_MOVIE = "{ CALL ReadGenresFromMovie (?) }";
    private static final String READ_MOVIES_FROM_GENRE = "{ CALL ReadMoviesFromGenre (?) }";
    private static final String REMOVE_GENRE_FROM_MOVIE = "{ CALL RemoveGenreFromMovie (?, ?) }";

    
    @Override
    public void createGenreToMovie(int movieId, int genreId) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(CREATE_GENRE_TO_MOVIE)) {

            stmt.setInt(1, movieId);
            stmt.setInt(2, genreId);

            stmt.executeUpdate();
        }
    }

    @Override
    public List<Genre> selectGenresFromMovie(int movieId) throws Exception {
        List<Genre> genres = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(READ_GENRES_FROM_MOVIE)) {

            stmt.setInt(1, movieId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Genre genre = new Genre(
                        rs.getInt(IDGENRE),
                        rs.getString(NAMEGENRE)
                    );
                    genres.add(genre);
                }
            }
        }
        return genres;
    }

    @Override
    public List<Movie> selectMoviesFromGenre(int genreId) throws Exception {
        List<Movie> movies = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(READ_MOVIES_FROM_GENRE)) {

            stmt.setInt(1, genreId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Movie movie = new Movie(
                        rs.getInt(IDMOVIE),
                        rs.getString(TITLE),
                        rs.getString(PICTURE_PATH),
                        rs.getString(DESCRIPTION),
                        LocalDate.parse(rs.getString(RELEASE_DATE), Movie.DATE_FORMATTER)
                    );
                    movies.add(movie);
                }
            }
        }
        return movies;
    }

    @Override
    public void removeGenreFromMovie(int movieId, int genreId) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(REMOVE_GENRE_FROM_MOVIE)) {

            stmt.setInt(1, movieId);
            stmt.setInt(2, genreId);

            stmt.executeUpdate();
        }
    }
    
    // User authentication
    
    private static final String IDUSER = "ID";
    private static final String USERNAMEUSER = "Username";
    private static final String PASSWORDUSER = "Password";
    private static final String ROLENAMEUSER = "RoleName";

    private static final String GETUSERBYUSERNAME = "{CALL GetUserByUsername(?)}";
    private static final String CREATEUSER = "{CALL CreateUser(?, ?, ?, ?)}";

    public Optional<User> getUserByUsername(String username) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(GETUSERBYUSERNAME)) {

            stmt.setString(1, username);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String passwordStr = rs.getString(PASSWORDUSER);
                    char[] passwordHash = passwordStr != null ? passwordStr.toCharArray() : null;

                    return Optional.of(
                            new User(
                                    rs.getInt(IDUSER),
                                    rs.getString(USERNAMEUSER),
                                    passwordHash,
                                    rs.getString(ROLENAMEUSER)
                            )
                    );
                }
            }
        }

        return Optional.empty();
    }

    public int createUser(User user) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(CREATEUSER)) {

            stmt.setString(1, user.getUsername());

            // Hash the password before saving to DB
            char[] password = user.getPasswordHash();
            char[] hashedPassword = PasswordUtils.hashPassword(password);
            stmt.setString(2, new String(hashedPassword));

            stmt.setString(3, user.getRoleName());
            stmt.registerOutParameter(4, java.sql.Types.INTEGER);

            stmt.executeUpdate();
            int generatedId = stmt.getInt(4);

            // CLEAN UP
            Arrays.fill(password, '0');
            Arrays.fill(hashedPassword, '0');

            return generatedId;
        }
    }

    // Authenticates a user by hashing the input password and comparing it to DB hash
    public boolean authenticateUser(String username, char[] password) throws Exception {
        Optional<User> optionalUser = getUserByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Hash input password
            char[] hashedInput = PasswordUtils.hashPassword(password);

            boolean matches = Arrays.equals(hashedInput, user.getPasswordHash());

            // Clean up sensitive data
            Arrays.fill(password, '0');
            Arrays.fill(hashedInput, '0');

            return matches;
        }

        return false;
    }

    
    private static final String DELETEALLDATAEXCEPTUSERS = "{CALL DeleteAllDataExceptUsers()}";

    public void DeleteAllDataExceptUsers() throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(DELETEALLDATAEXCEPTUSERS)) {

            stmt.executeUpdate();
        }
    }
    
    
    
    
    
}
