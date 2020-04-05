


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
import java.io.ObjectOutput;



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
 *    | 08/07/2004            | Thorn Green (viridian_1138@yahoo.com)           | Establish baseline for all changes in the last year.                 | Establish baseline for all changes in the last year.
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
 * HighLevelBinTree implements abstract linked Binary Trees which can be used
 * with any Meta-compliant datatype.  Both standard and Alt nodes are supported
 * by the data structure.  The information in each node is treated as a reference
 * to Meta, and to get it back to its original type one must use the typecast or
 * instanceof operators.<P>
 *	HighLevelBinTree structures are built out of linked collections of
 * {@link LowLevelBinTree} nodes.  The
 * {@link LowLevelBinTree} nodes implement many of the
 * features supported by HighLevelBinTree.<P>
 * 
 * @author Thorn Green
 * @param <U> The type of the tree node.
 * @param <T> The type of the data stored in the tree.
 */
public class HighLevelBinTree<T extends Meta<T>, U extends LowLevelBinTree<T,U>> extends Meta<HighLevelBinTree<T,U>> implements Externalizable {
	
	/**
	* Version number used to support versioned persistence.
	*/
	static final long serialVersionUID = (HighLevelBinTree.class).getName().hashCode() + "v3/98A".hashCode();
	
    @Override
    public HighLevelBinTree<T,U> copyNode() {
        HighLevelBinTree<T,U> temp = new HighLevelBinTree<T,U>();
        
        if (this.myTree != null) {
            temp.dvSetMyTree( myTree.copyNode() );
        } else {
            temp.dvSetMyTree(null);
        }
        
        return (temp);
    };
    
    @Override
    public HighLevelBinTree<T,U> copySub() {
        HighLevelBinTree<T,U> temp = new HighLevelBinTree<T,U>();
        
        if (this.myTree != null) {
            temp.dvSetMyTree( myTree.copySub() );
        } else {
            temp.dvSetMyTree(null);
        }
        
        return (temp);
    };
    
    @Override
    public HighLevelBinTree<T,U> copyAll() {
        HighLevelBinTree<T,U> temp = new HighLevelBinTree<T,U>();
        
        if (this.myTree != null) {
            temp.dvSetMyTree( myTree.copyAll() );
        } else {
            temp.dvSetMyTree(null);
        }
        
        return (temp);
    };
    
    @Override
    public HighLevelBinTree<T,U> copyData() {
        HighLevelBinTree<T,U> temp = new HighLevelBinTree<T,U>();
        
        return (temp);
    };
    
    @Override
    public HighLevelBinTree<T,U> copyDataPlusPtr() {
        HighLevelBinTree<T,U> temp = new HighLevelBinTree<T,U>();
        temp.dvSetMyTree(myTree);
        
        return (temp);
    };
    
    @Override
    public void copyNodeInfo(HighLevelBinTree<T,U> in) {
        HighLevelBinTree<T,U> temp = (HighLevelBinTree<T,U>) in;
        
        if (this.myTree != null) {
            temp.dvSetMyTree( myTree.copyNode() );
        } else {
            temp.dvSetMyTree(null);
        }
    };
    
    @Override
    public void copySubInfo(HighLevelBinTree<T,U> in) {
        HighLevelBinTree<T,U> temp = (HighLevelBinTree<T,U>) in;
        
        if (this.myTree != null) {
            temp.dvSetMyTree( myTree.copySub() );
        } else {
            temp.dvSetMyTree(null);
        }
    };
    
    @Override
    public void copyAllInfo(HighLevelBinTree<T,U> in) {
        HighLevelBinTree<T,U> temp = (HighLevelBinTree<T,U>) in;
        
        if (this.myTree != null) {
            temp.dvSetMyTree( myTree.copyAll() );
        } else {
            temp.dvSetMyTree(null);
        }
    };
    
    @Override
    public void copyDataInfo(HighLevelBinTree<T,U> in) {};
    
    @Override
    public void copyDataPlusPtrInfo(HighLevelBinTree<T,U> in) {
        HighLevelBinTree<T,U> temp = (HighLevelBinTree<T,U>) in;
        temp.dvSetMyTree(myTree);
    };
    
    @Override
    public void eraseNode() {
        if (this.myTree != null) {
            myTree.eraseNode();
        }
        
    };
    
    @Override
    public void eraseSub() {
        if (this.myTree != null) {
            myTree.eraseSub();
        }
        
    };
    
    @Override
    public void eraseAll() {
        if (this.myTree != null) {
            myTree.eraseAll();
        }
        
    };
    
    @Override
    public void eraseData() {};
    
    @Override
    public void eraseNodeInfo() {
        U temp;
        
        if (this.myTree != null) {
            if (myTree.right() != myTree)
                temp = myTree.right();
            else
                temp = null;
            myTree.eraseNode();
            myTree = temp;
        }
    };
    
