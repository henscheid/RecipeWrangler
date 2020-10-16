import java.util.ArrayList;
import java.util.Scanner;

///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Main Class File:  RecipeWrangler.java
//File:             RecipeBox.java
//Semester:         CS302 Fall 2015
//
//Author:           Ian Henscheid henscheid@wisc.edu
//CS Login:         henscheid
//Lecturer's Name:  Jim Williams
//Lab Section:      341

public class RecipeBox {
	
	//holds a list of recipes in recipeBox
	ArrayList<Recipe> recipeList;
	
	public RecipeBox() {
		recipeList = new ArrayList<Recipe>();
		
	}
	
	/**
	 * adds the recipe passed in to recipeList and 
	 * sorts recipeList lexigraphically
	 * 
	 * @param a (recipe to be added)
	 */
	public void add(Recipe a) {
		recipeList.add(a);
		recipeList.sort(null);
	}
	
	/**
	 * If recipeList has no recipes then return "No recipes"
	 * otherwise prints out all recipe names
	 * 
	 */
	public void printRecipeList() {
		
		if (recipeList.size() == 0) {
			System.out.println("No recipes");
		} else {
		//for each recipe in recipeBox
			for (int i = 0; i < recipeList.size(); i++) {
			
				//print out the name of the recipe
				System.out.println(recipeList.get(i).getName());
			}
		}
	}
	
	/**
	 * 
	 * @param index
	 * @return recipe at specified index
	 */
	public Recipe getRecipe(int index) {
		Recipe recipe;
		recipe = recipeList.get(index);
		
		return recipe;
	}
	
	/**
	 * Prints out the recipe name, ingredients and instructions
	 * of recipe r
	 * 
	 * @param r (recipe to be printed out)
	 */
	public void printRecipe(Recipe r) {
		System.out.println("Recipe name: " + r.getName()
				+ "\nIngredients: " + r.getIngredients()
				+ "\nInstructions: "+ r.getInstructions());
	}
	
	/**
	 * sets the recipe (recipe) to index (a) in recipeList
	 * 
	 * @param a (recipe index)
	 * @param recipe (recipe to be set)
	 */
	public void set(int a, Recipe recipe) {
		recipeList.set(a, recipe);
	}
	
	/**
	 * Sorts recipeList alphabetically
	 * 
	 */
	public void sort() {
		
		//starting at the first recipe in the recipeBox 
		//for every recipe in the recipeBox check if the
		//recipe name has a greater lexigraphical value than 
		//the last.
		for (int i = 0; i < this.recipeListSize() - 1; i++) {
			Recipe first = this.getRecipe(i);
			Recipe second = this.getRecipe(i + 1);
			
			//if the lexigraphical value of the first value is
			//greater than the lexigraphical value of the second
			//then switch the recipes in the recipeBox
			if (first.compareTo(second) > 0) {
				Recipe s = first;
				this.set(i, second);
				this.set(i + 1, s);
			}
		}
		
		//starting at the last recipe in the recipeBox 
		//for every recipe in the recipeBox check if the
		//recipe name has a lesser lexigraphical value than 
		//the last.
		for (int i = this.recipeListSize() - 1; i >= 1; i--) {
			Recipe last = this.getRecipe(i);
			Recipe next = this.getRecipe(i - 1);
			
			//if the lexigraphical value of last is
			//less than the lexigraphical value of next
			//then switch the recipes in the recipeBox
			if (last.compareTo(next) < 0) {
				this.set(i, next);
				this.set(i - 1, last);
				
			}
		}
	}
	
	/**
	 * 
	 * @return number of recipes in recipeBox
	 */
	public int recipeListSize() {
		
		return recipeList.size();
	}
	
	
//	public ArrayList<Recipe> getRecipeBox(){
//		return recipeList;
//	}

}
