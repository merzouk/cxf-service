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
 * Fichier 		:	AccountDaoImpl.java
 * Créé le 		: 	5 sept. 2014 à 20:32:47
 * Auteur		: 	ryan
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dao.AccountDao;
import org.dao.commons.IntPropertiesReader;
import org.entity.AccountEntity;
import org.exception.AccountException;
import org.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : persist
 * @package : org.dao.impl
 * @date    : 5 sept. 2014 20:32:47
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao
{
   private static final Logger logger = LoggerFactory.getLogger( AccountDaoImpl.class );
   
   /**
    * @param pERSISTENCE_UNIT_NAME
    */
   public AccountDaoImpl( String unit, String dbName )
   {
      super();
      PERSISTENCE_UNIT_NAME = unit;
      DB_NAME = dbName;
   }
   
   private String PERSISTENCE_UNIT_NAME = "";
   
   private String DB_NAME               = "";
   
   @Override
   public Account saveAccount( Account account ) throws AccountException
   {
      logger.info( "saveAccount" );
      if( account == null || account.getLogin() == null || account.getPassword() == null )
      {
         throw new AccountException( "Nom and Prenom is requered" );
      }
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( account.getId() == null )
      {
         AccountEntity entity = toEntity( account );
         Date dateNow = new Date();
         entity.setDateNow( dateNow );
         em.persist( entity );
         em.getTransaction().commit();
         em.close();
         return toModel( entity );
      }
      else
      {
         AccountEntity entity = toEntity( account );
         Date dateNow = new Date();
         entity.setDateNow( dateNow );
         entity = em.merge( entity );
         em.getTransaction().commit();
         em.close();
         return toModel( entity );
      }
   }
   
   /**
    * @see org.dao.AccountDao#updateAccount(org.model.Account)
    */
   @Override
   public Account updateAccount( Account account ) throws AccountException
   {
      logger.info( "update Account" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( account.getId() != null )
      {
         AccountEntity entity = toEntity( account );
         Date dateNow = new Date();
         entity.setDateNow( dateNow );
         entity = em.merge( entity );
         em.getTransaction().commit();
         em.close();
         return toModel( entity );
      }
      else
      {
         em.close();
         throw new AccountException( "Id est non null" );
      }
   }
   
   /**
    * @see org.dao.AccountDao#deleteAccount(org.model.Account)
    */
   @Override
   public void deleteAccount( Account account ) throws AccountException
   {
      logger.info( "delete Account" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( account.getId() != null )
      {
         AccountEntity entity = toEntity( account );
         entity = em.merge( entity );
         em.remove( entity );
         em.getTransaction().commit();
         em.close();
      }
      else
      {
         em.close();
         throw new AccountException( "Id est non null" );
      }
   }
   
   /**
    * @see org.dao.AccountDao#findById(java.lang.Integer)
    */
   @Override
   public Account findById( Integer id ) throws AccountException
   {
      logger.info( "findById Account" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      AccountEntity entity = em.find( AccountEntity.class, id );
      em.close();
      return toModel( entity );
   }
   
   /**
    * @see org.dao.AccountDao#listAccount()
    */
   @SuppressWarnings("unchecked")
   @Override
   public List<Account> listAccount() throws AccountException
   {
      logger.info( "list Account's" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      List<AccountEntity> list = em.createQuery( "select a from Account a" ).getResultList();
      em.close();
      return toListModel( list );
   }
   
   private AccountEntity toEntity( Account account )
   {
      AccountEntity entity = new AccountEntity();
      entity.setLogin( account.getLogin() );
      entity.setPassword( account.getPassword() );
     
      if( account.getId() != null && account.getId().intValue() > 0 )
      {
         entity.setId( account.getId() );
      }
      entity.setDateNow( account.getDateNow() );
      return entity;
   }
   
   private Account toModel( AccountEntity entity )
   {
      Account model = new Account();
      model.setLogin( entity.getLogin() );
      model.setPassword( entity.getPassword() );
      model.setId( entity.getId() );
      model.setDateNow( entity.getDateNow() );
      return model;
   }
   
   private List<Account> toListModel( List<AccountEntity> entities )
   {
      List<Account> models = new ArrayList<Account>();
      for( AccountEntity entity : entities )
      {
         models.add( toModel( entity ) );
      }
      return models;
   }
   /**
    * 
    * @param persistenceUnitName
    * @return
    */
   private EntityManager getEntityManager( String persistenceUnitName, String dataBaseName )
   {
      Map<String, String> properties = new HashMap<String, String>();
      properties.put( "javax.persistence.jdbc.user", IntPropertiesReader.getValueByKey( IntPropertiesReader.USER ) );
      properties.put( "javax.persistence.jdbc.password", IntPropertiesReader.getValueByKey( IntPropertiesReader.PASSWORD ) );
      properties.put( "javax.persistence.jdbc.url", IntPropertiesReader.getValueByKey( IntPropertiesReader.JDBC ) + "/" + dataBaseName );
      properties.put( "javax.persistence.jdbc.driver", IntPropertiesReader.getValueByKey( IntPropertiesReader.DRIVER ) );
      properties.put( "hibernate.dialect", IntPropertiesReader.getValueByKey( IntPropertiesReader.DIALECT ) );
      properties.put( "eclipselink.jdbc.exclusive-connection.mode", IntPropertiesReader.getValueByKey( IntPropertiesReader.TRASACTIONAL ) );
      properties.put( "eclipselink.jdbc.exclusive-connection.is-lazy", IntPropertiesReader.getValueByKey( IntPropertiesReader.ISLAZY ) );
      EntityManagerFactory emf = Persistence.createEntityManagerFactory( persistenceUnitName, properties );
      EntityManager em = emf.createEntityManager();
      return em;
   }
}
