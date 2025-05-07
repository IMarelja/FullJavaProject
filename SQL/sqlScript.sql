CREATE DATABASE VIDEORENTAL
GO
USE VIDEORENTAL
GO

-- Create Administrator table
CREATE TABLE Administrator (
    ID INT PRIMARY KEY IDENTITY,
    Username NVARCHAR(100) NOT NULL,
    Password NVARCHAR(255) NOT NULL
);

-- Create User table
CREATE TABLE [User] (
    ID INT PRIMARY KEY IDENTITY,
    Username NVARCHAR(100) NOT NULL,
    Password NVARCHAR(255) NOT NULL
);

-- Create Actor table
CREATE TABLE Actor (
    ID INT PRIMARY KEY IDENTITY,
    FirstName NVARCHAR(100) NOT NULL,
    LastName NVARCHAR(100) NOT NULL
);

-- Create Director table
CREATE TABLE Director (
    ID INT PRIMARY KEY IDENTITY,
    FirstName NVARCHAR(100) NOT NULL,
    LastName NVARCHAR(100) NOT NULL
);

-- Create Genre table
CREATE TABLE Genre (
    ID INT PRIMARY KEY IDENTITY,
    Name NVARCHAR(100) NOT NULL
);

-- Create Movie table
CREATE TABLE Movie (
    ID INT PRIMARY KEY IDENTITY,
    Title NVARCHAR(255) NOT NULL,
    PicturePath NVARCHAR(255) NOT NULL,
    Description NVARCHAR(MAX) NOT NULL, 
    ReleaseDate NVARCHAR(30) NOT NULL
);

-- Create junction tables for M:N relationships
CREATE TABLE Movie_Actor (
    MovieID INT NOT NULL,
    ActorID INT NOT NULL,
    PRIMARY KEY (MovieID, ActorID),
    FOREIGN KEY (MovieID) REFERENCES Movie(ID) ON DELETE CASCADE,
    FOREIGN KEY (ActorID) REFERENCES Actor(ID) ON DELETE CASCADE
);

CREATE TABLE Movie_Director (
    MovieID INT NOT NULL,
    DirectorID INT NOT NULL,
    PRIMARY KEY (MovieID, DirectorID),
    FOREIGN KEY (MovieID) REFERENCES Movie(ID) ON DELETE CASCADE,
    FOREIGN KEY (DirectorID) REFERENCES Director(ID) ON DELETE CASCADE
);

CREATE TABLE Movie_Genre (
    MovieID INT NOT NULL,
    GenreID INT NOT NULL,
    PRIMARY KEY (MovieID, GenreID),
    FOREIGN KEY (MovieID) REFERENCES Movie(ID) ON DELETE CASCADE,
    FOREIGN KEY (GenreID) REFERENCES Genre(ID) ON DELETE CASCADE
);

-- ============================
-- Administrator CRUD procedures
-- ============================

-- Create Administrator
CREATE PROCEDURE CreateAdministrator
    @Username NVARCHAR(100),
    @Password NVARCHAR(255),
    @ID INT OUTPUT
AS
BEGIN
    INSERT INTO Administrator (Username, Password)
    VALUES (@Username, @Password);
    
    SET @ID = SCOPE_IDENTITY();
END
GO

-- Read Administrator
CREATE PROCEDURE ReadAdministrator
    @ID INT
AS
BEGIN
    SELECT ID, Username, Password
    FROM Administrator
    WHERE ID = @ID;
END
GO

CREATE PROCEDURE ReadAdministrators
AS
BEGIN
    SELECT ID, Username, Password
    FROM Administrator;
END
GO

-- Update Administrator
CREATE PROCEDURE UpdateAdministrator
    @ID INT,
    @Username NVARCHAR(100),
    @Password NVARCHAR(255)
AS
BEGIN
    UPDATE Administrator
    SET Username = @Username,
        Password = @Password
    WHERE ID = @ID;
