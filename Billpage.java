import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

class Billpage extends JFrame implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JButton back;
    JTextArea text;
    JPanel p;
    String med;
   
    public Billpage(String title)
    {
        super(title);
        
        back=new JButton("BACK");
        back.setBounds(10, 10, 80, 25);
        add(back);
        back.addActionListener(this);
        
        p=new JPanel();
        add(p);
        p.setBackground(Color.cyan);
        
        text=new JTextArea(40,40);
        text.setBounds(50, 50, 10,10);
        p.add(text);
        text.setBackground(Color.cyan);     
    }
    
    public void billdisplay(String med,int qty, int price)
    {
        int totrs=qty*price;
        this.med=med;
        String q=Integer.toString(qty);
        String pr=Integer.toString(price);
        
        text.append("\n\n\n\n\t\tBILL\n\n\n");
        text.append("\tMEDICINE\t\t"+med+"\n\n");
        text.append("\tQUANTITY\t\t"+q+"\n\n");
        text.append("\tPRICE PER PIECE\t"+pr+"\n\n");
        text.append("\tTOTAL PRICE\t\t"+totrs+"\n\n");
    }
 
    public void actionPerformed(ActionEvent e) 
    {
        this.dispose();
    }
}
