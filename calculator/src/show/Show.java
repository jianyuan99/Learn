package show;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
public class Show {
    public Show() throws IOException {
//        CFrame cframe = new CFrame();
//        cframe.createJFrameWindows();
        WindowMenu win = new WindowMenu("菜单窗口",200,300,400,700);
    }
}


class CFrame extends JFrame{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;
    private static final int X_POSITION = 100;
    private static final int Y_POSITION = 200;

    public void createJFrameWindows() throws IOException {

        //加载窗口图标
        Image image = ImageIO.read(new File("C:/桌面.jpg"));
        //设置窗口的标题
        JFrame frame = new JFrame("测试1");
        JFrame frame1 = new JFrame("测试2");
        Container container = frame.getContentPane();
        Container container1 = frame1.getContentPane();
        //设置窗口的显示属性
        //frame.setVisible(true);
        //设置窗口初始化位置和窗口的大小
        frame.setBounds(X_POSITION,Y_POSITION,WIDTH,HEIGHT);
        frame1.setBounds(X_POSITION+WIDTH,Y_POSITION,WIDTH,HEIGHT);
        //设置窗口的背景
        container.setBackground(Color.black);
        container1.setBackground(Color.yellow);
        //设置退出按钮的点击事件为退出程序
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //设置窗口的图标为加载的图标
        frame.setIconImage(image);
        //frame.setUndecorated(true);
        frame.setVisible(true);
        frame1.setVisible(true);
    }
}

class WindowMenu extends JFrame{
    JMenuBar jMenuBar;
    JMenu menu, subMenu;
    JMenuItem itemLiterature,itemCooking;

    public WindowMenu(){}
    public WindowMenu(String s,int x,int y,int w,int h){
        init(s);
        setLocation(x,y);
        setSize(w,h);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container container = this.getContentPane();
        container.setBackground(Color.black);
    }

    void init(String s){
        setTitle(s);
        jMenuBar = new JMenuBar();
        menu = new JMenu("菜单");
        subMenu = new JMenu("谈论话题");
        itemLiterature = new JMenuItem("文学话题", new ImageIcon(""));
        itemCooking = new JMenuItem("烹饪话题", new ImageIcon(""));
        itemCooking.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        menu.add(itemLiterature);
        menu.addSeparator();
        menu.add(itemCooking);
        menu.add(subMenu);
        subMenu.add(new JMenuItem("足球",new ImageIcon("")));
        subMenu.add(new JMenuItem("篮球",new ImageIcon("")));
        jMenuBar.add(menu);
        setJMenuBar(jMenuBar);


    }
}