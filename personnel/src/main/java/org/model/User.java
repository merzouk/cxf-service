/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * A Renseigner.
 * @author  : ryan
 * @project : personnel
 * @package : org.server
 * @date    : 2 sept. 2014 22:53:43
 */
@XmlRootElement(name = "User")
public class User
{
   private Integer id;
   
   private String  nom;
   
   private String  prenom;
   
   private String  email;
   
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
    * @param id
    * @param nom
    * @param prenom
    * @param email
    * @param dateNow
    */
   public User( Integer id, String nom, String prenom, String email, Date dateNow )
   {
      super();
      this.id = id;
      this.nom = nom;
      this.prenom = prenom;
      this.email = email;
      this.dateNow = dateNow;
   }
   
   /**
    * @param nom
    * @param prenom
    * @param email
    * @param dateNow
    */
   public User( String nom, String prenom, String email, Date dateNow )
   {
      super();
      this.nom = nom;
      this.prenom = prenom;
      this.email = email;
      this.dateNow = dateNow;
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
    * 
    */
   public User()
   {
      super();
   }
}
