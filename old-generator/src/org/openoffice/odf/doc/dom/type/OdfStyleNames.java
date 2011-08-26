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
package org.openoffice.odf.dom.type;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
        
public class OdfStyleNames {
    
    public static String toString( List<String> _aStyleNames )
    {
        StringBuffer aRet = new StringBuffer();
        Iterator<String> aIter = _aStyleNames.iterator();
        while( aIter.hasNext() )
        {
            if( aRet.length() > 0 )
                aRet.append( ' ' );
            String aStyleName = OdfStyleName.toString(aIter.next());
            aRet.append( aStyleName );
        }
        return aRet.toString();
    }

    public static List<String> valueOf( String _aStringValue )
    {
        if( _aStringValue.length()==0 )
            return null;
        
        List<String> aRet = Arrays.asList( _aStringValue.split( " " ) );
        
        return aRet;
    }
}
