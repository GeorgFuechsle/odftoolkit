/************************************************************************
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 * 
 * Copyright 2008 Sun Microsystems, Inc. All rights reserved.
 * 
 * Use is subject to license terms.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at http://www.apache.org/licenses/LICENSE-2.0. You can also
 * obtain a copy of the License at http://odftoolkit.org/docs/license.txt
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ************************************************************************/
package org.openoffice.odf.dom.test;

import org.junit.Assert;
import org.junit.Test;
import org.openoffice.odf.dom.OdfNamespace;
import org.openoffice.odf.doc.OdfDocument;
import org.openoffice.odf.doc.element.style.*;
import org.openoffice.odf.dom.style.OdfStyleFamily;
import org.openoffice.odf.dom.style.props.OdfStylePropertiesSet;

/**
 * Tests if default styles are parsed correctly into
 * the defaultstyleCollection of the OdfDocument
 */
public class DefaultStylesTest {

    private static String TEST_FILE = "test/resources/test2.odt";

    public DefaultStylesTest() {
    }

    @Test
    public void testDefaultStyles() {
        try {
            OdfDocument doc = OdfDocument.loadDocument(TEST_FILE);

            Object o = doc.getDocumentStyles();
            OdfDefaultStyle oDSG = doc.getDocumentStyles().getDefaultStyle(OdfStyleFamily.Graphic);
            Assert.assertEquals(oDSG.getFamilyName(), OdfStyleFamily.Graphic.getName());
            String prop1 = oDSG.getProperty(OdfGraphicProperties.ShadowOffsetX);
            Assert.assertEquals(prop1, "0.1181in");

            OdfDefaultStyle oDSP = doc.getDocumentStyles().getDefaultStyle(OdfStyleFamily.Paragraph);
            Assert.assertEquals(oDSP.getFamilyName(), OdfStyleFamily.Paragraph.getName());
            String prop2 = oDSP.getProperty(OdfTextProperties.FontName);
            Assert.assertEquals(prop2, "Thorndale");
            String prop3 = oDSP.getProperty(OdfTextProperties.LetterKerning);
            Assert.assertEquals(prop3, "true");

            OdfDefaultStyle oDST = doc.getDocumentStyles().getDefaultStyle(OdfStyleFamily.Table);
            Assert.assertEquals(oDST.getFamilyName(), OdfStyleFamily.Table.getName());
            String prop4 = oDST.getProperty(OdfTableProperties.BorderModel);
            Assert.assertEquals(prop4, "collapsing");


            OdfDefaultStyle oDSTR = doc.getDocumentStyles().getDefaultStyle(OdfStyleFamily.TableRow);
            Assert.assertEquals(oDSTR.getFamilyName(), OdfStyleFamily.TableRow.getName());
            String prop5 = oDSTR.getProperty(OdfTableRowProperties.KeepTogether);
            Assert.assertEquals(prop5, "auto");


        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }
}
