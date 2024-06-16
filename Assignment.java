package pbouas;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Assignment extends Activity {

    // Field untuk menyimpan tanggal jatuh tempo tugas
    private LocalDateTime dueDate;

    // Relasi Many-to-Many antara Assignment dan Student
    // Menggunakan tabel perantara 'assignment_assignees'
    @ManyToMany
    @JoinTable(
        name = "assignment_assignees",
        joinColumns = @JoinColumn(name = "assignment_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> assignees = new HashSet<>();

    // Implementasi metode abstrak getDescription dari kelas Activity
    // Mengembalikan deskripsi tugas dengan tanggal jatuh tempo
    @Override
    public String getDescription() {
        return "Assignment due on " + getDueDate();
    }

    // Mendapatkan tanggal jatuh tempo tugas
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    // Mengatur tanggal jatuh tempo tugas
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    // Mendapatkan daftar siswa yang ditugaskan
    public Set<Student> getAssignees() {
        return assignees;
    }

    // Mengatur daftar siswa yang ditugaskan
    public void setAssignees(Set<Student> assignees) {
        this.assignees = assignees;
    }
}
