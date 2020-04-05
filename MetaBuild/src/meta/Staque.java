



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
 * Staque stands for "stack-queue" or
 * "stack and queue".  The Staque class uses the functionality of
 * {@link HighLevelList} to implement both a linked stack and a linked queue.
 * That is to say, Staque is a single data structure which functions as both a stack and a queue.
 * Typical stack and queue operations (e.g. Push, Pop, Enq, Deq) are supported.  Both standard and
 * Alt-nodes are supported.
 * 
 * @author Thorn Green
 * @param <U> The type of the list node in the Staque.
 * @param <T> The type of the data stored in the Staque.
 */
public class Staque<T extends Meta<T>, U extends LowLevelList<T,U>> extends Meta<Staque<T,U>> {
	
    @Override
    public Staque<T,U> copyNode() {
        Staque<T,U> temp = new Staque<T,U>();
        qHighLevelList.copyNodeInfo(temp.dvGetQHighLevelList());
        return (temp);
    };
    
    @Override
    public Staque<T,U> copySub() {
        Staque<T,U> temp = new Staque<T,U>();
        qHighLevelList.copySubInfo(temp.dvGetQHighLevelList());
        return (temp);
    };
    
    @Override
    public Staque<T,U> copyAll() {
        Staque<T,U> temp = new Staque<T,U>();
        qHighLevelList.copyAllInfo(temp.dvGetQHighLevelList());
        return (temp);
    };
    
    @Override
    public Staque<T,U> copyData() {
        Staque<T,U> temp = new Staque<T,U>();
        qHighLevelList.copyDataInfo(temp.dvGetQHighLevelList());
        return (temp);
    };
    
    @Override
    public Staque<T,U> copyDataPlusPtr() {
        Staque<T,U> temp = new Staque<T,U>();
        qHighLevelList.copyDataPlusPtrInfo(temp.dvGetQHighLevelList());
        return (temp);
    };
    
    @Override
    public void copyNodeInfo(Staque<T,U> in) {
        Staque<T,U> temp = in;
        qHighLevelList.copyNodeInfo(temp.dvGetQHighLevelList());
    };
    
    @Override
    public void copySubInfo(Staque<T,U> in) {
        Staque<T,U> temp = in;
        qHighLevelList.copySubInfo(temp.dvGetQHighLevelList());
    };
    
    @Override
    public void copyAllInfo(Staque<T,U> in) {
        Staque<T,U> temp = in;
        qHighLevelList.copyAllInfo(temp.dvGetQHighLevelList());
    };
    
    @Override
    public void copyDataInfo(Staque<T,U> in) {
        Staque<T,U> temp = in;
        qHighLevelList.copyDataInfo(temp.dvGetQHighLevelList());
    };
    
    @Override
    public void copyDataPlusPtrInfo(Staque<T,U> in) {
        Staque<T,U> temp = in;
        qHighLevelList.copyDataPlusPtrInfo(temp.dvGetQHighLevelList());
    };
    
    @Override
    public void eraseNode() {
        qHighLevelList.eraseNodeInfo();
    };
    
    @Override
    public void eraseSub() {
        qHighLevelList.eraseSubInfo();
    };
    
    @Override
    public void eraseAll() {
        qHighLevelList.eraseAllInfo();
    };
    
    @Override
    public void eraseData() {};
    
    @Override
    public void eraseNodeInfo() {
        qHighLevelList.eraseNodeInfo();
    };
    
    @Override
    public void eraseSubInfo() {
        qHighLevelList.eraseSubInfo();
    };
    
    @Override
    public void eraseAllInfo() {
        qHighLevelList.eraseAllInfo();
    };
    
    @Override
    public void erasePtrVal() {
        qHighLevelList.erasePtrVal();
    };
    
    @Override
    public void wake() {};
    
    /**
     * Adds an element as if the DS is a queue.
     * @param in The data for the node to be inserted.
     */
    public final void enq(T in) {
        HighLevelList<T,U> ql = qHighLevelList;
        ql.insertLeft(in);
    };
    
    /**
     * Pushes an element as if the DS is a stack.
     * @param in The data for the node to be inserted.
     */
    public final void push(T in) {
        HighLevelList<T,U> ql = qHighLevelList;
        ql.insertLeft(in);
    };
    
    /**
     * Adds an element as if the DS is a queue.
     * @param in The node to be inserted.
     */
    public final void importEnq(U in) {
        HighLevelList<T,U> ql = qHighLevelList;
        ql.importInsertLeft(in);
    };
    
