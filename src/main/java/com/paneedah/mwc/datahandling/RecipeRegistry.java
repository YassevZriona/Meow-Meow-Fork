package com.paneedah.mwc.datahandling;
import com.paneedah.mwc.ModernWarfare;
import com.paneedah.mwc.content.ModRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

public class RecipeRegistry extends RecipeProvider implements IConditionBuilder {
    public RecipeRegistry(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        furnaceGeneric(consumer, ModRegistry.RAW_ALUMINUM, ModRegistry.ALUMINUM_INGOT, 0.6f, 200, "aluminum");
        furnaceGeneric(consumer, ModRegistry.RAW_LEAD, ModRegistry.LEAD_INGOT, 0.7f, 200, "lead");
        furnaceBlasting(consumer, ModRegistry.RAW_TITANIUM, ModRegistry.TITANIUM_INGOT, 0.8f, 400, "titanium");
        furnaceBlasting(consumer, ModRegistry.RAW_TUNGSTEN, ModRegistry.TUNGSTEN_INGOT, 1.2f, 600, "tungsten");
        // ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_OPAL.get())
        //         .requires(ModBlocks.BLACK_OPAL_BLOCK.get())
        //         .unlockedBy("has_black_opal_block", inventoryTrigger(ItemPredicate.Builder.item()
        //                 .of(ModBlocks.BLACK_OPAL_BLOCK.get()).build()))
        //         .save(consumer);

        // ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_OPAL_BLOCK.get())
        //         .define('B', ModItems.BLACK_OPAL.get())
        //         .pattern("BBB")
        //         .pattern("BBB")
        //         .pattern("BBB")
        //         .unlockedBy("has_black_opal", inventoryTrigger(ItemPredicate.Builder.item()
        //                 .of(ModItems.BLACK_OPAL.get()).build()))
        //         .save(consumer);
    }

    private void furnaceGeneric(Consumer<FinishedRecipe> consumer, RegistryObject<Item> input, RegistryObject<Item> output, Float exp, int time, String group) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(input.get()), RecipeCategory.MISC, output.get(), exp, 200, RecipeSerializer.SMELTING_RECIPE)
                .group(group).unlockedBy(getHasName(input.get()), has(input.get())).save(consumer, new ResourceLocation(ModernWarfare.MODID, getItemName(output.get())) + "_from_smelting_" + getItemName(input.get()));
    }

    private void furnaceBlasting(Consumer<FinishedRecipe> consumer, RegistryObject<Item> input, RegistryObject<Item> output, Float exp, int time, String group) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(input.get()), RecipeCategory.MISC, output.get(), exp, time)
                .group(group).unlockedBy(getHasName(input.get()), has(input.get())).save(consumer, new ResourceLocation(ModernWarfare.MODID, getItemName(output.get())) + "_from_smelting_" + getItemName(input.get()));
    }
}
