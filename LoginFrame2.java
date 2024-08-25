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
class LoginFrame2 extends JFrame{

            LoginFrame2 currentFrame = this;
            JButton loginButton = new JButton("Click to Login");
            JLabel username = new JLabel("ENTER USERNAME");
            JTextField usernameTF = new JTextField();
            JLabel password = new JLabel("ENTER PASSWORD");
            JPasswordField passwordTF = new JPasswordField(8);

            String name, pass;

        LoginFrame2(){

            //Login Frame
            JPanel login = new JPanel();
            login.setSize(640,475);
            login.setLayout(null);
            login.setBackground(new Color(0,0,0,80));
            login.setBounds(300,175,640,475);


            username.setBounds(70,115,150,40);
            username.setFont(new Font("Serif", Font.BOLD, 15));
            usernameTF.setBounds(240,120,300,30);

            usernameTF.setBackground(Color.LIGHT_GRAY);
            usernameTF.setFont(new Font("Serif", Font.PLAIN, 15));

            password.setBounds(70,200,150,40);

            password.setFont(new Font("Serif", Font.BOLD, 15));
            passwordTF.setBounds(240,200,300,30);

            passwordTF.setBackground(Color.LIGHT_GRAY);

            passwordTF.setFont(new Font("Serif", Font.PLAIN, 15));
            loginButton.setBounds(250,300,140,50);
            loginButton.setBackground(new Color(160,182,45));
            loginButton.setForeground(Color.WHITE);
            loginButton.setFont(new Font("Serif", Font.PLAIN, 15));

            login.add(username);
            login.add(usernameTF);
            login.add(password);
            login.add(passwordTF);
            login.add(loginButton);
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

            //ImageIcon background_img = new ImageIcon(System.getProperty("user.dir") + "C:\\pics\\1.jpg");
            ImageIcon background_img = new ImageIcon( "C:\\pics\\3.jpg");
            
            Image img = background_img.getImage();
            Image  temp_img = img.getScaledInstance(1280,750,Image.SCALE_SMOOTH);
            background_img = new ImageIcon(temp_img);
            JLabel background = new JLabel("",background_img,JLabel.CENTER);
            background.setBounds(0,0,1280,750);
            background.add(heading);

            background.add(login);

            add(background);
            loginButton.addActionListener(new ListenToButton());
            setVisible(true);

            //This is end

            setSize(1280,950);
            setLayout(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);



        }


        private class ListenToButton implements ActionListener{

            public void actionPerformed(ActionEvent e){

                   if(e.getSource() == loginButton){

                        try{
                             name = usernameTF.getText();
                             pass = passwordTF.getText();


                            if(name.length()==0 || pass.length()==0){
                                throw new EmptyFieldsException();
                            }

                            for (int i=0 ; i<name.length() ;i++){
                                if ((name.charAt(i) < 'A' || name.charAt(i) > 'Z') && (name.charAt(i) < 'a' || name.charAt(i) > 'z') && name.charAt(i) != ' ')
                                    throw new NameException();

                                }

                                if(pass.length()>=8){
                                        JOptionPane.showMessageDialog(null,"WELCOME TO Blood Group Portal");
                                        new Frame2_AdminLocal().setVisible(true);
                                        currentFrame.setVisible(false);
                                        
                                }
                                else{
                                    throw new PasswordSizeException();
                                }

                            }
                            catch(Exception ee){
                                JOptionPane.showMessageDialog(null , ee);
                            }
                    }

            }
        }
}

