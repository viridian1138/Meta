


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


package meta;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectOutput;
import java.util.Vector;



/**
 * @author thorngreen
 *
 * A version of ObjectOutput for supporting Encoders such as XMLEncoder.
 */
public class EncoderObjectOutput implements ObjectOutput {
    
	/**
	 * Constructor.
	 */
    public EncoderObjectOutput() {
    }
    
    /**
     * Vector of objects representing the encoding.
     */
    protected final Vector<Object> objs = new Vector<Object>();
    
    /**
     * Writes an object to the ObjectOutput.
     * @param arg0 The object to be written.
     */
    public void writeObject(Object arg0) throws IOException {
        objs.add(arg0);
        
    }
    
    /**
     * Encodes an Externalizable into an array of objects in the ObjectOutput.
     * @param in The Externalizable to encode.
     * @return The array representing the encoding.
     * @throws IOException
     */
    public Object[] encodeObjects(Externalizable in) throws IOException {
        objs.add(in.getClass().getName());
        in.writeExternal(this);
        return (objs.toArray());
    }
    
    /**
     * Throws an UndefinedOperation exception.
     */
    protected void throwEx() {
        throw ( new Meta.UndefinedOperation() );
    }
    
    /**
     * Not supported.  Do not use.
     */
    public void write(int arg0) throws IOException {
        throwEx();
        
    }
    
    /**
     * Not supported.  Do not use.
     */
    public void write(byte[] arg0) throws IOException {
        throwEx();
    }
    
    /**
     * Not supported.  Do not use.
     */
    public void write(byte[] arg0, int arg1, int arg2) throws IOException {
        throwEx();
    }
    
    /**
     * Flushes the ObjectOutput.
     */
    public void flush() throws IOException {
        // Does Nothing.
    }
    
    /**
     * Closes the ObjectOutput.
     */
    public void close() throws IOException {
        // Does Nothing.
        
    }
    
    /**
     * Writes a boolean to the ObjectOutput.
     * @param arg0 The boolean to be written.
     */
    public void writeBoolean(boolean arg0) throws IOException {
        writeObject(new Boolean(arg0));
    }
    
    /**
     * Writes a byte to the ObjectOutput.
     * @param arg0 The byte to be written.
     */
    public void writeByte(int arg0) throws IOException {
        writeObject(new Byte((byte) arg0));
    }
    
    /**
     * Writes a short to the ObjectOutput.
     * @param arg0 The short to be written.
     */
    public void writeShort(int arg0) throws IOException {
        writeObject(new Short((short) arg0));
    }
    
    /**
     * Writes a character to the ObjectOutput.
     * @param arg0 The character to be written.
     */
    public void writeChar(int arg0) throws IOException {
        writeObject(new Character((char) arg0));
    }
    
    /**
     * Writes an int to the ObjectOutput.
     * @param arg0 The int to be written.
     */
    public void writeInt(int arg0) throws IOException {
        writeObject(new Integer(arg0));
    }
    
    /**
     * Writes a long to the ObjectOutput.
     * @param arg0 The long to be written.
     */
    public void writeLong(long arg0) throws IOException {
        writeObject(new Long(arg0));
    }
    
    /**
     * Writes a float to the ObjectOutput.
     * @param arg0 The float to be written.
     */
    public void writeFloat(float arg0) throws IOException {
        writeObject(new Float(arg0));
    }
    
    /**
     * Writes a double to the ObjectOutput.
     * @param arg0 The double to be written.
     */
    public void writeDouble(double arg0) throws IOException {
        writeObject(new Double(arg0));
    }
    
    /**
     * Not supported.  Do not use.
     */
    public void writeBytes(String arg0) throws IOException {
        throwEx();
    }
    
    /**
     * Not supported.  Do not use.
     */
    public void writeChars(String arg0) throws IOException {
        throwEx();
    }
    
    /**
     * Not supported.  Do not use.
     */
    public void writeUTF(String arg0) throws IOException {
        throwEx();
    }

    
}

