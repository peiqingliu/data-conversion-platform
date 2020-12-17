package com.yousu.dataconverterplateform.module.primary.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/**
 * @Author Liupeiqing
 * @Date 2020/3/18 22:39
 * @Version 1.0  西医病案首页
 */
@Data
@NoArgsConstructor
@JacksonXmlRootElement
public class BaseInfo implements Serializable {

    /**
     * 机构编码
     */
    private String USERCODE;

    /**
     * 机构名称
     */
    private String USERNAME;

    /**
     * 医疗付款方式
     */
    private String YLFKFS;

    /**
     * 健康卡号
     */
    private String JKKH;

    /**
     * 住院次数
     */
    private int ZYCS;
    /**
     * 备案号
     */
    private String BAH;
    /**
     * 姓名
     */
    private String XM;
    /**
     * 性别
     */
    private String XB;

    /**
     * 出生日期
     */
    private String CSRQ;
    /**
     * 年龄
     */
    private Integer NL;
    /**
     * 国籍
     */
    private String GJ;

    /**
     * (年龄不足 1 周岁的)年龄(月)
     */
    private Integer BZYZSNL;

    /**
     * 新生儿出生体重(克)
     */
    private Integer XSECSTZ;

    /**
     * 新生儿入院体重（克）
     */
    private Integer XSERYTZ;

    /**
     * 出生地(省)
     */
    private String CSD1;

    /**
     * 出生地(市)
     */
    private String CSD2;

    /**
     * 出生地(县)
     */
    private String CSD3;

    /**
     * 籍贯(省)
     */
    private String GG1;

    /**
     * 籍贯(市)
     */
    private String GG2;
    /**
     * 籍贯(县)
     */
    private String GG3;
    /**
     * 民族
     */
    private String MZ;

    /**
     * 身份证号
     */
    private String SFZH;

    /**
     * 职业
     */
    private String ZY;

    /**
     * 婚姻
     */
    private String HY;

    /**
     * 现住址(省)
     */
    private String XZZ1;

    /**
     * 现住址(市)
     */
    private String XZZ2;

    /**
     * 现住址(县)
     */
    private String XZZ3;

    /**
     * 现住址(镇)
     */
    private String XZZ4;

    /**
     * 现住址(街)
     */
    private String XZZ5;
    /**
     * 电话
     */
    private String DH;

    /**
     * 邮编
     */
    private String YB1;

    /**
     * 户口地址(省)
     */
    private String HKDZ1;

    /**
     * 户口地址(市)
     */
    private String HKDZ2;

    /**
     * 户口地址(县)
     */
    private String HKDZ3;

    /**
     * 户口地址(镇)
     */
    private String HKDZ4;

    /**
     * 户口地址(街)
     */
    private String HKDZ5;

    /**
     * 邮编
     */
    private String YB2;

    /**
     * 工作单位及地址
     */
    private String GZDWJDZ;

    /**
     * 单位电话
     */
    private String DWDH;

    /**
     * 邮编
     */
    private String YB3;

    /**
     * 联系人姓名
     */
    private String LXRXM;

    /**
     * 关系
     */
    private String GX;

    /**
     * 地址
     */
    private String DZ;

    /**
     * 电话
     */
    private String DH2;

    /**
     * 入院途径
     */
    private String RYTJ;


    /**
     * 入院时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date RYSJ;

    /**
     * 时
     */
    private Integer RYSJS;

    /**
     * 入院科别
     */
    private String RYKB;

    /**
     * 入院病房
     */
    private String RYBF;

    /**
     * 转科科别
     */
    private String ZKKB;

    /**
     * 出院时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date CYSJ;

    /**
     * 时
     */
    private Integer CYSJS;

    /**
     * 出院科别
     */
    private String CYKB;

    /**
     * 出院病房
     */
    private String CYBF;

    /**
     * 实际住院（天）
     */
    private String SJZYTS;

    /**
     * 门(急)诊诊断
     */
    private String MZZD;

    /**
     * 疾病编码
     */
    private String JBBM;

    /**
     * 主要诊断
     */
    private String ZYZD;

    /**
     * 疾病编码
     */
    private String JBDM;
    /**
     * 入院病情
     */
    private String RYBQ;

    /**
     * 其他诊断 8
     */
    private String QTZD8;

    /**
     * 疾病编码 8
     */
    private String JBDM8;

    /**
     * 入院病情 8
     */
    private String RYBQ8;

    /**
     * 其他诊断 1
     */
    private String QTZD1;

    /**
     * 疾病编码1
     */
    private String JBDM1;

