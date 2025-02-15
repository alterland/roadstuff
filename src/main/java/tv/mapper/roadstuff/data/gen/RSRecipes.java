package tv.mapper.roadstuff.data.gen;

import java.util.Arrays;
import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.DyeColor;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import tv.mapper.mapperbase.data.BaseTags;
import tv.mapper.mapperbase.item.BaseItems;
import tv.mapper.roadstuff.block.RSBlockRegistry;
import tv.mapper.roadstuff.data.RSTags;
import tv.mapper.roadstuff.item.RSItemRegistry;

public class RSRecipes extends RecipeProvider
{
    public RSRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        ShapedRecipeBuilder.shapedRecipe(RSBlockRegistry.ASPHALT_SLOPE.get(), 8).patternLine("i ").patternLine(" i").key('i', BaseTags.Items.ASPHALT).addCriterion("has_asphalt",
            hasItem(BaseTags.Items.ASPHALT)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(RSBlockRegistry.CONCRETE_SLOPE.get(), 8).patternLine("i ").patternLine(" i").key('i', BaseTags.Items.CONCRETE).addCriterion("has_concrete",
            hasItem(BaseTags.Items.CONCRETE)).build(consumer);

        for(int i = 0; i < Arrays.stream(DyeColor.values()).count(); i++)
        {
            ShapedRecipeBuilder.shapedRecipe(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.byId(i)).get()).patternLine(" D ").patternLine("D D").patternLine("BBB").key('B', BaseTags.ForgeItems.BITUMEN).key(
                'D', DyeColor.byId(i).getTag()).addCriterion("has_bitumen", hasItem(BaseTags.ForgeItems.BITUMEN)).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(DyeColor.byId(i)).get()).patternLine("DDD").patternLine("D D").patternLine("BBB").key('B',
                BaseTags.ForgeItems.BITUMEN).key('D', DyeColor.byId(i).getTag()).addCriterion("has_bitumen", hasItem(BaseTags.ForgeItems.BITUMEN)).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get()).patternLine(" D ").patternLine(" D ").patternLine("BBB").key('B',
                BaseTags.ForgeItems.BITUMEN).key('D', DyeColor.byId(i).getTag()).addCriterion("has_bitumen", hasItem(BaseTags.ForgeItems.BITUMEN)).build(consumer);

            ShapedRecipeBuilder.shapedRecipe(RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get()).patternLine("D").patternLine("R").patternLine("D").key('R', RSTags.Items.REFLECTORS).key('D',
                DyeColor.byId(i).getTag()).addCriterion("has_reflector", hasItem(RSTags.Items.REFLECTORS)).build(consumer);

            ShapedRecipeBuilder.shapedRecipe(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get()).patternLine("D").patternLine("G").patternLine("B").key('G', Tags.Items.DUSTS_GLOWSTONE).key('B',
                BaseItems.ASPHALT_ITEM.get()).key('D', DyeColor.byId(i).getTag()).addCriterion("has_reflector", hasItem(RSTags.Items.REFLECTORS)).build(consumer);
            ShapelessRecipeBuilder.shapelessRecipe(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get()).addIngredient(
                RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get()).addIngredient(Tags.Items.DUSTS_GLOWSTONE).addCriterion("has_" + DyeColor.byId(i).getString() + "_reflector",
                    hasItem(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get())).build(consumer);

            ShapelessRecipeBuilder.shapelessRecipe(RSBlockRegistry.GUARDRAIL_BLOCKS.get(DyeColor.byId(i)).get()).addIngredient(RSBlockRegistry.STEEL_GUARDRAIL.get()).addIngredient(
                DyeColor.byId(i).getTag()).addCriterion("has_steel_reflector", hasItem(RSBlockRegistry.STEEL_GUARDRAIL.get())).build(consumer);
        }

        ShapedRecipeBuilder.shapedRecipe(RSBlockRegistry.STEEL_GUARDRAIL.get(), 8).patternLine("PPP").patternLine(" R ").key('P', BaseTags.ForgeItems.PLATES_STEEL).key('R',
            BaseTags.ForgeItems.RODS_STEEL).addCriterion("has_steel_plate", hasItem(BaseTags.ForgeItems.PLATES_STEEL)).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(RSBlockRegistry.RED_BOLLARD.get()).patternLine("R").patternLine("S").patternLine("S").key('S', Tags.Items.RODS_WOODEN).key('R',
            RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.RED).get()).addCriterion("has_stick", hasItem(Tags.Items.RODS_WOODEN)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(RSBlockRegistry.WHITE_BOLLARD.get()).patternLine("R").patternLine("S").patternLine("S").key('S', Tags.Items.RODS_WOODEN).key('R',
            RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.WHITE).get()).addCriterion("has_stick", hasItem(Tags.Items.RODS_WOODEN)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(RSBlockRegistry.YELLOW_BOLLARD.get()).patternLine("R").patternLine("S").patternLine("S").key('S', Tags.Items.RODS_WOODEN).key('R',
            RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.YELLOW).get()).addCriterion("has_stick", hasItem(Tags.Items.RODS_WOODEN)).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(RSBlockRegistry.RED_SMALL_BOLLARD.get()).patternLine("R").patternLine("S").key('S', Tags.Items.RODS_WOODEN).key('R',
            RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.RED).get()).addCriterion("has_stick", hasItem(Tags.Items.RODS_WOODEN)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(RSBlockRegistry.WHITE_SMALL_BOLLARD.get()).patternLine("R").patternLine("S").key('S', Tags.Items.RODS_WOODEN).key('R',
            RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.WHITE).get()).addCriterion("has_stick", hasItem(Tags.Items.RODS_WOODEN)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(RSBlockRegistry.YELLOW_SMALL_BOLLARD.get()).patternLine("R").patternLine("S").key('S', Tags.Items.RODS_WOODEN).key('R',
            RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.YELLOW).get()).addCriterion("has_stick", hasItem(Tags.Items.RODS_WOODEN)).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(RSBlockRegistry.PAINT_BUCKET.get()).patternLine("I I").patternLine("I I").patternLine(" I ").key('I', Tags.Items.INGOTS_IRON).addCriterion("has_iron_ingot",
            hasItem(Tags.Items.INGOTS_IRON)).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(RSItemRegistry.PAINT_BRUSH.get()).patternLine(" W").patternLine("S ").key('W', ItemTags.WOOL).key('S', Tags.Items.RODS_WOODEN).addCriterion("has_wool",
            hasItem(ItemTags.WOOL)).build(consumer);

        for(int j = 1; j < Arrays.stream(DyeColor.values()).count(); j++)
        {
            ShapelessRecipeBuilder.shapelessRecipe(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.byId(j)).get()).addIngredient(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.WHITE).get()).addIngredient(
                DyeColor.byId(j).getTag()).addCriterion("has_white_traffic_cone", hasItem(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.WHITE).get())).build(consumer,
                    DyeColor.byId(j).getString() + "_traffic_cone_from_white");
            ShapelessRecipeBuilder.shapelessRecipe(RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(DyeColor.byId(j)).get()).addIngredient(
                RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(DyeColor.WHITE).get()).addIngredient(DyeColor.byId(j).getTag()).addCriterion("has_white_traffic_barrel",
                    hasItem(RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(DyeColor.WHITE).get())).build(consumer, DyeColor.byId(j).getString() + "_traffic_barrel_from_white");
            ShapelessRecipeBuilder.shapelessRecipe(RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(DyeColor.byId(j)).get()).addIngredient(
                RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(DyeColor.WHITE).get()).addIngredient(DyeColor.byId(j).getTag()).addCriterion("has_white_traffic_bollard",
                    hasItem(RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(DyeColor.WHITE).get())).build(consumer, DyeColor.byId(j).getString() + "_traffic_bollard_from_white");
            ShapelessRecipeBuilder.shapelessRecipe(RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(DyeColor.byId(j)).get()).addIngredient(
                RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(DyeColor.WHITE).get()).addIngredient(DyeColor.byId(j).getTag()).addCriterion("has_white_cylindrical_bollard",
                    hasItem(RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(DyeColor.WHITE).get())).build(consumer, DyeColor.byId(j).getString() + "_cylindrical_bollard_from_white");
            ShapelessRecipeBuilder.shapelessRecipe(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.byId(j)).get()).addIngredient(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.WHITE).get()).addIngredient(
                DyeColor.byId(j).getTag()).addCriterion("has_white_reflector", hasItem(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.WHITE).get())).build(consumer,
                    DyeColor.byId(j).getString() + "_reflector_from_white");
            ShapelessRecipeBuilder.shapelessRecipe(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.byId(j)).get()).addIngredient(
                RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.WHITE).get()).addIngredient(DyeColor.byId(j).getTag()).addCriterion("has_white_luminescent_reflector",
                    hasItem(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.WHITE).get())).build(consumer, DyeColor.byId(j).getString() + "_luminescent_reflector_from_white");
            ShapelessRecipeBuilder.shapelessRecipe(RSBlockRegistry.GUARDRAIL_BLOCKS.get(DyeColor.byId(j)).get()).addIngredient(RSBlockRegistry.GUARDRAIL_BLOCKS.get(DyeColor.WHITE).get()).addIngredient(
                DyeColor.byId(j).getTag()).addCriterion("has_white_guardrail", hasItem(RSBlockRegistry.GUARDRAIL_BLOCKS.get(DyeColor.WHITE).get())).build(consumer,
                    DyeColor.byId(j).getString() + "_guardrail_from_white");
        }
    }
}