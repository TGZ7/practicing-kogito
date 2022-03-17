package org.acme;

import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.drools.core.util.KieFunctions;

@javax.enterprise.context.ApplicationScoped()
@javax.inject.Named("text_processor")
@io.quarkus.runtime.Startup()
public class Text_processorProcess extends org.kie.kogito.process.impl.AbstractProcess<org.acme.Text_processorModel> {

    public Text_processorProcess(org.kie.kogito.app.Application app) {
        this(app, new org.kie.kogito.handlers.TextProcessor_toUpper_3_Handler());
    }

    @javax.inject.Inject()
    public Text_processorProcess(org.kie.kogito.app.Application app, org.kie.kogito.handlers.TextProcessor_toUpper_3_Handler textProcessor_toUpper_3_Handler) {
        super(app, java.util.Arrays.asList(textProcessor_toUpper_3_Handler));
        activate();
    }

    public Text_processorProcess() {
    }

    @Override()
    public org.acme.Text_processorProcessInstance createInstance(org.acme.Text_processorModel value) {
        return new org.acme.Text_processorProcessInstance(this, value, this.createProcessRuntime());
    }

    public org.acme.Text_processorProcessInstance createInstance(java.lang.String businessKey, org.acme.Text_processorModel value) {
        return new org.acme.Text_processorProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    @Override()
    public org.acme.Text_processorModel createModel() {
        return new org.acme.Text_processorModel();
    }

    public org.acme.Text_processorProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.acme.Text_processorModel) value);
    }

    public org.acme.Text_processorProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.acme.Text_processorModel) value);
    }

    public org.acme.Text_processorProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.Text_processorProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public org.acme.Text_processorProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.Text_processorProcessInstance(this, this.createModel(), wpi);
    }

    public org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("text_processor");
        factory.variable("mytext", new ObjectDataType("java.lang.String"), "customTags", null);
        factory.name("Text_processor");
        factory.packageName("org.acme");
        factory.dynamic(false);
        factory.version("1.0");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode1 = factory.actionNode(1);
        actionNode1.name("Imprime el texto");
        actionNode1.action(kcontext -> {
            java.lang.String mytext = (java.lang.String) kcontext.getVariable("mytext");
            System.out.println(mytext);
        });
        actionNode1.metaData("UniqueId", "_4B67D9BC-5617-4335-A4EC-5309FDC112C4");
        actionNode1.metaData("elementname", "Imprime el texto");
        actionNode1.metaData("NodeType", "ScriptTask");
        actionNode1.metaData("x", 562);
        actionNode1.metaData("width", 154);
        actionNode1.metaData("y", 175);
        actionNode1.metaData("height", 102);
        actionNode1.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode2 = factory.endNode(2);
        endNode2.name("End");
        endNode2.terminate(false);
        endNode2.metaData("UniqueId", "_A6902151-5E9D-48F7-95E9-375E41CF3E6F");
        endNode2.metaData("x", 846);
        endNode2.metaData("width", 56);
        endNode2.metaData("y", 198);
        endNode2.metaData("height", 56);
        endNode2.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode3 = factory.workItemNode(3);
        workItemNode3.name("Procesa el texto");
        workItemNode3.workName("org.acme.TextProcessor_toUpper_3_Handler");
        workItemNode3.workParameter("Interface", "org.acme.TextProcessor");
        workItemNode3.workParameter("Operation", "toUpper");
        workItemNode3.workParameter("interfaceImplementationRef", "org.acme.TextProcessor");
        workItemNode3.workParameter("operationImplementationRef", "toUpper");
        workItemNode3.workParameter("implementation", "Java");
        workItemNode3.inMapping("text", "mytext");
        workItemNode3.outMapping("text", "mytext");
        workItemNode3.done();
        workItemNode3.metaData("UniqueId", "_3CDC6E61-DCC5-4831-8BBB-417CFF517CB0");
        workItemNode3.metaData("Implementation", "Java");
        workItemNode3.metaData("elementname", "Procesa el texto");
        workItemNode3.metaData("Type", "Service Task");
        workItemNode3.metaData("OperationRef", "_3CDC6E61-DCC5-4831-8BBB-417CFF517CB0_ServiceOperation");
        workItemNode3.metaData("x", 315);
        workItemNode3.metaData("width", 143);
        workItemNode3.metaData("y", 188);
        workItemNode3.metaData("height", 76);
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode4 = factory.startNode(4);
        startNode4.name("Start");
        startNode4.interrupting(false);
        startNode4.metaData("UniqueId", "_75AC8C0C-CFBD-4ADF-A3B4-83AB90581A73");
        startNode4.metaData("x", 176);
        startNode4.metaData("width", 56);
        startNode4.metaData("y", 198);
        startNode4.metaData("height", 56);
        startNode4.done();
        factory.connection(3, 1, "_D764D3B4-1533-4962-A9E3-739A6DD9AEAB");
        factory.connection(1, 2, "_92D17409-36E6-4798-AA5A-EA9C9F2D880C");
        factory.connection(4, 3, "_00AB4A77-D70F-4086-8BA6-57DD017A5323");
        factory.validate();
        return factory.getProcess();
    }
}
