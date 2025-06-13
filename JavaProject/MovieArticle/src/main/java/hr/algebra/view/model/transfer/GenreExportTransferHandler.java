/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.view.model.transfer;

import java.awt.datatransfer.Transferable;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.TransferHandler;

/**
 *
 * @author windsten
 */
public class GenreExportTransferHandler extends TransferHandler {
    @Override
    public int getSourceActions(JComponent c) {
        return COPY_OR_MOVE;
    }

    @Override
    protected Transferable createTransferable(JComponent c) {
        JList<?> list = (JList<?>) c;
        Object value = list.getSelectedValue();
        return new GenreTransferable(value);
    }
}

