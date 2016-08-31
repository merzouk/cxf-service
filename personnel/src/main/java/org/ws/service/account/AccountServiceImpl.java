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

package org.ws.service.account;

import java.util.List;

import javax.jws.WebService;

import org.exception.AccountException;
import org.model.Account;
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
@WebService(endpointInterface = "org.ws.service.account.AccountService", serviceName = "AccountService")
public class AccountServiceImpl implements AccountService
{
   private static final Logger logger      = LoggerFactory.getLogger( AccountServiceImpl.class );
   
   private ServiceSoap         serviceSoap = null;
   
   @Override
   public Account addAccount( Account account ) throws AccountException
   {
      logger.info( "add Account called" );
      serviceSoap = new ServiceSoapImpl();
      return serviceSoap.saveAccount( account );
   }
   
   @Override
   public List<Account> getAccounts() throws AccountException
   {
      logger.info( "getAccounts called" );
      serviceSoap = new ServiceSoapImpl();
      return serviceSoap.listAccount();
   }
   
   @Override
   public void deleteAccount( Account account ) throws AccountException
   {
      logger.info( "deleteAccount called" );
      serviceSoap = new ServiceSoapImpl();
      serviceSoap.deleteAccount( account );
   }
   
   @Override
   public Account updateAccount( Account account ) throws AccountException
   {
      logger.info( "updateAccount called" );
      serviceSoap = new ServiceSoapImpl();
      return serviceSoap.updateAccount( account );
   }
   
   @Override
   public Account findAccountById( Integer id ) throws AccountException
   {
      logger.info( "find Account By Id called" );
      serviceSoap = new ServiceSoapImpl();
      return serviceSoap.findAccountById( id );
   }
}