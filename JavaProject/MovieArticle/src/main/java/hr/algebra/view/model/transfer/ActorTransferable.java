/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.view.model.transfer;

import hr.algebra.model.Actor;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

/**
 *
 * @author windsten
 */
public class ActorTransferable implements Transferable {
    public static final DataFlavor ACTOR_FLAVOR = new DataFlavor(Actor.class, "Actor");
    private final Actor actor;

    public ActorTransferable(Object actor) {
        this.actor = (Actor) actor;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{ACTOR_FLAVOR};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return ACTOR_FLAVOR.equals(flavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
        if (!ACTOR_FLAVOR.equals(flavor)) {
            throw new UnsupportedFlavorException(flavor);
        }
        return actor;
    }
}

