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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.StringWriter;

/**
 *
 * @author Azige
 */
public class JsonGeneratorImplTest{

    public JsonGeneratorImplTest(){
    }

    @BeforeClass
    public static void setUpClass(){
    }

    @AfterClass
    public static void tearDownClass(){
    }

    @Before
    public void setUp(){
    }

    @After
    public void tearDown(){
    }

    @Test
    public void testSomeMethod(){
        StringWriter sw = new StringWriter();
        new JsonGeneratorImpl(sw)
            .writeStartArray()
            .write(1)
            .write(2)
            .writeStartObject()
            .write("name", "bob")
            .write("age", 22)
            .writeEnd()
            .writeEnd()
            .close();
        assertEquals("[1,2,{\"name\":\"bob\",\"age\":22}]", sw.toString());
    }

    @Test
    public void testFormat(){
        StringWriter sw = new StringWriter();
        JsonGeneratorImpl generator = new JsonGeneratorImpl(sw, true);
        generator
            .writeStartObject()
            .write("firstName", "John")
            .write("lastName", "Smith")
            .write("age", 25)
            .writeStartObject("address")
            .write("streetAddress", "21 2nd Street")
            .write("city", "New York")
            .write("state", "NY")
            .write("postalCode", "10021")
            .writeEnd()
            .writeStartArray("phoneNumber")
            .writeStartObject()
            .write("type", "home")
            .write("number", "212 555-1234")
            .writeEnd()
            .writeStartObject()
            .write("type", "fax")
            .write("number", "646 555-4567")
            .writeEnd()
            .writeEnd()
            .writeEnd()
            .close();

        System.out.println(sw.toString());
    }

}
