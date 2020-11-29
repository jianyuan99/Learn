package Page;

public class Page {
    private int numPage;//页号
    private boolean pPage;//存在状态
    private int temp;
    public Page(int num){
        numPage = num;
        pPage = false;
    }

    public int getNumPage() {
        return numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }

    public boolean ispPage() {
        return pPage;
    }

    public void setpPage(boolean pPage) {
        this.pPage = pPage;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
