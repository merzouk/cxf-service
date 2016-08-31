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
 * Fichier 		:	ClientLoadListTest.java
 * Créé le 		: 	4 sept. 2014 à 19:38:09
 * Auteur		: 	ryan
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.client;

import static org.junit.Assert.assertTrue;

import java.util.List;

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
 * @date    : 4 sept. 2014 19:38:09
 */
public class ClientLoadListTest
{
   private static final Logger logger       = LoggerFactory.getLogger( ClientLoadListTest.class );
   
   private static final QName  SERVICE_NAME = new QName( "http://service.ws.org/", "UserCxfSoapService" );
   
   private static final QName  PORT_NAME    = new QName( "http://service.ws.org/", "UserCxfSoapServicePort" );
   
   @Test
   public void listTest() throws Exception
   {
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
      logger.info( "Users: " );
      List<User> users = userCxfSoapService.getUsers();
      int size = users.size();
      assertTrue( size > 0 );
      for( User e : users )
      {
         logger.info( " id :  " + e.getId() + " Nom : " + e.getNom() + " Prenom : " + e.getPrenom() + "email :  " + e.getEmail() + "  date :  " + e.getDateNow() );
      }
      assertTrue( users.size() > 0 );
   }
}
