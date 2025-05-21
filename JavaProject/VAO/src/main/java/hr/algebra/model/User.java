/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author windsten
 */
public final class User {
    private int id;
    private String username;
    private char[] passwordHash;
    private String rolename;

    public User() {}

    public User(int id, String username, char[] passwordHash, String rolename) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.rolename = rolename;
    }

    public User(String username, char[] passwordHash, String rolename) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.rolename = rolename;
    }
    
    public User(String username, char[] passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }
    
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public char[] getPasswordHash() {
        return passwordHash;
    }

    public String getRoleName() {
        return rolename;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswordHash(char[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setRoleName(String rolename) {
        this.rolename = rolename;
    }

    
    
    
}