    /**
     * 入院病情 1
     */
    private String RYBQ1;
    /**
     * 其他诊断 9
     */
    private String QTZD9;

    /**
     * 疾病编码 9
     */
    private String JBDM9;

    /**
     * 入院病情 9
     */
    private String RYBQ9;

    /**
     * 其他诊断 2
     */
    private String QTZD2;

    /**
     * 疾病编码 2
     */
    private String JBDM2;

    /**
     * 入院病情 2
     */
    private String RYBQ2;

    /**
     * 其他诊断 10
     */
    private String QTZD10;

    /**
     * 疾病编码 10
     */
    private String JBDM10;

    /**
     * 入院病情 10
     */
    private String RYBQ10;

    /**
     * 其他诊断 3
     */
    private String QTZD3;

    /**
     * 疾病编码 3
     */
    private String JBDM3;

    /**
     * 入院病情 3
     */
    private String RYBQ3;

    /**
     * 其他诊断 11
     */
    private String QTZD11;

    /**
     * 疾病编码 11
     */
    private String JBDM11;

    /**
     * 入院病情 11
     */
    private String RYBQ11;

    /**
     * 其他诊断 4
     */
    private String QTZD4;

    /**
     * 疾病编码 4
     */
    private String JBDM4;

    /**
     * 入院病情 4
     */
    private String RYBQ4;

