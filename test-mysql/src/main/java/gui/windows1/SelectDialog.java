package gui.windows1;

import bean.Student;
import impl.StudentImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

/**
 * @ClassName SelectDialog
 * @Description 查询对话框
 * @Author Huangbiao
 * @Date 2020-12-13 10:51
 * @Version V1.0
 */
public class SelectDialog extends JDialog {
    private JButton idSelectButton,nameSelectButton,deptSelectButton,allSelectButton;
    private JLabel idLabel,nameLabel,deptLabel;
    private JTextField idText,nameText,deptText;
    public static boolean status = true;
    public SelectDialog(){
        init();
    }
    private void init(){
        this.setAlwaysOnTop(true);//置顶
        this.setTitle("查找学生信息");//给顶部框加入字
        this.setLayout(null);//用户界面上的屏幕组件的格式布局
        this.setSize(580, 320);//定义这个查找弹窗的大小
        this.setLocationRelativeTo(null);//设置窗口相对于指定组件的位置，null代表的是居中
        idSelectButton = new JButton("学号查询");
        nameSelectButton = new JButton("姓名查询");
        deptSelectButton = new JButton("专业查询");
        allSelectButton = new JButton("查询所有学生");

        idSelectButton.setBounds(80, 200, 100, 30);
        nameSelectButton.setBounds(190, 200, 100, 30);
        deptSelectButton.setBounds(300, 200, 100, 30);
        allSelectButton.setBounds(410, 200, 100, 30);

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

        this.add(idSelectButton);
        this.add(nameSelectButton);
        this.add(deptSelectButton);
        this.add(allSelectButton);

        this.add(idText);
        this.add(nameText);
        this.add(deptText);

        idSelectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentImpl studentImpl = new StudentImpl();
                String id = idText.getText();
                Student student = studentImpl.findStudentId(id);
                Vector vector = new Vector();
                vector.add(0,student.getId());
                vector.add(1,student.getName());
                vector.add(2,student.getSex());
                vector.add(3,student.getAge());
                vector.add(4,student.getDept());
                TableJpanel.tableModel.addRow(vector);
                SelectDialog.status = false;
            }
        });

        nameSelectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentImpl studentImpl = new StudentImpl();
                String name = nameText.getText();
                List<Student> students = studentImpl.findStudentName(name);
                for (int i = 0; i < students.size(); i++) {
                    Student student = students.get(i);
                    Vector vector = new Vector();
                    vector.add(0,student.getId());
                    vector.add(1,student.getName());
                    vector.add(2,student.getSex());
                    vector.add(3,student.getAge());
                    vector.add(4,student.getDept());
                    TableJpanel.tableModel.addRow(vector);
                    SelectDialog.status = false;
                }
            }
        });

        deptSelectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentImpl studentImpl = new StudentImpl();
                String dept = deptText.getText();
                List<Student> students = studentImpl.findStudentDept(dept);
                for (int i = 0; i < students.size(); i++) {
                    Student student = students.get(i);
                    Vector vector = new Vector();
                    vector.add(0,student.getId());
                    vector.add(1,student.getName());
                    vector.add(2,student.getSex());
                    vector.add(3,student.getAge());
                    vector.add(4,student.getDept());
                    TableJpanel.tableModel.addRow(vector);
                    SelectDialog.status = false;
                }
            }
        });

        allSelectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentImpl studentImpl = new StudentImpl();
                List<Student> students = studentImpl.findAllStudent();
                for (int i = 0; i < students.size(); i++) {
                    Student student = students.get(i);
                    Vector vector = new Vector();
                    vector.add(0,student.getId());
                    vector.add(1,student.getName());
                    vector.add(2,student.getSex());
                    vector.add(3,student.getAge());
                    vector.add(4,student.getDept());
                    TableJpanel.tableModel.addRow(vector);
                    SelectDialog.status = false;
                }
            }
        });
        setVisible(true);
    }
}