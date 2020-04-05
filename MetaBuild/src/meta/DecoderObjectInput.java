



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
import java.io.ObjectInput;



/**
 * @author thorngreen
 *
 * A version of ObjectInput that is called by ExFac upon a decode request from a
 * Decoder such as XMLDecoder.
 */
public class DecoderObjectInput implements ObjectInput {
    
	/**
	 * The current index into the set of objects to decode.
	 */
    protected int index = 0;
    
    /**
     * The set of objects to decode.
     */
    protected Object[] readObjs = null;
    
    /**
     * Constructor.
     * @param _readObjs The set of objects to decode.
     */
    public DecoderObjectInput(Object[] _readObjs) {
        readObjs = _readObjs;
    }
    
    /**
     * Reads an Object from the ObjectInput.
     * The Object read from the ObjectInput.
     */
    public Object readObject() throws IOException {
        index++;
        return (readObjs[index]);
    }
    
    /**
     * Decodes the ObjectInput's objects into an Externalizable instance.
     * @return The decoded Externalizable instance.
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public Externalizable decodeObjects()
    throws
            ClassNotFoundException,
            IOException,
            IllegalAccessException,
            InstantiationException {
        String cname = (String) (readObjs[0]);
        Object obj = ( Class.forName( cname, true, Meta.getDefaultClassLoader() ) ).newInstance();
        Externalizable ret = (Externalizable) (obj);
        ret.readExternal(this);
        return (ret);
    }
    
    /**
     * Throws an UndefinedOperation exception.
     */
    protected void throwEx() {
        throw (new Meta.UndefinedOperation() );
    }
    
    /**
     * Not supported.  Do not use.
     */
    public int read() throws IOException {
        throwEx();
        return 0;
    }
    
    /**
     * Not supported.  Do not use.
     */
    public int read(byte[] arg0) throws IOException {
        throwEx();
        return 0;
    }
    
    /**
     * Not supported.  Do not use.
     */
    public int read(byte[] arg0, int arg1, int arg2) throws IOException {
        throwEx();
        return 0;
    }
    
    /**
     * Not supported.  Do not use.
     */
    public long skip(long arg0) throws IOException {
        throwEx();
        return 0;
    }
    
    /**
     * Not supported.  Do not use.
     */
    public int available() throws IOException {
        throwEx();
        return 0;
    }
    
    /**
     * Closes the ObjectInput.
     */
    public void close() throws IOException {
        // Does Nothing.
        
    }
    
    /**
     * Not supported.  Do not use.
     */
    public void readFully(byte[] arg0) throws IOException {
        throwEx();
    }
    
    /**
     * Not supported.  Do not use.
     */
    public void readFully(byte[] arg0, int arg1, int arg2) throws IOException {
        throwEx();
    }
    
    /**
     * Not supported.  Do not use.
     */
    public int skipBytes(int arg0) throws IOException {
        throwEx();
        return 0;
    }
    
    /**
     * Reads a boolean from the ObjectInput.
     * The boolean read from the ObjectInput.
     */
    public boolean readBoolean() throws IOException {
        Boolean intv = (Boolean) (readObject());
        return (intv.booleanValue());
    }
    
    /**
     * Reads a byte from the ObjectInput.
     * The byte read from the ObjectInput.
     */
    public byte readByte() throws IOException {
        Byte intv = (Byte) (readObject());
        return (intv.byteValue());
    }
    
    /**
     * Not supported.  Do not use.
     */
    public int readUnsignedByte() throws IOException {
        throwEx();
        return 0;
    }
    
    /**
     * Reads a short from the ObjectInput.
     * The short read from the ObjectInput.
     */
    public short readShort() throws IOException {
        Short intv = (Short) (readObject());
        return (intv.shortValue());
    }
    
    /**
     * Not supported.  Do not use.
     */
    public int readUnsignedShort() throws IOException {
        throwEx();
        return 0;
    }
    
    /**
     * Reads a char from the ObjectInput.
     * The char read from the ObjectInput.
     */
    public char readChar() throws IOException {
        Character intv = (Character) (readObject());
        return (intv.charValue());
    }
    
    /**
     * Reads an int from the ObjectInput.
     * The int read from the ObjectInput.
     */
    public int readInt() throws IOException {
        Integer intv = (Integer) (readObject());
        return (intv.intValue());
    }
    
    /**
     * Reads a long from the ObjectInput.
     * The long read from the ObjectInput.
     */
    public long readLong() throws IOException {
        Long intv = (Long) (readObject());
        return (intv.longValue());
    }
    
    /**
     * Reads a float from the ObjectInput.
     * The float read from the ObjectInput.
     */
    public float readFloat() throws IOException {
        Float intv = (Float) (readObject());
        return (intv.floatValue());
    }
    
    /**
     * Reads a double from the ObjectInput.
     * The double read from the ObjectInput.
     */
    public double readDouble() throws IOException {
        Double intv = (Double) (readObject());
        return (intv.doubleValue());
    }
    
    /**
     * Not supported.  Do not use.
     */
    public String readLine() throws IOException {
        throwEx();
        return null;
    }
    
    /**
     * Not supported.  Do not use.
     */
    public String readUTF() throws IOException {
        throwEx();
        return null;
    }
    
    
}

