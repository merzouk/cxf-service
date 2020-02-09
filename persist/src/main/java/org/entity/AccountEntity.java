package org.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : persist
 * @package : org.entity
 * @date    : 5 sept. 2014 20:27:37
 */
@Entity(name = "Account")
@Table(name = "Account")
public class AccountEntity implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = -8148114544654783866L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer           id;
   
   @Column(name = "login", length = 50, nullable = false, unique = true)
   private String            login;
   
   @Column(name = "password", length = 300, nullable = false, unique = true)
   private String            password;
   
   @Column(name = "date_now", nullable = false, unique = true)
   private Date              dateNow;
   
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
      return "AccountEntity [id=" + id + ", login=" + login + ", password=" + password + ", dateNow=" + dateNow + "]";
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
      AccountEntity other = (AccountEntity) obj;
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