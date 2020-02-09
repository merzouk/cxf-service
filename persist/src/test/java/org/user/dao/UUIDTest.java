package org.user.dao;

import java.util.UUID;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : persist
 * @package : org.dao
 * @date    : 4 sept. 2014 15:04:44
 */
public class UUIDTest
{
   public static void main( String[] args )
   {
      final String uuid = UUID.randomUUID().toString().replaceAll( "-", "" );
      System.out.println( "uuid = " + uuid );
   }
}
