package gui.windows1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * @ClassName FunctionButton
 * @Description 功能按钮
 * @Author Huangbiao
 * @Date 2020-12-13 0:53
 * @Version V1.0
 */
public class FunctionButton extends JPanel{
    private JButton findButton, deleteButton, insertButton, updateButton;
    public FunctionButton(){
        init();
    }

    private void init(){
        this.setLayout(null);
        findButton = new JButton("查询");
        deleteButton = new JButton("删除");
        insertButton = new JButton("插入");
        updateButton = new JButton("更新");

        findButton.setBounds(20, 50, 100, 30);
        deleteButton.setBounds(20, 100, 100, 30);
        insertButton.setBounds(20, 150, 100, 30);
        updateButton.setBounds(20, 200, 100, 30);

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new SelectDialog();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteDialog();
            }
        });

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InsertDialog();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateDialog();
            }
        });
        this.add(findButton);
        this.add(deleteButton);
        this.add(insertButton);
        this.add(updateButton);
        this.setSize(130, 600);

    }
}
