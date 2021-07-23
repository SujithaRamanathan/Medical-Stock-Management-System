import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


class Bill extends JPanel implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // JPanel p1;
  JLabel bl1,bl2;
  JTextField btf1,btf2;
  JButton bb;
  Connection con;
  String med;
  int qty,price;
    
  
  public Bill()
  {
    this.setBackground(Color.PINK);
    this.setLayout(null);

    bl1=new JLabel("Enter Medicine");
    bl1.setBounds(200,100,100,30);
    add(bl1);

    btf1=new JTextField();
    btf1.setBounds(450,100,150,30);
    add(btf1);

    bl2=new JLabel("Enter Quantity");
    bl2.setBounds(200,200,100,30);
    add(bl2);

    btf2=new JTextField();
    btf2.setBounds(450,200,150,30);
    add(btf2);

    bb=new JButton("GENERATE BILL");
    bb.setBounds(280,300,200,30);
    add(bb);
    bb.addActionListener(this);
    
  }

    public void actionPerformed(ActionEvent e) 
    {
        med=btf1.getText();
        qty=Integer.parseInt(btf2.getText());
        
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","Sujitha@01");            
            PreparedStatement pstmt=con.prepareStatement("update user set quantity=quantity-? where name=?");
            pstmt.setInt(1,qty);
            pstmt.setString(2,med);
            pstmt.executeUpdate();
            PreparedStatement stmt=con.prepareStatement("select price from user where name=?");
            stmt.setString(1, med);
            ResultSet rs=stmt.executeQuery();
            while(rs.next())
                price=rs.getInt("price");
         
            JOptionPane.showMessageDialog(null,"Bill generated");
            
            Billpage bp=new Billpage("Bill"); 
            bp.setVisible(true);
            bp.setSize(400, 400);
            bp.setDefaultCloseOperation(EXIT_ON_CLOSE);
            bp.setLocationRelativeTo(null);
            bp.setResizable(false);
            
            bp.billdisplay(med, qty,price);
        } 
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
}
