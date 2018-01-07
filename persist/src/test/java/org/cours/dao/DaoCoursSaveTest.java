/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : persist
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
 * Fichier 		:	DaoCoursSaveTest.java
 * Créé le 		: 	7 sept. 2014 à 14:56:02
 * Auteur		: 	ryan
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */
package org.cours.dao;

import java.util.UUID;

import org.dao.CoursDao;
import org.dao.impl.CoursDaoImpl;
import org.junit.Test;
import org.model.Cours;
import org.utils.Constanes;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : persist
 * @package : org.cours.dao
 * @date    : 7 sept. 2014 14:56:02
 */
public class DaoCoursSaveTest
{
 private static CoursDao coursDao = null;
   
   @Test
   public void saveTest()
   {
      coursDao = new CoursDaoImpl( Constanes.PERSISTENCE_UNIT_TEST, Constanes.DB_NAME_TEST );
      Cours cours = new Cours();
      String uuid = generateString( 10 );
      cours.setCoursCode( uuid );
      uuid = generateString( 10 );
      coursDao.saveCours( cours );
   }
   
   private String generateString( int length )
   {
      final String uuid = UUID.randomUUID().toString().replaceAll( "-", "" );
      return uuid.substring( 0, 11 ).toUpperCase();
   }
}
