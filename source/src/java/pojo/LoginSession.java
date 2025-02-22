package pojo;
// Generated Jan 10, 2016 2:36:50 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * LoginSession generated by hbm2java
 */
public class LoginSession  implements java.io.Serializable {


     private Integer idloginSession;
     private UserLogin userLogin;
     private Date inTime;
     private Date outTime;

    public LoginSession() {
    }

	
    public LoginSession(UserLogin userLogin) {
        this.userLogin = userLogin;
    }
    public LoginSession(UserLogin userLogin, Date inTime, Date outTime) {
       this.userLogin = userLogin;
       this.inTime = inTime;
       this.outTime = outTime;
    }
   
    public Integer getIdloginSession() {
        return this.idloginSession;
    }
    
    public void setIdloginSession(Integer idloginSession) {
        this.idloginSession = idloginSession;
    }
    public UserLogin getUserLogin() {
        return this.userLogin;
    }
    
    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }
    public Date getInTime() {
        return this.inTime;
    }
    
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }
    public Date getOutTime() {
        return this.outTime;
    }
    
    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }




}