END
GO

-- Delete Administrator
CREATE PROCEDURE DeleteAdministrator
    @ID INT
AS
BEGIN
    DELETE FROM Administrator
    WHERE ID = @ID;
END
GO

-- ============================
-- User CRUD procedures
-- ============================

-- Create User
CREATE PROCEDURE CreateUser
    @Username NVARCHAR(100),
    @Password NVARCHAR(255),
    @ID INT OUTPUT
AS
BEGIN
    INSERT INTO [User] (Username, Password)
    VALUES (@Username, @Password);
    
    SET @ID = SCOPE_IDENTITY();
END
GO

-- Read User
CREATE PROCEDURE ReadUser
    @ID INT
AS
BEGIN
    SELECT ID, Username, Password
    FROM [User]
    WHERE ID = @ID;
END
GO

CREATE PROCEDURE ReadUsers
AS
BEGIN
    SELECT ID, Username, Password
    FROM [User];
END
GO

-- Update User
CREATE PROCEDURE UpdateUser
    @ID INT,
    @Username NVARCHAR(100),
    @Password NVARCHAR(255)
AS
BEGIN
    UPDATE [User]
    SET Username = @Username,
        Password = @Password
    WHERE ID = @ID;
END
GO

-- Delete User
CREATE PROCEDURE DeleteUser
    @ID INT
AS
BEGIN
    DELETE FROM [User]
    WHERE ID = @ID;
END
GO

-- ============================
-- Actor CRUD procedures
-- ============================

-- Create Actor
CREATE PROCEDURE CreateActor
    @FirstName NVARCHAR(100),
    @LastName NVARCHAR(100),
    @ID INT OUTPUT
AS
BEGIN
    INSERT INTO Actor (FirstName, LastName)
    VALUES (@FirstName, @LastName);
    
    SET @ID = SCOPE_IDENTITY();
END
GO

-- Read Actor
CREATE PROCEDURE ReadActor
    @ID INT
AS
BEGIN
    SELECT ID, FirstName, LastName
    FROM Actor
    WHERE ID = @ID;
END
GO

CREATE PROCEDURE ReadActors
AS
BEGIN
    SELECT ID, FirstName, LastName
    FROM Actor;
END
GO

-- Update Actor
CREATE PROCEDURE UpdateActor
    @ID INT,
    @FirstName NVARCHAR(100),
    @LastName NVARCHAR(100)
AS
BEGIN
    UPDATE Actor
    SET FirstName = @FirstName,
        LastName = @LastName
    WHERE ID = @ID;
END
GO

-- Delete Actor
CREATE PROCEDURE DeleteActor
    @ID INT
AS
BEGIN
    DELETE FROM Actor
    WHERE ID = @ID;
END
GO

-- ============================
-- Director CRUD procedures
-- ============================

-- Create Director
CREATE PROCEDURE CreateDirector
    @FirstName NVARCHAR(100),
    @LastName NVARCHAR(100),
    @ID INT OUTPUT
AS
BEGIN
    INSERT INTO Director (FirstName, LastName)
    VALUES (@FirstName, @LastName);
    
    SET @ID = SCOPE_IDENTITY();
END
GO

-- Read Director
CREATE PROCEDURE ReadDirector
    @ID INT
AS
BEGIN
    SELECT ID, FirstName, LastName
    FROM Director
    WHERE ID = @ID;
END
GO

CREATE PROCEDURE ReadDirectors
AS
BEGIN
    SELECT ID, FirstName, LastName
    FROM Director;
END
GO

-- Update Director
CREATE PROCEDURE UpdateDirector
    @ID INT,
    @FirstName NVARCHAR(100),
    @LastName NVARCHAR(100)
AS
BEGIN
    UPDATE Director
    SET FirstName = @FirstName,
        LastName = @LastName
    WHERE ID = @ID;
END
GO

