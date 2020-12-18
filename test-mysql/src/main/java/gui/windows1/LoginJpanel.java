package gui.windows1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName LoginJpanel
 * @Description 登录界面
 * @Author Huangbiao
 * @Date 2020-12-12 22:44
 * @Version V1.0
 */
public class LoginJpanel extends JPanel{
    private JLabel user, pw;
    private JButton login, help;
    private JTextField texUser, texPw;

    public LoginJpanel(){
        init();
    }
    private void init(){

        this.setLayout(null);
        this.setSize(1000, 600);

        user = new JLabel("用户名:");
        pw = new JLabel("密码:");
        login = new JButton("登录");
        help = new JButton("帮助");
        texUser = new JTextField(10);
        texPw = new JTextField(20);

        user.setBounds(400, 150, 100, 30);
        pw.setBounds(400, 200, 100, 30);
        texUser.setBounds(450, 150,200, 30);
        texPw.setBounds(450, 200, 200, 30);
        login.setBounds(410, 250, 80, 30);
        help.setBounds(580, 250, 80, 30);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Windows1.panel.remove(0);
                Windows1.panel.add(new MenuJpanel());
                Windows1.cardLayout.next(Windows1.panel);
            }
        });
        this.add(user);
        this.add(pw);
        this.add(login);
        this.add(help);
        this.add(texUser);
        this.add(texPw);

    }
}
