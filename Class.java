/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbouas;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Kelas ini merepresentasikan entitas Class dalam basis data.
 * Penulis: user
 */
@Entity
@Table(name="class")
public class Class {
    
    // Konstruktor dengan parameter classId
    public Class(String classId)
    {
       this.classId = classId;
    }     
    
    // Field untuk menyimpan ID unik kelas, dihasilkan secara otomatis oleh basis data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    // Field untuk menyimpan ID kelas, harus unik dan tidak boleh null
    @Column(name="username", nullable=false, unique=true)
    private String classId;
    
    // Relasi Many-to-One dengan entitas Teacher, dengan pengambilan data secara lazy
    @ManyToOne(fetch=FetchType.LAZY)
    private Teacher teacher;
    
    // Relasi Many-to-One dengan entitas Course, dengan pengambilan data secara lazy
    @ManyToOne(fetch=FetchType.LAZY)
    private Course course;
    
    // Relasi Many-to-Many dengan entitas Student, menggunakan tabel perantara student_class
    @ManyToMany
    @JoinTable(
    name="student_class",
            joinColumns = @JoinColumn(name="class_id"),
            inverseJoinColumns = @JoinColumn(name="student_id")
    )
    private Set<Student> students = new HashSet<>();

    /**
     * Mendapatkan ID dari kelas.
     * @return id kelas.
     */
    public int getId() {
        return id;
    }

    /**
     * Mengatur ID untuk kelas.
     * @param id ID yang akan diatur untuk kelas.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Mendapatkan ID kelas.
     * @return classId ID kelas.
     */
    public String getClassId() {
        return classId;
    }

    /**
     * Mengatur ID kelas.
     * @param classId ID kelas yang akan diatur.
     */
    public void setClassId(String classId) {
        this.classId = classId;
    }

    /**
     * Mendapatkan guru yang mengajar kelas ini.
     * @return teacher Guru yang mengajar kelas ini.
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * Mengatur guru untuk kelas ini.
     * @param teacher Guru yang akan diatur untuk kelas ini.
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * Mendapatkan kursus yang terkait dengan kelas ini.
     * @return course Kursus yang terkait dengan kelas ini.
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Mengatur kursus untuk kelas ini.
     * @param course Kursus yang akan diatur untuk kelas ini.
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * Mendapatkan daftar siswa yang terdaftar di kelas ini.
     * @return students Daftar siswa yang terdaftar di kelas ini.
     */
    public Set<Student> getStudents() {
        return students;
    }

    /**
     * Mengatur daftar siswa yang terdaftar di kelas ini.
     * @param students Daftar siswa yang akan diatur untuk kelas ini.
     */
    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    /**
     * Mendapatkan daftar aktivitas yang terkait dengan kelas ini.
     * @return daftar aktivitas
     */
    Set<Activity> getActivities() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
