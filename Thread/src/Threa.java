import java.util.concurrent.Semaphore;

public class Threa extends Thread{
    //生产产品存放位置
    public static int in=0;
    //消费产品存在的位置
    public static int out=0;
    //当前缓冲区中产品的个数
    public static int n=0;
    //生产产品的编号
    public static int numProduct=0;
    //存放生产产品的循环数组（缓冲区）
    public static int buffer[]=new int[6];
    //定义信号量
    //full表示当前缓冲区中的产品数量
    final static Semaphore full=new Semaphore(0);
    //empty表示当前缓冲区中空缓冲的数量
    final static Semaphore empty=new Semaphore(6);
    //mutex表示互斥信号量
    final static Semaphore mutex=new Semaphore(1);
}

class Product extends Threa{
    @Override
    public void run() {

        while (true) {
            try{
                Thread.sleep(3000);//定义生产者生产的速度
            }
            catch (Exception e){
                e.printStackTrace();
            }
            try{
                empty.acquire();//相当于执行wait(empty)
                mutex.acquire();
                System.out.println("生产者:");
                System.out.println("当前缓冲区中产品的个数:"+n+"存放产品的位置:"+in);

                n++;//缓冲区中产品的个数
                numProduct++;
                buffer [in]=numProduct;
                in=(in+1)%6;//实现缓冲区数组循环

                System.out.println("产品编号:"+numProduct);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                mutex.release();//相当于执行signal(mutex)
                full.release();
            }
        }
    }
}

class Consumer extends Threa{
    @Override
    public void run() {
        while (true){
            try{
                Thread.sleep(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            try{
                full.acquire();
                mutex.acquire();
                System.out.println("消费者:");
                System.out.println("当前缓冲区中产品个数:"+n+"消费产品的位置:"+out);
                System.out.println("消费产品的编号:"+buffer[out]);
                n--;
                out=(out+1)%6;
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                mutex.release();
                empty.release();
            }
        }
    }
}

class Main1{
    public static void main(String[] args){
        new Product().start();
        new Consumer().start();
    }
}