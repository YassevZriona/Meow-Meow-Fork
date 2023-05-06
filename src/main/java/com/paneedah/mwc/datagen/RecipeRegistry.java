package com.paneedah.mwc.datagen;
import com.paneedah.mwc.ModernWarfare;
import com.paneedah.mwc.things.ModRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class RecipeRegistry extends RecipeProvider implements IConditionBuilder {
    public RecipeRegistry(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModRegistry.RAW_ALUMINUM.get()), RecipeCategory.MISC, ModRegistry.ALUMINUM_INGOT.get(), 0.7f, 200)
                .group("aluminum").unlockedBy(getHasName(ModRegistry.RAW_ALUMINUM.get()), has(ModRegistry.RAW_ALUMINUM.get())).save(consumer, new ResourceLocation(ModernWarfare.MODID, getItemName(ModRegistry.ALUMINUM_INGOT.get())) + "_from_smelting_" + getItemName(ModRegistry.RAW_ALUMINUM.get()));
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
}
