import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

 class Main extends JFrame
{
    
    private static final long serialVersionUID = 1L;
    JTabbedPane pane;
  JButton but;
  public Main(String title)
  {
    super(title);

    pane=new JTabbedPane(JTabbedPane.TOP);
    add(pane);
    pane.addTab("BILL GENERATION",new Bill());
    pane.addTab("ADD NEW MEDICINE STOCK",new Add());
    pane.addTab("UPDATE EXISTING STOCK",new Update());
    pane.addTab("REMOVE MEDICINE STOCK",new Remove());
    pane.addTab("LOGOUT",new Log());
  }


}
