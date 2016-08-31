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
// START SNIPPET: service

package org.ws.service.user;

import java.util.List;

import javax.jws.WebService;

import org.exception.AccountException;
import org.exception.UserException;
import org.model.Account;
import org.model.User;
import org.service.ServiceSoap;
import org.service.impl.ServiceSoapImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * A Renseigner.
 * @author  : ryan
 * @project : javaJaxws
 * @package : org.server
 * @date    : 2 sept. 2014 22:57:31
 */
@WebService(endpointInterface = "org.ws.service.user.UserService", serviceName = "UserService")
public class UserServiceImpl implements UserService
{
   private static final Logger logger      = LoggerFactory.getLogger( UserServiceImpl.class );
   
   private ServiceSoap         serviceSoap = null;
   
   @Override
   public User addUser( User user ) throws UserException
   {
      logger.info( "add User called" );
      serviceSoap = new ServiceSoapImpl();
      return serviceSoap.saveUser( user );
   }
   
   @Override
   public List<User> getUsers() throws UserException
   {
      logger.info( "get Users called" );
      serviceSoap = new ServiceSoapImpl();
      return serviceSoap.listUser();
   }
   
   @Override
   public void deleteUser( User user ) throws UserException
   {
      logger.info( "delete User called" );
      serviceSoap = new ServiceSoapImpl();
      serviceSoap.deleteUser( user );
   }
   
   @Override
   public User updateUser( User user ) throws UserException
   {
      logger.info( "update User called" );
      serviceSoap = new ServiceSoapImpl();
      return serviceSoap.updateUser( user );
   }
   
   @Override
   public User findUserById( Integer id ) throws UserException
   {
      logger.info( "findById User called" );
      serviceSoap = new ServiceSoapImpl();
      return serviceSoap.findUserById( id );
   }
   
   public Account addAccount( Account account ) throws AccountException
   {
      logger.info( "add Account called" );
      serviceSoap = new ServiceSoapImpl();
      return serviceSoap.saveAccount( account );
   }
}