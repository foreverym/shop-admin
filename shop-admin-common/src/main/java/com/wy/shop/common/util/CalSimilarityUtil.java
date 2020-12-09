package com.wy.shop.common.util;

/**
 * @author xpguo
 */
public class CalSimilarityUtil
{
    /**
     * 莱文斯坦距离，又称 Levenshtein 距离，是编辑距离的一种。指两个字串之间，由一个转成另一个所需的最少编辑操作次数。
     * 
     * @param a
     * @param b
     * @return
     */
    public static float levenshtein(String a, String b)
    {
        if (a == null && b == null)
        {
            return 1f;
        }
        if (a == null || b == null)
        {
            return 0F;
        }
        int editDistance = editDis(a, b);
        return 1 - ((float) editDistance / Math.max(a.length(), b.length()));
    }


    private static int editDis(String a, String b)
    {

        int aLen = a.length();
        int bLen = b.length();

        if (aLen == 0)
        {
            return aLen;
        }
        if (bLen == 0)
        {
            return bLen;
        }

        int[][] v = new int[aLen + 1][bLen + 1];
        for (int i = 0; i <= aLen; ++i)
        {
            for (int j = 0; j <= bLen; ++j)
            {
                if (i == 0)
                {
                    v[i][j] = j;
                }
                else if (j == 0)
                {
                    v[i][j] = i;
                }
                else if (a.charAt(i - 1) == b.charAt(j - 1))
                {
                    v[i][j] = v[i - 1][j - 1];
                }
                else
                {
                    v[i][j] = 1 + Math.min(v[i - 1][j - 1], Math.min(v[i][j - 1], v[i - 1][j]));
                }
            }
        }
        return v[aLen][bLen];
    }
}
