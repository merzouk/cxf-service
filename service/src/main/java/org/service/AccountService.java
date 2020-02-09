
package org.service;

import java.util.List;

import org.exception.AccountException;
import org.model.Account;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : service
 * @package : org.service
 * @date    : 5 sept. 2014 20:45:16
 */
public interface AccountService
{
   /**
    * 
    * @param account
    * @throws AccountException
    */
   Account saveAccount( Account account ) throws AccountException;
   
   /**
    * 
    * @param account
    * @return
    * @throws AccountException
    */
   Account updateAccount( Account account ) throws AccountException;
   
   /**
    * 
    * @param account
    * @throws AccountException
    */
   void deleteAccount( Account account ) throws AccountException;
   
   /**
    * 
    * @param id
    * @return
    * @throws AccountException
    */
   Account findById( Integer id ) throws AccountException;
   
   /**
    * 
    * @return
    * @throws AccountException
    */
   List<Account> listAccount() throws AccountException;
}
