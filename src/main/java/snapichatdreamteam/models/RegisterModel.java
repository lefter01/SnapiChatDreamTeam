/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snapichatdreamteam.models;

/**
 *
 * @author Rin0a
 */
public class RegisterModel {
    
    private byte[] image;
    private String fName;
    private String lName;
    private String email;
    private String phone;
    private String city;
    private String country;
    private String username;
    private String pass;
    private String cPass;

    public RegisterModel(byte[] image, String fName, String lName, String email, String phone, String city, String country, String username, String pass, String cPass) {
        this.image = image;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.country = country;
        this.username = username;
        this.pass = pass;
        this.cPass = cPass;
    }

    
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getcPass() {
        return cPass;
    }

    public void setcPass(String cPass) {
        this.cPass = cPass;
    }
}
