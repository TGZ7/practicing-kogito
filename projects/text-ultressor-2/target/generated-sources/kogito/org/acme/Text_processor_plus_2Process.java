package org.acme;

import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.drools.core.util.KieFunctions;

@javax.enterprise.context.ApplicationScoped()
@javax.inject.Named("text_processor_plus_2")
@io.quarkus.runtime.Startup()
public class Text_processor_plus_2Process extends org.kie.kogito.process.impl.AbstractProcess<org.acme.Text_processor_plus_2Model> {

    public Text_processor_plus_2Process(org.kie.kogito.app.Application app) {
        this(app, new org.kie.kogito.handlers.Processor_isLiked_7_Handler(), new org.kie.kogito.handlers.Processor_isPopular_3_Handler(), new org.kie.kogito.handlers.Processor_isEnded_9_Handler());
    }

    @javax.inject.Inject()
    public Text_processor_plus_2Process(org.kie.kogito.app.Application app, org.kie.kogito.handlers.Processor_isLiked_7_Handler processor_isLiked_7_Handler, org.kie.kogito.handlers.Processor_isPopular_3_Handler processor_isPopular_3_Handler, org.kie.kogito.handlers.Processor_isEnded_9_Handler processor_isEnded_9_Handler) {
        super(app, java.util.Arrays.asList(processor_isLiked_7_Handler, processor_isPopular_3_Handler, processor_isEnded_9_Handler));
        activate();
    }

    public Text_processor_plus_2Process() {
    }

    @Override()
    public org.acme.Text_processor_plus_2ProcessInstance createInstance(org.acme.Text_processor_plus_2Model value) {
        return new org.acme.Text_processor_plus_2ProcessInstance(this, value, this.createProcessRuntime());
    }

