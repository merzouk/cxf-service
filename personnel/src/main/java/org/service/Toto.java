/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : cxfJaxws
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
 * Fichier 		:	Toto.java
 * Créé le 		: 	7 sept. 2014 à 12:59:07
 * Auteur		: 	ryan
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */
package org.service;

import java.util.List;

import org.exception.CoursException;
import org.model.Cours;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : cxfJaxws
 * @package : org.service
 * @date    : 7 sept. 2014 12:59:07
 */
public interface Toto
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
   Cours findCoursById( Integer id ) throws CoursException;
   
   /**
    * 
    * @return
    * @throws CoursException
    */
   List<Cours> listCours() throws CoursException;
}
