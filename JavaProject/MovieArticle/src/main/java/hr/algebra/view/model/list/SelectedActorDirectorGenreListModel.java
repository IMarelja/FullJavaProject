/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view.model.list;

import hr.algebra.model.Actor;
import hr.algebra.model.Director;
import hr.algebra.model.Genre;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dnlbe
 */
public class SelectedActorDirectorGenreListModel extends AbstractListModel{
    
    private List<Actor> actors;
    private List<Director> directors;
    private List<Genre> genres;
    
    public SelectedActorDirectorGenreListModel(List<Actor> actors, List<Director> directors, List<Genre> genres) {
        this.actors = actors;
        this.directors = directors;
        this.genres = genres;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
        fireContentsChanged(this, 0, getSize() - 1);
    }
    
    public void setDirectors(List<Director> directors) {
        this.directors = directors;
        fireContentsChanged(this, 0, getSize() - 1);
    }
    
    public void setGenres(List<Genre> genres){
        this.genres = genres;
        fireContentsChanged(this, 0, getSize() - 1);
    }
    
    

    @Override
    public int getSize() {
        return directors.size();
    }

    @Override
    public Object getElementAt(int index) {
        return directors.get(index);
    }
    
    
}
