package replacement;
import Page.*;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PageReplacement {
    Page[] page;
    int n;//定义系统分配的物理块数量
    //int[] block;//定义物理块空间
    int numAt;//定义当前物理块中存在的页面数量
    int now;//定义当前指向挡墙置换的物理块位置
    int cnt;//记录页面置换次数
    int cntR;//记录页面访问总次数
    int flag;
    Deque<Integer> deque = new LinkedList<>();
    ArrayList <Page> block = new ArrayList<>();
    public PageReplacement(Page[] pages, int n){
        this.page = pages;
        this.n = n;
       // block = new int[n];
        numAt = 0;
        now = 0;
    }

    private void print(){
        if(numAt<n){
            for(int i=0;i<numAt;i++){
                System.out.print(block.get(i).getNumPage()+" ");
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                System.out.print(block.get(i).getNumPage()+" ");
            }
        }
        System.out.println();
    }

    private boolean findPage(int p){
        for (int i = 0; i < n; i++) {
            if (block.get(i).getNumPage() == p) {
                flag = i;
                return true;
            }
        }
        return false;
    }

    private void findPageOpt(Page page,int p){
        int t = n;
        page.setTemp(this.page.length+1);
        for(int i = p; i<this.page.length;i++){
            if(this.page[i].getNumPage()==page.getNumPage()){
                page.setTemp(i);
                break;
            }
        }
        if(numAt<n){
            t = numAt;
        }
        for(int i=0;i<t;i++){
            if(block.get(i).getTemp()>block.get(now).getTemp()){
                now = i;
            }
        }
    }

    private void findPageLru(Page page,int time){
        int t = n;
        if(numAt<n){
            t = numAt;
        }
        page.setTemp(time);
        for(int i=0;i<t;i++){
            if((time-block.get(i).getTemp())>(time-block.get(now).getTemp())){
                now = i;
            }
        }
    }

    public boolean Fifo(){
        for(int i=0; i< page.length;i++){
            if(numAt<n){
                block.add(numAt,page[i]);
                numAt++;
                cntR++;
                cnt++;
                now = numAt;
            }
            else{
                if(findPage(page[i].getNumPage())){
                    cntR++;
                    //System.out.println(block);
                    continue;

                }
                else{
                    block.remove(0);
                    block.add(page[i]);
                    cnt++;
                    cntR++;
                }
            }
            print();
        }
        System.out.println("缺页中断次数："+cnt);
        System.out.println("缺页率："+(1.0*cnt/cntR));
        return false;
    }

    public boolean Opt(){
        for(int i=0;i< page.length;i++){
            if(numAt<n){
                block.add(page[i]);
                numAt++;
                findPageOpt(page[i],numAt);
                cnt++;
                cntR++;
            }
            else{
                if(findPage(page[i].getNumPage())){
                    cntR++;
                    findPageOpt(block.get(flag), cntR);
                    print();
                    continue;
                }
                else{
                    block.set(now,page[i]);
                    findPageOpt(page[i],cntR+1);
                    cnt++;
                    cntR++;
                }
            }
            print();
        }
        System.out.println("缺页中断次数："+cnt);
        System.out.println("缺页率："+(1.0*cnt/cntR));
        return false;
    }

    public boolean Lru() {
        for (int i = 0; i < page.length; i++) {
            if (numAt < n) {
                block.add(page[i]);
                findPageLru(page[i], numAt);
                numAt++;
                cnt++;
                cntR++;
            } else {
                if (findPage(page[i].getNumPage())) {
                    findPageLru(block.get(flag), cntR);
                    cntR++;
                    print();
                    continue;
                } else {
                    block.set(now, page[i]);
                    findPageLru(page[i], cntR);
                    cntR++;
                    cnt++;
                }
            }

            print();
        }
        System.out.println("缺页中断次数："+cnt);
        System.out.println("缺页率："+(1.0*cnt/cntR));
        return false;
    }
}
