package show;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.text.AbstractDocument;

public class Show {
    public Show() throws IOException {
//        CFrame cframe = new CFrame();
//        cframe.createJFrameWindows();
//        WindowMenu win = new WindowMenu("菜单窗口", 200, 300, 400, 700);
        ComponentlnWindow componentlnWindow = new ComponentlnWindow(200, 300, 550, 350);
    }
}


class CFrame extends JFrame {
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
        frame.setBounds(X_POSITION, Y_POSITION, WIDTH, HEIGHT);
        frame1.setBounds(X_POSITION + WIDTH, Y_POSITION, WIDTH, HEIGHT);
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

class WindowMenu extends JFrame {
    JMenuBar jMenuBar;
    JMenu menu, subMenu;
    JMenuItem itemLiterature, itemCooking;

    public WindowMenu() {
    }

    public WindowMenu(String s, int x, int y, int w, int h) {
        init(s);
        setLocation(x, y);
        setSize(w, h);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container container = this.getContentPane();
        container.setBackground(Color.black);
    }

    void init(String s) {

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
        subMenu.add(new JMenuItem("足球", new ImageIcon("")));
        subMenu.add(new JMenuItem("篮球", new ImageIcon("")));
        jMenuBar.add(menu);
        setJMenuBar(jMenuBar);


    }
}

class ComponentlnWindow extends JFrame {
    private JTextField text;
    private JButton button;
    private JCheckBox checkBox1, checkBox2, checkBox3;
    private JRadioButton radio1, radio2;
    private ButtonGroup group;
    private JComboBox<String> comboBox;
    private JTextArea area;
    private Container container;

    public ComponentlnWindow(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        init();
        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void init() {
        container = this.getContentPane();
        container.setBackground(Color.cyan);
        setLayout(new FlowLayout());//浮动布局
        container.add(new JLabel("文本框："));
        text = new JTextField(10);
        container.add(text);
        container.add(new JLabel("按钮"));
        button = new JButton("确定");
        container.add(button);
        container.add(new JLabel("选择框"));
        checkBox1 = new JCheckBox("喜欢音乐");
        checkBox2 = new JCheckBox("喜欢旅游");
        checkBox3 = new JCheckBox("喜欢电影");
        container.add(checkBox1);
        container.add(checkBox2);
        container.add(checkBox3);
        container.add(new JLabel("单选按钮"));
        group = new ButtonGroup();
        radio1 = new JRadioButton("男");
        radio2 = new JRadioButton("女");
        container.add(radio1);
        container.add(radio2);
        container.add(new JLabel("下拉列表"));
        comboBox = new JComboBox<String>();
        comboBox.addItem("音乐天地");
        comboBox.addItem("武术天地");
        comboBox.addItem("象棋乐园");
        container.add(comboBox);
        container.add(new JLabel("文本区:"));
        area = new JTextArea(6, 12);
        container.add(new JScrollPane(area));
        ClickAction click = new ClickAction(this.text);
        ClickAction click2 = new ClickAction(this.text,"click2");
        ClickAction click3 = new ClickAction(this.text, this.comboBox);
        button.addActionListener(click3);
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new clinkAction(text);
////                text.setText("clink this button\n"+(String)comboBox.getSelectedItem());
////                new WindowMenu("new Window", 200, 300, 400, 700);
//            }
//        });
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("窗口关闭");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });


    }

}

class ClickAction implements ActionListener{
    private JTextField textField;
    private JComboBox comboBox;
    private String text;
    public ClickAction(JTextField textField){
        this.textField = textField;
        text = textField.getText();
    }

    public ClickAction(JComboBox comboBox){
        this.comboBox = comboBox;
        text = (String) comboBox.getSelectedItem();
    }

    public ClickAction(JTextField textField,JComboBox comboBox){
        this.comboBox = comboBox;
        this.textField = textField;
        text = textField.getText() + comboBox.getSelectedItem();
    }

    public ClickAction(JTextField textField, String text){
        this.textField = textField;
        this.text = text;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(text.isEmpty()){
            text = "clink Button";
        }
        else {
            text = textField.getText() + comboBox.getSelectedItem();
        }
        textField.setText(text);
    }
}