package com.modcrafting.lightingmobs;

import java.util.function.Supplier;

import com.modcrafting.lightingmobs.blocks.lightningblock.LightningBlock;
import com.modcrafting.lightingmobs.blocks.lightningblock.LightningBlockItem;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Registry {
	
	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LMobs.MODID);
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LMobs.MODID);
	
	public static final RegistryObject<Block> LIGHTNING_BLOCK = BLOCKS.register("lightning_block", () -> LightningBlock.init());
	public static final RegistryObject<BlockItem> LIGHTNING_BLOCK_ITEM = registerBlockItem(LIGHTNING_BLOCK, () -> LightningBlockItem.init());
	
	public static void init() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		BLOCKS.register(bus);
		ITEMS.register(bus);
	}
	
	private static RegistryObject<BlockItem> registerBlockItem(RegistryObject<Block> regBlock, Supplier<? extends BlockItem> sup) {
		return ITEMS.register(regBlock.get().getRegistryName().getPath(), sup);
	}
	
}
