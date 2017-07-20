/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

/**
 *
 * @author SUBHAM RAJ SINGH
 */
public class RegisterBean {
    
    
 private String firstname;
 private String lastname;
  private int manid;
   private int empid;
 private String city;
 private String state;
  private int zip;
 private String passw;
 private String email;
  
  
 public String getFirstName() {
 return firstname;
 }
 public void setFirstName(String firstname) {
 this.firstname= firstname;
 }
  public String getLastName() {
 return lastname;
 }
 public void setLastName(String lastname) {
 this.lastname= lastname;
 }
  public int getManagerId() {
 return manid;
 }
 public void setManagerId(int manid) {
 this.manid= manid;
 }
  public int getEmployeeId() {
 return empid;
 }
 public void setEmployeeId(int empid) {
 this.empid= empid;
 }
 public String getCity() {
 return city;
 }
 public void setCity(String city) {
 this.city = city;
 }
 public String getState() {
 return state;
 }
 public void setState(String state) {
 this.state= state;
 }
  public int getZip() {
 return zip;
 }
 public void setZip(int zip) {
 this.zip= zip;
 }
 public String getPassword() {
 return passw;
 }
 public void setPassword(String passw) {
 this.passw = passw;
 }
 
 public void setEmail(String email) {
 this.email = email;
 }
 public String getEmail() {
 return email;
 }
}
