/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author kohadon
 */
public class student {
    Integer id;
    String firstName, lastName, className;

    public student(Integer id, String firstName, String lastName, String className) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.className = className;
    }

    public student() {
        this.id = null;
        this.firstName = null;
        this.lastName = null;
        this.className = null;        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
    
    
    
}
