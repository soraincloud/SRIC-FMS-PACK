package com.spring.springboot.tools;

import org.springframework.stereotype.Component;
import org.springframework.core.io.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

//从HttpServletRequest的attribute中读取文件path，然后返回给ResourceHttpRequestHandler处理

@Component
public class StaticResourceHttpRequestHandler extends ResourceHttpRequestHandler
{
    public final static String ATTR_FILE = "NON-STATIC-FILE";

    @Override
    protected Resource getResource(HttpServletRequest request)
    {
        String filePath = (String) request.getAttribute(ATTR_FILE);
        return new FileSystemResource(filePath);
    }
}
