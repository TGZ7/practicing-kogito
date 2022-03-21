package org.acme;

import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.drools.core.util.KieFunctions;

@javax.enterprise.context.ApplicationScoped()
@javax.inject.Named("campaign_processor")
@io.quarkus.runtime.Startup()
public class Campaign_processorProcess extends org.kie.kogito.process.impl.AbstractProcess<org.acme.Campaign_processorModel> {

    public Campaign_processorProcess(org.kie.kogito.app.Application app) {
        this(app, new org.kie.kogito.handlers.Processor_isPopular_12_Handler(), new org.kie.kogito.handlers.Processor_isLiked_15_Handler(), new org.kie.kogito.handlers.Processor_isEnded_17_Handler());
    }

    @javax.inject.Inject()
    public Campaign_processorProcess(org.kie.kogito.app.Application app, org.kie.kogito.handlers.Processor_isPopular_12_Handler processor_isPopular_12_Handler, org.kie.kogito.handlers.Processor_isLiked_15_Handler processor_isLiked_15_Handler, org.kie.kogito.handlers.Processor_isEnded_17_Handler processor_isEnded_17_Handler) {
        super(app, java.util.Arrays.asList(processor_isPopular_12_Handler, processor_isLiked_15_Handler, processor_isEnded_17_Handler));
        activate();
    }

    public Campaign_processorProcess() {
    }

    @Override()
    public org.acme.Campaign_processorProcessInstance createInstance(org.acme.Campaign_processorModel value) {
        return new org.acme.Campaign_processorProcessInstance(this, value, this.createProcessRuntime());
    }

