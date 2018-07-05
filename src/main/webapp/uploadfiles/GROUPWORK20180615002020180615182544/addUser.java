/**
 * newssluser.java
 * 5 July 2001
 * December 2004 
 * Updated for Win2K3 Password complexity and to use TLS during password set
 * February 2005
 * Changed to use SSL instead of TLS
 *
 * Sample JNDI application that creates a new user in the Active Directory.
 * 
 */

import java.util.Hashtable;
import javax.naming.*;
import javax.naming.ldap.*;
import javax.naming.directory.*;
import javax.net.ssl.*;
import java.io.*;

public class newssluser
{
     public static void main (String[] args)
     {
     
          Hashtable env = new Hashtable();
          String adminName = "CN=Administrator,CN=Users,DC=antipodes,DC=com";
          String adminPassword = "XXXXXX";
          String ldapURL = "ldaps://mydc.antipodes.com:636";
          String userName = "CN=Benjamin Franklin,OU=Research,DC=antipodes,DC=com";
          String newPassword = "Password123";
          String groupName = "CN=All Research,OU=Research,DC=antipodes,DC=com";
          
          env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
     
          //Access the truststore 
          String keystore = "/usr/java/jdk1.5.0_01/jre/lib/security/cacerts";
          System.setProperty("javax.net.ssl.trustStore",keystore);
          
          //set security credentials, note using simple cleartext authentication
          env.put(Context.SECURITY_AUTHENTICATION,"simple");
          env.put(Context.SECURITY_PRINCIPAL,adminName);
          env.put(Context.SECURITY_CREDENTIALS,adminPassword);

          //specify the use of SSL
          env.put(Context.SECURITY_PROTOCOL,"ssl");
                    
          //connect to my domain controller
          env.put(Context.PROVIDER_URL,ldapURL);
                    
          try {

               // Create the initial directory context
               LdapContext ctx = new InitialLdapContext(env,null);

               // Create attributes to be associated with the new user
                   Attributes attrs = new BasicAttributes(true); 
              
               //These are the mandatory attributes for a user object
               //Note that Win2K3 will automagically create a random 
               //samAccountName if it is not present. (Win2K does not)
               attrs.put("objectClass","user");
                   attrs.put("samAccountName","BenF");
               attrs.put("cn","Benjamin Franklin");

               //These are some optional (but useful) attributes
               attrs.put("givenName","Benjamin");
               attrs.put("sn","Franklin");
               attrs.put("displayName","Benjamin Franklin");
               attrs.put("description","Kite Flying Research Scientist");
                   attrs.put("userPrincipalName","BenF@antipodes.com");
                   attrs.put("mail","Benjamin.Franklin@antipodes.com");
               attrs.put("telephoneNumber","1 800 FLY KITE");
               
               //some useful constants from lmaccess.h
               int UF_ACCOUNTDISABLE = 0x0002;
               int UF_PASSWD_NOTREQD = 0x0020;
               int UF_PASSWD_CANT_CHANGE = 0x0040;
               int UF_NORMAL_ACCOUNT = 0x0200;
               int UF_DONT_EXPIRE_PASSWD = 0x10000;
               int UF_PASSWORD_EXPIRED = 0x800000;
          
               //Note that you need to create the user object before you can
               //set the password. Therefore as the user is created with no 
               //password, user AccountControl must be set to the following
               //otherwise the Win2K3 password filter will return error 53
               //unwilling to perform.

                   attrs.put("userAccountControl",Integer.toString(UF_NORMAL_ACCOUNT + UF_PASSWD_NOTREQD + UF_PASSWORD_EXPIRED+ UF_ACCOUNTDISABLE));

          
               // Create the context
               Context result = ctx.createSubcontext(userName, attrs);
               System.out.println("Created disabled account for: " + userName);

               //now that we've created the user object,
               //set the password and change the userAccountControl
          
               //set password is a ldap modfy operation
               //also update the userAccountControl
               //enabling the acount and forcing the user to 
               //update ther password the first time they login
               ModificationItem[] mods = new ModificationItem[2];
          
               //Replace the "unicdodePwd" attribute with a new value
               //Password must be both Unicode and a quoted string
               String newQuotedPassword = "\"" + newPassword + "\"";
               byte[] newUnicodePassword = newQuotedPassword.getBytes("UTF-16LE");

               mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute("unicodePwd", newUnicodePassword));
               mods[1] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute("userAccountControl",Integer.toString(UF_NORMAL_ACCOUNT + UF_PASSWORD_EXPIRED)));
          
               // Perform the update
               ctx.modifyAttributes(userName, mods);
               System.out.println("Set password & updated userccountControl");

               //now add the user to a group.

                    try     {
                         ModificationItem member[] = new ModificationItem[1];
                         member[0]= new ModificationItem(DirContext.ADD_ATTRIBUTE, new BasicAttribute("member", userName)); 
                    
                         ctx.modifyAttributes(groupName,member);
                         System.out.println("Added user to group: " + groupName);

                    } 
                    catch (NamingException e) {
                          System.err.println("Problem adding user to group: " + e);
                    }

               ctx.close();
          
               System.out.println("Successfully created User: " + userName);
          
          } 
          catch (NamingException e) {
               System.err.println("Problem creating object: " + e);
          }
     
          catch (IOException e) {
               System.err.println("Problem creating object: " + e);               }
     }
}