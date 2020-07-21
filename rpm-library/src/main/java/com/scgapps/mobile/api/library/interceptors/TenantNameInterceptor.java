// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package com.scgapps.mobile.api.library.interceptors;


import com.scgapps.mobile.api.library.multitenancy.ThreadLocalStorage;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TenantNameInterceptor extends HandlerInterceptorAdapter {
    private String headerTokenName;
    private TenantNameInterceptor(){}

    public TenantNameInterceptor(String headerTokenName){
        this.headerTokenName = headerTokenName;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String tenantName = request.getHeader(headerTokenName);
        ThreadLocalStorage.setTenantName(tenantName);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalStorage.setTenantName(null);
    }
}