    private String QTZD12; //VARCHAR2(200) 其他诊断 12
    private String JBDM12;// VARCHAR2(100) 疾病编码 12
    private String RYBQ12;// VARCHAR2(100) 入院病情 12
    private String QTZD5;// VARCHAR2(200) 其他诊断 5
    private String JBDM5; //VARCHAR2(100) 疾病编码 5
    private String RYBQ5; // VARCHAR2(100) 入院病情 5
    private String QTZD13;// VARCHAR2(200) 其他诊断 13
    private String JBDM13;// VARCHAR2(100) 疾病编码 13
    private String RYBQ13;// VARCHAR2(100) 入院病情 13
    private String QTZD6;// VARCHAR2(200) 其他诊断 6
    private String JBDM6;// VARCHAR2(100) 疾病编码 6
    private String RYBQ6;// VARCHAR2(100) 入院病情 6
    private String QTZD14;// VARCHAR2(200) 其他诊断 14
    private String JBDM14;// VARCHAR2(100) 疾病编码 14
    private String RYBQ14;// VARCHAR2(100); 入院病情 14
    private String QTZD7;// VARCHAR2(200) 其他诊断 7
    private String JBDM7;// VARCHAR2(100) 疾病编码 7
    private String RYBQ7;// VARCHAR2(100) 入院病情 7
    private String QTZD15;// VARCHAR2(200) 其他诊断 15
    private String JBDM15;// VARCHAR2(100) 疾病编码 15
    private String RYBQ15;// VARCHAR2(100) 入院病情 15
    private String WBYY;// VARCHAR2(254) 中毒的外部原因
    private String H23;// VARCHAR2(100) 疾病编码
    private String BLZD;// VARCHAR2(100) 病理诊断
    private String JBMM;// VARCHAR2(100) 疾病编码
    private String BLH;// VARCHAR2(100) 病理号
    private String YWGM;// VARCHAR2(1) 药物过敏
    private String GMYW;// VARCHAR2(100) 过敏药物
    private String SWHZSJ;// VARCHAR2(100) 死亡患者尸检
    private String XX;// VARCHAR2(100) 血型
    private String RH;// VARCHAR2(100) Rh
    private String KZR;// VARCHAR2(100) 科主任
    private String ZRYS;// VARCHAR2(100) 主任（副主任）医师
    private String ZZYS;// VARCHAR2(100) 主治医师
    private String ZYYS;// VARCHAR2(100) 住院医师
    private String ZRHS;// VARCHAR2(100) 责任护士
    private String JXYS;// VARCHAR2(100) 进修医师
    private String SXYS;//VARCHAR2(100) 实习医师
    private String BMY;// VARCHAR2(100) 编码员
    private String BAZL;// VARCHAR2(100) 病案质量
    private String ZKYS;// VARCHAR2(100) 质控医师
    private String ZKHS;// VARCHAR2(100) 质控护士
    private String ZKRQ;// VARCHAR2(12) 质控日期
    private String SSJCZBM1;// VARCHAR2(100) 手术及操作编码
    private String SSJCZRQ1;// VARCHAR2(200) 手术及操作日期
    private String SHJB1;// VARCHAR2(100) 手术级别
    private String SSJCZMC1;// VARCHAR2(200) 手术及操作名称
    private String SZ1;// VARCHAR2(100) 术者
    private String YZ1;// VARCHAR2(100) I 助
    private String EZ1;// VARCHAR2(100) II 助
    private String QKDJ1;// VARCHAR2(100) 切口等级
    private String QKYLB1;// VARCHAR2(100) 切口愈合类别
    private String MZFS1;// VARCHAR2(100) 麻醉方式
    private String MZYS1;// VARCHAR2(100) 麻醉医师
    private String SSJCZBM2;// VARCHAR2(100) 手术及操作编码
    private String SSJCZRQ2;// VARCHAR2(12) 手术及操作日期
    private String SHJB2;// VARCHAR2(100) 手术级别
    private String SSJCZMC2;// VARCHAR2(200) 手术及操作名称
    private String SZ2;// VARCHAR2(100) 术者
    private String YZ2;// VARCHAR2(100) I 助
    private String EZ2;// VARCHAR2(100) II 助
    private String QKDJ2;// VARCHAR2(100) 切口等级
    private String QKYLB2;// VARCHAR2(100) 切口愈合类别
    private String MZFS2;// VARCHAR2(100) 麻醉方式
    private String MZYS2;// VARCHAR2(100) 麻醉医师
    private String SSJCZBM3;// VARCHAR2(100) 手术及操作编码
    private String SSJCZRQ3;// VARCHAR2(12) 手术及操作日期
    private String SHJB3;// VARCHAR2(100) 手术级别
    private String SSJCZMC3;// VARCHAR2(200) 手术及操作名称
    private String SZ3;// VARCHAR2(100) 术者
    private String YZ3;// VARCHAR2(100) I 助
    private String EZ3;// VARCHAR2(100) II 助
    private String QKDJ3;// VARCHAR2(100) 切口等级
    private String QKYLB3;// VARCHAR2(100) 切口愈合类别
    private String MZFS3;// VARCHAR2(100) 麻醉方式
    private String MZYS3;// VARCHAR2(100) 麻醉医师
    private String SSJCZBM4;// VARCHAR2(100) 手术及操作编码
    private String SSJCZRQ4;// VARCHAR2(12) 手术及操作日期
    private String SHJB4;// VARCHAR2(100) 手术级别
    private String SSJCZMC4;// VARCHAR2(200) 手术及操作名称
    private String SZ4;// VARCHAR2(100) 手术及操作医师术者
    private String YZ4;// VARCHAR2(100) I 助
    private String EZ4;// VARCHAR2(100) II 助
    private String QKDJ4;// VARCHAR2(100) 切口等级
    private String QKYLB4;// VARCHAR2(100) 切口愈合类别
    private String MZFS4;// VARCHAR2(100) 麻醉方式
    private String MZYS4;// VARCHAR2(100) 麻醉医师
    private String SSJCZBM5;// VARCHAR2(100) 手术及操作编码
    private String SSJCZRQ5;// VARCHAR2(12) 手术及操作日期
    private String SHJB5;// VARCHAR2(100) 手术级别
    private String SSJCZMC5;// VARCHAR2(200) 手术及操作名称
    private String SZ5;// VARCHAR2(100) 术者
    private String YZ5;// VARCHAR2(100) I 助
    private String EZ5;// VARCHAR2(100) II 助
    private String QKDJ5;// VARCHAR2(100) 切口等级
    private String QKYLB5;// VARCHAR2(100) 切口愈合类别
    private String MZFS5;// VARCHAR2(100) 麻醉方式
    private String MZYS5;// VARCHAR2(100) 麻醉医师
    private String SSJCZBM6;// VARCHAR2(100) 手术及操作编码
    private String SSJCZRQ6;// VARCHAR2(12) 手术及操作日期
    private String SHJB6;// VARCHAR2(100) 手术级别
    private String SSJCZMC6;// VARCHAR2(200) 手术及操作名称
    private String SZ6;// VARCHAR2(100) 术者
    private String YZ6;// VARCHAR2(100) I 助
    private String EZ6;// VARCHAR2(100) II 助
    private String QKDJ6;// VARCHAR2(100) 切口等级
    private String QKYLB6;// VARCHAR2(100) 切口愈合类别
    private String MZFS6;// VARCHAR2(100) 麻醉方式
    private String MZYS6;// VARCHAR2(100) 麻醉医师
    private String SSJCZBM7;// VARCHAR2(100) 手术及操作编码
    private String SSJCZRQ7;// VARCHAR2(12) 手术及操作日期
    private String SHJB7;// VARCHAR2(100) 手术级别
    private String SSJCZMC7;// VARCHAR2(200) 手术及操作名称
    private String SZ7;// VARCHAR2(100) 术者
    private String YZ7;// VARCHAR2(100) I 助
    private String EZ7;// II 助
    private String QKDJ7;// VARCHAR2(100) 切口等级
    private String QKYLB7;// VARCHAR2(100) 切口愈合类别
    private String MZFS7;// VARCHAR2(100) 麻醉方式
    private String MZYS7;// VARCHAR2(100) 麻醉医师
    private String LYFS;// VARCHAR2(100) 离院方式
    private String YZZY_YLJG;// VARCHAR2(200) 医嘱转院，拟接收医疗机构名称
    private String WSY_YLJG;// VARCHAR2(200) 医嘱转社区卫生服务机构/乡镇 生院，拟接收医疗机构名称
    private String SFZZYJH;// VARCHAR2(100) 是否有出院 31 天内再住院计划
    private String MD;// VARCHAR2(100) 目的
    private Integer RYQ_T;// NUMBER(12) 颅脑损伤患者昏迷入院前时间_天
    private Integer RYQ_XS;// NUMBER(24) 小时
    private Integer RYQ_FZ;// NUMBER(12) 分钟
    private Integer RYH_T;// NUMBER(12) 颅脑损伤患者昏迷入院后时间_天
    private Integer RYH_XS;// NUMBER(24) 小时
    private Integer RYH_FZ;// NUMBER(12) 分钟
    private Integer ZFY;// NUMBER(12,2) 住院费用(元)：总费用
    private Integer ZFJE;// NUMBER(12,2) 自付金额
    private Integer YLFUF;// NUMBER(12,2) 综合医疗服务类(1)一般医疗服务费
    private Integer ZLCZF;// NUMBER(12,2) 一般治疗操作费
    private Integer HLF;// NUMBER(12,2) 护理费
    private Integer QTFY;// NUMBER(12,2) 其他费用
    private Integer BLZDF;// NUMBER(12,2) 诊断类(5)病理诊断费
    private Integer SYSZDF;// NUMBER(12,2) 实验室诊断费
    private Integer YXXZDF;// NUMBER(12,2) 影像学诊断费
    private Integer LCZDXMF;// NUMBER(12,2) 临床诊断项目费
    private Integer FSSZLXMF;// NUMBER(12,2) 治疗类(9)非手术治疗项目费
    private Integer WLZLF;// NUMBER(12,2) 临床物理治疗费
    private Integer SSZLF;// NUMBER(12,2) 手术治疗费
    private Integer MAF;// NUMBER(12,2) 麻醉费
    private Integer SSF;// NUMBER(12,2) 手术费
    private Integer KFF;// NUMBER(12,2) 康复类(11)康复费
    private Integer ZYZLF;// NUMBER(12,2) 中医类:(12)中医治疗费
    private Integer XYF;// NUMBER(12,2) 西药类(13)西药费
    private Integer KJYWF;// NUMBER(12,2) 抗菌药物费
    private Integer ZCYF;// NUMBER(12,2) 中药类(14)中成药费
    private Integer ZCYF1;// NUMBER(12,2) 中草药费
    private Integer XF;// NUMBER(12,2) 血液和血液制品类(16)血费
    private Integer BDBLZPF;// NUMBER(12,2) 白蛋白类制品费

    private double QDBLZPF;// NUMBER(12,2) 球蛋白类制品费
    private double NXYZLZPF;// NUMBER(12,2) 凝血因子类制品费
    private double XBYZLZPF;// NUMBER(12,2) 细胞因子类制品费
    private double HCYYCLF;// NUMBER(12,2) 耗材类(23)检查用一次性医用材料费
    private double YYCLF;// NUMBER(12,2) 治疗用一次性医用材料费
    private double YCXYYCLF;// NUMBER(12,2) 手术用一次性医用材料费
    private double QTF;// NUMBER(12,2) 其他类(24)其他费
    private String FZR;// VARCHAR2(12) 负责人
    private String TJFZR;// VARCHAR2(12) 统计负责人
    private String LXDH;// VARCHAR2(16) 联系电话
    private Date RIQI;// DATETIME 填报日期
    private String XNHZH;// VARCHAR2(100) 新农合证号
    private String SECURITY_LEVEL;//VARCHAR2(1) 密级 0：无须病种控制；1：恶性肿瘤；2：性病艾滋病；3：其它不治之症；4.精神类病；9：其它
}
