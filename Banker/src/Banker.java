
import java.util.Scanner;

/**
 * @author huangbiao
 */

class Resources{
    private int[] available;
    private String[] nameResources;
    public static int nResources;

    public Resources(String[] name){
        nameResources=new String[name.length];
        nResources+=name.length;
        available=new int[name.length];

        Scanner in=new Scanner(System.in);
        for(int i=0;i<name.length;i++){
            nameResources[i]=name[i];
            System.out.println("请输入"+name[i]+"资源数量:");
            available[i]=in.nextInt();
        }
        System.out.println("资源初始化完成");
    }

    public int[] getAvailable() {
        return available;
    }

    public void setAvailable(int[] a) {
       for(int i=0;i<a.length;i++){
           available[i]-=a[i];
       }
    }

    public void resourcesInfo(){
        System.out.println("当前系统可用资源：");
        for(int i=0;i<nResources;i++){
            System.out.format("资源名: %5s 资源数量:%5d\n",nameResources[i],available[i]);
        }
    }
}

class Process{
    //记录进程的名字
    public String nameProcess;
    //最大资源需求
    private int[] maxProcess;
    //当前进程获得资源数
    private int[] allocation;
    //当前资源尚需资源数
    private int[] needs;

    public Process(String name,int[]max,int[] allo){
        nameProcess=name;

        maxProcess=new int[max.length];
        for(int i=0;i<max.length;i++){
            maxProcess[i]=max[i];
        }

        allocation=new int[allo.length];
        for(int i=0;i<allo.length;i++){
            allocation[i]=allo[i];
        }

        this.needs=new int[max.length];
        for(int i=0;i<max.length;i++){
            this.needs[i]=max[i]-allo[i];
        }
        System.out.println(nameProcess+"进程初始化完成!");
    }
    private boolean isSafe(Process[] pr,int[] available){
        System.out.println("进入系统安全检...");
        boolean safe=true;
        int[] temp=(int[])available.clone();
        int n=pr.length;
        int[] flag =new int[pr.length];//记录选中进程
        int s=0;
        for(int i=0;i<pr.length;i++){
            flag[i]=-1;
        }
        while((n--)!=0) {

            for (int i = 0; i < pr.length; i++) {
                int j = 0;
                int flag_t=0;
                for(int c=0;c< pr.length;c++){
                    if(flag[c]==i){
                        flag_t=1;
                        break;
                    }
                }
                if(flag_t==1){
                    continue;
                }
                for (; j < available.length; ) {
                    if (pr[i].needs[j] > temp[j]) {
                        break;
                    } else {
                        j++;
                    }
                }
                if (j == available.length) {
                    flag[s] = i;
                    s++;
                    break;
                }
            }
            if(s!=0&&flag[s-1]!=-1) {
                System.out.format("进程： %5s work[ ",pr[flag[s-1]].nameProcess);
                for(int i=0;i<available.length;i++){
                    System.out.format("%5d",temp[i]);
                }
                System.out.format("     ] need[ ");
                for(int i=0;i<available.length;i++){
                    System.out.format("%5d",pr[flag[s-1]].needs[i]);
                }
                System.out.format("     ] allo[ ");
                for(int i=0;i<available.length;i++){
                    System.out.format("%5d",pr[flag[s-1]].allocation[i]);
                }
                System.out.format("     ] work+allo[");
                for (int i = 0; i < available.length; i++) {
                    temp[i] += pr[flag[s-1]].allocation[i];
                    System.out.format("%5d",temp[i]);
                }
                System.out.format("     ]\n");
            }
            else{
                safe=false;
                break;
            }
        }
        System.out.println("银行家安全算法检测完成！");
        return safe;
    }

    public  boolean request(int[] req,int[] available,Process[] pr){
        for(int i=0;i<req.length;i++){
            if(req[i]>needs[i]){
            System.out.println("ERROR: 当前请求分配资源超出该进程的需求!");
                return false;
            }
            else if(req[i]>available[i]){
                System.out.println("ERROR: 当前请求分配资源超出可用资源!");
                return false;
            }
        }
        for(int i=0;i<req.length;i++){
            allocation[i]+=req[i];
            needs[i]-=req[i];
            available[i]-=req[i];
        }
        if(isSafe(pr,available)){
            System.out.println("资源分配成功!");
            return true;
        }
        else{
            System.out.println("资源分配失败，安全检查算法未通过！");
            for(int i=0;i<req.length;i++){
                allocation[i]-=req[i];
                needs[i]+=req[i];
                available[i]+=req[i];

            }
            return false;
        }
    }
    public void processInfo(){

        System.out.format("进程名: %5s ",nameProcess);
        System.out.format("max[ ");
        for(int i=0;i<maxProcess.length;i++){
            System.out.format(" %5d",maxProcess[i]);
        }
        System.out.format("     ] allo[ ");
        for(int i=0;i<maxProcess.length;i++){
            System.out.format(" %5d",allocation[i]);
        }
        System.out.format("     ] needs[ ");
        for(int i=0;i<maxProcess.length;i++){
            System.out.format(" %5d",needs[i]);
        }
        System.out.format("     ]");
        System.out.println("");
    }

}
/**
 * @author huangbiao
 */
public class Banker {
    static void init(){
        System.out.println("系统初始化：");
        String[] nameR={"A","B","C"};
        int n;
        System.out.println("请输入资源种类数量：");
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        nameR=new String[n];
        System.out.println("请输入资源名称:");
        for(int i=0;i<n;i++){
            nameR[i]=in.next();
        }
        Resources resources=new Resources(nameR);

        String nameP;
        int nP;
        int[] max=new int[n];
        int[] allo=new int[n];

        System.out.println("请输入进程数:");
        nP=in.nextInt();

        Process[] process=new Process[nP];
        for(int i=0;i<nP;i++){
            System.out.println("请输入进程名称:");
            nameP= in.next();
            System.out.println("请输入进程最大资源需求:");
            for(int j=0;j<n;j++){
                max[j]=in.nextInt();
            }
            System.out.println("请输入该进程获得资源数:");
            for(int j=0;j<n;j++){
                allo[j]=in.nextInt();
            }
            process[i]=new Process(nameP,max,allo);
        }

        resources.resourcesInfo();

        System.out.println("");
        System.out.println("当前系统线程资源分配情况：");
        for(int i=0;i<nP;i++){
            process[i].processInfo();
        }
        System.out.println("");

        while(true) {
            System.out.println("请输入资源请求进程名：");
            String name = in.next();
            if(name=="0"){break;}
            int p=0;
            for(int i=0;i<process.length;i++){
                if(process[i].nameProcess.equals(name)){
                    p=i;
                    break;
                }
            }
            System.out.println("请输入申请资源序列(负值为释放资源)：");

            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=in.nextInt();
            }
            System.out.println("");
            boolean b= process[p].request(a, resources.getAvailable(), process);
            System.out.println("");

            resources.resourcesInfo();

            System.out.println("");
            System.out.println("当前系统线程资源分配情况：");
            for (int i = 0; i < nP; i++) {
                process[i].processInfo();
            }
            System.out.println("");
        }
    }
    public static void main(String[] args){
        init();
    }
}