package pojo;
// Generated Jan 23, 2016 3:21:10 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Invoice generated by hbm2java
 */
public class Invoice  implements java.io.Serializable {


     private Integer idinvoice;
     private Cart cart;
     private User user;
     private String invoiceNum;
     private Date timeDate;
     private Set deliveries = new HashSet(0);

    public Invoice() {
    }

	
    public Invoice(Cart cart, User user) {
        this.cart = cart;
        this.user = user;
    }
    public Invoice(Cart cart, User user, String invoiceNum, Date timeDate, Set deliveries) {
       this.cart = cart;
       this.user = user;
       this.invoiceNum = invoiceNum;
       this.timeDate = timeDate;
       this.deliveries = deliveries;
    }
   
    public Integer getIdinvoice() {
        return this.idinvoice;
    }
    
    public void setIdinvoice(Integer idinvoice) {
        this.idinvoice = idinvoice;
    }
    public Cart getCart() {
        return this.cart;
    }
    
    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getInvoiceNum() {
        return this.invoiceNum;
    }
    
    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }
    public Date getTimeDate() {
        return this.timeDate;
    }
    
    public void setTimeDate(Date timeDate) {
        this.timeDate = timeDate;
    }
    public Set getDeliveries() {
        return this.deliveries;
    }
    
    public void setDeliveries(Set deliveries) {
        this.deliveries = deliveries;
    }




}


