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
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Bhomika Suthar
 */
public class Frame3_donorSeeker extends JFrame {

    private JButton bR = new JButton("BLOOD DONOR");
    private JButton bD = new JButton("BLOOD SEEKER");
    private JButton goToMain = new JButton("<Back");
    private Frame3_donorSeeker currentFrame = this;

    Frame3_donorSeeker() {

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

        ImageIcon background_img = new ImageIcon( "C:\\pics\\4.jpg");
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
        bD.addActionListener(new ListenToButton());
        bR.addActionListener(new ListenToButton());
        goToMain.addActionListener(new ListenToButton());
        //addWindowListener(new MyWindow());

        bR.setFont(new Font("Aerial", Font.BOLD, 18));
        bR.setBackground(Color.WHITE);
        bD.setFont(new Font("Aerial", Font.BOLD, 18));
        bD.setBackground(Color.WHITE);
        goToMain.setFont(new Font("Aerial", Font.ITALIC, 16));
        goToMain.setBackground(Color.WHITE);
        bD.setBounds(660, 350, 180, 80);
        background.add(bD);
        bR.setBounds(440, 350, 180, 80);
        background.add(bR);
        goToMain.setBounds(60, 600, 100, 20);
        background.add(goToMain);

        setSize(1280, 850);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private class ListenToButton implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == goToMain) {
                currentFrame.setVisible(false);
                new Frame2_AdminLocal().setVisible(true);
            } else if (ae.getSource() == bR) {
                currentFrame.setVisible(false);
                new  Donor_RegistrationFrame4().setVisible(true);
            } else {
                currentFrame.setVisible(false);
               new Frame_ClickOnSeeker().setVisible(true);
            }
        }
    }



}
