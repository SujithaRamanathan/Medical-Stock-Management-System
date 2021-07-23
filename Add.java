import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

class Add extends JPanel implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JLabel al1, al2, al3, al4;
  JTextField atf1,atf2,atf3,atf4;
  JButton ab;
  String mname,comp;
  int quan,pr;
  Connection con;
  public Add()
  {
    this.setBackground(Color.PINK);
    this.setLayout(null);

    al1=new JLabel("Enter Medicine");
    al1.setBounds(200,70,100,30);
    add(al1);

    atf1=new JTextField();
    atf1.setBounds(500,70,150,30);
    add(atf1);

    al2=new JLabel("Enter Company Name");
    al2.setBounds(200,150,150,30);
    add(al2);

    atf2=new JTextField();
    atf2.setBounds(500,150,150,30);
    add(atf2);

    al3=new JLabel("Enter Quantity");
    al3.setBounds(200,230,100,30);
    add(al3);

    atf3=new JTextField();
    atf3.setBounds(500,230,150,30);
    add(atf3);
    
    al4=new JLabel("Enter Price");
    al4.setBounds(200,310,100,30);
    add(al4);
    
    atf4=new JTextField();
    atf4.setBounds(500,310,150,30);
    add(atf4);

    ab=new JButton("ADD");
    ab.setBounds(310,390,200,30);
    add(ab);
    ab.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) 
  {
      mname=atf1.getText();
      comp=atf2.getText();
      quan=Integer.parseInt(atf3.getText());
      pr=Integer.parseInt(atf4.getText());
      
      try
      {
        Class.forName("com.mysql.cj.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","Sujitha@01");            
        PreparedStatement pstmt=con.prepareStatement("insert into user(name,company,quantity,price) "
                + "values(?,?,?,?)");
        pstmt.setString(1,mname);
        pstmt.setString(2, comp);
        pstmt.setInt(3,quan);
        pstmt.setInt(4,pr);
        pstmt.executeUpdate();
        JOptionPane.showMessageDialog(null,"New stock inserted successfully");
        con.close();
      }
      catch(Exception ex)
      {
        System.out.println(ex);
      }
  }

}
