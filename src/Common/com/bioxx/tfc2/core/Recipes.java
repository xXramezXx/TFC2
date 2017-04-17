package com.bioxx.tfc2.core;

import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import com.bioxx.tfc2.TFCBlocks;
import com.bioxx.tfc2.TFCItems;
import com.bioxx.tfc2.api.crafting.CraftingManagerTFC;
import com.bioxx.tfc2.api.crafting.CraftingManagerTFC.RecipeType;
import com.bioxx.tfc2.items.ToolHeadType;

public class Recipes 
{
	public final static int WILDCARD = 32767;

	public static void RegisterNormalRecipes()
	{
		CraftingManagerTFC manager = CraftingManagerTFC.getInstance();
		manager.addShapelessRecipe(RecipeType.NORMAL, new ItemStack(TFCItems.StoneAxe), new ItemStack(TFCItems.ToolHead, 1, ToolHeadType.STONE_AXE.ordinal()), "stickWood");
		manager.addShapelessRecipe(RecipeType.NORMAL, new ItemStack(TFCItems.StoneKnife), new ItemStack(TFCItems.ToolHead, 1, ToolHeadType.STONE_KNIFE.ordinal()), "stickWood");
		manager.addShapelessRecipe(RecipeType.NORMAL, new ItemStack(TFCItems.StoneShovel), new ItemStack(TFCItems.ToolHead, 1, ToolHeadType.STONE_SHOVEL.ordinal()), "stickWood");
		manager.addShapelessRecipe(RecipeType.NORMAL, new ItemStack(TFCItems.StoneHoe), new ItemStack(TFCItems.ToolHead, 1, ToolHeadType.STONE_HOE.ordinal()), "stickWood");
		manager.addRecipe(RecipeType.NORMAL, new ItemStack(TFCItems.Firestarter), " X","X ", 'X', "stickWood");
		manager.addRecipe(RecipeType.NORMAL, new ItemStack(TFCBlocks.Thatch), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(TFCItems.Straw, 1)});
		manager.addShapelessRecipe(RecipeType.NORMAL, new ItemStack(TFCItems.Straw, 4), new Object[]{new ItemStack(TFCBlocks.Thatch, 1)});

		List<IRecipe> list = CraftingManager.getInstance().getRecipeList();
		for(int i = 0; i < list.size(); i++)
		{
			IRecipe rec = list.get(i);
			if(rec.getRecipeOutput().getItem() == Item.getItemFromBlock(Blocks.CRAFTING_TABLE))
			{
				CraftingManager.getInstance().getRecipeList().remove(i);
			}

		}
	}

	public static void RegisterKnappingRecipes()
	{
		CraftingManagerTFC manager = CraftingManagerTFC.getInstance();
		manager.addRecipe(RecipeType.KNAPPING, new ItemStack(TFCItems.ToolHead, 1, ToolHeadType.STONE_AXE.ordinal()), "         "," XXXX    ","XXXXXX X ","XXXXXXXXX","XXXXXXXXX","XXXXXXXXX","XXXXXX X "," XXXX    ","         ", 'X', new ItemStack(TFCItems.LooseRock, 1, WILDCARD));
		manager.addRecipe(RecipeType.KNAPPING, new ItemStack(TFCItems.ToolHead, 1, ToolHeadType.STONE_SHOVEL.ordinal()) ,"  XXXXX  "," XXXXXXX "," XXXXXXX "," XXXXXXX "," XXXXXXX "," XXXXXXX "," XXXXXXX "," XXXXXXX ","   XXX   ", 'X', new ItemStack(TFCItems.LooseRock, 1, WILDCARD));
		manager.addRecipe(RecipeType.KNAPPING, new ItemStack(TFCItems.ToolHead, 1, ToolHeadType.STONE_KNIFE.ordinal()) ,"XX       ","XXX      ","XXXX     "," XXXX    ","  XXXX   ","   X XX  ","      XX ","       XX","        X", 'X', new ItemStack(TFCItems.LooseRock, 1, WILDCARD));
		manager.addRecipe(RecipeType.KNAPPING, new ItemStack(TFCItems.ToolHead, 1, ToolHeadType.STONE_HOE.ordinal()) ,"         ","XXX      ","  XX     ","   XX    ","    XX   ","    XXX  ","    XXX  ","         ","         ", 'X', new ItemStack(TFCItems.LooseRock, 1, WILDCARD));

		manager.addShapelessRecipe(RecipeType.ANVIL, new ItemStack(Items.GOLD_INGOT, 1 , 0), new ItemStack(Items.IRON_INGOT, 1), new ItemStack(Items.IRON_INGOT, 1));
	}
}
