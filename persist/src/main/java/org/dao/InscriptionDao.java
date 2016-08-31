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
 * Fichier 		:	InscriptionDao.java
 * Créé le 		: 	7 sept. 2014 à 13:58:55
 * Auteur		: 	ryan
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */
package org.dao;

import java.util.List;

import org.exception.InscriptionException;
import org.model.Inscription;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : persist
 * @package : org.dao
 * @date    : 7 sept. 2014 13:58:55
 */
public interface InscriptionDao
{
   /**
    * 
    * @param inscription
    * @throws InscriptionException
    */
   Inscription saveInscription( Inscription inscription ) throws InscriptionException;
   
   /**
    * 
    * @param inscription
    * @return
    * @throws InscriptionException
    */
   Inscription updateInscription( Inscription inscription ) throws InscriptionException;
   
   /**
    * 
    * @param inscription
    * @throws InscriptionException
    */
   void deleteInscription( Inscription inscription ) throws InscriptionException;
   
   /**
    * 
    * @param id
    * @return
    * @throws InscriptionException
    */
   Inscription findById( Integer id ) throws InscriptionException;
   
   /**
    * 
    * @return
    * @throws InscriptionException
    */
   List<Inscription> listInscription() throws InscriptionException;
}
