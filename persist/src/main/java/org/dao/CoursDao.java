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
 * Fichier 		:	CoursDao.java
 * Créé le 		: 	7 sept. 2014 à 13:58:41
 * Auteur		: 	ryan
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */
package org.dao;

import java.util.List;

import org.exception.CoursException;
import org.model.Cours;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : persist
 * @package : org.dao
 * @date    : 7 sept. 2014 13:58:41
 */
public interface CoursDao
{
   /**
    * 
    * @param cours
    * @throws CoursException
    */
   Cours saveCours( Cours cours ) throws CoursException;
   
   /**
    * 
    * @param cours
    * @return
    * @throws CoursException
    */
   Cours updateCours( Cours cours ) throws CoursException;
   
   /**
    * 
    * @param cours
    * @throws CoursException
    */
   void deleteCours( Cours cours ) throws CoursException;
   
   /**
    * 
    * @param id
    * @return
    * @throws CoursException
    */
   Cours findById( Integer id ) throws CoursException;
   
   /**
    * 
    * @return
    * @throws CoursException
    */
   List<Cours> listCours() throws CoursException;
}
