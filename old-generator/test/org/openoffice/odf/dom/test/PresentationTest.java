/*
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
 */

package org.openoffice.odf.dom.test;

import java.util.Iterator;
import org.junit.Assert;
import org.junit.Test;
import org.openoffice.odf.doc.OdfDocument;
import org.openoffice.odf.doc.element.draw.OdfFillImage;
import org.openoffice.odf.doc.element.draw.OdfGradient;
import org.openoffice.odf.doc.element.draw.OdfHatch;
import org.openoffice.odf.doc.element.draw.OdfMarker;
import org.openoffice.odf.doc.element.draw.OdfPage;
import org.openoffice.odf.doc.element.office.OdfMasterStyles;
import org.openoffice.odf.doc.element.office.OdfPresentation;
import org.openoffice.odf.doc.element.office.OdfStyles;
import org.openoffice.odf.doc.element.style.OdfMasterPage;
import org.openoffice.odf.doc.element.style.OdfStyle;
import org.openoffice.odf.dom.element.OdfElement;
import org.openoffice.odf.dom.style.OdfStyleFamily;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author cl93746
 */
public class PresentationTest
{
    OdfDocument odfdoc;
    public PresentationTest()
    {
        try {                
            odfdoc = OdfDocument.loadDocument("test/resources/presentation.odp");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testPresentation()
    {
        try {
            OdfPresentation presentation = OdfElement.findFirstChildNode( OdfPresentation.class, odfdoc.getOfficeBody() );
            Assert.assertNotNull(presentation);
            
            OdfPage page = presentation.getPage("slide-name-1");
            Assert.assertTrue( (page != null) && page.getName().equals("slide-name-1") );
            Assert.assertEquals( page, presentation.getPageAt(0) );
            
            page = presentation.getPage("slide-name-2");
            Assert.assertTrue( (page != null) && page.getName().equals("slide-name-2") );
            Assert.assertEquals( page, presentation.getPageAt(1) );
            
            page = presentation.getPage("slide-name-3");
            Assert.assertTrue( (page != null) && page.getName().equals("slide-name-3") );
            Assert.assertEquals( page, presentation.getPageAt(2) );
            
            testIterator( OdfPage.class, presentation.getPages(), 3 );
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testMasterStyles()
    {
        try {
            OdfMasterStyles officeMasterStyles = odfdoc.getOfficeMasterStyles();
            Assert.assertNotNull(officeMasterStyles);

            // check if iterator has all two master pages
            testIterator( OdfMasterPage.class, officeMasterStyles.getMasterPages(), 2 );

            // test "master-name-1"
            OdfMasterPage master = officeMasterStyles.getMasterPage("master-name-1");
            Assert.assertNotNull(master);
            Assert.assertEquals(master.getName(), "master-name-1");

            // test "master-name-2"
             master = officeMasterStyles.getMasterPage("master-name-2");
            Assert.assertNotNull(master);
            Assert.assertEquals(master.getName(), "master-name-2");

            // test handout master
            Assert.assertNotNull(officeMasterStyles.getHandoutMaster() );

            // test layerset
            Assert.assertNotNull(officeMasterStyles.getLayerSet() );
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testStyles()
    {
        try {
            OdfStyles officeStyles = odfdoc.getDocumentStyles();
            Assert.assertNotNull(officeStyles);

            Assert.assertNotNull(officeStyles.getGradient("Linear_20_blue_2f_white"));
            testIterator( OdfGradient.class, officeStyles.getGradients().iterator(), 1);

            Assert.assertNotNull(officeStyles.getMarker("Arrow"));
            testIterator( OdfMarker.class, officeStyles.getMarker().iterator(), 1 );

            Assert.assertNotNull(officeStyles.getHatch("Black_20_0_20_Degrees"));
            testIterator( OdfHatch.class, officeStyles.getHatches().iterator(), 1 );

            Assert.assertNotNull(officeStyles.getFillImage("Aqua"));
            testIterator( OdfFillImage.class, officeStyles.getFillImages().iterator(), 1 );

            // check for some styles
            Assert.assertNotNull(officeStyles.getDefaultStyle(OdfStyleFamily.Graphic));
            Assert.assertNotNull(officeStyles.getStyle("standard", OdfStyleFamily.Graphic));
            Assert.assertNotNull(officeStyles.getStyle("master-name-1-outline1", OdfStyleFamily.Presentation ) );   

            Iterator< OdfStyle > style_iter = officeStyles.getStylesForFamily(OdfStyleFamily.Presentation).iterator();
            Assert.assertNotNull( style_iter );
            Assert.assertTrue( style_iter.hasNext() );                
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
    
    private <T extends OdfElement> void testIterator( Class< T > clazz, Iterator< T > iter, int elements )
    {
        Assert.assertNotNull( iter );
        while( elements > 0 )
        {
            Assert.assertTrue( iter.hasNext() );
            Assert.assertTrue( clazz.isInstance( iter.next() ) );
            elements--;
        }
        
        Assert.assertFalse(iter.hasNext());
    }
            
}
