/*
 * Copyright 2012 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.drools.ide.common.client.modeldriven.dt52.auditlog;

import org.drools.ide.common.client.modeldriven.auditlog.AuditLogEntry;
import org.drools.ide.common.client.modeldriven.dt52.AttributeCol52;
import org.drools.ide.common.client.modeldriven.dt52.BaseColumn;
import org.drools.ide.common.client.modeldriven.dt52.MetadataCol52;
import org.drools.ide.common.client.modeldriven.dt52.auditlog.DecisionTableAuditLogFilter.DecisionTableAuditEvents;

/**
 * An Audit Event for when a column is deleted
 */
public class DeleteColumnAuditLogEntry extends AuditLogEntry {

    private static final long   serialVersionUID = 2118763458557017503L;

    private static final String TYPE             = DecisionTableAuditEvents.DELETE_COLUMN.name();

    private String              columnHeader;

    public DeleteColumnAuditLogEntry() {
    }

    public DeleteColumnAuditLogEntry(final BaseColumn column) {
        if ( column instanceof MetadataCol52 ) {
            this.columnHeader = ((MetadataCol52) column).getMetadata();
        } else if ( column instanceof AttributeCol52 ) {
            this.columnHeader = ((AttributeCol52) column).getAttribute();
        } else {
            this.columnHeader = column.getHeader();
        }
    }

    @Override
    public String getGenericType() {
        return TYPE;
    }

    public String getColumnHeader() {
        return this.columnHeader;
    }

}
