


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

import java.io.PrintStream;
import java.io.PrintWriter;



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
 *    | 08/12/2001            | Thorn Green (viridian_1138@yahoo.com)           | First-Cut at Error Handling.                                         | First-Cut at Error Handling.
 *    | 05/10/2002            | Thorn Green (viridian_1138@yahoo.com)           | Re-organize package relationships.                                   | Moved class to package meta.
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
 * A runtime exception that wraps a reference to the original exception
 * that produced it.  The stored exception is useful for post-mortem debugging.
 * 
 * @author Thorn Green
 */
public class WrapRuntimeException extends RuntimeException {
	
	/**
	 * The error or exception to be wrapped.
	 */
    Throwable wrapped = null;
    
    /**
     * Constructor.
     * @param thr The error or exception to be wrapped.
     */
    public WrapRuntimeException(Throwable thr) {
        super();
        wrapped = thr;
    }
    
    /**
     * Constructor.
     * @param str The message associated with the exception.
     * @param thr The error or exception to be wrapped.
     */
    public WrapRuntimeException(String str, Throwable thr) {
        super(str);
        wrapped = thr;
    }
    
    /**
     * Gets the error or exception being wrapped, or null if there is none.
     * @return The error or exception being wrapped, or null if there is none.
     */
    public Throwable getWrapped() {
        return (wrapped);
    }
    
    @Override
    public void printStackTrace(PrintWriter out) {
        super.printStackTrace(out);
        out.print("\n\nWrapping Exception [[[ \n\n");
        wrapped.printStackTrace(out);
        out.print("\n\n]]] End Wrap\n");
    }
    
    @Override
    public void printStackTrace(PrintStream out) {
        super.printStackTrace(out);
        out.print("\n\nWrapping Exception [[[ \n\n");
        wrapped.printStackTrace(out);
        out.print("\n\n]]] End Wrap\n");
    }
    
    /**
     * Prints the stack trace to system out.
     */
    public void printStackTrace() {
        printStackTrace(System.out);
    }
    
    
}


