/* GraphConfiguration
 *
 * $Id$:
 *
 * Created on Apr 9, 2010.
 *
 * Copyright (C) 2006 Internet Archive.
 *
 * This file is part of Wayback.
 *
 * Wayback is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * any later version.
 *
 * Wayback is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser Public License for more details.
 *
 * You should have received a copy of the GNU Lesser Public License
 * along with Wayback; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.archive.wayback.util.graph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;

/**
 * @author brad
 *
 */
public class GraphConfiguration {
	final static float dash1[] = {3.0f};
    final static BasicStroke dashed = new BasicStroke(1.0f, 
                                          BasicStroke.CAP_BUTT, 
                                          BasicStroke.JOIN_MITER, 
                                          3.0f, dash1, 0.0f);

	/**
	 * Main background color for graphs
	 */
	public Color backgroundColor = Color.white;

	/**
	 * font size for Year/Month labels
	 */
	public int regionFontSize = 9;
	/**
	 * font name for Year/Month labels
	 */
	public String regionFontName = Font.SANS_SERIF;
	/**
	 * font style for Year/Month labels
	 */
	public int regionFontStyle = Font.PLAIN;
	/**
	 * font Color for Year/Month labels
	 */
	public Color regionLabelColor = Color.black;
	/**
	 * top/bottom font padding for Year/Month labels
	 */
	public int fontPadY = 2;
	/**
	 * left font padding for Year/Month labels
	 */
	public int fontPadX = 4;

	/**
	 * color for Year/Month border lines
	 */
	public Color regionBorderColor = Color.darkGray;
	/**
	 * Stroke for Year/Month border lines
	 */
	public Stroke regionBorderStroke = dashed;

	/**
	 * Background color for active/selected Year/Month
	 */
	public Color regionHighlightColor = Color.lightGray;

	/**
	 * color for non-active/selected graph values
	 */
	public Color valueColor = Color.blue;
	/**
	 * color for active/selected graph values
	 */
	public Color valueHighlightColor = Color.green;

	/**
	 * Minimum pixel height for non-zero graph values
	 */
	public int valueMinHeight = 5;


	private Font regionLabelFont = null;
	/**
	 * @return the current Font to use for Month/Year labels, combination of
	 *   regionFontStyle, regionFontSize, regionFontName
	 */
	public Font getRegionLabelFont() {
		if(regionLabelFont == null) {
			regionLabelFont = new Font(regionFontName,
					regionFontStyle,regionFontSize);
		}
		return regionLabelFont;
	}
	/**
	 * Set whatever redneringHints are needed to properly draw the graph, ie.
	 * AntiAliasing, etc.
	 * @param g2d The Graphics2D objects on which the hints should be set.
	 */
	public void setRenderingHints(Graphics2D g2d) {
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}
}
