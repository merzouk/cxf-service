package org.inscription.dao;

import java.util.Date;
import java.util.UUID;

import org.dao.InscriptionDao;
import org.dao.impl.InscriptionDaoImpl;
import org.junit.Test;
import org.model.Inscription;
import org.utils.Constanes;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : persist
 * @package : org.inscription.dao
 * @date    : 7 sept. 2014 15:07:46
 */
public class DaoInscriptionSaveTest
{

   private static InscriptionDao inscriptionDao = null;
   
   @Test
   public void saveTest()
   {
      inscriptionDao = new InscriptionDaoImpl( Constanes.PERSISTENCE_UNIT_TEST, Constanes.DB_NAME_TEST );
      Inscription inscription = new Inscription();
      String uuid = generateString( 10 );
      inscription.setCours( uuid );
      uuid = generateString( 10 );
      inscription.setEmail(uuid+"@yahoo.fr" );
      inscription.setDateDuJour( new Date() );
      inscriptionDao.saveInscription( inscription );
   }
   
   private String generateString( int length )
   {
      final String uuid = UUID.randomUUID().toString().replaceAll( "-", "" );
      return uuid.substring( 0, 11 ).toUpperCase();
   }
}
