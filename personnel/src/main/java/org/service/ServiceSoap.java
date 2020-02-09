package org.service;

import java.util.List;

import org.exception.AccountException;
import org.exception.CoursException;
import org.exception.InscriptionException;
import org.exception.UserException;
import org.model.Account;
import org.model.Cours;
import org.model.Inscription;
import org.model.User;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : cxfJaxws
 * @package : org.service
 * @date    : 6 sept. 2014 11:23:04
 */
public interface ServiceSoap
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
   Account findAccountById( Integer id ) throws AccountException;
   
   /**
    * 
    * @return
    * @throws AccountException
    */
   List<Account> listAccount() throws AccountException;
   
   /**
    * 
    * @param user
    * @throws UserException
    */
   User saveUser( User user ) throws UserException;
   
   /**
    * 
    * @param user
    * @return
    * @throws UserException
    */
   User updateUser( User user ) throws UserException;
   
   /**
    * 
    * @param user
    * @throws UserException
    */
   void deleteUser( User user ) throws UserException;
   
   /**
    * 
    * @param id
    * @return
    * @throws UserException
    */
   User findUserById( Integer id ) throws UserException;
   
   /**
    * 
    * @return
    * @throws UserException
    */
   List<User> listUser() throws UserException;
   
   /**
    * 
    * @param inscription
    * @throws InscriptionException
    */
   Inscription saveInscription( Inscription inscription ) throws InscriptionException;
   
   /**
    * 
    * @param inscription
    * @return
    * @throws InscriptionException
    */
   Inscription updateInscription( Inscription inscription ) throws InscriptionException;
   
   /**
    * 
    * @param inscription
    * @throws InscriptionException
    */
   void deleteInscription( Inscription inscription ) throws InscriptionException;
   
   /**
    * 
    * @param id
    * @return
    * @throws InscriptionException
    */
   Inscription findInscriptionById( Integer id ) throws InscriptionException;
   
   /**
    * 
    * @return
    * @throws InscriptionException
    */
   List<Inscription> listInscription() throws InscriptionException;
   
   /**
    * 
    * @param cours
    * @throws CoursException
    */
   Cours saveCours( Cours cours ) throws CoursException;
   
   /**
    * 
    * @param cours
    * @return
    * @throws CoursException
    */
   Cours updateCours( Cours cours ) throws CoursException;
   
   /**
    * 
    * @param cours
    * @throws CoursException
    */
   void deleteCours( Cours cours ) throws CoursException;
   
   /**
    * 
    * @param id
    * @return
    * @throws CoursException
    */
   Cours findCoursById( Integer id ) throws CoursException;
   
   /**
    * 
    * @return
    * @throws CoursException
    */
   List<Cours> listCours() throws CoursException;
}
