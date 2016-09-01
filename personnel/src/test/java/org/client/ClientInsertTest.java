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

package org.client;

import java.util.Date;
import java.util.UUID;

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
 * A Renseigner.
 * @author  : ryan
 * @project : personnel
 * @package : org.client
 * @date    : 2 sept. 2014 23:13:20
 */
public final class ClientInsertTest
{
   private static final Logger logger       = LoggerFactory.getLogger( ClientInsertTest.class );
   
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
      String login = generateString( 11 );
      
      String nom = generateString( 11 );
      User user = new User( nom, login, login + "@gmail.com", new Date() );
      user = userCxfSoapService.addUser( user );
      logger.info( "" + user.toString() );
   }
   
   private String generateString( int length )
   {
      final String uuid = UUID.randomUUID().toString().replaceAll( "-", "" );
      return uuid.substring( 0, length );
   }
}
