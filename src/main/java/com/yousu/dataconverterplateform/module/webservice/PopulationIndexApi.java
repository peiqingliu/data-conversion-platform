package com.yousu.dataconverterplateform.module.webservice;

import com.yousu.dataconverterplateform.module.util.SoapUtils;

public class PopulationIndexApi {


    public static String doPostSoap(String posturl,String username,String password,  String idNo) throws Exception {
        String soapxml =
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://microsoft.com/webservices/\">\n" +
                        "   <soapenv:Header>\n" +
                        "      <web:MySoapHeader>\n" +
                        "         <web:Uname>"+ username +"</web:Uname><web:Password>"+ password +"</web:Password>\n" +
                        "      </web:MySoapHeader>\n" +
                        "   </soapenv:Header>\n" +
                        "   <soapenv:Body>\n" +
                        "      <web:PopulationIndex>        \n" +
                        "      <web:ProductId><![CDATA[<?xml version=\"1.0\" encoding=\"utf-8\"?> <request>       <head> <function>GetPersonIndex</function> <operation>0</operation> </head><body> <parameter>  "+ idNo +" </parameter> </body> </request>]]></web:ProductId></web:PopulationIndex>\n" +
                        "   </soapenv:Body>\n" +
                        "</soapenv:Envelope>";
        String soapAction = "http://microsoft.com/webservices/PopulationIndex";
        String doPostSoap11 = SoapUtils.doPostNotSSL(posturl, soapxml, soapAction);
        System.out.println("--------------- https result ------------------");
        System.out.println(doPostSoap11);
        return doPostSoap11;
    }

}
