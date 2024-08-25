/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Bhomika Suthar
 */
public class Frame_ClickOnSeeker extends JFrame {

    Frame_ClickOnSeeker CurrentFrame = this;
    public static TextField tfCity;
    JLabel labelCity, labelCombo, labelFillForm;
    JButton bSubmit = new JButton("SEARCH");
    JButton bBack = new JButton("BACK");
    JButton bForm = new JButton("CLICK HERE");
    public static JComboBox combo;
    String bloodGroups[] = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
    
    public static String getCityName()
    {
        return tfCity.getText();
    }
    public static String getBloodName()
    {
        String blood = combo.getSelectedItem().toString();
        return blood;
    }

    Frame_ClickOnSeeker() {

        //Starting
        //Font
        Font f = new Font("Serif", Font.BOLD, 36);

        //heading
        JPanel heading;
        heading = new JPanel();
        heading.setBackground(new Color(0, 0, 0, 80));

        heading.setBounds(0, 0, 1270, 100);
        JLabel title = new JLabel("WELCOME TO BLOOD GROUP PORTAL");
        title.setForeground(Color.WHITE);

        title.setFont(f);
        heading.add(title);

        //Image
        setSize(1280, 750);
        setLayout(null);

        ImageIcon background_img = new ImageIcon("C:\\pics\\0.jpg");
        Image img = background_img.getImage();
        Image temp_img = img.getScaledInstance(1280, 750, Image.SCALE_SMOOTH);
        background_img = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_img, JLabel.CENTER);
        background.setBounds(0, 0, 1280, 750);
        background.add(heading);
        add(background);
        setVisible(true);

        //This is end
        setLayout(null);
        bForm.addActionListener(new Frame_ClickOnSeeker.ListenToButton());
        bBack.addActionListener(new Frame_ClickOnSeeker.ListenToButton());
        bSubmit.addActionListener(new Frame_ClickOnSeeker.ListenToButton());

        labelCity = new JLabel("CITY:");
        labelFillForm = new JLabel("IF NO DONOR FOUND THEN FILL THE FORM BELOW");

        labelCombo = new JLabel("SELECT BLOOD GROUP:");

        tfCity = new TextField(20);
        labelCity.setFont(new Font("Aerial", Font.BOLD, 19));
        labelFillForm.setFont(new Font("Aerial", Font.BOLD, 20));

        labelCombo.setFont(new Font("Aerial", Font.BOLD, 19));
        bSubmit.setBounds(450, 550, 100, 50);
        bSubmit.setBackground(Color.WHITE);
        bBack.setBounds(300, 550, 100, 50);
        bBack.setBackground(Color.WHITE);
        bForm.setBounds(800, 345, 200, 50);
        bForm.setBackground(Color.WHITE);
        bForm.setFont(new Font("Aerial", Font.BOLD, 17));
        bSubmit.setFont(new Font("Aerial", Font.BOLD, 15));
        bBack.setFont(new Font("Aerial", Font.BOLD, 15));

        labelCity.setBounds(150, 230, 70, 70);
        tfCity.setBounds(300, 250, 250, 30);

        labelFillForm.setBounds(700, 230, 550, 70);

        labelCombo.setBounds(100, 300, 250, 130);

        background.add(tfCity);
        background.add(labelCity);

        background.add(labelCombo);

        combo = new JComboBox();
        background.add(combo);
        combo.addItem("");
        combo.addItem("A+");
        combo.addItem("A-");
        combo.addItem("B+");
        combo.addItem("B-");
        combo.addItem("AB+");
        combo.addItem("AB-");
        combo.addItem("O+");
        combo.addItem("O-");

        combo.setLayout(null);
        combo.setBounds(400, 350, 150, 30);
        //combo.addItemListener(new Donor_RegistrationFrame4.BloodOption());

        background.add(bSubmit);
        background.add(bBack);
        background.add(labelFillForm);
        background.add(bForm);
        setSize(1280, 950);
        setVisible(true);
        setLocationRelativeTo(null);

        bSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private class ListenToButton implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == bBack) {
                CurrentFrame.setVisible(false);
                new Frame3_donorSeeker().setVisible(true);

            } else if (ae.getSource() == bForm) {

                CurrentFrame.setVisible(false);
                new Seeker_RegistrationFrame().setVisible(true);
            } else if (ae.getSource() == bSubmit) {
                
                if(!(tfCity.getText().equals("")||(combo.getSelectedItem().toString().equals("")))){
                setVisible(false);
                new DonnerResult().setVisible(true);
                }
                else if(!(tfCity.getText().equals("")) && (combo.getSelectedItem().toString().equals(""))) {
                    JOptionPane.showMessageDialog(null,"Please select blood group");
                }
               else if((tfCity.getText().equals("")) && (!(combo.getSelectedItem().toString().equals("")))) {
                    JOptionPane.showMessageDialog(null,"Please enter city Name");
               }else {
                            JOptionPane.showMessageDialog(null,"Fields cannot be Empty");
                            }
                        
            }
        }
    }
}
