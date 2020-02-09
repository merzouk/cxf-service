
package org.service.impl;

import java.util.List;

import org.dao.impl.UserDaoImpl;
import org.exception.UserException;
import org.model.User;
import org.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : personnel
 * @package : org.service.impl
 * @date    : 4 sept. 2014 10:41:50
 */
@Service("userService")
public class UserServiceImpl implements UserService
{
   private static final Logger logger = LoggerFactory.getLogger( UserServiceImpl.class );
   
   public UserServiceImpl( String unit, String dbName )
   {
      super();
      userDao = new UserDaoImpl( unit , dbName);
   }
   
   //@Autowired
   private UserDaoImpl userDao = null;
   
   /**
    * @see org.service.UserService#saveUser(org.model.User)
    */
   @Override
   public User saveUser( User user ) throws UserException
   {
      logger.info( "add User" );
      return userDao.saveUser( user );
   }
   
   /**
    * @see org.service.UserService#updateUser(org.model.User)
    */
   @Override
   public User updateUser( User user ) throws UserException
   {
      logger.info( "update User" );
      return userDao.updateUser( user );
   }
   
   /**
    * @see org.service.UserService#deleteUser(org.model.User)
    */
   @Override
   public void deleteUser( User user ) throws UserException
   {
      logger.info( "delete User" );
      userDao.deleteUser( user );
   }
   
   /**
    * @see org.service.UserService#findById(java.lang.Integer)
    */
   @Override
   public User findById( Integer id ) throws UserException
   {
      logger.info( "find by id User" );
      return userDao.findById( id );
   }
   
   /**
    * @see org.service.UserService#listUser()
    */
   @Override
   public List<User> listUser() throws UserException
   {
      logger.info( "list User's" );
      return userDao.listUser();
   }
}
