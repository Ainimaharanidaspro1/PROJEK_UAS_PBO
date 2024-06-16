package pbouas;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Activity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)//menunjukkan bahwa pengambilan data entitas Class 
            //yang terkait dengan entitas Activity akan dilakukan secara (lazy loading). 
            //Ini berarti bahwa data Class hanya akan diambil 
            //dari basis data ketika pertama kali diakses, bukan saat entitas Activity diambil.
    @JoinColumn(name = "class_id")//akan menyimpan referensi ke ID dari entitas Class yang terkait, 
            //sehingga membentuk hubungan antara Activity dan Class.
    private Class classInfo;

//Metode abstrak yang harus diimplementasikan oleh subclass untuk memberikan 
    //deskripsi dari aktivitas.
    public abstract String getDescription();

//Mendapatkan informasi kelas yang terkait dengan untuk aktivitas ini.
    public Class getClassInfo() {
        return classInfo;
    }

//Menetapkan informasi kelas untuk aktivitas ini.
    public void setClassInfo(Class classInfo) {
        this.classInfo = classInfo;
    }

 //Mendapatkan kursus yang terkait dengan kelas dari aktivitas ini.
    public Course getCourse() {
        return getClassInfo().getCourse();
    }

 //Mendapatkan objek teacher yang terkait dengan kelas dari aktivitas ini.
    public Teacher getTeacher() {
        return getClassInfo().getTeacher();
    }

//Mendapatkan ID dari aktivitas ini.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
