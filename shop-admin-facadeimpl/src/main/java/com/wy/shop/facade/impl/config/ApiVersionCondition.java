package com.wy.shop.facade.impl.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiVersionCondition implements RequestCondition<ApiVersionCondition>
{

    private final static Logger logger = LoggerFactory.getLogger(ApiVersion.class);
    /**
     * extract the version part from url. example [v0-9]
     */
    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+)");

    private int apiVersion;


    ApiVersionCondition(int apiVersion)
    {
        this.apiVersion = apiVersion;
    }


    @Override
    public ApiVersionCondition combine(ApiVersionCondition other)
    {
        /*
         * latest defined would be take effect, that means, methods definition with override the classes definition
         */
        return new ApiVersionCondition(other.getApiVersion());
    }


    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest request)
    {
        try
        {
            Matcher m = VERSION_PREFIX_PATTERN.matcher(request.getRequestURI());
            if (m.find())
            {
                Integer version = Integer.valueOf(m.group(1));
                /*
                 * when applying version number equals configuration, then it will take effect
                 */
                if (version == this.apiVersion)
                {
                    return this;
                }
            }
        }
        catch (Exception e)
        {
            logger.warn("api version matched failed, Exception:\n", e);
        }
        return null;
    }


    @Override
    public int compareTo(ApiVersionCondition other, HttpServletRequest request)
    {
        return other.getApiVersion() - this.apiVersion;
    }


    private int getApiVersion()
    {
        return apiVersion;
    }

}