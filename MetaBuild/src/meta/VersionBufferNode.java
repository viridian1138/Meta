
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
 * Node internally stored within VersionBuffer.
 * 
 * @author tgreen
 *
 */
public class VersionBufferNode extends Meta<VersionBufferNode> {
    
	/**
	 * Constructor.
	 * @param callId The ID of the VersionBuffer instance associated with the node.
	 * @param user The user-specified per-instance key.
	 * @param hash Hash key for use with the global VersionBuffer table.
	 * @param val The object associated with the key.
	 */
    public VersionBufferNode(
            int callId,
            String user,
            String hash,
            Object val) {
        callerId = callId;
        userKey = user;
        hashKey = hash;
        value = val;
    }
    
    /**
     * Gets the object associated with the key.
     * @return The object associated with the key.
     */
    public Object getValue() {
        return (value);
    }
    
    /**
     * Gets the ID of the VersionBuffer instance associated with the node.
     * @return The ID of the VersionBuffer instance associated with the node.
     */
    public int getCallerId() {
        return (callerId);
    }
    
    /**
     * Gets the user-specified per-instance key.
     * @return The user-specified per-instance key.
     */
    public String getUserKey() {
        return (userKey);
    }
    
    /**
     * Gets the hash key for use with the global VersionBuffer table.
     * @return The Hash key for use with the global VersionBuffer table.
     */
    public String getHashKey() {
        return (hashKey);
    }
    
    @Override
    public void wake() {
    };
    
    
    /**
     * Hash key for use with the global VersionBuffer table.
     */
    private String hashKey;
    
    /**
     * The user-specified per-instance key.
     */
    private String userKey;
    
    /**
     * The object associated with the key.
     */
    private Object value;
    
    /**
     * The ID of the VersionBuffer instance associated with the node.
     */
    private int callerId;
    
    
}


