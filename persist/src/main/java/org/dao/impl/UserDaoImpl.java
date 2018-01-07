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
 * Fichier 		:	UserDaoImpl.java
 * Créé le 		: 	4 sept. 2014 à 10:40:15
 * Auteur		: 	ryan
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.dao.UserDao;
import org.entity.UserEntity;
import org.exception.UserException;
import org.model.User;
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
 * @date    : 4 sept. 2014 10:40:15
 */
@Repository("userDao")
public class UserDaoImpl extends GenericDao  implements UserDao
{
   private static final Logger logger = LoggerFactory.getLogger( UserDaoImpl.class );
   
   /**
    * @param pERSISTENCE_UNIT_NAME
    */
   public UserDaoImpl( String unit, String dbName )
   {
      super();
      PERSISTENCE_UNIT_NAME = unit;
      DB_NAME = dbName;
   }
   
   private String PERSISTENCE_UNIT_NAME = "";
   
   private String DB_NAME               = "";
   
   /**
    * @see org.dao.UserDao#saveUser(org.model.User)
    */
   @Override
   public User saveUser( User user ) throws UserException
   {
      logger.info( "saveUser" );
      if( user == null || user.getNom() == null || user.getPrenom() == null )
      {
         throw new UserException( "Nom and Prenom is requered" );
      }
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( user.getId() == null )
      {
         UserEntity entity = toEntity( user );
         Date dateNow = new Date();
         entity.setDateNow( dateNow );
         em.persist( entity );
         em.getTransaction().commit();
         em.close();
         return toModel( entity );
      }
      else
      {
         UserEntity entity = toEntity( user );
         Date dateNow = new Date();
         entity.setDateNow( dateNow );
         entity = em.merge( entity );
         em.getTransaction().commit();
         em.close();
         return toModel( entity );
      }
   }
   
   /**
    * @see org.dao.UserDao#updateUser(org.model.User)
    */
   @Override
   public User updateUser( User user ) throws UserException
   {
      logger.info( "update User" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( user.getId() != null )
      {
         UserEntity entity = toEntity( user );
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
         throw new UserException( "Id est non null" );
      }
   }
   
   /**
    * @see org.dao.UserDao#deleteUser(org.model.User)
    */
   @Override
   public void deleteUser( User user ) throws UserException
   {
      logger.info( "delete User" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( user.getId() != null )
      {
         UserEntity entity = toEntity( user );
         entity = em.merge( entity );
         em.remove( entity );
         em.getTransaction().commit();
         em.close();
      }
      else
      {
         em.close();
         throw new UserException( "Id est non null" );
      }
   }
   
   /**
    * @see org.dao.UserDao#findById(java.lang.Integer)
    */
   @Override
   public User findById( Integer id ) throws UserException
   {
      logger.info( "findById User" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      UserEntity entity = em.find( UserEntity.class, id );
      em.close();
      return toModel( entity );
   }
   
   /**
    * @see org.dao.UserDao#listUser()
    */
   @SuppressWarnings("unchecked")
   @Override
   public List<User> listUser() throws UserException
   {
      logger.info( "list User's" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      List<UserEntity> list = em.createQuery( "select u from User u" ).getResultList();
      em.close();
      return toListModel( list );
   }
   
   private UserEntity toEntity( User user )
   {
      UserEntity entity = new UserEntity();
      entity.setNom( user.getNom() );
      entity.setPrenom( user.getPrenom() );
      entity.setEmail( user.getEmail() );
      if( user.getId() != null && user.getId().intValue() > 0 )
      {
         entity.setId( user.getId() );
      }
      entity.setDateNow( user.getDateNow() );
      return entity;
   }
   
   private User toModel( UserEntity entity )
   {
      User model = new User();
      model.setNom( entity.getNom() );
      model.setPrenom( entity.getPrenom() );
      model.setEmail( entity.getEmail() );
      model.setId( entity.getId() );
      model.setDateNow( entity.getDateNow() );
      return model;
   }
   
   private List<User> toListModel( List<UserEntity> entities )
   {
      List<User> models = new ArrayList<User>();
      for( UserEntity entity : entities )
      {
         models.add( toModel( entity ) );
      }
      return models;
   }
}
