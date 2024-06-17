import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class block extends JFrame
 {
  private JLabel title,l1;
  private JTextField t2;
  private JTextArea t1;
  private JButton b1,b2,b6;
  private JPanel p1,p2,p3;
  private Container cn;
  int f,r;

  Cursor cr=new Cursor(Cursor.HAND_CURSOR);
  Dimension screensize;
  public block()
  {
    super("WORD COUNTER");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLayout(null);
    cn=getContentPane();
    
    BevelBorder edge=new BevelBorder(BevelBorder.RAISED);
    EtchedBorder edge1=new EtchedBorder(EtchedBorder.RAISED);

    p1=new JPanel();
    p2=new JPanel();
    p3=new JPanel();

    title=new JLabel(" WORD COUNTER");
    title.setBounds(0,0,120,50);
    title.setFont(new Font("Times New Roman",Font.BOLD,35));
    title.setForeground(Color.WHITE);

    p1.add(title);
    p1.setBackground(new Color(126,3,6));
    p1.setBounds(0,0,850,50);
    cn.add(p1);

    p3.setLayout(null);
    p3.setBackground(Color.cyan);
    p3.setBackground(new Color(250,216,217));
    p3.setBounds(0,0,850,550);
    cn.add(p3);

    p3.setBorder(BorderFactory.createTitledBorder("Enter the Words"));
    
    t1=new JTextArea();
    t1.setFont(new Font("Times New Roman",1,16));
    t1.setForeground(Color.blue);
    t1.setBounds(10,50,625,430);
    p3.add(t1);
  
    b1=new JButton("Count");
    p3.add(b1);
    b1.setToolTipText("Count the Words");
    b1.setBounds(650,80,120,25);
    b1.addActionListener(new addListener());   
    b1.setMnemonic('N');
    
    b2=new JButton("Reset");
    p3.add(b2);
    b2.setToolTipText("Clear the text area");
    b2.setMnemonic('S');
    b2.addActionListener(new deleteListener());
    b2.setBounds(650,120,120,25);
    
    
    b6=new JButton("Exit");
    p3.add(b6);
    b6.setBounds(650,160,120,25);
    b6.setToolTipText("Exit");
    b6.setMnemonic('X');
    b6.addActionListener(new exitListener());
    
    l1=new JLabel("No. of Words :");
    l1.setFont(new Font("Times New Roman",1,14));
    l1.setForeground(Color.blue);
    l1.setBounds(650,320,120,30);
    p3.add(l1);
    
    t2=new JTextField();
    t2.setFont(new Font("Times New Roman",1,14));
    t2.setForeground(Color.black);
    t2.setBounds(650,360,120,30);
    t2.setEditable(false);   
    p3.add(t2);

    
    b1.setCursor(cr);
    b6.setCursor(cr);
    l1.setBorder(edge);
    t1.setBorder(edge1);
    t2.setBorder(edge1);
    

    JLabel ln=new JLabel();
     ln.setForeground(new Color(190,91,14));
        ln.setText("===================================================================================================================================================================================================================================================================================================================================================================");
        p3.add(ln);
        ln.setBounds(0,490,800,16);

        JLabel bt1=new JLabel();
        bt1.setForeground(new Color(177,20,170));
        bt1.setText("DEVELOPED BY  :-");
        p3.add(bt1);
        bt1.setBounds(300,502,120,15);

       JLabel bt2=new JLabel();
        bt2.setForeground(new Color(149,21,21));
        bt2.setText("Rohit Kumar");
        p3.add(bt2);
        bt2.setBounds(425,502,300,15);

    pack();
    setSize(800,600);
    screensize=Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screensize.width-800)/2,(screensize.height-600)/2,800,600);
    setVisible(true);
    setResizable(false);

  }

   protected void processWindowEvent(WindowEvent we)
   {
     if(we.getID() == we.WINDOW_CLOSING)
     {
       r=JOptionPane.showConfirmDialog(null,"Do you want to Exit?","Enter Carefully",JOptionPane.WARNING_MESSAGE);
       if(r==JOptionPane.YES_OPTION)
         dispose();
      }
   }
		 
	
      private class deleteListener implements ActionListener
        {
                public void actionPerformed(ActionEvent e)
                {
                  try
                        {                     
                      t1.setText("");  
                      t2.setText("");  
                      
                      }
                        catch(Exception ex)
                        {
                          System.out.println(ex);
                        }
                }
        }
		
		private class addListener implements ActionListener
        {
                public void actionPerformed(ActionEvent e)
                {
                  clear();
                }
        }
		
		public void clear()
        {
         try
         { 		 
        String text = t1.getText();
        int wordCount = countWords(text);       
        t2.setText(Integer.toString(wordCount));   
      }
		 catch(Exception e)
           {
            System.out.println(e);
           } }
           public static int countWords(String text) {
            if (text == null || text.isEmpty()) {
                return 0;
            }
            String[] words = text.split("\\s+");
            return words.length;
        
      }

private class exitListener implements ActionListener
        {
                public void actionPerformed(ActionEvent e)
                {
                        r=JOptionPane.showConfirmDialog(null,"Do you want to exit?","Enter Carefully",JOptionPane.WARNING_MESSAGE);
                        if(r==JOptionPane.YES_OPTION)
                        dispose();
                }
       }
   public static void main(String args[])
  {
       block bl= new block();
  } 

}