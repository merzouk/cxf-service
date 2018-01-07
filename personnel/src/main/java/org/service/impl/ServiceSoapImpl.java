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
 * Fichier 		:	ServiceSoapImpl.java
 * Créé le 		: 	6 sept. 2014 à 11:25:33
 * Auteur		: 	ryan
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.service.impl;

import java.util.List;

import org.exception.AccountException;
import org.exception.CoursException;
import org.exception.InscriptionException;
import org.exception.UserException;
import org.model.Account;
import org.model.Cours;
import org.model.Inscription;
import org.model.User;
import org.service.ServiceSoap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.utils.Constanes;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : cxfJaxws
 * @package : org.service.impl
 * @date    : 6 sept. 2014 11:25:33
 */
public class ServiceSoapImpl implements ServiceSoap
{
   private static final Logger logger         = LoggerFactory.getLogger( ServiceSoapImpl.class );
   
   private AccountServiceImpl  accountService = null;
   
   /**
    * 
    * @see org.service.ServiceSoap#saveAccount(org.model.Account)
    */
   @Override
   public Account saveAccount( Account account ) throws AccountException
   {
      logger.info( "add Account called" );
      accountService = new AccountServiceImpl( Constanes.PERSISTENCE_UNIT, Constanes.DB_NAME );
      return accountService.saveAccount( account );
   }
   
   /**
    * 
    * @see org.service.ServiceSoap#listAccount()
    */
   public List<Account> listAccount() throws AccountException
   {
      logger.info( "get Accounts called" );
      accountService = new AccountServiceImpl( Constanes.PERSISTENCE_UNIT, Constanes.DB_NAME );
      return accountService.listAccount();
   }
   
   /**
    * 
    * @see org.service.ServiceSoap#deleteAccount(org.model.Account)
    */
   @Override
   public void deleteAccount( Account account ) throws AccountException
   {
      logger.info( "delete Account called" );
      accountService = new AccountServiceImpl( Constanes.PERSISTENCE_UNIT, Constanes.DB_NAME );
      accountService.deleteAccount( account );
   }
   
   /**
    * 
    * @see org.service.ServiceSoap#updateAccount(org.model.Account)
    */
   @Override
   public Account updateAccount( Account account ) throws AccountException
   {
      logger.info( "update Account called" );
      accountService = new AccountServiceImpl( Constanes.PERSISTENCE_UNIT, Constanes.DB_NAME );
      return accountService.updateAccount( account );
   }
   
   /**
    * 
    * @see org.service.ServiceSoap#findAccountById(java.lang.Integer)
    */
   @Override
   public Account findAccountById( Integer id ) throws AccountException
   {
      logger.info( "findById Account called" );
      accountService = new AccountServiceImpl( Constanes.PERSISTENCE_UNIT, Constanes.DB_NAME );
      return accountService.findById( id );
   }
   
   private UserServiceImpl userService = null;
   
   /**
    * 
    * @see org.service.ServiceSoap#saveUser(org.model.User)
    */
   @Override
   public User saveUser( User user ) throws UserException
   {
      logger.info( "add User called" );
      userService = new UserServiceImpl( Constanes.PERSISTENCE_UNIT, Constanes.DB_NAME );
      return userService.saveUser( user );
   }
   
   /**
    * 
    * @see org.service.ServiceSoap#listUser()
    */
   @Override
   public List<User> listUser() throws UserException
   {
      logger.info( "get Users called" );
      userService = new UserServiceImpl( Constanes.PERSISTENCE_UNIT, Constanes.DB_NAME );
      return userService.listUser();
   }
   
   /**
    * 
    * @see org.service.ServiceSoap#deleteUser(org.model.User)
    */
   @Override
   public void deleteUser( User user ) throws UserException
   {
      logger.info( "delete User called" );
      userService = new UserServiceImpl( Constanes.PERSISTENCE_UNIT, Constanes.DB_NAME );
      userService.deleteUser( user );
   }
   
   /**
    * 
    * @see org.service.ServiceSoap#updateUser(org.model.User)
    */
   @Override
   public User updateUser( User user ) throws UserException
   {
      logger.info( "update User called" );
      userService = new UserServiceImpl( Constanes.PERSISTENCE_UNIT, Constanes.DB_NAME );
      return userService.updateUser( user );
   }
   
   /**
    * 
    * @see org.service.ServiceSoap#findUserById(java.lang.Integer)
    */
   public User findUserById( Integer id ) throws UserException
   {
      logger.info( "findById User called" );
      userService = new UserServiceImpl( Constanes.PERSISTENCE_UNIT, Constanes.DB_NAME );
      return userService.findById( id );
   }
   
   /**
    * 
    * @see org.service.ServiceSoap#saveInscription(org.model.Inscription)
    */
   @Override
   public Inscription saveInscription( Inscription inscription ) throws InscriptionException
   {
      logger.info( "save Inscription called" );
      return null;
   }
   
   /**
    * 
    * @see org.service.ServiceSoap#updateInscription(org.model.Inscription)
    */
   @Override
   public Inscription updateInscription( Inscription inscription ) throws InscriptionException
   {
      logger.info( "update Inscription called" );
      return null;
   }
   
   /**
    * 
    * @see org.service.ServiceSoap#deleteInscription(org.model.Inscription)
    */
   @Override
   public void deleteInscription( Inscription inscription ) throws InscriptionException
   {
      logger.info( "delete Inscription called" );
   }
   
   /**
    * 
    * @see org.service.ServiceSoap#findInscriptionById(java.lang.Integer)
    */
   @Override
   public Inscription findInscriptionById( Integer id ) throws InscriptionException
   {
      logger.info( "find Inscription called" );
      return null;
   }
   
   /**
    * 
    * @see org.service.ServiceSoap#listInscription()
    */
   @Override
   public List<Inscription> listInscription() throws InscriptionException
   {
      logger.info( "listInscription called" );
      return null;
   }
   
   @Override
   public Cours saveCours( Cours cours ) throws CoursException
   {
      logger.info( "save Cours called" );
      return null;
   }
   
   @Override
   public Cours updateCours( Cours cours ) throws CoursException
   {
      logger.info( "update Cours called" );
      return null;
   }
   
   @Override
   public void deleteCours( Cours cours ) throws CoursException
   {
      logger.info( "delete Cours called" );
   }
   
   @Override
   public Cours findCoursById( Integer id ) throws CoursException
   {
      logger.info( "find Cours called" );
      return null;
   }
   
   @Override
   public List<Cours> listCours() throws CoursException
   {
      logger.info( "listCours called" );
      return null;
   }
}