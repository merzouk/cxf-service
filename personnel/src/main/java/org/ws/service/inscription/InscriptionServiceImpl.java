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

package org.ws.service.inscription;

import java.util.List;

import javax.jws.WebService;

import org.exception.InscriptionException;
import org.model.Inscription;
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
@WebService(endpointInterface = "org.ws.service.inscription.InscriptionService", serviceName = "InscriptionService")
public class InscriptionServiceImpl implements InscriptionService
{
   private static final Logger logger      = LoggerFactory.getLogger( InscriptionServiceImpl.class );
   
   private ServiceSoap         serviceSoap = null;
   
   public Inscription addInscription( Inscription inscription ) throws InscriptionException
   {
      logger.info( "add Inscription called" );
      serviceSoap = new ServiceSoapImpl();
      return serviceSoap.saveInscription( inscription );
   }
   
   public List<Inscription> getInscriptions() throws InscriptionException
   {
      logger.info( "get Inscriptions called" );
      serviceSoap = new ServiceSoapImpl();
      return serviceSoap.listInscription();
   }
   
   @Override
   public void deleteInscription( Inscription inscription ) throws InscriptionException
   {
      logger.info( "delete Inscription called" );
      serviceSoap = new ServiceSoapImpl();
      serviceSoap.deleteInscription( inscription );
   }
   
   @Override
   public Inscription updateInscription( Inscription inscription ) throws InscriptionException
   {
      logger.info( "update Inscription called" );
      serviceSoap = new ServiceSoapImpl();
      return serviceSoap.updateInscription( inscription );
   }
   
   @Override
   public Inscription findInscriptionById( Integer id ) throws InscriptionException
   {
      logger.info( "findById Inscription called" );
      serviceSoap = new ServiceSoapImpl();
      return serviceSoap.findInscriptionById( id );
   }
}