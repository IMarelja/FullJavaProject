/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view.model.list;

import hr.algebra.model.Genre;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author dnlbe
 */
public class GenreListModel extends AbstractListModel{

    private List<Genre> genres;

    public GenreListModel(List<Genre> genres) {
        this.genres = genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
        fireContentsChanged(this, 0, getSize() - 1);
    }

    @Override
    public int getSize() {
        return genres.size();
    }

    @Override
    public Object getElementAt(int index) {
        return genres.get(index);
    }
    
    
}
