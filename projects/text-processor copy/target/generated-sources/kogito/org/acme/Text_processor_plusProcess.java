package org.acme;

import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.drools.core.util.KieFunctions;

@javax.enterprise.context.ApplicationScoped()
@javax.inject.Named("text_processor_plus")
@io.quarkus.runtime.Startup()
public class Text_processor_plusProcess extends org.kie.kogito.process.impl.AbstractProcess<org.acme.Text_processor_plusModel> {

    public Text_processor_plusProcess(org.kie.kogito.app.Application app) {
        this(app, new org.kie.kogito.handlers.TextProcessor_toUpper_4_Handler());
    }

    @javax.inject.Inject()
    public Text_processor_plusProcess(org.kie.kogito.app.Application app, org.kie.kogito.handlers.TextProcessor_toUpper_4_Handler textProcessor_toUpper_4_Handler) {
        super(app, java.util.Arrays.asList(textProcessor_toUpper_4_Handler));
        activate();
    }

    public Text_processor_plusProcess() {
    }

    @Override()
    public org.acme.Text_processor_plusProcessInstance createInstance(org.acme.Text_processor_plusModel value) {
        return new org.acme.Text_processor_plusProcessInstance(this, value, this.createProcessRuntime());
    }

    public org.acme.Text_processor_plusProcessInstance createInstance(java.lang.String businessKey, org.acme.Text_processor_plusModel value) {
        return new org.acme.Text_processor_plusProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    @Override()
    public org.acme.Text_processor_plusModel createModel() {
        return new org.acme.Text_processor_plusModel();
    }

    public org.acme.Text_processor_plusProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.acme.Text_processor_plusModel) value);
    }

    public org.acme.Text_processor_plusProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.acme.Text_processor_plusModel) value);
    }

    public org.acme.Text_processor_plusProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.Text_processor_plusProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public org.acme.Text_processor_plusProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.Text_processor_plusProcessInstance(this, this.createModel(), wpi);
    }

    public org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("text_processor_plus");
        factory.variable("mytext", new ObjectDataType("java.lang.String"), "customTags", null);
        factory.variable("campain", new ObjectDataType("org.acme.Campain"), "customTags", null);
        factory.name("Text_processor_plus");
        factory.packageName("org.acme");
        factory.dynamic(false);
        factory.version("1.0");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode1 = factory.endNode(1);
        endNode1.name("End");
        endNode1.terminate(false);
        endNode1.metaData("UniqueId", "_7291F8A1-4E3F-46D3-B517-13D6A0C62894");
        endNode1.metaData("x", 1046);
        endNode1.metaData("width", 56);
        endNode1.metaData("y", 198);
        endNode1.metaData("height", 56);
        endNode1.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode2 = factory.actionNode(2);
        actionNode2.name("Imprime campain.getNombre()");
        actionNode2.action(kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            System.out.println(campain.getNombre());
        });
        actionNode2.metaData("UniqueId", "_92BCD222-8335-47DF-B15D-F938875722BA");
        actionNode2.metaData("elementname", "Imprime campain.getNombre()");
        actionNode2.metaData("NodeType", "ScriptTask");
        actionNode2.metaData("x", 812);
        actionNode2.metaData("width", 154);
        actionNode2.metaData("y", 175);
        actionNode2.metaData("height", 102);
        actionNode2.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode3 = factory.actionNode(3);
        actionNode3.name("Imprime el texto");
        actionNode3.action(kcontext -> {
            java.lang.String mytext = (java.lang.String) kcontext.getVariable("mytext");
            System.out.println(mytext);
        });
        actionNode3.metaData("UniqueId", "_4B67D9BC-5617-4335-A4EC-5309FDC112C4");
        actionNode3.metaData("elementname", "Imprime el texto");
        actionNode3.metaData("NodeType", "ScriptTask");
        actionNode3.metaData("x", 562);
        actionNode3.metaData("width", 154);
        actionNode3.metaData("y", 175);
        actionNode3.metaData("height", 102);
        actionNode3.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode4 = factory.workItemNode(4);
        workItemNode4.name("Procesa el texto");
        workItemNode4.workName("org.acme.TextProcessor_toUpper_4_Handler");
        workItemNode4.workParameter("Interface", "org.acme.TextProcessor");
        workItemNode4.workParameter("Operation", "toUpper");
        workItemNode4.workParameter("interfaceImplementationRef", "org.acme.TextProcessor");
        workItemNode4.workParameter("operationImplementationRef", "toUpper");
        workItemNode4.workParameter("implementation", "Java");
        workItemNode4.inMapping("text", "mytext");
        workItemNode4.outMapping("text", "mytext");
        workItemNode4.done();
        workItemNode4.metaData("UniqueId", "_3CDC6E61-DCC5-4831-8BBB-417CFF517CB0");
        workItemNode4.metaData("Implementation", "Java");
        workItemNode4.metaData("elementname", "Procesa el texto");
        workItemNode4.metaData("Type", "Service Task");
        workItemNode4.metaData("OperationRef", "_3CDC6E61-DCC5-4831-8BBB-417CFF517CB0_ServiceOperation");
        workItemNode4.metaData("x", 315);
        workItemNode4.metaData("width", 143);
        workItemNode4.metaData("y", 188);
        workItemNode4.metaData("height", 76);
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode5 = factory.startNode(5);
        startNode5.name("Start");
        startNode5.interrupting(false);
        startNode5.metaData("UniqueId", "_75AC8C0C-CFBD-4ADF-A3B4-83AB90581A73");
        startNode5.metaData("x", 176);
        startNode5.metaData("width", 56);
        startNode5.metaData("y", 198);
        startNode5.metaData("height", 56);
        startNode5.done();
        factory.connection(2, 1, "_8B33D751-067A-4E6B-AF96-24BF2127EA6B");
        factory.connection(3, 2, "_34C392CC-2377-4257-9DF5-1B500287FE5A");
        factory.connection(4, 3, "_D764D3B4-1533-4962-A9E3-739A6DD9AEAB");
        factory.connection(5, 4, "_00AB4A77-D70F-4086-8BA6-57DD017A5323");
        factory.validate();
        return factory.getProcess();
    }
}
