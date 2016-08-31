/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : javaJaxws
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
 * Fichier 		:	UserService.java
 * Créé le 		: 	4 sept. 2014 à 10:41:10
 * Auteur		: 	ryan
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.service;

import java.util.List;

import org.exception.UserException;
import org.model.User;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : javaJaxws
 * @package : org.service
 * @date    : 4 sept. 2014 10:41:10
 */
public interface UserService
{
   /**
    * 
    * @param user
    * @throws UserException
    */
   User saveUser( User user ) throws UserException;
   
   /**
    * 
    * @param user
    * @return
    * @throws UserException
    */
   User updateUser( User user ) throws UserException;
   
   /**
    * 
    * @param user
    * @throws UserException
    */
   void deleteUser( User user ) throws UserException;
   
   /**
    * 
    * @param id
    * @return
    * @throws UserException
    */
   User findById( Integer id ) throws UserException;
   
   /**
    * 
    * @return
    * @throws UserException
    */
   List<User> listUser() throws UserException;
}
