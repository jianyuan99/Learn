package gui.windows1;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * @ClassName MenuJpanel
 * @Description 主功能菜单界面
 * @Author Huangbiao
 * @Date 2020-12-12 23:47
 * @Version V1.0
 */
public class MenuJpanel extends JPanel{
    public MenuJpanel(){
       this.setSize(1000,600);
       JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
       jSplitPane.setLeftComponent(new FunctionButton());
       jSplitPane.setRightComponent(new TableJpanel());
       jSplitPane.setDividerLocation(150);
       jSplitPane.setDividerSize(1);
       jSplitPane.setName("jsp");
       jSplitPane.setBounds(0,0,1000,600);
       this.setLayout(null);
       this.add(jSplitPane);
    }

}
