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

package org.ws.service.user;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.exception.UserException;
import org.model.User;

/**
 * 
 * A Renseigner.
 * @author  : ryan
 * @project : personnel
 * @package : org.server
 * @date    : 2 sept. 2014 23:07:26
 */
@WebService(targetNamespace = "http://user.service.ws.org/", name = "UserService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserService
{
   @WebMethod
   @WebResult(partName = "return")
   public User addUser( @WebParam(name = "user", partName = "user") User user ) throws UserException;
   
   @WebMethod
   @WebResult(partName = "return")
   public List<User> getUsers() throws UserException;
   
   @WebMethod
   @WebResult(partName = "void")
   public void deleteUser( @WebParam(name = "user", partName = "user") User user ) throws UserException;
   
   @WebMethod
   @WebResult(partName = "return")
   public User updateUser( @WebParam(name = "user", partName = "user") User user ) throws UserException;
   
   @WebMethod
   @WebResult(partName = "return")
   public User findUserById( @WebParam(name = "id", partName = "id") Integer id ) throws UserException;
}