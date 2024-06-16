package pbouas;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class myhibernate {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // membuat dan menyimpan 20 data mahasiswa ke database
        Student student1 = new Student("samurai", "12345", "24242424");
        session.save(student1);
        Student student2 = new Student("Hana", "12345", "23232323");
        session.save(student2);
        Student student3 = new Student("Prisil", "12345", "25252525");
        session.save(student3);
        Student student4 = new Student("Gilang", "12345", "26262626");
        session.save(student4);
        Student student5 = new Student("Keenan", "12345", "27272727");
        session.save(student5);
        Student student6 = new Student("Risa", "12345", "28282828");
        session.save(student6);
        Student student7 = new Student("Luna", "12345", "29292929");
        session.save(student7);
        Student student8 = new Student("Cinta", "12345", "30303030");
        session.save(student8);
        Student student9 = new Student("Liam", "12345", "31313131");
        session.save(student9);
        Student student10 = new Student("Aldo", "12345", "32323232");
        session.save(student10);
        Student student11 = new Student("Klara", "12345", "33333333");
        session.save(student11);
        Student student12 = new Student("Lisa", "12345", "34343434");
        session.save(student12);
        Student student13 = new Student("Pian", "12345", "35353535");
        session.save(student13);
        Student student14 = new Student("Pika", "12345", "36363636");
        session.save(student14);
        Student student15 = new Student("Rian", "12345", "37373737");
        session.save(student15);
        Student student16 = new Student("Dona", "12345", "38383838");
        session.save(student16);
        Student student17 = new Student("Rara", "12345", "39393939");
        session.save(student17);
        Student student18 = new Student("Laka", "12345", "40404040");
        session.save(student18);
        Student student19 = new Student("Rika", "12345", "41414141");
        session.save(student19);
        Student student20 = new Student("Dino", "12345", "42424242");
        session.save(student20);

        // membuat dan menyimpan 4 dosen pengajar kedatabase
        Teacher teacher1 = new Teacher("shinobi", "12345", "02020202");
        session.save(teacher1);
        Teacher teacher2 = new Teacher("larasati", "12345", "03030303");
        session.save(teacher2);
        Teacher teacher3 = new Teacher("pilara", "12345", "04040404");
        session.save(teacher3);
        Teacher teacher4 = new Teacher("dikala", "12345", "05050505");
        session.save(teacher4);

        // membuat dan menyimpan course kedalam database
        Course course1 = new Course("Game Development", "Ik101010");
        session.save(course1);
        Course course2 = new Course("Kriptografi", "Ik111111");
        session.save(course2);
        Course course3 = new Course("Kecerdasan Buatan", "Ik121212");
        session.save(course3);
        Course course4 = new Course("Algoritma Pemrograman", "Ik131313");
        session.save(course4);

        // membuat dan menyimpan 4 kelas yang akan diikuti oleh mahasiswa. 
        // mahasiswa yang mengikuti kelas dapat disimpan acak dan tidak wajib mengambil 4 kelas
        Class class1 = new Class("class01");
        class1.setTeacher(teacher1);
        class1.setCourse(course1);
        class1.getStudents().add(student1);
        class1.getStudents().add(student2);
        class1.getStudents().add(student3);
        class1.getStudents().add(student4);
        class1.getStudents().add(student5);
        class1.getStudents().add(student6);
        class1.getStudents().add(student7);
        class1.getStudents().add(student8);
        session.save(class1);

        Class class2 = new Class("class02");
        class2.setTeacher(teacher2);
        class2.setCourse(course2);
        class2.getStudents().add(student1);
        class2.getStudents().add(student3);
        class2.getStudents().add(student4);
        class2.getStudents().add(student7);
        class2.getStudents().add(student8);
        session.save(class2);

        Class class3 = new Class("class03");
        class3.setTeacher(teacher3);
        class3.setCourse(course3);
        class3.getStudents().add(student1);
        class3.getStudents().add(student5);
        class3.getStudents().add(student6);
        session.save(class3);

        Class class4 = new Class("class04");
        class4.setTeacher(teacher4);
        class4.setCourse(course4);
        class4.getStudents().add(student2);
        class4.getStudents().add(student7);
        class4.getStudents().add(student8);
        session.save(class4);

        //mengatur data untuk mahasiswa yang memiliki satu dosen pembimbing dan 
        //satu dosen memiliki banyak mahasiswa yang dibimbing
        student1.setSupervisor(teacher1);
        student2.setSupervisor(teacher1);
        student3.setSupervisor(teacher2);
        student4.setSupervisor(teacher2);
        student5.setSupervisor(teacher3);
        student6.setSupervisor(teacher3);
        student7.setSupervisor(teacher4);
        student8.setSupervisor(teacher4);
        student9.setSupervisor(teacher1);
        student10.setSupervisor(teacher1);
        student11.setSupervisor(teacher2);
        student12.setSupervisor(teacher2);
        student13.setSupervisor(teacher3);
        student14.setSupervisor(teacher3);
        student15.setSupervisor(teacher4);
        student16.setSupervisor(teacher4);
        student17.setSupervisor(teacher1);
        student18.setSupervisor(teacher1);
        student19.setSupervisor(teacher2);
        student20.setSupervisor(teacher2);
            
        // menyimpan nilai yang didapatkan oleh mahasiswa dari satu kelas tertentu
        //misal nya ada mahasiswa dikelas1, kelas2 dst...yang memiliki nilai berbeda beda
        Score score1 = new Score(95, class1, student1);
        session.save(score1);
        Score score2 = new Score(88, class1, student2);
        session.save(score2);
        Score score3 = new Score(75, class2, student3);
        session.save(score3);
        Score score4 = new Score(60, class2, student4);
        session.save(score4);
        Score score5 = new Score(90, class3, student5);
        session.save(score5);
        Score score6 = new Score(80, class3, student6);
        session.save(score6);
        Score score7 = new Score(52, class4, student7);
        session.save(score7);
        Score score8 = new Score(82, class4, student8);
        session.save(score8);
        Score score9 = new Score(67, class4, student9);
        session.save(score9);
        Score score10 = new Score(62, class4, student10);
        session.save(score10);
        Score score11 = new Score(92, class3, student11);
        session.save(score11);
        Score score12 = new Score(40, class2, student12);
        session.save(score12);
        Score score13 = new Score(78, class2, student13);
        session.save(score13);
        Score score15 = new Score(89, class4, student15);
        session.save(score15); 
        Score score16 = new Score(89, class1, student16);
        session.save(score16);
        Score score17 = new Score(88, class2 ,student17);
        session.save(score17);
        Score score18 = new Score(87, class1, student18);
        session.save(score8);
        Score score19 = new Score(56, class1, student19);
        session.save(score8);      
        Score score20 = new Score(67, class1, student20);
        session.save(score20);
        
        // membuat dan menyimpan aktivitas pada kelas1
        createAndSaveActivities(session, class1, student1, student2, student3);
        // membuat dan menyimpan aktivitas pada kelas2
        createAndSaveActivities(session, class2, student4, student5, student6);
        // membuat dan menyimpan aktivitas pada kelas3
        createAndSaveActivities(session, class3, student7, student8, student9);
        // membuat dan menyimpan aktivitas pada kelas4
        createAndSaveActivities(session, class4, student10, student11, student12);

        // membuat objek transkrip
        Transcript transcript = new Transcript();
        transcript.setCourseCode("ik121212");
        transcript.setCourseName("Kecerdasan Buatan");
        transcript.setScore(80.0);
        
        // menyimpan transkrip ke database
        session.save(transcript);

        // Commit transaction
        transaction.commit();

        // Update GPA untuk setiap mahasiswa dan simpan perubahan
        Transaction updateTransaction = session.beginTransaction();
        List<Student> students = session.createQuery("from Student", Student.class).getResultList();
        for (Student student : students) {
            student.calculateGPA(); // Update GPA
            session.update(student); // Simpan perubahan
        }
        updateTransaction.commit();

        // Tutup sesi
        session.close();

        // Print daftar kehadiran dan penerimaan untuk setiap kelas
        printActivities(session, class1);
        printActivities(session, class2);
        printActivities(session, class3);
        printActivities(session, class4);
    }

    // Method untuk membuat dan menyimpan kegiatan-kegiatan
    private static void createAndSaveActivities(Session session, Class aClass, Student... students) {
        for (int i = 0; i < 3; i++) {
            // untuk membuat dan menyimpan pertemuan (Meeting)
            Meeting meeting = new Meeting();
            meeting.setClassInfo(aClass);
            meeting.setMeetingStartTime(LocalDateTime.now().plusDays(i));
            for (Student student : students) {
                meeting.getAttendees().add(student);
            }
            session.save(meeting);

            // untuk membuat dan menyimpan tugas (Assignment)
            Assignment assignment = new Assignment();
            assignment.setClassInfo(aClass);
            assignment.setDueDate(LocalDateTime.now().plusDays(i + 7));
            for (Student student : students) {
                assignment.getAssignees().add(student);
            }
            session.save(assignment);
        }
    }

    // Method untuk mencetak kegiatan-kegiatan dalam sebuah kelas
    private static void printActivities(Session session, Class aClass) {
        // Refresh aClass untuk memperbarui daftar kegiatan
        session.refresh(aClass);
        Set<Activity> activities = aClass.getActivities();
        System.out.println("Kegiatan untuk kelas: " + aClass.getClassId());

        // Iterasi dan cetak setiap kegiatan
        for (Activity activity : activities) {
            if (activity instanceof Meeting) {
                // Jika kegiatan adalah Meeting, cetak informasi pertemuan dan peserta
                Meeting meeting = (Meeting) activity;
                System.out.println("Pertemuan pada " + meeting.getMeetingStartTime() + " dengan peserta:");
                for (Student student : meeting.getAttendees()) {
                    System.out.println(" - " + student.getName());
                }
            } else if (activity instanceof Assignment) {
                // Jika kegiatan adalah Assignment, cetak informasi tugas dan penerima tugas
                Assignment assignment = (Assignment) activity;
                System.out.println("Tugas jatuh tempo pada " + assignment.getDueDate() + " dengan penerima:");
                for (Student student : assignment.getAssignees()) {
                    System.out.println(" - " + student.getName());
                }
            }
        }
    }
}