    /**
     * Pushes an element as if the DS is a stack.
     * @param in The node to be inserted.
     */
    public final void importPush(U in) {
        HighLevelList<T,U> ql = qHighLevelList;
        ql.importInsertLeft(in);
    };
    
    /**
     * Pops a stack node.
     * <P>
     * <B>In:</B> None.<BR>
     * <B>Out:</B> <BR>
     * <B>Pre:</B> The stack is not empty.  The stack is properly constructed.<BR>
     * <B>Post:</B> The node will be deleted, and its value returned.
     * <P>
     * @return The popped node.
     *
     * @author Thorn Green
     */
    public final T pop() {
        HighLevelList<T,U> ql = qHighLevelList;
        T temp = ql.getNode();
        
        ql.eraseNodeInfo();
        return (temp);
    };
    
    /**
     * Deqs a queue node.
     * <P>
     * <B>In:</B> None.<BR>
     * <B>Out:</B> <BR>
     * <B>Pre:</B> The queue is not empty.  The queue is properly constructed.<BR>
     * <B>Post:</B> The node will be deleted, and its value returned.
     * <P>
     * @return The deq-ed node.
     * @author Thorn Green
     */
    public final T deq() {
        T temp;
        
        HighLevelList<T,U> ql = qHighLevelList;
        ql.left();
        temp = ql.getNode();
        ql.eraseNodeInfo();
        return (temp);
    };
    
    /**
     * Returns true if the DS is empty.
     * @return True if the DS is empty.
     */
    public final boolean empty() {
        HighLevelList<T,U> ql = qHighLevelList;
        return (ql.empty());
    };
    
    /**
     * Gets the front node of a stack or queue.
     * <P>
     * <B>In:</B> None.<BR>
     * <B>Out:</B><BR>
     * <B>Pre:</B> The Staque is not empty.  The Staque is properly constructed.<BR>
     * <B>Post:</B> The node value will be returned.
     * <P>
     * @return The front node.
     * @author Thorn Green
     */
    public final T getFrontNode() {
        T temp;
        
        HighLevelList<T,U> ql = qHighLevelList;
        ql.left();
        temp = ql.getNode();
        ql.right();
        return (temp);
    };
    
    /**
     * Gets the rear node of a stack or queue.
     * <P>
     * <B>In:</B> None.<BR>
     * <B>Out:</B><BR>
     * <B>Pre:</B> The Staque is not empty.  The Staque is properly constructed.<BR>
     * <B>Post:</B> The node value will be returned.
     * <P>
     * @return The rear node.
     * @author Thorn Green
     */
    public final T getRearNode() {
        HighLevelList<T,U> ql = qHighLevelList;
        return (ql.getNode());
    };
    
    /**
     * Gets the front copy mode of a stack or queue.
     * <P>
     * <B>In:</B> None.<BR>
     * <B>Out:</B><BR>
     * <B>Pre:</B> The Staque is not empty.  The Staque is properly constructed.<BR>
     * <B>Post:</B> The copy mode value will be returned.
     * <P>
     * @return The front copy mode.
     * @author Thorn Green
     */
    public final int getFrontCopyMode() {
        int temp;
        
        HighLevelList<T,U> ql = qHighLevelList;
        ql.left();
        temp = ql.getCopyMode();
        ql.right();
        return (temp);
    };
    
    /**
     * Gets the rear copy mode of a stack or queue.
     * <P>
     * <B>In:</B> None.<BR>
     * <B>Out:</B><BR>
     * <B>Pre:</B> The Staque is not empty.  The Staque is properly constructed.<BR>
     * <B>Post:</B> The copy mode value will be returned.
     * <P>
     * @return The rear copy mode.
     * @author Thorn Green
     */
    public final int getRearCopyMode() {
        HighLevelList<T,U> ql = qHighLevelList;
        return (ql.getCopyMode());
    };
    
    /**
     * Gets the front erase mode of a stack or queue.
     * <P>
     * <B>In:</B> None.<BR>
     * <B>Out:</B><BR>
     * <B>Pre:</B> The Staque is not empty.  The Staque is properly constructed.<BR>
     * <B>Post:</B> The erase mode value will be returned.
     * <P>
     * @return The front erase mode.
     * @author Thorn Green
     */
    public final int getFrontEraseMode() {
        int temp;
        
        HighLevelList<T,U> ql = qHighLevelList;
        ql.left();
        temp = ql.getEraseMode();
        ql.right();
        return (temp);
    };
    
