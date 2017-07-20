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
public class RequestBean {
    
 private String prodname;
 private int empid;
 //private int manid;
// private String email;
 //private String contact;
 private String budget;
 private String need;
 
public String getProdName() {
 return prodname;
 }
public void setProdName(String prodname) {
 this.prodname = prodname;
 }
 
  public int getEmployeeId() {
 return empid;
 }
 public void setEmployeeId(int empid) {
 this.empid= empid;
 }
 
 
  public String getBudget() {
 return budget;
 }
 public void setBudget(String budget) {
 this.budget= budget;
 }
  public String getNeed() {
 return need;
 }
 public void setNeed(String need) {
 this.need= need;
 }
    
}
