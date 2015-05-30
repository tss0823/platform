/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.web.velocity;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;
import org.apache.velocity.runtime.parser.node.SimpleNode;

/**
 * 类PopDirective.java的实现描述：弹出窗口指令
 * 
 * @author shengshang.tang 2013年12月1日 下午3:50:50
 */
public class PopDirective extends Directive {

    /*
     * (non-Javadoc)
     * @see org.apache.velocity.runtime.directive.Directive#getName()
     */
    @Override
    public String getName() {
        return "popMenu";
    }

    /*
     * (non-Javadoc)
     * @see org.apache.velocity.runtime.directive.Directive#getType()
     */
    @Override
    public int getType() {
        return LINE;
    }

    /*
     * (non-Javadoc)
     * @see org.apache.velocity.runtime.directive.Directive#render(org.apache.velocity.context.InternalContextAdapter,
     * java.io.Writer, org.apache.velocity.runtime.parser.node.Node)
     */
    @Override
    public boolean render(InternalContextAdapter context, Writer writer, Node node) throws IOException,
                                                                                   ResourceNotFoundException,
                                                                                   ParseErrorException,
                                                                                   MethodInvocationException {

        Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
        int childNum = node.jjtGetNumChildren();
        // 格式：{\"remove\":{\"url\":\"xxx.htm\",\"text\":\"删除\"}}
        for (int i = 0; i < childNum; i++) {
            SimpleNode snData = (SimpleNode) node.jjtGetChild(i);
            Object data = snData.value(context);
            map.putAll((Map<String, Map<String, String>>) data);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<input type=\"button\" value=\"打开\" class=\"btn\" id=\"popBtn\"/>");
        sb.append("<div class=\"pop_menu\">");
        sb.append("<ul>");
        Set<Entry<String, Map<String, String>>> set = map.entrySet();
        for (Entry<String, Map<String, String>> entry : set) {
            String key = entry.getKey();
            Map<String, String> value = entry.getValue();
            sb.append("<li>");
            if (key.startsWith("a_")) {
                sb.append("<a href=\"" + value.get("url") + "\" ");
                String target = value.get("target");
                if (StringUtils.isNotEmpty(target)) {
                    sb.append("target=\"" + target + "\"");
                }
            } else {
                sb.append("<a href=\"javascript:void(0)\" id=\"" + key + "\" param-id=\"" + value.get("param-id")
                          + "\" ");
                String title = value.get("param-title");
                if (title != null) {
                    sb.append("param-title=\"" + title + "\"");
                }
            }
            sb.append(">" + value.get("text") + "</a></li>");
        }
        sb.append("</ul>");
        sb.append("</div>");
        String vel = "#foreach($member in $data.entrySet())<li>$member.key - $member.value</li>#end ";
        writer.write(sb.toString());
        return true;
    }

}
