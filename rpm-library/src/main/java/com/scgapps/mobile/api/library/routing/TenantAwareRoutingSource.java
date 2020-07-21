// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package com.scgapps.mobile.api.library.routing;


import com.scgapps.mobile.api.library.multitenancy.ThreadLocalStorage;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class TenantAwareRoutingSource extends AbstractRoutingDataSource {
    private String defaultTenant;

    private TenantAwareRoutingSource(){}

    public TenantAwareRoutingSource(String defaultTenant){
        this.defaultTenant = defaultTenant;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        if (ThreadLocalStorage.getTenantName() == null)
            return defaultTenant;

        return ThreadLocalStorage.getTenantName();
    }

}
