package org.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.dao.InscriptionDao;
import org.entity.InscriptionEntity;
import org.exception.InscriptionException;
import org.model.Inscription;
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
 * @date    : 7 sept. 2014 14:05:58
 */
@Repository("inscriptionDao")
public class InscriptionDaoImpl extends GenericDao  implements InscriptionDao
{
 private static final Logger logger = LoggerFactory.getLogger( InscriptionDaoImpl.class );
   
   /**
    * @param pERSISTENCE_UNIT_NAME
    */
   public InscriptionDaoImpl( String unit, String dbName )
   {
      super();
      PERSISTENCE_UNIT_NAME = unit;
      DB_NAME = dbName;
   }
   
   private String PERSISTENCE_UNIT_NAME = "";
   
   private String DB_NAME               = "";
   
   @Override
   public Inscription saveInscription( Inscription inscription ) throws InscriptionException
   {
      logger.info( "saveInscription" );
      if( inscription == null || inscription.getCours() == null || inscription.getEmail() == null )
      {
         throw new InscriptionException( "Nom and Prenom is requered" );
      }
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( inscription.getId() == null )
      {
         InscriptionEntity entity = toEntity( inscription );
         Date dateNow = new Date();
         entity.setDateDuJour( dateNow );
         em.persist( entity );
         em.getTransaction().commit();
         em.close();
         return toModel( entity );
      }
      else
      {
         InscriptionEntity entity = toEntity( inscription );
         Date dateNow = new Date();
         entity.setDateDuJour( dateNow );
         entity = em.merge( entity );
         em.getTransaction().commit();
         em.close();
         return toModel( entity );
      }
   }
   
   /**
    * @see org.dao.InscriptionDao#updateInscription(org.model.Inscription)
    */
   @Override
   public Inscription updateInscription( Inscription inscription ) throws InscriptionException
   {
      logger.info( "update Inscription" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( inscription.getId() != null )
      {
         InscriptionEntity entity = toEntity( inscription );
         Date dateNow = new Date();
         entity.setDateDuJour( dateNow );
         entity = em.merge( entity );
         em.getTransaction().commit();
         em.close();
         return toModel( entity );
      }
      else
      {
         em.close();
         throw new InscriptionException( "Id est non null" );
      }
   }
   
   /**
    * @see org.dao.InscriptionDao#deleteInscription(org.model.Inscription)
    */
   @Override
   public void deleteInscription( Inscription inscription ) throws InscriptionException
   {
      logger.info( "delete Inscription" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( inscription.getId() != null )
      {
         InscriptionEntity entity = toEntity( inscription );
         entity = em.merge( entity );
         em.remove( entity );
         em.getTransaction().commit();
         em.close();
      }
      else
      {
         em.close();
         throw new InscriptionException( "Id est non null" );
      }
   }
   
   /**
    * @see org.dao.InscriptionDao#findById(java.lang.Integer)
    */
   @Override
   public Inscription findById( Integer id ) throws InscriptionException
   {
      logger.info( "findById Inscription" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      InscriptionEntity entity = em.find( InscriptionEntity.class, id );
      em.close();
      return toModel( entity );
   }
   
   /**
    * @see org.dao.InscriptionDao#listInscription()
    */
   @SuppressWarnings("unchecked")
   @Override
   public List<Inscription> listInscription() throws InscriptionException
   {
      logger.info( "list Inscription's" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      List<InscriptionEntity> list = em.createQuery( "select a from Inscription a" ).getResultList();
      em.close();
      return toListModel( list );
   }
   
   private InscriptionEntity toEntity( Inscription model )
   {
      InscriptionEntity entity = new InscriptionEntity();
      entity.setCours( model.getCours() );
      entity.setDateDuJour( model.getDateDuJour() );
      entity.setEmail( model.getEmail() );
     
      if( model.getId() != null && model.getId().intValue() > 0 )
      {
         entity.setId( model.getId() );
      }
      return entity;
   }
   
   private Inscription toModel( InscriptionEntity entity )
   {
      Inscription model = new Inscription();
      model.setCours( entity.getCours() );
      model.setDateDuJour( entity.getDateDuJour() );
      model.setId( entity.getId() );
      model.setEmail( entity.getEmail() );
      return model;
   }
   
   private List<Inscription> toListModel( List<InscriptionEntity> entities )
   {
      List<Inscription> models = new ArrayList<Inscription>();
      for( InscriptionEntity entity : entities )
      {
         models.add( toModel( entity ) );
      }
      return models;
   }
}
