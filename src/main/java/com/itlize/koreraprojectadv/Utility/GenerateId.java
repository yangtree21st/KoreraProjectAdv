/**package com.itlize.koreraprojectadv.Utility;


import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import com.itlize.koreraprojectadv.Exception.BasicRuntimeException;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

@Data
@Service
@Component
@Transactional
public class GenerateId implements IdentifierGenerator, Configurable {

    @Resource
    private SessionFactory sessionFactory;

    public String workid;

    public String dataid;

    public SnowflakeIdWorker snowFlakeIdWorker;

    /**
     * hibernate自定义主键生成规则必须实现 IdentifierGenerator  generate 为默认方法
     */
  /**  @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o)
            throws HibernateException {
        Long id = snowFlakeIdWorker.nextId();
        if (id != null) {
            return id;
        }else {
            return null;
        }
    }

    /**
     * 加载配置文件中的数据初始化snowflakeworker类
     */
 /**   @Override
    public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry)
            throws MappingException {
        //加载配置文件
        InputStream is = GenerateId.class.getResourceAsStream("/snowflake.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BasicRuntimeException(this,"加载snowflake文件异常" + e.getMessage());
        }
        workid = properties.getProperty("workid");
        dataid = properties.getProperty("dataid");
        if (StringUtils.isNotBlank(dataid) && StringUtils.isNotBlank(workid)) {
            snowFlakeIdWorker = new SnowflakeIdWorker(Long.valueOf(workid), Long.valueOf(dataid));
        }
    }





}
**/
