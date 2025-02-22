package pojo;
// Generated Jan 23, 2016 3:21:10 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer iduser;
     private UserGender userGender;
     private UserState userState;
     private UserType userType;
     private String fname;
     private String lname;
     private String email;
     private String telephone;
     private String mobile;
     private String address1;
     private String address2;
     private String address3;
     private String city;
     private String PCode;
     private String district;
     private String country;
     private Date dob;
     private Set invoices = new HashSet(0);
     private Set carts = new HashSet(0);
     private Set deliveries = new HashSet(0);

    public User() {
    }

	
    public User(UserGender userGender, UserState userState, UserType userType) {
        this.userGender = userGender;
        this.userState = userState;
        this.userType = userType;
    }
    public User(UserGender userGender, UserState userState, UserType userType, String fname, String lname, String email, String telephone, String mobile, String address1, String address2, String address3, String city, String PCode, String district, String country, Date dob, Set invoices, Set carts, Set deliveries) {
       this.userGender = userGender;
       this.userState = userState;
       this.userType = userType;
       this.fname = fname;
       this.lname = lname;
       this.email = email;
       this.telephone = telephone;
       this.mobile = mobile;
       this.address1 = address1;
       this.address2 = address2;
       this.address3 = address3;
       this.city = city;
       this.PCode = PCode;
       this.district = district;
       this.country = country;
       this.dob = dob;
       this.invoices = invoices;
       this.carts = carts;
       this.deliveries = deliveries;
    }
   
    public Integer getIduser() {
        return this.iduser;
    }
    
    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }
    public UserGender getUserGender() {
        return this.userGender;
    }
    
    public void setUserGender(UserGender userGender) {
        this.userGender = userGender;
    }
    public UserState getUserState() {
        return this.userState;
    }
    
    public void setUserState(UserState userState) {
        this.userState = userState;
    }
    public UserType getUserType() {
        return this.userType;
    }
    
    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    public String getFname() {
        return this.fname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return this.lname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getAddress1() {
        return this.address1;
    }
    
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    public String getAddress2() {
        return this.address2;
    }
    
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    public String getAddress3() {
        return this.address3;
    }
    
    public void setAddress3(String address3) {
        this.address3 = address3;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getPCode() {
        return this.PCode;
    }
    
    public void setPCode(String PCode) {
        this.PCode = PCode;
    }
    public String getDistrict() {
        return this.district;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    public Date getDob() {
        return this.dob;
    }
    
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public Set getInvoices() {
        return this.invoices;
    }
    
    public void setInvoices(Set invoices) {
        this.invoices = invoices;
    }
    public Set getCarts() {
        return this.carts;
    }
    
    public void setCarts(Set carts) {
        this.carts = carts;
    }
    public Set getDeliveries() {
        return this.deliveries;
    }
    
    public void setDeliveries(Set deliveries) {
        this.deliveries = deliveries;
    }




}


