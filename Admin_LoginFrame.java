/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Bhomika Suthar
 */
public class Admin_LoginFrame extends JFrame {
    
    
    Admin_LoginFrame currentFrame =this;
    JButton bLogin = new JButton("LOGIN");
    JButton bBack = new JButton("BACK");
    JTextField tfName = new JTextField(20);
    final JPasswordField tfPassword = new JPasswordField(20);
    JLabel lName ,lPassword;
    String password = "password",name,pass;
    public Admin_LoginFrame() throws Exception{


        //Starting
        //Font
          Font f = new Font("Serif",Font.BOLD,36);

        //heading
        JPanel heading;
        heading = new JPanel();
        heading.setBackground(new Color(0,0,0,80));

        heading.setBounds(0,0,1270,100);
        JLabel title = new JLabel("WELCOME TO BLOOD GROUP PORTAL");
        title.setForeground(Color.WHITE);

        title.setFont(f);
        heading.add(title);

        //Image
        setSize(1280,750);
        setLayout(null);

        ImageIcon background_img = new ImageIcon("C:\\pics\\7.jpg");
        Image img = background_img.getImage();
        Image  temp_img = img.getScaledInstance(1280,750,Image.SCALE_SMOOTH);
        background_img = new ImageIcon(temp_img);
        JLabel background = new JLabel("",background_img,JLabel.CENTER);
        background.setBounds(0,0,1280,750);
        background.add(heading);
        add(background);
        setVisible(true);


        //This is end

        setLayout(null);

        lName = new JLabel("NAME");
        lPassword = new JLabel("PASSWORD");
        tfName.setBounds(400, 300, 250, 30);
        tfPassword.setBounds(400, 400, 250, 30);
        tfName.setFont(new Font("Aerial", Font.PLAIN, 15));
        tfPassword.setFont(new Font("Aerial", Font.PLAIN, 15));




        lName.setBounds(280, 278, 90, 70);
        lPassword.setBounds(240, 357, 150, 120);
        lName.setFont(new Font("Aerial", Font.BOLD, 19));
        lPassword.setFont(new Font("Aerial", Font.BOLD, 19));

        bBack.setFont(new Font("Aerial", Font.BOLD, 15));
        bLogin.setFont(new Font("Aerial", Font.BOLD, 15));

        bLogin.setBounds(800, 550, 100, 50); 
        bLogin.setBackground(Color.WHITE);
        bBack.setBounds(650, 550, 100, 50);
        bBack.setBackground(Color.WHITE);
        bBack.addActionListener(new ListenToButton());
        bLogin.addActionListener(new ListenToButton());


        background.add(tfName);
        background.add(tfPassword);
        background.add(lName);
        background.add(lPassword);
        background.add(bLogin);
        background.add(bBack);
        setSize(1280, 950);
        setVisible(true);
        setLocationRelativeTo(null);
        //addWindowListener(new MyWindow());
        setDefaultCloseOperation(EXIT_ON_CLOSE);






    }
    private class ListenToButton implements ActionListener{

        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==bBack){
                new Frame2_AdminLocal().setVisible(true);
                currentFrame.setVisible(false);
                
            }

            else {
                try{
                    name = tfName.getText();
                    pass = tfPassword.getText();
                    String check = tfPassword.getText();
                    if(name.length()==0 || pass.length()==0){
                        throw new EmptyFieldsException();
                    }
                    for (int i=0 ; i<name.length() ;i++){
                        if ((name.charAt(i) < 'A' || name.charAt(i) > 'Z') && (name.charAt(i) < 'a' || name.charAt(i) > 'z') && name.charAt(i) != ' ')
                            throw new NameException();

                    }
                    if(pass.length()==8){
                        if(check.equals(password)){
                            JOptionPane.showMessageDialog(null,"Hello Admin!");
                            new Frame_ViewSeekerDonor_Info();
                            currentFrame.setVisible(false);
                            //new showRecord().setVisible(true);
                           //AFTER THIS, SHOW FRAME FOR VIEW SEEKER AND DONOR INFO 
                           
                        }

                        else   throw new PasswordException();//JOptionPane.showMessageDialog(null,"SORRY! You don not have authorization "+);
                    }
                    else{
                        throw new PasswordSizeException();

                    }

                   // new showRecord();

                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null , e);
                }

            }

        }

    }
}