-- Delete Director
CREATE PROCEDURE DeleteDirector
    @ID INT
AS
BEGIN
    DELETE FROM Director
    WHERE ID = @ID;
END
GO

-- ============================
-- Genre CRUD procedures
-- ============================

-- Create Genre
CREATE PROCEDURE CreateGenre
    @Name NVARCHAR(100),
    @ID INT OUTPUT
AS
BEGIN
    INSERT INTO Genre (Name)
    VALUES (@Name);
    
    SET @ID = SCOPE_IDENTITY();
END
GO

-- Read Genre
CREATE PROCEDURE ReadGenre
    @ID INT
AS
BEGIN
    SELECT ID, Name
    FROM Genre
    WHERE ID = @ID;
END
GO

CREATE PROCEDURE ReadGenres
AS
BEGIN
    SELECT ID, Name
    FROM Genre;
END
GO

-- Update Genre
CREATE PROCEDURE UpdateGenre
    @ID INT,
    @Name NVARCHAR(100)
AS
BEGIN
    UPDATE Genre
    SET Name = @Name
    WHERE ID = @ID;
END
GO

-- Delete Genre
CREATE PROCEDURE DeleteGenre
    @ID INT
AS
BEGIN
    DELETE FROM Genre
    WHERE ID = @ID;
END
GO

-- ============================
-- Movie CRUD procedures
-- ============================

-- Create Movie
CREATE PROCEDURE CreateMovie
    @Title NVARCHAR(255),
    @PicturePath NVARCHAR(255),
    @Description NVARCHAR(MAX),
    @ReleaseDate NVARCHAR(30),
    @ID INT OUTPUT
AS
BEGIN
    INSERT INTO Movie (Title, PicturePath, Description, ReleaseDate)
    VALUES (@Title, @PicturePath, @Description, @ReleaseDate);
    
    SET @ID = SCOPE_IDENTITY();
END
GO

-- Read Movie
CREATE PROCEDURE ReadMovie
    @ID INT
AS
BEGIN
    SELECT ID, Title, PicturePath, Description, ReleaseDate
    FROM Movie
    WHERE ID = @ID;
END
GO

CREATE PROCEDURE ReadMovies
AS
BEGIN
    SELECT ID, Title, PicturePath, Description, ReleaseDate
    FROM Movie;
END
GO

-- Update Movie
CREATE PROCEDURE UpdateMovie
    @ID INT,
    @Title NVARCHAR(255),
    @PicturePath NVARCHAR(255),
    @Description NVARCHAR(MAX),
    @ReleaseDate NVARCHAR(30)
AS
BEGIN
    UPDATE Movie
    SET Title = @Title,
        PicturePath = @PicturePath,
        Description = @Description,
        ReleaseDate = @ReleaseDate
    WHERE ID = @ID;
END
GO

-- Delete Movie
CREATE PROCEDURE DeleteMovie
    @ID INT
AS
BEGIN
    DELETE FROM Movie
    WHERE ID = @ID;
END
GO

-- ============================
-- Movie-Actor Relationship CRUD
-- ============================

-- Create Actor to Movie
CREATE PROCEDURE CreateActorFromMovie
    @MovieID INT,
    @ActorID INT
AS
BEGIN
    INSERT INTO Movie_Actor (MovieID, ActorID)
    VALUES (@MovieID, @ActorID);
END
GO

-- Read Actors for a Movie
CREATE PROCEDURE ReadActorsFromMovie
    @MovieID INT
AS
BEGIN
    SELECT a.ID, a.FirstName, a.LastName
    FROM Actor a
    INNER JOIN Movie_Actor ma ON a.ID = ma.ActorID
    WHERE ma.MovieID = @MovieID;
END
GO

-- Read Movies for an Actor
CREATE PROCEDURE ReadMoviesFromActor
    @ActorID INT
