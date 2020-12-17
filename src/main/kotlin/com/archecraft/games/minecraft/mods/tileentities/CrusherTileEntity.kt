/*
 *  Copyright (C) 2020  Noah Dörr
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.archecraft.games.minecraft.mods.tileentities

import com.archecraft.games.minecraft.mods.setup.ModTileEntities
import net.minecraft.block.BlockState
import net.minecraft.nbt.CompoundNBT
import net.minecraft.network.NetworkManager
import net.minecraft.network.play.server.SUpdateTileEntityPacket
import net.minecraft.tileentity.TileEntity

class CrusherTileEntity : TileEntity(ModTileEntities.CRUSHER) {
    override fun getUpdateTag(): CompoundNBT {
        val nbt = CompoundNBT()
        
        return nbt
    }
    
    override fun handleUpdateTag(state: BlockState, tag: CompoundNBT) {
    
    }
    
    override fun getUpdatePacket(): SUpdateTileEntityPacket {
        val nbt = CompoundNBT()
        
        return SUpdateTileEntityPacket(getPos(), -1, nbt)
    }
    
    override fun onDataPacket(net: NetworkManager, pkt: SUpdateTileEntityPacket) {
        val nbt = pkt.nbtCompound
    }
}