



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
 *    | 08/12/2001            | Thorn Green (viridian_1138@yahoo.com)           | Needed a set of standard exceptions for verdantium error handling.   | Initial creation.
 *    | 11/17/2001            | Thorn Green (viridian_1138@yahoo.com)           | Verdantium Exceptions not modular or extensible.                     | Made the exception handling more extensible.
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
 * An exception indicating that needed information was not found in the
 * input data format.
 * 
 * @author Thorn Green
 */
public class DataFormatException extends IOException implements PrimitiveThrowHandler {
	
	/**
	 * The error or exception being wrapped, or null if there is none.
	 */
    Throwable wrap = null;
    
    /**
     * Constructor.
     * @param e The error or exception being wrapped, or null if there is none.
     */
    public DataFormatException(Throwable e) {
        super();
        wrap = e;
    }
    
    /**
     * Constructor.
     */
    public DataFormatException() {
        super();
    }
    
    /**
     * Constructor.
     * @param str The message associated with the exception.
     */
    public DataFormatException(String str) {
        super(str);
    }
    
    /**
     * Gets the error or exception being wrapped, or null if there is none.
     * @return The error or exception being wrapped, or null if there is none.
     */
    public Throwable getWrap() {
        return (wrap);
    }
    
    @Override
    public void printStackTrace(PrintWriter out) {
        super.printStackTrace(out);
        if (wrap != null) {
            out.print("\n\nWrapping Exception [[[ \n\n");
            wrap.printStackTrace(out);
            out.print("\n\n]]] End Wrap\n");
        }
    }
    
    @Override
    public void printStackTrace(PrintStream out) {
        super.printStackTrace(out);
        if (wrap != null) {
            out.print("\n\nWrapping Exception [[[ \n\n");
            wrap.printStackTrace(out);
            out.print("\n\n]]] End Wrap\n");
        }
    }
    
    /**
     * Prints the stack trace to system out.
     */
    public void printStackTrace() {
        printStackTrace(System.out);
    }
    
    /**
     * Supports primitive exception handling capability.
     * @param in The error or exception to be handled.
     */
    public Object[] handleThrow(Throwable in) {
        Object[] ret =
        {
            in,
                    "Data Format Exception",
                    "Data Format Exception : ",
                    "The Data Being Loaded Does Not Match The Expected Format." };
                    
                    return (ret);
    }

    
}

