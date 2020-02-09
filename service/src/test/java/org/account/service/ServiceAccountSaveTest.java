package org.account.service;

import java.util.UUID;

import org.junit.Test;
import org.model.Account;
import org.service.AccountService;
import org.service.impl.AccountServiceImpl;
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
public class ServiceAccountSaveTest
{
   private static AccountService accountService = null;
   
   @Test
   public void saveTest()
   {
      accountService = new AccountServiceImpl( Constanes.PERSISTENCE_UNIT_TEST, Constanes.DB_NAME_TEST );
      Account account = new Account();
      String uuid = generateString( 10 );
      account.setPassword( uuid );
      uuid = generateString( 10 );
      account.setLogin( uuid );
      accountService.saveAccount( account );
   }
   
   private String generateString( int length )
   {
      final String uuid = UUID.randomUUID().toString().replaceAll( "-", "" );
      return uuid.substring( 0, 11 ).toUpperCase();
   }
}
