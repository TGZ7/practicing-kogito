package org.acme;

import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.drools.core.util.KieFunctions;

@javax.enterprise.context.ApplicationScoped()
@javax.inject.Named("campaign_processor")
@io.quarkus.runtime.Startup()
public class Campaign_processorProcess extends org.kie.kogito.process.impl.AbstractProcess<org.acme.Campaign_processorModel> {

    public Campaign_processorProcess(org.kie.kogito.app.Application app) {
        this(app, new org.kie.kogito.handlers.Processor_isLiked_14_Handler(), new org.kie.kogito.handlers.Processor_isPopular_11_Handler(), new org.kie.kogito.handlers.Processor_isEnded_16_Handler());
    }

    @javax.inject.Inject()
    public Campaign_processorProcess(org.kie.kogito.app.Application app, org.kie.kogito.handlers.Processor_isLiked_14_Handler processor_isLiked_14_Handler, org.kie.kogito.handlers.Processor_isPopular_11_Handler processor_isPopular_11_Handler, org.kie.kogito.handlers.Processor_isEnded_16_Handler processor_isEnded_16_Handler) {
        super(app, java.util.Arrays.asList(processor_isLiked_14_Handler, processor_isPopular_11_Handler, processor_isEnded_16_Handler));
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
        factory.name("campaign_processor");
        factory.packageName("org.acme");
        factory.dynamic(false);
        factory.version("1.0");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode1 = factory.endNode(1);
        endNode1.name("End");
        endNode1.terminate(false);
        endNode1.metaData("UniqueId", "_968CCCB4-0A8C-4F8E-89BD-EDDB7A22A236");
        endNode1.metaData("x", 1238);
        endNode1.metaData("width", 56);
        endNode1.metaData("y", 369);
        endNode1.metaData("height", 56);
        endNode1.done();
        org.jbpm.ruleflow.core.factory.JoinFactory<?> joinNode2 = factory.joinNode(2);
        joinNode2.name("Join");
        joinNode2.type(2);
        joinNode2.metaData("UniqueId", "_7E9CB3F6-E15F-452F-A452-413DAAE2B9D9");
        joinNode2.metaData("x", 2914);
        joinNode2.metaData("width", 56);
        joinNode2.metaData("y", 198);
        joinNode2.metaData("height", 56);
        joinNode2.done();
        org.jbpm.ruleflow.core.factory.JoinFactory<?> joinNode3 = factory.joinNode(3);
        joinNode3.name("Join");
        joinNode3.type(2);
        joinNode3.metaData("UniqueId", "_7D728DF5-08BF-4D65-95EF-13BC8F1022F0");
        joinNode3.metaData("x", 1925);
        joinNode3.metaData("width", 56);
        joinNode3.metaData("y", 481);
        joinNode3.metaData("height", 56);
        joinNode3.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode4 = factory.actionNode(4);
        actionNode4.name("No es exitosa");
        actionNode4.action(kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            campain.setExitosa(false);
        });
        actionNode4.metaData("UniqueId", "_CA15BAE4-8177-4D95-B152-4DEE92E24BC2");
        actionNode4.metaData("elementname", "No es exitosa");
        actionNode4.metaData("NodeType", "ScriptTask");
        actionNode4.metaData("x", 1877);
        actionNode4.metaData("width", 154);
        actionNode4.metaData("y", 605);
        actionNode4.metaData("height", 102);
        actionNode4.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode5 = factory.splitNode(5);
        splitNode5.name("Split");
        splitNode5.type(2);
        splitNode5.metaData("UniqueId", "_FEE03E74-2092-4869-8164-10BE9BCB4540");
        splitNode5.metaData("x", 1926);
        splitNode5.metaData("width", 56);
        splitNode5.metaData("y", 198);
        splitNode5.metaData("height", 56);
        splitNode5.constraint(11, "_7621E9D4-7FA2-47E9-98E2-7E015D9C52FD", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            return liked == true;
        }, 0);
        splitNode5.constraint(3, "_3773B4B4-9372-491C-87A2-4A7C84CC297D", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            return liked == false;
        }, 0);
        splitNode5.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode6 = factory.endNode(6);
        endNode6.name("End");
        endNode6.terminate(false);
        endNode6.metaData("UniqueId", "_34769D65-562C-4863-955E-D1C6DE0B1FC0");
        endNode6.metaData("x", 3289);
        endNode6.metaData("width", 56);
        endNode6.metaData("y", 198);
        endNode6.metaData("height", 56);
        endNode6.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode7 = factory.actionNode(7);
        actionNode7.name("Imprime si es exitosa o no");
        actionNode7.action(kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            System.out.println("¿Es exitosa?: " + campain.getExitosa());
        });
        actionNode7.metaData("UniqueId", "_290BAB6E-7F24-4034-99CE-4179C24A6E8E");
        actionNode7.metaData("elementname", "Imprime si es exitosa o no");
        actionNode7.metaData("NodeType", "ScriptTask");
        actionNode7.metaData("x", 3055);
        actionNode7.metaData("width", 154);
        actionNode7.metaData("y", 175);
        actionNode7.metaData("height", 102);
        actionNode7.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode8 = factory.actionNode(8);
        actionNode8.name("Es exitosa");
        actionNode8.action(kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            campain.setExitosa(true);
        });
        actionNode8.metaData("UniqueId", "_93EFFD38-41DF-4A7F-AFE3-50A9D1E31315");
        actionNode8.metaData("elementname", "Es exitosa");
        actionNode8.metaData("NodeType", "ScriptTask");
        actionNode8.metaData("x", 2702);
        actionNode8.metaData("width", 154);
        actionNode8.metaData("y", 175);
        actionNode8.metaData("height", 102);
        actionNode8.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode9 = factory.splitNode(9);
        splitNode9.name("Split");
        splitNode9.type(2);
        splitNode9.metaData("UniqueId", "_DC0AADC4-CD87-4F0D-860F-6D548D4B77FF");
        splitNode9.metaData("x", 2566);
        splitNode9.metaData("width", 56);
        splitNode9.metaData("y", 198);
        splitNode9.metaData("height", 56);
        splitNode9.constraint(3, "_D0AFF58C-15E3-493B-906A-79A5E5B944B5", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            return popular == false;
        }, 0);
        splitNode9.constraint(8, "_BBBE7929-6A19-4602-8A73-AB26A80D1176", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            return popular == true;
        }, 0);
        splitNode9.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode10 = factory.actionNode(10);
        actionNode10.name("Lo imprime");
        actionNode10.action(kcontext -> {
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            System.out.println("¿Es popular?: " + popular);
        });
        actionNode10.metaData("UniqueId", "_37B03191-C450-4159-9C0D-4F8008A216A5");
        actionNode10.metaData("elementname", "Lo imprime");
        actionNode10.metaData("NodeType", "ScriptTask");
        actionNode10.metaData("x", 2349);
        actionNode10.metaData("width", 154);
        actionNode10.metaData("y", 175);
        actionNode10.metaData("height", 102);
        actionNode10.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode11 = factory.workItemNode(11);
        workItemNode11.name("¿Es popular?");
        workItemNode11.workName("org.acme.Processor_isPopular_11_Handler");
        workItemNode11.workParameter("Interface", "org.acme.Processor");
        workItemNode11.workParameter("Operation", "isPopular");
        workItemNode11.workParameter("interfaceImplementationRef", "org.acme.Processor");
        workItemNode11.workParameter("operationImplementationRef", "isPopular");
        workItemNode11.workParameter("implementation", "Java");
        workItemNode11.inMapping("campain", "campain");
        workItemNode11.outMapping("popular", "popular");
        workItemNode11.done();
        workItemNode11.metaData("UniqueId", "_0238D43E-8633-41F7-A49C-44FB8E5738CA");
        workItemNode11.metaData("Implementation", "Java");
        workItemNode11.metaData("elementname", "¿Es popular?");
        workItemNode11.metaData("Type", "Service Task");
        workItemNode11.metaData("OperationRef", "_0238D43E-8633-41F7-A49C-44FB8E5738CA_ServiceOperation");
        workItemNode11.metaData("x", 2115);
        workItemNode11.metaData("width", 154);
        workItemNode11.metaData("y", 175);
        workItemNode11.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode12 = factory.splitNode(12);
        splitNode12.name("Split");
        splitNode12.type(2);
        splitNode12.metaData("UniqueId", "_914C5A2C-CDBB-473F-B3FA-39E436FC39ED");
        splitNode12.metaData("x", 1237);
        splitNode12.metaData("width", 56);
        splitNode12.metaData("y", 197);
        splitNode12.metaData("height", 56);
        splitNode12.constraint(14, "_18243FDA-763B-4EF5-9021-93742C0E8F81", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            return ended == true;
        }, 0);
        splitNode12.constraint(1, "_3EDF49BA-379A-4C1E-B834-377F4ACF21B9", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            java.lang.Boolean popular = (java.lang.Boolean) kcontext.getVariable("popular");
            return ended == false;
        }, 0);
        splitNode12.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode13 = factory.actionNode(13);
        actionNode13.name("Lo imprime");
        actionNode13.action(kcontext -> {
            java.lang.Boolean liked = (java.lang.Boolean) kcontext.getVariable("liked");
            System.out.println("¿Más likes que dislikes?: " + liked);
        });
        actionNode13.metaData("UniqueId", "_6E620AA7-A217-4DA6-A21A-704F3326C97C");
        actionNode13.metaData("elementname", "Lo imprime");
        actionNode13.metaData("NodeType", "ScriptTask");
        actionNode13.metaData("x", 1619);
        actionNode13.metaData("width", 154);
        actionNode13.metaData("y", 175);
        actionNode13.metaData("height", 102);
        actionNode13.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode14 = factory.workItemNode(14);
        workItemNode14.name("¿Tiene más likes que dislikes?");
        workItemNode14.workName("org.acme.Processor_isLiked_14_Handler");
        workItemNode14.workParameter("Interface", "org.acme.Processor");
        workItemNode14.workParameter("Operation", "isLiked");
        workItemNode14.workParameter("interfaceImplementationRef", "org.acme.Processor");
        workItemNode14.workParameter("operationImplementationRef", "isLiked");
        workItemNode14.workParameter("implementation", "Java");
        workItemNode14.inMapping("campain", "campain");
        workItemNode14.outMapping("liked", "liked");
        workItemNode14.done();
        workItemNode14.metaData("UniqueId", "_6A2B63E7-69E0-440B-BF1D-E49443FFCF12");
        workItemNode14.metaData("Implementation", "Java");
        workItemNode14.metaData("elementname", "¿Tiene más likes que dislikes?");
        workItemNode14.metaData("Type", "Service Task");
        workItemNode14.metaData("OperationRef", "_6A2B63E7-69E0-440B-BF1D-E49443FFCF12_ServiceOperation");
        workItemNode14.metaData("x", 1385);
        workItemNode14.metaData("width", 154);
        workItemNode14.metaData("y", 175);
        workItemNode14.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode15 = factory.actionNode(15);
        actionNode15.name("Imprime el estado");
        actionNode15.action(kcontext -> {
            java.lang.Boolean ended = (java.lang.Boolean) kcontext.getVariable("ended");
            System.out.println("¿Está finalizada?: " + ended);
        });
        actionNode15.metaData("UniqueId", "_726C69CE-6944-4A57-AC5D-D0D4A477B02C");
        actionNode15.metaData("elementname", "Imprime el estado");
        actionNode15.metaData("NodeType", "ScriptTask");
        actionNode15.metaData("x", 1018);
        actionNode15.metaData("width", 154);
        actionNode15.metaData("y", 175);
        actionNode15.metaData("height", 102);
        actionNode15.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode16 = factory.workItemNode(16);
        workItemNode16.name("Estado de la campaña");
        workItemNode16.workName("org.acme.Processor_isEnded_16_Handler");
        workItemNode16.workParameter("Interface", "org.acme.Processor");
        workItemNode16.workParameter("Operation", "isEnded");
        workItemNode16.workParameter("interfaceImplementationRef", "org.acme.Processor");
        workItemNode16.workParameter("operationImplementationRef", "isEnded");
        workItemNode16.workParameter("implementation", "Java");
        workItemNode16.inMapping("campain", "campain");
        workItemNode16.outMapping("ended", "ended");
        workItemNode16.done();
        workItemNode16.metaData("UniqueId", "_C7A7BF5F-64E9-4CF8-8203-AE3A1A90AAF6");
        workItemNode16.metaData("Implementation", "Java");
        workItemNode16.metaData("elementname", "Estado de la campaña");
        workItemNode16.metaData("Type", "Service Task");
        workItemNode16.metaData("OperationRef", "_C7A7BF5F-64E9-4CF8-8203-AE3A1A90AAF6_ServiceOperation");
        workItemNode16.metaData("x", 784);
        workItemNode16.metaData("width", 154);
        workItemNode16.metaData("y", 175);
        workItemNode16.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode17 = factory.actionNode(17);
        actionNode17.name("Imprime el nombre de la campaña");
        actionNode17.action(kcontext -> {
            org.acme.Campain campain = (org.acme.Campain) kcontext.getVariable("campain");
            System.out.println("Nombre de la campaña: " + campain.getNombre());
        });
        actionNode17.metaData("UniqueId", "_92BCD222-8335-47DF-B15D-F938875722BA");
        actionNode17.metaData("elementname", "Imprime el nombre de la campaña");
        actionNode17.metaData("NodeType", "ScriptTask");
        actionNode17.metaData("x", 550);
        actionNode17.metaData("width", 154);
        actionNode17.metaData("y", 175);
        actionNode17.metaData("height", 102);
        actionNode17.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode18 = factory.startNode(18);
        startNode18.name("Start");
        startNode18.interrupting(true);
        startNode18.metaData("UniqueId", "_75AC8C0C-CFBD-4ADF-A3B4-83AB90581A73");
        startNode18.metaData("x", 393);
        startNode18.metaData("width", 56);
        startNode18.metaData("y", 198);
        startNode18.metaData("height", 56);
        startNode18.done();
        factory.connection(12, 1, "_3EDF49BA-379A-4C1E-B834-377F4ACF21B9");
        factory.connection(4, 2, "_38FD4A4B-CCEC-4F23-92BE-83DE49718F80");
        factory.connection(8, 2, "_26394C9B-27CB-40CF-9A5E-1E2DD8629825");
        factory.connection(5, 3, "_3773B4B4-9372-491C-87A2-4A7C84CC297D");
        factory.connection(9, 3, "_D0AFF58C-15E3-493B-906A-79A5E5B944B5");
        factory.connection(3, 4, "_7A269F31-3B31-44FA-A884-53D09BEC8AF1");
        factory.connection(13, 5, "_7D9658D6-6B5C-44F0-8C20-0C928F53602F");
        factory.connection(7, 6, "_5CB56649-5FB0-48CF-BDEE-D969FA6ADDC3");
        factory.connection(2, 7, "_1E4CBF0D-E8DC-4FE4-9F8C-714FF0059A12");
        factory.connection(9, 8, "_BBBE7929-6A19-4602-8A73-AB26A80D1176");
        factory.connection(10, 9, "_6A61E906-D9D3-4BA8-B58D-084B58346FEA");
        factory.connection(11, 10, "_D9AE0B78-AF4D-4242-BB51-FFEE68FFEC4D");
        factory.connection(5, 11, "_7621E9D4-7FA2-47E9-98E2-7E015D9C52FD");
        factory.connection(15, 12, "_6AE159D0-0A25-454E-B041-4370DC88FE82");
        factory.connection(14, 13, "_696C9E72-5001-460C-B006-92093B1C7DAB");
        factory.connection(12, 14, "_18243FDA-763B-4EF5-9021-93742C0E8F81");
        factory.connection(16, 15, "_3D8B5462-93A7-4B83-AE70-C3123ABE63D7");
        factory.connection(17, 16, "_5AE3B8F3-A726-4DD1-B019-EAB1361A7775");
        factory.connection(18, 17, "_00AB4A77-D70F-4086-8BA6-57DD017A5323");
        factory.validate();
        return factory.getProcess();
    }
}
