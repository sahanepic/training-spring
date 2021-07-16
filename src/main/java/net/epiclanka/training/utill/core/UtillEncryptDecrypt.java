package net.epiclanka.training.utill.core;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.jpos.iso.ISOUtil;

import net.epiclanka.training.utill.UtillLogger;

public class UtillEncryptDecrypt {

	 

 
	
	public static String ThripleDESEncryption(String key,String plaintxt)  {

        String cipertxt = null;

        
        
        try {
          byte[] k = new byte[172/ 8];   
            k = ISOUtil.hex2byte(key);
        	SecretKeySpec encKey = new SecretKeySpec(k, "DESede");
            Cipher cipher = Cipher.getInstance("DESede/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, encKey);
            byte[] cb = cipher.doFinal(ISOUtil.hex2byte(plaintxt) );
            cipertxt = ISOUtil.byte2hex(cb);
           
		} catch (NoSuchAlgorithmException e) {
			 UtillLogger.logError(UtillEncryptDecrypt.class, e.getMessage());
			
		} catch (NoSuchPaddingException e) {
			UtillLogger.logError(UtillEncryptDecrypt.class, e.getMessage());
		}
        catch (InvalidKeyException e) {
        	UtillLogger.logError(UtillEncryptDecrypt.class, e.getMessage());
		} 
        catch (IllegalBlockSizeException e) {
        	UtillLogger.logError(UtillEncryptDecrypt.class, e.getMessage());
		}
        catch (Exception e) {
        	UtillLogger.logError(UtillEncryptDecrypt.class, e.getMessage());
		}
        
        
        return cipertxt;
    }
	
	
	
	public static String ThripleDESDecryption(String key,String cipertxt )  {

        String plaintxt  = "";

        
        
        try {
          byte[] k = new byte[172/ 8];   
//        	byte[] k = new byte[64/ 8];
            k = ISOUtil.hex2byte(key);
        	
            
            SecretKeySpec encKey = new SecretKeySpec(k, "DESede");
            Cipher cipher = Cipher.getInstance("DESede/ECB/NoPadding");
//            SecretKeySpec encKey = new SecretKeySpec(k, "DES");
//            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, encKey);
            byte[] cb = cipher.doFinal(ISOUtil.hex2byte(cipertxt) );
            plaintxt = ISOUtil.byte2hex(cb);
           
		} catch (NoSuchAlgorithmException e) {
			 UtillLogger.logError(UtillEncryptDecrypt.class, e.getMessage());
			
		} catch (NoSuchPaddingException e) {
			UtillLogger.logError(UtillEncryptDecrypt.class, e.getMessage());
		}
        catch (InvalidKeyException e) {
        	UtillLogger.logError(UtillEncryptDecrypt.class, e.getMessage());
		} 
        catch (IllegalBlockSizeException e) {
        	UtillLogger.logError(UtillEncryptDecrypt.class, e.getMessage());
		}
        catch (Exception e) {
        	UtillLogger.logError(UtillEncryptDecrypt.class, e.getMessage());
		}
        
        
        return plaintxt;
    }
	
	
}
