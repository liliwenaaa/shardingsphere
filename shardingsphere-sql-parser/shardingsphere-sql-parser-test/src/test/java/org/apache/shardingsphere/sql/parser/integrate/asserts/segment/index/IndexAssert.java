/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.sql.parser.integrate.asserts.segment.index;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.shardingsphere.sql.parser.integrate.asserts.SQLCaseAssertContext;
import org.apache.shardingsphere.sql.parser.integrate.jaxb.segment.impl.index.ExpectedIndex;
import org.apache.shardingsphere.sql.parser.sql.segment.ddl.index.IndexSegment;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Index assert.
 *
 * @author zhangliang
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class IndexAssert {
    
    /**
     * Assert actual column segment is correct with expected column.
     *
     * @param assertContext assert context
     * @param actual actual index segment
     * @param expected expected index
     */
    public static void assertIs(final SQLCaseAssertContext assertContext, final IndexSegment actual, final ExpectedIndex expected) {
        assertNotNull(assertContext.getText("Index should exist."), expected);
        assertThat(assertContext.getText("Index name assertion error: "), actual.getName(), is(expected.getName()));
        assertThat(assertContext.getText("Index name start delimiter assertion error: "), actual.getQuoteCharacter().getStartDelimiter(), is(expected.getStartDelimiter()));
        assertThat(assertContext.getText("Index name end delimiter assertion error: "), actual.getQuoteCharacter().getEndDelimiter(), is(expected.getEndDelimiter()));
        // TODO assert start index and stop index
        //        SQLSegmentAssert.assertIs(assertContext, actual, expected);
    }
}