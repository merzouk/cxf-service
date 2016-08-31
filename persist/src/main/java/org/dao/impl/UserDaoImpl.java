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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dao.UserDao;
import org.dao.commons.IntPropertiesReader;
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
 * @project : javaJaxws
 * @package : org.dao.impl
 * @date    : 4 sept. 2014 10:40:15
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao
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
   
   //   private EntityManager getEntityManager()
   //   {
   //      Map<String, String> dbProps = new HashMap<String, String>();
   //      dbProps.put( "eclipselink.logging.level", appConf.get( "eclipselink.logging.level", "INFO" ).toString() );
   //      // On linux, the GSSAPI is not available. Use a default user/password  
   //      // pair to connect                                                      
   //      if( "Linux".equals( System.getProperty( "os.name" ) ) )
   //      {
   //         dbProps.put( "javax.persistence.jdbc.url", String.format( "jdbc:jtds:sqlserver://%s/%s", appConf.get( "db.host", "my-default-host" ), appConf.get( "db.database", "my-default-db" ) ) );
   //         dbProps.put( "javax.persistence.jdbc.driver", "net.sourceforge.jtds.jdbc.Driver" );
   //         dbProps.put( "javax.persistence.jdbc.password", appConf.get( "db.password" ).toString() );
   //         dbProps.put( "javax.persistence.jdbc.user", appConf.get( "db.user", "my-default-username" ).toString() );
   //      }
   //      else
   //      {
   //         dbProps.put( "javax.persistence.jdbc.url", String.format( "jdbc:sqlserver://%s;databaseName=%s;integratedSecurity=true", appConf.get( "db.host", "my-default-host" ), appConf.get( "db.database", "my-default-db" ) ) );
   //         dbProps.put( "javax.persistence.jdbc.driver", "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
   //      }
   //      appConf.flush();
   //      EntityManagerFactory fact = Persistence.createEntityManagerFactory( "myTestPU", dbProps );
   //      return fact.createEntityManager();
   //   }
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
