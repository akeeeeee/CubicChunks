/*******************************************************************************
 * Copyright (c) 2014 Jeff Martin.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Jeff Martin - initial API and implementation
 ******************************************************************************/
package cuchaz.cubicChunks;

import cuchaz.cubicChunks.util.Coords;

public class CubeProviderTools
{
	public static boolean blocksExist( CubeProvider provider, int minBlockX, int minBlockY, int minBlockZ, int maxBlockX, int maxBlockY, int maxBlockZ )
	{
		// convert block bounds to chunk bounds
		int minCubeX = Coords.blockToCube( minBlockX );
		int minCubeY = Coords.blockToCube( minBlockY );
		int minCubeZ = Coords.blockToCube( minBlockZ );
		int maxCubeX = Coords.blockToCube( maxBlockX );
		int maxCubeY = Coords.blockToCube( maxBlockY );
		int maxCubeZ = Coords.blockToCube( maxBlockZ );
		
		return cubesExist( provider, minCubeX, minCubeY, minCubeZ, maxCubeX, maxCubeY, maxCubeZ );
	}
	
	public static boolean cubesExist( CubeProvider provider, int minCubeX, int minCubeY, int minCubeZ, int maxCubeX, int maxCubeY, int maxCubeZ )
	{
		for( int cubeX=minCubeX; cubeX<=maxCubeX; cubeX++ )
		{
			for( int cubeY=minCubeY; cubeY<=maxCubeY; cubeY++ )
			{
				for( int cubeZ=minCubeZ; cubeZ<=maxCubeZ; cubeZ++ )
				{
					if( !provider.cubeExists( cubeX, cubeY, cubeZ ) )
					{
						return false;
					}
				}
			}
		}
		return true;
	}
}