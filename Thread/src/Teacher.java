public class Teacher extends Thread{
    private Student student;

    public Teacher(){}

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher(Student student){
        this.student=student;
    }

    public void run(){
        try{
            Thread.sleep(500);
            System.out.println(this.getName()+"老师很生气！");
            for(int i=0;i<3;i++){
                System.out.println(student.getName()+"同学，请不要睡觉！");
            }
            student.interrupt();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
