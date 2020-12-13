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

package com.archecraft.games.minecraft.mods.container

import com.archecraft.games.minecraft.mods.blocks.CrusherBlock
import com.archecraft.games.minecraft.mods.setup.ModBlocks
import com.archecraft.games.minecraft.mods.setup.ModContainers
import com.archecraft.games.minecraft.mods.tileentities.CrusherTileEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.container.Container
import net.minecraft.network.PacketBuffer
import net.minecraft.util.IWorldPosCallable

class CrusherContainer(windowId: Int, playerInv: PlayerInventory, val tile: CrusherTileEntity) : Container(ModContainers.CRUSHER, windowId) {
    constructor(windowId: Int, playerInv: PlayerInventory, data: PacketBuffer) : this(windowId, playerInv, getTileEntity(playerInv, data))
    
    private val canInteractWithCallable = IWorldPosCallable.of(tile.world ?: throw IllegalStateException("TileEntity is not in a world"), tile.pos)
    
    
    override fun canInteractWith(playerIn: PlayerEntity): Boolean = isWithinUsableDistance(canInteractWithCallable, playerIn, ModBlocks.CRUSHER)
    
    
    companion object {
        private fun getTileEntity(playerInv: PlayerInventory, data: PacketBuffer): CrusherTileEntity {
            val tileAtPos = playerInv.player.world.getTileEntity(data.readBlockPos())
            return if (tileAtPos is CrusherTileEntity) tileAtPos else throw IllegalStateException("Invalid TileEntity $tileAtPos")
        }
    }
}