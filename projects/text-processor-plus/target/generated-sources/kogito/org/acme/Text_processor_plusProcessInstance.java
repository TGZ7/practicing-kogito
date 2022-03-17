package org.acme;

public class Text_processor_plusProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<Text_processor_plusModel> {

    public Text_processor_plusProcessInstance(org.acme.Text_processor_plusProcess process, Text_processor_plusModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public Text_processor_plusProcessInstance(org.acme.Text_processor_plusProcess process, Text_processor_plusModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public Text_processor_plusProcessInstance(org.acme.Text_processor_plusProcess process, Text_processor_plusModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public Text_processor_plusProcessInstance(org.acme.Text_processor_plusProcess process, Text_processor_plusModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    protected java.util.Map<String, Object> bind(Text_processor_plusModel variables) {
        return variables.toMap();
    }

    protected void unbind(Text_processor_plusModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
