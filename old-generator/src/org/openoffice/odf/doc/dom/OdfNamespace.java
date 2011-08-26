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

package org.openoffice.odf.dom;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.xml.namespace.NamespaceContext;

/**
 * class keeping some constants for OpenDocument namespaces
 */
public class OdfNamespace implements Comparable, NamespaceContext {

    private static Map<String, String> namesspacesByPrefix;
    private static Map<String, String> namesspacesByUri;

    static private enum OOoNamespace {

        DC("dc", "http://purl.org/dc/elements/1.1/"),
        OFFICE("office", "urn:oasis:names:tc:opendocument:xmlns:office:1.0"),
        ANIM("anim", "urn:oasis:names:tc:opendocument:xmlns:animation:1.0"),
        TEXT("text", "urn:oasis:names:tc:opendocument:xmlns:text:1.0"),
        SVG("svg", "urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0"),
        XFORMS("xforms", "http://www.w3.org/2002/xforms"),
        FORM("form", "urn:oasis:names:tc:opendocument:xmlns:form:1.0"),
        SMIL("smil", "urn:oasis:names:tc:opendocument:xmlns:smil-compatible:1.0"),
        A("a", "http://relaxng.org/ns/compatibility/annotations/1.0"),
        NUMBER("number", "urn:oasis:names:tc:opendocument:xmlns:datastyle:1.0"),
        TABLE("table", "urn:oasis:names:tc:opendocument:xmlns:table:1.0"),
        SCRIPT("script", "urn:oasis:names:tc:opendocument:xmlns:script:1.0"),
        META("meta", "urn:oasis:names:tc:opendocument:xmlns:meta:1.0"),
        MATH("math", "http://www.w3.org/1998/Math/MathML"),
        DRAW("draw", "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0"),
        DR3D("dr3d", "urn:oasis:names:tc:opendocument:xmlns:dr3d:1.0"),
        STYLE("style", "urn:oasis:names:tc:opendocument:xmlns:style:1.0"),
        PRESENTATION("presentation", "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0"),
        XLINK("xlink", "http://www.w3.org/1999/xlink"),
        CONFIG("config", "urn:oasis:names:tc:opendocument:xmlns:config:1.0"),
        CHART("chart", "urn:oasis:names:tc:opendocument:xmlns:chart:1.0"),
        FO("fo", "urn:oasis:names:tc:opendocument:xmlns:xsl-fo-compatible:1.0");
        private String mPrefix;
        private String mNamespaceUri;

        OOoNamespace(String prefix, String namespaceUri) {
            mPrefix = prefix;
            mNamespaceUri = namespaceUri;
        }
    }

    static {
        namesspacesByPrefix = new HashMap<String, String>();
        namesspacesByUri = new HashMap<String, String>();
        for (OOoNamespace ns : OOoNamespace.values()) {
            namesspacesByPrefix.put(ns.mPrefix, ns.mNamespaceUri);
            namesspacesByUri.put(ns.mNamespaceUri, ns.mPrefix);
        }
    }
    private String m_uri;
    private String m_prefix;

    public OdfNamespace(){}
    
    private OdfNamespace(String uri) {
        this(null, uri);
    }

    private OdfNamespace(String prefix, String uri) {
        if (uri != null && uri.length() > 0) {
            m_uri = uri;
        }
        if (prefix != null && prefix.length() > 0) {
            m_prefix = prefix;
        }
    }

    public OdfName getOdfName(String name) {
        int i = name.indexOf(':');
        if (i >= 0) {
            return OdfName.get(this, name.substring(i + 1));
        } else {
            return OdfName.get(this, name);
        }
    }
    private static SortedSet m_namespaces = new TreeSet();

    public static OdfNamespace get(String uri) {
        OdfNamespace newns = new OdfNamespace(uri);
        SortedSet tail = m_namespaces.tailSet(newns);
        if (tail.size() > 0) {
            OdfNamespace result = (OdfNamespace) tail.first();
            if (result.equals(uri)) {
                return result;
            }
        }
        // no namespace found, create a new one        
        m_namespaces.add(newns);
        return newns;
    }

    public static OdfNamespace get(String prefix, String uri) {
        OdfNamespace newns = new OdfNamespace(prefix, uri);
        SortedSet tail = m_namespaces.tailSet(newns);
        for (Object obj : tail) {
            OdfNamespace result = (OdfNamespace) obj;
            if (tail.first().equals(uri)) {
                if (result.getPrefix().equals(prefix)) {
                    return result;
                } else {
                    // try to find a matching prefix as long as the uri matches
                    continue;
                }
            } else {
                // uri doesn't match any longer. stop searching
                break;
            }
        }
        // no namespace found, create a new one        
        m_namespaces.add(newns);
        return newns;

    }

