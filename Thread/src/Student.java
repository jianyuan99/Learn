public class Student extends Thread{

    public void run(){
        try{
            System.out.println(this.getName()+"同学要睡觉");
            Thread.sleep(1000*60*60);
        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println(this.getName()+"同学被吵醒！");
        }
    }
}
