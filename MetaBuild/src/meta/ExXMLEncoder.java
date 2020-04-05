/*
 * Created on Dec 2, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package meta;

import java.beans.PersistenceDelegate;
import java.beans.XMLEncoder;
import java.io.Externalizable;
import java.io.OutputStream;

//$$strtCprt
/*
        Meta data structure library by Thorn Green
        Copyright (C) 2005 Thorn Green
 
        This program is free software; you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation; either version 2 of the License, or
        (at your option) any later version.
 
        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.
 
        You should have received a copy of the GNU General Public License
        along with this program; if not, write to the Free Software
        Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
//$$endCprt


/**
 * @author thorngreen
 *
 * An extension to XMLEncoder that supports a subset of Externalizable objects.
 */
public class ExXMLEncoder extends XMLEncoder {
    
	/**
	 * Persistence delegate for handling Externalizable classes.
	 */
    protected static final ExPersistenceDelegate EX_DEL =
            new ExPersistenceDelegate();
    
    /**
     * Constructor.
     * @param arg0 The stream to which to enclde the XML.
     */
    public ExXMLEncoder(OutputStream arg0) {
        super(arg0);
    }
    
    @Override
    public PersistenceDelegate getPersistenceDelegate( Class<?> in ) {
        PersistenceDelegate ret = ( in != null ) && !( in.isArray() ) &&
                ( Externalizable.class.isAssignableFrom( in ) )
                ? EX_DEL
                : super.getPersistenceDelegate(in);
        return( ret );
    }
    
    
}