    /**
     * Gets the rear erase mode of a stack or queue.
     * <P>
     * <B>In:</B> None.<BR>
     * <B>Out:</B><BR>
     * <B>Pre:</B> The Staque is not empty.  The Staque is properly constructed.<BR>
     * <B>Post:</B> The erase mode value will be returned.
     * <P>
     * @return The rear erase mode.
     * @author Thorn Green
     */
    public final int getRearEraseMode() {
        HighLevelList<T,U> ql = qHighLevelList;
        return (ql.getEraseMode());
    };
    
    /**
     * Sets the front node of a stack or queue.
     * <P>
     * <B>In:</B> The node value to set.<BR>
     * <B>Out:</B> Staque modified.<BR>
     * <B>Pre:</B> The Staque is not empty.  The Staque is properly constructed.<BR>
     * <B>Post:</B> The front node will be set.
     * <P>
     * @param in The data to be set in the front node.
     * @author Thorn Green
     */
    public final void setFrontNode(T in) {
        HighLevelList<T,U> ql = qHighLevelList;
        ql.left();
        ql.setNode(in);
        ql.right();
    };
    
    /**
     * Sets the rear node of a stack or queue.
     * <P>
     * <B>In:</B> The node value to set.<BR>
     * <B>Out:</B> Staque modified.<BR>
     * <B>Pre:</B> The Staque is not empty.  The Staque is properly constructed.<BR>
     * <B>Post:</B> The rear node will be set.
     * <P>
     * @param in The data to be set in the rear node.
     * @author Thorn Green
     */
    public final void setRearNode(T in) {
        HighLevelList<T,U> ql = qHighLevelList;
        ql.setNode(in);
    };
    
    /**
     * Sets the front copy mode of a stack or queue.
     * <P>
     * <B>In:</B> The node value to set.<BR>
     * <B>Out:</B> Staque modified.<BR>
     * <B>Pre:</B> The Staque is not empty.  The Staque is properly constructed.<BR>
     * <B>Post:</B> The copy mode will be set.
     * <P>
     * @param in The front copy mode to set.
     * @author Thorn Green
     */
    public final void setFrontCopyMode(int in) {
        HighLevelList<T,U> ql = qHighLevelList;
        ql.left();
        ql.setCopyMode(in);
        ql.right();
    };
    
    /**
     * Sets the rear copy mode of a stack or queue.
     * <P>
     * <B>In:</B> The node value to set.<BR>
     * <B>Out:</B> Staque modified.<BR>
     * <B>Pre:</B> The Staque is not empty.  The Staque is properly constructed.<BR>
     * <B>Post:</B> The copy mode will be set.
     * <P>
     * @param in The rear copy mode to set.
     * @author Thorn Green
     */
    public final void setRearCopyMode(int in) {
        HighLevelList<T,U> ql = qHighLevelList;
        ql.setCopyMode(in);
    };
    
    /**
     * Sets the front erase mode of a stack or queue.
     * <P>
     * <B>In:</B> The node value to set.<BR>
     * <B>Out:</B> Staque modified.<BR>
     * <B>Pre:</B> The Staque is not empty.  The Staque is properly constructed.<BR>
     * <B>Post:</B> The erase mode will be set.
     * <P>
     * @param in The front erase mode to set.
     * @author Thorn Green
     */
    public final void setFrontEraseMode(int in) {
        HighLevelList<T,U> ql = qHighLevelList;
        ql.left();
        ql.setEraseMode(in);
        ql.right();
    };
    
    /**
     * Sets the rear erase mode of a stack or queue.
     * <P>
     * <B>In:</B> The node value to set.<BR>
     * <B>Out:</B> Staque modified.<BR>
     * <B>Pre:</B> The Staque is not empty.  The Staque is properly constructed.<BR>
     * <B>Post:</B> The erase mode will be set.
     * <P>
     * @param in The rear erase mode to set.
     * @author Thorn Green
     */
    public final void setRearEraseMode(int in) {
        HighLevelList<T,U> ql = qHighLevelList;
        ql.setEraseMode(in);
    };
    
    /**
     * Gets the list of elements in the stack or queue.
     * @return The list of elements in the stack or queue.
     */
    private final HighLevelList<T,U> dvGetQHighLevelList() {
        return (qHighLevelList);
    }
    
    /**
     * Initializes the Staque.
     */
    public final void iStaque() {
        HighLevelList<T,U> ql = qHighLevelList;
        ql.iHighLevelList();
    };
    
    /**
     * Constructor.
     */
    public Staque() {
        this.iStaque();
    };
    
    /**
     * List of elements in the stack or queue.
     */
    private final HighLevelList<T,U> qHighLevelList = new HighLevelList<T,U>();
    
    
};


