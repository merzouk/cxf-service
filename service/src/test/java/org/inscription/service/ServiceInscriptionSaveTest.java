
package org.inscription.service;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.model.Inscription;
import org.service.InscriptionService;
import org.service.impl.InscriptionServiceImpl;
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
public class ServiceInscriptionSaveTest
{

   private static InscriptionService inscriptionService = null;
   
   @Test
   public void saveTest()
   {
      inscriptionService = new InscriptionServiceImpl( Constanes.PERSISTENCE_UNIT_TEST, Constanes.DB_NAME_TEST );
      Inscription inscription = new Inscription();
      String uuid = generateString( 10 );
      inscription.setCours( uuid );
      uuid = generateString( 10 );
      inscription.setEmail(uuid+"@yahoo.fr" );
      inscription.setDateDuJour( new Date() );
      inscriptionService.saveInscription( inscription );
   }
   
   private String generateString( int length )
   {
      final String uuid = UUID.randomUUID().toString().replaceAll( "-", "" );
      return uuid.substring( 0, 11 ).toUpperCase();
   }
}
