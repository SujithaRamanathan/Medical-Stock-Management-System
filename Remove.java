import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

class Remove extends JPanel implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JLabel rl1;
  JTextField rtf1;
  JButton rb;
  Connection con;
  String med;
  public Remove()
  {
    this.setBackground(Color.PINK);
    this.setLayout(null);

    rl1=new JLabel("Enter Medicine to Remove Stock");
    rl1.setBounds(180,120,200,30);
    add(rl1);

    rtf1=new JTextField();
    rtf1.setBounds(500,120,150,30);
    add(rtf1);

    rb=new JButton("REMOVE");
    rb.setBounds(320,220,200,30);
    add(rb);
    rb.addActionListener(this);
  }

    public void actionPerformed(ActionEvent e) 
    {
       med=rtf1.getText();
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","Sujitha@01");            
            PreparedStatement pstmt=con.prepareStatement("delete from user where name=?");
            pstmt.setString(1, med);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Stock removed successfully");
        } 
        catch (Exception ex) 
        {
            System.out.println("ex");
        }
    }
}