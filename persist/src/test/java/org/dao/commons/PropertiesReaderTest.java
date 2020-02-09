package org.dao.commons;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 *  A Renseigner.
 * 
 * @author  : ryan
 * @project : persist
 * @package : org.dao.commons
 * @date    : 4 sept. 2014 19:08:01
 */
public class PropertiesReaderTest
{
   private static Logger logger = LoggerFactory.getLogger( PropertiesReaderTest.class );
   
   @Before
   public void init()
   {
      logger.info( "init" );
      try
      {
      }
      catch( Exception e )
      {
         logger.error( "setUp  : ", e );
      }
   }
   
   @After
   public void destroy()
   {
      logger.info( "destroy" );
      try
      {
      }
      catch( Exception e )
      {
         logger.error( "setUp  : ", e );
      }
   }
   
   /**
    * @param args
    */
   @Test
   public void propertiesReaderTest()
   {
      logger.info( "propertiesReaderTest" );
      String loginValue = IntPropertiesReader.getValueByKey( IntPropertiesReader.USER );
      assertEquals( "root", loginValue );
      String passwordValue = IntPropertiesReader.getValueByKey( IntPropertiesReader.PASSWORD );
      assertEquals( "admin", passwordValue );
      String dialectValue = IntPropertiesReader.getValueByKey( IntPropertiesReader.DIALECT );
      assertEquals( "org.hibernate.dialect.MySQLDialect", dialectValue );
   }
}