    @Override
    public void eraseSubInfo() {
        U temp;
        
        if (this.myTree != null) {
            temp = null;
            myTree.eraseSub();
            myTree = temp;
        }
    };
    
    @Override
    public void eraseAllInfo() {
        if (this.myTree != null) {
            myTree.eraseAll();
        }
        
        myTree = null;
    };
    
    @Override
    public void erasePtrVal() {
        myTree = null;
    };
    
    @Override
    public void wake() {};
    
    /**
     * Initializes the binary tree.
     */
    public final void iHighLevelBinTree() {
        this.myTree = null;
    };
    
    /**
     * Constructor.
     */
    public HighLevelBinTree() {
        this.iHighLevelBinTree();
    };
    
    /**
     * Moves the current node one node to the right.
     */
    public final void right() {
        myTree = myTree.right();
    };
    
    /**
     * Moves the current node one node to the left.
     */
    public final void left() {
        myTree = myTree.left();
    };
    
    /**
     * Returns true iff. the left link of the current node is threaded.
     * @return True iff. the left link of the current node is threaded.
     */
    public final boolean lThread() {
        return (myTree.lThread());
    };
    
    /**
     * Returns true iff. the right link of the current node is threaded.
     * @return True iff. the right link of the current node is threaded.
     */
    public final boolean rThread() {
        return (myTree.rThread());
    };
    
    /**
     * Returns the data in the current node.
     * @return The data in the current node.
     */
    public final T getNode() {
        return ( myTree.getNode() );
    };
    
    /**
     * Sets the data in the current node to <code>in</code>.
     * @param in The data to set in the current node.
     */
    public final void setNode(T in) {
        myTree.setNode(in);
    };
    
    /**
     * Sets the CopyMode of the current node.
     * @param copy The CopyMode to set.
     */
    public final void setCopyMode(int copy) {
        myTree.setCopyMode(copy);
    };
    
    /**
     * Sets the CopyInfoMode of the current node.
     * @param copy The CopyInfoMode to set.
     */
    public final void setCopyInfoMode(int copy) {
        myTree.setCopyInfoMode(copy);
    };
    
    /**
     * Sets the EraseMode of the current node.
     * @param erase The EraseMode to set.
     */
    public final void setEraseMode(int erase) {
        myTree.setEraseMode(erase);
    };
    
    /**
     * Returns the CopyMode of the current node.
     * @return The CopyMode of the current node.
     */
    public final int getCopyMode() {
        return (myTree.getCopyMode());
    };
    
    /**
     * Returns the CopyInfoMode of the current node.
     * @return The CopyInfoMode of the current node.
     */
    public final int getCopyInfoMode() {
        return (myTree.getCopyInfoMode());
    };
    
    /**
     * Returns the EraseMode of the current node.
     * @return The EraseMode of the current node.
     */
    public final int getEraseMode() {
        return (myTree.getEraseMode());
    };
    
    /**
     * Returns true iff. the tree is empty.
     * @return True iff. the tree is empty.
     */
    public final boolean empty() {
        return (myTree == null);
    };
    
    /**
     * Returns true iff. the tree nodes are identical.
     * @param coppTree The tree to compare.
     * @return True iff. the tree nodes are identical.
     */
    public final boolean equal(HighLevelBinTree<T,U> compTree) {
        return (myTree == compTree.dvGetMyTree());
    };
    
    /**
     * Inserts the data <code>in</code> to the left of the current node.
     * @param in The data for the node to insert.
     */
    public final void addLeft(T in) {
        if (this.myTree != null) {
            myTree.addLeft(in);
            myTree = myTree.left();
        } else {
            myTree = (U)( new StdLowLevelBinTree<T>() );
            myTree.setNode(in);
        }
    };
    
    /**
     * Inserts the data <code>in</code> to the right of the current node.
     * @param in The data for the node to insert.
     */
    public final void addRight(T in) {
        if (this.myTree != null) {
            myTree.addRight(in);
            myTree = myTree.right();
        } else {
            myTree = (U)( new StdLowLevelBinTree<T>() );
            myTree.setNode(in);
        }
    };
    
    /**
     * Inserts the node <code>in</code> to the left of the current node.
     * @param in The node to insert.
     */
    public final void importAddLeft(U in) {
        if (this.myTree != null) {
            myTree.importAddLeft(in);
            myTree = myTree.left();
        } else {
            myTree = in;
        }
    };
    
    /**
     * Inserts the node <code>in</code> to the right of the current node.
     * @param in The node to insert.
     */
    public final void importAddRight(U in) {
        if (this.myTree != null) {
            myTree.importAddRight(in);
            myTree = myTree.right();
        } else {
            myTree = in;
        }
    };
    
    /**
     * Prunes everything to the left of the current node, using the EraseModes provided.
     */
    public final void pruneLeft() {
        if (myTree != null)
            myTree.pruneLeft();
        else {
            /* exit( 1 ); */
            /* throw( UndefinedOperation ); */
        }
    };
    
