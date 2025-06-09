/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view.model.list;

import hr.algebra.model.Director;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author dnlbe
 */
public class DirectorListModel extends AbstractListModel{

    private List<Director> directors;

    public DirectorListModel(List<Director> directors) {
        this.directors = directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
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
