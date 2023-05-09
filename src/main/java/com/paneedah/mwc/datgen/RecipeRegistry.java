package com.paneedah.mwc.datgen;
import com.paneedah.mwc.ModernWarfare;
import com.paneedah.mwc.client.ModRegistry;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class RecipeRegistry extends RecipeProvider implements IConditionBuilder {
    public RecipeRegistry(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, List.of(ModRegistry.RAW_ALUMINUM.get()), RecipeCategory.MISC,
                ModRegistry.ALUMINUM_INGOT.get(), 0.6f, 200, "aluminum");
        oreBlasting(consumer, List.of(ModRegistry.RAW_ALUMINUM.get()), RecipeCategory.MISC,
                ModRegistry.ALUMINUM_INGOT.get(), 0.6f, 150, "aluminum");
        oreSmelting(consumer, List.of(ModRegistry.RAW_LEAD.get()), RecipeCategory.MISC,
                ModRegistry.LEAD_INGOT.get(), 0.7f, 200, "lead");
        oreBlasting(consumer, List.of(ModRegistry.RAW_LEAD.get()), RecipeCategory.MISC,
                ModRegistry.LEAD_INGOT.get(), 0.7f, 150, "lead");
        oreSmelting(consumer, List.of(ModRegistry.RAW_TITANIUM.get()), RecipeCategory.MISC,
                ModRegistry.TITANIUM_INGOT.get(), 0.8f, 200, "titanium");
        oreBlasting(consumer, List.of(ModRegistry.RAW_TITANIUM.get()), RecipeCategory.MISC,
                ModRegistry.TITANIUM_INGOT.get(), 0.8f, 150, "titanium");
        oreSmelting(consumer, List.of(ModRegistry.RAW_TUNGSTEN.get()), RecipeCategory.MISC,
                ModRegistry.TUNGSTEN_INGOT.get(), 0.9f, 200, "tungsten");
        oreBlasting(consumer, List.of(ModRegistry.RAW_TUNGSTEN.get()), RecipeCategory.MISC,
                ModRegistry.TUNGSTEN_INGOT.get(), 0.9f, 150, "tungsten");
        oreSmelting(consumer, List.of(ModRegistry.SULFUR.get()), RecipeCategory.MISC,
                Items.GUNPOWDER, 1.0f, 110, "sulfur");
        oreBlasting(consumer, List.of(ModRegistry.SULFUR.get()), RecipeCategory.MISC,
                Items.GUNPOWDER, 1.0f, 10, "sulfur");

         ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModRegistry.STIMPAK.get())
                 .define('A', ModRegistry.EMPTY_SYRINGE.get())
                 .define('B', Items.NETHER_WART)
                 .pattern(" B ")
                 .pattern("BAB")
                 .pattern(" B ")
                 .unlockedBy("has_empty_syringe", inventoryTrigger(ItemPredicate.Builder.item()
                         .of(ModRegistry.EMPTY_SYRINGE.get()).build()))
                 .save(consumer);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> consumer, List<ItemLike> input, RecipeCategory recipeCategory, ItemLike output, float experience, int time, String category) {
        oreCooking(consumer, RecipeSerializer.SMELTING_RECIPE, input, recipeCategory, output, experience, time, category, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> consumer, List<ItemLike> input, RecipeCategory recipeCategory, ItemLike output, float experience, int time, String category) {
        oreCooking(consumer, RecipeSerializer.BLASTING_RECIPE, input, recipeCategory, output, experience, time, category, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> p_250791_, RecipeSerializer<? extends AbstractCookingRecipe> p_251817_, List<ItemLike> p_249619_, RecipeCategory p_251154_, ItemLike p_250066_, float p_251871_, int p_251316_, String p_251450_, String p_249236_) {
        for(ItemLike itemlike : p_249619_) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), p_251154_, p_250066_, p_251871_, p_251316_, p_251817_).group(p_251450_)
                    .unlockedBy(getHasName(itemlike), has(itemlike)).save(p_250791_, new ResourceLocation(ModernWarfare.MODID, getItemName(p_250066_)) + p_249236_ + "_" + getItemName(itemlike));
        }
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_249580_, RecipeCategory p_251203_, ItemLike p_251689_, RecipeCategory p_251376_, ItemLike p_248771_) {
        nineBlockStorageRecipes(p_249580_, p_251203_, p_251689_, p_251376_, p_248771_, getSimpleRecipeName(p_248771_), (String)null, getSimpleRecipeName(p_251689_), (String)null);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_250423_, RecipeCategory p_250083_, ItemLike p_250042_,
                                                  RecipeCategory p_248977_, ItemLike p_251911_, String p_250475_, @Nullable String p_248641_,
                                                  String p_252237_, @Nullable String p_250414_) {
        ShapelessRecipeBuilder.shapeless(p_250083_, p_250042_, 9).requires(p_251911_).group(p_250414_).unlockedBy(getHasName(p_251911_), has(p_251911_))
                .save(p_250423_, new ResourceLocation(ModernWarfare.MODID, p_252237_));
        ShapedRecipeBuilder.shaped(p_248977_, p_251911_).define('#', p_250042_).pattern("###").pattern("###").pattern("###").group(p_248641_)
                .unlockedBy(getHasName(p_250042_), has(p_250042_)).save(p_250423_, new ResourceLocation(ModernWarfare.MODID, p_250475_));
    }
}
