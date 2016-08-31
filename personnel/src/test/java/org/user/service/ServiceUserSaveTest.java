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
 * Fichier 		:	UserSaveTest.java
 * Créé le 		: 	4 sept. 2014 à 13:20:54
 * Auteur		: 	ryan
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.user.service;

import java.util.UUID;

import org.junit.Test;
import org.model.User;
import org.service.ServiceSoap;
import org.service.impl.ServiceSoapImpl;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : javaJaxws
 * @package : org.dao
 * @date    : 4 sept. 2014 13:20:54
 */
public class ServiceUserSaveTest
{
   private static ServiceSoap serviceSoap = null;
   
   @Test
   public void saveTest()
   {
      serviceSoap = new ServiceSoapImpl();
      User user = new User();
      String uuid = generateString( 10 );
      user.setEmail( uuid + "@gmail.com" );
      user.setNom( "nom_" + 1 );
      user.setPrenom( uuid );
      serviceSoap.saveUser( user );
   }
   
   private String generateString( int length )
   {
      final String uuid = UUID.randomUUID().toString().replaceAll( "-", "" );
      return uuid.substring( 0, 11 ).toUpperCase();
   }
}
