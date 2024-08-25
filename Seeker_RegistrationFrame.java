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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class Seeker_RegistrationFrame extends JFrame {
    
 

    Seeker_RegistrationFrame CurrentFrame = this;
    TextField tfN, tfL, tfC, tfP, tfCity, tfCountry;
    JLabel labelN, labelL, labelC,labelP, labelCity, labelCountry, labelCombo;
    JButton bSubmit = new JButton("SUBMIT");
    JButton bBack = new JButton("BACK");
    JComboBox combo ,combo1;
    String name, lastName, CNIC, Phone, City, Country,bloodGroup;
    String bloodGroups[] = {"A+", "A-", "B+", "B-","AB+","AB-","O+","O-"};
    

    Seeker_RegistrationFrame() {



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

        ImageIcon background_img = new ImageIcon("C:\\pics\\9.jpg");
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
        bBack.addActionListener(new ListenToButton());
        bSubmit.addActionListener(new ListenToButton());

        labelN = new JLabel("NAME");
        labelL = new JLabel("LAST NAME");
        labelC = new JLabel("CNIC No");
        labelP = new JLabel("PHONE NO");
        labelCity = new JLabel("CITY");
        labelCountry = new JLabel("COUNTRY");
        labelCombo = new JLabel("BLOOD");


        labelN.setBounds(150, 175, 90, 70);
        labelL.setBounds(650, 150, 150, 120);
        labelC.setBounds(150, 280, 90, 70);
        labelP.setBounds(650, 260, 110, 110);
        labelCity.setBounds(150, 380, 70, 70);
        labelCombo.setBounds(150, 455, 130, 130);
        labelCountry.setBounds(650, 360, 120, 120);
       

        labelN.setFont(new Font("Aerial", Font.BOLD, 19));
        labelL.setFont(new Font("Aerial", Font.BOLD, 19));
        labelC.setFont(new Font("Aerial", Font.BOLD, 19));
        labelP.setFont(new Font("Aerial", Font.BOLD, 19));
        labelCity.setFont(new Font("Aerial", Font.BOLD, 19));
        labelCombo.setFont(new Font("Aerial", Font.BOLD, 19));
        labelCountry.setFont(new Font("Aerial", Font.BOLD, 19));
       
        bSubmit.setBounds(800, 620, 100, 50);
        bSubmit.setBackground(Color.WHITE);
        bBack.setBounds(650, 620, 100, 50);
        bBack.setBackground(Color.WHITE);
        bSubmit.setFont(new Font("Aerial", Font.BOLD, 15));
        bBack.setFont(new Font("Aerial", Font.BOLD, 15));

        tfN = new TextField(20);
        tfL = new TextField(20);
        tfC = new TextField(20);
        tfP = new TextField(20);
        tfCity = new TextField(20);
        tfCountry = new TextField(20);
       

        tfN.setBounds(300, 200, 250, 30);
        tfL.setBounds(850, 200, 250, 30);
        tfC.setBounds(300, 300, 250, 30);
        tfP.setBounds(850, 300, 250, 30);
        tfCity.setBounds(300, 400, 250, 30);
        tfCountry.setBounds(850, 400, 250, 30);
       

        tfN.setFont(new Font("Aerial", Font.PLAIN, 15));
        tfL.setFont(new Font("Aerial", Font.PLAIN, 15));
        tfC.setFont(new Font("Aerial", Font.PLAIN, 15));
        tfP.setFont(new Font("Aerial", Font.PLAIN, 15));
        tfCity.setFont(new Font("Aerial", Font.PLAIN, 15));
        tfCountry.setFont(new Font("Aerial", Font.PLAIN, 15));
        

        background.add(tfN);
        background.add(tfL);
        background.add(tfC);
        background.add(tfP);
        background.add(tfCity);
        background.add(tfCountry);
       
        background.add(labelN);
        background.add(labelL);
        background.add(labelC);
        background.add(labelP);
        background.add(labelCity);
        background.add(labelCountry);
        background.add(labelCombo);
       
        combo = new JComboBox();
        background.add(combo);
        combo.addItem("Choose Blood Groups");
        combo.addItem("A+");
        combo.addItem("A-");
        combo.addItem("B+");
        combo.addItem("B-");
        combo.addItem("AB+");
        combo.addItem("AB-");
        combo.addItem("O+");
        combo.addItem("O-");

        combo.setLayout(null);
        combo.setBounds(300, 500, 250, 30);
        combo.addItemListener(new BloodOption());

        background.add(bSubmit);
        background.add(bBack);
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
                new Frame3_donorSeeker().setVisible(true);
                CurrentFrame.setVisible(false);
                

            }
            else if(ae.getSource() == bSubmit) {
                try {
                    name = tfN.getText();
                    lastName = tfL.getText();
                    CNIC = tfC.getText();
                    Phone = tfP.getText();
                    City = tfCity.getText();
                    Country = tfCountry.getText();
                     
                    
                    
                    if (name.length() == 0 || lastName.length() == 0 || CNIC.length() == 0 || Phone.length() == 0 || City.length() == 0 || Country.length() == 0 )
                        throw new EmptyFieldsException();

                    for (int i = 0; i < name.length(); i++)
                        if ((name.charAt(i) < 'A' || name.charAt(i) > 'Z') && (name.charAt(i) < 'a' || name.charAt(i) > 'z'))
                            throw new NameException();

                    for (int i = 0; i < lastName.length(); i++)
                        if ((lastName.charAt(i) < 'A' || lastName.charAt(i) > 'Z') && (lastName.charAt(i) < 'a' || lastName.charAt(i) > 'z'))
                            throw new LastNameException(); // throw LastName exception here.

                    if (CNIC.length() != 13) throw new CNICSizeException();
                    for (int i = 0; i < CNIC.length(); i++)
                        if (CNIC.charAt(i) < '0' || CNIC.charAt(i) > '9')
                            throw new CNICException();

                    if (Phone.length() != 11) throw new PhoneSizeException();
                    for (int i = 0; i < Phone.length(); i++)
                        if (Phone.charAt(i) < '0' || Phone.charAt(i) > '9')
                            throw new PhoneException();

                    for (int i = 0; i < City.length(); i++)
                        if ((City.charAt(i) < 'A' || City.charAt(i) > 'Z') && (City.charAt(i) < 'a' || City.charAt(i) > 'z') && City.charAt(i) != ' ')
                            throw new CityNameException(); // throw CityName exception here

                    for (int i = 0; i < Country.length(); i++)
                        if ((Country.charAt(i) < 'A' || Country.charAt(i) > 'Z') && (Country.charAt(i) < 'a' || Country.charAt(i) > 'z'))
                            throw new CountryNameException(); // throw CountryName exception here


                    if(combo.getSelectedItem().toString().equals("A+") ||combo.getSelectedItem().toString().equals("A-")||combo.getSelectedItem().toString().equals("B+")||combo.getSelectedItem().toString().equals("B-")||combo.getSelectedItem().toString().equals("AB+")||combo.getSelectedItem().toString().equals("AB-")||combo.getSelectedItem().toString().equals("O+")||combo.getSelectedItem().toString().equals("O-") ){
                        JOptionPane.showMessageDialog(null,new DonorInfo(name,lastName,Phone,CNIC,City,Country,combo.getSelectedItem().toString())+ "\n");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"SORRY! you did not choose any blood type");
                    }





                     try {
                        String url = "jdbc:mysql://localhost:3306/FinalProject1";
                        String uname = "root";
                        String pass = "root";
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(url, uname, pass);

                        String query1 = "insert into seeker(name,lastname,cnic,phonenumber,city,country,bloodgroup) values (?,?,?,?,?,?,?)";
                        PreparedStatement statement1 = con.prepareStatement(query1);

                        statement1.setString(1, tfN.getText());
                        statement1.setString(2, tfL.getText());
                        statement1.setString(3, tfC.getText());
                        statement1.setString(4, tfP.getText());
                        statement1.setString(5, tfCity.getText());
                        statement1.setString(6, tfCountry.getText());
                        statement1.setString(7, combo.getSelectedItem().toString());
                        statement1.executeUpdate();
//                        int i = statement1.executeUpdate();
//                        if (i > 0) {
//                            System.out.println("Record Added");
//
//                        }

                        con.close();
                    } catch (Exception ee) {
                        System.out.println(ee);
                    }


                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            }
        }
    }
    private class BloodOption implements ItemListener {

        public void itemStateChanged(ItemEvent ie) {
            if(ie.getStateChange()==ItemEvent.SELECTED){
               
                   
                    JOptionPane.showMessageDialog(null, "Blood group is added ");
               

            }
        }

    }
}

