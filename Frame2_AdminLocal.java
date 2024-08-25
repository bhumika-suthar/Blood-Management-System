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
import javax.swing.JPanel;

/**
 *
 * @author Bhomika Suthar
 */
public class Frame2_AdminLocal extends JFrame{
    
    
  

    private JButton bL = new JButton("LOCAL USER");
    private JButton bA = new JButton("ADMINISTRATOR");
    private Frame2_AdminLocal currentFrame = this;

    public Frame2_AdminLocal() {


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

        ImageIcon background_img = new ImageIcon( "C:\\pics\\5.jpg");
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
        bL.addActionListener(new ListenToButton());
        bA.addActionListener(new ListenToButton());
        addWindowListener(new MyWindow());

        bA.setFont(new Font("Aerial", Font.BOLD, 15));
        bA.setBackground(Color.WHITE);
        bL.setFont(new Font("Aerial", Font.BOLD, 15));
        bL.setBackground(Color.WHITE);
        bA.setBounds(670, 350, 200, 80);
       
        bL.setBounds(440, 350, 200, 80);
        background.add(bL);//Changing
        background.add(bA); //Changing

        setSize(1280, 850);
        setLocationRelativeTo(null);


    }

    private class ListenToButton implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == bL) {
                currentFrame.setVisible(false);
                new Frame3_donorSeeker();

            } else {
                currentFrame.setVisible(false);
                try {
                        new Admin_LoginFrame();
                }
                catch (Exception e){
                    System.out.println(e);
                }

            }

        }

    }
    
    
    
}
