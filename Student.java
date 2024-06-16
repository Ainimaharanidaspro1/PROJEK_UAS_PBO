package pbouas;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User {

    // Relasi One-to-Many dengan entitas Transcript(sehingga membentuk hubungan antara Student dan Transcript)
    @OneToMany(mappedBy = "student")
    private List<Transcript> transcripts;
    
    // Kolom untuk menyimpan student ID yang unik
    @Column(name = "student_id", nullable = false, unique = true)
    private String studentId;

    // Relasi Many-to-One dengan entitas Teacher sebagai supervisor
    @ManyToOne
    @JoinColumn(name = "supervisor_id") // kolom dalam tabel student
    private Teacher supervisor;

    // Relasi Many-to-Many dengan entitas Class
    @ManyToMany(mappedBy = "students")
    private Set<Class> classes = new HashSet<>();

    // Relasi One-to-Many dengan entitas Score
    @OneToMany(mappedBy = "student")
    private Set<Score> scores = new HashSet<>();

    // Konstruktor untuk menginisialisasi username, password, dan studentId
    public Student(String username, String password, String studentId) {
        super(username, password);
        this.studentId = studentId;
    }

    // Untuk mengakses dan mengubah nilai field untuk studentId
    public String getStudentId() {
        return studentId;
    }

    // Untuk mengakses dan mengubah nilai field untuk studentId
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // Untuk mengakses dan mengubah nilai field untuk supervisor
    public Teacher getSupervisor() {
        return supervisor;
    }

    // Untuk mengakses dan mengubah nilai field untuk supervisor
    public void setSupervisor(Teacher supervisor) {
        this.supervisor = supervisor;
    }

    // Untuk mengakses dan mengubah nilai field untuk classes
    public Set<Class> getClasses() {
        return classes;
    }

    // Untuk mengakses dan mengubah nilai field untuk classes
    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }

    // Untuk mengakses dan mengubah nilai field untuk scores
    public Set<Score> getScores() {
        return scores;
    }

    // Untuk mengakses dan mengubah nilai field untuk scores
    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    // Metode untuk menghitung IPK
    public double calculateGPA() {
        if (getScores().isEmpty()) {
            return 0.0; // Mengembalikan 0 jika tidak ada nilai
        }

        double totalScore = 0.0;
        int totalCredits = 0;

        for (Score score : getScores()) {
            totalScore += score.getIpk(); // Menggunakan nilai IPK dari Score
            totalCredits++;
        }

        if (totalCredits == 0) {
            return 0.0; // Mencegah pembagian dengan nol
        }

        // Menghitung IPK
        double gpa = totalScore / totalCredits;
        return gpa;
    }

    // Metode getName() yang belum diimplementasi
    String getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Untuk mengakses dan mengubah nilai field untuk transcripts
    public List<Transcript> getTranscripts() {
        return transcripts;
    }

    // Untuk mengakses dan mengubah nilai field untuk transcripts
    public void setTranscripts(List<Transcript> transcripts) {
        this.transcripts = transcripts;
    }
}
