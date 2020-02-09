
package org.service;

import java.util.List;

import org.exception.InscriptionException;
import org.model.Inscription;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : persist
 * @package : org.dao
 * @date    : 7 sept. 2014 13:58:55
 */
public interface InscriptionService
{
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
   Inscription findById( Integer id ) throws InscriptionException;
   
   /**
    * 
    * @return
    * @throws InscriptionException
    */
   List<Inscription> listInscription() throws InscriptionException;
}