    public org.acme.Text_processor_plus_2ProcessInstance createInstance(java.lang.String businessKey, org.acme.Text_processor_plus_2Model value) {
        return new org.acme.Text_processor_plus_2ProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    @Override()
    public org.acme.Text_processor_plus_2Model createModel() {
        return new org.acme.Text_processor_plus_2Model();
    }

    public org.acme.Text_processor_plus_2ProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.acme.Text_processor_plus_2Model) value);
    }

    public org.acme.Text_processor_plus_2ProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.acme.Text_processor_plus_2Model) value);
    }

    public org.acme.Text_processor_plus_2ProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.Text_processor_plus_2ProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public org.acme.Text_processor_plus_2ProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.Text_processor_plus_2ProcessInstance(this, this.createModel(), wpi);
    }

    public org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("text_processor_plus_2");
        factory.variable("campain", new ObjectDataType("org.acme.Campain"), "customTags", null);
        factory.variable("ended", new ObjectDataType("java.lang.Boolean"), "customTags", null);
        factory.variable("liked", new ObjectDataType("java.lang.Boolean"), "customTags", null);
        factory.variable("popular", new ObjectDataType("java.lang.Boolean"), "customTags", null);
        factory.name("Text_processor_plus_2");
        factory.packageName("org.acme");
        factory.dynamic(false);
        factory.version("1.0");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode1 = factory.endNode(1);
        endNode1.name("End");
        endNode1.terminate(false);
        endNode1.metaData("UniqueId", "_5A2BCA44-2D03-4DF5-BE32-6E962973794E");
        endNode1.metaData("x", 2583);
        endNode1.metaData("width", 56);
        endNode1.metaData("y", 198);
        endNode1.metaData("height", 56);
        endNode1.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode2 = factory.actionNode(2);
        actionNode2.name("Lo imprime");
        actionNode2.action(kcontext -> {
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            System.out.println("¿Es popular?: " + popular);
        });
        actionNode2.metaData("UniqueId", "_37B03191-C450-4159-9C0D-4F8008A216A5");
        actionNode2.metaData("elementname", "Lo imprime");
        actionNode2.metaData("NodeType", "ScriptTask");
        actionNode2.metaData("x", 2349);
        actionNode2.metaData("width", 154);
        actionNode2.metaData("y", 175);
        actionNode2.metaData("height", 102);
        actionNode2.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode3 = factory.workItemNode(3);
        workItemNode3.name("¿Es popular?");
        workItemNode3.workName("org.acme.Processor_isPopular_3_Handler");
        workItemNode3.workParameter("Interface", "org.acme.Processor");
        workItemNode3.workParameter("Operation", "isPopular");
        workItemNode3.workParameter("interfaceImplementationRef", "org.acme.Processor");
        workItemNode3.workParameter("operationImplementationRef", "isPopular");
        workItemNode3.workParameter("implementation", "Java");
        workItemNode3.inMapping("campain", "campain");
        workItemNode3.outMapping("popular", "popular");
        workItemNode3.done();
        workItemNode3.metaData("UniqueId", "_0238D43E-8633-41F7-A49C-44FB8E5738CA");
        workItemNode3.metaData("Implementation", "Java");
        workItemNode3.metaData("elementname", "¿Es popular?");
        workItemNode3.metaData("Type", "Service Task");
        workItemNode3.metaData("OperationRef", "_0238D43E-8633-41F7-A49C-44FB8E5738CA_ServiceOperation");
        workItemNode3.metaData("x", 2115);
        workItemNode3.metaData("width", 154);
        workItemNode3.metaData("y", 175);
        workItemNode3.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode4 = factory.endNode(4);
        endNode4.name("End");
        endNode4.terminate(false);
        endNode4.metaData("UniqueId", "_31638212-8566-4A88-AB61-47AA0B84F250");
        endNode4.metaData("x", 1499);
        endNode4.metaData("width", 56);
        endNode4.metaData("y", 354);
        endNode4.metaData("height", 56);
        endNode4.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode5 = factory.splitNode(5);
        splitNode5.name("Split");
        splitNode5.type(2);
        splitNode5.metaData("UniqueId", "_914C5A2C-CDBB-473F-B3FA-39E436FC39ED");
        splitNode5.metaData("x", 1499);
        splitNode5.metaData("width", 56);
        splitNode5.metaData("y", 197);
        splitNode5.metaData("height", 56);
        splitNode5.constraint(7, "_18243FDA-763B-4EF5-9021-93742C0E8F81", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            return ended == true;
        }, 0);
        splitNode5.constraint(4, "_4A81A14D-48CD-4A33-9589-89D01F30653E", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            return ended == false;
        }, 0);
        splitNode5.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode6 = factory.actionNode(6);
        actionNode6.name("Lo imprime");
        actionNode6.action(kcontext -> {
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            System.out.println("¿Más likes que dislikes?: " + liked);
        });
        actionNode6.metaData("UniqueId", "_6E620AA7-A217-4DA6-A21A-704F3326C97C");
        actionNode6.metaData("elementname", "Lo imprime");
        actionNode6.metaData("NodeType", "ScriptTask");
        actionNode6.metaData("x", 1881);
        actionNode6.metaData("width", 154);
        actionNode6.metaData("y", 175);
        actionNode6.metaData("height", 102);
        actionNode6.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode7 = factory.workItemNode(7);
        workItemNode7.name("¿Tiene más likes que dislikes?");
        workItemNode7.workName("org.acme.Processor_isLiked_7_Handler");
        workItemNode7.workParameter("Interface", "org.acme.Processor");
        workItemNode7.workParameter("Operation", "isLiked");
        workItemNode7.workParameter("interfaceImplementationRef", "org.acme.Processor");
        workItemNode7.workParameter("operationImplementationRef", "isLiked");
        workItemNode7.workParameter("implementation", "Java");
        workItemNode7.inMapping("campain", "campain");
        workItemNode7.outMapping("liked", "liked");
        workItemNode7.done();
        workItemNode7.metaData("UniqueId", "_6A2B63E7-69E0-440B-BF1D-E49443FFCF12");
        workItemNode7.metaData("Implementation", "Java");
        workItemNode7.metaData("elementname", "¿Tiene más likes que dislikes?");
        workItemNode7.metaData("Type", "Service Task");
        workItemNode7.metaData("OperationRef", "_6A2B63E7-69E0-440B-BF1D-E49443FFCF12_ServiceOperation");
        workItemNode7.metaData("x", 1647);
        workItemNode7.metaData("width", 154);
        workItemNode7.metaData("y", 175);
        workItemNode7.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode8 = factory.actionNode(8);
        actionNode8.name("Imprime el estado");
        actionNode8.action(kcontext -> {
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            System.out.println("¿Está finalizada?: " + ended);
        });
        actionNode8.metaData("UniqueId", "_726C69CE-6944-4A57-AC5D-D0D4A477B02C");
        actionNode8.metaData("elementname", "Imprime el estado");
        actionNode8.metaData("NodeType", "ScriptTask");
        actionNode8.metaData("x", 1280);
        actionNode8.metaData("width", 154);
        actionNode8.metaData("y", 175);
        actionNode8.metaData("height", 102);
        actionNode8.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode9 = factory.workItemNode(9);
        workItemNode9.name("Estado de la campaña");
        workItemNode9.workName("org.acme.Processor_isEnded_9_Handler");
        workItemNode9.workParameter("Interface", "org.acme.Processor");
        workItemNode9.workParameter("Operation", "isEnded");
        workItemNode9.workParameter("interfaceImplementationRef", "org.acme.Processor");
        workItemNode9.workParameter("operationImplementationRef", "isEnded");
        workItemNode9.workParameter("implementation", "Java");
        workItemNode9.inMapping("campain", "campain");
        workItemNode9.outMapping("ended", "ended");
        workItemNode9.done();
        workItemNode9.metaData("UniqueId", "_C7A7BF5F-64E9-4CF8-8203-AE3A1A90AAF6");
        workItemNode9.metaData("Implementation", "Java");
        workItemNode9.metaData("elementname", "Estado de la campaña");
        workItemNode9.metaData("Type", "Service Task");
        workItemNode9.metaData("OperationRef", "_C7A7BF5F-64E9-4CF8-8203-AE3A1A90AAF6_ServiceOperation");
        workItemNode9.metaData("x", 1046);
        workItemNode9.metaData("width", 154);
        workItemNode9.metaData("y", 175);
        workItemNode9.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode10 = factory.actionNode(10);
        actionNode10.name("Imprime el nombre de la campaña");
        actionNode10.action(kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            System.out.println("Nombre de la campaña: " + campain.getNombre());
        });
        actionNode10.metaData("UniqueId", "_92BCD222-8335-47DF-B15D-F938875722BA");
        actionNode10.metaData("elementname", "Imprime el nombre de la campaña");
        actionNode10.metaData("NodeType", "ScriptTask");
        actionNode10.metaData("x", 812);
        actionNode10.metaData("width", 154);
        actionNode10.metaData("y", 175);
        actionNode10.metaData("height", 102);
        actionNode10.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode11 = factory.startNode(11);
        startNode11.name("Start");
        startNode11.interrupting(true);
        startNode11.metaData("UniqueId", "_75AC8C0C-CFBD-4ADF-A3B4-83AB90581A73");
        startNode11.metaData("x", 655);
        startNode11.metaData("width", 56);
        startNode11.metaData("y", 198);
        startNode11.metaData("height", 56);
        startNode11.done();
        factory.connection(2, 1, "_2B4B5768-43A8-4BB3-9F0F-048DD0E2E75D");
        factory.connection(3, 2, "_D9AE0B78-AF4D-4242-BB51-FFEE68FFEC4D");
        factory.connection(6, 3, "_68452D09-95EC-4359-A826-78C45FAC90F2");
        factory.connection(5, 4, "_4A81A14D-48CD-4A33-9589-89D01F30653E");
        factory.connection(8, 5, "_6AE159D0-0A25-454E-B041-4370DC88FE82");
        factory.connection(7, 6, "_696C9E72-5001-460C-B006-92093B1C7DAB");
        factory.connection(5, 7, "_18243FDA-763B-4EF5-9021-93742C0E8F81");
        factory.connection(9, 8, "_3D8B5462-93A7-4B83-AE70-C3123ABE63D7");
        factory.connection(10, 9, "_5AE3B8F3-A726-4DD1-B019-EAB1361A7775");
        factory.connection(11, 10, "_00AB4A77-D70F-4086-8BA6-57DD017A5323");
        factory.validate();
        return factory.getProcess();
    }
}
