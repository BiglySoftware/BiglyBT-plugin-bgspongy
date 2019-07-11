/*
 * Copyright (C) Bigly Software, Inc, All Rights Reserved.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA
 */

package com.biglybt.plugins.bgspongy;

import com.biglybt.pif.*;


public class 
SpongyPlugin
	implements UnloadablePlugin
{
	public static void
	load(
		PluginInterface		pi )
	{
		pi.getPluginProperties().setProperty( "plugin.initialize.after.load", "true" );
	}
	
	@Override
	public void 
	initialize(
		PluginInterface pluginInterface ) 
		
		throws PluginException
	{
	}
	
	@Override
	public void 
	unload() 
		
		throws PluginException
	{
	}
}
