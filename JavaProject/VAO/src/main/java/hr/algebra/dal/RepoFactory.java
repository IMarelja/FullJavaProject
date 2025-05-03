/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal;

import hr.algebra.dal.sql.SqlRepo;

/**
 *
 * @author windsten
 */
public class RepoFactory {
    private static Repository repository;

    private RepoFactory() {
    }
    // LAZY LAZY SINGLETON
    public static Repository getRepository() throws Exception {
        if (repository == null) {
            repository = new SqlRepo();
        }
        return repository;
    }
}
