package org.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.dao.CoursDao;
import org.entity.CoursEntity;
import org.exception.CoursException;
import org.model.Cours;
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
 * @date    : 7 sept. 2014 14:01:20
 */
@Repository("coursDao")
public class CoursDaoImpl extends GenericDao implements CoursDao
{
   private static final Logger logger = LoggerFactory.getLogger( CoursDaoImpl.class );
   
   /**
    * @param pERSISTENCE_UNIT_NAME
    */
   public CoursDaoImpl( String unit, String dbName )
   {
      super();
      PERSISTENCE_UNIT_NAME = unit;
      DB_NAME = dbName;
   }
   
   private String PERSISTENCE_UNIT_NAME = "";
   
   private String DB_NAME               = "";
   
   @Override
   public Cours saveCours( Cours cours ) throws CoursException
   {
      logger.info( "saveCours" );
      if( cours == null || cours.getCoursCode() == null || cours.getCoursCode().trim().length() <= 3 )
      {
         throw new CoursException( "Cours is requered" );
      }
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( cours.getId() == null )
      {
         CoursEntity entity = toEntity( cours );
         em.persist( entity );
         em.getTransaction().commit();
         em.close();
         return toModel( entity );
      }
      else
      {
         CoursEntity entity = toEntity( cours );
         entity = em.merge( entity );
         em.getTransaction().commit();
         em.close();
         return toModel( entity );
      }
   }
   
   /**
    * @see org.dao.CoursDao#updateCours(org.model.Cours)
    */
   @Override
   public Cours updateCours( Cours user ) throws CoursException
   {
      logger.info( "update Cours" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( user.getId() != null )
      {
         CoursEntity entity = toEntity( user );
         entity = em.merge( entity );
         em.getTransaction().commit();
         em.close();
         return toModel( entity );
      }
      else
      {
         em.close();
         throw new CoursException( "Id est non null" );
      }
   }
   
   /**
    * @see org.dao.CoursDao#deleteCours(org.model.Cours)
    */
   @Override
   public void deleteCours( Cours user ) throws CoursException
   {
      logger.info( "delete Cours" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( user.getId() != null )
      {
         CoursEntity entity = toEntity( user );
         entity = em.merge( entity );
         em.remove( entity );
         em.getTransaction().commit();
         em.close();
      }
      else
      {
         em.close();
         throw new CoursException( "Id est non null" );
      }
   }
   
   /**
    * @see org.dao.CoursDao#findById(java.lang.Integer)
    */
   @Override
   public Cours findById( Integer id ) throws CoursException
   {
      logger.info( "findById Cours" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      CoursEntity entity = em.find( CoursEntity.class, id );
      em.close();
      return toModel( entity );
   }
   
   /**
    * @see org.dao.CoursDao#listCours()
    */
   @SuppressWarnings("unchecked")
   @Override
   public List<Cours> listCours() throws CoursException
   {
      logger.info( "list Cours's" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      List<CoursEntity> list = em.createQuery( "select a from Cours a" ).getResultList();
      em.close();
      return toListModel( list );
   }
   
   private CoursEntity toEntity( Cours cours )
   {
      CoursEntity entity = new CoursEntity();
      entity.setCoursCode(  cours.getCoursCode() );
      if( cours.getId() != null && cours.getId().intValue() > 0 )
      {
         entity.setId( cours.getId() );
      }
      return entity;
   }
   
   private Cours toModel( CoursEntity entity )
   {
      Cours model = new Cours();
      model.setCoursCode( entity.getCoursCode() );
      model.setId( entity.getId() );
      return model;
   }
   
   private List<Cours> toListModel( List<CoursEntity> entities )
   {
      List<Cours> models = new ArrayList<Cours>();
      for( CoursEntity entity : entities )
      {
         models.add( toModel( entity ) );
      }
      return models;
   }
}
