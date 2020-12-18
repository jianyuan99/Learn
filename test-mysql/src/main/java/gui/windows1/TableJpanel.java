package gui.windows1;

import bean.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @ClassName TableJpanel
 * @Description 表格
 * @Author Huangbiao
 * @Date 2020-12-13 9:26
 * @Version V1.0
 */
public class TableJpanel extends JPanel{
    private final String[] tableHEAD = {"学号","姓名","性别","年龄","专业"};
    public static DefaultTableModel tableModel;
    public static Vector vector = new Vector<>();

    private JTable table;
    private JScrollPane scrollPane;

    public TableJpanel(){
//        this.setSize(870,600);
//        this.setLayout(null);
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(tableHEAD);
//        tableModel.addRow(tableHEAD);
//        tableModel.addRow(vector);
        table = new JTable(tableModel);
        table.setDragEnabled(false);
        table.setBackground(Color.LIGHT_GRAY);
        table.setRowHeight(30);
        table.setColumnSelectionAllowed(false);
        table.setCellSelectionEnabled(false);
        table.setRowSelectionAllowed(true);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(85, 20, 700, 500);

        this.add(scrollPane);
    }
}
