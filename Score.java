package pbouas;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "score")
public class Score {

    // ID unik untuk setiap score, dihasilkan secara otomatis oleh basis data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Nilai score
    private int value;

    // IPK yang dihitung dari nilai score
    private double ipk; 

    // Relasi Many-to-One dengan entitas Class, dengan pengambilan data secara lazy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", nullable = false)
    private Class aClass;

    // Relasi Many-to-One dengan entitas Student, dengan pengambilan data secara lazy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // Konstruktor default (diperlukan oleh Hibernate)
    public Score() {
    }

    // Konstruktor untuk menginisialisasi nilai, kelas, dan siswa
    public Score(int value, Class aClass, Student student) {
        this.value = value;
        this.aClass = aClass;
        this.student = student;
        this.ipk = convertToGPA(value); // Hitung IPK saat score dibuat
    }

    // Untuk mengakses dan mengubah nilai field untuk ID score
    public int getId() {
        return id;
    }

    // Untuk mengakses dan mengubah nilai field untuk ID score
    public void setId(int id) {
        this.id = id;
    }

    // Untuk mengakses dan mengubah nilai field untuk nilai score
    public int getValue() {
        return value;
    }

    // SUntuk mengakses dan mengubah nilai field untuk nilai score
    public void setValue(int value) {
        this.value = value;
    }

    // Untuk mengakses dan mengubah nilai field untuk IPK
    public double getIpk() {
        return ipk;
    }

    // Untuk mengakses dan mengubah nilai field untuk IPK
    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    // Untuk mengakses dan mengubah nilai field untuk kelas
    public Class getaClass() {
        return aClass;
    }

    // Untuk mengakses dan mengubah nilai field untuk kelas
    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    // Untuk mengakses dan mengubah nilai field siswa
    public Student getStudent() {
        return student;
    }

    // Untuk mengakses dan mengubah nilai field untuk siswa
    public void setStudent(Student student) {
        this.student = student;
    }

    // Metode untuk mengkonversi nilai score ke IPK
    private double convertToGPA(int value) {
        if (value >= 90) {
            return 4.0;
        } else if (value >= 85) {
            return 3.9;
        } else if (value >= 80) {
            return 3.8;
        } else if (value >= 75) {
            return 3.7;
        } else if (value >= 70) {
            return 3.6;
        } else if (value >= 65) {
            return 3.5;
        } else if (value >= 60) {
            return 2.9;
        } else if (value >= 55) {
            return 2.5;
        } else if (value >= 50) {
            return 2.4;
        } else if (value >= 40) {
            return 2.3;
        } else if (value >= 20) {
            return 2.2;
        } else if (value >= 0) {
            return 1.1;
        } else {
            return 0.0;
        }
    }
}
