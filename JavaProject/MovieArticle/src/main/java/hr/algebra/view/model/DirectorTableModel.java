/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view.model;

import hr.algebra.model.Actor;
import hr.algebra.model.Director;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dnlbe
 */
public class DirectorTableModel extends AbstractTableModel{
    
    private static final String[] COLUMN_NAMES = {"Id", "Firstname", "Lastname"};

    private List<Director> directors;

    public DirectorTableModel(List<Director> directors) {
        this.directors = directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
        fireTableDataChanged();
    }
    
    

    @Override
    public int getRowCount() {
        return directors.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
        }
        return super.getColumnClass(columnIndex); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    /*
    FIX THIS SHIT
    */
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return directors.get(rowIndex).getId();
            case 1:
                return directors.get(rowIndex).getFirstName();
            case 2:
                return directors.get(rowIndex).getLastName();
            default:
                throw new AssertionError();
        }
    }
    
    
}
