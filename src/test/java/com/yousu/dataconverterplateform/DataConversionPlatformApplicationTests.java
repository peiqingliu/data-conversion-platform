package com.yousu.dataconverterplateform;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.yousu.dataconverterplateform.module.slave.entity.OriginPerson;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Slf4j
@SpringBootTest
class DataConversionPlatformApplicationTests {

    @Test
    void contextLoads() {
    }

    private JsonGenerator jsonGenerator = null;
    private ObjectMapper objectMapper = null;

    private XmlMapper xmlMapper = new XmlMapper();

    @PostConstruct
    public void init() {
        objectMapper = new ObjectMapper();
        try {
            jsonGenerator = objectMapper.getFactory().createGenerator(System.out,JsonEncoding.UTF8);
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

    @Test
    public void testXMLTOBean() throws IOException {
        String xml = " <person>\n" +
                "            <patient_id>058321060</patient_id>\n" +
                "            <health_record_code></health_record_code>\n" +
                "            <health_card_id></health_card_id>\n" +
                "            <name>李秋玲</name>\n" +
                "            <sex>女</sex>\n" +
                "            <marital_status>再婚</marital_status>\n" +
                "            <date_of_birth>1990/8/20</date_of_birth>\n" +
                "            <birth_place1>广西壮族自治区南宁市青秀区</birth_place1>\n" +
                "            <birth_place2>广西壮族自治区南宁市青秀区长塘镇</birth_place2>\n" +
                "            <citizenship>中国</citizenship>\n" +
                "            <nation>壮族</nation>\n" +
                "            <id_no>45012119900820334X</id_no>\n" +
                "            <identity></identity>\n" +
                "            <charge_type></charge_type>\n" +
                "            <unit_in_contract>51</unit_in_contract>\n" +
                "            <mailing_address1>广西壮族自治区南宁市青秀区</mailing_address1>\n" +
                "            <mailing_address2>广西壮族自治区南宁市青秀区长塘镇</mailing_address2>\n" +
                "            <mailing_address3>广西壮族自治区来宾市合山市</mailing_address3>\n" +
                "            <mailing_address4>广西壮族自治区来宾市合山市岭南镇城中</mailing_address4>\n" +
                "            <zip_code></zip_code>\n" +
                "            <phone_number_home>15277164686</phone_number_home>\n" +
                "            <phone_number_business></phone_number_business>\n" +
                "            <next_of_kin></next_of_kin>\n" +
                "            <relationship></relationship>\n" +
                "            <next_of_kin_addr></next_of_kin_addr>\n" +
                "            <next_of_kin_zip_code></next_of_kin_zip_code>\n" +
                "            <next_of_kin_phone></next_of_kin_phone>\n" +
                "            <ispoor>0</ispoor>\n" +
                "            <dead_tag>0</dead_tag>\n" +
                "            <tprq></tprq>\n" +
                "            <out_poverty_status></out_poverty_status>\n" +
                "        </person>";

        OriginPerson originPerson = xmlToJavabean(xml, OriginPerson.class);
        log.info("originPerson：" + originPerson);
    }


    @Test
    public void readJson2Map() {
        String json = "{\n" +
                "\"REQUEST\":{\n" +
                "   \"PRESCINFO_MASTER\":\"sql\",\n" +
                "   \"PRESCINFO_DETAIL\":{\n" +
                "     \"ITEM\":\"sql\"\n" +
                "    }\n" +
                "   }\n" +
                "}";
        try {
            Map<String, Map<String, Object>> maps = objectMapper.readValue(json, Map.class);
          System.out.println(maps.size());
            Set<String> key = maps.keySet();
            Iterator<String> iter = key.iterator();
            while (iter.hasNext()) {
                String field = iter.next();
                System.out.println(field + ":" + maps.get(field));
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
