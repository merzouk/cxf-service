/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : persist
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
 * Fichier 		:	UUIDTest.java
 * Créé le 		: 	4 sept. 2014 à 15:04:44
 * Auteur		: 	ryan
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

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
