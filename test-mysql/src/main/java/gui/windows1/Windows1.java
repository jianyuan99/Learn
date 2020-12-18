package gui.windows1;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName Windows1
 * @Description 显示窗口
 * @Author Huangbiao
 * @Date 2020-12-12 21:52
 * @Version V1.0
 */
public class Windows1 extends JFrame {

    //JPanel jp=new JPanel()://定义面板并初始化


    //JLabel background = new JLabel(new ImageIcon(photo/keda.jpg));
    public static CardLayout cardLayout;

    //面板组件，非顶层容器，一个界面只可以有一个JFrame窗体组件，但是可以有多个JPanel面板组件
    public static JPanel panel;


    public Windows1(String name) {
        super(name);
        // 定义卡片对象：CardLayout 布局对象名称=new CardLayout();
        cardLayout = new CardLayout();
        panel = new JPanel(cardLayout);
		/*Icon iocn=new ImageIcon("photo/keda.jpg");//定义图片并初始化，写上图片的绝对路径
		String icon = null;
		JLabel jl=new JLabel(icon);//把图片放在标签上*/

        //窗口关闭分为四种情况，默认情况下，关闭窗口，只隐藏界面，不释放占用的内存
        //这个是直接关闭应用程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //这个是主页面的大小
        this.setSize(1000, 600);

        //这个是主页面出现在屏幕上的位置，x,y定义的是左上角的那个点
        this.setLocation(250, 100);

        //加载LoginJpanel到此界面
        panel.add(new LoginJpanel());
//        panel.remove(0);
//        panel.add(new MenuJpanel());
//        JPanel panel1 = new JPanel();
//        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, new FunctionButton(), new JLabel("123456"));
//        panel1.add(jSplitPane);
//        panel.add(panel1);
        //将LoginJpanel和ManagerJpanel加入到该界面上
		/*jp.add(new LoginJPanel());
		jp.add(new ManagerJpanel());*/


        //jp.add(jl);//往面板上添加标签注意：面板JPanel不能之间添加图片iocn，icon需要放在标签JLabel上，才能在JPanel上显示


        this.add(panel);
		/*参数为boolean类型，resizeable值为true时，表示在生成的窗体可以自由改变大小；
		resizeable值为false时，表示生成的窗体大小是由程序员决定的，用户不可以自由改变*/
        this.setResizable(false);

        //显示
        this.setVisible(true);
    }
}


