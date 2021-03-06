/*
 * Copyright 2014 Azige.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.azige.json;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author Azige
 */
public class JsonBuilderFactoryImpl implements JsonBuilderFactory{

    private final Map<String, ?> config;

    public JsonBuilderFactoryImpl(){
        this.config = null;
    }

    public JsonBuilderFactoryImpl(Map<String, ?> config){
        this.config = Collections.unmodifiableMap(new HashMap<>(config));
    }

    @Override
    public JsonObjectBuilder createObjectBuilder(){
        return new JsonObjectBuilderImpl();
    }

    @Override
    public JsonArrayBuilder createArrayBuilder(){
        return new JsonArrayBuilderImpl();
    }

    @Override
    public Map<String, ?> getConfigInUse(){
        return config;
    }

}
