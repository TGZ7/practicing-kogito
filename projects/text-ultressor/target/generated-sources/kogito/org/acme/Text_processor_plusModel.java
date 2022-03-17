/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.acme;

import org.kie.kogito.MapInput;
import org.kie.kogito.MapInputId;
import org.kie.kogito.MapOutput;
import java.util.Map;
import java.util.HashMap;
import org.kie.kogito.MappableToModel;
import org.kie.kogito.Model;

@org.kie.kogito.codegen.Generated(value = "kogito-codegen", reference = "text_processor_plus", name = "Text_processor_plus", hidden = false)
public class Text_processor_plusModel implements org.kie.kogito.Model, MapInput, MapInputId, MapOutput, MappableToModel<Text_processor_plusModelOutput> {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "mytext")
    @javax.validation.Valid()
    private java.lang.String mytext;

    public java.lang.String getMytext() {
        return mytext;
    }

    public void setMytext(java.lang.String mytext) {
        this.mytext = mytext;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "campain")
    @javax.validation.Valid()
    private org.acme.Campain campain;

    public org.acme.Campain getCampain() {
        return campain;
    }

    public void setCampain(org.acme.Campain campain) {
        this.campain = campain;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ended")
    @javax.validation.Valid()
    private java.lang.Boolean ended;

    public java.lang.Boolean getEnded() {
        return ended;
    }

    public void setEnded(java.lang.Boolean ended) {
        this.ended = ended;
    }

    @Override()
    public Text_processor_plusModelOutput toModel() {
        Text_processor_plusModelOutput result = new Text_processor_plusModelOutput();
        result.setId(getId());
        result.setMytext(getMytext());
        result.setCampain(getCampain());
        result.setEnded(getEnded());
        return result;
    }
}
