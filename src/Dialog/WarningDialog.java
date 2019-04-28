package Dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

// 设置弹出消息框，应用于警告
public class WarningDialog extends JFrame{
    public void WarningDialog(String str){
        JOptionPane.showMessageDialog(this,str, "Warning",JOptionPane.WARNING_MESSAGE);
	}
}
