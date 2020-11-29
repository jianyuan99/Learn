public class Main {
    public static void main(String[] args){

        Student student= new Student();
        student.setName("张三");
        student.start();

        Teacher teacher= new Teacher();
        teacher.setName("熊风光");
        teacher.setStudent(student);
        teacher.start();
    }
}


