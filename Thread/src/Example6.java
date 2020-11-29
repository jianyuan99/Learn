import javax.swing.plaf.SplitPaneUI;

public class Example6 {
    public static void main(String[] args){
        P p = new P();
        Leftthread leftthread = new Leftthread(p);
        Rightthread rightthread = new Rightthread(p);

        leftthread.start();
        rightthread.start();
    }
}


class P{
    Integer integer= new Integer(1);

    void print(){
        synchronized(integer) {
            for (int i = 1; i <= 500; i++) {
                System.out.println("我是线程" + i);
            }
        }
            for(int i=1;i<=600;i++){
                System.out.println("我是a线程"+i);
            }

    }
}


class Leftthread extends Thread{
    private P p;
    public Leftthread(P p){
        this.p=p;
    }

    public void run(){
        p.print();
    }
}

class Rightthread extends Thread{
    private P p;

    public Rightthread(P p){
        this.p=p;
    }

    public void run(){
        p.print();
    }
}