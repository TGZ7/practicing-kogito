package org.acme;

public class Text_processorProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<Text_processorModel> {

    public Text_processorProcessInstance(org.acme.Text_processorProcess process, Text_processorModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public Text_processorProcessInstance(org.acme.Text_processorProcess process, Text_processorModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public Text_processorProcessInstance(org.acme.Text_processorProcess process, Text_processorModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public Text_processorProcessInstance(org.acme.Text_processorProcess process, Text_processorModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    protected java.util.Map<String, Object> bind(Text_processorModel variables) {
        return variables.toMap();
    }

    protected void unbind(Text_processorModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
