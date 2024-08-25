/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

/**
 *
 * @author Bhomika Suthar
 */
public class DonorInfo {
    
    String fname,lname ,phoneNo,CNIC,city,country,bloodGroup;

    public DonorInfo(String fname,String lname ,String phoneNo,String CNIC,String city,String country,String bloodGroup){
        
        this.fname = fname;
        this.lname = lname;
        this.phoneNo = phoneNo;
        this.CNIC = CNIC;
        this.city = city;
        this.country = country;
        this.bloodGroup = bloodGroup;
    }

    public String toString(){
       return "Name :"+fname+" "+lname+"\nPhone Number : "+phoneNo+"\nCNIC No : "+CNIC+"\nCity = "+city+"\nCountry : "+country+"\nBlood Group :"+bloodGroup;
    }

}
