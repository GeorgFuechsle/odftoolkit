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
import org.openoffice.odf.doc.OdfDocument;
import org.openoffice.odf.doc.OdfFileDom;
import org.openoffice.odf.doc.element.text.OdfParagraph;
import org.openoffice.odf.doc.element.table.OdfTable;
import org.openoffice.odf.doc.element.table.OdfTableCell;
import org.openoffice.odf.doc.element.table.OdfTableRow;
import org.openoffice.odf.doc.element.style.OdfTableColumnProperties;
import org.openoffice.odf.doc.element.style.OdfTableProperties;
import org.w3c.dom.NodeList;

public class CreateTableTest {

    public CreateTableTest() {
    }

    @Test
    public void testCreateTable1() {
        try {            
            OdfFileDom doc = OdfDocument.loadDocument("test/resources/empty.odt").getContentDom();
            
            // find the last paragraph
            NodeList lst = doc.getElementsByTagNameNS(
                    OdfParagraph.ELEMENT_NAME.getUri(),
                    OdfParagraph.ELEMENT_NAME.getLocalName());
            Assert.assertTrue(lst.getLength() > 0);
            OdfParagraph p0 = (OdfParagraph) lst.item(lst.getLength() - 1);

            OdfTable table = doc.createOdfElement(OdfTable.class);

            OdfTableRow tr = (OdfTableRow) table.appendChild(
                    doc.createOdfElement(OdfTableRow.class));
            OdfTableCell td1 = (OdfTableCell) tr.appendCell(
                    doc.createOdfElement(OdfTableCell.class));
            OdfParagraph p1 = doc.createOdfElement(OdfParagraph.class);
            p1.appendChild(doc.createTextNode("content 1"));
            td1.appendChild(p1);

            OdfTableCell td2 = (OdfTableCell) tr.appendCell(
                    doc.createOdfElement(OdfTableCell.class));
            OdfParagraph p2 = doc.createOdfElement(OdfParagraph.class);
            p2.appendChild(doc.createTextNode("cell 2"));
            td2.appendChild(p2);

            OdfTableCell td3 = (OdfTableCell) tr.appendCell(
                    doc.createOdfElement(OdfTableCell.class));
            OdfParagraph p3 = doc.createOdfElement(OdfParagraph.class);
            p3.appendChild(doc.createTextNode("table cell content 3"));
            td3.appendChild(p3);

            p0.getParentNode().insertBefore(table, p0);

            table.setProperty(OdfTableProperties.Width, "12cm");
            table.setProperty(OdfTableProperties.Align, "left");

            td1.setProperty(OdfTableColumnProperties.ColumnWidth, "2cm");

            td2.setProperty(OdfTableColumnProperties.ColumnWidth, "4cm");

            td3.setProperty(OdfTableColumnProperties.ColumnWidth, "6cm");

            doc.getOdfDocument().save("build/test/tabletest.odt");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed with " + e.getClass().getName() + ": '" + e.getMessage() + "'");
        }
    }
}
