package org.service;

import java.util.UUID;

import org.junit.Test;
import org.model.User;
import org.service.impl.UserServiceImpl;
import org.utils.Constanes;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : personnel
 * @package : org.dao
 * @date    : 4 sept. 2014 13:20:54
 */
public class ServiceUserSaveTest
{
   private static UserService userService = null;
   
   @Test
   public void saveTest()
   {
      userService = new UserServiceImpl( Constanes.PERSISTENCE_UNIT_TEST, Constanes.DB_NAME_TEST );
      User user = new User();
      String uuid = generateString( 10 );
      user.setEmail( uuid + "@gmail.com" );
      user.setNom( "nom_" + 1 );
      user.setPrenom( "prenom_" + 1 );
      userService.saveUser( user );
   }
   
   private String generateString( int length )
   {
      final String uuid = UUID.randomUUID().toString().replaceAll( "-", "" );
      return uuid.substring( 0, 11 ).toUpperCase();
   }
}
