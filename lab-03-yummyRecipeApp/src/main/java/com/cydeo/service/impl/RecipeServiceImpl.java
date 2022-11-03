package com.cydeo.service.impl;

import com.cydeo.config.AuthorConfig;
import com.cydeo.enums.QuantityType;
import com.cydeo.enums.RecipeType;
import com.cydeo.model.Ingredient;
import com.cydeo.model.Recipe;
import com.cydeo.repository.RecipeRepository;
import com.cydeo.service.RecipeService;
import com.cydeo.service.ShareService;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.*;

@Getter
@Setter

@Component
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final ShareService shareService;

    private final Faker faker;





    @Override
    public boolean prepareRecipe() {

        /*
        Faker faker= new Faker(); // to generate data and to test the program

        List<Ingredients> ingredientsList= new ArrayList<>();

        int i=0;
        while(i<8){
            Ingredients ingredients= new Ingredients();

            ingredients.setName(faker.food().ingredient());
            ingredients.setQuantiy(faker.number().randomDigit());
            ingredients.setQuantityType(QuantityType.getQuantityType(faker.number().numberBetween(1,3)));
            ingredientsList.add(ingredients);

            i++;}

        recipe.setIngredientsList(ingredientsList);
        recipeRepository.save(recipe);
        shareService.share(recipe);

        printConfigData();

        recipeRepository.save(recipe);
        shareService.share(recipe);
        return true;


         */

        for (int i = 0; i < 20 ; i++) { // 7  * 20 = 140


            Arrays.stream(RecipeType.values()).forEach(recipeType -> {

                Recipe recipe = new Recipe();
                recipe.setId(UUID.randomUUID());
                recipe.setName(faker.food().dish());
                recipe.setDuration(generateRandomValue());
                recipe.setPreparation(faker.lorem().paragraph(generateRandomValue()));
                recipe.setIngredients(prepareIngredient());
                recipe.setRecipeType(recipeType);
                recipeRepository.save(recipe);
                shareService.share(recipe);

            });

        }

        return true;

    }

    private List<Ingredient> prepareIngredient() {

        List<QuantityType>  quantityTypeList = List.of(QuantityType.values());

        List<Ingredient> ingredientList = new ArrayList<>();

        for (int i = 0; i < generateRandomValue() ; i++) {

            Ingredient ingredient = new Ingredient();

            ingredient.setName(faker.food().ingredient());
            ingredient.setQuantity(generateRandomValue());
            ingredient.setQuantityType(quantityTypeList.get(new Random().nextInt(3)));
            ingredientList.add(ingredient);
        }

        return ingredientList;
    }



    private int generateRandomValue(){
        return new Random().nextInt(20);
    }


}

