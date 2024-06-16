/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbouas;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Kelas entity yang merepresentasikan seorang pengguna (user) dalam sistem.
 */
@Entity
@Table(name="user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    
    /**
     * Konstruktor untuk kelas User.
     * @param username Nama pengguna (username) dari user.
     * @param password Kata sandi (password) dari user.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // ID unik dari user
    
    @NotNull
    @Column(name="username", nullable=false, unique = true)
    private String username; // Username dari user, tidak boleh null dan harus unik
    
    @NotNull
    @Column(name="password", nullable=false)
    private String password; // Password dari user, tidak boleh null

    // Getter dan Setter untuk setiap atribut

    /**
     * @return ID dari user.
     */
    public int getId() {
        return id;
    }

    /**
     * @param id ID yang akan di-set untuk user.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Username dari user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username Username yang akan di-set untuk user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return Password dari user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password Password yang akan di-set untuk user.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
