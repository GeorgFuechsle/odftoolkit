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
package org.openoffice.odf.dom.type.text;

public enum OdfBibliographyDataFieldType
{
              CUSTOM1( "custom1" ), SERIES( "series" ), EDITION( "edition" ), CUSTOM2( "custom2" ), CUSTOM3( "custom3" ), CUSTOM4( "custom4" ), CUSTOM5( "custom5" ), ISSN( "issn" ), BIBLIOGRAPHY_TYPE( "bibliography-type" ), HOWPUBLISHED( "howpublished" ), BOOKTITLE( "booktitle" ), PUBLISHER( "publisher" ), JOURNAL( "journal" ), AUTHOR( "author" ), TITLE( "title" ), CHAPTER( "chapter" ), ISBN( "isbn" ), REPORT_TYPE( "report-type" ), YEAR( "year" ), NOTE( "note" ), INSTITUTION( "institution" ), ORGANIZATIONS( "organizations" ), PAGES( "pages" ), NUMBER( "number" ), URL( "url" ), EDITOR( "editor" ), SCHOOL( "school" ), ADDRESS( "address" ), VOLUME( "volume" ), MONTH( "month" ), ANNOTE( "annote" ), IDENTIFIER( "identifier" );

    private String m_aValue;

    OdfBibliographyDataFieldType( String _aValue )
    {
        m_aValue = _aValue;
    }

    public String toString()
    {
        return m_aValue;
    }

    public static String toString( OdfBibliographyDataFieldType _aEnum )
    {
        return _aEnum.toString();
    }

    public static OdfBibliographyDataFieldType enumValueOf( String _aString )
    {
        for( OdfBibliographyDataFieldType aIter : values() )
        {
            if( _aString.equals( aIter.toString() ) )
            {
                return aIter;
            }
        }
        return null;
    }

}
