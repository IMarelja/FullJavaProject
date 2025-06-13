/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.view.model.transfer;

import hr.algebra.model.Genre;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 *
 * @author windsten
 */
public class GenreTransferable implements Transferable {
    public static final DataFlavor GENRE_FLAVOR = new DataFlavor(Genre.class, "Genre");
    private final Genre genre;

    public GenreTransferable(Object genre) {
        this.genre  = (Genre) genre;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{GENRE_FLAVOR};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return GENRE_FLAVOR.equals(flavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (!GENRE_FLAVOR.equals(flavor)) {
            throw new UnsupportedFlavorException(flavor);
        }
        return genre;
    }
    
}
