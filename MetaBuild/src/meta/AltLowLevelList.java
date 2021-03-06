


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

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Externalizable;



/**
 *
 * --- SOURCE MODIFICATION LIST ---
 *
 * Please document all changes to this source file here.
 * Feel free to add rows if needed.
 *
 *
 *    |-----------------------|-------------------------------------------------|----------------------------------------------------------------------|---------------------------------------------------------------...
 *    | Date of Modification  |    Author of Modification                       |    Reason for Modification                                           |    Description of Modification (use multiple rows if needed)  ...
 *    |-----------------------|-------------------------------------------------|----------------------------------------------------------------------|---------------------------------------------------------------...
 *    |                       |                                                 |                                                                      |
 *    | 9/24/2000             | Thorn Green (viridian_1138@yahoo.com)           | Needed to provide a standard way to document source file changes.    | Added a souce modification list to the documentation so that changes to the souce could be recorded.
 *    | 10/22/2000            | Thorn Green (viridian_1138@yahoo.com)           | Methods did not have names that followed standard Java conventions.  | Performed a global modification to bring the names within spec.
 *    | 10/29/2000            | Thorn Green (viridian_1138@yahoo.com)           | Classes did not have names that followed standard Java conventions.  | Performed a global modification to bring the names within spec.
 *    | 08/12/2001            | Thorn Green (viridian_1138@yahoo.com)           | First-Cut at Error Handling.                                         | First-Cut at Error Handling.
 *    | 09/29/2001            | Thorn Green (viridian_1138@yahoo.com)           | Meta contained anachronisms from C++ that could hurt performance.    | Removed a number of the anachronisms.
 *    | 05/10/2002            | Thorn Green (viridian_1138@yahoo.com)           | Redundant information in persistent storage.                         | Made numerous persistence and packaging changes.
 *    | 10/13/2005            | Thorn Green (viridian_1138@yahoo.com)           | Update copyright.                                                    | Update copyright.
 *    |                       |                                                 |                                                                      |
 *    |                       |                                                 |                                                                      |
 *    |                       |                                                 |                                                                      |
 *    |                       |                                                 |                                                                      |
 *    |                       |                                                 |                                                                      |
 *    |                       |                                                 |                                                                      |
 *    |                       |                                                 |                                                                      |
 *    |                       |                                                 |                                                                      |
 *    |                       |                                                 |                                                                      |
 *    |                       |                                                 |                                                                      |
 *    |                       |                                                 |                                                                      |
 *    |                       |                                                 |                                                                      |
 *
 *
 */

/**
 * This is a {@link LowLevelList} node containing a {@link HighLevelList}.  This is useful if one
 * wishes to create a list of lists (perhaps for a simple sparse matrix).
 * 
 * @author Thorn Green
 * @param <U> The type of the list node.
 * @param <T> The type of the data stored in the list.
 */
public abstract class AltLowLevelList<T extends Meta<T>, U extends AltLowLevelList<T,U>> extends LowLevelList<T,U> implements Externalizable {
	
	/**
	* Version number used to support versioned persistence.
	*/
	static final long serialVersionUID = (AltLowLevelList.class).getName().hashCode() + "v3/98A".hashCode();
	
   @Override
    public T getNode() {
        return (myRec);
    };
    
    /**
     * This is an undefined operation.  Do not use.
     */
    public void setNode(T input) { throw( new UndefinedOperation() );
    };
    
    /**
     * This is an undefined operation.  Do not use.
     */
    public void setCopyMode(int copy) { throw( new UndefinedOperation() );
    };
    
    /**
     * This is an undefined operation.  Do not use.
     */
    public int getCopyMode() { throw( new UndefinedOperation() );
    };
    
    @Override
    public void setCopyInfoMode(int copy) {
        this.copyInfoMode = copy;
    };
    
    @Override
    public int getCopyInfoMode() {
        return (this.copyInfoMode);
    };
    
    /**
     * Initializes the structure.
     */
    public void iAltHigh() {
        this.copyInfoMode = Meta.COPY_DATA_INFO;
    };
    
    /**
     * Constructor.
     */
    public AltLowLevelList() {
        super();
        this.iAltHigh();
    };
    
    /**
     * Disposes the structure according to the current EraseMode.
     */
    public void dispose() {
        this.eraseDat();
    };
    
    /**
     * Reads serial data.
     */
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
        
        try {
            VersionBuffer myv = (VersionBuffer) (in.readObject());
            VersionBuffer.chkNul(myv);
            
            T arec = (T) (myv.getProperty("MyRec"));
            arec.copyAllInfo( myRec );
            VersionBuffer.chkNul(myRec);
            copyInfoMode = myv.getInt("ThisCopyInfoMode");
        } catch (ClassCastException e) {
            throw (new DataFormatException(e));
        }
    }
    
    /**
     * Writes serial data.
     * <P>
     * @serialData TBD.
     */
    public void writeExternal(ObjectOutput out) throws IOException {
        VersionBuffer myv = new VersionBuffer(VersionBuffer.WRITE);
        
        myv.setProperty("MyRec", myRec);
        myv.setInt("ThisCopyInfoMode", copyInfoMode);
        
        super.writeExternal(out);
        out.writeObject(myv);
    }
    
    /**
     * Constructs the data stored in the node.
     * @return The data stored in the node.
     */
    protected abstract T construct();
    
    /**
     * The data stored in the node.
     */
    protected final T myRec = construct();
    
    /**
     * The CopyInfoMode for the node.
     */
    protected int copyInfoMode;
    
    /**
     * Copies to the parameter <code>input</code> using the current CopyInfoMode.
     * @param input The destination into which to copy the data.
     */
    protected void copyDat(U input) {
        if (copyInfoMode != Meta.COPY_DATA_INFO)
            myRec.exeCopyInfo(copyInfoMode, input.dvGetMyRec());
        
                /* For future exception handling purposes, it's very important that things happen
                        in this order. */
        
        input.dvSetCopyInfoMode(copyInfoMode);
        input.dvSetEraseMode(eraseMode);
    };
    
    /**
     * Gets the data stored in the node.
     * @return The data stored in the node.
     */
    private final T dvGetMyRec() {
        return (myRec);
    }
    
    /**
     * Sets the copy-info mode of the node.
     * @param in The copy-info mode of the node.
     */
    private final void dvSetCopyInfoMode(int in) {
        copyInfoMode = in;
    }
    
    /**
     * Sets the erase mode of the node.
     * @param in The erase mode of the node.
     */
    private final void dvSetEraseMode(int in) {
        eraseMode = in;
    }

    
};

