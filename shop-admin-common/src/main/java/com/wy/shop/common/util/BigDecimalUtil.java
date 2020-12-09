//*****************************************************************************
//
// File Name       :  BigDecimalUtil.java
// Date Created    :  Jun 29, 2011
// Last Changed By :  $Author: $
// Last Changed On :  $Date: $
// Revision        :  $Rev: $
// Description     :  TODO To fill in a brief description of the purpose of
//                    this class.
//
// PracBiz Pte Ltd.  Copyright (c) 2011.  All Rights Reserved.
//
//*****************************************************************************

package com.wy.shop.common.util;


import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * TODO To provide an overview of this class.
 *
 * @author jiangming_2009
 */
public final class BigDecimalUtil
{

    // 10以内的数字
    private static final String[] SINGLE_NUM_ARR = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine" };
    // 十几的数字
    private static final String[] TEN_NUM_ARR = new String[] { "Ten", "Eleven", "Tweleve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    // 整十的数字
    private static final String[] TEN_INTEGER_ARR = new String[] { "Ten", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety" };

    private static BigDecimalUtil instance;


    private BigDecimalUtil()
    {
    }


    public static BigDecimalUtil getInstance()
    {
        synchronized (BigDecimalUtil.class)
        {
            if (instance == null)
            {
                instance = new BigDecimalUtil();
            }
        }

        return instance;
    }


    public BigDecimal getStringValueNullAsZero(String value)
    {
        if (value == null || StringUtils.isBlank(value))
        {
            return BigDecimal.ZERO;
        }

        return new BigDecimal(value.trim());
    }


    public BigDecimal convertStringToBigDecimal(String value, int length)
    {
        if (value == null || "".equals(value.trim()))
        {
            return null;
        }

        BigDecimal data = new BigDecimal(value.trim());

        return data.divide(BigDecimal.ONE, length, BigDecimal.ROUND_HALF_UP);
    }


    /**
     * 
     * 格式数值,如果为nul,返回0
     *
     * @author Sunyadong
     * @return
     */
    public BigDecimal format(BigDecimal value)
    {
        if (value == null)
        {
            return BigDecimal.ZERO;
        }

        return value;
    }


    public BigDecimal format(BigDecimal value, int length)
    {
        if (value == null)
        {
            return BigDecimal.ZERO.divide(BigDecimal.ONE, length, BigDecimal.ROUND_HALF_UP);
        }

        return value.divide(BigDecimal.ONE, length, BigDecimal.ROUND_HALF_UP);
    }


    public BigDecimal formatWithRoundingMode(BigDecimal value, int length, int roundingMode)
    {
        if (value == null)
        {
            return BigDecimal.ZERO.divide(BigDecimal.ONE, length, roundingMode);
        }

        return value.divide(BigDecimal.ONE, length, roundingMode);
    }


    public String convertBigDecimalToStringIntegerWithNoScale(BigDecimal value, int scale)
    {
        if (value == null)
        {
            return BigDecimal.ZERO.divide(BigDecimal.ONE, 0, BigDecimal.ROUND_HALF_UP).toString();
        }

        if (BigDecimal.valueOf(value.intValue()).compareTo(value) == 0)
        {
            return value.divide(BigDecimal.ONE, 0, BigDecimal.ROUND_HALF_UP).toString();
        }
        else
        {
            return value.divide(BigDecimal.ONE, scale, BigDecimal.ROUND_HALF_UP).toString();
        }
    }


    public String convertBigDecimalToStringIntegerWithScale(BigDecimal value, int scale)
    {
        if (value == null)
        {
            return BigDecimal.ZERO.divide(BigDecimal.ONE, scale, BigDecimal.ROUND_HALF_UP).toString();
        }

        return value.divide(BigDecimal.ONE, scale, BigDecimal.ROUND_HALF_UP).toString();
    }


    public String convertBigDecimalToStringThousandWithScale(BigDecimal value, int scale)
    {
        if (value == null)
        {
            return BigDecimal.ZERO.divide(BigDecimal.ONE, scale, BigDecimal.ROUND_HALF_UP).toString();
        }
        DecimalFormat format = new DecimalFormat("#,##0.000");
        return format.format(value.divide(BigDecimal.ONE, scale, BigDecimal.ROUND_HALF_UP));
    }


    public String formatBigDecimal(BigDecimal obj, String expression)
    {
        if (obj == null) return null;
        DecimalFormat df = new DecimalFormat(expression);
        return df.format(obj.doubleValue());
    }


    public static boolean isBlank(BigDecimal value)
    {
        return value == null || value.compareTo(BigDecimal.ZERO) == 0;
    }


    /**
     * 转换金额到英文
     * 
     * @param x (需要转换的金额)
     * @return String (转换后的结果) sample:x=263.45 result is :Two Hundred Sixty-Three and Cents Forty-Five only
     * 
     * */
    public String parseNumToEnglish(String x)
    {
        if (Double.parseDouble(x) <= 0)
        {
            return "Zero only";
        }
        int z = x.indexOf("."); // 取小数点位置
        String lstr = "", rstr = "";
        if (z > -1)
        { // 看是否有小数，如果有，则分别取左边和右边
            lstr = x.substring(0, z);
            rstr = x.substring(z + 1);
        }
        else
            // 否则就是全部
            lstr = x;

        String lstrrev = reverse(lstr); // 对左边的字串取反
        String[] a = new String[5]; // 定义5个字串变量来存放解析出来的叁位一组的字串

        switch (lstrrev.length() % 3)
        {
        case 1:
            lstrrev += "00";
            break;
        case 2:
            lstrrev += "0";
            break;
        }
        String lm = ""; // 用来存放转换後的整数部分
        for (int i = 0; i < lstrrev.length() / 3; i++)
        {
            a[i] = reverse(lstrrev.substring(3 * i, 3 * i + 3)); // 截取第一个叁位
            if (!a[i].equals("000"))
            { // 用来避免这种情况：1000000 = one million
                if (i != 0)
                    lm = transThree(a[i]) + " " + parseMore(String.valueOf(i)) + " " + lm; // 加:
                                                                                           // thousand、million、billion
                else
                    lm = transThree(a[i]); // 防止i=0时， 在多加两个空格.
            }
            else
                lm += transThree(a[i]);
        }

        String xs = ""; // 用来存放转换後小数部分
        if (z > -1)
        {
            String transTwo = transTwo(rstr);
            if (transTwo == null || "".equals(transTwo))
            {
                xs = "";
            }
            else
            {
                xs = "and " + "Cents " + transTwo + " "; // 小数部分存在时转换小数
            }
        }
        return lm.trim() + " " + xs + "only";
    }


    private static String parseFirst(String s)
    {
        // String[] a = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
        return SINGLE_NUM_ARR[Integer.parseInt(s.substring(s.length() - 1))];
    }


    private static String parseTeen(String s)
    {
        // String[] a = new String[] { "Ten", "Eleven", "Tweleve", "Thirteen", "Fourteen", "Fifteen",
        // "Sixteen","Seventeen", "Eighteen", "Nineteen" };
        return TEN_NUM_ARR[Integer.parseInt(s) - 10];
    }


    private static String parseTen(String s)
    {
        // String[] a = new String[] { "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
        // "Ninety" };
        return TEN_INTEGER_ARR[Integer.parseInt(s.substring(0, 1)) - 1];
    }


    // 两位
    private static String transTwo(String s)
    {
        String value = "";
        // 判断位数
        if (s.length() > 2)
            s = s.substring(0, 2);
        else if (s.length() < 2) s = s + "0";

        if (s.startsWith("0")) // 07 - seven 是否小於10
            value = parseFirst(s);
        else if (s.startsWith("1")) // 17 seventeen 是否在10和20之间
            value = parseTeen(s);
        else if (s.endsWith("0")) // 是否在10与100之间的能被10整除的数
            value = parseTen(s);
        else
            value = parseTen(s) + "-" + parseFirst(s);
        return value;
    }


    private static String parseMore(String s)
    {
        String[] a = new String[] { "", "Thousand", "Million", "Billion" };
        return a[Integer.parseInt(s)];
    }


    // 制作叁位的数
    // s.length = 3
    private static String transThree(String s)
    {
        String value = "";
        if (s.startsWith("0")) // 是否小於100
            value = transTwo(s.substring(1));
        else if (s.substring(1).equals("00")) // 是否被100整除
            value = parseFirst(s.substring(0, 1)) + " Hundred";
        else
            value = parseFirst(s.substring(0, 1)) + " Hundred " + transTwo(s.substring(1));
        return value;
    }


    private static String reverse(String s)
    {
        char[] aChr = s.toCharArray();
        StringBuffer tmp = new StringBuffer();
        for (int i = aChr.length - 1; i >= 0; i--)
        {
            tmp.append(aChr[i]);
        }
        return tmp.toString();
    }


    public boolean isMoreThan0(BigDecimal value)
    {
        return value != null && value.compareTo(BigDecimal.ZERO) > 0;
    }


    /**
     * 
     * 数值相加,如果都为null,返回null
     *
     */
    public BigDecimal customerAdd(BigDecimal value1, BigDecimal value2)
    {
        if (null == value1 && null == value2)
        {
            return null;
        }
        return format(value1).add(format(value2));
    }


    /**
     * 比较两个金额相差(取绝对值)是否在一个范围内
     * 
     * @param amt
     * @param compareAmt
     * @param range
     * @return boolean
     */
    public boolean compareAmtBetweenRange(BigDecimal amt, BigDecimal compareAmt, BigDecimal range)
    {
        if (amt != null && compareAmt != null && amt.subtract(compareAmt).abs().compareTo(range) <= 0)
        {
            return true;
        }
        return false;
    }

}
