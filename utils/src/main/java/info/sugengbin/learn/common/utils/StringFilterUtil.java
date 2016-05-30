/** 
 * Project Name:utils 
 * File Name:StringFilterUtil.java 
 * Package Name:info.sugengbin.learn.common.utils 
 * Date:2016年5月30日下午11:47:10 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
*/ 
package info.sugengbin.learn.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/** 
 * ClassName:StringFilterUtil <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年5月30日 下午11:47:10 <br/> 
 * @author   sugengbin 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
/*
* Copyright 2015-2020 SF-Express Tech Company.
*/
public class StringFilterUtil {

    private static final String REGEX_SCRIPT = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
    private static final String REGEX_STYLE = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
    private static final String REGEX_HTML = "<[^>]+>";

    /**
     * 过滤script、style、html
     *
     * @param content
     * @return
     */
    public static String filterScript(String content) {
        if (null == content) {
            return StringUtils.EMPTY;
        }
        try {
            Pattern p_script = Pattern.compile(REGEX_SCRIPT, Pattern.CASE_INSENSITIVE);
            Matcher m_script = p_script.matcher(content);
            content = m_script.replaceAll(StringUtils.EMPTY); // 过滤script标签
            Pattern p_style = Pattern.compile(REGEX_STYLE, Pattern.CASE_INSENSITIVE);
            Matcher m_style = p_style.matcher(content);
            content = m_style.replaceAll(StringUtils.EMPTY); // 过滤style标签
            Pattern p_html = Pattern.compile(REGEX_HTML, Pattern.CASE_INSENSITIVE);
            Matcher m_html = p_html.matcher(content);
            content = m_html.replaceAll(StringUtils.EMPTY); // 过滤html标签
        } catch (Exception e) {
            return StringUtils.EMPTY;
        }
        return content;
    }
}