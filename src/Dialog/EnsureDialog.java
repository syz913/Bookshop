package Dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//设置弹出消息框，应用于确认

public class EnsureDialog extends JFrame{
    private int n;
	public boolean EnsureDialog(String s){      
        n = JOptionPane.showConfirmDialog(this,s,"确认对话框", JOptionPane.YES_NO_OPTION);
        if(n==JOptionPane.YES_OPTION){return true;}
        else if(n==JOptionPane.NO_OPTION){return false;}
		return false;
    }
    public int getN(){
        return n;
    }
}