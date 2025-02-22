package pojo;
// Generated Jan 23, 2016 3:21:10 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * ProductColor generated by hbm2java
 */
public class ProductColor  implements java.io.Serializable {


     private Integer idcolor;
     private String color;
     private Set products = new HashSet(0);

    public ProductColor() {
    }

    public ProductColor(String color, Set products) {
       this.color = color;
       this.products = products;
    }
   
    public Integer getIdcolor() {
        return this.idcolor;
    }
    
    public void setIdcolor(Integer idcolor) {
        this.idcolor = idcolor;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public Set getProducts() {
        return this.products;
    }
    
    public void setProducts(Set products) {
        this.products = products;
    }




}


