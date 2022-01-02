package com.louis.info.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * 赖小燚
 * www.louis.com
 */
public class TestFilter extends HttpServletRequestWrapper {
    public TestFilter(HttpServletRequest request) {
        super(request);
    }
}
