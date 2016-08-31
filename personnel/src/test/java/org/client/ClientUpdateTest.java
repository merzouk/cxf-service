/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : cxfJaxws
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
 * Fichier 		:	ClientUpdateTest.java
 * Créé le 		: 	4 sept. 2014 à 19:45:19
 * Auteur		: 	ryan
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.client;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.junit.Test;
import org.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ws.service.user.UserService;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : cxfJaxws
 * @package : org.client
 * @date    : 4 sept. 2014 19:45:19
 */
public class ClientUpdateTest
{
   private static final Logger logger       = LoggerFactory.getLogger( ClientUpdateTest.class );
   
   private static final QName  SERVICE_NAME = new QName( "http://service.ws.org/", "UserCxfSoapService" );
   
   private static final QName  PORT_NAME    = new QName( "http://service.ws.org/", "UserCxfSoapServicePort" );
   
   @Test
   public void updateTest() throws Exception
   {
      logger.info( "updateTest" );
      Service service = Service.create( SERVICE_NAME );
      // Endpoint Address
      //String endpointAddress = "http://localhost:8081/UserCxfSoapService";
      // If web service deployed on Tomcat (either standalone or embedded)
      // as described in sample README, endpoint should be changed to:
      String endpointAddress = "http://localhost:8081/cxfJaxws/services/serviceSoapUser";
      /**
       *  Add a port to the Service
       */
      service.addPort( PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress );
      UserService userCxfSoapService = service.getPort( UserService.class );
      /**
       * 
       */
      List<User> list = userCxfSoapService.getUsers();
      assertNotNull( list );
      int size = list.size();
      Integer idToDelete = list.get( 0 ).getId();
      assertTrue( size > 0 );
      
      User userToUpdate = userCxfSoapService.findUserById( idToDelete );
      assertNotNull( userToUpdate );
      String login = generateString( 11 );
      String email = login + "@yahoo.fr";
      userToUpdate.setEmail( email );
      userToUpdate.setPrenom( login );
      userToUpdate = userCxfSoapService.updateUser( userToUpdate );
      User userUpdated = userCxfSoapService.findUserById( idToDelete );
      assertNotNull( userUpdated );
      assertEquals( email, userUpdated.getEmail() );
   }
   
   private String generateString( int length )
   {
      final String uuid = UUID.randomUUID().toString().replaceAll( "-", "" );
      return uuid.substring( 0, length );
   }
}
