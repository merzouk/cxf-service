/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : service
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
 * Fichier 		:	InscriptionServiceImpl.java
 * Créé le 		: 	7 sept. 2014 à 15:14:34
 * Auteur		: 	ryan
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */
package org.service.impl;

import java.util.List;

import org.dao.impl.InscriptionDaoImpl;
import org.exception.InscriptionException;
import org.model.Inscription;
import org.service.InscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : service
 * @package : org.service.impl
 * @date    : 7 sept. 2014 15:14:34
 */
@Service("inscriptionService")
public class InscriptionServiceImpl implements InscriptionService
{
private static final Logger logger = LoggerFactory.getLogger( InscriptionServiceImpl.class );
   
   public InscriptionServiceImpl( String unit, String dbName )
   {
      super();
      inscriptionDao = new InscriptionDaoImpl( unit, dbName );
   }
   
   //@Autowired
   private InscriptionDaoImpl inscriptionDao = null;
   
   /**
    * @see org.service.InscriptionService#saveInscription(org.model.Inscription)
    */
   @Override
   public Inscription saveInscription( Inscription inscription ) throws InscriptionException
   {
      logger.info( "add Inscription" );
      return inscriptionDao.saveInscription( inscription );
   }
   
   /**
    * @see org.service.InscriptionService#updateInscription(org.model.Inscription)
    */
   @Override
   public Inscription updateInscription( Inscription inscription ) throws InscriptionException
   {
      logger.info( "update Inscription" );
      return inscriptionDao.updateInscription( inscription );
   }
   
   /**
    * @see org.service.InscriptionService#deleteInscription(org.model.Inscription)
    */
   @Override
   public void deleteInscription( Inscription inscription ) throws InscriptionException
   {
      logger.info( "delete Inscription" );
      inscriptionDao.deleteInscription( inscription );
   }
   
   /**
    * @see org.service.InscriptionService#findById(java.lang.Integer)
    */
   @Override
   public Inscription findById( Integer id ) throws InscriptionException
   {
      logger.info( "find by id Inscription" );
      return inscriptionDao.findById( id );
   }
   
   /**
    * @see org.service.InscriptionService#listInscription()
    */
   @Override
   public List<Inscription> listInscription() throws InscriptionException
   {
      logger.info( "list Inscription's" );
      return inscriptionDao.listInscription();
   }
}
