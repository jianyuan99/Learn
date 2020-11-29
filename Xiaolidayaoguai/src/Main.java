import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Human  xiaoli = new Human("xiaoli");
        Monstersc yaoguai = new Monstersc("yaoguai", 1000, true);
        Arms[] arms = new Arms[3];
        arms[0] = new Arms("木剑",20);
        arms[1] = new Arms("铁剑", 50);
        arms[2] = new Arms("魔剑", 100);

        Scanner in = new Scanner(System.in);

        System.out.println("小李打妖怪\n");
        System.out.println("输入9开始游戏");
        System.out.println("输入0结束游戏");
        System.out.println("输入0选择木剑攻击");
        System.out.println("输入1选择铁剑攻击");
        System.out.println("输入2选择魔剑攻击");

        int flag = in.nextInt();
        while (flag!=9){
            System.out.println("小李打妖怪\n");
            System.out.println("输入9开始游戏");
            System.out.println("输入8结束游戏");
            System.out.println("输入0选择木剑攻击");
            System.out.println("输入1选择铁剑攻击");
            System.out.println("输入2选择魔剑攻击");
            flag = in.nextInt();
        }
        if(flag==9){
            System.out.println("游戏开始！");
            int op = in.nextInt();
            boolean t = yaoguai.isExist();

            while(op!=8&&t){
                if(!xiaoli.attack(yaoguai,arms[op])){
                    break;
                }
                op = in.nextInt();
                t = yaoguai.isExist();
            }
        }

    }
}


class Monstersc{
    private String name;
    private int healthPoint;
    private boolean exist;

    public Monstersc(String name, int healthPoint , boolean exist ){
        this.name = name;
        this.healthPoint = healthPoint;
        this.exist = exist;
    }

    public  Monstersc(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public boolean attacked(int damageValue){
        healthPoint -= damageValue;
        if(healthPoint < 0){
            System.out.println("怪物已死亡！");
            System.out.println("游戏结束");
            return false;
        }
        return true;
    }

}

class Human{
    private String name;

    public Human(String nanme){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean attack(Monstersc monstersc, Arms arms){
        System.out.println(arms.getName()+"攻击!");
        boolean s = monstersc.attacked(arms.getDamageValue());
        System.out.println("怪物剩余血量："+ monstersc.getHealthPoint());
        return s;
    }
}

class Arms{
    private String name;
    private int damageValue;

    public Arms(String name, int damageValue){
        this.name = name;
        this.damageValue = damageValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamageValue() {
        return damageValue;
    }

    public void setDamageValue(int damageValue) {
        this.damageValue = damageValue;
    }

}