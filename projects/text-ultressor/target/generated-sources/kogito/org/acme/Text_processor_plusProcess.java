package org.acme;

import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.drools.core.util.KieFunctions;

@javax.enterprise.context.ApplicationScoped()
@javax.inject.Named("text_processor_plus")
@io.quarkus.runtime.Startup()
public class Text_processor_plusProcess extends org.kie.kogito.process.impl.AbstractProcess<org.acme.Text_processor_plusModel> {

    public Text_processor_plusProcess(org.kie.kogito.app.Application app) {
        this(app, new org.kie.kogito.handlers.Processor_toUpper_6_Handler(), new org.kie.kogito.handlers.Processor_isEnded_3_Handler());
    }

    @javax.inject.Inject()
    public Text_processor_plusProcess(org.kie.kogito.app.Application app, org.kie.kogito.handlers.Processor_toUpper_6_Handler processor_toUpper_6_Handler, org.kie.kogito.handlers.Processor_isEnded_3_Handler processor_isEnded_3_Handler) {
        super(app, java.util.Arrays.asList(processor_toUpper_6_Handler, processor_isEnded_3_Handler));
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
        factory.variable("ended", new ObjectDataType("java.lang.Boolean"), "customTags", null);
        factory.name("Text_processor_plus");
        factory.packageName("org.acme");
        factory.dynamic(false);
        factory.version("1.0");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode1 = factory.endNode(1);
        endNode1.name("End");
        endNode1.terminate(false);
        endNode1.metaData("UniqueId", "_1F47A5F6-20B5-43CA-8DB1-897EEA03BB9A");
        endNode1.metaData("x", 1514);
        endNode1.metaData("width", 56);
        endNode1.metaData("y", 198);
        endNode1.metaData("height", 56);
        endNode1.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode2 = factory.actionNode(2);
        actionNode2.name("Imprime si está finalizada la campaña");
        actionNode2.action(kcontext -> {
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            System.out.println("¿Está finalizada?: " + ended);
        });
        actionNode2.metaData("UniqueId", "_726C69CE-6944-4A57-AC5D-D0D4A477B02C");
        actionNode2.metaData("elementname", "Imprime si está finalizada la campaña");
        actionNode2.metaData("NodeType", "ScriptTask");
        actionNode2.metaData("x", 1280);
        actionNode2.metaData("width", 154);
        actionNode2.metaData("y", 175);
        actionNode2.metaData("height", 102);
        actionNode2.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode3 = factory.workItemNode(3);
        workItemNode3.name("Estado de la campaña");
        workItemNode3.workName("org.acme.Processor_isEnded_3_Handler");
        workItemNode3.workParameter("Interface", "org.acme.Processor");
        workItemNode3.workParameter("Operation", "isEnded");
        workItemNode3.workParameter("interfaceImplementationRef", "org.acme.Processor");
        workItemNode3.workParameter("operationImplementationRef", "isEnded");
        workItemNode3.workParameter("implementation", "Java");
        workItemNode3.inMapping("campain", "campain");
        workItemNode3.outMapping("ended", "ended");
        workItemNode3.done();
        workItemNode3.metaData("UniqueId", "_C7A7BF5F-64E9-4CF8-8203-AE3A1A90AAF6");
        workItemNode3.metaData("Implementation", "Java");
        workItemNode3.metaData("elementname", "Estado de la campaña");
        workItemNode3.metaData("Type", "Service Task");
        workItemNode3.metaData("OperationRef", "_C7A7BF5F-64E9-4CF8-8203-AE3A1A90AAF6_ServiceOperation");
        workItemNode3.metaData("x", 1046);
        workItemNode3.metaData("width", 154);
        workItemNode3.metaData("y", 175);
        workItemNode3.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode4 = factory.actionNode(4);
        actionNode4.name("Imprime campain.getNombre()");
        actionNode4.action(kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            System.out.println(campain.getNombre());
        });
        actionNode4.metaData("UniqueId", "_92BCD222-8335-47DF-B15D-F938875722BA");
        actionNode4.metaData("elementname", "Imprime campain.getNombre()");
        actionNode4.metaData("NodeType", "ScriptTask");
        actionNode4.metaData("x", 812);
        actionNode4.metaData("width", 154);
        actionNode4.metaData("y", 175);
        actionNode4.metaData("height", 102);
        actionNode4.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode5 = factory.actionNode(5);
        actionNode5.name("Imprime el texto");
        actionNode5.action(kcontext -> {
            java.lang.String mytext = (java.lang.String) kcontext.getVariable("mytext");
            System.out.println(mytext);
        });
        actionNode5.metaData("UniqueId", "_4B67D9BC-5617-4335-A4EC-5309FDC112C4");
        actionNode5.metaData("elementname", "Imprime el texto");
        actionNode5.metaData("NodeType", "ScriptTask");
        actionNode5.metaData("x", 562);
        actionNode5.metaData("width", 154);
        actionNode5.metaData("y", 175);
        actionNode5.metaData("height", 102);
        actionNode5.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode6 = factory.workItemNode(6);
        workItemNode6.name("Procesa el texto");
        workItemNode6.workName("org.acme.Processor_toUpper_6_Handler");
        workItemNode6.workParameter("Interface", "org.acme.Processor");
        workItemNode6.workParameter("Operation", "toUpper");
        workItemNode6.workParameter("interfaceImplementationRef", "org.acme.Processor");
        workItemNode6.workParameter("operationImplementationRef", "toUpper");
        workItemNode6.workParameter("implementation", "Java");
        workItemNode6.inMapping("text", "mytext");
        workItemNode6.outMapping("text", "mytext");
        workItemNode6.done();
        workItemNode6.metaData("UniqueId", "_3CDC6E61-DCC5-4831-8BBB-417CFF517CB0");
        workItemNode6.metaData("Documentation", "Toma el valor de mytext, lo envía a toUpper de Processor.java y lo actualiza.");
        workItemNode6.metaData("Implementation", "Java");
        workItemNode6.metaData("elementname", "Procesa el texto");
        workItemNode6.metaData("Type", "Service Task");
        workItemNode6.metaData("OperationRef", "_3CDC6E61-DCC5-4831-8BBB-417CFF517CB0_ServiceOperation");
        workItemNode6.metaData("x", 315);
        workItemNode6.metaData("width", 143);
        workItemNode6.metaData("y", 188);
        workItemNode6.metaData("height", 76);
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode7 = factory.startNode(7);
        startNode7.name("Start");
        startNode7.interrupting(false);
        startNode7.metaData("UniqueId", "_75AC8C0C-CFBD-4ADF-A3B4-83AB90581A73");
        startNode7.metaData("x", 176);
        startNode7.metaData("width", 56);
        startNode7.metaData("y", 198);
        startNode7.metaData("height", 56);
        startNode7.done();
        factory.connection(2, 1, "_B8C5E0CC-BB98-434A-9CEE-42A204DE6819");
        factory.connection(3, 2, "_3D8B5462-93A7-4B83-AE70-C3123ABE63D7");
        factory.connection(4, 3, "_5AE3B8F3-A726-4DD1-B019-EAB1361A7775");
        factory.connection(5, 4, "_34C392CC-2377-4257-9DF5-1B500287FE5A");
        factory.connection(6, 5, "_D764D3B4-1533-4962-A9E3-739A6DD9AEAB");
        factory.connection(7, 6, "_00AB4A77-D70F-4086-8BA6-57DD017A5323");
        factory.validate();
        return factory.getProcess();
    }
}
