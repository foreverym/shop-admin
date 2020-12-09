package com.wy.shop.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class SqlUtil
{
    private static final Map<String, String> CHARACTERMAP = new LinkedHashMap<String, String>();

    static
    {
        CHARACTERMAP.put("\\[", "\\\\[");
        CHARACTERMAP.put("\\]", "\\\\]");
        CHARACTERMAP.put("_", "\\\\_");
        CHARACTERMAP.put("%", "\\\\%");
        CHARACTERMAP.put("\\^", "\\\\^");
    }


    /**
     * 
     * 替换特殊字符
     * 
     * @author xpguo
     * @param %param name% %param description%
     * @return
     */
    public static String replaceSpecialCharacter(String str)
    {
        if (StringUtils.isNotEmpty(str))
        {
            str = str.trim();
            for (Map.Entry<String, String> me : CHARACTERMAP.entrySet())
            {
                str = str.replaceAll(me.getKey(), me.getValue());
            }
        }
        return str;

    }


    public static void main(String[] args)
    {
        System.out.println(replaceSpecialCharacter("[_%]^"));
    }

}
