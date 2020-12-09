package com.wy.shop.common.facade.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wy.shop.common.exception.BizException;
import com.wy.shop.common.exception.FacadeException;
import com.wy.shop.common.exception.ValidatorException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * facade层公共处理基类<br/>
 * 作用: 处理请求参数打印、参数转换、基本校验、异常转换<br/>
 * 作用域: 只可被用于facadeimpl模块，facade层接口实现类按需继承该类<br/>
 * //TODO 扩展范围值校验
 *
 */
public abstract class BaseFacadeImpl
{
    private static final Logger logger = LoggerFactory.getLogger(BaseFacadeImpl.class);


    protected void printFacadeInParams(String param, String requestId)
    {
        logger.info("receive the request with param :: {} and request :: {}", param, requestId);
    }


    protected <T> T convertParam(String param, Class<T> class1) throws FacadeException
    {
        T result;
        if (StringUtils.isEmpty(param))
        {
            throw FacadeException.FACADE_JSON_IS_NULL.print();
        }
        try
        {
            result = JSONObject.parseObject(param, class1);
        }
        catch (Exception e)
        {
            throw FacadeException.FACADE_JSON_CONVERT_ERROR.print();
        }
        return result;
    }


    protected void validateParam(String fieldValue, String field) throws ValidatorException
    {
        if (null == fieldValue)
        {
            throw ValidatorException.VALIDATOR_PARAM_IS_NULL
                    .newInstance("Parameter verified failed, there is empty content in the parameter: %s", field)
                    .print();
        }

        if (StringUtils.isBlank(fieldValue))
        {
            throw ValidatorException.VALIDATOR_PARAM_IS_NULL
                    .newInstance("Parameter verified failed, there is empty content in the parameter: %s", field)
                    .print();
        }
    }


    protected void validateParam(Date fieldValue, String field) throws ValidatorException
    {
        if (null == fieldValue)
        {
            throw ValidatorException.VALIDATOR_PARAM_IS_NULL
                    .newInstance("Parameter verified failed, there is empty content in the parameter: %s", field)
                    .print();
        }
    }


    protected void validateParam(Object fieldValue, String field) throws ValidatorException
    {
        if (null == fieldValue)
        {
            throw ValidatorException.VALIDATOR_PARAM_IS_NULL
                    .newInstance("Parameter verified failed, there is empty content in the parameter: %s", field)
                    .print();
        }
        if (fieldValue instanceof List)
        {

            if (CollectionUtils.isEmpty((List) fieldValue))
            {
                throw ValidatorException.VALIDATOR_PARAM_IS_NULL
                        .newInstance("Parameter verified failed, there is empty content in the parameter: %s", field)
                        .print();
            }
        }
    }


    protected void validateParam(BigDecimal fieldValue, String field) throws ValidatorException
    {
        if (null == fieldValue)
        {
            throw ValidatorException.VALIDATOR_PARAM_IS_NULL
                    .newInstance("Parameter verified failed, there is empty content in the parameter: %s", field)
                    .print();
        }
    }


    protected void validateParam(String field, String... fieldValues) throws ValidatorException
    {
        if (null == fieldValues || fieldValues.length <= 0)
        {
            throw ValidatorException.VALIDATOR_PARAM_IS_NULL
                    .newInstance("Parameter verified failed, there is empty content in the parameter,%s:%s", field,
                            fieldValues)
                    .print();
        }

        boolean ret = false;
        for (String val : fieldValues)
        {
            if (StringUtils.isNotEmpty(val))
            {
                ret = true;
                break;
            }
        }
        if (!ret)
        {
            throw ValidatorException.VALIDATOR_PARAM_IS_NULL
                    .newInstance("Parameter verified failed, there is empty content in the parameter,%s:%s", field,
                            fieldValues)
                    .print();
        }
    }

    protected String responseToJSONString(Object object)
    {
        String resp = "";
        if (null == object)
        {
            return resp;
        }
        else
        {
            resp = JSON.toJSONString(object);
        }
        logger.info(resp);
        return resp;
    }

}
