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

package org.ws.service.cours;

import java.util.List;

import javax.jws.WebService;

import org.exception.CoursException;
import org.model.Cours;
import org.service.ServiceSoap;
import org.service.impl.ServiceSoapImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * A Renseigner.
 * @author  : ryan
 * @project : service
 * @package : org.server
 * @date    : 2 sept. 2014 22:57:31
 */
@WebService(endpointInterface = "org.ws.service.cours.CoursService", serviceName = "CoursService")
public class CoursServiceImpl implements CoursService
{
   private static final Logger logger      = LoggerFactory.getLogger( CoursServiceImpl.class );
   
   private ServiceSoap         serviceSoap = null;
   
   public Cours addCours( Cours inscription ) throws CoursException
   {
      logger.info( "add Cours called" );
      serviceSoap = new ServiceSoapImpl();
      return serviceSoap.saveCours( inscription );
   }
   
   public List<Cours> getCourss() throws CoursException
   {
      logger.info( "get Courss called" );
      serviceSoap = new ServiceSoapImpl();
      return serviceSoap.listCours();
   }
   
   @Override
   public void deleteCours( Cours inscription ) throws CoursException
   {
      logger.info( "delete Cours called" );
      serviceSoap = new ServiceSoapImpl();
      serviceSoap.deleteCours( inscription );
   }
   
   @Override
   public Cours updateCours( Cours inscription ) throws CoursException
   {
      logger.info( "update Cours called" );
      serviceSoap = new ServiceSoapImpl();
      return serviceSoap.updateCours( inscription );
   }
   
   @Override
   public Cours findCoursById( Integer id ) throws CoursException
   {
      logger.info( "findById Cours called" );
      serviceSoap = new ServiceSoapImpl();
      return serviceSoap.findCoursById( id );
   }
}