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
 * Fichier 		:	AccountSaveTest.java
 * Créé le 		: 	4 sept. 2014 à 13:20:54
 * Auteur		: 	ryan
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.account.dao;

import java.util.UUID;

import org.dao.AccountDao;
import org.dao.impl.AccountDaoImpl;
import org.junit.Test;
import org.model.Account;
import org.utils.Constanes;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : javaJaxws
 * @package : org.dao
 * @date    : 4 sept. 2014 13:20:54
 */
public class DaoAccountSaveTest
{
   private static AccountDao accountDao = null;
   
   @Test
   public void saveTest()
   {
      accountDao = new AccountDaoImpl( Constanes.PERSISTENCE_UNIT_TEST, Constanes.DB_NAME_TEST );
      Account account = new Account();
      String uuid = generateString( 10 );
      account.setPassword( uuid );
      uuid = generateString( 10 );
      account.setLogin( uuid );
      accountDao.saveAccount( account );
   }
   
   private String generateString( int length )
   {
      final String uuid = UUID.randomUUID().toString().replaceAll( "-", "" );
      return uuid.substring( 0, 11 ).toUpperCase();
   }
}
