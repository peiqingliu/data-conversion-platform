package com.yousu.dataconverterplateform.module.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Liu_peiqing
 * @Date: 2020/03/29/21:06
 * @Description: todo
 */
@Component
@Slf4j
public class SoapRunUtil {


    @Value("${yousu.posturl}")
    private  String posturl;

    public  String doPostSoap59(String soapXml,String soapAction) throws Exception {
        String doPostSoap11 = SoapUtils.doPostNotSSL(posturl, soapXml, soapAction);
        System.out.println("--------------- https result ------------------");
        System.out.println(doPostSoap11);
        return doPostSoap11;
    }

}
