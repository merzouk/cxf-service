
package org.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.model.User;
import org.ws.service.user.UserServiceImpl;

/**
 * 
 * A Renseigner.
 * @author  : ryan
 * @project : personnel
 * @package : org.server
 * @date    : 2 sept. 2014 23:13:10
 */
public class UserCxfSoapServiceImplTest
{
   
   private String generateString( int length )
   {
      final String uuid = UUID.randomUUID().toString().replaceAll( "-", "" );
      return uuid.substring( 0, length );
   }
   @Test
   public void testSayHiToUser()
   {
      UserServiceImpl service = new UserServiceImpl();
      String login = generateString( 11 );
      String nom = generateString( 11 );
      User sam = new User( nom, login, login + "@gmail.com", new Date() );
      User response = service.addUser( sam );
      assertEquals( "addUser isn't returning expected string", nom, response.getNom() );
   }
   
   @Test
   public void testGetUsers()
   {
      UserServiceImpl userCxfSoapService = new UserServiceImpl();
      String login = generateString( 11 );
      String nom = generateString( 11 );
      User mike = new User( nom, login, login + "@gmail.com", new Date() );
      userCxfSoapService.addUser( mike );
      login = generateString( 11 );
      nom = generateString( 11 );
      User george = new User( nom, login, login + "@gmail.com", new Date() );
      userCxfSoapService.addUser( george );
      List<User> list = userCxfSoapService.getUsers();
      assertTrue( "getUsers() not returning expected number of users", list.size() > 0 );
      assertTrue( "Expected user Mike not found", list.get( 0 ).getNom() != null );
      assertTrue( "Expected user George not found", list.get( 1 ).getNom() != null );
   }
}
