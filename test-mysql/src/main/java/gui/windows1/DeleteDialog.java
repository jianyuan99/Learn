package gui.windows1;

import bean.Student;
import impl.StudentImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName DeleteDialog
 * @Description 删除弹窗
 * @Author Huangbiao
 * @Version V1.0
 */
public class DeleteDialog extends JDialog{
    private JButton idDeleteButton,nameDeleteButton,deptDeleteButton;
    private JLabel idLabel,nameLabel,deptLabel;
    private JTextField idText,nameText,deptText;
    public static boolean status = true;
    public DeleteDialog(){
        init();
    }
    private void init() {
        this.setAlwaysOnTop(true);//置顶
        this.setTitle("删除学生信息");//给顶部框加入字
        this.setLayout(null);//用户界面上的屏幕组件的格式布局
        this.setSize(580, 320);//定义这个查找弹窗的大小
        this.setLocationRelativeTo(null);//设置窗口相对于指定组件的位置，null代表的是居中
        idDeleteButton = new JButton("学号删除");
        nameDeleteButton = new JButton("姓名删除");
        deptDeleteButton = new JButton("专业删除");

        idDeleteButton.setBounds(100, 200, 100, 30);
        nameDeleteButton.setBounds(210, 200, 100, 30);
        deptDeleteButton.setBounds(320, 200, 100, 30);

        idLabel = new JLabel("学号:");
        nameLabel = new JLabel("姓名:");
        deptLabel = new JLabel("专业");

        idLabel.setBounds(30, 50, 30, 30);
        nameLabel.setBounds(200, 50, 30, 30);
        deptLabel.setBounds(370, 50, 30, 30);

        idText = new JTextField();
        nameText = new JTextField();
        deptText = new JTextField();

        idText.setBounds(80, 50, 100, 30);
        nameText.setBounds(250, 50, 100, 30);
        deptText.setBounds(420, 50, 100, 30);

        this.add(idLabel);
        this.add(nameLabel);
        this.add(deptLabel);

        this.add(idDeleteButton);
        this.add(nameDeleteButton);
        this.add(deptDeleteButton);

        this.add(idText);
        this.add(nameText);
        this.add(deptText);

        idDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idText.getText();
                new StudentImpl().delStudentId(id);
            }
        });

        nameDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                Student student = new Student();
                student.setName(name);
                new StudentImpl().delStudent(student);
            }
        });

        deptDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dept = deptText.getText();
                new StudentImpl().delStudentDept(dept);
            }
        });

        setVisible(true);
    }
}
