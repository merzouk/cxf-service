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
 * Fichier 		:	AccountServiceImpl.java
 * Créé le 		: 	5 sept. 2014 à 20:46:11
 * Auteur		: 	ryan
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.service.impl;

import java.util.List;

import org.dao.impl.AccountDaoImpl;
import org.exception.AccountException;
import org.model.Account;
import org.service.AccountService;
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
 * @date    : 5 sept. 2014 20:46:11
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService
{
   private static final Logger logger = LoggerFactory.getLogger( AccountServiceImpl.class );
   
   public AccountServiceImpl( String unit, String dbName )
   {
      super();
      accountDao = new AccountDaoImpl( unit, dbName );
   }
   
   //@Autowired
   private AccountDaoImpl accountDao = null;
   
   /**
    * @see org.service.AccountService#saveAccount(org.model.Account)
    */
   @Override
   public Account saveAccount( Account account ) throws AccountException
   {
      logger.info( "add Account" );
      return accountDao.saveAccount( account );
   }
   
   /**
    * @see org.service.AccountService#updateAccount(org.model.Account)
    */
   @Override
   public Account updateAccount( Account account ) throws AccountException
   {
      logger.info( "update Account" );
      return accountDao.updateAccount( account );
   }
   
   /**
    * @see org.service.AccountService#deleteAccount(org.model.Account)
    */
   @Override
   public void deleteAccount( Account account ) throws AccountException
   {
      logger.info( "delete Account" );
      accountDao.deleteAccount( account );
   }
   
   /**
    * @see org.service.AccountService#findById(java.lang.Integer)
    */
   @Override
   public Account findById( Integer id ) throws AccountException
   {
      logger.info( "find by id Account" );
      return accountDao.findById( id );
   }
   
   /**
    * @see org.service.AccountService#listAccount()
    */
   @Override
   public List<Account> listAccount() throws AccountException
   {
      logger.info( "list Account's" );
      return accountDao.listAccount();
   }
}
