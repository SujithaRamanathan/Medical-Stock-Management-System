import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

class Update extends JPanel implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JLabel ul1, ul2;
  JTextField utf1,utf2;
  JButton ub;
  Connection con;
  String med;
  int qty;
  public Update()
  {
    this.setBackground(Color.PINK);
    this.setLayout(null);

    ul1=new JLabel("Enter Medicine to Update");
    ul1.setBounds(200,100,150,30);
    add(ul1);

    utf1=new JTextField();
    utf1.setBounds(500,100,150,30);
    add(utf1);

    ul2=new JLabel("Enter Quantity to Update");
    ul2.setBounds(200,200,150,30);
    add(ul2);

    utf2=new JTextField();
    utf2.setBounds(500,200,150,30);
    add(utf2);

    ub=new JButton("UPDATE");
    ub.setBounds(310,300,200,30);
    add(ub);
    ub.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) 
  {
    med=utf1.getText();
    qty=Integer.parseInt(utf2.getText());
    try 
    {
       Class.forName("com.mysql.cj.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","Sujitha@01");            
       PreparedStatement pstmt=con.prepareStatement("update user set quantity=quantity+? where name=?");
       pstmt.setInt(1, qty);
       pstmt.setString(2, med);
       pstmt.executeUpdate();
       JOptionPane.showMessageDialog(null,"Stock Updated Successfully");
    } 
    catch (Exception ex) 
    {
        System.out.println("ex");
    }
  }
}
