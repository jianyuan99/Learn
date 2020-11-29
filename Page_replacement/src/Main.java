import Page.Page;
import replacement.PageReplacement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int n;//定义分配的物理块数
        int nPage = 0;//定义待分配页面的数量
        int op;//定义选择的页面置换算法，1为OPT，2为FIFO,3为LRU
        Scanner in = new Scanner(System.in);
        System.out.println("请输入分配物理块数:");
        n = in.nextInt();
        System.out.println("请输入待分配页面数:");
        nPage = in.nextInt();
        System.out.println("初始化页面信息！");
        System.out.println("请输入页面号串：");
        Page[] page = new Page[nPage];
        for(int i=0;i<nPage;i++){
            page[i] = new Page(in.nextInt());
        }
        System.out.println("初始化成功！");

        while (true){
            System.out.println("请输入选择的页面置换算法法");
            op = in.nextInt();
            if(op==1){
                new PageReplacement(page,n).Opt();
            }
            else if(op==2){
                new PageReplacement(page,n).Fifo();
            }
            else if(op==3){
                new PageReplacement(page,n).Lru();
            }
            else if(op==0){
                break;
            }
        }
    }
}
