/* ****************************************************************************
 *
 * [ Count.java ]
 *
 * COPYRIGHT (c) 2002 - 2021 by Allianz-Suisse, Zürich, Switzerland.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Allianz-Suisse.
 *
 ******************************************************************************/
package ch.allianz.fileReader;

import java.io.IOException;

public interface Consume {

    public void consume() throws IOException;

}
