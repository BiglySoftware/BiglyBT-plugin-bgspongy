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

import java.security.MessageDigest;
import java.security.Provider;
import java.util.Map;

import org.spongycastle.jcajce.provider.digest.SHA512.Digest;
import org.spongycastle.jce.provider.BouncyCastleProvider;

import com.biglybt.pif.*;
import com.biglybt.pif.ipc.IPCException;


public class 
SpongyPlugin
	implements Plugin
{
	public static void
	load(
		PluginInterface		pi )
	{
		pi.getPluginProperties().setProperty( "plugin.initialize.after.load", "true" );
	}

	private Provider 	provider;
	
	@Override
	public void 
	initialize(
		PluginInterface pluginInterface ) 
		
		throws PluginException
	{
		try{
			provider = new BouncyCastleProvider();
			
			// Security.addProvider( provider );
			
		}catch( Throwable e ){
			
			throw( new PluginException( e ));
		}
	}
	
	public Object
	getDigest(
		Map<String,Object>		params )
	
		throws IPCException
	{
		if ( provider == null ){
		
			throw( new IPCException( "Provider not available" ));
		}
		
		try{
			String	alg = (String)params.get( "alg" );
			
			MessageDigest digest = Digest.getInstance( alg, provider );
			
			return( digest );
			
		}catch( Throwable e ){
			
			throw( new IPCException( e ));
		}
	}
}
