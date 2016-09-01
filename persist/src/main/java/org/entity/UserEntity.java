/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : javaJaxws
 *
 * Copyright Administrateur,  All Rights Reserved.
 *
 * This software is the confidential and proprietary
 * information of Administrateur.
 * You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms
 * of the license agreement you entered into with
 * Administrateur.
 *-------------------------------------------------------- 
 * 
 * Fichier 		:	UserEntity.java
 * Créé le 		: 	4 sept. 2014 à 11:50:31
 * Auteur		: 	ryan
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

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
 * @date    : 4 sept. 2014 11:50:31
 */
@Entity(name = "User")
@Table(name = "User")
public class UserEntity implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = 692610245726664403L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer           id;
   
   @Column(name = "nom", length = 50, nullable = false, unique = false)
   private String            nom;
   
   @Column(name = "prenom", length = 50, nullable = false, unique = false)
   private String            prenom;
   
   @Column(name = "email", length = 150, nullable = false, unique = true)
   private String            email;
   
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
    * @return the nom
    */
   public String getNom()
   {
      return nom;
   }
   
   /**
    * @param nom the nom to set
    */
   public void setNom( String nom )
   {
      this.nom = nom;
   }
   
   /**
    * @return the prenom
    */
   public String getPrenom()
   {
      return prenom;
   }
   
   /**
    * @param prenom the prenom to set
    */
   public void setPrenom( String prenom )
   {
      this.prenom = prenom;
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
      return "UserEntity [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", dateNow=" + dateNow + "]";
   }
   
   /**
    * @param id
    * @param nom
    * @param prenom
    * @param email
    * @param dateNow
    */
   public UserEntity( Integer id, String nom, String prenom, String email, Date dateNow )
   {
      super();
      this.id = id;
      this.nom = nom;
      this.prenom = prenom;
      this.email = email;
      this.dateNow = dateNow;
   }
   
   /**
    * 
    */
   public UserEntity()
   {
      super();
   }
}