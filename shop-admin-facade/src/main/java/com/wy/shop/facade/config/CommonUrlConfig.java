package com.wy.shop.facade.config;

/**
 * @author : WangYB
 * @time: 2020/12/9  11:11
 */
public class CommonUrlConfig {


    public static final int DEFAULT_VERSION = 1;
    public static final String VERSION_PLACEHOLDER = "/{api_version}";
    private static final String VERSION_PRE_FIX = "/v";


    public static final String INDEX_URL_PREFIX = "/index";

    /** */
    public static final String URL_INDEX_QUERY_PANEL_INFO = "/panel";

    /** */
    public static final String URL_FGDS_SOR_INV_EXPORT_QUERY_LIST = "/sor/inv/export/query/list";
    /**
     * 获取默认版本的URL
     *
     * @param url 具体的URL
     * @return URL 不包含 ip port context
     */
    public static String getUrl(String url)
    {
        return getUrl(INDEX_URL_PREFIX, url, DEFAULT_VERSION);
    }


    /**
     * 获取默认版本的URL
     *
     * @param url 具体的URL
     * @return URL 不包含 ip port context
     */
    public static String getUrl(String url, int version)
    {
        return getUrl(INDEX_URL_PREFIX, url, version);
    }


    /**
     * 获取URL版本
     *
     * @param version
     * @return
     */
    protected static String getVersion(int version)
    {
        if (version <= 0)
        {
            version = 1;
        }
        return VERSION_PRE_FIX + version;
    }


    /**
     * 获取默认版本的URL
     *
     * @param prefix URL隶属于
     * @param url 具体的URL
     * @return URL 不包含 ip port context
     */
    public static String getUrl(String prefix, String url)
    {
        return getUrl(prefix, url, DEFAULT_VERSION);
    }


    /**
     * 获取指定的版本
     *
     * @param prefix URL隶属于
     * @param url 具体的URL
     * @param version URL版本
     * @return URL 不包含 ip port context
     */
    public static String getUrl(String prefix, String url, int version)
    {
        return prefix + url + getVersion(version);
    }


}