    public boolean hasPrefix() {
        return m_prefix != null;
    }

    public String getPrefix() {
        return m_prefix;
    }

    public String getUri() {
        return m_uri;
    }

    @Override
    public boolean equals(Object obj) {
        if (m_uri != null) {
            return m_uri.equals(obj.toString());
        } else {
            return m_uri == obj;
        }
    }

    @Override
    public int hashCode() {
        if (m_uri != null) {
            return m_uri.hashCode();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return m_uri;
    }

    public static String[] splitQName(String qname) {
        String localpart = qname;
        String prefix = null;
        int colon = qname.indexOf(':');
        if (colon > 0) {
            localpart = qname.substring(colon + 1);
            prefix = qname.substring(0, colon);
        }
        return new String[]{prefix, localpart};
    }

    public static String getPrefixPart(String qname) {
        return splitQName(qname)[0];
    }

    public static String getLocalPart(String qname) {
        return splitQName(qname)[1];
    }

    public int compareTo(Object o) {
        return toString().compareTo(o.toString());
    }
    
    // 2DO: use only constants from Enumeration
    // 2DO: move Namespaceconstants into OdfName.. (?)
    public static final OdfNamespace DC = get("dc", "http://purl.org/dc/elements/1.1/");
    public static final OdfNamespace OFFICE = get("office", "urn:oasis:names:tc:opendocument:xmlns:office:1.0");
    public static final OdfNamespace ANIM = get("anim", "urn:oasis:names:tc:opendocument:xmlns:animation:1.0");
    public static final OdfNamespace TEXT = get("text", "urn:oasis:names:tc:opendocument:xmlns:text:1.0");
    public static final OdfNamespace SVG = get("svg", "urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0");
    public static final OdfNamespace XFORMS = get("xforms", "http://www.w3.org/2002/xforms");
    public static final OdfNamespace FORM = get("form", "urn:oasis:names:tc:opendocument:xmlns:form:1.0");
    public static final OdfNamespace SMIL = get("smil", "urn:oasis:names:tc:opendocument:xmlns:smil-compatible:1.0");
    public static final OdfNamespace A = get("a", "http://relaxng.org/ns/compatibility/annotations/1.0");
    public static final OdfNamespace NUMBER = get("number", "urn:oasis:names:tc:opendocument:xmlns:datastyle:1.0");
    public static final OdfNamespace TABLE = get("table", "urn:oasis:names:tc:opendocument:xmlns:table:1.0");
    public static final OdfNamespace SCRIPT = get("script", "urn:oasis:names:tc:opendocument:xmlns:script:1.0");
    public static final OdfNamespace META = get("meta", "urn:oasis:names:tc:opendocument:xmlns:meta:1.0");
    public static final OdfNamespace MATH = get("math", "http://www.w3.org/1998/Math/MathML");
    public static final OdfNamespace DRAW = get("draw", "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0");
    public static final OdfNamespace DR3D = get("dr3d", "urn:oasis:names:tc:opendocument:xmlns:dr3d:1.0");
    public static final OdfNamespace STYLE = get("style", "urn:oasis:names:tc:opendocument:xmlns:style:1.0");
    public static final OdfNamespace PRESENTATION = get("presentation", "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0");
    public static final OdfNamespace XLINK = get("xlink", "http://www.w3.org/1999/xlink");
    public static final OdfNamespace CONFIG = get("config", "urn:oasis:names:tc:opendocument:xmlns:config:1.0");
    public static final OdfNamespace CHART = get("chart", "urn:oasis:names:tc:opendocument:xmlns:chart:1.0");
    public static final OdfNamespace FO = get("fo", "urn:oasis:names:tc:opendocument:xmlns:xsl-fo-compatible:1.0");

    public String getNamespaceURI(String prefix) {
        return namesspacesByPrefix.get(prefix);
    }

    public static String getNamespaceURIByPrefix(String prefix) {
        return namesspacesByPrefix.get(prefix);
    }
    
    public String getPrefix(String namespaceUri) {
        return namesspacesByUri.get(namespaceUri);
    }

    public Iterator getPrefixes(String namespaceuri) {
        return namesspacesByPrefix.keySet().iterator();
    }
}
