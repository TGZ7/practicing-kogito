package org.kie.kogito.handlers;

import org.kie.kogito.process.workitem.WorkItemExecutionException;

@javax.enterprise.context.ApplicationScoped()
public class Processor_isPopular_11_Handler implements org.kie.kogito.internal.process.runtime.KogitoWorkItemHandler {

    org.acme.Processor service;

    public Processor_isPopular_11_Handler() {
        this(new org.acme.Processor());
    }

    @javax.inject.Inject()
    public Processor_isPopular_11_Handler(org.acme.Processor service) {
        this.service = service;
    }

    public void executeWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
        java.lang.Object result;
        result = service.isPopular((org.acme.Campain) workItem.getParameter("campain"));
        workItemManager.completeWorkItem(workItem.getStringId(), java.util.Collections.singletonMap("popular", result));
    }

    public void abortWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
    }

    public String getName() {
        return "org.acme.Processor_isPopular_11_Handler";
    }
}