AS
BEGIN
    SELECT m.ID, m.Title, m.PicturePath, m.Description, m.ReleaseDate
    FROM Movie m
    INNER JOIN Movie_Actor ma ON m.ID = ma.MovieID
    WHERE ma.ActorID = @ActorID;
END
GO

-- Remove Actor from Movie
CREATE PROCEDURE DeleteActorFromMovie
    @MovieID INT,
    @ActorID INT
AS
BEGIN
    DELETE FROM Movie_Actor
    WHERE MovieID = @MovieID AND ActorID = @ActorID;
END
GO

-- ============================
-- Movie-Director Relationship CRUD
-- ============================

-- Create Director to Movie
CREATE PROCEDURE CreateDirectorToMovie
    @MovieID INT,
    @DirectorID INT
AS
BEGIN
    INSERT INTO Movie_Director (MovieID, DirectorID)
    VALUES (@MovieID, @DirectorID);
END
GO

-- Read Directors for a Movie
CREATE PROCEDURE ReadDirectorsFromMovie
    @MovieID INT
AS
BEGIN
    SELECT d.ID, d.FirstName, d.LastName
    FROM Director d
    INNER JOIN Movie_Director md ON d.ID = md.DirectorID
    WHERE md.MovieID = @MovieID;
END
GO

-- Read Movies for a Director
CREATE PROCEDURE ReadMoviesFromDirector
    @DirectorID INT
AS
BEGIN
    SELECT m.ID, m.Title, m.PicturePath, m.Description, m.ReleaseDate
    FROM Movie m
    INNER JOIN Movie_Director md ON m.ID = md.MovieID
    WHERE md.DirectorID = @DirectorID;
END
GO

-- Remove Director from Movie
CREATE PROCEDURE RemoveDirectorFromMovie
    @MovieID INT,
    @DirectorID INT
AS
BEGIN
    DELETE FROM Movie_Director
    WHERE MovieID = @MovieID AND DirectorID = @DirectorID;
END
GO

-- ============================
-- Movie-Genre Relationship CRUD
-- ============================

-- Create Genre to Movie
CREATE PROCEDURE CreateGenreToMovie
    @MovieID INT,
    @GenreID INT
AS
BEGIN
    INSERT INTO Movie_Genre (MovieID, GenreID)
    VALUES (@MovieID, @GenreID);
END
GO

-- Read Genres for a Movie
CREATE PROCEDURE ReadGenresFromMovie
    @MovieID INT
AS
BEGIN
    SELECT g.ID, g.Name
    FROM Genre g
    INNER JOIN Movie_Genre mg ON g.ID = mg.GenreID
    WHERE mg.MovieID = @MovieID;
END
GO

-- Read Movies for a Genre
CREATE PROCEDURE ReadMoviesFromGenre
    @GenreID INT
AS
BEGIN
    SELECT m.ID, m.Title, m.PicturePath, m.Description, m.ReleaseDate
    FROM Movie m
    INNER JOIN Movie_Genre mg ON m.ID = mg.MovieID
    WHERE mg.GenreID = @GenreID;
END
GO

-- Remove Genre from Movie
CREATE PROCEDURE RemoveGenreFromMovie
    @MovieID INT,
    @GenreID INT
AS
BEGIN
    DELETE FROM Movie_Genre
    WHERE MovieID = @MovieID AND GenreID = @GenreID;
END
GO

-- ============================
-- Authenticatition
-- ============================

CREATE PROCEDURE AuthenticateUser
    @Username NVARCHAR(100),
    @Password NVARCHAR(255)
AS
BEGIN
    SELECT ID, Username, Password
    FROM [User]
    WHERE Username = @Username AND Password = @Password;
END
GO

CREATE PROCEDURE AuthenticateAdministrator
    @Username NVARCHAR(100),
    @Password NVARCHAR(255)
AS
BEGIN
    SELECT ID, Username, Password
    FROM Administrator
    WHERE Username = @Username AND Password = @Password;
END
GO