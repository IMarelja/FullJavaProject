/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.view.model.transfer;

import hr.algebra.model.Actor;
import hr.algebra.model.Director;
import hr.algebra.model.Genre;
import static hr.algebra.view.model.transfer.ActorTransferable.ACTOR_FLAVOR;
import static hr.algebra.view.model.transfer.DirectorTransferable.DIRECTOR_FLAVOR;
import static hr.algebra.view.model.transfer.GenreTransferable.GENRE_FLAVOR;
import java.awt.Component;
import java.awt.Container;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.TransferHandler;

/**
 *
 * @author windsten
 */
public class MultiEntityTransferHandler extends TransferHandler {
    private final JToolBar targetToolBar;

    private String buttonExtraText = "[X] ";
    
    public MultiEntityTransferHandler(JToolBar targetToolBar) {
        this.targetToolBar = targetToolBar;
    }
    
    public MultiEntityTransferHandler(JToolBar targetToolBar, List<Actor> actors, List<Director> directors, List<Genre> genres) {
        this.targetToolBar = targetToolBar;

        if(!actors.isEmpty()){
            for (Actor actor : actors) {
                handleActorDrop(actor);
            }
        }

        if(!directors.isEmpty()){
            for (Director director : directors) {
                handleDirectorDrop(director);
            }
        }

        if(!genres.isEmpty()){
            for (Genre genre : genres) {
                handleGenreDrop(genre);
            }
        }
    }
    
    @Override
    public boolean canImport(TransferSupport support) {
        return support.isDataFlavorSupported(ACTOR_FLAVOR)
            || support.isDataFlavorSupported(DIRECTOR_FLAVOR)
            || support.isDataFlavorSupported(GENRE_FLAVOR);
    }

    @Override
    public boolean importData(TransferSupport support) {
        try {
            if (support.isDataFlavorSupported(ACTOR_FLAVOR)) {
                Actor actor = (Actor) support.getTransferable().getTransferData(ACTOR_FLAVOR);
                handleActorDrop(actor);
                return true;
            } else if (support.isDataFlavorSupported(DIRECTOR_FLAVOR)) {
                Director director = (Director) support.getTransferable().getTransferData(DIRECTOR_FLAVOR);
                handleDirectorDrop(director);
                return true;
            } else if (support.isDataFlavorSupported(GENRE_FLAVOR)) {
                Genre genre = (Genre) support.getTransferable().getTransferData(GENRE_FLAVOR);
                handleGenreDrop(genre);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void handleActorDrop(Actor actor) {
        if(buttonExists(actor)){
            return;
        }
        JButton btn = new JButton(buttonExtraText + actor.toString());
        btn.putClientProperty("Actor", actor);
        btn.setToolTipText("Actor");
        btn.addActionListener(e -> {
            Container parent = ((JButton)e.getSource()).getParent();
            parent.remove(((JButton)e.getSource()));
            parent.revalidate(); // Refresh the layout
            parent.repaint();
        });
        targetToolBar.add(btn);
        targetToolBar.revalidate();
        targetToolBar.repaint();
        
    }

    private void handleDirectorDrop(Director director) {
        if(buttonExists(director)){
            return;
        }
        JButton btn = new JButton(buttonExtraText + director.toString());
        btn.putClientProperty("Director", director);
        btn.setToolTipText("Director");
        btn.addActionListener(e -> {
            Container parent = ((JButton)e.getSource()).getParent();
            parent.remove(((JButton)e.getSource()));
            parent.revalidate(); // Refresh the layout
            parent.repaint();
        });
        targetToolBar.add(btn);
        targetToolBar.revalidate();
        targetToolBar.repaint();
    }

    private void handleGenreDrop(Genre genre) {
        JButton btn = new JButton(buttonExtraText + genre.toString());
        btn.putClientProperty("Genre", genre);
        btn.setToolTipText("Genre");
        btn.addActionListener(e -> {
            Container parent = ((JButton)e.getSource()).getParent();
            parent.remove(((JButton)e.getSource()));
            parent.revalidate(); // Refresh the layout
            parent.repaint();
        });
        targetToolBar.add(btn);
        targetToolBar.revalidate();
        targetToolBar.repaint();
    }
    
    private boolean buttonExists(Object object) {
        String propertyKey = null;

        // Determine the property key based on object type
        if (object instanceof Actor) {
            propertyKey = "Actor";
        } else if (object instanceof Director) {
            propertyKey = "Director";
        } else if (object instanceof Genre) {
            propertyKey = "Genre";
        } else {
            return false; // Unknown object type
        }

        // Check all buttons in the toolbar
        for (Component comp : targetToolBar.getComponents()) {
            if (comp instanceof JButton button) {
                Object storedObject = button.getClientProperty(propertyKey);

                // Check if the stored object equals the passed object
                if (object.equals(storedObject)) {
                    return true;
                }
            }
        }
        return false;
    }
    
}

