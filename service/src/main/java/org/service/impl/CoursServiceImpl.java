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
 * Fichier 		:	CoursServiceImpl.java
 * Créé le 		: 	7 sept. 2014 à 15:15:09
 * Auteur		: 	ryan
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */
package org.service.impl;

import java.util.List;

import org.dao.impl.CoursDaoImpl;
import org.exception.CoursException;
import org.model.Cours;
import org.service.CoursService;
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
 * @date    : 7 sept. 2014 15:15:09
 */
@Service("coursService")
public class CoursServiceImpl implements CoursService
{
  private static final Logger logger = LoggerFactory.getLogger( CoursServiceImpl.class );
   
   public CoursServiceImpl( String unit, String dbName )
   {
      super();
      coursDao = new CoursDaoImpl( unit, dbName );
   }
   
   //@Autowired
   private CoursDaoImpl coursDao = null;
   
   /**
    * @see org.service.CoursService#saveCours(org.model.Cours)
    */
   @Override
   public Cours saveCours( Cours cours ) throws CoursException
   {
      logger.info( "add Cours" );
      return coursDao.saveCours( cours );
   }
   
   /**
    * @see org.service.CoursService#updateCours(org.model.Cours)
    */
   @Override
   public Cours updateCours( Cours cours ) throws CoursException
   {
      logger.info( "update Cours" );
      return coursDao.updateCours( cours );
   }
   
   /**
    * @see org.service.CoursService#deleteCours(org.model.Cours)
    */
   @Override
   public void deleteCours( Cours cours ) throws CoursException
   {
      logger.info( "delete Cours" );
      coursDao.deleteCours( cours );
   }
   
   /**
    * @see org.service.CoursService#findById(java.lang.Integer)
    */
   @Override
   public Cours findById( Integer id ) throws CoursException
   {
      logger.info( "find by id Cours" );
      return coursDao.findById( id );
   }
   
   /**
    * @see org.service.CoursService#listCours()
    */
   @Override
   public List<Cours> listCours() throws CoursException
   {
      logger.info( "list Cours's" );
      return coursDao.listCours();
   }
}
