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

@org.kie.kogito.codegen.Generated(value = "kogito-codegen", reference = "text_processor_plus_2", name = "Text_processor_plus_2", hidden = true)
public class Text_processor_plus_2ModelOutput implements org.kie.kogito.Model, MapInput, MapInputId, MapOutput, MappableToModel<Text_processor_plus_2Model> {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
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

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "popular")
    @javax.validation.Valid()
    private java.lang.Boolean popular;

    public java.lang.Boolean getPopular() {
        return popular;
    }

    public void setPopular(java.lang.Boolean popular) {
        this.popular = popular;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "liked")
    @javax.validation.Valid()
    private java.lang.Boolean liked;

    public java.lang.Boolean getLiked() {
        return liked;
    }

    public void setLiked(java.lang.Boolean liked) {
        this.liked = liked;
    }

    @Override()
    public Text_processor_plus_2Model toModel() {
        Text_processor_plus_2Model result = new Text_processor_plus_2Model();
        result.setId(getId());
        result.setCampain(getCampain());
        result.setEnded(getEnded());
        result.setPopular(getPopular());
        result.setLiked(getLiked());
        return result;
    }
}
