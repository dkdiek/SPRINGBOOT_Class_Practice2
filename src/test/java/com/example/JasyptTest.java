package com.example;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JasyptTest {

    @Test
    public void jasyptTest(){
        String value="1234";
        String result = jasyptEncoding(value);
        log.debug("---{}---", result);
        System.out.println(result);
    }

    public String jasyptEncoding(String value){
        String key = "5f7d1da3d58fd1259a6085e9d711b52f0706c2b915702a0abdf78ead998519ae";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWITHMD5ANDDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }
    
}
