package Dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

// ���õ�����Ϣ��Ӧ���ھ���
public class WarningDialog extends JFrame{
    public void WarningDialog(String str){
        JOptionPane.showMessageDialog(this,str, "Warning",JOptionPane.WARNING_MESSAGE);
	}
}