    public org.acme.Campaign_processorProcessInstance createInstance(java.lang.String businessKey, org.acme.Campaign_processorModel value) {
        return new org.acme.Campaign_processorProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    @Override()
    public org.acme.Campaign_processorModel createModel() {
        return new org.acme.Campaign_processorModel();
    }

    public org.acme.Campaign_processorProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.acme.Campaign_processorModel) value);
    }

    public org.acme.Campaign_processorProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.acme.Campaign_processorModel) value);
    }

    public org.acme.Campaign_processorProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.Campaign_processorProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public org.acme.Campaign_processorProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.Campaign_processorProcessInstance(this, this.createModel(), wpi);
    }

    public org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("campaign_processor");
        factory.variable("campain", new ObjectDataType("org.acme.Campain"), "customTags", null);
        factory.variable("ended", new ObjectDataType("java.lang.Boolean"), "customTags", null);
        factory.variable("liked", new ObjectDataType("java.lang.Boolean"), "customTags", null);
        factory.variable("popular", new ObjectDataType("java.lang.Boolean"), "customTags", null);
        factory.variable("delay", new ObjectDataType("java.lang.Integer"), "customTags", null);
        factory.name("campaign-processor");
        factory.packageName("org.acme");
        factory.dynamic(false);
        factory.version("1.0");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.TimerNodeFactory<?> timerNode1 = factory.timerNode(1);
        timerNode1.name("Delay");
        timerNode1.type(1);
        timerNode1.delay("#{delay}");
        timerNode1.metaData("UniqueId", "_A35406C0-AC89-4E99-94FD-7ECDFC2D311A");
        timerNode1.metaData("EventType", "timer");
        timerNode1.metaData("x", 652);
        timerNode1.metaData("width", 56);
        timerNode1.metaData("y", 198);
        timerNode1.metaData("height", 56);
        timerNode1.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode2 = factory.endNode(2);
        endNode2.name("End");
        endNode2.terminate(false);
        endNode2.metaData("UniqueId", "_968CCCB4-0A8C-4F8E-89BD-EDDB7A22A236");
        endNode2.metaData("x", 1238);
        endNode2.metaData("width", 56);
        endNode2.metaData("y", 369);
        endNode2.metaData("height", 56);
        endNode2.done();
        org.jbpm.ruleflow.core.factory.JoinFactory<?> joinNode3 = factory.joinNode(3);
        joinNode3.name("Join");
        joinNode3.type(2);
        joinNode3.metaData("UniqueId", "_7E9CB3F6-E15F-452F-A452-413DAAE2B9D9");
        joinNode3.metaData("x", 2914);
        joinNode3.metaData("width", 56);
        joinNode3.metaData("y", 198);
        joinNode3.metaData("height", 56);
        joinNode3.done();
        org.jbpm.ruleflow.core.factory.JoinFactory<?> joinNode4 = factory.joinNode(4);
        joinNode4.name("Join");
        joinNode4.type(2);
        joinNode4.metaData("UniqueId", "_7D728DF5-08BF-4D65-95EF-13BC8F1022F0");
        joinNode4.metaData("x", 1925);
        joinNode4.metaData("width", 56);
        joinNode4.metaData("y", 481);
        joinNode4.metaData("height", 56);
        joinNode4.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode5 = factory.actionNode(5);
        actionNode5.name("No es exitosa");
        actionNode5.action(kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            campain.setExitosa(false);
        });
        actionNode5.metaData("UniqueId", "_CA15BAE4-8177-4D95-B152-4DEE92E24BC2");
        actionNode5.metaData("elementname", "No es exitosa");
        actionNode5.metaData("NodeType", "ScriptTask");
        actionNode5.metaData("x", 1877);
        actionNode5.metaData("width", 154);
        actionNode5.metaData("y", 605);
        actionNode5.metaData("height", 102);
        actionNode5.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode6 = factory.splitNode(6);
        splitNode6.name("Split");
        splitNode6.type(2);
        splitNode6.metaData("UniqueId", "_FEE03E74-2092-4869-8164-10BE9BCB4540");
        splitNode6.metaData("x", 1926);
        splitNode6.metaData("width", 56);
        splitNode6.metaData("y", 198);
        splitNode6.metaData("height", 56);
        splitNode6.constraint(4, "_3773B4B4-9372-491C-87A2-4A7C84CC297D", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            java.lang.Integer delay = (java.lang.Integer) kcontext.getVariable("delay");
            return liked == false;
        }, 0);
        splitNode6.constraint(12, "_7621E9D4-7FA2-47E9-98E2-7E015D9C52FD", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            java.lang.Integer delay = (java.lang.Integer) kcontext.getVariable("delay");
            return liked == true;
        }, 0);
        splitNode6.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode7 = factory.endNode(7);
        endNode7.name("End");
        endNode7.terminate(false);
        endNode7.metaData("UniqueId", "_34769D65-562C-4863-955E-D1C6DE0B1FC0");
        endNode7.metaData("x", 3289);
        endNode7.metaData("width", 56);
        endNode7.metaData("y", 198);
        endNode7.metaData("height", 56);
        endNode7.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode8 = factory.actionNode(8);
        actionNode8.name("Imprime si es exitosa o no");
        actionNode8.action(kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            System.out.println("¿Es exitosa?: " + campain.getExitosa());
        });
        actionNode8.metaData("UniqueId", "_290BAB6E-7F24-4034-99CE-4179C24A6E8E");
        actionNode8.metaData("elementname", "Imprime si es exitosa o no");
        actionNode8.metaData("NodeType", "ScriptTask");
        actionNode8.metaData("x", 3055);
        actionNode8.metaData("width", 154);
        actionNode8.metaData("y", 175);
        actionNode8.metaData("height", 102);
        actionNode8.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode9 = factory.actionNode(9);
        actionNode9.name("Es exitosa");
        actionNode9.action(kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            campain.setExitosa(true);
        });
        actionNode9.metaData("UniqueId", "_93EFFD38-41DF-4A7F-AFE3-50A9D1E31315");
        actionNode9.metaData("elementname", "Es exitosa");
        actionNode9.metaData("NodeType", "ScriptTask");
        actionNode9.metaData("x", 2702);
        actionNode9.metaData("width", 154);
        actionNode9.metaData("y", 175);
        actionNode9.metaData("height", 102);
        actionNode9.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode10 = factory.splitNode(10);
        splitNode10.name("Split");
        splitNode10.type(2);
        splitNode10.metaData("UniqueId", "_DC0AADC4-CD87-4F0D-860F-6D548D4B77FF");
        splitNode10.metaData("x", 2566);
        splitNode10.metaData("width", 56);
        splitNode10.metaData("y", 198);
        splitNode10.metaData("height", 56);
        splitNode10.constraint(4, "_D0AFF58C-15E3-493B-906A-79A5E5B944B5", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            java.lang.Integer delay = (java.lang.Integer) kcontext.getVariable("delay");
            return popular == false;
        }, 0);
        splitNode10.constraint(9, "_BBBE7929-6A19-4602-8A73-AB26A80D1176", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            java.lang.Integer delay = (java.lang.Integer) kcontext.getVariable("delay");
            return popular == true;
        }, 0);
        splitNode10.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode11 = factory.actionNode(11);
        actionNode11.name("Lo imprime");
        actionNode11.action(kcontext -> {
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            System.out.println("¿Es popular?: " + popular);
        });
        actionNode11.metaData("UniqueId", "_37B03191-C450-4159-9C0D-4F8008A216A5");
        actionNode11.metaData("elementname", "Lo imprime");
        actionNode11.metaData("NodeType", "ScriptTask");
        actionNode11.metaData("x", 2349);
        actionNode11.metaData("width", 154);
        actionNode11.metaData("y", 175);
        actionNode11.metaData("height", 102);
        actionNode11.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode12 = factory.workItemNode(12);
        workItemNode12.name("¿Es popular?");
        workItemNode12.workName("org.acme.Processor_isPopular_12_Handler");
        workItemNode12.workParameter("Interface", "org.acme.Processor");
        workItemNode12.workParameter("Operation", "isPopular");
        workItemNode12.workParameter("interfaceImplementationRef", "org.acme.Processor");
        workItemNode12.workParameter("operationImplementationRef", "isPopular");
        workItemNode12.workParameter("implementation", "Java");
        workItemNode12.inMapping("campain", "campain");
        workItemNode12.outMapping("popular", "popular");
        workItemNode12.done();
        workItemNode12.metaData("UniqueId", "_0238D43E-8633-41F7-A49C-44FB8E5738CA");
        workItemNode12.metaData("Implementation", "Java");
        workItemNode12.metaData("elementname", "¿Es popular?");
        workItemNode12.metaData("Type", "Service Task");
        workItemNode12.metaData("OperationRef", "_0238D43E-8633-41F7-A49C-44FB8E5738CA_ServiceOperation");
        workItemNode12.metaData("x", 2115);
        workItemNode12.metaData("width", 154);
        workItemNode12.metaData("y", 175);
        workItemNode12.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode13 = factory.splitNode(13);
        splitNode13.name("Split");
        splitNode13.type(2);
        splitNode13.metaData("UniqueId", "_914C5A2C-CDBB-473F-B3FA-39E436FC39ED");
        splitNode13.metaData("x", 1237);
        splitNode13.metaData("width", 56);
        splitNode13.metaData("y", 197);
        splitNode13.metaData("height", 56);
        splitNode13.constraint(15, "_18243FDA-763B-4EF5-9021-93742C0E8F81", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            java.lang.Integer delay = (java.lang.Integer) kcontext.getVariable("delay");
            return ended == true;
        }, 0);
        splitNode13.constraint(2, "_3EDF49BA-379A-4C1E-B834-377F4ACF21B9", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            java.lang.Integer delay = (java.lang.Integer) kcontext.getVariable("delay");
            return ended == false;
        }, 0);
        splitNode13.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode14 = factory.actionNode(14);
        actionNode14.name("Lo imprime");
        actionNode14.action(kcontext -> {
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            System.out.println("¿Más likes que dislikes?: " + liked);
        });
        actionNode14.metaData("UniqueId", "_6E620AA7-A217-4DA6-A21A-704F3326C97C");
        actionNode14.metaData("elementname", "Lo imprime");
        actionNode14.metaData("NodeType", "ScriptTask");
        actionNode14.metaData("x", 1619);
        actionNode14.metaData("width", 154);
        actionNode14.metaData("y", 175);
        actionNode14.metaData("height", 102);
        actionNode14.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode15 = factory.workItemNode(15);
        workItemNode15.name("¿Tiene más likes que dislikes?");
        workItemNode15.workName("org.acme.Processor_isLiked_15_Handler");
        workItemNode15.workParameter("Interface", "org.acme.Processor");
        workItemNode15.workParameter("Operation", "isLiked");
        workItemNode15.workParameter("interfaceImplementationRef", "org.acme.Processor");
        workItemNode15.workParameter("operationImplementationRef", "isLiked");
        workItemNode15.workParameter("implementation", "Java");
        workItemNode15.inMapping("campain", "campain");
        workItemNode15.outMapping("liked", "liked");
        workItemNode15.done();
        workItemNode15.metaData("UniqueId", "_6A2B63E7-69E0-440B-BF1D-E49443FFCF12");
        workItemNode15.metaData("Implementation", "Java");
        workItemNode15.metaData("elementname", "¿Tiene más likes que dislikes?");
        workItemNode15.metaData("Type", "Service Task");
        workItemNode15.metaData("OperationRef", "_6A2B63E7-69E0-440B-BF1D-E49443FFCF12_ServiceOperation");
        workItemNode15.metaData("x", 1385);
        workItemNode15.metaData("width", 154);
        workItemNode15.metaData("y", 175);
        workItemNode15.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode16 = factory.actionNode(16);
        actionNode16.name("Imprime el estado");
        actionNode16.action(kcontext -> {
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            System.out.println("¿Está finalizada?: " + ended);
        });
        actionNode16.metaData("UniqueId", "_726C69CE-6944-4A57-AC5D-D0D4A477B02C");
        actionNode16.metaData("elementname", "Imprime el estado");
        actionNode16.metaData("NodeType", "ScriptTask");
        actionNode16.metaData("x", 1018);
        actionNode16.metaData("width", 154);
        actionNode16.metaData("y", 175);
        actionNode16.metaData("height", 102);
        actionNode16.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode17 = factory.workItemNode(17);
        workItemNode17.name("Estado de la campaña");
        workItemNode17.workName("org.acme.Processor_isEnded_17_Handler");
        workItemNode17.workParameter("Interface", "org.acme.Processor");
        workItemNode17.workParameter("Operation", "isEnded");
        workItemNode17.workParameter("interfaceImplementationRef", "org.acme.Processor");
        workItemNode17.workParameter("operationImplementationRef", "isEnded");
        workItemNode17.workParameter("implementation", "Java");
        workItemNode17.inMapping("campain", "campain");
        workItemNode17.outMapping("ended", "ended");
        workItemNode17.done();
        workItemNode17.metaData("UniqueId", "_C7A7BF5F-64E9-4CF8-8203-AE3A1A90AAF6");
        workItemNode17.metaData("Implementation", "Java");
        workItemNode17.metaData("elementname", "Estado de la campaña");
        workItemNode17.metaData("Type", "Service Task");
        workItemNode17.metaData("OperationRef", "_C7A7BF5F-64E9-4CF8-8203-AE3A1A90AAF6_ServiceOperation");
        workItemNode17.metaData("x", 784);
        workItemNode17.metaData("width", 154);
        workItemNode17.metaData("y", 175);
        workItemNode17.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode18 = factory.actionNode(18);
        actionNode18.name("Imprime el nombre de la campaña");
        actionNode18.action(kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            System.out.println("Nombre de la campaña: " + campain.getNombre());
        });
        actionNode18.metaData("UniqueId", "_92BCD222-8335-47DF-B15D-F938875722BA");
        actionNode18.metaData("elementname", "Imprime el nombre de la campaña");
        actionNode18.metaData("NodeType", "ScriptTask");
        actionNode18.metaData("x", 421);
        actionNode18.metaData("width", 154);
        actionNode18.metaData("y", 175);
        actionNode18.metaData("height", 102);
        actionNode18.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode19 = factory.startNode(19);
        startNode19.name("Start");
        startNode19.interrupting(true);
        startNode19.metaData("UniqueId", "_75AC8C0C-CFBD-4ADF-A3B4-83AB90581A73");
        startNode19.metaData("x", 268);
        startNode19.metaData("width", 56);
        startNode19.metaData("y", 198);
        startNode19.metaData("height", 56);
        startNode19.done();
        factory.connection(18, 1, "_5AE3B8F3-A726-4DD1-B019-EAB1361A7775");
        factory.connection(13, 2, "_3EDF49BA-379A-4C1E-B834-377F4ACF21B9");
        factory.connection(5, 3, "_38FD4A4B-CCEC-4F23-92BE-83DE49718F80");
        factory.connection(9, 3, "_26394C9B-27CB-40CF-9A5E-1E2DD8629825");
        factory.connection(6, 4, "_3773B4B4-9372-491C-87A2-4A7C84CC297D");
        factory.connection(10, 4, "_D0AFF58C-15E3-493B-906A-79A5E5B944B5");
        factory.connection(4, 5, "_7A269F31-3B31-44FA-A884-53D09BEC8AF1");
        factory.connection(14, 6, "_7D9658D6-6B5C-44F0-8C20-0C928F53602F");
        factory.connection(8, 7, "_5CB56649-5FB0-48CF-BDEE-D969FA6ADDC3");
        factory.connection(3, 8, "_1E4CBF0D-E8DC-4FE4-9F8C-714FF0059A12");
        factory.connection(10, 9, "_BBBE7929-6A19-4602-8A73-AB26A80D1176");
        factory.connection(11, 10, "_6A61E906-D9D3-4BA8-B58D-084B58346FEA");
        factory.connection(12, 11, "_D9AE0B78-AF4D-4242-BB51-FFEE68FFEC4D");
        factory.connection(6, 12, "_7621E9D4-7FA2-47E9-98E2-7E015D9C52FD");
        factory.connection(16, 13, "_6AE159D0-0A25-454E-B041-4370DC88FE82");
        factory.connection(15, 14, "_696C9E72-5001-460C-B006-92093B1C7DAB");
        factory.connection(13, 15, "_18243FDA-763B-4EF5-9021-93742C0E8F81");
        factory.connection(17, 16, "_3D8B5462-93A7-4B83-AE70-C3123ABE63D7");
        factory.connection(1, 17, "_6F2F76F1-38E5-451E-A031-98C7AE83F4C9");
        factory.connection(19, 18, "_00AB4A77-D70F-4086-8BA6-57DD017A5323");
        factory.validate();
        return factory.getProcess();
    }
}
