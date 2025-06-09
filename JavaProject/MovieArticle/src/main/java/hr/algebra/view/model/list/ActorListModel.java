/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view.model.list;

import hr.algebra.model.Actor;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author dnlbe
 */
public class ActorListModel extends AbstractListModel{

    private List<Actor> actors;

    public ActorListModel(List<Actor> actors) {
        this.actors = actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
        fireContentsChanged(this, 0, getSize() - 1);
    }

    @Override
    public int getSize() {
        return actors.size();
    }

    @Override
    public Object getElementAt(int index) {
        return actors.get(index);
    }
    
    
}

