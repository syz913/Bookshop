package Dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//���õ�����Ϣ��Ӧ����ȷ��

public class EnsureDialog extends JFrame{
    private int n;
	public boolean EnsureDialog(String s){      
        n = JOptionPane.showConfirmDialog(this,s,"ȷ�϶Ի���", JOptionPane.YES_NO_OPTION);
        if(n==JOptionPane.YES_OPTION){return true;}
        else if(n==JOptionPane.NO_OPTION){return false;}
		return false;
    }
    public int getN(){
        return n;
    }
}