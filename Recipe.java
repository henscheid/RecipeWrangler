///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Main Class File:  RecipeWrangler.java
//File:             Recipe.java
//Semester:         CS302 Fall 2015
//
//Author:           Ian Henscheid henscheid@wisc.edu
//CS Login:         henscheid
//Lecturer's Name:  Jim Williams
//Lab Section:      341

public class Recipe implements Comparable<Recipe> {
	
	//this recipe's name
	private String name;
	
	//this recipe's ingredients
	private String ingredients;
	
	//this recipe's instructions
	private String instructions;
	
	/**
	 * Constructor: requires 3 strings
	 * @param a (name of recipe)
	 * @param b (recipe ingredients)
	 * @param c (recipe instructions)
	 */
	public Recipe(String a, String b, String c) {
		this.name = a;
		this.ingredients = b;
		this.instructions = c;
		name.toUpperCase();
	}
	
	/**
	 * returns specified recipe name
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * returns the ingredients for the specified recipe
	 * @return
	 */
	public String getIngredients() {
		return ingredients;
	}
	
	/**
	 * returns the instructions for the specified recipe
	 * @param instructions
	 */
	public String getInstructions() {
		return instructions;
	}
	
	/**
	 * sets the ingredients for the specified recipe 
	 * to the ingredients passed in
	 * 
	 * @param ingredients
	 */
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	
	/**
	 * sets the instructions for the specified recipe
	 * to the ingredients passed in
	 * 
	 * @param instructions
	 */
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	
	@Override
	/**
	This method returns -1 if the name of "this" recipe
	is lexigraphically less than the name of otherRecipe
	
	returns +1 if the name of "this" recipe is lexigraphically 
	more than the name of otherRecipe
	
	returns 0 if the names are lexigraphically the same
	*/
	
	public int compareTo(Recipe otherRecipe) {
		String firstName = this.getName();
		String otherName = otherRecipe.getName();
		
		
		// TODO Auto-generated method stub
		return firstName.compareTo(otherName);
	}

}
