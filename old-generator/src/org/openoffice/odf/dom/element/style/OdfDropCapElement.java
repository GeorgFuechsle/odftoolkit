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

/*
 * This file is automatically generated.
 * Don't edit manually.
 */    

package org.openoffice.odf.dom.element.style;

import org.openoffice.odf.dom.OdfName;
import org.openoffice.odf.dom.OdfNamespace;
import org.openoffice.odf.doc.OdfFileDom;
import org.openoffice.odf.dom.style.OdfStyleFamily;
import org.openoffice.odf.dom.element.OdfStylableElement;
import org.openoffice.odf.dom.type.OdfPositiveInteger;
import org.openoffice.odf.dom.type.OdfStyleName;


/**
 * ODF DOM Element implementation for element "<style:drop-cap>".
 */
public abstract class OdfDropCapElement extends OdfStylableElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.STYLE, "drop-cap" );

    public OdfDropCapElement( OdfFileDom _aOwnerDoc )
    {
        super( _aOwnerDoc, ELEMENT_NAME, OdfStyleFamily.Text, OdfName.get( OdfNamespace.TEXT, "style-name" ) );
    }

    public OdfName getOdfName()
    {
        return ELEMENT_NAME;
    }


    /**
     * Get value of attribute "style:length".
     */
    public Integer getStyleLength()
    {                    
        String aStringVal = getOdfAttribute( OdfName.get( OdfNamespace.STYLE, "length" ) );
        if( aStringVal.length()==0 )
        {
            aStringVal = "1";
        }

        return OdfPositiveInteger.valueOf( aStringVal);
    }

    /**
     * Set value of attribute "style:length".
     */
    public void setStyleLength( Integer _aStyleLength )
    {                    
        String aStringVal = OdfPositiveInteger.toString( _aStyleLength );
        setOdfAttribute( OdfName.get( OdfNamespace.STYLE, "length" ), aStringVal );
    }

    /**
     * Get value of attribute "style:lines".
     */
    public Integer getLines()
    {                    
        String aStringVal = getOdfAttribute( OdfName.get( OdfNamespace.STYLE, "lines" ) );
        if( aStringVal.length()==0 )
        {
            aStringVal = "1";
        }

        return OdfPositiveInteger.valueOf( aStringVal);
    }

    /**
     * Set value of attribute "style:lines".
     */
    public void setLines( Integer _aLines )
    {                    
        String aStringVal = OdfPositiveInteger.toString( _aLines );
        setOdfAttribute( OdfName.get( OdfNamespace.STYLE, "lines" ), aStringVal );
    }

    /**
     * Get value of attribute "style:distance".
     */
    public String getDistance()
    {                    
        String aStringVal = getOdfAttribute( OdfName.get( OdfNamespace.STYLE, "distance" ) );
        if( aStringVal.length()==0 )
        {
            aStringVal = "0cm";
        }

        return String.valueOf( aStringVal);
    }

    /**
     * Set value of attribute "style:distance".
     */
    public void setDistance( String _aDistance )
    {
        setOdfAttribute( OdfName.get( OdfNamespace.STYLE, "distance" ), _aDistance );
    }

    /**
     * Get value of attribute "style:style-name".
     */
    public String getStyleName()
    {                    
        String aStringVal = getOdfAttribute( OdfName.get( OdfNamespace.STYLE, "style-name" ) );
        return OdfStyleName.valueOf( aStringVal);
    }

    /**
     * Set value of attribute "style:style-name".
     */
    public void setStyleName( String _aStyleName )
    {                    
        String aStringVal = OdfStyleName.toString( _aStyleName );
        setOdfAttribute( OdfName.get( OdfNamespace.STYLE, "style-name" ), aStringVal );
    }

}