package gui.windows1;

import bean.Student;
import impl.StudentImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName InsertDialog
 * @Description 插入弹窗
 * @Author Huangbiao
 * @Version V1.0
 */
public class InsertDialog extends JDialog{
    private JButton insertButton;
    private JLabel idLabel,nameLabel,deptLabel,sexLabel,ageLabel;
    private JTextField idText,nameText,deptText,sexText,ageText;
    public static boolean status = true;
    public InsertDialog(){
        init();
    }
    private void init() {
        this.setAlwaysOnTop(true);//置顶
        this.setTitle("插入学生信息");//给顶部框加入字
        this.setLayout(null);//用户界面上的屏幕组件的格式布局
        this.setSize(580, 320);//定义这个查找弹窗的大小
        this.setLocationRelativeTo(null);//设置窗口相对于指定组件的位置，null代表的是居中
        insertButton = new JButton("插入");
        insertButton.setBounds(200, 200, 100, 30);


        idLabel = new JLabel("学号:");
        nameLabel = new JLabel("姓名:");
        deptLabel = new JLabel("专业");
        sexLabel = new JLabel("性别");
        ageLabel = new JLabel("年龄");

        idLabel.setBounds(30, 50, 30, 30);
        nameLabel.setBounds(200, 50, 30, 30);
        deptLabel.setBounds(370, 50, 30, 30);
        sexLabel.setBounds(30, 90, 30, 30);
        ageLabel.setBounds(200, 90, 30, 30);

        idText = new JTextField();
        nameText = new JTextField();
        deptText = new JTextField();
        sexText = new JTextField();
        ageText = new JTextField();

        idText.setBounds(80, 50, 100, 30);
        nameText.setBounds(250, 50, 100, 30);
        deptText.setBounds(420, 50, 100, 30);
        sexText.setBounds(80, 90, 100, 30);
        ageText.setBounds(250, 90, 100, 30);

        this.add(idLabel);
        this.add(nameLabel);
        this.add(deptLabel);

        this.add(insertButton);

        this.add(idText);
        this.add(nameText);
        this.add(deptText);
        this.add(sexLabel);
        this.add(ageLabel);
        this.add(sexText);
        this.add(ageText);
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idText.getText();
                String name = nameText.getText();
                String sex = sexText.getText();
                String age = ageText.getText();
                String dept = deptText.getText();
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setSex(sex);
                student.setAge(age);
                student.setDept(dept);
                StudentImpl studentImpl = new StudentImpl();
                studentImpl.insert(student);
            }
        });

        setVisible(true);

    }
}
