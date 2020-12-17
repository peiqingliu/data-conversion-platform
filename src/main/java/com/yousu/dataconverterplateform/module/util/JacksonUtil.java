package com.yousu.dataconverterplateform.module.util;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Liu_peiqing
 * @Date: 2020/03/28/21:38
 * @Description: todo
 */
@Slf4j
@Component
public class JacksonUtil {

    private JsonGenerator jsonGenerator = null;
    private ObjectMapper objectMapper = null;
    private XmlMapper xmlMapper = new XmlMapper();

    @PostConstruct
    public void init() {
        objectMapper = new ObjectMapper();
        // 允许整数前导为0,eg:"01"形式
        objectMapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        try {
            jsonGenerator = objectMapper.getFactory().createGenerator(System.out, JsonEncoding.UTF8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * convert xml to javabean.
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public <T> T xmlToJavabean(String xml,Class<T> clazz) throws JsonParseException, JsonMappingException, IOException{
        log.info("待转换的xml");
        // xml to java bean
        T obj = xmlMapper.readValue(xml, clazz);
        log.info("抓换完成T:" + obj.toString());
        return obj;
    }



    public Map<String, Object> JsonToMap(String json) {
        try {
            Map<String, Object> maps = objectMapper.readValue(json, Map.class);
            System.out.println(maps.size());
            Set<String> key = maps.keySet();
            Iterator<String> iter = key.iterator();
            while (iter.hasNext()) {
                String field = iter.next();
                System.out.println(field + ":" + maps.get(field));
            }
            log.info("转成的map：" +  maps);
            return maps;
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }


    public  Map<String, Object> multilayerXmlToMap(String xml) {
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            log.error("xml字符串解析，失败 --> {}", e);
        }
        Map<String, Object> map = new HashMap<>();
        if (null == doc) {
            return map;
        }
        // 获取根元素
        Element rootElement = doc.getRootElement();
        recursionXmlToMap(rootElement,map);
        return map;
    }

    /**
     * multilayerXmlToMap核心方法，递归调用
     *
     * @param element 节点元素
     * @param outmap 用于存储xml数据的map
     */
    @SuppressWarnings("unchecked")
    private void recursionXmlToMap(Element element, Map<String, Object> outmap) {
        // 得到根元素下的子元素列表
        List<Element> list = element.elements();
        int size = list.size();
        if (size == 0) {
            // 如果没有子元素,则将其存储进map中
            outmap.put(element.getName(), element.getTextTrim());
        } else {
            // innermap用于存储子元素的属性名和属性值
            Map<String, Object> innermap = new HashMap<>();
            // 遍历子元素
            list.forEach(childElement -> recursionXmlToMap(childElement, innermap));
            outmap.put(element.getName(), innermap);
        }
    }


    public void MapToXml(Map<String,Object> map){
        XmlMapper xml = new XmlMapper();
        try {
            String paramXml = xml.writeValueAsString(map);
            createSoapXml(paramXml);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.error("将Map转换成xml出错" + e);
        }
    }


    public String createSoapXml(String paramXml){
        String soapXml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Header>\n" +
                "    <MySoapHeader xmlns=\"http://microsoft.com/webservices/\">\n" +
                "      <Uname>string</Uname>\n" +
                "      <Password>string</Password>\n" +
                "    </MySoapHeader>\n" +
                "  </soap12:Header>\n" +
                "  <soap12:Body>\n" +
                "    <GetBasInfo xmlns=\"http://microsoft.com/webservices/\">\n" +
                "      <tag>int</tag>\n" +
                "      <ProductId>"
                +  paramXml +
                "       </ProductId>\n" +
                "    </GetBasInfo>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        log.info("获取整个拼接后的soapxml:" + soapXml);
        return soapXml;
    }


    @PreDestroy
    public void destroy() {
        try {
            if (jsonGenerator != null) {
                jsonGenerator.flush();
            }
            if (!jsonGenerator.isClosed()) {
                jsonGenerator.close();
            }
            jsonGenerator = null;
            objectMapper = null;
            System.gc();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
