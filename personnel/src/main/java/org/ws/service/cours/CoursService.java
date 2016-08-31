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

package org.ws.service.cours;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.exception.CoursException;
import org.model.Cours;

/**
 * 
 * A Renseigner.
 * @author  : ryan
 * @project : javaJaxws
 * @package : org.server
 * @date    : 2 sept. 2014 23:07:26
 */
@WebService(targetNamespace = "http://cours.service.ws.org/", name = "CoursCxfSoapService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CoursService
{
   @WebMethod
   @WebResult(partName = "return")
   public Cours addCours( @WebParam(name = "cours", partName = "cours") Cours cours ) throws CoursException;
   
   @WebMethod
   @WebResult(partName = "return")
   public List<Cours> getCourss() throws CoursException;
   
   @WebMethod
   @WebResult(partName = "void")
   public void deleteCours( @WebParam(name = "cours", partName = "cours") Cours cours ) throws CoursException;
   
   @WebMethod
   @WebResult(partName = "return")
   public Cours updateCours( @WebParam(name = "cours", partName = "cours") Cours cours ) throws CoursException;
   
   @WebMethod
   @WebResult(partName = "return")
   public Cours findCoursById( @WebParam(name = "id", partName = "id") Integer id ) throws CoursException;
   
}