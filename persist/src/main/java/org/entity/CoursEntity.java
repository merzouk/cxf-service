package org.entity;

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
 * @project : cxfJaxws
 * @package : org.model
 * @date    : 7 sept. 2014 12:51:19
 */
@Entity(name = "Cours")
@Table(name = "Cours")
public class CoursEntity
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer           id;
   
   @Column(name = "coursCode", length = 50, nullable = false, unique = true)
   private String  coursCode;
   
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
    * @return the coursCode
    */
   public String getCoursCode()
   {
      return coursCode;
   }
   
   /**
    * @param coursCode the coursCode to set
    */
   public void setCoursCode( String coursCode )
   {
      this.coursCode = coursCode;
   }
   
   /**
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString()
   {
      return "Cours [id=" + id + ", coursCode=" + coursCode + "]";
   }
   
   /**
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ( ( coursCode == null ) ? 0 : coursCode.hashCode() );
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
      CoursEntity other = (CoursEntity) obj;
      if( coursCode == null )
      {
         if( other.coursCode != null ) return false;
      }
      else if( !coursCode.equals( other.coursCode ) ) return false;
      if( id == null )
      {
         if( other.id != null ) return false;
      }
      else if( !id.equals( other.id ) ) return false;
      return true;
   }
}