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
 * Fichier 		:	AccountService.java
 * Créé le 		: 	5 sept. 2014 à 20:45:16
 * Auteur		: 	ryan
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */
package org.service;

import java.util.List;

import org.exception.AccountException;
import org.model.Account;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : service
 * @package : org.service
 * @date    : 5 sept. 2014 20:45:16
 */
public interface AccountService
{
   /**
    * 
    * @param account
    * @throws AccountException
    */
   Account saveAccount( Account account ) throws AccountException;
   
   /**
    * 
    * @param account
    * @return
    * @throws AccountException
    */
   Account updateAccount( Account account ) throws AccountException;
   
   /**
    * 
    * @param account
    * @throws AccountException
    */
   void deleteAccount( Account account ) throws AccountException;
   
   /**
    * 
    * @param id
    * @return
    * @throws AccountException
    */
   Account findById( Integer id ) throws AccountException;
   
   /**
    * 
    * @return
    * @throws AccountException
    */
   List<Account> listAccount() throws AccountException;
}
