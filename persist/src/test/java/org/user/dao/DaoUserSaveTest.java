package org.user.dao;

import java.util.UUID;

import org.dao.UserDao;
import org.dao.impl.UserDaoImpl;
import org.junit.Test;
import org.model.User;
import org.utils.Constanes;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : persist
 * @package : org.dao
 * @date    : 4 sept. 2014 13:20:54
 */
public class DaoUserSaveTest
{
   private static UserDao userDao = null;
   
   @Test
   public void saveTest()
   {
      userDao = new UserDaoImpl( Constanes.PERSISTENCE_UNIT_TEST, Constanes.DB_NAME_TEST );
      User user = new User();
      String uuid = generateString( 10 );
      user.setEmail( uuid + "@gmail.com" );
      user.setNom( uuid );
      uuid = generateString( 10 );
      user.setPrenom( uuid );
      userDao.saveUser( user );
   }
   
   private String generateString( int length )
   {
      final String uuid = UUID.randomUUID().toString().replaceAll( "-", "" );
      return uuid.substring( 0, 11 ).toUpperCase();
   }
}
