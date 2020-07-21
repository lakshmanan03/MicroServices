package com.scgapps.mobile.api.library.config;

import com.scgapps.mobile.api.library.multitenancy.ThreadLocalStorage;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor
{
   @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(TenantConstants.headerTenantKey,ThreadLocalStorage.getTenantName());
    }
}
