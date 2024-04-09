package aop;

public class Student {
    private String nameSurname;
    private int course;
    private double avgGarde;

    public Student(String nameSurname, int course, double avgGarde) {
        this.nameSurname = nameSurname;
        this.course = course;
        this.avgGarde = avgGarde;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGarde() {
        return avgGarde;
    }

    public void setAvgGarde(double avgGarde) {
        this.avgGarde = avgGarde;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nameSurname='" + nameSurname + '\'' +
                ", course=" + course +
                ", avgGarde=" + avgGarde +
                '}';
    }
}
