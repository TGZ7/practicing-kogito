package org.acme;

import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.drools.core.util.KieFunctions;

@javax.enterprise.context.ApplicationScoped()
@javax.inject.Named("text_processor_plus_2")
@io.quarkus.runtime.Startup()
public class Text_processor_plus_2Process extends org.kie.kogito.process.impl.AbstractProcess<org.acme.Text_processor_plus_2Model> {

    public Text_processor_plus_2Process(org.kie.kogito.app.Application app) {
        this(app, new org.kie.kogito.handlers.Processor_isPopular_9_Handler(), new org.kie.kogito.handlers.Processor_isEnded_15_Handler(), new org.kie.kogito.handlers.Processor_isLiked_13_Handler());
    }

    @javax.inject.Inject()
    public Text_processor_plus_2Process(org.kie.kogito.app.Application app, org.kie.kogito.handlers.Processor_isPopular_9_Handler processor_isPopular_9_Handler, org.kie.kogito.handlers.Processor_isEnded_15_Handler processor_isEnded_15_Handler, org.kie.kogito.handlers.Processor_isLiked_13_Handler processor_isLiked_13_Handler) {
        super(app, java.util.Arrays.asList(processor_isPopular_9_Handler, processor_isEnded_15_Handler, processor_isLiked_13_Handler));
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
        endNode1.metaData("UniqueId", "_E58659E3-111D-4357-ADFA-3C6CACDA0673");
        endNode1.metaData("x", 1926);
        endNode1.metaData("width", 56);
        endNode1.metaData("y", 354);
        endNode1.metaData("height", 56);
        endNode1.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode2 = factory.splitNode(2);
        splitNode2.name("Split");
        splitNode2.type(2);
        splitNode2.metaData("UniqueId", "_FEE03E74-2092-4869-8164-10BE9BCB4540");
        splitNode2.metaData("x", 1926);
        splitNode2.metaData("width", 56);
        splitNode2.metaData("y", 198);
        splitNode2.metaData("height", 56);
        splitNode2.constraint(1, "_3773B4B4-9372-491C-87A2-4A7C84CC297D", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            return liked == false;
        }, 0);
        splitNode2.constraint(9, "_7621E9D4-7FA2-47E9-98E2-7E015D9C52FD", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            return liked == true;
        }, 0);
        splitNode2.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode3 = factory.endNode(3);
        endNode3.name("End");
        endNode3.terminate(false);
        endNode3.metaData("UniqueId", "_34769D65-562C-4863-955E-D1C6DE0B1FC0");
        endNode3.metaData("x", 3170);
        endNode3.metaData("width", 56);
        endNode3.metaData("y", 198);
        endNode3.metaData("height", 56);
        endNode3.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode4 = factory.actionNode(4);
        actionNode4.name("Lo imprime");
        actionNode4.action(kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            System.out.println("¿Es exitosa?: " + campain.getExitosa());
        });
        actionNode4.metaData("UniqueId", "_290BAB6E-7F24-4034-99CE-4179C24A6E8E");
        actionNode4.metaData("elementname", "Lo imprime");
        actionNode4.metaData("NodeType", "ScriptTask");
        actionNode4.metaData("x", 2936);
        actionNode4.metaData("width", 154);
        actionNode4.metaData("y", 175);
        actionNode4.metaData("height", 102);
        actionNode4.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode5 = factory.endNode(5);
        endNode5.name("End");
        endNode5.terminate(false);
        endNode5.metaData("UniqueId", "_32AA19B6-0F03-407D-8302-ACBFC54C6F89");
        endNode5.metaData("x", 2566);
        endNode5.metaData("width", 56);
        endNode5.metaData("y", 354);
        endNode5.metaData("height", 56);
        endNode5.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode6 = factory.actionNode(6);
        actionNode6.name("Es exitosa");
        actionNode6.action(kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            campain.setExitosa(true);
        });
        actionNode6.metaData("UniqueId", "_93EFFD38-41DF-4A7F-AFE3-50A9D1E31315");
        actionNode6.metaData("elementname", "Es exitosa");
        actionNode6.metaData("NodeType", "ScriptTask");
        actionNode6.metaData("x", 2702);
        actionNode6.metaData("width", 154);
        actionNode6.metaData("y", 175);
        actionNode6.metaData("height", 102);
        actionNode6.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode7 = factory.splitNode(7);
        splitNode7.name("Split");
        splitNode7.type(2);
        splitNode7.metaData("UniqueId", "_DC0AADC4-CD87-4F0D-860F-6D548D4B77FF");
        splitNode7.metaData("x", 2566);
        splitNode7.metaData("width", 56);
        splitNode7.metaData("y", 198);
        splitNode7.metaData("height", 56);
        splitNode7.constraint(5, "_DB7048B5-452F-400F-BB67-D3A2C6788B32", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            return popular == false;
        }, 0);
        splitNode7.constraint(6, "_BBBE7929-6A19-4602-8A73-AB26A80D1176", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            return popular == true;
        }, 0);
        splitNode7.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode8 = factory.actionNode(8);
        actionNode8.name("Lo imprime");
        actionNode8.action(kcontext -> {
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            System.out.println("¿Es popular?: " + popular);
        });
        actionNode8.metaData("UniqueId", "_37B03191-C450-4159-9C0D-4F8008A216A5");
        actionNode8.metaData("elementname", "Lo imprime");
        actionNode8.metaData("NodeType", "ScriptTask");
        actionNode8.metaData("x", 2349);
        actionNode8.metaData("width", 154);
        actionNode8.metaData("y", 175);
        actionNode8.metaData("height", 102);
        actionNode8.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode9 = factory.workItemNode(9);
        workItemNode9.name("¿Es popular?");
        workItemNode9.workName("org.acme.Processor_isPopular_9_Handler");
        workItemNode9.workParameter("Interface", "org.acme.Processor");
        workItemNode9.workParameter("Operation", "isPopular");
        workItemNode9.workParameter("interfaceImplementationRef", "org.acme.Processor");
        workItemNode9.workParameter("operationImplementationRef", "isPopular");
        workItemNode9.workParameter("implementation", "Java");
        workItemNode9.inMapping("campain", "campain");
        workItemNode9.outMapping("popular", "popular");
        workItemNode9.done();
        workItemNode9.metaData("UniqueId", "_0238D43E-8633-41F7-A49C-44FB8E5738CA");
        workItemNode9.metaData("Implementation", "Java");
        workItemNode9.metaData("elementname", "¿Es popular?");
        workItemNode9.metaData("Type", "Service Task");
        workItemNode9.metaData("OperationRef", "_0238D43E-8633-41F7-A49C-44FB8E5738CA_ServiceOperation");
        workItemNode9.metaData("x", 2115);
        workItemNode9.metaData("width", 154);
        workItemNode9.metaData("y", 175);
        workItemNode9.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode10 = factory.endNode(10);
        endNode10.name("End");
        endNode10.terminate(false);
        endNode10.metaData("UniqueId", "_31638212-8566-4A88-AB61-47AA0B84F250");
        endNode10.metaData("x", 1237);
        endNode10.metaData("width", 56);
        endNode10.metaData("y", 354);
        endNode10.metaData("height", 56);
        endNode10.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode11 = factory.splitNode(11);
        splitNode11.name("Split");
        splitNode11.type(2);
        splitNode11.metaData("UniqueId", "_914C5A2C-CDBB-473F-B3FA-39E436FC39ED");
        splitNode11.metaData("x", 1237);
        splitNode11.metaData("width", 56);
        splitNode11.metaData("y", 197);
        splitNode11.metaData("height", 56);
        splitNode11.constraint(13, "_18243FDA-763B-4EF5-9021-93742C0E8F81", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            return ended == true;
        }, 0);
        splitNode11.constraint(10, "_4A81A14D-48CD-4A33-9589-89D01F30653E", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            return ended == false;
        }, 0);
        splitNode11.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode12 = factory.actionNode(12);
        actionNode12.name("Lo imprime");
        actionNode12.action(kcontext -> {
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            System.out.println("¿Más likes que dislikes?: " + liked);
        });
        actionNode12.metaData("UniqueId", "_6E620AA7-A217-4DA6-A21A-704F3326C97C");
        actionNode12.metaData("elementname", "Lo imprime");
        actionNode12.metaData("NodeType", "ScriptTask");
        actionNode12.metaData("x", 1619);
        actionNode12.metaData("width", 154);
        actionNode12.metaData("y", 175);
        actionNode12.metaData("height", 102);
        actionNode12.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode13 = factory.workItemNode(13);
        workItemNode13.name("¿Tiene más likes que dislikes?");
        workItemNode13.workName("org.acme.Processor_isLiked_13_Handler");
        workItemNode13.workParameter("Interface", "org.acme.Processor");
        workItemNode13.workParameter("Operation", "isLiked");
        workItemNode13.workParameter("interfaceImplementationRef", "org.acme.Processor");
        workItemNode13.workParameter("operationImplementationRef", "isLiked");
        workItemNode13.workParameter("implementation", "Java");
        workItemNode13.inMapping("campain", "campain");
        workItemNode13.outMapping("liked", "liked");
        workItemNode13.done();
        workItemNode13.metaData("UniqueId", "_6A2B63E7-69E0-440B-BF1D-E49443FFCF12");
        workItemNode13.metaData("Implementation", "Java");
        workItemNode13.metaData("elementname", "¿Tiene más likes que dislikes?");
        workItemNode13.metaData("Type", "Service Task");
        workItemNode13.metaData("OperationRef", "_6A2B63E7-69E0-440B-BF1D-E49443FFCF12_ServiceOperation");
        workItemNode13.metaData("x", 1385);
        workItemNode13.metaData("width", 154);
        workItemNode13.metaData("y", 175);
        workItemNode13.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode14 = factory.actionNode(14);
        actionNode14.name("Imprime el estado");
        actionNode14.action(kcontext -> {
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            System.out.println("¿Está finalizada?: " + ended);
        });
        actionNode14.metaData("UniqueId", "_726C69CE-6944-4A57-AC5D-D0D4A477B02C");
        actionNode14.metaData("elementname", "Imprime el estado");
        actionNode14.metaData("NodeType", "ScriptTask");
        actionNode14.metaData("x", 1018);
        actionNode14.metaData("width", 154);
        actionNode14.metaData("y", 175);
        actionNode14.metaData("height", 102);
        actionNode14.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode15 = factory.workItemNode(15);
        workItemNode15.name("Estado de la campaña");
        workItemNode15.workName("org.acme.Processor_isEnded_15_Handler");
        workItemNode15.workParameter("Interface", "org.acme.Processor");
        workItemNode15.workParameter("Operation", "isEnded");
        workItemNode15.workParameter("interfaceImplementationRef", "org.acme.Processor");
        workItemNode15.workParameter("operationImplementationRef", "isEnded");
        workItemNode15.workParameter("implementation", "Java");
        workItemNode15.inMapping("campain", "campain");
        workItemNode15.outMapping("ended", "ended");
        workItemNode15.done();
        workItemNode15.metaData("UniqueId", "_C7A7BF5F-64E9-4CF8-8203-AE3A1A90AAF6");
        workItemNode15.metaData("Implementation", "Java");
        workItemNode15.metaData("elementname", "Estado de la campaña");
        workItemNode15.metaData("Type", "Service Task");
        workItemNode15.metaData("OperationRef", "_C7A7BF5F-64E9-4CF8-8203-AE3A1A90AAF6_ServiceOperation");
        workItemNode15.metaData("x", 784);
        workItemNode15.metaData("width", 154);
        workItemNode15.metaData("y", 175);
        workItemNode15.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode16 = factory.actionNode(16);
        actionNode16.name("Imprime el nombre de la campaña");
        actionNode16.action(kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            System.out.println("Nombre de la campaña: " + campain.getNombre());
        });
        actionNode16.metaData("UniqueId", "_92BCD222-8335-47DF-B15D-F938875722BA");
        actionNode16.metaData("elementname", "Imprime el nombre de la campaña");
        actionNode16.metaData("NodeType", "ScriptTask");
        actionNode16.metaData("x", 550);
        actionNode16.metaData("width", 154);
        actionNode16.metaData("y", 175);
        actionNode16.metaData("height", 102);
        actionNode16.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode17 = factory.startNode(17);
        startNode17.name("Start");
        startNode17.interrupting(true);
        startNode17.metaData("UniqueId", "_75AC8C0C-CFBD-4ADF-A3B4-83AB90581A73");
        startNode17.metaData("x", 393);
        startNode17.metaData("width", 56);
        startNode17.metaData("y", 198);
        startNode17.metaData("height", 56);
        startNode17.done();
        factory.connection(2, 1, "_3773B4B4-9372-491C-87A2-4A7C84CC297D");
        factory.connection(12, 2, "_7D9658D6-6B5C-44F0-8C20-0C928F53602F");
        factory.connection(4, 3, "_5CB56649-5FB0-48CF-BDEE-D969FA6ADDC3");
        factory.connection(6, 4, "_8AB24B14-3F85-491B-B5B4-EBD85A92ED6A");
        factory.connection(7, 5, "_DB7048B5-452F-400F-BB67-D3A2C6788B32");
        factory.connection(7, 6, "_BBBE7929-6A19-4602-8A73-AB26A80D1176");
        factory.connection(8, 7, "_6A61E906-D9D3-4BA8-B58D-084B58346FEA");
        factory.connection(9, 8, "_D9AE0B78-AF4D-4242-BB51-FFEE68FFEC4D");
        factory.connection(2, 9, "_7621E9D4-7FA2-47E9-98E2-7E015D9C52FD");
        factory.connection(11, 10, "_4A81A14D-48CD-4A33-9589-89D01F30653E");
        factory.connection(14, 11, "_6AE159D0-0A25-454E-B041-4370DC88FE82");
        factory.connection(13, 12, "_696C9E72-5001-460C-B006-92093B1C7DAB");
        factory.connection(11, 13, "_18243FDA-763B-4EF5-9021-93742C0E8F81");
        factory.connection(15, 14, "_3D8B5462-93A7-4B83-AE70-C3123ABE63D7");
        factory.connection(16, 15, "_5AE3B8F3-A726-4DD1-B019-EAB1361A7775");
        factory.connection(17, 16, "_00AB4A77-D70F-4086-8BA6-57DD017A5323");
        factory.validate();
        return factory.getProcess();
    }
}
