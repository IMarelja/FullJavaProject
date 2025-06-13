/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.view.model.transfer;

import hr.algebra.model.Director;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 *
 * @author windsten
 */
public class DirectorTransferable implements Transferable {

    public static final DataFlavor DIRECTOR_FLAVOR = new DataFlavor(Director.class, "Director");
    private final Director director;
    
    public DirectorTransferable(Object director) {
        this.director = (Director) director;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{DIRECTOR_FLAVOR};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return DIRECTOR_FLAVOR.equals(flavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (!DIRECTOR_FLAVOR.equals(flavor)) {
            throw new UnsupportedFlavorException(flavor);
        }
        return director;
    }
    
}
