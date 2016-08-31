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

package org.ws.service.account;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.exception.AccountException;
import org.model.Account;

/**
 * 
 * A Renseigner.
 * @author  : ryan
 * @project : javaJaxws
 * @package : org.server
 * @date    : 2 sept. 2014 23:07:26
 */
@WebService(targetNamespace = "http://account.service.ws.org/", name = "AccountCxfSoapService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface AccountService
{
   
   @WebMethod
   @WebResult(partName = "return")
   public Account addAccount( @WebParam(name = "account", partName = "account") Account account ) throws AccountException;
   
   @WebMethod
   @WebResult(partName = "return")
   public List<Account> getAccounts() throws AccountException;
   
   @WebMethod
   @WebResult(partName = "void")
   public void deleteAccount( @WebParam(name = "account", partName = "account") Account account ) throws AccountException;
   
   @WebMethod
   @WebResult(partName = "return")
   public Account updateAccount( @WebParam(name = "account", partName = "account") Account account ) throws AccountException;
   
   @WebMethod
   @WebResult(partName = "return")
   public Account findAccountById( @WebParam(name = "id", partName = "id") Integer id ) throws AccountException;
   
}