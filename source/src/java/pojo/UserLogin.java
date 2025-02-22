package pojo;
// Generated Jan 10, 2016 2:36:50 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * UserLogin generated by hbm2java
 */
public class UserLogin  implements java.io.Serializable {


     private Integer iduserLogin;
     private User user;
     private String username;
     private String password;
     private Integer maxLoginAttempt;
     private Set loginSessions = new HashSet(0);

    public UserLogin() {
    }

	
    public UserLogin(User user) {
        this.user = user;
    }
    public UserLogin(User user, String username, String password, Integer maxLoginAttempt, Set loginSessions) {
       this.user = user;
       this.username = username;
       this.password = password;
       this.maxLoginAttempt = maxLoginAttempt;
       this.loginSessions = loginSessions;
    }
   
    public Integer getIduserLogin() {
        return this.iduserLogin;
    }
    
    public void setIduserLogin(Integer iduserLogin) {
        this.iduserLogin = iduserLogin;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getMaxLoginAttempt() {
        return this.maxLoginAttempt;
    }
    
    public void setMaxLoginAttempt(Integer maxLoginAttempt) {
        this.maxLoginAttempt = maxLoginAttempt;
    }
    public Set getLoginSessions() {
        return this.loginSessions;
    }
    
    public void setLoginSessions(Set loginSessions) {
        this.loginSessions = loginSessions;
    }




}


