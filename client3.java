import java.awt.*;
import java.awt.event.*;
import java.security.PublicKey;
import javax.swing.*;
import javax.swing.event.*;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import jdk.internal.dynalink.beans.StaticClass;

 import java.io.BufferedReader;
 import java.io.DataOutputStream;
 import java.io.InputStreamReader;
 import java.net.HttpURLConnection;
 import java.net.URL;
 import javax.net.ssl.HttpsURLConnection;
 
 import sun.net.util.IPAddressUtil;
 
public class VPN extends JComponent implements ActionListener
{
public JCheckBox check;
public JButton but1;
public JButton but2;
public JButton but3;
public JButton but4;
public JButton but5;
public JPanel panel1;
public JPanel panel2;
public JPanel panel3;
public JPanel panel4;
public JTextField text1;
public JTextField text2;
public JPasswordField pass2;
public JComboBox com;
public JComboBox box;
public JLabel label1;
public JLabel label2;
public JLabel label3;
public JLabel label4;
public JLabel label5;
public JLabel label6;
public JList list;
public JScrollPane scroll;
private String [] names = {"FREE SERVER", "UNITED STATES","GERMANY","NETHERLANDS","SINGAPORE"};
private String [] tweaks = {"MTN", "GLO", "ETISALAT", "AIRTEL"};
public static DefaultListModel dlm = new DefaultListModel();
//Main program
public static void main(String[] args)
{
    //Draw the main window
JFrame window = new JFrame();
VPN items = new VPN();
window.add(items);
window.setLocation(400,200);
window.setTitle("EliteVPN v1.0");
window.setSize(500,500);
window.setResizable(false);
window.setVisible(true);
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.getContentPane().setBackground(new Color(216,191,216));
}
 
    public VPN(){
    //Specify the values and properties of the various controls and add to JFrame
    panel1 = new JPanel();
    label1 = new JLabel("Username");
    text1 = new JTextField("",15);
    label3 = new JLabel("Server");
    label6 = new JLabel ("Tweak");
    label2 = new JLabel("Password");
    com = new JComboBox(names);
    box = new JComboBox(tweaks);
    pass2 = new JPasswordField("",15);
    label1.setBounds(20,20,90,20);
    text1.setBounds(100,20,160,20);
    label2.setBounds(20,60,90,20);
    pass2.setBounds(100,60,160,20);
    label3.setBounds(20,100,90,20);
    com.setBounds(100,100,130,20);
    label6.setBounds(20,125,130,20);
    box.setBounds(100,125,130,20);
    panel1.add(label1);
    panel1.add(text1);
    panel1.add(label2);
    panel1.add(pass2);
    panel1.add(label3);
    panel1.add(com);
    panel1.add(label6);
    panel1.add(box);
    panel1.setLayout(null);
    panel1.setBorder(BorderFactory.createTitledBorder("Login"));
    panel1.setBackground(Color.blue);
    panel1.setBounds(0,0,280,150);
    add(panel1);
 
    panel2 = new JPanel();
    label4 = new JLabel("HTTPS(S) Listen Port");
    label4.setBounds(20,20,120,20);
    text2 = new JTextField("",15);
    text2.setBounds(165,20,95,20);
    panel2.setBorder(BorderFactory.createTitledBorder("HTTP(S) Listen Port"));
    panel2.setLayout(null);
    panel2.setBounds(0,160,280,50);
    panel2.setBackground(Color.blue);
    panel2.add(label4);
    panel2.add(text2);
    add(panel2);
 
    panel3 = new JPanel();
    check = new JCheckBox("Enable VPN");
    check.setBounds(108,120,93,20);
    but1 = new JButton("Start EliteVPN");
    but1.setBounds(5,20,197,20);
    but2 = new JButton("Stop EliteVPN");
    but2.setEnabled(false);
    but2.setBounds(5,70,197,20);
    but3 = new JButton("OpenVPN");
    but3.setBackground(Color.yellow);
    but3.setBounds(5,120,98,20);
    but4 = new JButton("About EliteVPN");
    but4.setBounds(5,160,197,20);
    but5 = new JButton("Go Premium");
    but5.setBounds(5,185,197,20);
    panel3.setBorder(BorderFactory.createTitledBorder("Controls"));
    panel3.setLayout(null);
    panel3.setBackground(Color.blue);
    panel3.setBounds(288,0,206,209);
    panel3.add(but1);
    panel3.add(but2);
    panel3.add(but3);
    panel3.add(check);
    panel3.add(but4);
    panel3.add(but5);
    add(panel3);
 
    panel4 = new JPanel();
    label5 = new JLabel("Powered by Elitesbase : In partnership with Yusitechs");
    label5.setBackground(new Color(216,191,216));
    label5.setFont(new Font("Segoe Script",Font.PLAIN,14));
    label5.setBounds(45,0,500,150);
    panel4.setLayout(null);
    panel4.setBackground(new Color(224,224,225));
    panel4.setBounds(0,370,496,100);
    panel4.add(label5);
    add(panel4);
 
    list = new JList();
    scroll = new JScrollPane(list);
    list.setBackground(Color.BLACK);
    list.setBorder(BorderFactory.createTitledBorder("LOGS"));
    list.setForeground(Color.WHITE);
    scroll.setBounds(0, 210, 500, 162);
    add(scroll);
    but1.addActionListener(this);
    but2.addActionListener(this);
    but3.addActionListener(this);
    but4.addActionListener(this);
    but5.addActionListener(this);
 
    dlm.addElement("Welcome To EliteVPN");
    dlm.addElement("Version: 1.0");
    dlm.addElement("Website: www.yusitechs.com");
    dlm.addElement("Forum: www.elitesbase.com");
    dlm.addElement("Email: yusiiii7@gmail.com");
    dlm.addElement("!!!!!!!DISCLAIMER!!!!!!!");
    dlm.addElement("Intended for Educational Use Only.");        
 
 
    list.ensureIndexIsVisible(list.getModel().getSize() - 1 );
    list.setModel(dlm);
}
 
 
 
public void EliteButton(){
    JOptionPane.showMessageDialog(null, "You Clicked Stop EliteVPN button");
}
 
 
 
    public void actionPerformed(ActionEvent e){
        if (e.getSource()== but2){
            dlm.addElement("VPN stopped");
            list.ensureIndexIsVisible(list.getModel().getSize() - 1 );
            list.setModel(dlm);
            but1.setEnabled(true);
            but2.setEnabled(false);
 
        }
 
            if (e.getSource()== but1){
                dlm.addElement("VPN started");
                list.ensureIndexIsVisible(list.getModel().getSize() - 1 );
                list.setModel(dlm);
 
                but1.setEnabled(false);
                but2.setEnabled(true);
            }
            if (e.getSource()== but4){
 
            JOptionPane.showMessageDialog(null, "Dedicated To Elitesbase Members");
 
            }
 
            if (e.getSource()== but3){
                dlm.addElement("VPN open");
                list.ensureIndexIsVisible(list.getModel().getSize() - 1 );
                list.setModel(dlm);
            }
            if (e.getSource()== but5){
   JOptionPane.showMessageDialog(null, "Get a Premium Account From www.elitesbase.com");    
 
 }
 
    
 
    

