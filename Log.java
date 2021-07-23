import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

class Log extends JPanel implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JButton lb1, lb2;
  JTextArea ta;
  Connection con;
        
  public Log()
  {
    this.setBackground(Color.PINK);
    this.setLayout(null);

    lb1=new JButton("SHOW STOCK");
    lb1.setBounds(180,120,200,30);
    add(lb1);
    lb1.addActionListener(this);

    lb2=new JButton("LOGOUT");
    lb2.setBounds(500,120,200,30);
    add(lb2);
    lb2.addActionListener(this);
    
    
  }

  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==lb1)
    {
     ta=new JTextArea(20,10);
    ta.setBounds(50, 240, 800, 150);
    add(ta);
    ta.setBackground(Color.PINK);
      try 
      {
          Class.forName("com.mysql.cj.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","Sujitha@01");            
          Statement stmt=con.createStatement();
          ResultSet rs=stmt.executeQuery("select * from user");
          ta.append("MEDICINE\t\tCOMPANY\t\tQUANTITY\t\tPRICE\n\n");
          while(rs.next())
          {
                ta.append(rs.getString(1)+"\t\t"
                      +rs.getString(2)+"\t\t"+rs.getInt(3)+"\t\t"
                      +rs.getInt(4)+"\n");
          }
          con.close();
            
      } 
      catch (Exception ex)
      {
          System.out.println(ex);
      }  
    }
    if (e.getSource()==lb2)
    {
        System.exit(0);
    }
  }
}