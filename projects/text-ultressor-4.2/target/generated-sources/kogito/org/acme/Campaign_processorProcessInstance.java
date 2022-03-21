package org.acme;

public class Campaign_processorProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<Campaign_processorModel> {

    public Campaign_processorProcessInstance(org.acme.Campaign_processorProcess process, Campaign_processorModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public Campaign_processorProcessInstance(org.acme.Campaign_processorProcess process, Campaign_processorModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public Campaign_processorProcessInstance(org.acme.Campaign_processorProcess process, Campaign_processorModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public Campaign_processorProcessInstance(org.acme.Campaign_processorProcess process, Campaign_processorModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    protected java.util.Map<String, Object> bind(Campaign_processorModel variables) {
        return variables.toMap();
    }

    protected void unbind(Campaign_processorModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
