package pbouas;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Meeting extends Activity {

    // Field untuk menyimpan waktu mulai meeting
    private LocalDateTime meetingStartTime;

    // Relasi Many-to-Many antara Meeting dan Student
    // Menggunakan tabel perantara 'meeting_attendees'
    @ManyToMany
    @JoinTable(
        name = "meeting_attendees",
        joinColumns = @JoinColumn(name = "meeting_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> attendees = new HashSet<>();

    // Implementasi metode abstrak getDescription dari kelas Activity
    // Mengembalikan deskripsi meeting dengan waktu mulai
    @Override
    public String getDescription() {
        return "Meeting at " + getMeetingStartTime();
    }

    // Mendapatkan waktu mulai meeting
    public LocalDateTime getMeetingStartTime() {
        return meetingStartTime;
    }

    // Mengatur waktu mulai meeting
    public void setMeetingStartTime(LocalDateTime meetingStartTime) {
        this.meetingStartTime = meetingStartTime;
    }

    // Mendapatkan daftar siswa yang menghadiri meeting
    public Set<Student> getAttendees() {
        return attendees;
    }

    // Mengatur daftar siswa yang menghadiri meeting
    public void setAttendees(Set<Student> attendees) {
        this.attendees = attendees;
    }
}
