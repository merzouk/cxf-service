package org.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : persist
 * @package : org.model
 * @date    : 5 sept. 2014 20:25:32
 */
@XmlRootElement(name = "Account")
public class Account
{
   private Integer id;
   
   private String  login;
   
   private String  password;
   
   private Date    dateNow;
   
   /**
    * @return the id
    */
   public Integer getId()
   {
      return id;
   }
   
   /**
    * @param id the id to set
    */
   public void setId( Integer id )
   {
      this.id = id;
   }
   
   /**
    * @return the login
    */
   public String getLogin()
   {
      return login;
   }
   
   /**
    * @param login the login to set
    */
   public void setLogin( String login )
   {
      this.login = login;
   }
   
   /**
    * @return the password
    */
   public String getPassword()
   {
      return password;
   }
   
   /**
    * @param password the password to set
    */
   public void setPassword( String password )
   {
      this.password = password;
   }
   
   /**
    * @return the dateNow
    */
   public Date getDateNow()
   {
      return dateNow;
   }
   
   /**
    * @param dateNow the dateNow to set
    */
   public void setDateNow( Date dateNow )
   {
      this.dateNow = dateNow;
   }
   
   /**
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString()
   {
      return "Account [id=" + id + ", login=" + login + ", password=" + password + ", dateNow=" + dateNow + "]";
   }
   
   /**
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ( ( dateNow == null ) ? 0 : dateNow.hashCode() );
      result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
      result = prime * result + ( ( login == null ) ? 0 : login.hashCode() );
      result = prime * result + ( ( password == null ) ? 0 : password.hashCode() );
      return result;
   }
   
   /**
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals( Object obj )
   {
      if( this == obj ) return true;
      if( obj == null ) return false;
      if( getClass() != obj.getClass() ) return false;
      Account other = (Account) obj;
      if( dateNow == null )
      {
         if( other.dateNow != null ) return false;
      }
      else if( !dateNow.equals( other.dateNow ) ) return false;
      if( id == null )
      {
         if( other.id != null ) return false;
      }
      else if( !id.equals( other.id ) ) return false;
      if( login == null )
      {
         if( other.login != null ) return false;
      }
      else if( !login.equals( other.login ) ) return false;
      if( password == null )
      {
         if( other.password != null ) return false;
      }
      else if( !password.equals( other.password ) ) return false;
      return true;
   }
}