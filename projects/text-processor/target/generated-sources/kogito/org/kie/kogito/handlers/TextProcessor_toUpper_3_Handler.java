package org.kie.kogito.handlers;

import org.kie.kogito.process.workitem.WorkItemExecutionException;

@javax.enterprise.context.ApplicationScoped()
public class TextProcessor_toUpper_3_Handler implements org.kie.kogito.internal.process.runtime.KogitoWorkItemHandler {

    org.acme.TextProcessor service;

    public TextProcessor_toUpper_3_Handler() {
        this(new org.acme.TextProcessor());
    }

    @javax.inject.Inject()
    public TextProcessor_toUpper_3_Handler(org.acme.TextProcessor service) {
        this.service = service;
    }

    public void executeWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
        java.lang.Object result;
        result = service.toUpper((String) workItem.getParameter("text"));
        workItemManager.completeWorkItem(workItem.getStringId(), java.util.Collections.singletonMap("text", result));
    }

    public void abortWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
    }

    public String getName() {
        return "org.acme.TextProcessor_toUpper_3_Handler";
    }
}
