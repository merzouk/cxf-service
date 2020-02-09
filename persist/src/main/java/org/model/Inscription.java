package org.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : cxfJaxws
 * @package : org.model
 * @date    : 7 sept. 2014 10:45:57
 */
@XmlRootElement(name = "Inscription")
public class Inscription
{
   private Integer id;
   
   private String  email;
   
   private String  cours;
   
   private Date    dateDuJour;
   
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
    * @return the email
    */
   public String getEmail()
   {
      return email;
   }
   
   /**
    * @param email the email to set
    */
   public void setEmail( String email )
   {
      this.email = email;
   }
   
   /**
    * @return the cours
    */
   public String getCours()
   {
      return cours;
   }
   
   /**
    * @param cours the cours to set
    */
   public void setCours( String cours )
   {
      this.cours = cours;
   }
   
   /**
    * @return the dateDuJour
    */
   public Date getDateDuJour()
   {
      return dateDuJour;
   }
   
   /**
    * @param dateDuJour the dateDuJour to set
    */
   public void setDateDuJour( Date dateDuJour )
   {
      this.dateDuJour = dateDuJour;
   }
   
   /**
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString()
   {
      return "Inscription [id=" + id + ", email=" + email + ", cours=" + cours + ", dateDuJour=" + dateDuJour + "]";
   }
   
   /**
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ( ( cours == null ) ? 0 : cours.hashCode() );
      result = prime * result + ( ( dateDuJour == null ) ? 0 : dateDuJour.hashCode() );
      result = prime * result + ( ( email == null ) ? 0 : email.hashCode() );
      result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
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
      Inscription other = (Inscription) obj;
      if( cours == null )
      {
         if( other.cours != null ) return false;
      }
      else if( !cours.equals( other.cours ) ) return false;
      if( dateDuJour == null )
      {
         if( other.dateDuJour != null ) return false;
      }
      else if( !dateDuJour.equals( other.dateDuJour ) ) return false;
      if( email == null )
      {
         if( other.email != null ) return false;
      }
      else if( !email.equals( other.email ) ) return false;
      if( id == null )
      {
         if( other.id != null ) return false;
      }
      else if( !id.equals( other.id ) ) return false;
      return true;
   }
}