/*
 * Created on Dec 2, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package meta;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.Externalizable;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;

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
 * Factory class called by the XMLDecoder for decoding instances of
 * Externalizable objects.  Also creates loader-aware XMLDecoder
 * instances.
 */
public class ExFac {
    
	/**
	 * Decodes an Externalizable given an array of objects describing the Externalizable.
	 * @param _in Input that is cast to the array of objects.
	 * @return The decoded Externalizable.
	 */
    public static Object create(Object _in) {
        Externalizable ret = null;
        try {
            Object[] in = (Object[]) _in;
            DecoderObjectInput di = new DecoderObjectInput(in);
            ret = di.decodeObjects();
        } catch (Exception ex) {
            throw (new WrapRuntimeException(ex));
        }
        return ret;
    }
    
    /**
     * Creates an externalization-compatible XML decoder for a particular class loader.
     * @param is The input stream to decode.
     * @param loader The class loader.
     * @return The created XML decoder.
     */
    public static XMLDecoder createXMLDecoder(
            InputStream is,
            ClassLoader loader) {
        return (new XMLDecoder(is, loader));
    }
    
    /**
     * Creates an XML decoder for the Meta default class loader.
     * @param is The input stream to decode.
     * @return The created XML decoder.
     */
    public static XMLDecoder createXMLDecoder(InputStream is) {
        return (createXMLDecoder(is, Meta.getDefaultClassLoader()));
    }
    
    /**
     * Creates an externalization-compatible XML encoder for a particular class loader.
     * @param os The output stream into which to encode XML.
     * @param loader The class loader.
     * @return The created XML encoder.
     * 
     * Note: The ExXMLEncoder class must be loaded with the input class loader in 
     * order to see the contents of the input class loader.
     */
    public static XMLEncoder createXMLEncoder(
            OutputStream os,
            ClassLoader cl) {
    	XMLEncoder ret = null;
        try {
            Class<?>[] types = { OutputStream.class };
            Object[] params = { os };
            Class<? extends XMLEncoder> xmls = 
            		(Class<? extends XMLEncoder>)( cl.loadClass(ExXMLEncoder.class.getName()) );
            Constructor<? extends XMLEncoder> cr = xmls.getConstructor(types);
            ret = cr.newInstance(params);
        } catch (Exception ex) {
            throw (new WrapRuntimeException(ex));
        }
        return ( ret );
    }
    
    /**
     * Creates an externalization-compatible XML encoder for the Meta default class loader.
     * @param os The output stream into which to encode XML.
     * @return The created XML encoder.
     */
    public static XMLEncoder createXMLEncoder(OutputStream os) {
        return (createXMLEncoder(os, Meta.getDefaultClassLoader()));
    }
    
    
    
}


