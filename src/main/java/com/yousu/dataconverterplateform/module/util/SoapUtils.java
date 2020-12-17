package com.yousu.dataconverterplateform.module.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * @author ：chenwenbin
 * @date ：Created in 2019/12/16 12:23
 * @description ：
 */
public class SoapUtils {
    private static final Logger logger = LoggerFactory.getLogger(SoapUtils.class);

    /**
     * soap1.1
     * @param posturl post地址
     * @param soapxml   xml
     * @return String 返回xml字符串
     */
    public static  String doPostSoap11(String posturl, String soapxml,String soapAction){
//        System.setProperty("javax.net.ssl.trustStore","C:\\Program Files\\Java\\jdk1.8.0_231\\jre\\lib\\security\\cacerts"); //key路径
//        System.setProperty("javax.net.ssl.trustStorePassword","123456");//密码
//        System.setProperty("java.protocol.handler.pkgs","com.sun.net.ssl.internal.www.protocol");
        String retStr = "";
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(posturl);
        //  设置请求和传输超时时间
        int socketTimeout = 30000;
        int connetionRequestTimeout = 30000;
        int connectTimeout = 30000;
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(socketTimeout)
                .setConnectionRequestTimeout(connetionRequestTimeout)
                .setConnectTimeout(connectTimeout).build();
        httpPost.setConfig(requestConfig);
        try {
            httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");
            httpPost.setHeader("SOAPAction", soapAction);
            StringEntity data = new StringEntity(soapxml,Charset.forName("UTF-8"));
            httpPost.setEntity(data);
            CloseableHttpResponse response = closeableHttpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                // 打印响应内容
                retStr = EntityUtils.toString(httpEntity, "UTF-8");
                logger.info("response:" + retStr);
            }
            response.close();
            // 释放资源
            closeableHttpClient.close();
        } catch (Exception e) {
            logger.error("exception in doPostSoap1_1", e);
        }

        return retStr;
    }


    /**
     * post方法，忽略SSL证书
     * @param posturl
     * @param soapxml
     * @param soapAction
     * @return
     */
    public static  String doPostNotSSL(String posturl, String soapxml,String soapAction) throws  Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String body = "";
        // 通过自定义客户端生成忽视SSL证书的客户端
        CloseableHttpClient client =getHttpClient();
        try {
            HttpPost httpPost = new HttpPost(posturl);
            httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");
            httpPost.setHeader("SOAPAction", soapAction);
            StringEntity data = new StringEntity(soapxml, StandardCharsets.UTF_8);
            httpPost.setEntity(data);
            //执行请求操作，并拿到结果（同步阻塞）
            CloseableHttpResponse response = client.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            //获取结果实体
            HttpEntity entity = response.getEntity();
            if (entity != null){
                //用UTF-8转码
                body = EntityUtils.toString(entity,"UTF-8");
            }
            EntityUtils.consume(entity);
            //释放连接
            response.close();
//            System.out.println("body:"+body);
        } finally {
            httpclient.close();
        }
        return body;
    }

    /**
     * 信任所有SSL证书
     * @return
     */
    private static CloseableHttpClient getHttpClient() {
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory>create();
        ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();
        registryBuilder.register("http", plainSF);
        //指定信任密钥存储对象和连接套接字工厂
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            //信任任何链接
            TrustStrategy anyTrustStrategy = new TrustStrategy() {
                @Override
                public boolean isTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            };
            SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, anyTrustStrategy).build();
            LayeredConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            registryBuilder.register("https", sslSF);
        } catch (KeyStoreException | KeyManagementException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Registry<ConnectionSocketFactory> registry = registryBuilder.build();
        //设置连接管理器
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(registry);
        //构建客户端
        return HttpClientBuilder.create().setConnectionManager(connManager).build();
    }
}