    /**
     * Places a copy of the left subtree of the current node in <code>out</code>.
     * @param out The destination to which to copy the left subtree.
     */
    public final void copyLeft(HighLevelBinTree<T,U> out) {
        if (myTree != null) {
            if (out.dvGetMyTree() != null)
                myTree.copyLeft(out.dvGetMyTree());
            else {
                /* Do Something Here. */
            }
        }
    };
    
    /**
     * Performs an inorder traversal, executing the Callback with each node visited.
     * @param tStop The node at which to stop the traversal.
     * @param inClass The callback to invoke upon traversing each node.
     */
    public final void inOrder(HighLevelBinTree<T,U> tStop, Callback<T> inClass ) {
        if (myTree != null) {
            myTree.inOrder(tStop.dvGetMyTree(), inClass);
        }
    };
    
    /**
     * Performs an preorder traversal, executing the Callback with each node visited.
     * @param tStop The node at which to stop the traversal.
     * @param inClass The callback to invoke upon traversing each node.
     */
    public final void preOrder(HighLevelBinTree<T,U> tStop, Callback<T> inClass) {
        if (myTree != null) {
            myTree.preOrder(tStop.dvGetMyTree(), inClass);
        }
    };
    
    /**
     * Performs an postorder traversal, executing the Callback with each node visited.
     * @param tStop The node at which to stop the traversal.
     * @param inClass The callback to invoke upon traversing each node.
     */
    public final void postOrder(HighLevelBinTree<T,U> tStop, Callback<T> inClass) {
        if (myTree != null) {
            myTree.postOrder(tStop.dvGetMyTree(), inClass);
        }
    };
    
    /**
     * Copies this tree to the right of <code>out</code>.
     * @param out The destination tree to which to copy the nodes.
     */
    public final void pasteRight(HighLevelBinTree<T,U> out) {
        if (myTree != null) {
            if (out.dvGetMyTree() != null) {
                myTree.pasteRight( out.dvGetMyTree() );
            } else {
                /* Do Something Here. */
            }
        }
    };
    
    /**
     * Copies this tree to the left of <code>out</code>.
     * @param out The destination tree to which to copy the nodes.
     */
    public final void pasteLeft(HighLevelBinTree<T,U> out) {
        if (myTree != null) {
            if (out.dvGetMyTree() != null) {
                myTree.pasteLeft( out.dvGetMyTree() );
            } else {
                /* Do Something Here. */
            }
        }
    };
    
    /**
     * Connects this tree to the right of <code>out</code>.
     * @param out The tree to which to connect nodes.
     */
    public final void connectRight(HighLevelBinTree<T,U> out) {
        if (myTree != null) {
            if (out.dvGetMyTree() != null) {
                myTree.connectRight( out.dvGetMyTree() );
            } else {
                /* Do Something Here. */
            }
        }
    };
    
    /**
     * Connects this tree to the left of <code>out</code>.
     * @param out The tree to which to connect nodes.
     */
    public final void connectLeft(HighLevelBinTree<T,U> out) {
        if (myTree != null) {
            if (out.dvGetMyTree() != null) {
                myTree.connectLeft( out.dvGetMyTree() );
            } else {
                /* Do Something Here. */
            }
        }
    };
    
    /**
     * Traverses to the right until a right-thread is found.  Then sets the current node
     * to that node.
     */
    public final void findEnd() {
        if (myTree != null)
            myTree = myTree.findEnd();
        else {
            /* Do Something Here. */
        }
    };
    
    /**
     * As if the binary tree is a representation of a generalized list, finds
     * the "parent" of the current node and sets the current node to that node.
     */
    public final void listParent() {
        if (myTree != null)
            myTree = myTree.listParent();
        else {
            /* Do Something Here. */
        }
    };
    
    /**
     * Writes serial data.
     * <P>
     * @serialData TBD.
     */
    public void writeExternal(ObjectOutput out) throws IOException {
        U tmp = myTree;
        
        if (tmp == null) {} else {
            out.writeObject(myTree);
        }
        
        out.writeObject("s"); /* Stop */
    }
    
    /**
     * Reads serial data.
     */
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        try {
            myTree = null;
            Object myo = in.readObject();
            
            while (myo instanceof LowLevelBinTree) {
                U myl = (U) myo;
                VersionBuffer.chkNul(myl);
                
                if (myTree == null) {
                    myTree = myl;
                }
                
                myo = in.readObject();
            }
        } catch (ClassCastException e) {
            throw (new DataFormatException(e));
        }
        
    }
    
    /**
     * Sets the current node pointed to by the tree.
     * @param in The current node pointed to by the tree.
     */
    private final void dvSetMyTree(U in) {
        myTree = in;
    }
    
    /**
     * Gets the current node pointed to by the tree.
     * @return in The current node pointed to by the tree.
     */
    private final U dvGetMyTree() {
        return (myTree);
    }
    
    /**
     * The current node pointed to by the tree.
     */
    private U myTree;
    
    
};

