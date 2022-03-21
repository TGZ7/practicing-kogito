package org.acme;

public class Text_processor_plus_2ProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<Text_processor_plus_2Model> {

    public Text_processor_plus_2ProcessInstance(org.acme.Text_processor_plus_2Process process, Text_processor_plus_2Model value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public Text_processor_plus_2ProcessInstance(org.acme.Text_processor_plus_2Process process, Text_processor_plus_2Model value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public Text_processor_plus_2ProcessInstance(org.acme.Text_processor_plus_2Process process, Text_processor_plus_2Model value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public Text_processor_plus_2ProcessInstance(org.acme.Text_processor_plus_2Process process, Text_processor_plus_2Model value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    protected java.util.Map<String, Object> bind(Text_processor_plus_2Model variables) {
        return variables.toMap();
    }

    protected void unbind(Text_processor_plus_2Model variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
