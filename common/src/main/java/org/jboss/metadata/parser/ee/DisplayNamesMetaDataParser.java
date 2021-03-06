/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.metadata.parser.ee;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.jboss.metadata.javaee.spec.DisplayNamesImpl;


/**
 * @author Remy Maucherat
 */
public class DisplayNamesMetaDataParser {

    public static boolean parse(XMLStreamReader reader, DisplayNamesImpl displayNames) throws XMLStreamException {
        // Only look at the current element, no iteration
        final Element element = Element.forName(reader.getLocalName());
        switch (element) {
            case DISPLAY_NAME:
                displayNames.add(DisplayNameMetaDataParser.parse(reader));
                break;
            default: return false;
        }
        return true;
    }

}
