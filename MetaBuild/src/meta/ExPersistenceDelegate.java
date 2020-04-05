/*
 * Created on Dec 2, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package meta;

import java.beans.Encoder;
import java.beans.Expression;
import java.beans.PersistenceDelegate;
import java.io.Externalizable;

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
 * Persistence delegate for encoding a subset of Externalizable objects.
 */
public class ExPersistenceDelegate extends PersistenceDelegate {
    
    /**
     * Constructor.
     */
    public ExPersistenceDelegate() {
        super();
    }
    
    @Override
    protected Expression instantiate(Object arg0, Encoder arg1) {
        Expression ret = null;
        try {
            Externalizable e = (Externalizable) arg0;
            EncoderObjectOutput eo = new EncoderObjectOutput();
            Object[] params = { eo.encodeObjects( e ) };
            ret = new Expression(e, ExFac.class, "create", params);
        } catch (Exception ex) {
            throw (new WrapRuntimeException(ex));
        }
        return (ret);
    }
    
    
}

